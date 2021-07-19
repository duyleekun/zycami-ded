/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.a;

import e.a.d;
import e.a.s0.a;
import e.a.w0.e.a.x;
import e.a.w0.e.a.x$a$a;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

public final class x$a
implements Runnable {
    private final AtomicBoolean a;
    public final a b;
    public final d c;
    public final /* synthetic */ x d;

    public x$a(x x10, AtomicBoolean atomicBoolean, a a10, d d10) {
        this.d = x10;
        this.a = atomicBoolean;
        this.b = a10;
        this.c = d10;
    }

    public void run() {
        Object object = this.a;
        Object object2 = null;
        boolean bl2 = true;
        boolean bl3 = ((AtomicBoolean)object).compareAndSet(false, bl2);
        if (bl3) {
            this.b.e();
            object = this.d.e;
            if (object == null) {
                object = this.c;
                Object object3 = this.d;
                long l10 = object3.b;
                object3 = object3.c;
                object3 = ExceptionHelper.e(l10, (TimeUnit)((Object)object3));
                object2 = new TimeoutException((String)object3);
                object.onError((Throwable)object2);
            } else {
                object2 = new x$a$a(this);
                object.f((d)object2);
            }
        }
    }
}

