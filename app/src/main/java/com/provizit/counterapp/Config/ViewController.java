package com.provizit.counterapp.Config;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;

import androidx.core.content.ContextCompat;

import com.provizit.counterapp.R;

public class ViewController {


    private static ProgressDialog dialog;

    public static void barPrimaryColorWhite(Activity activity) {
        Window window = activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(activity, R.color.white));
    }

    public static void barPrimaryColor(Activity activity) {
        Window window = activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(activity, R.color.colorPrimary));
    }


    public static AnimationSet animation() {
        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new DecelerateInterpolator()); //add this
        fadeIn.setDuration(100);
        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator()); //and this
        fadeOut.setStartOffset(100);
        fadeOut.setDuration(100);
        AnimationSet animation = new AnimationSet(false); //change to false
        animation.addAnimation(fadeIn);
//        animation.addAnimation(fadeOut);
        return animation;
    }

    public static void ShowProgressBar(Activity activity){

        //        dialog  = new Dialog(activity);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
//        dialog.setCancelable(false);
//        dialog.setContentView(R.layout.custom_progress_loader);
//        dialog.show();

        if (dialog == null || !dialog.isShowing()) {
            dialog = new ProgressDialog(activity);
            dialog.setMessage("Loading...");
            dialog.setCancelable(false); // Prevent dialog from being canceled by back button
            dialog.setCanceledOnTouchOutside(false); // Prevent dialog from being canceled by touch outside
            dialog.show();
        }
    }
    public static void DismissProgressBar() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }


    public static void clearCache(Context context) {
        try {
            context.getCacheDir().delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
