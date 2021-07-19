/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

import androidx.room.InvalidationTracker;
import androidx.room.InvalidationTracker$Observer;
import java.lang.ref.WeakReference;
import java.util.Set;

public class InvalidationTracker$WeakObserver
extends InvalidationTracker$Observer {
    public final WeakReference mDelegateRef;
    public final InvalidationTracker mTracker;

    public InvalidationTracker$WeakObserver(InvalidationTracker weakReference, InvalidationTracker$Observer invalidationTracker$Observer) {
        String[] stringArray = invalidationTracker$Observer.mTables;
        super(stringArray);
        this.mTracker = weakReference;
        this.mDelegateRef = weakReference = new WeakReference<InvalidationTracker$Observer>(invalidationTracker$Observer);
    }

    public void onInvalidated(Set object) {
        InvalidationTracker$Observer invalidationTracker$Observer = (InvalidationTracker$Observer)this.mDelegateRef.get();
        if (invalidationTracker$Observer == null) {
            object = this.mTracker;
            ((InvalidationTracker)object).removeObserver(this);
        } else {
            invalidationTracker$Observer.onInvalidated((Set)object);
        }
    }
}

