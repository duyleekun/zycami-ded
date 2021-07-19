/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.ConnectivityManager
 */
package cn.leancloud.network;

import android.content.Context;
import android.net.ConnectivityManager;
import androidx.core.content.ContextCompat;
import cn.leancloud.AVLogger;
import cn.leancloud.network.NetworkingDetector;
import cn.leancloud.network.NetworkingDetector$NetworkType;
import cn.leancloud.utils.LogUtil;

public class AndroidNetworkingDetector
implements NetworkingDetector {
    private static AVLogger LOGGER = LogUtil.getLogger(AndroidNetworkingDetector.class);
    private Context context = null;

    public AndroidNetworkingDetector(Context context) {
        this.context = context;
    }

    public NetworkingDetector$NetworkType getNetworkType() {
        NetworkingDetector$NetworkType networkingDetector$NetworkType = NetworkingDetector$NetworkType.None;
        Object object = this.context;
        String string2 = "android.permission.ACCESS_NETWORK_STATE";
        int n10 = ContextCompat.checkSelfPermission((Context)object, string2);
        if (n10 != 0) {
            object = LOGGER;
            string2 = "android.Manifest.permission.ACCESS_NETWORK_STATE is not granted.";
            ((AVLogger)object).w(string2);
        } else {
            object = this.context;
            string2 = "connectivity";
            if ((object = ((ConnectivityManager)object.getSystemService(string2)).getActiveNetworkInfo()) != null) {
                n10 = object.getType();
                if (n10 != 0) {
                    int n11 = 1;
                    if (n10 == n11) {
                        networkingDetector$NetworkType = NetworkingDetector$NetworkType.WIFI;
                    }
                } else {
                    networkingDetector$NetworkType = NetworkingDetector$NetworkType.Mobile;
                }
            }
        }
        return networkingDetector$NetworkType;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean isConnected() {
        try {
            Object object = this.context;
            String string2 = "android.permission.ACCESS_NETWORK_STATE";
            int n10 = ContextCompat.checkSelfPermission((Context)object, string2);
            if (n10 != 0) {
                object = LOGGER;
                string2 = "android.Manifest.permission.ACCESS_NETWORK_STATE is not granted.";
                ((AVLogger)object).w(string2);
                return false;
            }
            object = this.context;
            string2 = "connectivity";
            object = object.getSystemService(string2);
            object = (ConnectivityManager)object;
            if ((object = object.getActiveNetworkInfo()) == null) return false;
            n10 = (int)(object.isConnected() ? 1 : 0);
            if (n10 == 0) return false;
            return true;
        }
        catch (Exception exception) {
            AVLogger aVLogger = LOGGER;
            String string3 = "failed to detect networking status.";
            aVLogger.w(string3, exception);
        }
        return false;
    }
}

