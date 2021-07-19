/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 */
package d.c.a.o.k;

import android.os.Handler;
import android.os.Looper;
import d.c.a.o.k.s;
import d.c.a.o.k.v$a;

public class v {
    private boolean a;
    private final Handler b;

    public v() {
        Handler handler;
        Looper looper = Looper.getMainLooper();
        v$a v$a = new v$a();
        this.b = handler = new Handler(looper, (Handler.Callback)v$a);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(s s10, boolean bl2) {
        synchronized (this) {
            void var2_2;
            boolean bl3 = this.a;
            int n10 = 1;
            if (!bl3 && var2_2 == false) {
                this.a = n10;
                s10.recycle();
                s10 = null;
                this.a = false;
            } else {
                Handler handler = this.b;
                s10 = handler.obtainMessage(n10, (Object)s10);
                s10.sendToTarget();
            }
            return;
        }
    }
}

