/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

import androidx.room.InvalidationTracker;
import androidx.room.InvalidationTracker$Observer;
import androidx.room.MultiInstanceInvalidationClient;

public class MultiInstanceInvalidationClient$4
implements Runnable {
    public final /* synthetic */ MultiInstanceInvalidationClient this$0;

    public MultiInstanceInvalidationClient$4(MultiInstanceInvalidationClient multiInstanceInvalidationClient) {
        this.this$0 = multiInstanceInvalidationClient;
    }

    public void run() {
        Object object = this.this$0;
        InvalidationTracker invalidationTracker = ((MultiInstanceInvalidationClient)object).mInvalidationTracker;
        object = ((MultiInstanceInvalidationClient)object).mObserver;
        invalidationTracker.removeObserver((InvalidationTracker$Observer)object);
    }
}

