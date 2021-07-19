/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams$PublisherLiveData$LiveDataSubscriber;
import i.g.c;
import java.util.concurrent.atomic.AtomicReference;

public class LiveDataReactiveStreams$PublisherLiveData
extends LiveData {
    private final c mPublisher;
    public final AtomicReference mSubscriber;

    public LiveDataReactiveStreams$PublisherLiveData(c atomicReference) {
        this.mPublisher = atomicReference;
        this.mSubscriber = atomicReference = new AtomicReference();
    }

    public void onActive() {
        super.onActive();
        LiveDataReactiveStreams$PublisherLiveData$LiveDataSubscriber liveDataReactiveStreams$PublisherLiveData$LiveDataSubscriber = new LiveDataReactiveStreams$PublisherLiveData$LiveDataSubscriber(this);
        this.mSubscriber.set(liveDataReactiveStreams$PublisherLiveData$LiveDataSubscriber);
        this.mPublisher.subscribe(liveDataReactiveStreams$PublisherLiveData$LiveDataSubscriber);
    }

    public void onInactive() {
        super.onInactive();
        LiveDataReactiveStreams$PublisherLiveData$LiveDataSubscriber liveDataReactiveStreams$PublisherLiveData$LiveDataSubscriber = this.mSubscriber.getAndSet(null);
        if (liveDataReactiveStreams$PublisherLiveData$LiveDataSubscriber != null) {
            liveDataReactiveStreams$PublisherLiveData$LiveDataSubscriber.cancelSubscription();
        }
    }
}

