/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.util.Log
 */
package d.c.a.p;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import d.c.a.p.e;

public class e$a
extends BroadcastReceiver {
    public final /* synthetic */ e a;

    public e$a(e e10) {
        this.a = e10;
    }

    public void onReceive(Context object, Intent object2) {
        boolean bl2;
        object2 = this.a;
        boolean bl3 = ((e)object2).c;
        ((e)object2).c = bl2 = ((e)object2).b((Context)object);
        object = this.a;
        bl2 = ((e)object).c;
        if (bl3 != bl2) {
            object2 = "ConnectivityMonitor";
            bl2 = Log.isLoggable((String)object2, (int)3);
            if (bl2) {
                object = new StringBuilder();
                ((StringBuilder)object).append("connectivity changed, isConnected: ");
                e e10 = this.a;
                bl3 = e10.c;
                ((StringBuilder)object).append(bl3);
                object = ((StringBuilder)object).toString();
                Log.d((String)object2, (String)object);
            }
            object = this.a;
            object2 = ((e)object).b;
            bl2 = ((e)object).c;
            object2.a(bl2);
        }
    }
}

