/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 */
package d.n.a.q0.x;

import android.content.BroadcastReceiver;
import android.content.Context;
import d.n.a.q0.x.p$a;
import e.a.v0.f;

public class p$a$b
implements f {
    public final /* synthetic */ BroadcastReceiver a;
    public final /* synthetic */ p$a b;

    public p$a$b(p$a p$a, BroadcastReceiver broadcastReceiver) {
        this.b = p$a;
        this.a = broadcastReceiver;
    }

    public void cancel() {
        Context context = this.b.a.a;
        BroadcastReceiver broadcastReceiver = this.a;
        context.unregisterReceiver(broadcastReceiver);
    }
}

