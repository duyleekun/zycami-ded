/*
 * Decompiled with CFR 0.151.
 */
package d.v.b0.i;

import com.faceunity.wrapper.faceunity;
import d.v.b0.i.b;

public class b$u
implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ b b;

    public b$u(b b10, int n10) {
        this.b = b10;
        this.a = n10;
    }

    public void run() {
        faceunity.fuSetMultiSamples(this.a);
    }
}

