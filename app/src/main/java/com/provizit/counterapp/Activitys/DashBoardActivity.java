package com.provizit.counterapp.Activitys;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationSet;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.provizit.counterapp.Adapters.CounterAdapter;
import com.provizit.counterapp.Config.ViewController;
import com.provizit.counterapp.Config.Preferences;
import com.provizit.counterapp.Models.CompanyData;
import com.provizit.counterapp.Models.Model1;
import com.provizit.counterapp.R;
import com.provizit.counterapp.Services.DataManger;
import com.provizit.counterapp.databinding.ActivityCounterBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

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

        counterList = new ArrayList<>();

        showCustomCounterListDialog();

        runningTime();

    }

    private void runningTime() {
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
        Dialog dialog = new Dialog(this);

        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.custom_counter_list_dailouge, null);
        dialog.setContentView(dialogView);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().getAttributes().windowAnimations = R.style.BottomSheetDialogAnimation;

        // Set dialog to be cancellable when touching outside
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);

        TextView txtNoData = dialogView.findViewById(R.id.txtNoData);
        RecyclerView recyclerView = dialogView.findViewById(R.id.recyclerView);
        getcounters(dialog,recyclerView, txtNoData);


        Window window = dialog.getWindow();
        if (window != null) {
            window.setGravity(Gravity.BOTTOM);
        }

        dialog.show();
    }

    private void getcounters(Dialog dialog, RecyclerView recyclerView, TextView txtNoData) {

        DataManger dataManager = DataManger.getDataManager();
        dataManager.getcounters(new Callback<Model1>() {
            @SuppressLint("SuspiciousIndentation")
            @Override
            public void onResponse(Call<Model1> call, Response<Model1> response) {
                final Model1 model = response.body();
                if (model != null) {
                    Integer statuscode = model.getResult();
                    Integer successcode = 200;
                    Integer failurecode = 201;
                    Integer not_verified = 404;
                    if (statuscode.equals(failurecode)) {

                    } else if (statuscode.equals(not_verified)) {

                    } else if (statuscode.equals(successcode)) {

                        counterList.addAll(model.getItems());
                        if (counterList != null && !counterList.isEmpty()){
                            recyclerView.setLayoutManager(new LinearLayoutManager(DashBoardActivity.this));
                            CounterAdapter counterAdapter = new CounterAdapter(DashBoardActivity.this, counterList, new CounterAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(CompanyData counterItem) {
                                    Toast.makeText(DashBoardActivity.this, "Clicked on: " + counterItem.getName(), Toast.LENGTH_SHORT).show();

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

            }
        },DashBoardActivity.this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Remove the callbacks when the activity is destroyed to avoid memory leaks
        handler.removeCallbacks(timeRunnable);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        back_popup();
    }
    private void back_popup() {
        final Dialog dialog = new Dialog(DashBoardActivity.this);
        dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
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