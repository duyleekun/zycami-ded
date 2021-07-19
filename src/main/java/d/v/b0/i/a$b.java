/*
 * Decompiled with CFR 0.151.
 */
package d.v.b0.i;

import com.faceunity.wrapper.faceunity;
import d.v.b0.i.a;
import d.v.b0.j.b;

public class a$b
implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ a c;

    public a$b(a a10, int n10, int n11) {
        this.c = a10;
        this.a = n10;
        this.b = n11;
    }

    public void run() {
        Object object = this.c;
        int n10 = this.a;
        d.v.b0.i.a.m((a)object, n10);
        object = this.c;
        n10 = this.b;
        d.v.b0.i.a.o((a)object, n10);
        d.v.b0.i.a.p(this.c, 0);
        d.v.b0.i.a.q(this.c);
        object = this.c;
        n10 = d.v.b0.i.a.e((a)object);
        d.v.b0.i.a.d((a)object, n10);
        object = new StringBuilder();
        ((StringBuilder)object).append("FuRender mInputOrientation: ");
        n10 = d.v.b0.i.a.n(this.c);
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append("  mDeviceOrientation:");
        n10 = d.v.b0.i.a.f(this.c);
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append("  mRotationMode:");
        n10 = d.v.b0.i.a.c(this.c);
        ((StringBuilder)object).append(n10);
        d.v.b0.j.b.a(((StringBuilder)object).toString());
        faceunity.fuSetDefaultRotationMode(d.v.b0.i.a.c(this.c));
    }
}

