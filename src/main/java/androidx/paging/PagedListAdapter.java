/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.paging.AsyncPagedListDiffer;
import androidx.paging.AsyncPagedListDiffer$PagedListListener;
import androidx.paging.PagedList;
import androidx.paging.PagedListAdapter$1;
import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil$ItemCallback;
import androidx.recyclerview.widget.RecyclerView$Adapter;

public abstract class PagedListAdapter
extends RecyclerView$Adapter {
    public final AsyncPagedListDiffer mDiffer;
    private final AsyncPagedListDiffer$PagedListListener mListener;

    public PagedListAdapter(AsyncDifferConfig asyncDifferConfig) {
        AsyncPagedListDiffer asyncPagedListDiffer;
        PagedListAdapter$1 pagedListAdapter$1 = new PagedListAdapter$1(this);
        this.mListener = pagedListAdapter$1;
        AdapterListUpdateCallback adapterListUpdateCallback = new AdapterListUpdateCallback(this);
        this.mDiffer = asyncPagedListDiffer = new AsyncPagedListDiffer(adapterListUpdateCallback, asyncDifferConfig);
        asyncPagedListDiffer.addPagedListListener(pagedListAdapter$1);
    }

    public PagedListAdapter(DiffUtil$ItemCallback diffUtil$ItemCallback) {
        AsyncPagedListDiffer asyncPagedListDiffer;
        PagedListAdapter$1 pagedListAdapter$1 = new PagedListAdapter$1(this);
        this.mListener = pagedListAdapter$1;
        this.mDiffer = asyncPagedListDiffer = new AsyncPagedListDiffer(this, diffUtil$ItemCallback);
        asyncPagedListDiffer.addPagedListListener(pagedListAdapter$1);
    }

    public PagedList getCurrentList() {
        return this.mDiffer.getCurrentList();
    }

    public Object getItem(int n10) {
        return this.mDiffer.getItem(n10);
    }

    public int getItemCount() {
        return this.mDiffer.getItemCount();
    }

    public void onCurrentListChanged(PagedList pagedList) {
    }

    public void onCurrentListChanged(PagedList pagedList, PagedList pagedList2) {
    }

    public void submitList(PagedList pagedList) {
        this.mDiffer.submitList(pagedList);
    }

    public void submitList(PagedList pagedList, Runnable runnable) {
        this.mDiffer.submitList(pagedList, runnable);
    }
}

