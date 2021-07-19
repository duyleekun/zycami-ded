/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveData$ObserverWrapper;
import androidx.lifecycle.Observer;

public class LiveData$AlwaysActiveObserver
extends LiveData$ObserverWrapper {
    public final /* synthetic */ LiveData this$0;

    public LiveData$AlwaysActiveObserver(LiveData liveData, Observer observer) {
        this.this$0 = liveData;
        super(liveData, observer);
    }

    public boolean shouldBeActive() {
        return true;
    }
}

