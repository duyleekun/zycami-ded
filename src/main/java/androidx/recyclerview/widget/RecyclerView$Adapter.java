/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.ViewGroup
 */
package androidx.recyclerview.widget;

import android.view.ViewGroup;
import androidx.core.os.TraceCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$7;
import androidx.recyclerview.widget.RecyclerView$Adapter$StateRestorationPolicy;
import androidx.recyclerview.widget.RecyclerView$AdapterDataObservable;
import androidx.recyclerview.widget.RecyclerView$AdapterDataObserver;
import androidx.recyclerview.widget.RecyclerView$LayoutParams;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import java.util.List;

public abstract class RecyclerView$Adapter {
    private boolean mHasStableIds;
    private final RecyclerView$AdapterDataObservable mObservable;
    private RecyclerView$Adapter$StateRestorationPolicy mStateRestorationPolicy;

    public RecyclerView$Adapter() {
        Object object;
        this.mObservable = object = new RecyclerView$AdapterDataObservable();
        this.mHasStableIds = false;
        object = RecyclerView$Adapter$StateRestorationPolicy.ALLOW;
        this.mStateRestorationPolicy = object;
    }

    public final void bindViewHolder(RecyclerView$ViewHolder object, int n10) {
        Object object2;
        int n11;
        RecyclerView$Adapter recyclerView$Adapter = object.mBindingAdapter;
        int n12 = 1;
        if (recyclerView$Adapter == null) {
            n11 = n12;
        } else {
            n11 = 0;
            recyclerView$Adapter = null;
        }
        if (n11 != 0) {
            object.mPosition = n10;
            int n13 = this.hasStableIds();
            if (n13 != 0) {
                long l10;
                object.mItemId = l10 = this.getItemId(n10);
            }
            n13 = 519;
            object.setFlags(n12, n13);
            object2 = "RV OnBindView";
            TraceCompat.beginSection((String)object2);
        }
        object.mBindingAdapter = this;
        object2 = object.getUnmodifiedPayloads();
        this.onBindViewHolder((RecyclerView$ViewHolder)object, n10, (List)object2);
        if (n11 != 0) {
            object.clearPayload();
            object = object.itemView.getLayoutParams();
            n10 = object instanceof RecyclerView$LayoutParams;
            if (n10 != 0) {
                object = (RecyclerView$LayoutParams)((Object)object);
                ((RecyclerView$LayoutParams)object).mInsetsDirty = n12;
            }
            TraceCompat.endSection();
        }
    }

    public boolean canRestoreState() {
        int[] nArray = RecyclerView$7.$SwitchMap$androidx$recyclerview$widget$RecyclerView$Adapter$StateRestorationPolicy;
        int n10 = this.mStateRestorationPolicy.ordinal();
        int n11 = nArray[n10];
        n10 = 0;
        int n12 = 1;
        if (n11 != n12) {
            int n13 = 2;
            if (n11 != n13) {
                return n12 != 0;
            }
            n11 = this.getItemCount();
            if (n11 > 0) {
                n10 = n12;
            }
        }
        return n10 != 0;
    }

    public final RecyclerView$ViewHolder createViewHolder(ViewGroup object, int n10) {
        block9: {
            String string2 = "RV CreateView";
            TraceCompat.beginSection(string2);
            object = this.onCreateViewHolder((ViewGroup)object, n10);
            string2 = object.itemView;
            string2 = string2.getParent();
            if (string2 != null) break block9;
            object.mItemViewType = n10;
            return object;
        }
        String string3 = "ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)";
        try {
            object = new IllegalStateException(string3);
            throw object;
        }
        finally {
            TraceCompat.endSection();
        }
    }

    public int findRelativeAdapterPositionIn(RecyclerView$Adapter recyclerView$Adapter, RecyclerView$ViewHolder recyclerView$ViewHolder, int n10) {
        if (recyclerView$Adapter == this) {
            return n10;
        }
        return -1;
    }

    public abstract int getItemCount();

    public long getItemId(int n10) {
        return -1;
    }

    public int getItemViewType(int n10) {
        return 0;
    }

    public final RecyclerView$Adapter$StateRestorationPolicy getStateRestorationPolicy() {
        return this.mStateRestorationPolicy;
    }

    public final boolean hasObservers() {
        return this.mObservable.hasObservers();
    }

    public final boolean hasStableIds() {
        return this.mHasStableIds;
    }

    public final void notifyDataSetChanged() {
        this.mObservable.notifyChanged();
    }

    public final void notifyItemChanged(int n10) {
        this.mObservable.notifyItemRangeChanged(n10, 1);
    }

    public final void notifyItemChanged(int n10, Object object) {
        this.mObservable.notifyItemRangeChanged(n10, 1, object);
    }

    public final void notifyItemInserted(int n10) {
        this.mObservable.notifyItemRangeInserted(n10, 1);
    }

    public final void notifyItemMoved(int n10, int n11) {
        this.mObservable.notifyItemMoved(n10, n11);
    }

    public final void notifyItemRangeChanged(int n10, int n11) {
        this.mObservable.notifyItemRangeChanged(n10, n11);
    }

    public final void notifyItemRangeChanged(int n10, int n11, Object object) {
        this.mObservable.notifyItemRangeChanged(n10, n11, object);
    }

    public final void notifyItemRangeInserted(int n10, int n11) {
        this.mObservable.notifyItemRangeInserted(n10, n11);
    }

    public final void notifyItemRangeRemoved(int n10, int n11) {
        this.mObservable.notifyItemRangeRemoved(n10, n11);
    }

    public final void notifyItemRemoved(int n10) {
        this.mObservable.notifyItemRangeRemoved(n10, 1);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
    }

    public abstract void onBindViewHolder(RecyclerView$ViewHolder var1, int var2);

    public void onBindViewHolder(RecyclerView$ViewHolder recyclerView$ViewHolder, int n10, List list) {
        this.onBindViewHolder(recyclerView$ViewHolder, n10);
    }

    public abstract RecyclerView$ViewHolder onCreateViewHolder(ViewGroup var1, int var2);

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
    }

    public boolean onFailedToRecycleView(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        return false;
    }

    public void onViewAttachedToWindow(RecyclerView$ViewHolder recyclerView$ViewHolder) {
    }

    public void onViewDetachedFromWindow(RecyclerView$ViewHolder recyclerView$ViewHolder) {
    }

    public void onViewRecycled(RecyclerView$ViewHolder recyclerView$ViewHolder) {
    }

    public void registerAdapterDataObserver(RecyclerView$AdapterDataObserver recyclerView$AdapterDataObserver) {
        this.mObservable.registerObserver(recyclerView$AdapterDataObserver);
    }

    public void setHasStableIds(boolean bl2) {
        boolean bl3 = this.hasObservers();
        if (!bl3) {
            this.mHasStableIds = bl2;
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        throw illegalStateException;
    }

    public void setStateRestorationPolicy(RecyclerView$Adapter$StateRestorationPolicy recyclerView$Adapter$StateRestorationPolicy) {
        this.mStateRestorationPolicy = recyclerView$Adapter$StateRestorationPolicy;
        this.mObservable.notifyStateRestorationPolicyChanged();
    }

    public void unregisterAdapterDataObserver(RecyclerView$AdapterDataObserver recyclerView$AdapterDataObserver) {
        this.mObservable.unregisterObserver(recyclerView$AdapterDataObserver);
    }
}

