/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.lifecycle.LiveDataReactiveStreams$PublisherLiveData;
import androidx.lifecycle.LiveDataReactiveStreams$PublisherLiveData$LiveDataSubscriber$1;
import i.g.d;
import i.g.e;
import java.util.concurrent.atomic.AtomicReference;

public final class LiveDataReactiveStreams$PublisherLiveData$LiveDataSubscriber
extends AtomicReference
implements d {
    public final /* synthetic */ LiveDataReactiveStreams$PublisherLiveData this$0;

    public LiveDataReactiveStreams$PublisherLiveData$LiveDataSubscriber(LiveDataReactiveStreams$PublisherLiveData liveDataReactiveStreams$PublisherLiveData) {
        this.this$0 = liveDataReactiveStreams$PublisherLiveData;
    }

    public void cancelSubscription() {
        e e10 = (e)this.get();
        if (e10 != null) {
            e10.cancel();
        }
    }

    public void onComplete() {
        this.this$0.mSubscriber.compareAndSet(this, null);
    }

    public void onError(Throwable throwable) {
        this.this$0.mSubscriber.compareAndSet(this, null);
        ArchTaskExecutor archTaskExecutor = ArchTaskExecutor.getInstance();
        LiveDataReactiveStreams$PublisherLiveData$LiveDataSubscriber$1 liveDataReactiveStreams$PublisherLiveData$LiveDataSubscriber$1 = new LiveDataReactiveStreams$PublisherLiveData$LiveDataSubscriber$1(this, throwable);
        archTaskExecutor.executeOnMainThread(liveDataReactiveStreams$PublisherLiveData$LiveDataSubscriber$1);
    }

    public void onNext(Object object) {
        this.this$0.postValue(object);
    }

    public void onSubscribe(e e10) {
        boolean bl2 = this.compareAndSet(null, e10);
        if (bl2) {
            long l10 = Long.MAX_VALUE;
            e10.request(l10);
        } else {
            e10.cancel();
        }
    }
}

