/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.lifecycle.LiveData;

public class LiveData$1
implements Runnable {
    public final /* synthetic */ LiveData this$0;

    public LiveData$1(LiveData liveData) {
        this.this$0 = liveData;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Object object;
        Object object2 = this.this$0.mDataLock;
        synchronized (object2) {
            Object object3;
            object = this.this$0;
            object = ((LiveData)object).mPendingData;
            LiveData liveData = this.this$0;
            liveData.mPendingData = object3 = LiveData.NOT_SET;
        }
        this.this$0.setValue(object);
    }
}

