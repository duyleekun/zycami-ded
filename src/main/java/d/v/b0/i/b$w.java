/*
 * Decompiled with CFR 0.151.
 */
package d.v.b0.i;

import com.faceunity.wrapper.faceunity;
import d.v.b0.i.b;

public class b$w
implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ b c;

    public b$w(b b10, int n10, int n11) {
        this.c = b10;
        this.a = n10;
        this.b = n11;
    }

    public void run() {
        d.v.b0.i.b.f0(this.c, 0);
        Object object = this.c;
        int n10 = this.a;
        d.v.b0.i.b.h0((b)object, n10);
        object = this.c;
        n10 = this.b;
        d.v.b0.i.b.i0((b)object, n10);
        d.v.b0.i.b.g0(this.c);
        object = this.c;
        n10 = d.v.b0.i.b.j0((b)object);
        d.v.b0.i.b.T0((b)object, n10);
        object = d.v.b0.i.b.U0(this.c);
        int n11 = ((Object)object).length;
        n10 = 2;
        if (n11 <= n10) {
            faceunity.fuSetDefaultRotationMode(0);
        } else {
            object = this.c;
            n11 = d.v.b0.i.b.S0((b)object);
            faceunity.fuSetDefaultRotationMode(n11);
        }
    }
}

