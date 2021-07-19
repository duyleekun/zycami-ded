/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.paging.PagedList;
import androidx.paging.PagedList$BoundaryCallback;

public class PagedList$1
implements Runnable {
    public final /* synthetic */ PagedList this$0;
    public final /* synthetic */ boolean val$deferBegin;
    public final /* synthetic */ boolean val$deferEmpty;
    public final /* synthetic */ boolean val$deferEnd;

    public PagedList$1(PagedList pagedList, boolean bl2, boolean bl3, boolean bl4) {
        this.this$0 = pagedList;
        this.val$deferEmpty = bl2;
        this.val$deferBegin = bl3;
        this.val$deferEnd = bl4;
    }

    public void run() {
        Object object;
        boolean bl2 = this.val$deferEmpty;
        if (bl2) {
            object = this.this$0.mBoundaryCallback;
            ((PagedList$BoundaryCallback)object).onZeroItemsLoaded();
        }
        bl2 = this.val$deferBegin;
        boolean bl3 = true;
        if (bl2) {
            object = this.this$0;
            ((PagedList)object).mBoundaryCallbackBeginDeferred = bl3;
        }
        if (bl2 = this.val$deferEnd) {
            object = this.this$0;
            ((PagedList)object).mBoundaryCallbackEndDeferred = bl3;
        }
        this.this$0.tryDispatchBoundaryCallbacks(false);
    }
}

