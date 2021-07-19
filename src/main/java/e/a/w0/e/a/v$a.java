/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.a;

import e.a.d;
import e.a.s0.b;
import e.a.t0.a;
import e.a.w0.e.a.v;
import io.reactivex.exceptions.CompositeException;

public final class v$a
implements d {
    private final d a;
    public final /* synthetic */ v b;

    public v$a(v v10, d d10) {
        this.b = v10;
        this.a = d10;
    }

    public void onComplete() {
        this.a.onComplete();
    }

    public void onError(Throwable object) {
        Object object2;
        try {
            object2 = this.b;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            d d10 = this.a;
            Throwable[] throwableArray = new Throwable[]{object, throwable};
            CompositeException compositeException = new CompositeException(throwableArray);
            d10.onError(compositeException);
            return;
        }
        object2 = ((v)object2).b;
        boolean bl2 = object2.test(object);
        if (bl2) {
            object = this.a;
            object.onComplete();
        } else {
            object2 = this.a;
            object2.onError((Throwable)object);
        }
    }

    public void onSubscribe(b b10) {
        this.a.onSubscribe(b10);
    }
}

