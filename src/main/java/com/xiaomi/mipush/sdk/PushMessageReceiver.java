/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 */
package com.xiaomi.mipush.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.MessageHandleService;
import com.xiaomi.mipush.sdk.MessageHandleService$a;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.push.fb;

public abstract class PushMessageReceiver
extends BroadcastReceiver {
    public void onCommandResult(Context context, MiPushCommandMessage miPushCommandMessage) {
    }

    public void onNotificationMessageArrived(Context context, MiPushMessage miPushMessage) {
    }

    public void onNotificationMessageClicked(Context context, MiPushMessage miPushMessage) {
    }

    public final void onReceive(Context object, Intent intent) {
        block11: {
            int n10;
            int n11;
            Object object2;
            block10: {
                object2 = object.getApplicationContext();
                MessageHandleService$a messageHandleService$a = new MessageHandleService$a(intent, this);
                MessageHandleService.addJob((Context)object2, messageHandleService$a);
                object2 = "eventMessageType";
                n11 = -1;
                n10 = intent.getIntExtra((String)object2, n11);
                n11 = 2000;
                if (n10 != n11) break block10;
                object2 = object.getApplicationContext();
                object2 = fb.a((Context)object2);
                object = object.getPackageName();
                n11 = 2003;
                ((fb)object2).a((String)object, intent, n11, null);
            }
            n11 = 6000;
            if (n10 != n11) break block11;
            object2 = object.getApplicationContext();
            object2 = fb.a((Context)object2);
            object = object.getPackageName();
            n11 = 6005;
            try {
                ((fb)object2).a((String)object, intent, n11, null);
            }
            catch (Exception exception) {
                b.a(exception);
            }
        }
    }

    public void onReceiveMessage(Context context, MiPushMessage miPushMessage) {
    }

    public void onReceivePassThroughMessage(Context context, MiPushMessage miPushMessage) {
    }

    public void onReceiveRegisterResult(Context context, MiPushCommandMessage miPushCommandMessage) {
    }

    public void onRequirePermissions(Context context, String[] stringArray) {
    }
}

