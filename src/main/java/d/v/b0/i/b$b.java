/*
 * Decompiled with CFR 0.151.
 */
package d.v.b0.i;

import com.faceunity.wrapper.faceunity;
import d.v.b0.i.b;

public class b$b
implements Runnable {
    public final /* synthetic */ b a;

    public b$b(b b10) {
        this.a = b10;
    }

    public void run() {
        int n10 = b.j0(this.a);
        faceunity.fuSetDefaultRotationMode(n10);
        b.T0(this.a, n10);
    }
}

