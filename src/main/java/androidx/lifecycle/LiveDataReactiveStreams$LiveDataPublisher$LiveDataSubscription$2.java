/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.lifecycle.LiveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription;

public class LiveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription$2
implements Runnable {
    public final /* synthetic */ LiveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription this$0;

    public LiveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription$2(LiveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription liveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription) {
        this.this$0 = liveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription;
    }

    public void run() {
        LiveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription liveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription = this.this$0;
        boolean bl2 = liveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription.mObserving;
        if (bl2) {
            liveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription.mLiveData.removeObserver(liveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription);
            liveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription = this.this$0;
            bl2 = false;
            liveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription.mObserving = false;
        }
        this.this$0.mLatest = null;
    }
}

