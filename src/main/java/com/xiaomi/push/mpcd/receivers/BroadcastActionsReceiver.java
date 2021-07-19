/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 */
package com.xiaomi.push.mpcd.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.push.dw;

public class BroadcastActionsReceiver
extends BroadcastReceiver {
    private dw a;

    public BroadcastActionsReceiver(dw dw2) {
        this.a = dw2;
    }

    public void onReceive(Context context, Intent intent) {
        dw dw2 = this.a;
        if (dw2 != null) {
            dw2.a(context, intent);
        }
    }
}

