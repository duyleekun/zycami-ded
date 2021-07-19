/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.net.ConnectivityManager
 */
package cn.leancloud.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import androidx.core.content.ContextCompat;
import cn.leancloud.push.AVConnectivityListener;
import cn.leancloud.utils.LogUtil;

public class AVConnectivityReceiver
extends BroadcastReceiver {
    private boolean connectivityBroken = false;
    private final AVConnectivityListener listener;

    public AVConnectivityReceiver(AVConnectivityListener aVConnectivityListener) {
        this.listener = aVConnectivityListener;
    }

    public boolean isConnectivityBroken() {
        return this.connectivityBroken;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onReceive(Context context, Intent object) {
        object = this.listener;
        if (object == null) return;
        if (context == null) {
            return;
        }
        object = "android.permission.ACCESS_NETWORK_STATE";
        int n10 = ContextCompat.checkSelfPermission(context, (String)object);
        if (n10 != 0) {
            LogUtil.getLogger(AVConnectivityReceiver.class).w("android.Manifest.permission.ACCESS_NETWORK_STATE is not granted.");
            return;
        }
        object = (ConnectivityManager)context.getSystemService("connectivity");
        try {
            int n11;
            object = object.getActiveNetworkInfo();
            int n12 = 1;
            if (object != null && (n11 = object.isConnected()) != 0) {
                n11 = 0;
                this.connectivityBroken = false;
                n11 = object.getType();
                if (n11 == 0) {
                    object = this.listener;
                    object.onMobile(context);
                    return;
                }
                n10 = object.getType();
                if (n10 == n12) {
                    object = this.listener;
                    object.onWifi(context);
                    return;
                }
                object = this.listener;
                object.onOtherConnected(context);
                return;
            }
            object = this.listener;
            object.onNotConnected(context);
            this.connectivityBroken = n12;
            return;
        }
        catch (Exception exception) {
            return;
        }
    }
}

