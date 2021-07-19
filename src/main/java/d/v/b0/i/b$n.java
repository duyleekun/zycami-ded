/*
 * Decompiled with CFR 0.151.
 */
package d.v.b0.i;

import d.v.b0.i.b;

public class b$n
implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ b b;

    public b$n(b b10, boolean bl2) {
        this.b = b10;
        this.a = bl2;
    }

    public void run() {
        Object object = this.b;
        int n10 = this.a;
        d.v.b0.i.b.v0((b)object, n10 != 0);
        object = d.v.b0.i.b.U0(this.b);
        n10 = this.a;
        if (n10 != 0) {
            b b10 = this.b;
            n10 = d.v.b0.i.b.w0(b10);
        } else {
            n10 = 0;
            Object var3_4 = null;
        }
        object[1] = n10;
    }
}

