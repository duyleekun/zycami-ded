/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.app.ActivityManager$RunningAppProcessInfo
 *  android.content.Context
 *  android.os.Process
 */
package d.v.e.l;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;

public class f2 {
    private static int a;

    public static int a(Context object, String string2) {
        int n10 = a;
        if (n10 == 0) {
            String string3 = "activity";
            object = ((ActivityManager)object.getSystemService(string3)).getRunningAppProcesses().iterator();
            while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                int n11;
                string3 = (ActivityManager.RunningAppProcessInfo)object.next();
                String string4 = ((ActivityManager.RunningAppProcessInfo)string3).processName;
                boolean bl2 = string4.equals(string2);
                if (!bl2) continue;
                a = n11 = ((ActivityManager.RunningAppProcessInfo)string3).pid;
                break;
            }
        }
        return a;
    }

    public static String b(Context object) {
        boolean bl2;
        int n10 = Process.myPid();
        String string2 = "activity";
        object = ((ActivityManager)object.getSystemService(string2)).getRunningAppProcesses().iterator();
        while (bl2 = object.hasNext()) {
            string2 = (ActivityManager.RunningAppProcessInfo)object.next();
            int n11 = ((ActivityManager.RunningAppProcessInfo)string2).pid;
            if (n11 != n10) continue;
            return ((ActivityManager.RunningAppProcessInfo)string2).processName;
        }
        return null;
    }

    public static boolean c(Context object, String string2) {
        boolean bl2;
        String string3 = "activity";
        object = ((ActivityManager)object.getSystemService(string3)).getRunningAppProcesses().iterator();
        while (bl2 = object.hasNext()) {
            string3 = ((ActivityManager.RunningAppProcessInfo)object.next()).processName;
            bl2 = string3.equals(string2);
            if (!bl2) continue;
            return true;
        }
        return false;
    }
}

