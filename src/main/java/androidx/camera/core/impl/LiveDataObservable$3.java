/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.LiveDataObservable;
import androidx.camera.core.impl.LiveDataObservable$LiveDataObserverAdapter;
import androidx.lifecycle.MutableLiveData;

public class LiveDataObservable$3
implements Runnable {
    public final /* synthetic */ LiveDataObservable this$0;
    public final /* synthetic */ LiveDataObservable$LiveDataObserverAdapter val$adapter;

    public LiveDataObservable$3(LiveDataObservable liveDataObservable, LiveDataObservable$LiveDataObserverAdapter liveDataObservable$LiveDataObserverAdapter) {
        this.this$0 = liveDataObservable;
        this.val$adapter = liveDataObservable$LiveDataObserverAdapter;
    }

    public void run() {
        MutableLiveData mutableLiveData = this.this$0.mLiveData;
        LiveDataObservable$LiveDataObserverAdapter liveDataObservable$LiveDataObserverAdapter = this.val$adapter;
        mutableLiveData.removeObserver(liveDataObservable$LiveDataObserverAdapter);
    }
}

