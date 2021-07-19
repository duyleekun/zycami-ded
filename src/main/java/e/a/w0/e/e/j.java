/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.e0;
import e.a.g0;
import e.a.v0.g;
import e.a.w0.b.a;
import e.a.w0.i.c;
import e.a.w0.i.d;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.observers.BlockingObserver;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.LinkedBlockingQueue;

public final class j {
    private j() {
        IllegalStateException illegalStateException = new IllegalStateException("No instances!");
        throw illegalStateException;
    }

    public static void a(e0 object) {
        d d10 = new d();
        g g10 = Functions.h();
        g g11 = Functions.h();
        LambdaObserver lambdaObserver = new LambdaObserver(g10, d10, d10, g11);
        object.subscribe(lambdaObserver);
        c.a(d10, lambdaObserver);
        object = d10.a;
        if (object == null) {
            return;
        }
        throw ExceptionHelper.f((Throwable)object);
    }

    public static void b(e0 e02, g0 g02) {
        boolean bl2;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        BlockingObserver blockingObserver = new BlockingObserver(linkedBlockingQueue);
        g02.onSubscribe(blockingObserver);
        e02.subscribe(blockingObserver);
        while (!(bl2 = blockingObserver.isDisposed())) {
            Object object;
            boolean bl3;
            e02 = linkedBlockingQueue.poll();
            if (e02 == null) {
                try {
                    e02 = linkedBlockingQueue.take();
                }
                catch (InterruptedException interruptedException) {
                    blockingObserver.dispose();
                    g02.onError(interruptedException);
                    return;
                }
            }
            if (!(bl3 = blockingObserver.isDisposed()) && e02 != (object = BlockingObserver.TERMINATED) && !(bl2 = NotificationLite.acceptFull((Object)e02, g02))) continue;
        }
    }

    public static void c(e0 e02, g g10, g g11, e.a.v0.a a10) {
        a.g(g10, "onNext is null");
        a.g(g11, "onError is null");
        a.g(a10, "onComplete is null");
        g g12 = Functions.h();
        LambdaObserver lambdaObserver = new LambdaObserver(g10, g11, a10, g12);
        j.b(e02, lambdaObserver);
    }
}

