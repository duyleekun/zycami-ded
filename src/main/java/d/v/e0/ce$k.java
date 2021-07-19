/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.stabilizer.Stabilizer;
import d.v.e0.ce;
import d.v.e0.ie.j;
import e.a.g0;
import e.a.s0.b;

public class ce$k
implements g0 {
    public final /* synthetic */ j a;
    public final /* synthetic */ ce b;

    public ce$k(ce ce2, j j10) {
        this.b = ce2;
        this.a = j10;
    }

    public void a(Stabilizer stabilizer) {
        this.a.g(stabilizer);
    }

    public void onComplete() {
        this.a.j();
    }

    public void onError(Throwable throwable) {
        ce ce2 = this.b;
        j j10 = this.a;
        ce.m(ce2, throwable, j10);
    }

    public void onSubscribe(b b10) {
        ce.c(this.b, b10);
        this.a.f();
    }
}

