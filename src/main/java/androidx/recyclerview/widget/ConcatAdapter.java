/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.ViewGroup
 */
package androidx.recyclerview.widget;

import android.view.ViewGroup;
import androidx.recyclerview.widget.ConcatAdapter$Config;
import androidx.recyclerview.widget.ConcatAdapterController;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$Adapter$StateRestorationPolicy;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class ConcatAdapter
extends RecyclerView$Adapter {
    public static final String TAG = "ConcatAdapter";
    private final ConcatAdapterController mController;

    public ConcatAdapter(ConcatAdapter$Config object, List object2) {
        boolean bl2;
        ConcatAdapterController concatAdapterController;
        this.mController = concatAdapterController = new ConcatAdapterController(this, (ConcatAdapter$Config)object);
        object = object2.iterator();
        while (bl2 = object.hasNext()) {
            object2 = (RecyclerView$Adapter)object.next();
            this.addAdapter((RecyclerView$Adapter)object2);
        }
        boolean bl3 = this.mController.hasStableIds();
        super.setHasStableIds(bl3);
    }

    public ConcatAdapter(ConcatAdapter$Config concatAdapter$Config, RecyclerView$Adapter ... object) {
        object = Arrays.asList(object);
        this(concatAdapter$Config, (List)object);
    }

    public ConcatAdapter(List list) {
        ConcatAdapter$Config concatAdapter$Config = ConcatAdapter$Config.DEFAULT;
        this(concatAdapter$Config, list);
    }

    public ConcatAdapter(RecyclerView$Adapter ... recyclerView$AdapterArray) {
        ConcatAdapter$Config concatAdapter$Config = ConcatAdapter$Config.DEFAULT;
        this(concatAdapter$Config, recyclerView$AdapterArray);
    }

    public boolean addAdapter(int n10, RecyclerView$Adapter recyclerView$Adapter) {
        return this.mController.addAdapter(n10, recyclerView$Adapter);
    }

    public boolean addAdapter(RecyclerView$Adapter recyclerView$Adapter) {
        return this.mController.addAdapter(recyclerView$Adapter);
    }

    public int findRelativeAdapterPositionIn(RecyclerView$Adapter recyclerView$Adapter, RecyclerView$ViewHolder recyclerView$ViewHolder, int n10) {
        return this.mController.getLocalAdapterPosition(recyclerView$Adapter, recyclerView$ViewHolder, n10);
    }

    public List getAdapters() {
        return Collections.unmodifiableList(this.mController.getCopyOfAdapters());
    }

    public int getItemCount() {
        return this.mController.getTotalCount();
    }

    public long getItemId(int n10) {
        return this.mController.getItemId(n10);
    }

    public int getItemViewType(int n10) {
        return this.mController.getItemViewType(n10);
    }

    public void internalSetStateRestorationPolicy(RecyclerView$Adapter$StateRestorationPolicy recyclerView$Adapter$StateRestorationPolicy) {
        super.setStateRestorationPolicy(recyclerView$Adapter$StateRestorationPolicy);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        this.mController.onAttachedToRecyclerView(recyclerView);
    }

    public void onBindViewHolder(RecyclerView$ViewHolder recyclerView$ViewHolder, int n10) {
        this.mController.onBindViewHolder(recyclerView$ViewHolder, n10);
    }

    public RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int n10) {
        return this.mController.onCreateViewHolder(viewGroup, n10);
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        this.mController.onDetachedFromRecyclerView(recyclerView);
    }

    public boolean onFailedToRecycleView(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        return this.mController.onFailedToRecycleView(recyclerView$ViewHolder);
    }

    public void onViewAttachedToWindow(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        this.mController.onViewAttachedToWindow(recyclerView$ViewHolder);
    }

    public void onViewDetachedFromWindow(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        this.mController.onViewDetachedFromWindow(recyclerView$ViewHolder);
    }

    public void onViewRecycled(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        this.mController.onViewRecycled(recyclerView$ViewHolder);
    }

    public boolean removeAdapter(RecyclerView$Adapter recyclerView$Adapter) {
        return this.mController.removeAdapter(recyclerView$Adapter);
    }

    public void setHasStableIds(boolean bl2) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Calling setHasStableIds is not allowed on the ConcatAdapter. Use the Config object passed in the constructor to control this behavior");
        throw unsupportedOperationException;
    }

    public void setStateRestorationPolicy(RecyclerView$Adapter$StateRestorationPolicy object) {
        object = new UnsupportedOperationException("Calling setStateRestorationPolicy is not allowed on the ConcatAdapter. This value is inferred from added adapters");
        throw object;
    }
}

