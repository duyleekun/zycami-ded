/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.app.ActivityManager$RunningServiceInfo
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.os.Process
 */
package com.geetest.sdk.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Process;
import com.geetest.sdk.utils.l;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;

public class v {
    private static boolean a() {
        StackTraceElement[] stackTraceElementArray;
        String string2 = "Deteck hook";
        try {
            stackTraceElementArray = new Exception(string2);
            throw stackTraceElementArray;
        }
        catch (Exception exception) {
            stackTraceElementArray = exception.getStackTrace();
            int n10 = stackTraceElementArray.length;
            int n11 = 0;
            for (int i10 = 0; i10 < n10; ++i10) {
                boolean bl2;
                String string3;
                Object object = stackTraceElementArray[i10];
                String string4 = ((StackTraceElement)object).getClassName();
                int n12 = "com.android.internal.os.ZygoteInit".equals(string4);
                String string5 = "Geetest";
                boolean bl3 = true;
                if (n12 != 0 && ++n11 == (n12 = 2)) {
                    l.d(string5, "Substrate is active on the device.");
                    return bl3;
                }
                String string6 = "com.saurik.substrate.MS$2";
                string4 = ((StackTraceElement)object).getClassName();
                n12 = (int)(string6.equals(string4) ? 1 : 0);
                if (n12 != 0 && (n12 = (int)((string6 = "invoke").equals(string4 = ((StackTraceElement)object).getMethodName()) ? 1 : 0)) != 0) {
                    l.d(string5, "A method on the stack trace has been hooked using Substrate.");
                    return bl3;
                }
                string6 = "de.robv.android.xposed.XposedBridge";
                string4 = ((StackTraceElement)object).getClassName();
                n12 = (int)(string6.equals(string4) ? 1 : 0);
                if (n12 != 0 && (n12 = (int)((string3 = "main").equals(string4 = ((StackTraceElement)object).getMethodName()) ? 1 : 0)) != 0) {
                    l.d(string5, "Xposed is active on the device.");
                    return bl3;
                }
                string4 = ((StackTraceElement)object).getClassName();
                n12 = (int)(string6.equals(string4) ? 1 : 0);
                if (n12 == 0 || !(bl2 = (string4 = "handleHookedMethod").equals(object = ((StackTraceElement)object).getMethodName()))) continue;
                l.d(string5, "A method on the stack trace has been hooked using Xposed.");
                return bl3;
            }
            return false;
        }
    }

    private static boolean a(Context object) {
        boolean bl2;
        object = object.getApplicationContext().getPackageManager().getInstalledApplications(128);
        String string2 = null;
        if (object == null) {
            return false;
        }
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            String string3;
            Object object2 = (ApplicationInfo)object.next();
            String string4 = object2.packageName;
            String string5 = "de.robv.android.xposed.installer";
            boolean bl3 = string5.equals(string4);
            boolean bl4 = true;
            String string6 = "Geetest";
            if (!(bl3 || (bl3 = (string3 = "com.sollyu.xposed.hook.model").equals(string4 = object2.packageName)) || (bl3 = (string3 = "org.meowcat.edxposed.manager").equals(string4 = object2.packageName)) || (bl3 = (string3 = "com.solohsu.android.edxp.manager").equals(string4 = object2.packageName)))) {
                string4 = "com.saurik.substrate";
                object2 = object2.packageName;
                bl2 = string4.equals(object2);
                if (!bl2) continue;
                l.d(string6, "CydiaSubstrate fonund on device");
                return bl4;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("Xposeded fonund on device # ");
            string2 = object2.manageSpaceActivityName;
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
            l.d(string6, (String)object);
            return bl4;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static boolean b() {
        Object object = new HashSet();
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("/proc/");
        int n10 = Process.myPid();
        ((StringBuilder)charSequence).append(n10);
        Object object2 = "/maps";
        ((StringBuilder)charSequence).append((String)object2);
        charSequence = ((StringBuilder)charSequence).toString();
        try {
            int n11;
            String string2;
            String string3;
            int n12;
            FileReader fileReader = new FileReader((String)charSequence);
            object2 = new BufferedReader(fileReader);
            while (true) {
                charSequence = ((BufferedReader)object2).readLine();
                n12 = 1;
                if (charSequence == null) break;
                string3 = ((String)charSequence).toLowerCase();
                n11 = string3.contains(string2 = "frida");
                if (n11 != 0) {
                    return n12 != 0;
                }
                string3 = ".so";
                n11 = ((String)charSequence).endsWith(string3);
                if (n11 == 0 && (n11 = ((String)charSequence).endsWith(string3 = ".jar")) == 0) continue;
                string3 = " ";
                n11 = ((String)charSequence).lastIndexOf(string3) + n12;
                charSequence = ((String)charSequence).substring(n11);
                object.add(charSequence);
            }
            object = object.iterator();
            do {
                boolean bl2;
                if (!(bl2 = object.hasNext())) {
                    ((BufferedReader)object2).close();
                    return false;
                }
                charSequence = object.next();
                charSequence = (String)charSequence;
                string3 = "com.saurik.substrate";
                n11 = ((String)charSequence).contains(string3);
                string2 = "Geetest";
                if (n11 == 0) continue;
                object = new StringBuilder();
                object2 = "Substrate shared object found: ";
                ((StringBuilder)object).append((String)object2);
                ((StringBuilder)object).append((String)charSequence);
                object = ((StringBuilder)object).toString();
                l.d(string2, (String)object);
                return n12 != 0;
            } while ((n11 = (int)(((String)charSequence).contains(string3 = "XposedBridge.jar") ? 1 : 0)) == 0 && (n11 = (int)(((String)charSequence).contains(string3 = "edxp.jar") ? 1 : 0)) == 0);
            object = new StringBuilder();
            object2 = "Xposed JAR found: ";
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append((String)charSequence);
            object = ((StringBuilder)object).toString();
            l.d(string2, (String)object);
            return n12 != 0;
        }
        catch (Exception exception) {
            return false;
        }
    }

    private static boolean b(Context object) {
        int n10;
        String string2 = "activity";
        if ((object = (ActivityManager)object.getSystemService(string2)) != null) {
            n10 = 300;
            object = object.getRunningServices(n10);
        } else {
            object = null;
        }
        string2 = null;
        if (object != null) {
            int n11;
            int n12 = 0;
            for (n10 = 0; n10 < (n11 = object.size()); ++n10) {
                String string3 = ((ActivityManager.RunningServiceInfo)object.get((int)n10)).process;
                String string4 = "fridaserver";
                n11 = (int)(string3.contains(string4) ? 1 : 0);
                if (n11 == 0) continue;
                n12 = 1;
            }
            n10 = n12;
        }
        return n10 != 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int c(Context context) {
        int n10 = 0;
        try {
            boolean bl2 = v.b(context);
            if (bl2) return 1;
        }
        catch (Exception exception) {
            return n10;
        }
        boolean bl3 = v.a(context);
        if (bl3) return 1;
        bl3 = v.a();
        if (bl3) return 1;
        bl3 = v.b();
        if (!bl3) return n10;
        return 1;
    }
}

