/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.LiveDataObservable$LiveDataObserverAdapter$1;
import androidx.camera.core.impl.LiveDataObservable$Result;
import androidx.camera.core.impl.Observable$Observer;
import androidx.lifecycle.Observer;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public final class LiveDataObservable$LiveDataObserverAdapter
implements Observer {
    public final AtomicBoolean mActive;
    public final Executor mExecutor;
    public final Observable$Observer mObserver;

    public LiveDataObservable$LiveDataObserverAdapter(Executor executor, Observable$Observer observable$Observer) {
        AtomicBoolean atomicBoolean;
        this.mActive = atomicBoolean = new AtomicBoolean(true);
        this.mExecutor = executor;
        this.mObserver = observable$Observer;
    }

    public void disable() {
        this.mActive.set(false);
    }

    public void onChanged(LiveDataObservable$Result liveDataObservable$Result) {
        Executor executor = this.mExecutor;
        LiveDataObservable$LiveDataObserverAdapter$1 liveDataObservable$LiveDataObserverAdapter$1 = new LiveDataObservable$LiveDataObserverAdapter$1(this, liveDataObservable$Result);
        executor.execute(liveDataObservable$LiveDataObserverAdapter$1);
    }
}

