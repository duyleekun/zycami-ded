/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

import androidx.room.InvalidationTracker;
import androidx.room.InvalidationTracker$Observer;
import androidx.room.RxRoom$3;
import e.a.v0.a;

public class RxRoom$3$2
implements a {
    public final /* synthetic */ RxRoom$3 this$0;
    public final /* synthetic */ InvalidationTracker$Observer val$observer;

    public RxRoom$3$2(RxRoom$3 rxRoom$3, InvalidationTracker$Observer invalidationTracker$Observer) {
        this.this$0 = rxRoom$3;
        this.val$observer = invalidationTracker$Observer;
    }

    public void run() {
        InvalidationTracker invalidationTracker = this.this$0.val$database.getInvalidationTracker();
        InvalidationTracker$Observer invalidationTracker$Observer = this.val$observer;
        invalidationTracker.removeObserver(invalidationTracker$Observer);
    }
}

