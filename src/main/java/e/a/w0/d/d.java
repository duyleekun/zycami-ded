/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.d;

import e.a.w0.d.c;

public final class d
extends c {
    public void onError(Throwable throwable) {
        Object object = this.a;
        if (object == null) {
            this.b = throwable;
        }
        this.countDown();
    }

    public void onNext(Object object) {
        Object object2 = this.a;
        if (object2 == null) {
            this.a = object;
            object = this.c;
            object.dispose();
            this.countDown();
        }
    }
}

