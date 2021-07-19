/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.LiveDataObservable$1;
import androidx.camera.core.impl.LiveDataObservable$2;
import androidx.camera.core.impl.LiveDataObservable$3;
import androidx.camera.core.impl.LiveDataObservable$LiveDataObserverAdapter;
import androidx.camera.core.impl.LiveDataObservable$Result;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.Observable$Observer;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public final class LiveDataObservable
implements Observable {
    public final MutableLiveData mLiveData;
    private final Map mObservers;

    public LiveDataObservable() {
        HashMap hashMap = new HashMap();
        this.mLiveData = hashMap;
        this.mObservers = hashMap = new HashMap();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void addObserver(Executor object, Observable$Observer object2) {
        Map map = this.mObservers;
        synchronized (map) {
            Object object3 = this.mObservers;
            object3 = object3.get(object2);
            object3 = (LiveDataObservable$LiveDataObserverAdapter)object3;
            if (object3 != null) {
                ((LiveDataObservable$LiveDataObserverAdapter)object3).disable();
            }
            LiveDataObservable$LiveDataObserverAdapter liveDataObservable$LiveDataObserverAdapter = new LiveDataObservable$LiveDataObserverAdapter((Executor)object, (Observable$Observer)object2);
            object = this.mObservers;
            object.put(object2, liveDataObservable$LiveDataObserverAdapter);
            object = CameraXExecutors.mainThreadExecutor();
            object2 = new LiveDataObservable$2(this, (LiveDataObservable$LiveDataObserverAdapter)object3, liveDataObservable$LiveDataObserverAdapter);
            object.execute((Runnable)object2);
            return;
        }
    }

    public ListenableFuture fetchData() {
        LiveDataObservable$1 liveDataObservable$1 = new LiveDataObservable$1(this);
        return CallbackToFutureAdapter.getFuture(liveDataObservable$1);
    }

    public LiveData getLiveData() {
        return this.mLiveData;
    }

    public void postError(Throwable object) {
        MutableLiveData mutableLiveData = this.mLiveData;
        object = LiveDataObservable$Result.fromError((Throwable)object);
        mutableLiveData.postValue(object);
    }

    public void postValue(Object object) {
        MutableLiveData mutableLiveData = this.mLiveData;
        object = LiveDataObservable$Result.fromValue(object);
        mutableLiveData.postValue(object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void removeObserver(Observable$Observer object) {
        Map map = this.mObservers;
        synchronized (map) {
            Object object2 = this.mObservers;
            object = object2.remove(object);
            object = (LiveDataObservable$LiveDataObserverAdapter)object;
            if (object != null) {
                ((LiveDataObservable$LiveDataObserverAdapter)object).disable();
                object2 = CameraXExecutors.mainThreadExecutor();
                LiveDataObservable$3 liveDataObservable$3 = new LiveDataObservable$3(this, (LiveDataObservable$LiveDataObserverAdapter)object);
                object2.execute(liveDataObservable$3);
            }
            return;
        }
    }
}

