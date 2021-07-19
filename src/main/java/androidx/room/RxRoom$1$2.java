/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

import androidx.room.InvalidationTracker;
import androidx.room.InvalidationTracker$Observer;
import androidx.room.RxRoom$1;
import e.a.v0.a;

public class RxRoom$1$2
implements a {
    public final /* synthetic */ RxRoom$1 this$0;
    public final /* synthetic */ InvalidationTracker$Observer val$observer;

    public RxRoom$1$2(RxRoom$1 rxRoom$1, InvalidationTracker$Observer invalidationTracker$Observer) {
        this.this$0 = rxRoom$1;
        this.val$observer = invalidationTracker$Observer;
    }

    public void run() {
        InvalidationTracker invalidationTracker = this.this$0.val$database.getInvalidationTracker();
        InvalidationTracker$Observer invalidationTracker$Observer = this.val$observer;
        invalidationTracker.removeObserver(invalidationTracker$Observer);
    }
}

