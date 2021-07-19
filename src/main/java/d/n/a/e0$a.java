/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.IntentFilter
 */
package d.n.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import d.n.a.e0;
import d.n.a.e0$a$a;
import d.n.a.e0$a$b;
import e.a.b0;
import e.a.c0;
import e.a.v0.f;

public class e0$a
implements c0 {
    public final /* synthetic */ Context a;
    public final /* synthetic */ e0 b;

    public e0$a(e0 e02, Context context) {
        this.b = e02;
        this.a = context;
    }

    public void subscribe(b0 b02) {
        e0$a$a e0$a$a = new e0$a$a(this, b02);
        Object object = this.a;
        IntentFilter intentFilter = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
        object.registerReceiver((BroadcastReceiver)e0$a$a, intentFilter);
        object = new e0$a$b(this, e0$a$a);
        b02.setCancellable((f)object);
    }
}

