package capture.ivis.com.userlocationupdate.service;

import android.content.Context;
import android.util.Log;

import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by Lokesh on 27-12-2017.
 */

public class RetroHelper {


    private static Context mContext;
    public static RestAdapter getAdapter(Context ctx, String serverUrl) {
        mContext=ctx;

        final OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setReadTimeout(1, TimeUnit.MINUTES);
        okHttpClient.setConnectTimeout(1, TimeUnit.MINUTES);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(StringConstants.BASE_URL+serverUrl)
                .setLogLevel(RestAdapter.LogLevel.FULL).setLog(new RestAdapter.Log() {
                    @Override
                    public void log(String msg) {
                        Log.d("Retro Helper", msg);
                    }
                })

                .setClient(new OkClient(okHttpClient))
                .build();




        return restAdapter;
    }


}
