/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 */
package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.api.internal.zabr;

public final class zabq
extends BroadcastReceiver {
    private Context mContext;
    private final zabr zaji;

    public zabq(zabr zabr2) {
        this.zaji = zabr2;
    }

    public final void onReceive(Context object, Intent object2) {
        boolean bl2;
        object = object2.getData();
        if (object != null) {
            object = object.getSchemeSpecificPart();
        } else {
            bl2 = false;
            object = null;
        }
        object2 = "com.google.android.gms";
        bl2 = ((String)object2).equals(object);
        if (bl2) {
            object = this.zaji;
            ((zabr)object).zas();
            this.unregister();
        }
    }

    public final void unregister() {
        synchronized (this) {
            Context context;
            block5: {
                context = this.mContext;
                if (context == null) break block5;
                context.unregisterReceiver((BroadcastReceiver)this);
            }
            context = null;
            this.mContext = null;
            return;
        }
    }

    public final void zac(Context context) {
        this.mContext = context;
    }
}

