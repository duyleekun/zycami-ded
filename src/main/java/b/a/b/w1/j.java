/*
 * Decompiled with CFR 0.151.
 */
package b.a.b.w1;

import androidx.camera.core.impl.DeferrableSurfaces;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final class j
implements CallbackToFutureAdapter$Resolver {
    public final /* synthetic */ List a;
    public final /* synthetic */ ScheduledExecutorService b;
    public final /* synthetic */ Executor c;
    public final /* synthetic */ long d;
    public final /* synthetic */ boolean e;

    public /* synthetic */ j(List list, ScheduledExecutorService scheduledExecutorService, Executor executor, long l10, boolean bl2) {
        this.a = list;
        this.b = scheduledExecutorService;
        this.c = executor;
        this.d = l10;
        this.e = bl2;
    }

    public final Object attachCompleter(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        List list = this.a;
        ScheduledExecutorService scheduledExecutorService = this.b;
        Executor executor = this.c;
        long l10 = this.d;
        boolean bl2 = this.e;
        return DeferrableSurfaces.d(list, scheduledExecutorService, executor, l10, bl2, callbackToFutureAdapter$Completer);
    }
}

