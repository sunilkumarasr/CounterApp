package com.provizit.counterapp.Config;

import android.content.Context;
import android.util.Log;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Scriptable;
import java.io.InputStream;

public class AESUtil {
    Context context;
    InputStream inputStream;
    org.mozilla.javascript.Context rhino;
    Scriptable scope;
    public AESUtil(Context context)
    {
        this.context = context;
    }

    public  void setValues()
    {

        inputStream = context.getResources().openRawResource(
                context.getResources().getIdentifier("aes",
                        "raw", context.getPackageName()));
        String data = convertStreamToString(inputStream);
        Log.d("animesh_data", data);
        rhino = org.mozilla.javascript.Context.enter();

        // Turn off optimization to make Rhino Android compatible

        rhino.setOptimizationLevel(-1);
        scope = rhino.initStandardObjects();
        rhino.evaluateString(scope, data, "JavaScript", 0, null);
    }

    static String convertStreamToString(InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    public String encrypt( String data,String key)
    {

        setValues();
        Object obj = scope.get("encryption", scope);
        if (obj instanceof Function) {
            Function jsFunction = (Function) obj;
            Object[] params = new Object[]{data, key};

            // Call the function with params
            Object jsResult = jsFunction.call(rhino, scope, scope, params);
            // Parse the jsResult object to a String
            return org.mozilla.javascript.Context.toString(jsResult);
        }
        return null;
    }
    public String decrypt(String key ,String data)
    {

        setValues();
        Object obj = scope.get("decryption", scope);
        if (obj instanceof Function) {
            Function jsFunction = (Function) obj;
            Object[] params = new Object[]{data, key};
            // Call the function with params
            Object jsResult = jsFunction.call(rhino, scope, scope, params);
            // Parse the jsResult object to a String
            return org.mozilla.javascript.Context.toString(jsResult);
        }
        return null;
    }
}
