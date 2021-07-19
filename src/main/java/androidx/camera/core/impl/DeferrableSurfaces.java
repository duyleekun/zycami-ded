/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.DeferrableSurface$SurfaceClosedException;
import androidx.camera.core.impl.DeferrableSurfaces$1;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;
import b.a.b.w1.h;
import b.a.b.w1.i;
import b.a.b.w1.j;
import b.a.b.w1.k;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class DeferrableSurfaces {
    private DeferrableSurfaces() {
    }

    public static /* synthetic */ void a(ListenableFuture listenableFuture, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer, long l10) {
        boolean bl2 = listenableFuture.isDone();
        if (!bl2) {
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "Cannot complete surfaceList within ";
            stringBuilder.append(string2);
            stringBuilder.append(l10);
            String string3 = stringBuilder.toString();
            TimeoutException timeoutException = new TimeoutException(string3);
            callbackToFutureAdapter$Completer.setException(timeoutException);
            boolean bl3 = true;
            listenableFuture.cancel(bl3);
        }
    }

    public static /* synthetic */ void b(Executor executor, ListenableFuture listenableFuture, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer, long l10) {
        i i10 = new i(listenableFuture, callbackToFutureAdapter$Completer, l10);
        executor.execute(i10);
    }

    public static /* synthetic */ void c(ListenableFuture listenableFuture) {
        listenableFuture.cancel(true);
    }

    public static /* synthetic */ Object d(List object, ScheduledExecutorService object2, Executor executor, long l10, boolean bl2, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        k k10;
        object = Futures.successfulAsList((Collection)object);
        Object object3 = k10;
        k10 = new k(executor, (ListenableFuture)object, callbackToFutureAdapter$Completer, l10);
        object3 = TimeUnit.MILLISECONDS;
        object2 = object2.schedule(k10, l10, (TimeUnit)((Object)object3));
        Object object4 = new h((ListenableFuture)object);
        callbackToFutureAdapter$Completer.addCancellationListener((Runnable)object4, executor);
        object4 = new DeferrableSurfaces$1(bl2, callbackToFutureAdapter$Completer, (ScheduledFuture)object2);
        Futures.addCallback((ListenableFuture)object, (FutureCallback)object4, executor);
        return "surfaceList";
    }

    public static void decrementAll(List object) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            DeferrableSurface deferrableSurface = (DeferrableSurface)object.next();
            deferrableSurface.decrementUseCount();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void incrementAll(List list) {
        int n10 = list.isEmpty() ? 1 : 0;
        if (n10 != 0) return;
        n10 = 0;
        try {
            int n11;
            do {
                Object object = list.get(n10);
                object = (DeferrableSurface)object;
                ((DeferrableSurface)object).incrementUseCount();
            } while (++n10 < (n11 = list.size()));
            return;
        }
        catch (DeferrableSurface$SurfaceClosedException deferrableSurface$SurfaceClosedException) {
            n10 += -1;
            while (n10 >= 0) {
                DeferrableSurface deferrableSurface = (DeferrableSurface)list.get(n10);
                deferrableSurface.decrementUseCount();
                n10 += -1;
            }
            throw deferrableSurface$SurfaceClosedException;
        }
    }

    public static ListenableFuture surfaceListWithTimeout(Collection object, boolean bl2, long l10, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        Object object2;
        boolean bl3;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        object = object.iterator();
        while (bl3 = object.hasNext()) {
            object2 = ((DeferrableSurface)object.next()).getSurface();
            arrayList.add(object2);
        }
        object2 = object;
        object = new j(arrayList, scheduledExecutorService, executor, l10, bl2);
        return CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter$Resolver)object);
    }

    public static boolean tryIncrementAll(List list) {
        try {
            DeferrableSurfaces.incrementAll(list);
            return true;
        }
        catch (DeferrableSurface$SurfaceClosedException deferrableSurface$SurfaceClosedException) {
            return false;
        }
    }
}

