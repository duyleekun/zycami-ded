/*
 * Decompiled with CFR 0.151.
 */
package d.v.b0.i;

import com.faceunity.wrapper.faceunity;
import d.v.b0.i.b;

public class b$a
implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ b b;

    public b$a(b b10, int n10) {
        this.b = b10;
        this.a = n10;
    }

    public void run() {
        Object object = this.b;
        int n10 = this.a;
        d.v.b0.i.b.k0((b)object, n10);
        object = d.v.b0.i.b.U0(this.b);
        int n11 = ((Object)object).length;
        n10 = 2;
        if (n11 <= n10) {
            return;
        }
        n11 = d.v.b0.i.b.j0(this.b);
        faceunity.fuSetDefaultRotationMode(n11);
        d.v.b0.i.b.T0(this.b, n11);
    }
}

