/*
 * Decompiled with CFR 0.151.
 */
package d.v.b0.i;

import com.faceunity.wrapper.faceunity;
import d.v.b0.i.b;

public class b$c
implements Runnable {
    public final /* synthetic */ long a;
    public final /* synthetic */ b b;

    public b$c(b b10, long l10) {
        this.b = b10;
        this.a = l10;
    }

    public void run() {
        int n10;
        int[] nArray = d.v.b0.i.b.U0(this.b);
        int n11 = nArray[n10 = 1];
        if (n11 > 0) {
            long l10 = this.a;
            double d10 = l10;
            String string2 = "music_time";
            faceunity.fuItemSetParam(n11, string2, d10);
        }
    }
}

