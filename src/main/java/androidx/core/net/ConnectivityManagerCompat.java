/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  android.os.Build$VERSION
 */
package androidx.core.net;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;

public final class ConnectivityManagerCompat {
    public static final int RESTRICT_BACKGROUND_STATUS_DISABLED = 1;
    public static final int RESTRICT_BACKGROUND_STATUS_ENABLED = 3;
    public static final int RESTRICT_BACKGROUND_STATUS_WHITELISTED = 2;

    private ConnectivityManagerCompat() {
    }

    public static NetworkInfo getNetworkInfoFromBroadcast(ConnectivityManager connectivityManager, Intent intent) {
        String string2 = "networkInfo";
        if ((intent = (NetworkInfo)intent.getParcelableExtra(string2)) != null) {
            int n10 = intent.getType();
            return connectivityManager.getNetworkInfo(n10);
        }
        return null;
    }

    public static int getRestrictBackgroundStatus(ConnectivityManager connectivityManager) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            return connectivityManager.getRestrictBackgroundStatus();
        }
        return 3;
    }

    public static boolean isActiveNetworkMetered(ConnectivityManager connectivityManager) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            return connectivityManager.isActiveNetworkMetered();
        }
        connectivityManager = connectivityManager.getActiveNetworkInfo();
        n10 = 1;
        if (connectivityManager == null) {
            return n10 != 0;
        }
        int n12 = connectivityManager.getType();
        if (n12 != n10 && n12 != (n11 = 7) && n12 != (n11 = 9)) {
            return n10 != 0;
        }
        return false;
    }
}

