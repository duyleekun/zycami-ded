/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.ViewGroup
 */
package androidx.recyclerview.widget;

import android.util.Log;
import android.view.ViewGroup;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.ConcatAdapter$Config;
import androidx.recyclerview.widget.ConcatAdapter$Config$StableIdMode;
import androidx.recyclerview.widget.ConcatAdapterController$WrapperAndLocalPosition;
import androidx.recyclerview.widget.NestedAdapterWrapper;
import androidx.recyclerview.widget.NestedAdapterWrapper$Callback;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$Adapter$StateRestorationPolicy;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import androidx.recyclerview.widget.StableIdStorage;
import androidx.recyclerview.widget.StableIdStorage$IsolatedStableIdStorage;
import androidx.recyclerview.widget.StableIdStorage$NoStableIdStorage;
import androidx.recyclerview.widget.StableIdStorage$SharedPoolStableIdStorage;
import androidx.recyclerview.widget.StableIdStorage$StableIdLookup;
import androidx.recyclerview.widget.ViewTypeStorage;
import androidx.recyclerview.widget.ViewTypeStorage$IsolatedViewTypeStorage;
import androidx.recyclerview.widget.ViewTypeStorage$SharedIdRangeViewTypeStorage;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;

public class ConcatAdapterController
implements NestedAdapterWrapper$Callback {
    private List mAttachedRecyclerViews;
    private final IdentityHashMap mBinderLookup;
    private final ConcatAdapter mConcatAdapter;
    private ConcatAdapterController$WrapperAndLocalPosition mReusableHolder;
    private final ConcatAdapter$Config$StableIdMode mStableIdMode;
    private final StableIdStorage mStableIdStorage;
    private final ViewTypeStorage mViewTypeStorage;
    private List mWrappers;

    public ConcatAdapterController(ConcatAdapter object, ConcatAdapter$Config object2) {
        block5: {
            block3: {
                block4: {
                    block2: {
                        Object object3 = new ArrayList();
                        this.mAttachedRecyclerViews = object3;
                        this.mBinderLookup = object3;
                        object3 = new ArrayList();
                        this.mWrappers = object3;
                        this.mReusableHolder = object3 = new ConcatAdapterController$WrapperAndLocalPosition();
                        this.mConcatAdapter = object;
                        boolean bl2 = object2.isolateViewTypes;
                        this.mViewTypeStorage = bl2 ? (object = new ViewTypeStorage$IsolatedViewTypeStorage()) : (object = new ViewTypeStorage$SharedIdRangeViewTypeStorage());
                        object = object2.stableIdMode;
                        this.mStableIdMode = object;
                        object2 = ConcatAdapter$Config$StableIdMode.NO_STABLE_IDS;
                        if (object != object2) break block2;
                        object = new StableIdStorage$NoStableIdStorage();
                        this.mStableIdStorage = object;
                        break block3;
                    }
                    object2 = ConcatAdapter$Config$StableIdMode.ISOLATED_STABLE_IDS;
                    if (object != object2) break block4;
                    object = new StableIdStorage$IsolatedStableIdStorage();
                    this.mStableIdStorage = object;
                    break block3;
                }
                object2 = ConcatAdapter$Config$StableIdMode.SHARED_STABLE_IDS;
                if (object != object2) break block5;
                object = new StableIdStorage$SharedPoolStableIdStorage();
                this.mStableIdStorage = object;
            }
            return;
        }
        object = new IllegalArgumentException("unknown stable id mode");
        throw object;
    }

    private void calculateAndUpdateStateRestorationPolicy() {
        Object object;
        RecyclerView$Adapter$StateRestorationPolicy recyclerView$Adapter$StateRestorationPolicy = this.computeStateRestorationPolicy();
        if (recyclerView$Adapter$StateRestorationPolicy != (object = this.mConcatAdapter.getStateRestorationPolicy())) {
            object = this.mConcatAdapter;
            ((ConcatAdapter)object).internalSetStateRestorationPolicy(recyclerView$Adapter$StateRestorationPolicy);
        }
    }

    private RecyclerView$Adapter$StateRestorationPolicy computeStateRestorationPolicy() {
        int n10;
        Iterator iterator2 = this.mWrappers.iterator();
        while ((n10 = iterator2.hasNext()) != 0) {
            RecyclerView$Adapter$StateRestorationPolicy recyclerView$Adapter$StateRestorationPolicy;
            NestedAdapterWrapper nestedAdapterWrapper = (NestedAdapterWrapper)iterator2.next();
            RecyclerView$Adapter$StateRestorationPolicy recyclerView$Adapter$StateRestorationPolicy2 = nestedAdapterWrapper.adapter.getStateRestorationPolicy();
            if (recyclerView$Adapter$StateRestorationPolicy2 == (recyclerView$Adapter$StateRestorationPolicy = RecyclerView$Adapter$StateRestorationPolicy.PREVENT)) {
                return recyclerView$Adapter$StateRestorationPolicy;
            }
            RecyclerView$Adapter$StateRestorationPolicy recyclerView$Adapter$StateRestorationPolicy3 = RecyclerView$Adapter$StateRestorationPolicy.PREVENT_WHEN_EMPTY;
            if (recyclerView$Adapter$StateRestorationPolicy2 != recyclerView$Adapter$StateRestorationPolicy3 || (n10 = nestedAdapterWrapper.getCachedItemCount()) != 0) continue;
            return recyclerView$Adapter$StateRestorationPolicy;
        }
        return RecyclerView$Adapter$StateRestorationPolicy.ALLOW;
    }

    private int countItemsBefore(NestedAdapterWrapper nestedAdapterWrapper) {
        NestedAdapterWrapper nestedAdapterWrapper2;
        int n10;
        Iterator iterator2 = this.mWrappers.iterator();
        int n11 = 0;
        while ((n10 = iterator2.hasNext()) != 0 && (nestedAdapterWrapper2 = (NestedAdapterWrapper)iterator2.next()) != nestedAdapterWrapper) {
            n10 = nestedAdapterWrapper2.getCachedItemCount();
            n11 += n10;
        }
        return n11;
    }

    private ConcatAdapterController$WrapperAndLocalPosition findWrapperAndLocalPosition(int n10) {
        int n11;
        Object object = this.mReusableHolder;
        boolean bl2 = ((ConcatAdapterController$WrapperAndLocalPosition)object).mInUse;
        if (bl2) {
            object = new ConcatAdapterController$WrapperAndLocalPosition();
        } else {
            ((ConcatAdapterController$WrapperAndLocalPosition)object).mInUse = bl2 = true;
        }
        Object object2 = this.mWrappers.iterator();
        int n12 = n10;
        while ((n11 = object2.hasNext()) != 0) {
            NestedAdapterWrapper nestedAdapterWrapper = (NestedAdapterWrapper)object2.next();
            int n13 = nestedAdapterWrapper.getCachedItemCount();
            if (n13 > n12) {
                ((ConcatAdapterController$WrapperAndLocalPosition)object).mWrapper = nestedAdapterWrapper;
                ((ConcatAdapterController$WrapperAndLocalPosition)object).mLocalPosition = n12;
                break;
            }
            n11 = nestedAdapterWrapper.getCachedItemCount();
            n12 -= n11;
        }
        if ((object2 = ((ConcatAdapterController$WrapperAndLocalPosition)object).mWrapper) != null) {
            return object;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Cannot find wrapper for ");
        ((StringBuilder)object2).append(n10);
        String string2 = ((StringBuilder)object2).toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    private NestedAdapterWrapper findWrapperFor(RecyclerView$Adapter recyclerView$Adapter) {
        int n10;
        int n11 = this.indexOfWrapper(recyclerView$Adapter);
        if (n11 == (n10 = -1)) {
            return null;
        }
        return (NestedAdapterWrapper)this.mWrappers.get(n11);
    }

    private NestedAdapterWrapper getWrapper(RecyclerView$ViewHolder object) {
        Object object2 = (NestedAdapterWrapper)this.mBinderLookup.get(object);
        if (object2 != null) {
            return object2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot find wrapper for ");
        stringBuilder.append(object);
        stringBuilder.append(", seems like it is not bound by this adapter: ");
        stringBuilder.append(this);
        object = stringBuilder.toString();
        object2 = new IllegalStateException((String)object);
        throw object2;
    }

    private int indexOfWrapper(RecyclerView$Adapter recyclerView$Adapter) {
        List list = this.mWrappers;
        int n10 = list.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            RecyclerView$Adapter recyclerView$Adapter2 = ((NestedAdapterWrapper)this.mWrappers.get((int)i10)).adapter;
            if (recyclerView$Adapter2 != recyclerView$Adapter) continue;
            return i10;
        }
        return -1;
    }

    private boolean isAttachedTo(RecyclerView recyclerView) {
        boolean bl2;
        Iterator iterator2 = this.mAttachedRecyclerViews.iterator();
        while (bl2 = iterator2.hasNext()) {
            Object t10 = ((WeakReference)iterator2.next()).get();
            if (t10 != recyclerView) continue;
            return true;
        }
        return false;
    }

    private void releaseWrapperAndLocalPosition(ConcatAdapterController$WrapperAndLocalPosition concatAdapterController$WrapperAndLocalPosition) {
        concatAdapterController$WrapperAndLocalPosition.mInUse = false;
        concatAdapterController$WrapperAndLocalPosition.mWrapper = null;
        concatAdapterController$WrapperAndLocalPosition.mLocalPosition = -1;
        this.mReusableHolder = concatAdapterController$WrapperAndLocalPosition;
    }

    public boolean addAdapter(int n10, RecyclerView$Adapter object) {
        Object object2;
        int n11;
        if (n10 >= 0 && n10 <= (n11 = (object2 = this.mWrappers).size())) {
            boolean bl2;
            Object object3;
            n11 = (int)(this.hasStableIds() ? 1 : 0);
            if (n11 != 0) {
                n11 = (int)(((RecyclerView$Adapter)object).hasStableIds() ? 1 : 0);
                object3 = "All sub adapters must have stable ids when stable id mode is ISOLATED_STABLE_IDS or SHARED_STABLE_IDS";
                Preconditions.checkArgument(n11 != 0, object3);
            } else {
                n11 = (int)(((RecyclerView$Adapter)object).hasStableIds() ? 1 : 0);
                if (n11 != 0) {
                    object2 = "ConcatAdapter";
                    object3 = "Stable ids in the adapter will be ignored as the ConcatAdapter is configured not to have stable ids";
                    Log.w((String)object2, (String)object3);
                }
            }
            object2 = this.findWrapperFor((RecyclerView$Adapter)object);
            if (object2 != null) {
                return false;
            }
            object3 = this.mViewTypeStorage;
            StableIdStorage$StableIdLookup stableIdStorage$StableIdLookup = this.mStableIdStorage.createStableIdLookup();
            object2 = new NestedAdapterWrapper((RecyclerView$Adapter)object, this, (ViewTypeStorage)object3, stableIdStorage$StableIdLookup);
            object3 = this.mWrappers;
            object3.add(n10, object2);
            Object object4 = this.mAttachedRecyclerViews.iterator();
            while (bl2 = object4.hasNext()) {
                object3 = (RecyclerView)((WeakReference)object4.next()).get();
                if (object3 == null) continue;
                ((RecyclerView$Adapter)object).onAttachedToRecyclerView((RecyclerView)object3);
            }
            n10 = ((NestedAdapterWrapper)object2).getCachedItemCount();
            if (n10 > 0) {
                object4 = this.mConcatAdapter;
                int n12 = this.countItemsBefore((NestedAdapterWrapper)object2);
                n11 = ((NestedAdapterWrapper)object2).getCachedItemCount();
                ((RecyclerView$Adapter)object4).notifyItemRangeInserted(n12, n11);
            }
            this.calculateAndUpdateStateRestorationPolicy();
            return true;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Index must be between 0 and ");
        int n13 = this.mWrappers.size();
        ((StringBuilder)object2).append(n13);
        ((StringBuilder)object2).append(". Given:");
        ((StringBuilder)object2).append(n10);
        String string2 = ((StringBuilder)object2).toString();
        object = new IndexOutOfBoundsException(string2);
        throw object;
    }

    public boolean addAdapter(RecyclerView$Adapter recyclerView$Adapter) {
        int n10 = this.mWrappers.size();
        return this.addAdapter(n10, recyclerView$Adapter);
    }

    public boolean canRestoreState() {
        boolean bl2;
        Iterator iterator2 = this.mWrappers.iterator();
        while (bl2 = iterator2.hasNext()) {
            RecyclerView$Adapter recyclerView$Adapter = ((NestedAdapterWrapper)iterator2.next()).adapter;
            bl2 = recyclerView$Adapter.canRestoreState();
            if (bl2) continue;
            return false;
        }
        return true;
    }

    public RecyclerView$Adapter getBoundAdapter(RecyclerView$ViewHolder object) {
        IdentityHashMap identityHashMap = this.mBinderLookup;
        if ((object = (NestedAdapterWrapper)identityHashMap.get(object)) == null) {
            return null;
        }
        return ((NestedAdapterWrapper)object).adapter;
    }

    public List getCopyOfAdapters() {
        boolean bl2;
        ArrayList<RecyclerView$Adapter> arrayList = this.mWrappers;
        boolean bl3 = arrayList.isEmpty();
        if (bl3) {
            return Collections.emptyList();
        }
        int n10 = this.mWrappers.size();
        arrayList = new ArrayList<RecyclerView$Adapter>(n10);
        Iterator iterator2 = this.mWrappers.iterator();
        while (bl2 = iterator2.hasNext()) {
            RecyclerView$Adapter recyclerView$Adapter = ((NestedAdapterWrapper)iterator2.next()).adapter;
            arrayList.add(recyclerView$Adapter);
        }
        return arrayList;
    }

    public long getItemId(int n10) {
        ConcatAdapterController$WrapperAndLocalPosition concatAdapterController$WrapperAndLocalPosition = this.findWrapperAndLocalPosition(n10);
        NestedAdapterWrapper nestedAdapterWrapper = concatAdapterController$WrapperAndLocalPosition.mWrapper;
        int n11 = concatAdapterController$WrapperAndLocalPosition.mLocalPosition;
        long l10 = nestedAdapterWrapper.getItemId(n11);
        this.releaseWrapperAndLocalPosition(concatAdapterController$WrapperAndLocalPosition);
        return l10;
    }

    public int getItemViewType(int n10) {
        ConcatAdapterController$WrapperAndLocalPosition concatAdapterController$WrapperAndLocalPosition = this.findWrapperAndLocalPosition(n10);
        NestedAdapterWrapper nestedAdapterWrapper = concatAdapterController$WrapperAndLocalPosition.mWrapper;
        int n11 = concatAdapterController$WrapperAndLocalPosition.mLocalPosition;
        int n12 = nestedAdapterWrapper.getItemViewType(n11);
        this.releaseWrapperAndLocalPosition(concatAdapterController$WrapperAndLocalPosition);
        return n12;
    }

    public int getLocalAdapterPosition(RecyclerView$Adapter object, RecyclerView$ViewHolder recyclerView$ViewHolder, int n10) {
        Object object2 = (NestedAdapterWrapper)this.mBinderLookup.get(recyclerView$ViewHolder);
        if (object2 == null) {
            return -1;
        }
        int n11 = this.countItemsBefore((NestedAdapterWrapper)object2);
        n10 -= n11;
        RecyclerView$Adapter recyclerView$Adapter = ((NestedAdapterWrapper)object2).adapter;
        n11 = recyclerView$Adapter.getItemCount();
        if (n10 >= 0 && n10 < n11) {
            return ((NestedAdapterWrapper)object2).adapter.findRelativeAdapterPositionIn((RecyclerView$Adapter)object, recyclerView$ViewHolder, n10);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Detected inconsistent adapter updates. The local position of the view holder maps to ");
        stringBuilder.append(n10);
        stringBuilder.append(" which is out of bounds for the adapter with size ");
        stringBuilder.append(n11);
        stringBuilder.append(".Make sure to immediately call notify methods in your adapter when you change the backing dataviewHolder:");
        stringBuilder.append(recyclerView$ViewHolder);
        stringBuilder.append("adapter:");
        stringBuilder.append(object);
        object = stringBuilder.toString();
        object2 = new IllegalStateException((String)object);
        throw object2;
    }

    public int getTotalCount() {
        int n10;
        Iterator iterator2 = this.mWrappers.iterator();
        int n11 = 0;
        while ((n10 = iterator2.hasNext()) != 0) {
            NestedAdapterWrapper nestedAdapterWrapper = (NestedAdapterWrapper)iterator2.next();
            n10 = nestedAdapterWrapper.getCachedItemCount();
            n11 += n10;
        }
        return n11;
    }

    public boolean hasStableIds() {
        boolean bl2;
        ConcatAdapter$Config$StableIdMode concatAdapter$Config$StableIdMode = this.mStableIdMode;
        ConcatAdapter$Config$StableIdMode concatAdapter$Config$StableIdMode2 = ConcatAdapter$Config$StableIdMode.NO_STABLE_IDS;
        if (concatAdapter$Config$StableIdMode != concatAdapter$Config$StableIdMode2) {
            bl2 = true;
        } else {
            bl2 = false;
            concatAdapter$Config$StableIdMode = null;
        }
        return bl2;
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        boolean bl2;
        boolean bl3 = this.isAttachedTo(recyclerView);
        if (bl3) {
            return;
        }
        Object object = this.mAttachedRecyclerViews;
        Object object2 = new WeakReference(recyclerView);
        object.add(object2);
        object = this.mWrappers.iterator();
        while (bl2 = object.hasNext()) {
            object2 = ((NestedAdapterWrapper)object.next()).adapter;
            ((RecyclerView$Adapter)object2).onAttachedToRecyclerView(recyclerView);
        }
    }

    public void onBindViewHolder(RecyclerView$ViewHolder recyclerView$ViewHolder, int n10) {
        ConcatAdapterController$WrapperAndLocalPosition concatAdapterController$WrapperAndLocalPosition = this.findWrapperAndLocalPosition(n10);
        Object object = this.mBinderLookup;
        NestedAdapterWrapper nestedAdapterWrapper = concatAdapterController$WrapperAndLocalPosition.mWrapper;
        ((IdentityHashMap)object).put(recyclerView$ViewHolder, nestedAdapterWrapper);
        object = concatAdapterController$WrapperAndLocalPosition.mWrapper;
        int n11 = concatAdapterController$WrapperAndLocalPosition.mLocalPosition;
        ((NestedAdapterWrapper)object).onBindViewHolder(recyclerView$ViewHolder, n11);
        this.releaseWrapperAndLocalPosition(concatAdapterController$WrapperAndLocalPosition);
    }

    public void onChanged(NestedAdapterWrapper nestedAdapterWrapper) {
        this.mConcatAdapter.notifyDataSetChanged();
        this.calculateAndUpdateStateRestorationPolicy();
    }

    public RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int n10) {
        return this.mViewTypeStorage.getWrapperForGlobalType(n10).onCreateViewHolder(viewGroup, n10);
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        boolean bl2;
        Object object;
        Object object2 = this.mAttachedRecyclerViews;
        for (int i10 = object2.size() + -1; i10 >= 0; i10 += -1) {
            object = (WeakReference)this.mAttachedRecyclerViews.get(i10);
            Object t10 = ((Reference)object).get();
            if (t10 == null) {
                object = this.mAttachedRecyclerViews;
                object.remove(i10);
                continue;
            }
            if ((object = ((Reference)object).get()) != recyclerView) continue;
            object = this.mAttachedRecyclerViews;
            object.remove(i10);
            break;
        }
        object2 = this.mWrappers.iterator();
        while (bl2 = object2.hasNext()) {
            object = ((NestedAdapterWrapper)object2.next()).adapter;
            ((RecyclerView$Adapter)object).onDetachedFromRecyclerView(recyclerView);
        }
    }

    public boolean onFailedToRecycleView(RecyclerView$ViewHolder object) {
        Object object2 = (NestedAdapterWrapper)this.mBinderLookup.get(object);
        if (object2 != null) {
            boolean bl2 = ((NestedAdapterWrapper)object2).adapter.onFailedToRecycleView((RecyclerView$ViewHolder)object);
            this.mBinderLookup.remove(object);
            return bl2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot find wrapper for ");
        stringBuilder.append(object);
        stringBuilder.append(", seems like it is not bound by this adapter: ");
        stringBuilder.append(this);
        object = stringBuilder.toString();
        object2 = new IllegalStateException((String)object);
        throw object2;
    }

    public void onItemRangeChanged(NestedAdapterWrapper nestedAdapterWrapper, int n10, int n11) {
        int n12 = this.countItemsBefore(nestedAdapterWrapper);
        ConcatAdapter concatAdapter = this.mConcatAdapter;
        concatAdapter.notifyItemRangeChanged(n10 += n12, n11);
    }

    public void onItemRangeChanged(NestedAdapterWrapper nestedAdapterWrapper, int n10, int n11, Object object) {
        int n12 = this.countItemsBefore(nestedAdapterWrapper);
        ConcatAdapter concatAdapter = this.mConcatAdapter;
        concatAdapter.notifyItemRangeChanged(n10 += n12, n11, object);
    }

    public void onItemRangeInserted(NestedAdapterWrapper nestedAdapterWrapper, int n10, int n11) {
        int n12 = this.countItemsBefore(nestedAdapterWrapper);
        ConcatAdapter concatAdapter = this.mConcatAdapter;
        concatAdapter.notifyItemRangeInserted(n10 += n12, n11);
    }

    public void onItemRangeMoved(NestedAdapterWrapper nestedAdapterWrapper, int n10, int n11) {
        int n12 = this.countItemsBefore(nestedAdapterWrapper);
        ConcatAdapter concatAdapter = this.mConcatAdapter;
        concatAdapter.notifyItemMoved(n10 += n12, n11 += n12);
    }

    public void onItemRangeRemoved(NestedAdapterWrapper nestedAdapterWrapper, int n10, int n11) {
        int n12 = this.countItemsBefore(nestedAdapterWrapper);
        ConcatAdapter concatAdapter = this.mConcatAdapter;
        concatAdapter.notifyItemRangeRemoved(n10 += n12, n11);
    }

    public void onStateRestorationPolicyChanged(NestedAdapterWrapper nestedAdapterWrapper) {
        this.calculateAndUpdateStateRestorationPolicy();
    }

    public void onViewAttachedToWindow(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        this.getWrapper((RecyclerView$ViewHolder)recyclerView$ViewHolder).adapter.onViewAttachedToWindow(recyclerView$ViewHolder);
    }

    public void onViewDetachedFromWindow(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        this.getWrapper((RecyclerView$ViewHolder)recyclerView$ViewHolder).adapter.onViewDetachedFromWindow(recyclerView$ViewHolder);
    }

    public void onViewRecycled(RecyclerView$ViewHolder object) {
        Object object2 = (NestedAdapterWrapper)this.mBinderLookup.get(object);
        if (object2 != null) {
            ((NestedAdapterWrapper)object2).adapter.onViewRecycled((RecyclerView$ViewHolder)object);
            this.mBinderLookup.remove(object);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot find wrapper for ");
        stringBuilder.append(object);
        stringBuilder.append(", seems like it is not bound by this adapter: ");
        stringBuilder.append(this);
        object = stringBuilder.toString();
        object2 = new IllegalStateException((String)object);
        throw object2;
    }

    public boolean removeAdapter(RecyclerView$Adapter recyclerView$Adapter) {
        int n10;
        int n11 = this.indexOfWrapper(recyclerView$Adapter);
        if (n11 == (n10 = -1)) {
            return false;
        }
        NestedAdapterWrapper nestedAdapterWrapper = (NestedAdapterWrapper)this.mWrappers.get(n11);
        int n12 = this.countItemsBefore(nestedAdapterWrapper);
        List list = this.mWrappers;
        list.remove(n11);
        Object object = this.mConcatAdapter;
        int n13 = nestedAdapterWrapper.getCachedItemCount();
        ((RecyclerView$Adapter)object).notifyItemRangeRemoved(n12, n13);
        object = this.mAttachedRecyclerViews.iterator();
        while ((n12 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            RecyclerView recyclerView = (RecyclerView)((WeakReference)object.next()).get();
            if (recyclerView == null) continue;
            recyclerView$Adapter.onDetachedFromRecyclerView(recyclerView);
        }
        nestedAdapterWrapper.dispose();
        this.calculateAndUpdateStateRestorationPolicy();
        return true;
    }
}

