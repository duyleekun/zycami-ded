/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.paging.PagedList;

public class PagedList$2
implements Runnable {
    public final /* synthetic */ PagedList this$0;
    public final /* synthetic */ boolean val$dispatchBegin;
    public final /* synthetic */ boolean val$dispatchEnd;

    public PagedList$2(PagedList pagedList, boolean bl2, boolean bl3) {
        this.this$0 = pagedList;
        this.val$dispatchBegin = bl2;
        this.val$dispatchEnd = bl3;
    }

    public void run() {
        PagedList pagedList = this.this$0;
        boolean bl2 = this.val$dispatchBegin;
        boolean bl3 = this.val$dispatchEnd;
        pagedList.dispatchBoundaryCallbacks(bl2, bl3);
    }
}

