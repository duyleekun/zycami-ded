/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.util.Log
 */
package d.v.e0.je;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.util.Log;
import d.v.e0.je.e$a;
import e.a.v0.a;

public class e$a$b
implements a {
    public final /* synthetic */ BroadcastReceiver a;
    public final /* synthetic */ e$a b;

    public e$a$b(e$a e$a, BroadcastReceiver broadcastReceiver) {
        this.b = e$a;
        this.a = broadcastReceiver;
    }

    public void run() {
        Log.i((String)"BluetoothDevice", (String)"Unregister bluetooth bond");
        Context context = this.b.b;
        BroadcastReceiver broadcastReceiver = this.a;
        context.unregisterReceiver(broadcastReceiver);
    }
}

