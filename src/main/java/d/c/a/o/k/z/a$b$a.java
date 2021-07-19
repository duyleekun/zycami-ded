/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Process
 *  android.os.StrictMode
 *  android.os.StrictMode$ThreadPolicy
 *  android.os.StrictMode$ThreadPolicy$Builder
 */
package d.c.a.o.k.z;

import android.os.Process;
import android.os.StrictMode;
import d.c.a.o.k.z.a$b;
import d.c.a.o.k.z.a$c;

public class a$b$a
extends Thread {
    public final /* synthetic */ a$b a;

    public a$b$a(a$b a$b, Runnable runnable, String string2) {
        this.a = a$b;
        super(runnable, string2);
    }

    public void run() {
        Process.setThreadPriority((int)9);
        a$b a$b = this.a;
        boolean bl2 = a$b.c;
        if (bl2) {
            a$b = new StrictMode.ThreadPolicy.Builder();
            a$b = a$b.detectNetwork().penaltyDeath().build();
            StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)a$b);
        }
        try {
            super.run();
        }
        catch (Throwable throwable) {
            a$c a$c = this.a.b;
            a$c.a(throwable);
        }
    }
}

