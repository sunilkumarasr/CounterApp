package com.provizit.counterapp.Logins;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.provizit.counterapp.Activitys.CounterActivity;
import com.provizit.counterapp.Activitys.PrivacyPolicyActivity;
import com.provizit.counterapp.Activitys.SplashScreenActivity;
import com.provizit.counterapp.Config.ViewController;
import com.provizit.counterapp.Models.CompanyData;
import com.provizit.counterapp.Models.Model;
import com.provizit.counterapp.R;
import com.provizit.counterapp.Services.DataManger;
import com.provizit.counterapp.Config.AESUtil;
import com.provizit.counterapp.Config.Preferences;
import com.provizit.counterapp.databinding.ActivityLoginBinding;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    AESUtil aesUtil;
    String pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewController.barPrimaryColorWhite(LoginActivity.this);

        aesUtil = new AESUtil(LoginActivity.this);

        inits();

    }

    private void inits() {

        binding.checkbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                binding.checkbox.setChecked(binding.checkbox.isChecked());
            }else {
                binding.checkbox.setChecked(false);
            }
        });
        binding.linearPrivacy.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), PrivacyPolicyActivity.class);
            startActivity(i);
        });

        binding.editPassword.setOnFocusChangeListener((v, hasFocus) -> {
            if (binding.editEmail.getText().toString().equals("")) {
                binding.editEmail.setError("Required");
                binding.editEmail.requestFocus();
            }
        });

        binding.login.setOnClickListener(v -> {
            if (binding.editEmail.getText().toString().equals("")) {
                Toast.makeText(getApplicationContext(),"Enter Email",Toast.LENGTH_SHORT).show();
            } else if (binding.editPassword.getText().toString().equals("")) {
                Toast.makeText(getApplicationContext(),"Enter Password",Toast.LENGTH_SHORT).show();
            } else {
                if (binding.checkbox.isChecked()){
                    JsonObject gsonObject = new JsonObject();
                    JSONObject jsonObj_ = new JSONObject();
                    try {
                        jsonObj_.put("val", binding.editEmail.getText().toString().trim().toLowerCase());
                        jsonObj_.put("type", "email");
                        pwd = aesUtil.encrypt(binding.editPassword.getText().toString().trim(),binding.editEmail.getText().toString().trim().toLowerCase());
                        jsonObj_.put("password",pwd );
                        JsonParser jsonParser = new JsonParser();
                        gsonObject = (JsonObject) jsonParser.parse(jsonObj_.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    Log.e("Password",aesUtil.decrypt(binding.editEmail.getText().toString().trim(),pwd));
                    userLogin(gsonObject);
                }else {
                    Toast.makeText(getApplicationContext(),"Please Agree & Continue",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void userLogin(JsonObject jsonObject) {
        DataManger dataManager = DataManger.getDataManager();
        dataManager.userLogin(new Callback<Model>() {
            @SuppressLint("SuspiciousIndentation")
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                final Model model = response.body();
                if (model != null) {
                    Integer statuscode = model.getResult();
                    Integer successcode = 200;
                    Integer failurecode = 201;
                    Integer not_verified = 404;
                    if (statuscode.equals(failurecode)) {
                        new AlertDialog.Builder(LoginActivity.this)
//                                    .setTitle("ACCESS DENIED")
                                .setMessage( "Presently, this app is accessible by only the enterprise users of PROVIZIT.\n" +
                                        "\n" +
                                        "We couldn’t find you as an enterprise user.\n" +
                                        "\n" +
                                        "You may contact your organization or write to info@provizit.com for more information." )
                                .setPositiveButton(android.R.string.ok, null)
                                .show();
                    } else if (statuscode.equals(not_verified)) {
//                        progressBar.setVisibility(View.GONE);
                        new AlertDialog.Builder(LoginActivity.this)
//                                    .setTitle("ACCESS DENIED")
                                .setMessage( "Invalid Password" )
                                .setPositiveButton(android.R.string.ok, null)
                                .show();
                    } else if (statuscode.equals(successcode)) {
                        CompanyData items = new CompanyData();
                        items = model.getItems();

                        Preferences.saveStringValue(getApplicationContext(), Preferences.comp_id, items.getComp_id());
                        Preferences.saveStringValue(getApplicationContext(), Preferences.email, binding.editEmail.getText().toString().trim().toLowerCase());

                        Intent intent = new Intent(LoginActivity.this, CounterActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        overridePendingTransition(R.anim.enter, R.anim.exit);
                    }
                }
            }
            @Override
            public void onFailure(Call<Model> call, Throwable t) {

            }
        },LoginActivity.this, jsonObject);
    }

}