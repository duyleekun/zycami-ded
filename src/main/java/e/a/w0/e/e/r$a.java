/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.e0;
import e.a.g0;
import e.a.s0.b;
import e.a.v0.o;
import e.a.w0.b.a;
import e.a.w0.e.e.r$a$a;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class r$a
implements g0,
b {
    public final g0 a;
    public final o b;
    public b c;
    public final AtomicReference d;
    public volatile long e;
    public boolean f;

    public r$a(g0 g02, o o10) {
        AtomicReference atomicReference;
        this.d = atomicReference = new AtomicReference();
        this.a = g02;
        this.b = o10;
    }

    public void a(long l10, Object object) {
        long l11 = this.e;
        long l12 = l10 - l11;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 == false) {
            g0 g02 = this.a;
            g02.onNext(object);
        }
    }

    public void dispose() {
        this.c.dispose();
        DisposableHelper.dispose(this.d);
    }

    public boolean isDisposed() {
        return this.c.isDisposed();
    }

    public void onComplete() {
        DisposableHelper disposableHelper;
        boolean bl2 = this.f;
        if (bl2) {
            return;
        }
        this.f = bl2 = true;
        Object object = (b)this.d.get();
        if (object != (disposableHelper = DisposableHelper.DISPOSED)) {
            if ((object = (r$a$a)object) != null) {
                ((r$a$a)object).b();
            }
            DisposableHelper.dispose(this.d);
            object = this.a;
            object.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        DisposableHelper.dispose(this.d);
        this.a.onError(throwable);
    }

    public void onNext(Object object) {
        Object object2;
        boolean bl2 = this.f;
        if (bl2) {
            return;
        }
        long l10 = this.e;
        long l11 = 1L;
        this.e = l10 += l11;
        b b10 = (b)this.d.get();
        if (b10 != null) {
            b10.dispose();
        }
        try {
            object2 = this.b;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.dispose();
            this.a.onError(throwable);
            return;
        }
        object2 = object2.apply(object);
        Object object3 = "The ObservableSource supplied is null";
        object2 = e.a.w0.b.a.g(object2, (String)object3);
        object2 = (e0)object2;
        object3 = new r$a$a(this, l10, object);
        object = this.d;
        boolean bl3 = ((AtomicReference)object).compareAndSet(b10, object3);
        if (bl3) {
            object2.subscribe((g0)object3);
        }
    }

    public void onSubscribe(b object) {
        b b10 = this.c;
        boolean bl2 = DisposableHelper.validate(b10, (b)object);
        if (bl2) {
            this.c = object;
            object = this.a;
            object.onSubscribe(this);
        }
    }
}

