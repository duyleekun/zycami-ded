/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Message
 */
package com.mob.commons.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import com.mob.commons.a.d;
import com.mob.commons.a.k;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;

public class k$1
extends BroadcastReceiver {
    public final /* synthetic */ k a;

    public k$1(k k10) {
        this.a = k10;
    }

    public void onReceive(Context object, Intent object2) {
        block8: {
            String string2;
            boolean bl2;
            if (object2 != null && (bl2 = (string2 = "android.net.wifi.STATE_CHANGE").equals(object = object2.getAction()))) {
                object = "networkInfo";
                object = object2.getParcelableExtra((String)object);
                if (object == null) break block8;
                object2 = new Message();
                int n10 = 9;
                ((Message)object2).what = n10;
                ((Message)object2).obj = object;
                object = this.a;
                try {
                    ((d)object).b((Message)object2);
                }
                catch (Throwable throwable) {
                    object2 = MobLog.getInstance();
                    ((NLog)object2).w(throwable);
                }
            }
        }
    }
}

