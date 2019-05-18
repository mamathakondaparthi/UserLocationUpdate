package capture.ivis.com.userlocationupdate.service;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import capture.ivis.com.userlocationupdate.R;


/**
 * Created by user on 2/23/2017.
 */

public class Util {
    private static final String MyPREFERENCES = "MyPrefs";
    private static SharedPreferences sharedpreferences;
   private static MaterialDialog ringProgressDialog = null;



    public static SharedPreferences getSharedpreferences(Context context) {
        if (sharedpreferences == null)
            sharedpreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        return sharedpreferences;
    }

    public static void setString(String key, String value) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String getString(String key) {
        return sharedpreferences.getString(key, "");
    }

    public static void setBitmap(String key, Bitmap value) {



        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(key, String.valueOf(value));
        editor.commit();
    }

    public static void setBoolean(String key, boolean value) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static boolean getBoolean(String key) {
        return sharedpreferences.getBoolean(key, false);
    }

    public static void setInt(String key, int value) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public static int getInt(String key) {
        return sharedpreferences.getInt(key,  0);
    }

    public static void setfloat(String key, float value) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putInt(key, (int) value);
        editor.commit();
    }

    public static float getFloat(String key) {
        return sharedpreferences.getFloat(key, 0);
    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        if (info == null)
        {
            Toast.makeText(context, " No Internet Connection", Toast.LENGTH_SHORT).show();

//            final Dialog dialog = neww Dialog(context);
//            dialog.setContentView(R.layout.custom);
//
//
//            // set the custom dialog components - text, image and button
//            TextView text = (TextView) dialog.findViewById(R.id.ok);
//
//
//
//            TextView dialogButton = (TextView) dialog.findViewById(R.id.cencel);
//            // if button is clicked, close the custom dialog
//            dialogButton.setOnClickListener(neww View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    dialog.dismiss();
//                }
//            });
//
//            dialog.show();


            return false;
        }
        NetworkInfo.State network = info.getState();
        return (network == NetworkInfo.State.CONNECTED || network == NetworkInfo.State.CONNECTING);
    }

    public static boolean showProgressDialog(final Context ctx) {
        if (ringProgressDialog == null) {
            ringProgressDialog = new MaterialDialog.Builder(ctx)
                    .title(ctx.getResources().getString(R.string.app_name))
                    .content("Please wait.... ")
                    .progress(true, 0)
                    .theme(Theme.LIGHT)
                    .cancelable(false)
                    .show();
            ringProgressDialog.setOnShowListener(new DialogInterface.OnShowListener() {
                @Override
                public void onShow(DialogInterface dialog) {
                    ProgressBar v = (ProgressBar) ringProgressDialog.findViewById(android.R.id.progress);
                    v.getIndeterminateDrawable().setColorFilter(ctx.getResources().getColor(R.color.colorAccent),
                            android.graphics.PorterDuff.Mode.MULTIPLY);
                }
            });
        }
        return false;
    }

    public static void dismissDialog() {
        if (ringProgressDialog != null) {
            if (ringProgressDialog.isShowing()) {
                ringProgressDialog.dismiss();
                ringProgressDialog = null;
            }
        }
    }

    public void singelButtonAlertDialog(Context ctx, String title, String message) {
        MaterialDialog.Builder builder = new MaterialDialog.Builder(ctx);
        builder.theme(Theme.LIGHT);
        if (title != null) {
            builder.title(title);
        }
        builder.content(message);

        builder.positiveText("Ok");

        builder.positiveColorRes(R.color.colorPrimary);
        builder.cancelable(false);
        builder.show();

    }

    public void singelButtonAlertDialog(Context ctx, String title, String message, final MaterialDialog.ButtonCallback cb) {
        MaterialDialog.Builder builder = new MaterialDialog.Builder(ctx);
        builder.theme(Theme.LIGHT);
        if (title != null) {
            builder.title(title);
        }
        builder.content(message);

        builder.positiveText("Yes");
        builder.negativeText("No");

        builder.positiveColorRes(R.color.colorPrimary);
        builder.negativeColorRes(R.color.md_edittext_error);
        builder.callback(cb);
        builder.cancelable(false);
        builder.show();

    }


    public void twoButtonAlertDialog(Context ctx, String title, String message, boolean okCancel, final MaterialDialog.ButtonCallback cb) {
        MaterialDialog.Builder builder = new MaterialDialog.Builder(ctx);
        builder.theme(Theme.LIGHT);
        if (title != null) {
            builder.title(title);
        }
        builder.content(message);

        if (okCancel) {
            builder.negativeText(android.R.string.cancel);
            builder.positiveText(android.R.string.ok);
        } else {
            builder.negativeText("No");
            builder.positiveText("Yes");
        }

        builder.positiveColorRes(R.color.colorPrimary);
        builder.negativeColorRes(R.color.md_edittext_error);
        builder.callback(cb);
        builder.cancelable(false);
        builder.show();

    }


    public static ServiceOperations getBaseClassService(Context ctx, String url) {
        return RetroHelper.getAdapter(ctx,url).create(ServiceOperations.class);

    }




//    public void serviceCallFailermsg(RetrofitError call, Context mcontext) {
//        if (call != null) {
//            try {
//                singelButtonAlertDialog(mcontext, mcontext.getResources().getString(R.string.app_name), call.toString());
//            } catch (Exception e) {
//                singelButtonAlertDialog(mcontext, mcontext.getResources().getString(R.string.app_name), mcontext.getString(R.string.timeout));
//            }
//        } else {
//            singelButtonAlertDialog(mcontext, mcontext.getResources().getString(R.string.app_name), mcontext.getString(R.string.networkmessage));
//        }
//    }

    public File convertToFile(Bitmap bitmap, Context ctx) {
        File file = new File(ctx.getCacheDir(), "file" + System.currentTimeMillis()+".jpg" );
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.PNG, 0 /*ignored for PNG*/, bos);
        byte[] bitmapdata = bos.toByteArray();

//write the bytes in file
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            fos.write(bitmapdata);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }


}
