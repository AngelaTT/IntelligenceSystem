package com.manage.intelligence.http;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * @author: XuChi
 * @version: V1.0
 * @project: xcf_user_new
 * @package: io.cxc.user.http
 * @description: description
 * @date: 2019/8/14
 * @time: 10:58
 */
public class LiveNetworkMonitor {

    private final Context applicationContext;

    public LiveNetworkMonitor(Context context) {
        applicationContext = context;
    }

    public boolean isConnected() {
        ConnectivityManager cm =
                (ConnectivityManager) applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
    }
}
