/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.g0;
import e.a.t0.a;
import e.a.w0.e.e.m0$a;
import e.a.z;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Iterator;

public final class m0
extends z {
    public final Iterable a;

    public m0(Iterable iterable) {
        this.a = iterable;
    }

    public void K5(g0 g02) {
        Object object;
        block6: {
            try {
                object = this.a;
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                EmptyDisposable.error(throwable, g02);
                return;
            }
            object = object.iterator();
            try {
                boolean bl2 = object.hasNext();
                if (bl2) break block6;
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                EmptyDisposable.error(throwable, g02);
                return;
            }
            EmptyDisposable.complete(g02);
            return;
        }
        m0$a m0$a = new m0$a(g02, (Iterator)object);
        g02.onSubscribe(m0$a);
        boolean bl3 = m0$a.d;
        if (!bl3) {
            m0$a.a();
        }
    }
}

