/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.a1.a;
import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

public final class c0$a
implements g0,
b {
    public final g0 a;
    public final long b;
    public final Object c;
    public final boolean d;
    public b e;
    public long f;
    public boolean g;

    public c0$a(g0 g02, long l10, Object object, boolean bl2) {
        this.a = g02;
        this.b = l10;
        this.c = object;
        this.d = bl2;
    }

    public void dispose() {
        this.e.dispose();
    }

    public boolean isDisposed() {
        return this.e.isDisposed();
    }

    public void onComplete() {
        boolean bl2 = this.g;
        if (!bl2) {
            boolean bl3;
            this.g = bl2 = true;
            Object object = this.c;
            if (object == null && (bl3 = this.d)) {
                object = this.a;
                NoSuchElementException noSuchElementException = new NoSuchElementException();
                object.onError(noSuchElementException);
            } else {
                if (object != null) {
                    g0 g02 = this.a;
                    g02.onNext(object);
                }
                object = this.a;
                object.onComplete();
            }
        }
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.g;
        if (bl2) {
            e.a.a1.a.Y(throwable);
            return;
        }
        this.g = true;
        this.a.onError(throwable);
    }

    public void onNext(Object object) {
        boolean bl2 = this.g;
        if (bl2) {
            return;
        }
        long l10 = this.f;
        long l11 = this.b;
        long l12 = l10 - l11;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 == false) {
            this.g = true;
            this.e.dispose();
            this.a.onNext(object);
            this.a.onComplete();
            return;
        }
        this.f = ++l10;
    }

    public void onSubscribe(b object) {
        b b10 = this.e;
        boolean bl2 = DisposableHelper.validate(b10, (b)object);
        if (bl2) {
            this.e = object;
            object = this.a;
            object.onSubscribe(this);
        }
    }
}

