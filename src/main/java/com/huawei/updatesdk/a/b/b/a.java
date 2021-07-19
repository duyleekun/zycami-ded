/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 */
package com.huawei.updatesdk.a.b.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.updatesdk.a.b.b.b;

public abstract class a
extends BroadcastReceiver {
    public abstract void a(Context var1, b var2);

    public final void onReceive(Context context, Intent object) {
        object = b.a(object);
        this.a(context, (b)object);
    }
}

