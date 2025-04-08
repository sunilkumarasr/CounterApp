package com.provizit.counterapp.Activity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationSet;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.provizit.counterapp.Adapters.CounterAdapter;
import com.provizit.counterapp.Config.ViewController;
import com.provizit.counterapp.Config.Preferences;
import com.provizit.counterapp.Logins.LoginActivity;
import com.provizit.counterapp.Models.CompanyData;
import com.provizit.counterapp.Models.CounterSlotDetailsModel;
import com.provizit.counterapp.Models.Model;
import com.provizit.counterapp.Models.Model1;
import com.provizit.counterapp.R;
import com.provizit.counterapp.Services.DataManger;
import com.provizit.counterapp.databinding.ActivityCounterBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashBoardActivity extends AppCompatActivity {

    ActivityCounterBinding binding;

    ArrayList<CompanyData> counterList;

    private boolean isMainActivityShown = true;

    //time
    private Handler handler;
    private Runnable timeRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCounterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewController.barPrimaryColor(DashBoardActivity.this);
        Preferences.saveStringValue(getApplicationContext(), Preferences.LOGINCHECK, "true");

        inits();



    }

    private void inits() {
        //Company Logo
        String comp_id = Preferences.loadStringValue(DashBoardActivity.this, Preferences.comp_id, "");
        String companyLogo = Preferences.loadStringValue(DashBoardActivity.this, Preferences.companyLogo, "");
        Log.e("companyLogo_",DataManger.IMAGE_URL + "/uploads/" + comp_id + "/" + companyLogo);
        Glide.with(DashBoardActivity.this).load(DataManger.IMAGE_URL + "/uploads/" + comp_id + "/" + companyLogo)
                .into(binding.logo);


        counterList = new ArrayList<>();
        showCustomCounterListDialog();

        runningTimeShow();

        reloadCounterSlotDetails();

        binding.linearCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnimationSet animationp = ViewController.animation();
                view.startAnimation(animationp);
                showCustomCounterListDialog();
            }
        });

        binding.logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnimationSet animation = ViewController.animation();
                view.startAnimation(animation);

                final Dialog dialog = new Dialog(DashBoardActivity.this);
                dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.logout_popup_dailouge);
                Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

                TextView txtWorning = dialog.findViewById(R.id.txtWorning);
                EditText editPassword = dialog.findViewById(R.id.editPassword);
                TextView txt_yes = dialog.findViewById(R.id.txt_yes);
                TextView txt_no = dialog.findViewById(R.id.txt_no);

                txt_yes.setOnClickListener(v1 -> {
                    AnimationSet animationp = ViewController.animation();
                    v1.startAnimation(animationp);
                    String password = Preferences.loadStringValue(DashBoardActivity.this, Preferences.password, "");

                    if (editPassword.getText().toString().equalsIgnoreCase("")){
                        txtWorning.setVisibility(View.VISIBLE);
                    }else if (!editPassword.getText().toString().equalsIgnoreCase(password)){
                        txtWorning.setVisibility(View.VISIBLE);
                    }else {
                        ViewController.clearCache(DashBoardActivity.this);

                        Intent intent = new Intent(DashBoardActivity.this, LoginActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        Preferences.saveStringValue(getApplicationContext(), "status", "failed");
                        Preferences.deleteSharedPreferences(getApplicationContext());
                        startActivity(intent);
                        finish();

                        dialog.dismiss();
                    }

                });
                txt_no.setOnClickListener(v12 -> {
                    AnimationSet animationp = ViewController.animation();
                    v12.startAnimation(animationp);
                    dialog.dismiss();
                });
                dialog.show();

            }
        });

    }

    private void runningTimeShow() {
        handler = new Handler();
        timeRunnable = new Runnable() {
            @Override
            public void run() {
                // Update the time
                String formattedTime = getCurrentTime();
                binding.txtRunningTime.setText(formattedTime);
                // Update the time
                String formattedDate = getCurrentDate();
                binding.txtRunningDate.setText(formattedDate);
                handler.postDelayed(this, 1000);
            }
        };
        handler.post(timeRunnable);
    }
    private String getCurrentTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm a");
        Date date = new Date(); // Get the current date and time
        return simpleDateFormat.format(date); // Return the formatted time
    }
    private String getCurrentDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy");
        Date date = new Date(); // Get the current date and time
        return simpleDateFormat.format(date); // Return the formatted time
    }

    private void showCustomCounterListDialog() {
        Dialog dialog = new Dialog(DashBoardActivity.this);
        Objects.requireNonNull(dialog.getWindow()).clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.custom_counter_list_dailouge);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        // Set dialog to be cancellable when touching outside
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);

        TextView txtNoData = dialog.findViewById(R.id.txtNoData);
        RecyclerView recyclerView = dialog.findViewById(R.id.recyclerView);
        getcounters(dialog,recyclerView, txtNoData);

    }

    //counter number
    private void getcounters(Dialog dialog, RecyclerView recyclerView, TextView txtNoData) {
        ViewController.ShowProgressBar(DashBoardActivity.this);
        DataManger dataManager = DataManger.getDataManager();
        dataManager.getcounters(new Callback<Model1>() {
            @SuppressLint("SuspiciousIndentation")
            @Override
            public void onResponse(Call<Model1> call, Response<Model1> response) {
                dialog.show();
                ViewController.DismissProgressBar();
                final Model1 model = response.body();
                if (model != null) {
                    Integer statuscode = model.getResult();
                    Integer successcode = 200;
                    Integer failurecode = 201;
                    Integer not_verified = 404;
                    if (statuscode.equals(failurecode)) {

                    } else if (statuscode.equals(not_verified)) {

                    } else if (statuscode.equals(successcode)) {
                        ArrayList<CompanyData> items = new ArrayList<>(model.getItems());
                        counterList.clear();

                        if (!items.isEmpty()){
                            for (CompanyData item : items) {
                                if (item.getActive()){
                                    counterList.add(item);
                                }
                            }
                            recyclerView.setLayoutManager(new LinearLayoutManager(DashBoardActivity.this));
                            CounterAdapter counterAdapter = new CounterAdapter(DashBoardActivity.this, counterList, new CounterAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(CompanyData counterItem) {
                                    binding.txtToken.setText(counterItem.getName());
                                    Preferences.saveStringValue(getApplicationContext(), Preferences.counterId, counterItem.get_id().get$oid());
                                    getcounterslotdetails(counterItem.get_id().get$oid());
                                    dialog.dismiss();
                                }
                            });
                            recyclerView.setAdapter(counterAdapter);
                        }else {
                            recyclerView.setVisibility(View.GONE);
                            txtNoData.setVisibility(View.VISIBLE);
                        }

                    }
                }
            }
            @Override
            public void onFailure(Call<Model1> call, Throwable t) {
                Log.e("getMessage",t.getMessage());
                ViewController.DismissProgressBar();
            }
        },DashBoardActivity.this);
    }

    private void reloadCounterSlotDetails() {
        // Create a ScheduledExecutorService for background tasks
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    String counterId = Preferences.loadStringValue(getApplicationContext(), Preferences.counterId, "");
                    if (!counterId.equalsIgnoreCase("")) {
                        getcounterslotdetails(counterId);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        // Schedule the task to run immediately, and then every 1 minute (60 seconds)
        scheduler.scheduleAtFixedRate(task, 0, 1, TimeUnit.MINUTES);
    }
    private void getcounterslotdetails(String counterId) {

        //date Stamp
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.set(2025, Calendar.APRIL, 8, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        long timestampInSeconds = calendar.getTimeInMillis() / 1000;
        System.out.println("Today's Start Timestamp: " + timestampInSeconds);

        DataManger dataManager = DataManger.getDataManager();
        dataManager.getcounterslotdetails(new Callback<CounterSlotDetailsModel>() {
            @SuppressLint("SuspiciousIndentation")
            @Override
            public void onResponse(Call<CounterSlotDetailsModel> call, Response<CounterSlotDetailsModel> response) {
                final CounterSlotDetailsModel model = response.body();
                if (model != null) {
                    Integer statuscode = model.getResult();
                    Integer successcode = 200;
                    Integer failurecode = 201;
                    Integer not_verified = 404;
                    if (statuscode.equals(failurecode)) {
                        binding.linearCalling.setVisibility(View.INVISIBLE);
                    } else if (statuscode.equals(not_verified)) {
                        binding.linearCalling.setVisibility(View.INVISIBLE);
                    } else if (statuscode.equals(successcode)) {
                        binding.linearCalling.setVisibility(View.VISIBLE);

                        binding.txtName.setText(model.getItems().getUserDetails().getName());

                    }
                }
            }
            @Override
            public void onFailure(Call<CounterSlotDetailsModel> call, Throwable t) {
                Log.e("getMessage",t.getMessage());
                binding.linearCalling.setVisibility(View.INVISIBLE);
            }
        },DashBoardActivity.this, counterId, timestampInSeconds);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Remove the callbacks when the activity is destroyed to avoid memory leaks
        handler.removeCallbacks(timeRunnable);
    }

    @Override
    public void onBackPressed() {
       // super.onBackPressed();
        back_popup();
    }
    private void back_popup() {
        final Dialog dialog = new Dialog(DashBoardActivity.this);
        Objects.requireNonNull(dialog.getWindow()).clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.popup_back_press);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        TextView title = dialog.findViewById(R.id.title);
        TextView title_note = dialog.findViewById(R.id.title_note);
        TextView txt_yes = dialog.findViewById(R.id.txt_yes);
        TextView txt_no = dialog.findViewById(R.id.txt_no);

        title.setText(getResources().getString(R.string.app_name));
        title_note.setText(getResources().getString(R.string.Do_you_want_to_exit_the_application));
        txt_yes.setText(getResources().getString(R.string.Yes));
        txt_no.setText(getResources().getString(R.string.No));

        txt_yes.setOnClickListener(v -> {
            AnimationSet animation = ViewController.animation();
            v.startAnimation(animation);
            if (isMainActivityShown) {
                finishAffinity();
            }
            dialog.dismiss();
        });
        txt_no.setOnClickListener(v -> {
            AnimationSet animationp = ViewController.animation();
            v.startAnimation(animationp);
            dialog.dismiss();
        });
        dialog.show();
    }

}