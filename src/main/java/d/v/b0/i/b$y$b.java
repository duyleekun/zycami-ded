/*
 * Decompiled with CFR 0.151.
 */
package d.v.b0.i;

import com.faceunity.wrapper.faceunity;
import d.v.b0.i.b;
import d.v.b0.i.b$y;

public class b$y$b
implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ b$y b;

    public b$y$b(b$y b$y, int n10) {
        this.b = b$y;
        this.a = n10;
    }

    public void run() {
        int n10;
        int n11;
        int[] nArray = d.v.b0.i.b.U0(this.b.a);
        int n12 = nArray[n11 = 3];
        if (n12 > 0) {
            n12 = d.v.b0.i.b.U0(this.b.a)[n11];
            faceunity.fuDestroyItem(n12);
            nArray = d.v.b0.i.b.U0(this.b.a);
            n10 = 0;
            nArray[n11] = 0;
        }
        nArray = d.v.b0.i.b.U0(this.b.a);
        nArray[n11] = n10 = this.a;
    }
}

