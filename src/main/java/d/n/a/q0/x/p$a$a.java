/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 */
package d.n.a.q0.x;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import d.n.a.q0.x.p$a;
import e.a.b0;

public class p$a$a
extends BroadcastReceiver {
    public final /* synthetic */ b0 a;
    public final /* synthetic */ p$a b;

    public p$a$a(p$a a10, b0 b02) {
        this.b = a10;
        this.a = b02;
    }

    public void onReceive(Context object, Intent object2) {
        boolean bl2 = this.b.a.b.a();
        object2 = this.a;
        object = bl2;
        object2.onNext(object);
    }
}

