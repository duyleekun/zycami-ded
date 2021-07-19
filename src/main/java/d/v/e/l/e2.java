/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Process
 */
package d.v.e.l;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import androidx.collection.SimpleArrayMap;
import androidx.core.app.ActivityCompat;
import androidx.core.app.AppOpsManagerCompat;
import androidx.core.content.PermissionChecker;
import androidx.fragment.app.Fragment;

public final class e2 {
    private static final SimpleArrayMap a;

    static {
        SimpleArrayMap simpleArrayMap;
        a = simpleArrayMap = new SimpleArrayMap(8);
        Integer n10 = 14;
        simpleArrayMap.put("com.android.voicemail.permission.ADD_VOICEMAIL", n10);
        n10 = 20;
        simpleArrayMap.put("android.permission.BODY_SENSORS", n10);
        n10 = 16;
        simpleArrayMap.put("android.permission.READ_CALL_LOG", n10);
        simpleArrayMap.put("android.permission.READ_EXTERNAL_STORAGE", n10);
        Integer n11 = 9;
        simpleArrayMap.put("android.permission.USE_SIP", n11);
        simpleArrayMap.put("android.permission.WRITE_CALL_LOG", n10);
        n10 = 23;
        simpleArrayMap.put("android.permission.SYSTEM_ALERT_WINDOW", n10);
        simpleArrayMap.put("android.permission.WRITE_SETTINGS", n10);
    }

    private e2() {
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean a(Context context, String string2) {
        String string3;
        String string4;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 >= n11 && (n10 = (int)((string4 = "Xiaomi").equalsIgnoreCase(string3 = Build.MANUFACTURER) ? 1 : 0))) {
            return e2.b(context, string2);
        }
        n10 = 0;
        string3 = null;
        try {
            int n12 = PermissionChecker.checkSelfPermission(context, string2);
            if (n12 != 0) return n10 != 0;
            return 1 != 0;
        }
        catch (RuntimeException runtimeException) {
            return n10 != 0;
        }
    }

    private static boolean b(Context context, String string2) {
        int n10;
        String string3;
        String string4 = AppOpsManagerCompat.permissionToOp(string2);
        boolean bl2 = true;
        if (string4 == null) {
            return bl2;
        }
        int n11 = Process.myUid();
        int n12 = AppOpsManagerCompat.noteOp(context, string4, n11, string3 = context.getPackageName());
        if (n12 != 0 || (n10 = PermissionChecker.checkSelfPermission(context, string2)) != 0) {
            bl2 = false;
        }
        return bl2;
    }

    public static boolean c(Context context, String ... stringArray) {
        for (String string2 : stringArray) {
            boolean bl2;
            boolean bl3 = e2.d(string2);
            if (!bl3 || (bl2 = e2.a(context, string2))) continue;
            return false;
        }
        return true;
    }

    private static boolean d(String object) {
        int n10;
        int n11;
        SimpleArrayMap simpleArrayMap = a;
        if ((object = (Integer)simpleArrayMap.get(object)) != null && (n11 = Build.VERSION.SDK_INT) < (n10 = ((Integer)object).intValue())) {
            n10 = 0;
            object = null;
        } else {
            n10 = 1;
        }
        return n10 != 0;
    }

    public static boolean e(Activity activity, String ... stringArray) {
        for (String string2 : stringArray) {
            boolean bl2 = ActivityCompat.shouldShowRequestPermissionRationale(activity, string2);
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public static boolean f(Fragment fragment, String ... stringArray) {
        for (String string2 : stringArray) {
            boolean bl2 = fragment.shouldShowRequestPermissionRationale(string2);
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public static boolean g(int ... nArray) {
        int n10 = nArray.length;
        if (n10 == 0) {
            return false;
        }
        for (int n11 : nArray) {
            if (n11 == 0) continue;
            return false;
        }
        return true;
    }
}

