/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.a1.a;
import e.a.g0;
import e.a.l0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

public final class e0$a
implements g0,
b {
    public final l0 a;
    public final long b;
    public final Object c;
    public b d;
    public long e;
    public boolean f;

    public e0$a(l0 l02, long l10, Object object) {
        this.a = l02;
        this.b = l10;
        this.c = object;
    }

    public void dispose() {
        this.d.dispose();
    }

    public boolean isDisposed() {
        return this.d.isDisposed();
    }

    public void onComplete() {
        boolean bl2 = this.f;
        if (!bl2) {
            this.f = bl2 = true;
            Object object = this.c;
            if (object != null) {
                l0 l02 = this.a;
                l02.onSuccess(object);
            } else {
                object = this.a;
                NoSuchElementException noSuchElementException = new NoSuchElementException();
                object.onError(noSuchElementException);
            }
        }
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.f;
        if (bl2) {
            e.a.a1.a.Y(throwable);
            return;
        }
        this.f = true;
        this.a.onError(throwable);
    }

    public void onNext(Object object) {
        boolean bl2 = this.f;
        if (bl2) {
            return;
        }
        long l10 = this.e;
        long l11 = this.b;
        long l12 = l10 - l11;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 == false) {
            this.f = true;
            this.d.dispose();
            this.a.onSuccess(object);
            return;
        }
        this.e = ++l10;
    }

    public void onSubscribe(b object) {
        b b10 = this.d;
        boolean bl2 = DisposableHelper.validate(b10, (b)object);
        if (bl2) {
            this.d = object;
            object = this.a;
            object.onSubscribe(this);
        }
    }
}

