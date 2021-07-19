/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.ActivityManager
 *  android.app.ActivityManager$RunningAppProcessInfo
 *  android.app.KeyguardManager
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.Process
 *  android.text.TextUtils
 */
package com.huawei.hms.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.huawei.hms.support.common.ActivityMgr;
import com.huawei.hms.support.log.HMSLog;

public class UIUtil {
    public static Activity getActiveActivity(Activity object, Context object2) {
        boolean bl2 = UIUtil.isBackground((Context)object2);
        String string2 = "UIUtil";
        if (bl2) {
            object = new StringBuilder();
            ((StringBuilder)object).append("isBackground");
            boolean bl3 = UIUtil.isBackground((Context)object2);
            ((StringBuilder)object).append(bl3);
            object = ((StringBuilder)object).toString();
            HMSLog.i(string2, (String)object);
            return null;
        }
        if (object == null) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("activity is ");
            ((StringBuilder)object2).append(object);
            object = ((StringBuilder)object2).toString();
            HMSLog.i(string2, (String)object);
            return ActivityMgr.INST.getCurrentActivity();
        }
        boolean bl4 = object.isFinishing();
        if (bl4) {
            object2 = new StringBuilder();
            String string3 = "activity isFinishing is ";
            ((StringBuilder)object2).append(string3);
            boolean bl5 = object.isFinishing();
            ((StringBuilder)object2).append(bl5);
            object = ((StringBuilder)object2).toString();
            HMSLog.i(string2, (String)object);
            object = ActivityMgr.INST.getCurrentActivity();
        }
        return object;
    }

    public static String getProcessName(Context object, int n10) {
        String string2 = "";
        if (object == null) {
            return string2;
        }
        String string3 = "activity";
        if ((object = (ActivityManager)object.getSystemService(string3)) != null && (object = object.getRunningAppProcesses()) != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                string3 = (ActivityManager.RunningAppProcessInfo)object.next();
                int n11 = ((ActivityManager.RunningAppProcessInfo)string3).pid;
                if (n11 != n10) continue;
                return ((ActivityManager.RunningAppProcessInfo)string3).processName;
            }
        }
        return string2;
    }

    /*
     * WARNING - void declaration
     */
    public static boolean isActivityFullscreen(Activity activity) {
        void var1_5;
        activity = activity.getWindow().getAttributes();
        int bl2 = activity.flags;
        int n10 = 1024;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
            activity = null;
        }
        return (boolean)var1_5;
    }

    public static boolean isBackground(Context object) {
        int n10 = 1;
        if (object == null) {
            return n10;
        }
        Object object2 = (ActivityManager)object.getSystemService("activity");
        KeyguardManager keyguardManager = (KeyguardManager)object.getSystemService("keyguard");
        if (object2 != null && keyguardManager != null) {
            if ((object2 = object2.getRunningAppProcesses()) == null) {
                return n10;
            }
            int n11 = Process.myPid();
            object = UIUtil.getProcessName((Context)object, n11);
            object2 = object2.iterator();
            while ((n11 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
                Object object3 = (ActivityManager.RunningAppProcessInfo)object2.next();
                String string2 = ((ActivityManager.RunningAppProcessInfo)object3).processName;
                boolean bl2 = TextUtils.equals((CharSequence)string2, (CharSequence)object);
                if (!bl2) continue;
                object = new StringBuilder();
                ((StringBuilder)object).append("appProcess.importance is ");
                int n12 = ((ActivityManager.RunningAppProcessInfo)object3).importance;
                ((StringBuilder)object).append(n12);
                object = ((StringBuilder)object).toString();
                object2 = "UIUtil";
                HMSLog.i((String)object2, (String)object);
                int n13 = ((ActivityManager.RunningAppProcessInfo)object3).importance;
                n11 = 100;
                bl2 = false;
                string2 = null;
                if (n13 == n11) {
                    n13 = n10;
                } else {
                    n13 = 0;
                    object = null;
                }
                n11 = Build.VERSION.SDK_INT;
                int n14 = 22;
                boolean bl3 = n11 > n14 ? keyguardManager.isDeviceLocked() : keyguardManager.inKeyguardRestrictedInputMode();
                object3 = new StringBuilder();
                ((StringBuilder)object3).append("isForground is ");
                ((StringBuilder)object3).append(n13 != 0);
                String string3 = "***  isLockedState is ";
                ((StringBuilder)object3).append(string3);
                ((StringBuilder)object3).append(bl3);
                object3 = ((StringBuilder)object3).toString();
                HMSLog.i((String)object2, (String)object3);
                if (!n13 || bl3) break;
                n10 = 0;
                break;
            }
        }
        return n10;
    }
}

