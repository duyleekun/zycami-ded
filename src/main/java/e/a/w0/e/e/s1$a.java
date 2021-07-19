/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.a1.a;
import e.a.g0;
import e.a.s0.b;
import e.a.v0.r;
import io.reactivex.internal.disposables.DisposableHelper;

public final class s1$a
implements g0,
b {
    public final g0 a;
    public final r b;
    public b c;
    public boolean d;

    public s1$a(g0 g02, r r10) {
        this.a = g02;
        this.b = r10;
    }

    public void dispose() {
        this.c.dispose();
    }

    public boolean isDisposed() {
        return this.c.isDisposed();
    }

    public void onComplete() {
        boolean bl2 = this.d;
        if (!bl2) {
            this.d = bl2 = true;
            g0 g02 = this.a;
            g02.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.d;
        if (!bl2) {
            this.d = bl2 = true;
            g0 g02 = this.a;
            g02.onError(throwable);
        } else {
            e.a.a1.a.Y(throwable);
        }
    }

    public void onNext(Object object) {
        boolean bl2 = this.d;
        if (!bl2) {
            Object object2 = this.a;
            object2.onNext(object);
            object2 = this.b;
            try {
                boolean bl3 = object2.test(object);
                if (bl3) {
                    this.d = bl3 = true;
                    this.c.dispose();
                    object = this.a;
                    object.onComplete();
                }
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                object2 = this.c;
                object2.dispose();
                this.onError(throwable);
            }
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

