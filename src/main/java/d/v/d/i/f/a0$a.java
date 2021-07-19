/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package d.v.d.i.f;

import android.os.Handler;
import d.v.d.i.f.a0;

public class a0$a
implements Runnable {
    public final /* synthetic */ a0 a;

    public a0$a(a0 a02) {
        this.a = a02;
    }

    public void run() {
        this.a.y(1.05f);
        Handler handler = a0.p(this.a);
        Runnable runnable = a0.n(this.a);
        long l10 = a0.o(this.a);
        handler.postDelayed(runnable, l10);
    }
}

