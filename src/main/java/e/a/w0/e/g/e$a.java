/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.g;

import e.a.l0;
import e.a.s0.b;
import e.a.t;
import e.a.v0.o;
import e.a.w0.b.a;
import e.a.y;
import io.reactivex.internal.disposables.DisposableHelper;

public final class e$a
implements l0,
b {
    public final t a;
    public final o b;
    public b c;

    public e$a(t t10, o o10) {
        this.a = t10;
        this.b = o10;
    }

    public void dispose() {
        this.c.dispose();
    }

    public boolean isDisposed() {
        return this.c.isDisposed();
    }

    public void onError(Throwable throwable) {
        this.a.onError(throwable);
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

    public void onSuccess(Object object) {
        Object object2;
        try {
            object2 = this.b;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.a.onError(throwable);
            return;
        }
        object = object2.apply(object);
        object2 = "The selector returned a null Notification";
        object = e.a.w0.b.a.g(object, (String)object2);
        object = (y)object;
        boolean bl2 = ((y)object).h();
        if (bl2) {
            object2 = this.a;
            object = ((y)object).e();
            object2.onSuccess(object);
        } else {
            bl2 = ((y)object).f();
            if (bl2) {
                object = this.a;
                object.onComplete();
            } else {
                object2 = this.a;
                object = ((y)object).d();
                object2.onError((Throwable)object);
            }
        }
    }
}

