/*
 * Decompiled with CFR 0.151.
 */
package d.v.b0.i;

import com.faceunity.wrapper.faceunity;
import d.v.b0.i.a;

public class a$e
implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ a b;

    public a$e(a a10, int n10) {
        this.b = a10;
        this.a = n10;
    }

    public void run() {
        a a10 = this.b;
        int n10 = this.a;
        d.v.b0.i.a.g(a10, n10);
        int n11 = d.v.b0.i.a.e(this.b);
        faceunity.fuSetDefaultRotationMode(n11);
        d.v.b0.i.a.d(this.b, n11);
    }
}

