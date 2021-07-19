/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.a1.a;
import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;

public final class q1$a
implements g0,
b {
    public final g0 a;
    public boolean b;
    public b c;
    public long d;

    public q1$a(g0 g02, long l10) {
        this.a = g02;
        this.d = l10;
    }

    public void dispose() {
        this.c.dispose();
    }

    public boolean isDisposed() {
        return this.c.isDisposed();
    }

    public void onComplete() {
        boolean bl2 = this.b;
        if (!bl2) {
            this.b = bl2 = true;
            this.c.dispose();
            g0 g02 = this.a;
            g02.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.b;
        if (bl2) {
            e.a.a1.a.Y(throwable);
            return;
        }
        this.b = true;
        this.c.dispose();
        this.a.onError(throwable);
    }

    public void onNext(Object object) {
        Object object2 = this.b;
        if (object2 == 0) {
            long l10;
            long l11 = this.d;
            this.d = l10 = l11 - 1L;
            long l12 = 0L;
            long l13 = l11 - l12;
            object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object2 > 0) {
                object2 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
                object2 = object2 == 0 ? 1 : 0;
                g0 g02 = this.a;
                g02.onNext(object);
                if (object2 != 0) {
                    this.onComplete();
                }
            }
        }
    }

    public void onSubscribe(b object) {
        b b10 = this.c;
        Object object2 = DisposableHelper.validate(b10, (b)object);
        if (object2) {
            this.c = object;
            long l10 = this.d;
            long l11 = 0L;
            long l12 = l10 - l11;
            object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (!object2) {
                this.b = object2 = true;
                object.dispose();
                object = this.a;
                EmptyDisposable.complete((g0)object);
            } else {
                object = this.a;
                object.onSubscribe(this);
            }
        }
    }
}

