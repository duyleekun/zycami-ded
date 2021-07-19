/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.a;

import e.a.d;
import e.a.l0;
import e.a.s0.b;
import e.a.t0.a;
import e.a.w0.e.a.a0;

public final class a0$a
implements d {
    private final l0 a;
    public final /* synthetic */ a0 b;

    public a0$a(a0 a02, l0 l02) {
        this.b = a02;
        this.a = l02;
    }

    public void onComplete() {
        Object object = this.b;
        Object object2 = ((a0)object).b;
        if (object2 != null) {
            try {
                object = object2.call();
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                this.a.onError(throwable);
                return;
            }
        } else {
            object = ((a0)object).c;
        }
        if (object == null) {
            object = this.a;
            String string2 = "The value supplied is null";
            object2 = new NullPointerException(string2);
            object.onError((Throwable)object2);
        } else {
            object2 = this.a;
            object2.onSuccess(object);
        }
    }

    public void onError(Throwable throwable) {
        this.a.onError(throwable);
    }

    public void onSubscribe(b b10) {
        this.a.onSubscribe(b10);
    }
}

