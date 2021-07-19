/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.AppOpsManager
 *  android.content.Context
 *  android.os.Build$VERSION
 */
package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;

public final class AppOpsManagerCompat {
    public static final int MODE_ALLOWED = 0;
    public static final int MODE_DEFAULT = 3;
    public static final int MODE_ERRORED = 2;
    public static final int MODE_IGNORED = 1;

    private AppOpsManagerCompat() {
    }

    public static int noteOp(Context context, String string2, int n10, String string3) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 19;
        if (n11 >= n12) {
            return ((AppOpsManager)context.getSystemService("appops")).noteOp(string2, n10, string3);
        }
        return 1;
    }

    public static int noteOpNoThrow(Context context, String string2, int n10, String string3) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 19;
        if (n11 >= n12) {
            return ((AppOpsManager)context.getSystemService("appops")).noteOpNoThrow(string2, n10, string3);
        }
        return 1;
    }

    public static int noteProxyOp(Context context, String string2, String string3) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 >= n11) {
            return ((AppOpsManager)context.getSystemService(AppOpsManager.class)).noteProxyOp(string2, string3);
        }
        return 1;
    }

    public static int noteProxyOpNoThrow(Context context, String string2, String string3) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 >= n11) {
            return ((AppOpsManager)context.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(string2, string3);
        }
        return 1;
    }

    public static String permissionToOp(String string2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 >= n11) {
            return AppOpsManager.permissionToOp((String)string2);
        }
        return null;
    }
}

