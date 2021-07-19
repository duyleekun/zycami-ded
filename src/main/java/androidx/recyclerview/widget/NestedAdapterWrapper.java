/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.ViewGroup
 */
package androidx.recyclerview.widget;

import android.view.ViewGroup;
import androidx.recyclerview.widget.NestedAdapterWrapper$1;
import androidx.recyclerview.widget.NestedAdapterWrapper$Callback;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$AdapterDataObserver;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import androidx.recyclerview.widget.StableIdStorage$StableIdLookup;
import androidx.recyclerview.widget.ViewTypeStorage;
import androidx.recyclerview.widget.ViewTypeStorage$ViewTypeLookup;

public class NestedAdapterWrapper {
    public final RecyclerView$Adapter adapter;
    private RecyclerView$AdapterDataObserver mAdapterObserver;
    public int mCachedItemCount;
    public final NestedAdapterWrapper$Callback mCallback;
    private final StableIdStorage$StableIdLookup mStableIdLookup;
    private final ViewTypeStorage$ViewTypeLookup mViewTypeLookup;

    public NestedAdapterWrapper(RecyclerView$Adapter recyclerView$Adapter, NestedAdapterWrapper$Callback object, ViewTypeStorage viewTypeStorage, StableIdStorage$StableIdLookup stableIdLookup) {
        int n10;
        NestedAdapterWrapper$1 nestedAdapterWrapper$1 = new NestedAdapterWrapper$1(this);
        this.mAdapterObserver = nestedAdapterWrapper$1;
        this.adapter = recyclerView$Adapter;
        this.mCallback = object;
        this.mViewTypeLookup = object = viewTypeStorage.createViewTypeWrapper(this);
        this.mStableIdLookup = stableIdLookup;
        this.mCachedItemCount = n10 = recyclerView$Adapter.getItemCount();
        object = this.mAdapterObserver;
        recyclerView$Adapter.registerAdapterDataObserver((RecyclerView$AdapterDataObserver)object);
    }

    public void dispose() {
        RecyclerView$Adapter recyclerView$Adapter = this.adapter;
        RecyclerView$AdapterDataObserver recyclerView$AdapterDataObserver = this.mAdapterObserver;
        recyclerView$Adapter.unregisterAdapterDataObserver(recyclerView$AdapterDataObserver);
        this.mViewTypeLookup.dispose();
    }

    public int getCachedItemCount() {
        return this.mCachedItemCount;
    }

    public long getItemId(int n10) {
        long l10 = this.adapter.getItemId(n10);
        return this.mStableIdLookup.localToGlobal(l10);
    }

    public int getItemViewType(int n10) {
        ViewTypeStorage$ViewTypeLookup viewTypeStorage$ViewTypeLookup = this.mViewTypeLookup;
        n10 = this.adapter.getItemViewType(n10);
        return viewTypeStorage$ViewTypeLookup.localToGlobal(n10);
    }

    public void onBindViewHolder(RecyclerView$ViewHolder recyclerView$ViewHolder, int n10) {
        this.adapter.bindViewHolder(recyclerView$ViewHolder, n10);
    }

    public RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int n10) {
        n10 = this.mViewTypeLookup.globalToLocal(n10);
        return this.adapter.onCreateViewHolder(viewGroup, n10);
    }
}

