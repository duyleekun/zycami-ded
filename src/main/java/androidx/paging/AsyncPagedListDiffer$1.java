/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.paging.AsyncPagedListDiffer;
import androidx.paging.PagedList$Callback;

public class AsyncPagedListDiffer$1
extends PagedList$Callback {
    public final /* synthetic */ AsyncPagedListDiffer this$0;

    public AsyncPagedListDiffer$1(AsyncPagedListDiffer asyncPagedListDiffer) {
        this.this$0 = asyncPagedListDiffer;
    }

    public void onChanged(int n10, int n11) {
        this.this$0.mUpdateCallback.onChanged(n10, n11, null);
    }

    public void onInserted(int n10, int n11) {
        this.this$0.mUpdateCallback.onInserted(n10, n11);
    }

    public void onRemoved(int n10, int n11) {
        this.this$0.mUpdateCallback.onRemoved(n10, n11);
    }
}

