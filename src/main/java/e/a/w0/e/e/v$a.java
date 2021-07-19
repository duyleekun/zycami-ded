/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.g0;
import e.a.s0.b;
import e.a.v0.o;
import e.a.w0.b.a;
import e.a.y;
import io.reactivex.internal.disposables.DisposableHelper;

public final class v$a
implements g0,
b {
    public final g0 a;
    public final o b;
    public boolean c;
    public b d;

    public v$a(g0 g02, o o10) {
        this.a = g02;
        this.b = o10;
    }

    public void dispose() {
        this.d.dispose();
    }

    public boolean isDisposed() {
        return this.d.isDisposed();
    }

    public void onComplete() {
        boolean bl2 = this.c;
        if (bl2) {
            return;
        }
        this.c = true;
        this.a.onComplete();
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.c;
        if (bl2) {
            e.a.a1.a.Y(throwable);
            return;
        }
        this.c = true;
        this.a.onError(throwable);
    }

    public void onNext(Object object) {
        Object object2;
        boolean bl2 = this.c;
        if (bl2) {
            bl2 = object instanceof y;
            if (bl2 && (bl2 = ((y)(object = (y)object)).g())) {
                object = ((y)object).d();
                e.a.a1.a.Y((Throwable)object);
            }
            return;
        }
        try {
            object2 = this.b;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.d.dispose();
            this.onError(throwable);
            return;
        }
        object = object2.apply(object);
        object2 = "The selector returned a null Notification";
        object = e.a.w0.b.a.g(object, (String)object2);
        object = (y)object;
        bl2 = ((y)object).g();
        if (bl2) {
            object2 = this.d;
            object2.dispose();
            object = ((y)object).d();
            this.onError((Throwable)object);
        } else {
            bl2 = ((y)object).f();
            if (bl2) {
                object = this.d;
                object.dispose();
                this.onComplete();
            } else {
                object2 = this.a;
                object = ((y)object).e();
                object2.onNext(object);
            }
        }
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

