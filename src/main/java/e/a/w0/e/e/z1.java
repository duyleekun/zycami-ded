/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.g0;
import e.a.v0.c;
import e.a.w0.b.a;
import e.a.w0.e.e.z1$a;
import e.a.z;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Iterator;

public final class z1
extends z {
    public final z a;
    public final Iterable b;
    public final c c;

    public z1(z z10, Iterable iterable, c c10) {
        this.a = z10;
        this.b = iterable;
        this.c = c10;
    }

    public void K5(g0 g02) {
        Object object;
        Object object2;
        block7: {
            try {
                object2 = this.b;
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                EmptyDisposable.error(throwable, g02);
                return;
            }
            object2 = object2.iterator();
            object = "The iterator returned by other is null";
            object2 = e.a.w0.b.a.g(object2, (String)object);
            object2 = (Iterator)object2;
            try {
                boolean bl2 = object2.hasNext();
                if (bl2) break block7;
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                EmptyDisposable.error(throwable, g02);
                return;
            }
            EmptyDisposable.complete(g02);
            return;
        }
        object = this.a;
        c c10 = this.c;
        z1$a z1$a = new z1$a(g02, (Iterator)object2, c10);
        ((z)object).subscribe(z1$a);
    }
}

