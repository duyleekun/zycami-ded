/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 */
package d.r.a.u;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import d.r.a.u.s;

public final class u {
    public static NetworkInfo a(Context object) {
        String string2 = "connectivity";
        try {
            object = object.getSystemService(string2);
        }
        catch (Exception exception) {
            s.c("NetUtils", exception);
            return null;
        }
        object = (ConnectivityManager)object;
        return object.getActiveNetworkInfo();
    }
}

