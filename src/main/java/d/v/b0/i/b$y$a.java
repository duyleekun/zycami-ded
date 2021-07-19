/*
 * Decompiled with CFR 0.151.
 */
package d.v.b0.i;

import com.faceunity.wrapper.faceunity;
import d.v.b0.i.b;
import d.v.b0.i.b$y;

public class b$y$a
implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ b$y b;

    public b$y$a(b$y y10, int n10) {
        this.b = y10;
        this.a = n10;
    }

    public void run() {
        int n10;
        int[] nArray = d.v.b0.i.b.U0(this.b.a);
        int n11 = nArray[0];
        if (n11 > 0) {
            n11 = d.v.b0.i.b.U0(this.b.a)[0];
            faceunity.fuDestroyItem(n11);
            nArray = d.v.b0.i.b.U0(this.b.a);
            nArray[0] = 0;
        }
        nArray = d.v.b0.i.b.U0(this.b.a);
        nArray[0] = n10 = this.a;
        d.v.b0.i.b.Q0(this.b.a, true);
    }
}

