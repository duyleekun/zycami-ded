/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.IntentFilter
 */
package d.n.a.q0.x;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import d.n.a.q0.x.p;
import d.n.a.q0.x.p$a$a;
import d.n.a.q0.x.p$a$b;
import e.a.b0;
import e.a.c0;
import e.a.v0.f;

public class p$a
implements c0 {
    public final /* synthetic */ p a;

    public p$a(p p10) {
        this.a = p10;
    }

    public void subscribe(b0 b02) {
        boolean bl2 = this.a.b.a();
        p$a$a p$a$a = new p$a$a(this, b02);
        Object object = bl2;
        b02.onNext(object);
        object = this.a.a;
        IntentFilter intentFilter = new IntentFilter("android.location.MODE_CHANGED");
        object.registerReceiver((BroadcastReceiver)p$a$a, intentFilter);
        object = new p$a$b(this, p$a$a);
        b02.setCancellable((f)object);
    }
}

