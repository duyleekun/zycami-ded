/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 */
package com.mob.commons.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.mob.commons.a.d;
import com.mob.commons.a.k;

public class k$2
extends BroadcastReceiver {
    public final /* synthetic */ k a;

    public k$2(k k10) {
        this.a = k10;
    }

    public void onReceive(Context object, Intent object2) {
        object = this.a;
        boolean bl2 = k.a((k)object);
        if (bl2 && (bl2 = ((String)(object2 = "android.net.wifi.SCAN_RESULTS")).equals(object = object2.getAction()))) {
            object = this.a;
            object2 = null;
            k.a((k)object, false);
            object = this.a;
            int n10 = 8;
            ((d)object).b(n10);
        }
    }
}

