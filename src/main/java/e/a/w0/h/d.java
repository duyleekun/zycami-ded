/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.h;

import e.a.a1.a;
import e.a.w0.h.c;

public final class d
extends c {
    public void onError(Throwable throwable) {
        Object object = this.a;
        if (object == null) {
            this.b = throwable;
        } else {
            e.a.a1.a.Y(throwable);
        }
        this.countDown();
    }

    public void onNext(Object object) {
        Object object2 = this.a;
        if (object2 == null) {
            this.a = object;
            object = this.c;
            object.cancel();
            this.countDown();
        }
    }
}

