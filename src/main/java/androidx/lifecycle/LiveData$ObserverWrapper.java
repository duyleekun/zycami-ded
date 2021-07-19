/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

public abstract class LiveData$ObserverWrapper {
    public boolean mActive;
    public int mLastVersion = -1;
    public final Observer mObserver;
    public final /* synthetic */ LiveData this$0;

    public LiveData$ObserverWrapper(LiveData liveData, Observer observer) {
        this.this$0 = liveData;
        this.mObserver = observer;
    }

    public void activeStateChanged(boolean n10) {
        int n11 = this.mActive;
        if (n10 == n11) {
            return;
        }
        this.mActive = n10;
        LiveData liveData = this.this$0;
        n10 = n10 != 0 ? 1 : -1;
        liveData.changeActiveCounter(n10);
        n10 = this.mActive;
        if (n10 != 0) {
            LiveData liveData2 = this.this$0;
            liveData2.dispatchingValue(this);
        }
    }

    public void detachObserver() {
    }

    public boolean isAttachedTo(LifecycleOwner lifecycleOwner) {
        return false;
    }

    public abstract boolean shouldBeActive();
}

