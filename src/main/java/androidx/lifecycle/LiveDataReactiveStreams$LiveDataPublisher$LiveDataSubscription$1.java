/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription;
import androidx.lifecycle.Observer;

public class LiveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription$1
implements Runnable {
    public final /* synthetic */ LiveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription this$0;
    public final /* synthetic */ long val$n;

    public LiveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription$1(LiveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription liveDataSubscription, long l10) {
        this.this$0 = liveDataSubscription;
        this.val$n = l10;
    }

    public void run() {
        Object object = this.this$0;
        boolean bl2 = ((LiveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription)object).mCanceled;
        if (bl2) {
            return;
        }
        long l10 = this.val$n;
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        boolean bl3 = true;
        if (l12 <= 0) {
            IllegalArgumentException illegalArgumentException;
            this.this$0.mCanceled = bl3;
            object = this.this$0;
            boolean bl4 = ((LiveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription)object).mObserving;
            if (bl4) {
                ((LiveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription)object).mLiveData.removeObserver((Observer)object);
                object = this.this$0;
                bl4 = false;
                illegalArgumentException = null;
                ((LiveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription)object).mObserving = false;
            }
            object = this.this$0;
            ((LiveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription)object).mLatest = null;
            object = ((LiveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription)object).mSubscriber;
            illegalArgumentException = new IllegalArgumentException("Non-positive request");
            object.onError(illegalArgumentException);
            return;
        }
        LiveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription liveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription = this.this$0;
        long l13 = liveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription.mRequested;
        long l14 = l13 + l10;
        long l15 = l14 - l13;
        Object object2 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        l13 = object2 >= 0 ? (l13 += l10) : Long.MAX_VALUE;
        liveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription.mRequested = l13;
        bl2 = liveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription.mObserving;
        if (!bl2) {
            liveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription.mObserving = bl3;
            object = liveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription.mLiveData;
            LifecycleOwner lifecycleOwner = liveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription.mLifecycle;
            ((LiveData)object).observe(lifecycleOwner, liveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription);
        } else {
            object = liveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription.mLatest;
            if (object != null) {
                liveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription.onChanged(object);
                object = this.this$0;
                ((LiveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription)object).mLatest = null;
            }
        }
    }
}

