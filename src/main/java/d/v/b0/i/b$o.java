/*
 * Decompiled with CFR 0.151.
 */
package d.v.b0.i;

import com.faceunity.wrapper.faceunity;
import d.v.b0.i.b;

public class b$o
implements Runnable {
    public final /* synthetic */ float a;
    public final /* synthetic */ b b;

    public b$o(b b10, float f10) {
        this.b = b10;
        this.a = f10;
    }

    public void run() {
        int[] nArray = d.v.b0.i.b.U0(this.b);
        int n10 = 5;
        float f10 = 7.0E-45f;
        int n11 = nArray[n10];
        if (n11 > 0) {
            f10 = this.a;
            double d10 = f10;
            String string2 = "warp_intensity";
            faceunity.fuItemSetParam(n11, string2, d10);
        }
    }
}

