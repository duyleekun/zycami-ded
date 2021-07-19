/*
 * Decompiled with CFR 0.151.
 */
package d.v.b0.i;

import com.faceunity.wrapper.faceunity;
import d.v.b0.i.b;

public class b$g
implements Runnable {
    public final /* synthetic */ double[] a;
    public final /* synthetic */ b b;

    public b$g(b b10, double[] dArray) {
        this.b = b10;
        this.a = dArray;
    }

    public void run() {
        Object object = this.b;
        double[] dArray = this.a;
        d.v.b0.i.b.n0((b)object, dArray);
        object = d.v.b0.i.b.U0(this.b);
        int n10 = 1;
        Object object2 = object[n10];
        if (object2 > 0) {
            dArray = this.a;
            String string2 = "key_color";
            faceunity.fuItemSetParam((int)object2, string2, dArray);
        }
    }
}

