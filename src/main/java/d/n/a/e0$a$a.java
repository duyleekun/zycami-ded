/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 */
package d.n.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import d.n.a.e0;
import d.n.a.e0$a;
import d.n.a.q0.p;
import e.a.b0;

public class e0$a$a
extends BroadcastReceiver {
    public final /* synthetic */ b0 a;
    public final /* synthetic */ e0.a b;

    public e0$a$a(e0.a a10, b0 b02) {
        this.b = a10;
        this.a = b02;
    }

    public void onReceive(Context object, Intent objectArray) {
        object = e0.h8(objectArray.getIntExtra("android.bluetooth.adapter.extra.STATE", -1));
        objectArray = new Object[]{object};
        p.k("Adapter state changed: %s", objectArray);
        this.a.onNext(object);
    }
}

