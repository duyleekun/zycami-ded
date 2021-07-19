/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.lifecycle.ComputableLiveData$1;
import androidx.lifecycle.ComputableLiveData$2;
import androidx.lifecycle.ComputableLiveData$3;
import androidx.lifecycle.LiveData;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class ComputableLiveData {
    public final AtomicBoolean mComputing;
    public final Executor mExecutor;
    public final AtomicBoolean mInvalid;
    public final Runnable mInvalidationRunnable;
    public final LiveData mLiveData;
    public final Runnable mRefreshRunnable;

    public ComputableLiveData() {
        Executor executor = ArchTaskExecutor.getIOThreadExecutor();
        this(executor);
    }

    public ComputableLiveData(Executor object) {
        Object object2 = new AtomicBoolean(true);
        this.mInvalid = object2;
        object2 = new AtomicBoolean(false);
        this.mComputing = object2;
        this.mRefreshRunnable = object2 = new ComputableLiveData$2(this);
        this.mInvalidationRunnable = object2 = new ComputableLiveData$3(this);
        this.mExecutor = object;
        this.mLiveData = object = new ComputableLiveData$1(this);
    }

    public abstract Object compute();

    public LiveData getLiveData() {
        return this.mLiveData;
    }

    public void invalidate() {
        ArchTaskExecutor archTaskExecutor = ArchTaskExecutor.getInstance();
        Runnable runnable = this.mInvalidationRunnable;
        archTaskExecutor.executeOnMainThread(runnable);
    }
}

