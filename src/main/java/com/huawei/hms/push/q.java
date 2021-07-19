/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.AlarmManager
 *  android.app.NotificationManager
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ActivityInfo
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.ResolveInfo
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 */
package com.huawei.hms.push;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class q {
    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static long a(String var0) {
        var1_2 = "PushSelfShowLog";
        if (var0 == null) {
            var0 = "";
        }
        var2_3 = 0L;
        var4_4 = new Date();
        var5_5 = var4_4.getHours() * 2;
        var6_6 = var4_4.getMinutes();
        var5_5 += (var6_6 /= 30);
        var0 = var0.concat((String)var0);
        var7_7 /* !! */  = new StringBuilder();
        var8_8 = "startIndex is ";
        var7_7 /* !! */ .append(var8_8);
        var7_7 /* !! */ .append(var5_5);
        var8_8 = ",ap is:";
        var7_7 /* !! */ .append(var8_8);
        var7_7 /* !! */ .append((String)var0);
        var8_8 = ",length is:";
        var7_7 /* !! */ .append(var8_8);
        var9_9 = var0.length();
        var7_7 /* !! */ .append(var9_9);
        var7_7 /* !! */  = var7_7 /* !! */ .toString();
        HMSLog.i(var1_2, (String)var7_7 /* !! */ );
        var6_6 = var0.length();
        for (var9_9 = var5_5; var9_9 < var6_6; ++var9_9) {
            var10_10 = var0.charAt(var9_9);
            var11_11 = '0';
            if (var10_10 == var11_11) continue;
            var12_12 = 60000L;
            var14_13 = (var9_9 - var5_5) * 30;
            var15_14 = var4_4.getMinutes();
            ** try [egrp 16[TRYBLOCK] [20 : 206->209)] { 
lbl52:
            // 1 sources

            var16_15 = (long)(var14_13 -= (var15_14 %= 30)) * var12_12;
            var0 = new StringBuilder();
            var4_4 = "startIndex is:";
            var0.append((String)var4_4);
            var0.append(var5_5);
            var4_4 = " i is:";
            var0.append((String)var4_4);
            var0.append(var9_9);
            var4_4 = " delay:";
            var0.append((String)var4_4);
            var0.append(var16_15);
            var0 = var0.toString();
            try {
                HMSLog.d(var1_2, (String)var0);
            }
lbl83:
            // 23 sources

            catch (Exception var0_1) {
                var4_4 = "error ";
                HMSLog.e(var1_2, (String)var4_4, var0_1);
                break;
            }
            var14_13 = (int)(var16_15 == var2_3 ? 0 : (var16_15 < var2_3 ? -1 : 1));
            if (var14_13 >= 0) {
                var2_3 = var16_15;
            }
            return var2_3;
        }
        return var2_3;
    }

    public static Boolean a(Context object, String string2, Intent object2) {
        block16: {
            object = object.getPackageManager();
            object = object.queryIntentActivities(object2, 0);
            if (object == null) break block16;
            int n10 = object.size();
            if (n10 <= 0) break block16;
            n10 = object.size();
            for (int i10 = 0; i10 < n10; ++i10) {
                Object object3 = object.get(i10);
                object3 = (ResolveInfo)object3;
                object3 = ((ResolveInfo)object3).activityInfo;
                if (object3 == null) continue;
                object3 = object.get(i10);
                object3 = (ResolveInfo)object3;
                object3 = ((ResolveInfo)object3).activityInfo;
                object3 = ((ActivityInfo)object3).applicationInfo;
                object3 = ((ApplicationInfo)object3).packageName;
                boolean bl2 = string2.equals(object3);
                if (!bl2) continue;
                try {
                    return Boolean.TRUE;
                }
                catch (Exception exception) {
                    string2 = exception.toString();
                    object2 = "PushSelfShowLog";
                    HMSLog.e((String)object2, string2, exception);
                    break;
                }
            }
        }
        return Boolean.FALSE;
    }

    public static String a(Context object, String string2) {
        int n10;
        try {
            object = object.getPackageManager();
            n10 = 128;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            object = new StringBuilder();
            ((StringBuilder)object).append("get the app name of package:");
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" failed.");
            object = ((StringBuilder)object).toString();
            HMSLog.i("PushSelfShowLog", (String)object);
            return null;
        }
        ApplicationInfo applicationInfo = object.getApplicationInfo(string2, n10);
        object = object.getApplicationLabel(applicationInfo);
        return object.toString();
    }

    public static void a(Context object, int n10) {
        block5: {
            String string2 = "PushSelfShowLog";
            if (object == null) {
                HMSLog.e(string2, "context is null");
                return;
            }
            String string3 = "notification";
            object = object.getSystemService(string3);
            object = (NotificationManager)object;
            if (object == null) break block5;
            try {
                object.cancel(n10);
            }
            catch (Exception exception) {
                StringBuilder stringBuilder = new StringBuilder();
                string3 = "removeNotifiCationById err:";
                stringBuilder.append(string3);
                String string4 = exception.toString();
                stringBuilder.append(string4);
                string4 = stringBuilder.toString();
                HMSLog.e(string2, string4);
            }
        }
    }

    public static void a(Context object, Intent object2) {
        CharSequence charSequence;
        String string2;
        block18: {
            string2 = "PushSelfShowLog";
            charSequence = "selfshow_auto_clear_id";
            Object object3 = null;
            int n10 = object2.getIntExtra((String)charSequence, 0);
            charSequence = new StringBuilder();
            object3 = "setDelayAlarm(cancel) alarmNotityId ";
            ((StringBuilder)charSequence).append((String)object3);
            ((StringBuilder)charSequence).append(n10);
            charSequence = ((StringBuilder)charSequence).toString();
            HMSLog.d(string2, (String)charSequence);
            if (n10 == 0) {
                return;
            }
            object3 = "com.huawei.intent.action.PUSH_DELAY_NOTIFY";
            charSequence = new Intent((String)object3);
            object3 = object.getPackageName();
            object3 = charSequence.setPackage((String)object3);
            int n11 = 32;
            object3.setFlags(n11);
            object3 = "alarm";
            object3 = object.getSystemService((String)object3);
            object3 = (AlarmManager)object3;
            n11 = 0x20000000;
            object = PendingIntent.getBroadcast((Context)object, (int)n10, (Intent)charSequence, (int)n11);
            if (object == null || object3 == null) break block18;
            object2 = "alarm cancel";
            HMSLog.d(string2, (String)object2);
            object3.cancel((PendingIntent)object);
        }
        object = "alarm not exist";
        try {
            HMSLog.d(string2, (String)object);
        }
        catch (Exception exception) {
            object2 = new StringBuilder();
            charSequence = "cancelAlarm err:";
            ((StringBuilder)object2).append((String)charSequence);
            String string3 = exception.toString();
            ((StringBuilder)object2).append(string3);
            string3 = ((StringBuilder)object2).toString();
            HMSLog.e(string2, string3);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(Context context, Intent object, long l10) {
        String string2 = "PushSelfShowLog";
        try {
            Object object2 = new StringBuilder();
            String string3 = "enter setAPDelayAlarm(intent:";
            ((StringBuilder)object2).append(string3);
            string3 = object.toURI();
            ((StringBuilder)object2).append(string3);
            string3 = " interval:";
            ((StringBuilder)object2).append(string3);
            ((StringBuilder)object2).append(l10);
            string3 = "ms, context:";
            ((StringBuilder)object2).append(string3);
            ((StringBuilder)object2).append(context);
            object2 = ((StringBuilder)object2).toString();
            HMSLog.d(string2, (String)object2);
            object2 = "alarm";
            object2 = context.getSystemService((String)object2);
            object2 = (AlarmManager)object2;
            if (object2 == null) return;
            long l11 = System.currentTimeMillis();
            long l12 = 1000L;
            int n10 = (int)(l11 /= l12);
            context = PendingIntent.getBroadcast((Context)context, (int)n10, (Intent)object, (int)0);
            l12 = System.currentTimeMillis() + l10;
            object2.set(0, l12, (PendingIntent)context);
            return;
        }
        catch (Exception exception) {
            object = new StringBuilder();
            String string4 = "set DelayAlarm error";
            ((StringBuilder)object).append(string4);
            String string5 = exception.toString();
            ((StringBuilder)object).append(string5);
            string5 = ((StringBuilder)object).toString();
            HMSLog.w(string2, string5);
        }
    }

    public static boolean a() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 11;
        n10 = n10 >= n11 ? 1 : 0;
        return n10 != 0;
    }

    public static boolean a(Context object) {
        object = object.getPackageName();
        return "com.huawei.hwid".equals(object);
    }

    public static Intent b(Context object, String string2) {
        object = object.getPackageManager();
        try {
            object = object.getLaunchIntentForPackage(string2);
        }
        catch (Exception exception) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" not have launch activity");
            object = ((StringBuilder)object).toString();
            string2 = "PushSelfShowLog";
            HMSLog.w(string2, (String)object);
            object = null;
        }
        return object;
    }

    public static boolean c(Context object, String string2) {
        CharSequence charSequence;
        int n10;
        if (object != null && string2 != null && (n10 = ((String)(charSequence = "")).equals(string2)) == 0) {
            try {
                object = object.getPackageManager();
                n10 = 8192;
            }
            catch (Exception exception) {}
            object = object.getApplicationInfo(string2, n10);
            if (object == null) {
                return false;
            }
            object = "PushSelfShowLog";
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string2);
            string2 = " is installed";
            ((StringBuilder)charSequence).append(string2);
            string2 = ((StringBuilder)charSequence).toString();
            HMSLog.d((String)object, string2);
            return true;
        }
        return false;
    }

    /*
     * WARNING - void declaration
     */
    public static boolean d(Context context, String string2) {
        void var4_7;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        context = context.getPackageManager();
        context.getPreferredActivities(arrayList, arrayList2, string2);
        int bl2 = arrayList2.size();
        if (bl2 > 0) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
            context = null;
        }
        return (boolean)var4_7;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void e(Context context, String iterator2) {
        boolean bl2 = TextUtils.isEmpty(iterator2);
        String string2 = "PushSelfShowLog";
        if (bl2) {
            HMSLog.i(string2, "url is null.");
            return;
        }
        try {
            boolean bl3;
            Object object;
            boolean bl4;
            String string3 = "android.intent.action.VIEW";
            Intent intent = new Intent(string3);
            iterator2 = Uri.parse((String)((Object)iterator2));
            intent.setData((Uri)iterator2);
            int n10 = 0x18000000;
            intent.setFlags(n10);
            iterator2 = context.getPackageManager();
            string3 = null;
            iterator2 = iterator2.queryIntentActivities(intent, 0);
            string3 = null;
            Object object2 = iterator2.iterator();
            while (bl4 = object2.hasNext()) {
                object = object2.next();
                object = (ResolveInfo)object;
                object = ((ResolveInfo)object).activityInfo;
                object = ((ActivityInfo)object).packageName;
                bl3 = q.d(context, object);
                if (!bl3) continue;
                string3 = object;
                break;
            }
            if (string3 == null) {
                object2 = "com.android.browser";
                iterator2 = iterator2.iterator();
                while (bl4 = iterator2.hasNext()) {
                    object = iterator2.next();
                    object = (ResolveInfo)object;
                    object = ((ResolveInfo)object).activityInfo;
                    object = ((ActivityInfo)object).packageName;
                    bl3 = ((String)object2).equalsIgnoreCase((String)object);
                    if (!bl3) continue;
                    string3 = object;
                    break;
                }
            }
            if (string3 != null) {
                intent.setPackage(string3);
            }
            context.startActivity(intent);
            return;
        }
        catch (Exception exception) {
            iterator2 = new Iterator();
            String string4 = "start browser activity failed, exception:";
            ((StringBuilder)((Object)iterator2)).append(string4);
            String string5 = exception.getMessage();
            ((StringBuilder)((Object)iterator2)).append(string5);
            string5 = ((StringBuilder)((Object)iterator2)).toString();
            HMSLog.e(string2, string5);
        }
    }
}

