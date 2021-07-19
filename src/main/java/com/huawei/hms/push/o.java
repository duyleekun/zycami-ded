/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.AlarmManager
 *  android.app.Notification
 *  android.app.Notification$Builder
 *  android.app.NotificationChannel
 *  android.app.NotificationManager
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ApplicationInfo
 *  android.graphics.Bitmap
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.text.TextUtils
 */
package com.huawei.hms.push;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.android.HwBuildEx$VERSION;
import com.huawei.hms.push.e;
import com.huawei.hms.push.k;
import com.huawei.hms.push.l;
import com.huawei.hms.push.m;
import com.huawei.hms.push.n;
import com.huawei.hms.push.q;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;

public class o {
    public static int a;

    public static Notification a(Context context, k k10, int[] object) {
        n n10;
        Notification.Builder builder = new Notification.Builder(context);
        Object object2 = m.a(k10);
        if (object2 == (n10 = n.b)) {
            object2 = k10.g();
            m.a(builder, (String)object2, k10);
        }
        l.a(context, builder, k10);
        o.b(k10, builder);
        o.b(context, k10, builder);
        o.a(context, k10, builder);
        o.a(builder);
        o.a(k10, builder);
        o.c(k10, builder);
        object2 = o.c(context, k10, object);
        builder.setContentIntent((PendingIntent)object2);
        object = o.b(context, k10, object);
        builder.setDeleteIntent((PendingIntent)object);
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 26;
        if (n11 >= n12) {
            object = "HwPushChannelID";
            builder.setChannelId((String)object);
        }
        o.b(context, builder, k10);
        o.a(context, builder, k10);
        return builder.build();
    }

    public static Intent a(Context object, k object2, int[] nArray, String string2, int n10) {
        Intent intent = new Intent("com.huawei.intent.action.PUSH_DELAY_NOTIFY");
        Object object3 = ((k)object2).o();
        object3 = intent.putExtra("selfshow_info", object3);
        object2 = ((k)object2).y();
        object2 = object3.putExtra("selfshow_token", (byte[])object2).putExtra("selfshow_event_id", string2);
        int n11 = nArray[0];
        object2 = object2.putExtra("selfshow_notify_id", n11);
        int n12 = nArray[3];
        object2 = object2.putExtra("selfshow_auto_clear_id", n12);
        object = object.getPackageName();
        object2.setPackage((String)object).setFlags(n10);
        return intent;
    }

    public static void a(Notification.Builder builder) {
        builder.setShowWhen(true);
        long l10 = System.currentTimeMillis();
        builder.setWhen(l10);
    }

    public static void a(Context object, Notification.Builder builder, k object2) {
        int n10 = HwBuildEx$VERSION.EMUI_SDK_INT;
        int n11 = 11;
        if (n10 >= n11 && (n10 = (int)(q.a(object) ? 1 : 0)) != 0) {
            Bundle bundle = new Bundle();
            object2 = ((k)object2).k();
            CharSequence charSequence = new StringBuilder();
            charSequence.append("the package name of notification is:");
            charSequence.append((String)object2);
            charSequence = charSequence.toString();
            String string2 = "PushSelfShowLog";
            HMSLog.i(string2, (String)charSequence);
            n11 = (int)(TextUtils.isEmpty((CharSequence)object2) ? 1 : 0);
            if (n11 == 0) {
                object = q.a(object, (String)object2);
                object2 = new StringBuilder();
                charSequence = "the app name is:";
                ((StringBuilder)object2).append((String)charSequence);
                ((StringBuilder)object2).append((String)object);
                object2 = ((StringBuilder)object2).toString();
                HMSLog.i(string2, (String)object2);
                if (object != null) {
                    object2 = "android.extraAppName";
                    bundle.putCharSequence((String)object2, (CharSequence)object);
                }
            }
            builder.setExtras(bundle);
        }
    }

    public static void a(Context context, Intent object, long l10, int n10) {
        block15: {
            String string2 = "PushSelfShowLog";
            Object object2 = new StringBuilder();
            String string3 = "enter setDelayAlarm(intent:";
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
            if (object2 == null) break block15;
            int n11 = 0x8000000;
            context = PendingIntent.getBroadcast((Context)context, (int)n10, (Intent)object, (int)n11);
            object = null;
            long l11 = System.currentTimeMillis() + l10;
            try {
                object2.set(0, l11, (PendingIntent)context);
            }
            catch (Exception exception) {
                object = new StringBuilder();
                String string4 = "set DelayAlarm error.";
                ((StringBuilder)object).append(string4);
                String string5 = exception.toString();
                ((StringBuilder)object).append(string5);
                string5 = ((StringBuilder)object).toString();
                HMSLog.w(string2, string5);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(Context context, k object) {
        Class<o> clazz = o.class;
        synchronized (clazz) {
            String string2;
            if (context != null && string2 != null) {
                int n10;
                Object object2;
                int n11;
                CharSequence charSequence;
                int n12;
                Object object3;
                CharSequence charSequence2;
                int n13;
                CharSequence charSequence3 = new StringBuilder();
                String string3 = "showNotification, the msg id = ";
                ((StringBuilder)charSequence3).append(string3);
                string3 = ((k)((Object)string2)).p();
                ((StringBuilder)charSequence3).append(string3);
                charSequence3 = ((StringBuilder)charSequence3).toString();
                string3 = "PushSelfShowLog";
                HMSLog.d(string3, (String)charSequence3);
                int n14 = a;
                if (n14 == 0) {
                    charSequence3 = new StringBuilder();
                    string3 = context.getPackageName();
                    ((StringBuilder)charSequence3).append(string3);
                    long l10 = System.currentTimeMillis();
                    ((StringBuilder)charSequence3).append(l10);
                    charSequence3 = ((StringBuilder)charSequence3).toString();
                    a = n14 = ((String)charSequence3).hashCode();
                }
                charSequence3 = ((k)((Object)string2)).l();
                n14 = (int)(TextUtils.isEmpty((CharSequence)charSequence3) ? 1 : 0);
                int n15 = 1;
                if (n14 != 0) {
                    charSequence3 = ((k)((Object)string2)).q();
                    n13 = TextUtils.isEmpty((CharSequence)charSequence3);
                    if (n13 == 0) {
                        n14 = ((String)charSequence3).hashCode();
                        ((k)((Object)string2)).a(n14);
                        charSequence2 = new StringBuilder();
                        object3 = "notification msgTag = ";
                        ((StringBuilder)charSequence2).append((String)object3);
                        ((StringBuilder)charSequence2).append(n14);
                        charSequence3 = ((StringBuilder)charSequence2).toString();
                        charSequence2 = "PushSelfShowLog";
                        HMSLog.d((String)charSequence2, (String)charSequence3);
                    }
                    if ((n14 = ((k)((Object)string2)).s()) != (n13 = -1)) {
                        n14 = ((k)((Object)string2)).s();
                        charSequence2 = new StringBuilder();
                        object3 = ((k)((Object)string2)).k();
                        ((StringBuilder)charSequence2).append((String)object3);
                        long l11 = System.currentTimeMillis();
                        ((StringBuilder)charSequence2).append(l11);
                        charSequence2 = ((StringBuilder)charSequence2).toString();
                        n13 = ((String)charSequence2).hashCode();
                        n12 = n13 + 1;
                        charSequence = new StringBuilder();
                        n11 = ((k)((Object)string2)).s();
                        ((StringBuilder)charSequence).append(n11);
                        object2 = ((k)((Object)string2)).k();
                        ((StringBuilder)charSequence).append((String)object2);
                        object2 = context.getPackageName();
                        ((StringBuilder)charSequence).append((String)object2);
                        charSequence = ((StringBuilder)charSequence).toString();
                        n10 = ((String)charSequence).hashCode();
                    } else {
                        a = n14 = a + n15;
                        a = n13 = n14 + 1;
                        a = n12 = n13 + 1;
                        a = n10 = n12 + 1;
                    }
                } else {
                    charSequence3 = new StringBuilder();
                    charSequence2 = ((k)((Object)string2)).l();
                    ((StringBuilder)charSequence3).append((String)charSequence2);
                    charSequence2 = ((k)((Object)string2)).k();
                    ((StringBuilder)charSequence3).append((String)charSequence2);
                    charSequence3 = ((StringBuilder)charSequence3).toString();
                    n14 = ((String)charSequence3).hashCode();
                    a = n13 = a + n15;
                    a = n12 = n13 + 1;
                    charSequence = new StringBuilder();
                    object2 = ((k)((Object)string2)).l();
                    ((StringBuilder)charSequence).append((String)object2);
                    object2 = ((k)((Object)string2)).k();
                    ((StringBuilder)charSequence).append((String)object2);
                    object2 = context.getPackageName();
                    ((StringBuilder)charSequence).append((String)object2);
                    charSequence = ((StringBuilder)charSequence).toString();
                    n10 = ((String)charSequence).hashCode();
                }
                object2 = new StringBuilder();
                String string4 = "notifyId:";
                ((StringBuilder)object2).append(string4);
                ((StringBuilder)object2).append(n14);
                string4 = ",openNotifyId:";
                ((StringBuilder)object2).append(string4);
                ((StringBuilder)object2).append(n13);
                string4 = ",delNotifyId:";
                ((StringBuilder)object2).append(string4);
                ((StringBuilder)object2).append(n12);
                string4 = ",alarmNotifyId:";
                ((StringBuilder)object2).append(string4);
                ((StringBuilder)object2).append(n10);
                object2 = ((StringBuilder)object2).toString();
                string4 = "PushSelfShowLog";
                HMSLog.d(string4, (String)object2);
                n11 = 4;
                object2 = new int[n11];
                int n16 = 0;
                string4 = null;
                object2[0] = n14;
                object2[n15] = n13;
                n15 = 2;
                object2[n15] = n12;
                n15 = ((k)((Object)string2)).f();
                if (n15 <= 0) {
                    n10 = 0;
                    charSequence = null;
                }
                n15 = 3;
                object2[n15] = n10;
                n13 = 0;
                charSequence2 = null;
                n12 = (int)(q.a() ? 1 : 0);
                if (n12 != 0) {
                    charSequence2 = o.a(context, (k)((Object)string2), (int[])object2);
                }
                object3 = "notification";
                object3 = context.getSystemService((String)object3);
                if ((object3 = (NotificationManager)object3) != null && charSequence2 != null) {
                    n10 = Build.VERSION.SDK_INT;
                    n16 = 26;
                    if (n10 >= n16) {
                        charSequence = "hms_push_channel";
                        n10 = ResourceLoaderUtil.getStringId((String)charSequence);
                        charSequence = context.getString(n10);
                        String string5 = "HwPushChannelID";
                        string4 = new NotificationChannel(string5, charSequence, n15);
                        object3.createNotificationChannel((NotificationChannel)string4);
                    }
                    object3.notify(n14, (Notification)charSequence2);
                    o.d(context, (k)((Object)string2), (int[])object2);
                    charSequence3 = ((k)((Object)string2)).p();
                    string2 = ((k)((Object)string2)).b();
                    string3 = "100";
                    e.a(context, (String)charSequence3, string2, string3);
                }
                return;
            }
            return;
        }
    }

    public static void a(Context context, k k10, Notification.Builder builder) {
        if ((context = l.a(context, k10)) != null) {
            builder.setLargeIcon((Bitmap)context);
        }
    }

    public static void a(k k10, Notification.Builder builder) {
        int n10;
        int n11 = k10.e();
        if (n11 != (n10 = 1)) {
            n10 = 0;
        }
        builder.setAutoCancel(n10 != 0);
        builder.setOngoing(false);
    }

    public static PendingIntent b(Context context, k k10, int[] nArray) {
        k10 = o.a(context, k10, nArray, "2", 0x10000000);
        int n10 = nArray[2];
        return PendingIntent.getBroadcast((Context)context, (int)n10, (Intent)k10, (int)0x8000000);
    }

    public static void b(Context object, Notification.Builder builder, k object2) {
        String string2 = "com.huawei.android.pushagent";
        boolean bl2 = string2.equals(object = object.getPackageName());
        if (bl2) {
            object = new Bundle();
            boolean bl3 = TextUtils.isEmpty((CharSequence)(object2 = ((k)object2).k()));
            if (!bl3) {
                string2 = "hw_origin_sender_package_name";
                object.putString(string2, (String)object2);
                builder.setExtras((Bundle)object);
            }
        }
    }

    public static void b(Context object, k object2, Notification.Builder builder) {
        String string2 = ((k)object2).u();
        int n10 = TextUtils.isEmpty((CharSequence)string2);
        if (n10 != 0) {
            string2 = object.getApplicationInfo();
            n10 = ((ApplicationInfo)string2).labelRes;
            object = object.getResources().getString(n10);
        } else {
            object = ((k)object2).u();
        }
        object2 = ((k)object2).j();
        builder.setContentTitle((CharSequence)object);
        builder.setContentText((CharSequence)object2);
    }

    public static void b(k object, Notification.Builder builder) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)(object = ((k)object).t()));
        if (!bl2) {
            builder.setSubText((CharSequence)object);
        }
    }

    public static PendingIntent c(Context context, k k10, int[] nArray) {
        k10 = o.a(context, k10, nArray, "1", 0x10000000);
        int n10 = nArray[1];
        return PendingIntent.getBroadcast((Context)context, (int)n10, (Intent)k10, (int)0x8000000);
    }

    public static void c(k object, Notification.Builder builder) {
        object = ((k)object).x();
        builder.setTicker((CharSequence)object);
    }

    public static void d(Context context, k k10, int[] nArray) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("setAutoClear time is: ");
        int n10 = k10.f();
        charSequence.append(n10);
        charSequence = charSequence.toString();
        String string2 = "PushSelfShowLog";
        HMSLog.i(string2, (String)charSequence);
        int n11 = k10.f();
        if (n11 <= 0) {
            return;
        }
        charSequence = o.a(context, k10, nArray, "-1", 32);
        long l10 = k10.f();
        int n12 = nArray[3];
        o.a(context, (Intent)charSequence, l10, n12);
    }
}

