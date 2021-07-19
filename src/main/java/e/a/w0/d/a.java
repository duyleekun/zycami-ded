/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.d;

import e.a.g0;
import e.a.s0.b;
import e.a.w0.c.j;
import io.reactivex.internal.disposables.DisposableHelper;

public abstract class a
implements g0,
j {
    public final g0 a;
    public b b;
    public j c;
    public boolean d;
    public int e;

    public a(g0 g02) {
        this.a = g02;
    }

    public void a() {
    }

    public boolean b() {
        return true;
    }

    public final void c(Throwable throwable) {
        e.a.t0.a.b(throwable);
        this.b.dispose();
        this.onError(throwable);
    }

    public void clear() {
        this.c.clear();
    }

    public final int d(int n10) {
        int n11;
        j j10 = this.c;
        if (j10 != null && (n11 = n10 & 4) == 0) {
            if ((n10 = j10.requestFusion(n10)) != 0) {
                this.e = n10;
            }
            return n10;
        }
        return 0;
    }

    public void dispose() {
        this.b.dispose();
    }

    public boolean isDisposed() {
        return this.b.isDisposed();
    }

    public boolean isEmpty() {
        return this.c.isEmpty();
    }

    public final boolean offer(Object object) {
        object = new UnsupportedOperationException("Should not be called!");
        throw object;
    }

    public final boolean offer(Object object, Object object2) {
        object = new UnsupportedOperationException("Should not be called!");
        throw object;
    }

    public void onComplete() {
        boolean bl2 = this.d;
        if (bl2) {
            return;
        }
        this.d = true;
        this.a.onComplete();
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.d;
        if (bl2) {
            e.a.a1.a.Y(throwable);
            return;
        }
        this.d = true;
        this.a.onError(throwable);
    }

    public final void onSubscribe(b object) {
        b b10 = this.b;
        boolean bl2 = DisposableHelper.validate(b10, (b)object);
        if (bl2) {
            boolean bl3;
            this.b = object;
            bl2 = object instanceof j;
            if (bl2) {
                object = (j)object;
                this.c = object;
            }
            if (bl3 = this.b()) {
                object = this.a;
                object.onSubscribe(this);
                this.a();
            }
        }
    }
}

