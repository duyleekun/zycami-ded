/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.g;

import e.a.i0;
import e.a.l0;
import e.a.o0;
import e.a.s0.b;
import e.a.t0.a;
import e.a.v0.o;
import e.a.w0.e.g.v$a;
import e.a.w0.e.g.z$a;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.single.SingleZipArray$ZipCoordinator;
import io.reactivex.internal.operators.single.SingleZipArray$ZipSingleObserver;
import java.util.Arrays;
import java.util.NoSuchElementException;

public final class z
extends i0 {
    public final Iterable a;
    public final o b;

    public z(Iterable iterable, o o10) {
        this.a = iterable;
        this.b = o10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void e1(l0 object) {
        int n10;
        z$a z$a;
        int n11;
        Object object2;
        Object object3;
        block9: {
            int n12 = 8;
            object3 = new o0[n12];
            try {
                boolean bl2;
                object2 = this.a;
                object2 = object2.iterator();
                n11 = 0;
                z$a = null;
                n10 = 0;
                while (bl2 = object2.hasNext()) {
                    Object e10 = object2.next();
                    o0 o02 = (o0)e10;
                    if (o02 == null) {
                        object2 = "One of the sources is null";
                        object3 = new NullPointerException((String)object2);
                        EmptyDisposable.error((Throwable)object3, (l0)object);
                        return;
                    }
                    int n13 = ((o0[])object3).length;
                    if (n10 == n13) {
                        n13 = (n10 >> 2) + n10;
                        object3 = Arrays.copyOf(object3, n13);
                        object3 = (o0[])object3;
                    }
                    n13 = n10 + 1;
                    object3[n10] = o02;
                    n10 = n13;
                }
                if (n10 != 0) break block9;
                object3 = new NoSuchElementException();
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                EmptyDisposable.error(throwable, (l0)object);
                return;
            }
            EmptyDisposable.error((Throwable)object3, (l0)object);
            return;
        }
        int n14 = 1;
        if (n10 == n14) {
            object3 = object3[0];
            z$a = new z$a(this);
            object2 = new v$a((l0)object, z$a);
            object3.f((l0)object2);
            return;
        }
        o o10 = this.b;
        object2 = new SingleZipArray$ZipCoordinator((l0)object, n10, o10);
        object.onSubscribe((b)object2);
        while (n11 < n10) {
            boolean bl3 = ((SingleZipArray$ZipCoordinator)object2).isDisposed();
            if (bl3) {
                return;
            }
            object = object3[n11];
            SingleZipArray$ZipSingleObserver singleZipArray$ZipSingleObserver = ((SingleZipArray$ZipCoordinator)object2).observers[n11];
            object.f(singleZipArray$ZipSingleObserver);
            ++n11;
        }
        return;
    }
}

