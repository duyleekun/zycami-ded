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
import com.mob.commons.a.o;

public class o$1
extends BroadcastReceiver {
    public final /* synthetic */ o a;

    public o$1(o o10) {
        this.a = o10;
    }

    public void onReceive(Context object, Intent object2) {
        boolean bl2;
        if (object2 != null) {
            object = object2.getAction();
        } else {
            bl2 = false;
            object = null;
        }
        object2 = this.a;
        bl2 = o.a((o)object2, (String)object);
        if (bl2) {
            object = this.a;
            int n10 = 1;
            ((d)object).a(n10);
            object = this.a;
            long l10 = 5000L;
            ((d)object).a(n10, l10);
        }
    }
}

