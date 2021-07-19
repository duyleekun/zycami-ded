/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription$1;
import androidx.lifecycle.LiveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription$2;
import androidx.lifecycle.Observer;
import i.g.d;
import i.g.e;

public final class LiveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription
implements e,
Observer {
    public volatile boolean mCanceled;
    public Object mLatest;
    public final LifecycleOwner mLifecycle;
    public final LiveData mLiveData;
    public boolean mObserving;
    public long mRequested;
    public final d mSubscriber;

    public LiveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription(d d10, LifecycleOwner lifecycleOwner, LiveData liveData) {
        this.mSubscriber = d10;
        this.mLifecycle = lifecycleOwner;
        this.mLiveData = liveData;
    }

    public void cancel() {
        boolean bl2 = this.mCanceled;
        if (bl2) {
            return;
        }
        this.mCanceled = true;
        ArchTaskExecutor archTaskExecutor = ArchTaskExecutor.getInstance();
        LiveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription$2 liveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription$2 = new LiveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription$2(this);
        archTaskExecutor.executeOnMainThread(liveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription$2);
    }

    public void onChanged(Object object) {
        Object object2 = this.mCanceled;
        if (object2 != 0) {
            return;
        }
        long l10 = this.mRequested;
        long l11 = 0L;
        long l12 = l10 - l11;
        object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 > 0) {
            object2 = 0;
            this.mLatest = null;
            d d10 = this.mSubscriber;
            d10.onNext(object);
            l10 = this.mRequested;
            l11 = Long.MAX_VALUE;
            long l13 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l13 != false) {
                l11 = 1L;
                this.mRequested = l10 -= l11;
            }
        } else {
            this.mLatest = object;
        }
    }

    public void request(long l10) {
        boolean bl2 = this.mCanceled;
        if (bl2) {
            return;
        }
        ArchTaskExecutor archTaskExecutor = ArchTaskExecutor.getInstance();
        LiveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription$1 liveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription$1 = new LiveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription$1(this, l10);
        archTaskExecutor.executeOnMainThread(liveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription$1);
    }
}

