/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.Observable$Observer;
import androidx.camera.core.impl.utils.futures.Futures;
import b.a.b.w1.e;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public final class ConstantObservable
implements Observable {
    private static final ConstantObservable NULL_OBSERVABLE;
    private static final String TAG = "ConstantObservable";
    private final ListenableFuture mValueFuture;

    static {
        ConstantObservable constantObservable;
        NULL_OBSERVABLE = constantObservable = new ConstantObservable(null);
    }

    private ConstantObservable(Object object) {
        this.mValueFuture = object = Futures.immediateFuture(object);
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ void a(Observable$Observer observable$Observer) {
        block5: {
            void var2_5;
            ListenableFuture listenableFuture = this.mValueFuture;
            listenableFuture = listenableFuture.get();
            try {
                observable$Observer.onNewData(listenableFuture);
                break block5;
            }
            catch (InterruptedException interruptedException) {
            }
            catch (ExecutionException executionException) {
                // empty catch block
            }
            observable$Observer.onError((Throwable)var2_5);
        }
    }

    public static Observable withValue(Object object) {
        if (object == null) {
            return NULL_OBSERVABLE;
        }
        ConstantObservable constantObservable = new ConstantObservable(object);
        return constantObservable;
    }

    public void addObserver(Executor executor, Observable$Observer observable$Observer) {
        ListenableFuture listenableFuture = this.mValueFuture;
        e e10 = new e(this, observable$Observer);
        listenableFuture.addListener(e10, executor);
    }

    public /* synthetic */ void b(Observable$Observer observable$Observer) {
        this.a(observable$Observer);
    }

    public ListenableFuture fetchData() {
        return this.mValueFuture;
    }

    public void removeObserver(Observable$Observer observable$Observer) {
    }
}

