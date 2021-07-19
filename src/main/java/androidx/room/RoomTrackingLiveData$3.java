/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.executor.TaskExecutor;
import androidx.room.InvalidationTracker$Observer;
import androidx.room.RoomTrackingLiveData;
import java.util.Set;

public class RoomTrackingLiveData$3
extends InvalidationTracker$Observer {
    public final /* synthetic */ RoomTrackingLiveData this$0;

    public RoomTrackingLiveData$3(RoomTrackingLiveData roomTrackingLiveData, String[] stringArray) {
        this.this$0 = roomTrackingLiveData;
        super(stringArray);
    }

    public void onInvalidated(Set object) {
        object = ArchTaskExecutor.getInstance();
        Runnable runnable = this.this$0.mInvalidationRunnable;
        ((TaskExecutor)object).executeOnMainThread(runnable);
    }
}

