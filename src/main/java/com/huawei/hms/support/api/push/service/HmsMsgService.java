/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.Notification$Builder
 *  android.app.NotificationChannel
 *  android.app.NotificationManager
 *  android.app.Service
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.Messenger
 */
package com.huawei.hms.support.api.push.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Messenger;
import com.huawei.hms.push.c;
import com.huawei.hms.push.i;
import com.huawei.hms.push.t;
import com.huawei.hms.support.api.push.service.HmsMsgService$a;
import com.huawei.hms.support.log.HMSLog;

public class HmsMsgService
extends Service {
    public static /* synthetic */ void a(Context context, Bundle bundle) {
        HmsMsgService.c(context, bundle);
    }

    public static /* synthetic */ void b(Context context, Bundle bundle) {
        HmsMsgService.d(context, bundle);
    }

    public static void c(Context context, Bundle object) {
        String string2;
        CharSequence charSequence;
        boolean bl2 = t.a(context);
        String string3 = "HmsMsgService";
        if (!bl2) {
            charSequence = new StringBuilder();
            string2 = context.getPackageName();
            charSequence.append(string2);
            string2 = " disable display notification.";
            charSequence.append(string2);
            charSequence = charSequence.toString();
            HMSLog.i(string3, (String)charSequence);
        }
        charSequence = new Intent();
        charSequence.setAction("com.huawei.push.msg.NOTIFY_MSG");
        string2 = "selfshow_info";
        byte[] byArray = c.a(object, string2);
        charSequence.putExtra(string2, byArray);
        string2 = "selfshow_token";
        byArray = c.a(object, string2);
        charSequence.putExtra(string2, byArray);
        object = c.c(object, "push_package");
        charSequence.setPackage((String)object);
        i.a(context, (Intent)charSequence);
        HMSLog.i(string3, "invokeSelfShow done");
    }

    public static void d(Context object, Bundle object2) {
        String string2 = "msgIdStr";
        String string3 = "device_token";
        Object object3 = "msg_data";
        String string4 = "HmsMsgService";
        Intent intent = new Intent();
        Object object4 = "com.huawei.android.push.intent.RECEIVE";
        intent.setAction((String)object4);
        object4 = c.a((Bundle)object2, (String)object3);
        intent.putExtra((String)object3, (byte[])object4);
        object3 = c.a((Bundle)object2, string3);
        intent.putExtra(string3, (byte[])object3);
        string3 = c.c((Bundle)object2, string2);
        intent.putExtra(string2, string3);
        int n10 = 32;
        intent.setFlags(n10);
        string2 = "push_package";
        object2 = c.c((Bundle)object2, string2);
        intent.setPackage((String)object2);
        object2 = new StringBuilder();
        string2 = object.getPackageName();
        ((StringBuilder)object2).append(string2);
        string2 = ".permission.PROCESS_PUSH_MSG";
        ((StringBuilder)object2).append(string2);
        object2 = ((StringBuilder)object2).toString();
        object.sendBroadcast(intent, (String)object2);
        object = "send broadcast passby done";
        try {
            HMSLog.i(string4, (String)object);
        }
        catch (Exception exception) {
            object = "send broadcast Exception";
            HMSLog.i(string4, (String)object);
        }
        catch (SecurityException securityException) {
            object = "send broadcast SecurityException";
            HMSLog.i(string4, (String)object);
        }
    }

    public IBinder onBind(Intent intent) {
        HMSLog.i("HmsMsgService", "onBind");
        HmsMsgService$a hmsMsgService$a = new HmsMsgService$a((Context)this);
        Messenger messenger = new Messenger((Handler)hmsMsgService$a);
        this.stopService(intent);
        return messenger.getBinder();
    }

    public void onDestroy() {
        super.onDestroy();
        int bl2 = Build.VERSION.SDK_INT;
        int n10 = 26;
        if (bl2 >= n10) {
            boolean bl3 = true;
            this.stopForeground(bl3);
        }
    }

    public int onStartCommand(Intent object, int n10, int n11) {
        object = "HmsMsgService";
        String string2 = "Enter onStartCommand.";
        HMSLog.i((String)object, string2);
        int n12 = Build.VERSION.SDK_INT;
        n10 = 26;
        if (n12 >= n10) {
            String string3 = "HwPushChannelID";
            String string4 = "pushKit";
            object = new NotificationChannel(string3, (CharSequence)string4, 3);
            n10 = 0;
            object.enableVibration(false);
            string2 = (NotificationManager)this.getSystemService("notification");
            if (string2 != null) {
                string2.createNotificationChannel((NotificationChannel)object);
            }
            object = new Notification.Builder((Context)this, string3);
            n10 = 1;
            object.setAutoCancel(n10 != 0);
            object = object.build();
            this.startForeground(n10, (Notification)object);
        }
        return 2;
    }
}

