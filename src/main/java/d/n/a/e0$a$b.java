/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 */
package d.n.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import d.n.a.e0$a;
import e.a.v0.f;

public class e0$a$b
implements f {
    public final /* synthetic */ BroadcastReceiver a;
    public final /* synthetic */ e0$a b;

    public e0$a$b(e0$a e0$a, BroadcastReceiver broadcastReceiver) {
        this.b = e0$a;
        this.a = broadcastReceiver;
    }

    public void cancel() {
        Context context = this.b.a;
        BroadcastReceiver broadcastReceiver = this.a;
        context.unregisterReceiver(broadcastReceiver);
    }
}

