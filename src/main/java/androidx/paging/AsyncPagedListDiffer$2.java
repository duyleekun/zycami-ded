/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.paging.AsyncPagedListDiffer;
import androidx.paging.AsyncPagedListDiffer$2$1;
import androidx.paging.PagedList;
import androidx.paging.PagedStorage;
import androidx.paging.PagedStorageDiffHelper;
import androidx.recyclerview.widget.DiffUtil$DiffResult;
import androidx.recyclerview.widget.DiffUtil$ItemCallback;

public class AsyncPagedListDiffer$2
implements Runnable {
    public final /* synthetic */ AsyncPagedListDiffer this$0;
    public final /* synthetic */ Runnable val$commitCallback;
    public final /* synthetic */ PagedList val$newSnapshot;
    public final /* synthetic */ PagedList val$oldSnapshot;
    public final /* synthetic */ PagedList val$pagedList;
    public final /* synthetic */ int val$runGeneration;

    public AsyncPagedListDiffer$2(AsyncPagedListDiffer asyncPagedListDiffer, PagedList pagedList, PagedList pagedList2, int n10, PagedList pagedList3, Runnable runnable) {
        this.this$0 = asyncPagedListDiffer;
        this.val$oldSnapshot = pagedList;
        this.val$newSnapshot = pagedList2;
        this.val$runGeneration = n10;
        this.val$pagedList = pagedList3;
        this.val$commitCallback = runnable;
    }

    public void run() {
        Object object = this.val$oldSnapshot.mStorage;
        Object object2 = this.val$newSnapshot.mStorage;
        Object object3 = this.this$0.mConfig.getDiffCallback();
        object = PagedStorageDiffHelper.computeDiff((PagedStorage)object, (PagedStorage)object2, (DiffUtil$ItemCallback)object3);
        object2 = this.this$0.mMainThreadExecutor;
        object3 = new AsyncPagedListDiffer$2$1(this, (DiffUtil$DiffResult)object);
        object2.execute((Runnable)object3);
    }
}

