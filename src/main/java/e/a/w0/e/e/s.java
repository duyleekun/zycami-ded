/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.e0;
import e.a.g0;
import e.a.w0.b.a;
import e.a.z;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

public final class s
extends z {
    public final Callable a;

    public s(Callable callable) {
        this.a = callable;
    }

    public void K5(g0 g02) {
        Object object;
        try {
            object = this.a;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            EmptyDisposable.error(throwable, g02);
            return;
        }
        object = object.call();
        String string2 = "null ObservableSource supplied";
        object = e.a.w0.b.a.g(object, string2);
        ((e0)object).subscribe(g02);
    }
}

