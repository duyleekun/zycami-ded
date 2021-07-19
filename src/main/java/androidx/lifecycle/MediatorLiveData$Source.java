/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

public class MediatorLiveData$Source
implements Observer {
    public final LiveData mLiveData;
    public final Observer mObserver;
    public int mVersion = -1;

    public MediatorLiveData$Source(LiveData liveData, Observer observer) {
        this.mLiveData = liveData;
        this.mObserver = observer;
    }

    public void onChanged(Object object) {
        int n10 = this.mVersion;
        LiveData liveData = this.mLiveData;
        int n11 = liveData.getVersion();
        if (n10 != n11) {
            this.mVersion = n10 = this.mLiveData.getVersion();
            Observer observer = this.mObserver;
            observer.onChanged(object);
        }
    }

    public void plug() {
        this.mLiveData.observeForever(this);
    }

    public void unplug() {
        this.mLiveData.removeObserver(this);
    }
}

