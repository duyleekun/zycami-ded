/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.a1.a;
import e.a.i0;
import e.a.j;
import e.a.l0;
import e.a.w0.c.b;
import e.a.w0.e.b.l$a;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.flowable.FlowableCollect;
import java.util.concurrent.Callable;

public final class l
extends i0
implements b {
    public final j a;
    public final Callable b;
    public final e.a.v0.b c;

    public l(j j10, Callable callable, e.a.v0.b b10) {
        this.a = j10;
        this.b = callable;
        this.c = b10;
    }

    public void e1(l0 l02) {
        Object object;
        try {
            object = this.b;
        }
        catch (Throwable throwable) {
            EmptyDisposable.error(throwable, l02);
            return;
        }
        object = object.call();
        Object object2 = "The initialSupplier returned a null value";
        object = e.a.w0.b.a.g(object, (String)object2);
        object2 = this.a;
        e.a.v0.b b10 = this.c;
        l$a l$a = new l$a(l02, object, b10);
        ((j)object2).l6(l$a);
    }

    public j l() {
        j j10 = this.a;
        Callable callable = this.b;
        e.a.v0.b b10 = this.c;
        FlowableCollect flowableCollect = new FlowableCollect(j10, callable, b10);
        return e.a.a1.a.P(flowableCollect);
    }
}

