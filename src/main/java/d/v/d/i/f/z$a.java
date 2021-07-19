/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package d.v.d.i.f;

import android.os.Handler;
import d.v.d.i.f.z;

public class z$a
implements Runnable {
    public final /* synthetic */ z a;

    public z$a(z z10) {
        this.a = z10;
    }

    public void run() {
        Handler handler = z.p(this.a);
        Runnable runnable = z.n(this.a);
        long l10 = z.o(this.a);
        handler.postDelayed(runnable, l10);
        this.a.A(1.05f);
    }
}

