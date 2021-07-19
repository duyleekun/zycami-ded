/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Process
 */
package d.c.a.o.k;

import android.os.Process;
import d.c.a.o.k.a$a;

public class a$a$a
implements Runnable {
    public final /* synthetic */ Runnable a;
    public final /* synthetic */ a.a b;

    public a$a$a(a.a a10, Runnable runnable) {
        this.b = a10;
        this.a = runnable;
    }

    public void run() {
        Process.setThreadPriority((int)10);
        this.a.run();
    }
}

