/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.paging.AsyncPagedListDiffer$PagedListListener;
import androidx.paging.PagedList;
import androidx.paging.PagedListAdapter;

public class PagedListAdapter$1
implements AsyncPagedListDiffer$PagedListListener {
    public final /* synthetic */ PagedListAdapter this$0;

    public PagedListAdapter$1(PagedListAdapter pagedListAdapter) {
        this.this$0 = pagedListAdapter;
    }

    public void onCurrentListChanged(PagedList pagedList, PagedList pagedList2) {
        this.this$0.onCurrentListChanged(pagedList2);
        this.this$0.onCurrentListChanged(pagedList, pagedList2);
    }
}

