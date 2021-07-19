/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.AsyncDifferConfig$Builder;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.AsyncListDiffer$ListListener;
import androidx.recyclerview.widget.DiffUtil$ItemCallback;
import androidx.recyclerview.widget.ListAdapter$1;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import java.util.List;

public abstract class ListAdapter
extends RecyclerView$Adapter {
    public final AsyncListDiffer mDiffer;
    private final AsyncListDiffer$ListListener mListener;

    public ListAdapter(AsyncDifferConfig asyncDifferConfig) {
        AsyncListDiffer asyncListDiffer;
        ListAdapter$1 listAdapter$1 = new ListAdapter$1(this);
        this.mListener = listAdapter$1;
        AdapterListUpdateCallback adapterListUpdateCallback = new AdapterListUpdateCallback(this);
        this.mDiffer = asyncListDiffer = new AsyncListDiffer(adapterListUpdateCallback, asyncDifferConfig);
        asyncListDiffer.addListListener(listAdapter$1);
    }

    public ListAdapter(DiffUtil$ItemCallback object) {
        AsyncListDiffer asyncListDiffer;
        ListAdapter$1 listAdapter$1 = new ListAdapter$1(this);
        this.mListener = listAdapter$1;
        AdapterListUpdateCallback adapterListUpdateCallback = new AdapterListUpdateCallback(this);
        AsyncDifferConfig$Builder asyncDifferConfig$Builder = new AsyncDifferConfig$Builder((DiffUtil$ItemCallback)object);
        object = asyncDifferConfig$Builder.build();
        this.mDiffer = asyncListDiffer = new AsyncListDiffer(adapterListUpdateCallback, (AsyncDifferConfig)object);
        asyncListDiffer.addListListener(listAdapter$1);
    }

    public List getCurrentList() {
        return this.mDiffer.getCurrentList();
    }

    public Object getItem(int n10) {
        return this.mDiffer.getCurrentList().get(n10);
    }

    public int getItemCount() {
        return this.mDiffer.getCurrentList().size();
    }

    public void onCurrentListChanged(List list, List list2) {
    }

    public void submitList(List list) {
        this.mDiffer.submitList(list);
    }

    public void submitList(List list, Runnable runnable) {
        this.mDiffer.submitList(list, runnable);
    }
}

