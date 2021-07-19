/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

import androidx.room.InvalidationTracker;
import androidx.room.MultiInstanceInvalidationClient$1;

public class MultiInstanceInvalidationClient$1$1
implements Runnable {
    public final /* synthetic */ MultiInstanceInvalidationClient$1 this$1;
    public final /* synthetic */ String[] val$tables;

    public MultiInstanceInvalidationClient$1$1(MultiInstanceInvalidationClient$1 var1_1, String[] stringArray) {
        this.this$1 = var1_1;
        this.val$tables = stringArray;
    }

    public void run() {
        InvalidationTracker invalidationTracker = this.this$1.this$0.mInvalidationTracker;
        String[] stringArray = this.val$tables;
        invalidationTracker.notifyObserversByTableNames(stringArray);
    }
}

