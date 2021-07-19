/*
 * Decompiled with CFR 0.151.
 */
package e.a.s0;

import e.a.s0.b;
import e.a.w0.b.a;
import i.g.e;
import io.reactivex.disposables.ActionDisposable;
import io.reactivex.disposables.FutureDisposable;
import io.reactivex.disposables.RunnableDisposable;
import io.reactivex.disposables.SubscriptionDisposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import java.util.concurrent.Future;

public final class c {
    private c() {
        IllegalStateException illegalStateException = new IllegalStateException("No instances!");
        throw illegalStateException;
    }

    public static b a() {
        return EmptyDisposable.INSTANCE;
    }

    public static b b() {
        return c.f(Functions.b);
    }

    public static b c(e.a.v0.a a10) {
        a.g(a10, "run is null");
        ActionDisposable actionDisposable = new ActionDisposable(a10);
        return actionDisposable;
    }

    public static b d(Future future) {
        a.g(future, "future is null");
        return c.e(future, true);
    }

    public static b e(Future future, boolean bl2) {
        a.g(future, "future is null");
        FutureDisposable futureDisposable = new FutureDisposable(future, bl2);
        return futureDisposable;
    }

    public static b f(Runnable runnable) {
        a.g(runnable, "run is null");
        RunnableDisposable runnableDisposable = new RunnableDisposable(runnable);
        return runnableDisposable;
    }

    public static b g(e e10) {
        a.g(e10, "subscription is null");
        SubscriptionDisposable subscriptionDisposable = new SubscriptionDisposable(e10);
        return subscriptionDisposable;
    }
}

