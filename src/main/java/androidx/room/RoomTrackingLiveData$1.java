/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

import androidx.room.InvalidationTracker;
import androidx.room.InvalidationTracker$Observer;
import androidx.room.RoomTrackingLiveData;
import java.util.concurrent.atomic.AtomicBoolean;

public class RoomTrackingLiveData$1
implements Runnable {
    public final /* synthetic */ RoomTrackingLiveData this$0;

    public RoomTrackingLiveData$1(RoomTrackingLiveData roomTrackingLiveData) {
        this.this$0 = roomTrackingLiveData;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Object object;
        Object object2 = this.this$0.mRegisteredObserver;
        boolean bl3 = true;
        boolean bl4 = ((AtomicBoolean)object2).compareAndSet(false, bl3);
        if (bl4) {
            object2 = this.this$0.mDatabase.getInvalidationTracker();
            object = this.this$0.mObserver;
            ((InvalidationTracker)object2).addWeakObserver((InvalidationTracker$Observer)object);
        }
        do {
            if (!(bl4 = ((AtomicBoolean)(object2 = this.this$0.mComputing)).compareAndSet(false, bl3))) return;
            bl4 = false;
            object2 = null;
            boolean bl2 = false;
            object = null;
            try {
                Object object3;
                while (true) {
                    object3 = this.this$0;
                    object3 = ((RoomTrackingLiveData)object3).mInvalid;
                    boolean bl5 = ((AtomicBoolean)object3).compareAndSet(bl3, false);
                    if (!bl5) break;
                    try {
                        object2 = this.this$0;
                        object2 = ((RoomTrackingLiveData)object2).mComputeFunction;
                        object2 = object2.call();
                        bl2 = bl3;
                    }
                    catch (Exception exception) {
                        object = "Exception while computing database live data.";
                        RuntimeException runtimeException = new RuntimeException((String)object, exception);
                        throw runtimeException;
                    }
                }
                if (bl2) {
                    object3 = this.this$0;
                    RoomTrackingLiveData.access$000((RoomTrackingLiveData)object3, object2);
                }
                object2 = this.this$0.mComputing;
                ((AtomicBoolean)object2).set(false);
            }
            catch (Throwable throwable) {
                this.this$0.mComputing.set(false);
                throw throwable;
            }
            if (!bl2) return;
        } while (bl4 = ((AtomicBoolean)(object2 = this.this$0.mInvalid)).get());
    }
}

