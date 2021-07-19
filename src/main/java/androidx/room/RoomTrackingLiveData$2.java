/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

import androidx.lifecycle.LiveData;
import androidx.room.RoomTrackingLiveData;
import java.util.concurrent.atomic.AtomicBoolean;

public class RoomTrackingLiveData$2
implements Runnable {
    public final /* synthetic */ RoomTrackingLiveData this$0;

    public RoomTrackingLiveData$2(RoomTrackingLiveData roomTrackingLiveData) {
        this.this$0 = roomTrackingLiveData;
    }

    public void run() {
        Object object = this.this$0;
        boolean bl2 = ((LiveData)object).hasActiveObservers();
        Object object2 = this.this$0.mInvalid;
        boolean bl3 = true;
        boolean bl4 = ((AtomicBoolean)object2).compareAndSet(false, bl3);
        if (bl4 && bl2) {
            object = this.this$0.getQueryExecutor();
            object2 = this.this$0.mRefreshRunnable;
            object.execute((Runnable)object2);
        }
    }
}

