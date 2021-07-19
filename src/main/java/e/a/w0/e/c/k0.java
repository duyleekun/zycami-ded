/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.c;

import e.a.q;
import e.a.s0.b;
import e.a.t;
import e.a.t0.a;
import e.a.v0.o;
import e.a.w;
import e.a.w0.e.c.c0$a;
import e.a.w0.e.c.k0$a;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.maybe.MaybeZipArray$ZipCoordinator;
import io.reactivex.internal.operators.maybe.MaybeZipArray$ZipMaybeObserver;
import java.util.Arrays;

public final class k0
extends q {
    public final Iterable a;
    public final o b;

    public k0(Iterable iterable, o o10) {
        this.a = iterable;
        this.b = o10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void t1(t object) {
        int n10;
        k0$a k0$a;
        int n11;
        Object object2;
        Object object3;
        block9: {
            int n12 = 8;
            object3 = new w[n12];
            try {
                boolean bl2;
                object2 = this.a;
                object2 = object2.iterator();
                n11 = 0;
                k0$a = null;
                n10 = 0;
                while (bl2 = object2.hasNext()) {
                    Object e10 = object2.next();
                    w w10 = (w)e10;
                    if (w10 == null) {
                        object2 = "One of the sources is null";
                        object3 = new NullPointerException((String)object2);
                        EmptyDisposable.error((Throwable)object3, (t)object);
                        return;
                    }
                    int n13 = ((w[])object3).length;
                    if (n10 == n13) {
                        n13 = (n10 >> 2) + n10;
                        object3 = Arrays.copyOf(object3, n13);
                        object3 = (w[])object3;
                    }
                    n13 = n10 + 1;
                    object3[n10] = w10;
                    n10 = n13;
                }
                if (n10 != 0) break block9;
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                EmptyDisposable.error(throwable, (t)object);
                return;
            }
            EmptyDisposable.complete((t)object);
            return;
        }
        int n14 = 1;
        if (n10 == n14) {
            object3 = object3[0];
            k0$a = new k0$a(this);
            object2 = new c0$a((t)object, k0$a);
            object3.g((t)object2);
            return;
        }
        o o10 = this.b;
        object2 = new MaybeZipArray$ZipCoordinator((t)object, n10, o10);
        object.onSubscribe((b)object2);
        while (n11 < n10) {
            boolean bl3 = ((MaybeZipArray$ZipCoordinator)object2).isDisposed();
            if (bl3) {
                return;
            }
            object = object3[n11];
            MaybeZipArray$ZipMaybeObserver maybeZipArray$ZipMaybeObserver = ((MaybeZipArray$ZipCoordinator)object2).observers[n11];
            object.g(maybeZipArray$ZipMaybeObserver);
            ++n11;
        }
        return;
    }
}

