/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.w0.e.e.c$a$a;
import e.a.y0.a;
import io.reactivex.internal.util.NotificationLite;

public final class c$a
extends a {
    public volatile Object b;

    public c$a(Object object) {
        this.b = object = NotificationLite.next(object);
    }

    public c$a$a c() {
        c$a$a c$a$a = new c$a$a(this);
        return c$a$a;
    }

    public void onComplete() {
        Object object;
        this.b = object = NotificationLite.complete();
    }

    public void onError(Throwable object) {
        this.b = object = NotificationLite.error((Throwable)object);
    }

    public void onNext(Object object) {
        this.b = object = NotificationLite.next(object);
    }
}

