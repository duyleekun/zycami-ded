/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription;
import i.g.c;
import i.g.d;

public final class LiveDataReactiveStreams$LiveDataPublisher
implements c {
    public final LifecycleOwner mLifecycle;
    public final LiveData mLiveData;

    public LiveDataReactiveStreams$LiveDataPublisher(LifecycleOwner lifecycleOwner, LiveData liveData) {
        this.mLifecycle = lifecycleOwner;
        this.mLiveData = liveData;
    }

    public void subscribe(d d10) {
        LifecycleOwner lifecycleOwner = this.mLifecycle;
        LiveData liveData = this.mLiveData;
        LiveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription liveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription = new LiveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription(d10, lifecycleOwner, liveData);
        d10.onSubscribe(liveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription);
    }
}

