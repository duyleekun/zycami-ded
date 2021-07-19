/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.e0;
import e.a.g0;
import e.a.v0.b;
import e.a.w0.e.e.a;
import e.a.w0.e.e.n$a;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

public final class n
extends a {
    public final Callable b;
    public final b c;

    public n(e0 e02, Callable callable, b b10) {
        super(e02);
        this.b = callable;
        this.c = b10;
    }

    public void K5(g0 g02) {
        Object object;
        try {
            object = this.b;
        }
        catch (Throwable throwable) {
            EmptyDisposable.error(throwable, g02);
            return;
        }
        object = object.call();
        Object object2 = "The initialSupplier returned a null value";
        object = e.a.w0.b.a.g(object, (String)object2);
        object2 = this.a;
        b b10 = this.c;
        n$a n$a = new n$a(g02, object, b10);
        object2.subscribe(n$a);
    }
}

