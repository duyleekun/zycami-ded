/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.app.ActivityManager$RunningAppProcessInfo
 *  android.app.AppOpsManager
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Build$VERSION
 *  android.os.Process
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ba;
import com.xiaomi.push.g$a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class g {
    public static int a(Context context, String string2) {
        int n10;
        context = context.getPackageManager();
        int n11 = 16384;
        try {
            context = context.getPackageInfo(string2, n11);
        }
        catch (Exception exception) {
            b.a(exception);
            n10 = 0;
            context = null;
        }
        if (context != null) {
            n10 = context.versionCode;
        } else {
            n10 = 0;
            context = null;
        }
        return n10;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static g$a a(Context object, String string2) {
        void var1_8;
        if (object == null) return g$a.a;
        int n10 = TextUtils.isEmpty((CharSequence)var1_8);
        if (n10 != 0) return g$a.a;
        n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 < n11) {
            return g$a.a;
        }
        Object object2 = AppOpsManager.class;
        Object object3 = "OP_POST_NOTIFICATION";
        try {
            void var0_7;
            int n12;
            object2 = ba.a(object2, (String)object3);
            object2 = (Integer)object2;
            if (object2 == null) {
                return g$a.a;
            }
            object3 = object.getPackageManager();
            object3 = object3.getApplicationInfo((String)var1_8, 0);
            String string3 = "appops";
            Object object4 = object.getSystemService(string3);
            AppOpsManager appOpsManager = (AppOpsManager)object4;
            string3 = "checkOpNoThrow";
            int n13 = 3;
            Object[] objectArray = new Object[n13];
            objectArray[0] = object2;
            n10 = 1;
            n11 = ((ApplicationInfo)object3).uid;
            objectArray[n10] = object3 = Integer.valueOf(n11);
            n10 = 2;
            objectArray[n10] = var1_8;
            Object object5 = ba.a((Object)appOpsManager, string3, objectArray);
            Integer n14 = (Integer)object5;
            if (n14 != null && (n12 = n14.intValue()) == 0) {
                g$a g$a = g$a.b;
                return var0_7;
            }
            g$a g$a = g$a.c;
            return var0_7;
        }
        catch (Throwable throwable) {
            return g$a.a;
        }
    }

    public static String a(Context object) {
        boolean bl2;
        if (object == null) {
            return null;
        }
        String string2 = "activity";
        if ((object = ((ActivityManager)object.getSystemService(string2)).getRunningAppProcesses()) == null) {
            return null;
        }
        int n10 = Process.myPid();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)object.next();
            int n11 = runningAppProcessInfo.pid;
            if (n11 != n10) continue;
            return runningAppProcessInfo.processName;
        }
        return null;
    }

    public static String a(Context object, String string2) {
        object = object.getPackageManager();
        int n10 = 16384;
        try {
            object = object.getPackageInfo(string2, n10);
        }
        catch (Exception exception) {
            b.a(exception);
            object = null;
        }
        object = object != null ? object.versionName : "1.0";
        return object;
    }

    public static boolean a(Context context) {
        boolean bl2;
        boolean bl3;
        Object object = ((ActivityManager)context.getSystemService("activity")).getRunningAppProcesses();
        if (object != null && (bl3 = object.size()) >= (bl2 = true)) {
            object = object.iterator();
            while (bl3 = (boolean)object.hasNext()) {
                String string2;
                Object object2 = (ActivityManager.RunningAppProcessInfo)object.next();
                int n10 = ((ActivityManager.RunningAppProcessInfo)object2).pid;
                int n11 = Process.myPid();
                if (n10 != n11 || !(bl3 = (boolean)((String)(object2 = ((ActivityManager.RunningAppProcessInfo)object2).processName)).equals(string2 = context.getPackageName()))) continue;
                return bl2;
            }
        }
        return false;
    }

    public static boolean a(Context object, String string2) {
        List<String> list = "activity";
        if ((object = ((ActivityManager)object.getSystemService((String)((Object)list))).getRunningAppProcesses()) != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                list = Arrays.asList(((ActivityManager.RunningAppProcessInfo)object.next()).pkgList);
                bl2 = list.contains(string2);
                if (!bl2) continue;
                return true;
            }
        }
        return false;
    }

    public static String b(Context object) {
        int n10;
        object = ((ActivityManager)object.getSystemService("activity")).getRunningAppProcesses();
        ArrayList<String> arrayList = new ArrayList<String>();
        StringBuilder stringBuilder = new StringBuilder();
        if (object != null && (n10 = object.size()) > 0) {
            object = object.iterator();
            while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                int n11;
                String[] stringArray = ((ActivityManager.RunningAppProcessInfo)object.next()).pkgList;
                for (int i10 = 0; stringArray != null && i10 < (n11 = stringArray.length); ++i10) {
                    String string2 = stringArray[i10];
                    n11 = (int)(arrayList.contains(string2) ? 1 : 0);
                    if (n11 != 0) continue;
                    string2 = stringArray[i10];
                    arrayList.add(string2);
                    n11 = arrayList.size();
                    int n12 = 100000;
                    int n13 = 1;
                    if (n11 == n13) {
                        string2 = (String)arrayList.get(0);
                    } else {
                        stringBuilder.append("#");
                        string2 = stringArray[i10];
                    }
                    n11 = string2.hashCode() % n12;
                    stringBuilder.append(n11);
                }
            }
        }
        return stringBuilder.toString();
    }

    public static String b(Context object, String object2) {
        block6: {
            object = object.getPackageManager();
            PackageInfo packageInfo = null;
            packageInfo = object.getPackageInfo((String)object2, 0);
            if (packageInfo == null) break block6;
            packageInfo = packageInfo.applicationInfo;
            if (packageInfo == null) break block6;
            object = object.getApplicationLabel((ApplicationInfo)packageInfo);
            try {
                object2 = object = object.toString();
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                b.a(nameNotFoundException);
            }
        }
        return object2;
    }

    public static boolean b(Context context, String string2) {
        context = context.getPackageManager();
        try {
            context = context.getPackageInfo(string2, 0);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            context = null;
        }
        return context != null;
    }

    public static boolean c(Context object, String string2) {
        PackageManager packageManager = object.getPackageManager();
        int n10 = packageManager.checkPermission(string2, (String)(object = object.getPackageName()));
        if (!n10) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        return n10 != 0;
    }
}

