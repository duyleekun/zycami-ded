/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.paging.AsyncPagedListDiffer;
import androidx.paging.AsyncPagedListDiffer$2;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.DiffUtil$DiffResult;

public class AsyncPagedListDiffer$2$1
implements Runnable {
    public final /* synthetic */ AsyncPagedListDiffer$2 this$1;
    public final /* synthetic */ DiffUtil.DiffResult val$result;

    public AsyncPagedListDiffer$2$1(AsyncPagedListDiffer$2 var1_1, DiffUtil.DiffResult diffResult) {
        this.this$1 = var1_1;
        this.val$result = diffResult;
    }

    public void run() {
        AsyncPagedListDiffer$2 asyncPagedListDiffer$2 = this.this$1;
        AsyncPagedListDiffer asyncPagedListDiffer = asyncPagedListDiffer$2.this$0;
        int n10 = asyncPagedListDiffer.mMaxScheduledGeneration;
        int n11 = asyncPagedListDiffer$2.val$runGeneration;
        if (n10 == n11) {
            PagedList pagedList = asyncPagedListDiffer$2.val$pagedList;
            PagedList pagedList2 = asyncPagedListDiffer$2.val$newSnapshot;
            DiffUtil.DiffResult diffResult = this.val$result;
            PagedList pagedList3 = asyncPagedListDiffer$2.val$oldSnapshot;
            int n12 = pagedList3.mLastLoad;
            Runnable runnable = asyncPagedListDiffer$2.val$commitCallback;
            asyncPagedListDiffer.latchPagedList(pagedList, pagedList2, diffResult, n12, runnable);
        }
    }
}

