/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.LiveDataObservable;
import androidx.camera.core.impl.LiveDataObservable$LiveDataObserverAdapter;
import androidx.lifecycle.MutableLiveData;

public class LiveDataObservable$2
implements Runnable {
    public final /* synthetic */ LiveDataObservable this$0;
    public final /* synthetic */ LiveDataObservable$LiveDataObserverAdapter val$newAdapter;
    public final /* synthetic */ LiveDataObservable$LiveDataObserverAdapter val$oldAdapter;

    public LiveDataObservable$2(LiveDataObservable liveDataObservable, LiveDataObservable$LiveDataObserverAdapter liveDataObserverAdapter, LiveDataObservable$LiveDataObserverAdapter liveDataObserverAdapter2) {
        this.this$0 = liveDataObservable;
        this.val$oldAdapter = liveDataObserverAdapter;
        this.val$newAdapter = liveDataObserverAdapter2;
    }

    public void run() {
        MutableLiveData mutableLiveData = this.this$0.mLiveData;
        LiveDataObservable$LiveDataObserverAdapter liveDataObservable$LiveDataObserverAdapter = this.val$oldAdapter;
        mutableLiveData.removeObserver(liveDataObservable$LiveDataObserverAdapter);
        mutableLiveData = this.this$0.mLiveData;
        liveDataObservable$LiveDataObserverAdapter = this.val$newAdapter;
        mutableLiveData.observeForever(liveDataObservable$LiveDataObserverAdapter);
    }
}

