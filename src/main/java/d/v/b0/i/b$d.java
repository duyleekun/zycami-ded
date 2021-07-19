/*
 * Decompiled with CFR 0.151.
 */
package d.v.b0.i;

import com.faceunity.wrapper.faceunity;
import d.v.b0.i.b;

public class b$d
implements Runnable {
    public final /* synthetic */ b a;

    public b$d(b b10) {
        this.a = b10;
    }

    public void run() {
        int[] nArray = b.U0(this.a);
        float f10 = 0.0f;
        int n10 = nArray[0];
        if (n10 > 0) {
            f10 = b.l0();
            double d10 = f10;
            String string2 = "is_beauty_on";
            faceunity.fuItemSetParam(n10, string2, d10);
        }
    }
}

