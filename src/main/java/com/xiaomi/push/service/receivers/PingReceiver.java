/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.text.TextUtils
 */
package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.fc;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.at;
import com.xiaomi.push.service.bb;

public class PingReceiver
extends BroadcastReceiver {
    public void onReceive(Context object, Intent object2) {
        Object object3 = new StringBuilder();
        String string2 = object2.getPackage();
        ((StringBuilder)object3).append(string2);
        ((StringBuilder)object3).append(" is the package name");
        b.c(((StringBuilder)object3).toString());
        object3 = at.o;
        string2 = object2.getAction();
        boolean bl2 = ((String)object3).equals(string2);
        if (bl2) {
            object3 = object.getPackageName();
            boolean bl3 = TextUtils.equals((CharSequence)object3, (CharSequence)(object2 = object2.getPackage()));
            if (bl3) {
                object2 = "Ping XMChannelService on timer";
                b.c((String)object2);
                object3 = XMPushService.class;
                object2 = new Intent((Context)object, (Class)object3);
                object3 = "time_stamp";
                long l10 = System.currentTimeMillis();
                object2.putExtra((String)object3, l10);
                object3 = "com.xiaomi.push.timer";
                object2.setAction((String)object3);
                object = bb.a((Context)object);
                try {
                    ((bb)object).a((Intent)object2);
                }
                catch (Exception exception) {
                    b.a(exception);
                }
            }
        } else {
            object = "cancel the old ping timer";
            b.a((String)object);
            fc.a();
        }
    }
}

