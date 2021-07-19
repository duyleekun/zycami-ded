/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl.utils.futures;

import androidx.arch.core.util.Function;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.ChainingListenableFuture;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures$1;
import androidx.camera.core.impl.utils.futures.Futures$2;
import androidx.camera.core.impl.utils.futures.Futures$3;
import androidx.camera.core.impl.utils.futures.Futures$4;
import androidx.camera.core.impl.utils.futures.Futures$CallbackListener;
import androidx.camera.core.impl.utils.futures.ImmediateFuture;
import androidx.camera.core.impl.utils.futures.ImmediateFuture$ImmediateFailedFuture;
import androidx.camera.core.impl.utils.futures.ImmediateFuture$ImmediateFailedScheduledFuture;
import androidx.camera.core.impl.utils.futures.ImmediateFuture$ImmediateSuccessfulFuture;
import androidx.camera.core.impl.utils.futures.ListFuture;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.core.util.Preconditions;
import b.a.b.w1.p.a.a;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;

public final class Futures {
    private static final Function IDENTITY_FUNCTION;

    static {
        Futures$2 futures$2 = new Futures$2();
        IDENTITY_FUNCTION = futures$2;
    }

    private Futures() {
    }

    public static /* synthetic */ Object a(ListenableFuture listenableFuture, CallbackToFutureAdapter$Completer object) {
        Function function = IDENTITY_FUNCTION;
        Executor executor = CameraXExecutors.directExecutor();
        Futures.propagateTransform(false, listenableFuture, function, (CallbackToFutureAdapter$Completer)object, executor);
        object = new StringBuilder();
        ((StringBuilder)object).append("nonCancellationPropagating[");
        ((StringBuilder)object).append(listenableFuture);
        ((StringBuilder)object).append("]");
        return ((StringBuilder)object).toString();
    }

    public static void addCallback(ListenableFuture listenableFuture, FutureCallback futureCallback, Executor executor) {
        Preconditions.checkNotNull(futureCallback);
        Futures$CallbackListener futures$CallbackListener = new Futures$CallbackListener(listenableFuture, futureCallback);
        listenableFuture.addListener(futures$CallbackListener, executor);
    }

    public static ListenableFuture allAsList(Collection object) {
        ArrayList arrayList = new ArrayList(object);
        object = CameraXExecutors.directExecutor();
        ListFuture listFuture = new ListFuture(arrayList, true, (Executor)object);
        return listFuture;
    }

    public static Object getDone(Future future) {
        boolean bl2 = future.isDone();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Future was expected to be done, ");
        charSequence.append(future);
        charSequence = charSequence.toString();
        Preconditions.checkState(bl2, (String)charSequence);
        return Futures.getUninterruptibly(future);
    }

    public static Object getUninterruptibly(Future future) {
        boolean bl2 = false;
        Thread thread = null;
        while (true) {
            block5: {
                try {
                    future = future.get();
                    if (!bl2) break block5;
                }
                catch (Throwable throwable) {
                    if (bl2) {
                        thread = Thread.currentThread();
                        thread.interrupt();
                    }
                    throw throwable;
                }
                catch (InterruptedException interruptedException) {
                    bl2 = true;
                    continue;
                }
                thread = Thread.currentThread();
                thread.interrupt();
            }
            return future;
            break;
        }
    }

    public static ListenableFuture immediateFailedFuture(Throwable throwable) {
        ImmediateFuture$ImmediateFailedFuture immediateFuture$ImmediateFailedFuture = new ImmediateFuture$ImmediateFailedFuture(throwable);
        return immediateFuture$ImmediateFailedFuture;
    }

    public static ScheduledFuture immediateFailedScheduledFuture(Throwable throwable) {
        ImmediateFuture$ImmediateFailedScheduledFuture immediateFuture$ImmediateFailedScheduledFuture = new ImmediateFuture$ImmediateFailedScheduledFuture(throwable);
        return immediateFuture$ImmediateFailedScheduledFuture;
    }

    public static ListenableFuture immediateFuture(Object object) {
        if (object == null) {
            return ImmediateFuture.nullFuture();
        }
        ImmediateFuture$ImmediateSuccessfulFuture immediateFuture$ImmediateSuccessfulFuture = new ImmediateFuture$ImmediateSuccessfulFuture(object);
        return immediateFuture$ImmediateSuccessfulFuture;
    }

    public static ListenableFuture nonCancellationPropagating(ListenableFuture listenableFuture) {
        Preconditions.checkNotNull(listenableFuture);
        boolean bl2 = listenableFuture.isDone();
        if (bl2) {
            return listenableFuture;
        }
        a a10 = new a(listenableFuture);
        return CallbackToFutureAdapter.getFuture(a10);
    }

    public static void propagate(ListenableFuture listenableFuture, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        Function function = IDENTITY_FUNCTION;
        Executor executor = CameraXExecutors.directExecutor();
        Futures.propagateTransform(listenableFuture, function, callbackToFutureAdapter$Completer, executor);
    }

    public static void propagateTransform(ListenableFuture listenableFuture, Function function, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer, Executor executor) {
        Futures.propagateTransform(true, listenableFuture, function, callbackToFutureAdapter$Completer, executor);
    }

    private static void propagateTransform(boolean bl2, ListenableFuture object, Function function, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer, Executor executor) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(function);
        Preconditions.checkNotNull(callbackToFutureAdapter$Completer);
        Preconditions.checkNotNull(executor);
        Futures$3 futures$3 = new Futures$3(callbackToFutureAdapter$Completer, function);
        Futures.addCallback((ListenableFuture)object, futures$3, executor);
        if (bl2) {
            Futures$4 futures$4 = new Futures$4((ListenableFuture)object);
            object = CameraXExecutors.directExecutor();
            callbackToFutureAdapter$Completer.addCancellationListener(futures$4, (Executor)object);
        }
    }

    public static ListenableFuture successfulAsList(Collection object) {
        ArrayList arrayList = new ArrayList(object);
        object = CameraXExecutors.directExecutor();
        ListFuture listFuture = new ListFuture(arrayList, false, (Executor)object);
        return listFuture;
    }

    public static ListenableFuture transform(ListenableFuture listenableFuture, Function function, Executor executor) {
        Preconditions.checkNotNull(function);
        Futures$1 futures$1 = new Futures$1(function);
        return Futures.transformAsync(listenableFuture, futures$1, executor);
    }

    public static ListenableFuture transformAsync(ListenableFuture listenableFuture, AsyncFunction asyncFunction, Executor executor) {
        ChainingListenableFuture chainingListenableFuture = new ChainingListenableFuture(asyncFunction, listenableFuture);
        listenableFuture.addListener(chainingListenableFuture, executor);
        return chainingListenableFuture;
    }
}

