/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.v0.g;
import e.a.w0.b.a;
import i.g.c;
import i.g.d;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.subscribers.BlockingSubscriber;
import io.reactivex.internal.subscribers.BoundedSubscriber;
import io.reactivex.internal.subscribers.LambdaSubscriber;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.LinkedBlockingQueue;

public final class h {
    private h() {
        IllegalStateException illegalStateException = new IllegalStateException("No instances!");
        throw illegalStateException;
    }

    public static void a(c object) {
        e.a.w0.i.d d10 = new e.a.w0.i.d();
        g g10 = Functions.h();
        g g11 = Functions.l;
        LambdaSubscriber lambdaSubscriber = new LambdaSubscriber(g10, d10, d10, g11);
        object.subscribe(lambdaSubscriber);
        e.a.w0.i.c.a(d10, lambdaSubscriber);
        object = d10.a;
        if (object == null) {
            return;
        }
        throw ExceptionHelper.f((Throwable)object);
    }

    public static void b(c c10, g g10, g g11, e.a.v0.a a10) {
        a.g(g10, "onNext is null");
        a.g(g11, "onError is null");
        a.g(a10, "onComplete is null");
        g g12 = Functions.l;
        LambdaSubscriber lambdaSubscriber = new LambdaSubscriber(g10, g11, a10, g12);
        h.d(c10, lambdaSubscriber);
    }

    public static void c(c c10, g g10, g g11, e.a.v0.a a10, int n10) {
        a.g(g10, "onNext is null");
        a.g(g11, "onError is null");
        a.g(a10, "onComplete is null");
        a.h(n10, "number > 0 required");
        g g12 = Functions.d(n10);
        BoundedSubscriber boundedSubscriber = new BoundedSubscriber(g10, g11, a10, g12, n10);
        h.d(c10, boundedSubscriber);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void d(c c10, d d10) {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        BlockingSubscriber blockingSubscriber = new BlockingSubscriber(linkedBlockingQueue);
        c10.subscribe(blockingSubscriber);
        try {
            boolean bl2;
            do {
                boolean bl3;
                if (bl2 = blockingSubscriber.isCancelled()) {
                    return;
                }
                c10 = linkedBlockingQueue.poll();
                if (c10 == null) {
                    bl2 = blockingSubscriber.isCancelled();
                    if (bl2) {
                        return;
                    }
                    e.a.w0.i.c.b();
                    c10 = linkedBlockingQueue.take();
                }
                if (bl3 = blockingSubscriber.isCancelled()) {
                    return;
                }
                Object object = BlockingSubscriber.TERMINATED;
                if (c10 == object) return;
            } while (!(bl2 = NotificationLite.acceptFull((Object)c10, d10)));
            return;
        }
        catch (InterruptedException interruptedException) {
            blockingSubscriber.cancel();
            d10.onError(interruptedException);
        }
    }
}

