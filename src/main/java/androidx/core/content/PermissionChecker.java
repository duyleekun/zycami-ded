/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Binder
 *  android.os.Process
 */
package androidx.core.content;

import android.content.Context;
import android.os.Binder;
import android.os.Process;
import androidx.core.app.AppOpsManagerCompat;

public final class PermissionChecker {
    public static final int PERMISSION_DENIED = 255;
    public static final int PERMISSION_DENIED_APP_OP = 254;
    public static final int PERMISSION_GRANTED;

    private PermissionChecker() {
    }

    public static int checkCallingOrSelfPermission(Context context, String string2) {
        String string3;
        int n10;
        int n11 = Binder.getCallingPid();
        if (n11 == (n10 = Process.myPid())) {
            string3 = context.getPackageName();
        } else {
            n11 = 0;
            string3 = null;
        }
        n10 = Binder.getCallingPid();
        int n12 = Binder.getCallingUid();
        return PermissionChecker.checkPermission(context, string2, n10, n12, string3);
    }

    public static int checkCallingPermission(Context context, String string2, String string3) {
        int n10;
        int n11 = Binder.getCallingPid();
        if (n11 == (n10 = Process.myPid())) {
            return -1;
        }
        n11 = Binder.getCallingPid();
        n10 = Binder.getCallingUid();
        return PermissionChecker.checkPermission(context, string2, n11, n10, string3);
    }

    public static int checkPermission(Context context, String string2, int n10, int n11, String string3) {
        int n12;
        int n13;
        if ((n10 = context.checkPermission(string2, n10, n11)) == (n13 = -1)) {
            return n13;
        }
        string2 = AppOpsManagerCompat.permissionToOp(string2);
        n10 = 0;
        if (string2 == null) {
            return 0;
        }
        if (string3 == null) {
            int n14;
            string3 = context.getPackageManager();
            String[] stringArray = string3.getPackagesForUid(n11);
            if (stringArray != null && (n14 = stringArray.length) > 0) {
                string3 = stringArray[0];
            } else {
                return n13;
            }
        }
        if ((n12 = AppOpsManagerCompat.noteProxyOpNoThrow(context, string2, string3)) != 0) {
            return -2;
        }
        return 0;
    }

    public static int checkSelfPermission(Context context, String string2) {
        int n10 = Process.myPid();
        int n11 = Process.myUid();
        String string3 = context.getPackageName();
        return PermissionChecker.checkPermission(context, string2, n10, n11, string3);
    }
}

