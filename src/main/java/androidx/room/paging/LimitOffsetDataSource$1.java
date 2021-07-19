/*
 * Decompiled with CFR 0.151.
 */
package androidx.room.paging;

import androidx.room.InvalidationTracker$Observer;
import androidx.room.paging.LimitOffsetDataSource;
import java.util.Set;

public class LimitOffsetDataSource$1
extends InvalidationTracker$Observer {
    public final /* synthetic */ LimitOffsetDataSource this$0;

    public LimitOffsetDataSource$1(LimitOffsetDataSource limitOffsetDataSource, String[] stringArray) {
        this.this$0 = limitOffsetDataSource;
        super(stringArray);
    }

    public void onInvalidated(Set set) {
        this.this$0.invalidate();
    }
}

