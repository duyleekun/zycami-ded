/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Binder
 *  android.os.Process
 *  android.util.Log
 */
package d.j.f.a.a.k;

import android.content.Context;
import android.os.Binder;
import android.os.Process;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import com.huawei.secure.android.common.exception.NoPermissionCheckerException;

public class e {
    private static final String a = "e";

    public static boolean a(Context context, String string2, String string3) {
        int n10;
        int n11 = Binder.getCallingPid();
        if (n11 == (n10 = Process.myPid())) {
            return false;
        }
        n11 = Binder.getCallingPid();
        n10 = Binder.getCallingUid();
        return e.b(context, string2, n11, n10, string3);
    }

    /*
     * WARNING - void declaration
     */
    public static boolean b(Context context, String string2, int n10, int n11, String string3) {
        try {
            void var5_10;
            int bl2 = PermissionChecker.checkPermission(context, string2, n10, n11, string3);
            if (bl2 == 0) {
                boolean bl3 = true;
            } else {
                boolean bl4 = false;
                context = null;
            }
            return (boolean)var5_10;
        }
        catch (Throwable throwable) {
            string2 = a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("checkPermission: ");
            Object object = throwable.getMessage();
            stringBuilder.append((String)object);
            stringBuilder.append(" , you should implementation support library or androidx library");
            object = stringBuilder.toString();
            Log.e((String)string2, (String)object);
            object = new NoPermissionCheckerException("you should implementation support library or androidx library");
            throw object;
        }
    }

    public static boolean c(Context context, String string2) {
        int n10 = Process.myPid();
        int n11 = Process.myUid();
        String string3 = context.getPackageName();
        return e.b(context, string2, n10, n11, string3);
    }
}

