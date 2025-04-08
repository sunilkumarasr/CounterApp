package com.provizit.counterapp.Services;

import static android.content.Context.MODE_PRIVATE;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.provizit.counterapp.Config.Preferences;
import com.provizit.counterapp.Models.Model;
import com.provizit.counterapp.Models.Model1;
import com.provizit.counterapp.Models.OutlookModel;
import com.provizit.counterapp.Config.AESUtil;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataManger {

    public static final String ROOT_URL = "https://liveapi.provizit.com/provizit/resources/";

    public static final String IMAGE_URL = "https://provizit.com";

    private static DataManger dataManager;
    private final Retrofit retrofit;
    private final Retrofit retrofit2;

    private static final String BEARER = "Bearer";

    private DataManger() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.connectTimeout(30, TimeUnit.SECONDS);
        httpClient.readTimeout(30, TimeUnit.SECONDS);
        httpClient.writeTimeout(30, TimeUnit.SECONDS);
        httpClient.addInterceptor(logging);
        HttpLoggingInterceptor logging1 = new HttpLoggingInterceptor();
        logging1.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient1 = new OkHttpClient.Builder();
        httpClient1.connectTimeout(5, TimeUnit.MINUTES);
        httpClient1.readTimeout(5, TimeUnit.MINUTES);
        httpClient1.writeTimeout(5, TimeUnit.MINUTES);
        httpClient1.addInterceptor(logging1);
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        retrofit = new Retrofit.Builder().baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient.build())
                .build();

        retrofit2 = new Retrofit.Builder().baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient1.build())
                .build();

    }

    public static DataManger getDataManager() {
        if (dataManager == null) {
            dataManager = new DataManger();
        }
        return dataManager;
    }

    public void getuserDetails(Callback<Model> cb, Context context, String id) {
        API apiService = retrofit.create(API.class);
        String newEncrypt = encrypt(context, false);
        String bearer = BEARER + newEncrypt;
        Call<Model> call = apiService.getuserDetails(bearer, newEncrypt, id);
        call.enqueue(cb);
    }

    public void userLogin(Callback<Model> cb, Context context, JsonObject data) {
        API apiService = retrofit.create(API.class);
        String newEncrypt = encrypt(context, false);
        String bearer = BEARER + newEncrypt;
        Call<Model> call = apiService.getuserLogin(bearer, newEncrypt, data);
        call.enqueue(cb);
    }

    public void getcounters(Callback<Model1> cb, Context context) {
        API apiService = retrofit.create(API.class);
        String newEncrypt = encrypt(context, false);
        String bearer = BEARER + newEncrypt;
        Call<Model1> call = apiService.getcounters(bearer, newEncrypt);
        call.enqueue(cb);
    }

    public void getMeetingRooms(Callback<Model1> cb, Context context, String id, String location) {
        API apiService = retrofit.create(API.class);
        String newEncrypt = encrypt(context, false);
        String bearer = BEARER + newEncrypt;
        Call<Model1> call = apiService.getmeetingrooms(bearer, newEncrypt, id, location);
        call.enqueue(cb);
    }

    public void getworkingdaymrddetails(Callback<Model> cb, Context context, String id) {
        API apiService = retrofit2.create(API.class);
        String newEncrypt = encrypt(context, false);
        String bearer = BEARER + newEncrypt;
        Call<Model> call = apiService.getworkingdaymrddetails(bearer, newEncrypt, id);
        call.enqueue(cb);
    }

    public void getrmslots(Callback<Model1> cb, Context context, String type, String comp_id, Long start, Long end, String rm_id) {
        API apiService = retrofit.create(API.class);
        String newEncrypt = encrypt(context, false);
        String bearer = BEARER + newEncrypt;
        Call<Model1> call = apiService.getrmslots(bearer, newEncrypt, type, comp_id, start, end, rm_id);
        call.enqueue(cb);
    }

    public void getappointments(Callback<OutlookModel> cb, String comp_id, String rm_id, Long start, Long end, String type) {
        API apiService = retrofit.create(API.class);
        Call<OutlookModel> call = apiService.getappointments(comp_id, rm_id, start, end, type);
        call.enqueue(cb);
    }


    public static String encrypt(Context context, Boolean isAdmin) {
        AESUtil aesUtil = new AESUtil(context);
        Calendar calendar = Calendar.getInstance();
        if (isAdmin) {
            return aesUtil.encrypt("admin_" + ((calendar.getTimeInMillis() / 1000) - 60), "egems_2013_grms_2017_provizit_2020");
        } else {
            if (context != null) {
                String comp_id = Preferences.loadStringValue(context, Preferences.comp_id, "");
                Log.e("comp_id_",comp_id);
                return aesUtil.encrypt(comp_id + "_" + ((calendar.getTimeInMillis() / 1000) - 60), "egems_2013_grms_2017_provizit_2020");
            }
            return "";
        }
    }


}