/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0.ne;

import d.v.e0.ne.p0$a;
import d.v.e0.ne.p0$b;
import d.v.y.c.r0;
import e.a.b0;

public class p0$a$a
implements p0$b {
    public final /* synthetic */ b0 a;
    public final /* synthetic */ p0.a b;

    public p0$a$a(p0.a a10, b0 b02) {
        this.b = a10;
        this.a = b02;
    }

    public void a(r0 r02) {
        this.a.onNext(r02);
        this.a.onComplete();
    }

    public void onFailed(Throwable throwable) {
        this.a.tryOnError(throwable);
    }
}

