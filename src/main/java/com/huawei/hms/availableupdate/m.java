/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Handler
 *  android.os.Message
 */
package com.huawei.hms.availableupdate;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.huawei.hms.ui.SafeIntent;

public class m
extends BroadcastReceiver {
    public Handler a;

    public m(Handler handler) {
        this.a = handler;
    }

    public void onReceive(Context object, Intent object2) {
        if (object2 == null) {
            return;
        }
        String string2 = "com.huawei.appmarket.service.downloadservice.Receiver";
        object = new SafeIntent((Intent)object2);
        int n10 = string2.equals(object2 = object.getAction());
        if (n10 != 0) {
            if ((object = object.getExtras()) == null) {
                return;
            }
            object2 = new Message();
            object2.what = n10 = 101;
            object2.obj = object;
            object = this.a;
            object.sendMessage((Message)object2);
        } else {
            string2 = "com.huawei.appmarket.service.downloadservice.progress.Receiver";
            n10 = string2.equals(object2);
            if (n10 != 0) {
                if ((object = object.getExtras()) == null) {
                    return;
                }
                object2 = new Message();
                object2.what = n10 = 102;
                object2.obj = object;
                object = this.a;
                object.sendMessage((Message)object2);
            } else {
                string2 = "com.huawei.appmarket.service.installerservice.Receiver";
                boolean bl2 = string2.equals(object2);
                if (bl2) {
                    if ((object = object.getExtras()) == null) {
                        return;
                    }
                    object2 = new Message();
                    object2.what = n10 = 103;
                    object2.obj = object;
                    object = this.a;
                    object.sendMessage((Message)object2);
                }
            }
        }
    }
}

