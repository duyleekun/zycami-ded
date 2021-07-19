/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.lifecycle.LiveDataReactiveStreams$PublisherLiveData$LiveDataSubscriber;

public class LiveDataReactiveStreams$PublisherLiveData$LiveDataSubscriber$1
implements Runnable {
    public final /* synthetic */ LiveDataReactiveStreams.PublisherLiveData.LiveDataSubscriber this$1;
    public final /* synthetic */ Throwable val$ex;

    public LiveDataReactiveStreams$PublisherLiveData$LiveDataSubscriber$1(LiveDataReactiveStreams.PublisherLiveData.LiveDataSubscriber liveDataSubscriber, Throwable throwable) {
        this.this$1 = liveDataSubscriber;
        this.val$ex = throwable;
    }

    public void run() {
        Throwable throwable = this.val$ex;
        RuntimeException runtimeException = new RuntimeException("LiveData does not handle errors. Errors from publishers should be handled upstream and propagated as state", throwable);
        throw runtimeException;
    }
}

