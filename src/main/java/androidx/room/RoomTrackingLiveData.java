/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

import androidx.lifecycle.LiveData;
import androidx.room.InvalidationLiveDataContainer;
import androidx.room.InvalidationTracker$Observer;
import androidx.room.RoomDatabase;
import androidx.room.RoomTrackingLiveData$1;
import androidx.room.RoomTrackingLiveData$2;
import androidx.room.RoomTrackingLiveData$3;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public class RoomTrackingLiveData
extends LiveData {
    public final Callable mComputeFunction;
    public final AtomicBoolean mComputing;
    private final InvalidationLiveDataContainer mContainer;
    public final RoomDatabase mDatabase;
    public final boolean mInTransaction;
    public final AtomicBoolean mInvalid;
    public final Runnable mInvalidationRunnable;
    public final InvalidationTracker$Observer mObserver;
    public final Runnable mRefreshRunnable;
    public final AtomicBoolean mRegisteredObserver;

    public RoomTrackingLiveData(RoomDatabase object, InvalidationLiveDataContainer invalidationLiveDataContainer, boolean bl2, Callable callable, String[] stringArray) {
        Object object2 = new AtomicBoolean(true);
        this.mInvalid = object2;
        object2 = new AtomicBoolean(false);
        this.mComputing = object2;
        object2 = new AtomicBoolean(false);
        this.mRegisteredObserver = object2;
        this.mRefreshRunnable = object2 = new RoomTrackingLiveData$1(this);
        this.mInvalidationRunnable = object2 = new RoomTrackingLiveData$2(this);
        this.mDatabase = object;
        this.mInTransaction = bl2;
        this.mComputeFunction = callable;
        this.mContainer = invalidationLiveDataContainer;
        this.mObserver = object = new RoomTrackingLiveData$3(this, stringArray);
    }

    public static /* synthetic */ void access$000(RoomTrackingLiveData roomTrackingLiveData, Object object) {
        roomTrackingLiveData.postValue(object);
    }

    public Executor getQueryExecutor() {
        boolean bl2 = this.mInTransaction;
        if (bl2) {
            return this.mDatabase.getTransactionExecutor();
        }
        return this.mDatabase.getQueryExecutor();
    }

    public void onActive() {
        super.onActive();
        this.mContainer.onActive(this);
        Executor executor = this.getQueryExecutor();
        Runnable runnable = this.mRefreshRunnable;
        executor.execute(runnable);
    }

    public void onInactive() {
        super.onInactive();
        this.mContainer.onInactive(this);
    }
}

