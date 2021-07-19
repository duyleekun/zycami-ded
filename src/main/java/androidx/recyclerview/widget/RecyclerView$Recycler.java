/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 */
package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.AdapterHelper;
import androidx.recyclerview.widget.ChildHelper;
import androidx.recyclerview.widget.GapWorker$LayoutPrefetchRegistryImpl;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ItemAnimator;
import androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemHolderInfo;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView$LayoutParams;
import androidx.recyclerview.widget.RecyclerView$RecycledViewPool;
import androidx.recyclerview.widget.RecyclerView$RecyclerListener;
import androidx.recyclerview.widget.RecyclerView$State;
import androidx.recyclerview.widget.RecyclerView$ViewCacheExtension;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate$ItemDelegate;
import androidx.recyclerview.widget.ViewInfoStore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class RecyclerView$Recycler {
    public static final int DEFAULT_CACHE_SIZE = 2;
    public final ArrayList mAttachedScrap;
    public final ArrayList mCachedViews;
    public ArrayList mChangedScrap;
    public RecyclerView$RecycledViewPool mRecyclerPool;
    private int mRequestedCacheMax;
    private final List mUnmodifiableAttachedScrap;
    private RecyclerView$ViewCacheExtension mViewCacheExtension;
    public int mViewCacheMax;
    public final /* synthetic */ RecyclerView this$0;

    public RecyclerView$Recycler(RecyclerView list) {
        int n10;
        ArrayList arrayList;
        this.this$0 = list;
        this.mAttachedScrap = list = new List();
        this.mChangedScrap = null;
        this.mCachedViews = arrayList = new ArrayList();
        this.mUnmodifiableAttachedScrap = list = Collections.unmodifiableList(list);
        this.mRequestedCacheMax = n10 = 2;
        this.mViewCacheMax = n10;
    }

    private void attachAccessibilityDelegateOnBind(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        Object object = this.this$0;
        boolean n10 = ((RecyclerView)object).isAccessibilityEnabled();
        if (n10) {
            recyclerView$ViewHolder = recyclerView$ViewHolder.itemView;
            int n11 = ViewCompat.getImportantForAccessibility((View)recyclerView$ViewHolder);
            if (n11 == 0) {
                int n12 = 1;
                ViewCompat.setImportantForAccessibility((View)recyclerView$ViewHolder, n12);
            }
            if ((object = this.this$0.mAccessibilityDelegate) == null) {
                return;
            }
            boolean bl2 = (object = ((RecyclerViewAccessibilityDelegate)object).getItemDelegate()) instanceof RecyclerViewAccessibilityDelegate$ItemDelegate;
            if (bl2) {
                Object object2 = object;
                object2 = (RecyclerViewAccessibilityDelegate$ItemDelegate)object;
                ((RecyclerViewAccessibilityDelegate$ItemDelegate)object2).saveOriginalDelegate((View)recyclerView$ViewHolder);
            }
            ViewCompat.setAccessibilityDelegate((View)recyclerView$ViewHolder, (AccessibilityDelegateCompat)object);
        }
    }

    private void invalidateDisplayListInt(ViewGroup viewGroup, boolean n10) {
        int n11 = viewGroup.getChildCount();
        int n12 = 1;
        n11 -= n12;
        while (n11 >= 0) {
            View view = viewGroup.getChildAt(n11);
            boolean bl2 = view instanceof ViewGroup;
            if (bl2) {
                view = (ViewGroup)view;
                this.invalidateDisplayListInt((ViewGroup)view, n12 != 0);
            }
            n11 += -1;
        }
        if (n10 == 0) {
            return;
        }
        n10 = viewGroup.getVisibility();
        if (n10 == (n11 = 4)) {
            n10 = 0;
            viewGroup.setVisibility(0);
            viewGroup.setVisibility(n11);
        } else {
            n10 = viewGroup.getVisibility();
            viewGroup.setVisibility(n11);
            viewGroup.setVisibility(n10);
        }
    }

    private void invalidateDisplayListInt(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        recyclerView$ViewHolder = recyclerView$ViewHolder.itemView;
        boolean bl2 = recyclerView$ViewHolder instanceof ViewGroup;
        if (bl2) {
            recyclerView$ViewHolder = (ViewGroup)recyclerView$ViewHolder;
            bl2 = false;
            this.invalidateDisplayListInt((ViewGroup)recyclerView$ViewHolder, false);
        }
    }

    private boolean tryBindViewHolderByDeadline(RecyclerView$ViewHolder recyclerView$ViewHolder, int n10, int n11, long l10) {
        RecyclerView$RecycledViewPool recyclerView$RecycledViewPool;
        boolean bl2;
        RecyclerView recyclerView;
        recyclerView$ViewHolder.mBindingAdapter = null;
        recyclerView$ViewHolder.mOwnerRecyclerView = recyclerView = this.this$0;
        int n12 = recyclerView$ViewHolder.getItemViewType();
        recyclerView = this.this$0;
        long l11 = recyclerView.getNanoTime();
        long l12 = Long.MAX_VALUE;
        long l13 = l10 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object != false && !(bl2 = (recyclerView$RecycledViewPool = this.mRecyclerPool).willBindInTime(n12, l11, l10))) {
            return false;
        }
        RecyclerView$Adapter recyclerView$Adapter = this.this$0.mAdapter;
        recyclerView$Adapter.bindViewHolder(recyclerView$ViewHolder, n10);
        l10 = this.this$0.getNanoTime();
        Object object2 = this.mRecyclerPool;
        object = recyclerView$ViewHolder.getItemViewType();
        ((RecyclerView$RecycledViewPool)object2).factorInBindTime((int)object, l10 -= l11);
        this.attachAccessibilityDelegateOnBind(recyclerView$ViewHolder);
        object2 = this.this$0.mState;
        n10 = (int)(((RecyclerView$State)object2).isPreLayout() ? 1 : 0);
        if (n10 != 0) {
            recyclerView$ViewHolder.mPreLayoutPosition = n11;
        }
        return true;
    }

    public void addViewHolderToRecycledViewPool(RecyclerView$ViewHolder recyclerView$ViewHolder, boolean bl2) {
        RecyclerView.clearNestedRecyclerViewIfNotNested(recyclerView$ViewHolder);
        View view = recyclerView$ViewHolder.itemView;
        AccessibilityDelegateCompat accessibilityDelegateCompat = this.this$0.mAccessibilityDelegate;
        if (accessibilityDelegateCompat != null) {
            boolean bl3 = (accessibilityDelegateCompat = accessibilityDelegateCompat.getItemDelegate()) instanceof RecyclerViewAccessibilityDelegate$ItemDelegate;
            accessibilityDelegateCompat = bl3 ? ((RecyclerViewAccessibilityDelegate$ItemDelegate)accessibilityDelegateCompat).getAndRemoveOriginalDelegateForItem(view) : null;
            ViewCompat.setAccessibilityDelegate(view, accessibilityDelegateCompat);
        }
        if (bl2) {
            this.dispatchViewRecycled(recyclerView$ViewHolder);
        }
        recyclerView$ViewHolder.mBindingAdapter = null;
        recyclerView$ViewHolder.mOwnerRecyclerView = null;
        this.getRecycledViewPool().putRecycledView(recyclerView$ViewHolder);
    }

    public void bindViewToPosition(View object, int n10) {
        if ((object = RecyclerView.getChildViewHolderInt(object)) != null) {
            int n11;
            Object object2 = this.this$0.mAdapterHelper;
            int n12 = ((AdapterHelper)object2).findPositionOffset(n10);
            if (n12 >= 0 && n12 < (n11 = ((RecyclerView$Adapter)(object2 = this.this$0.mAdapter)).getItemCount())) {
                long l10 = Long.MAX_VALUE;
                object2 = this;
                this.tryBindViewHolderByDeadline((RecyclerView$ViewHolder)object, n12, n10, l10);
                Object object3 = object.itemView.getLayoutParams();
                if (object3 == null) {
                    object3 = (RecyclerView$LayoutParams)this.this$0.generateDefaultLayoutParams();
                    object2 = object.itemView;
                    object2.setLayoutParams(object3);
                } else {
                    object2 = this.this$0;
                    n11 = (int)(((RecyclerView)object2).checkLayoutParams((ViewGroup.LayoutParams)object3) ? 1 : 0);
                    if (n11 == 0) {
                        object3 = (RecyclerView$LayoutParams)this.this$0.generateLayoutParams((ViewGroup.LayoutParams)object3);
                        object2 = object.itemView;
                        object2.setLayoutParams(object3);
                    } else {
                        object3 = (RecyclerView$LayoutParams)((Object)object3);
                    }
                }
                n11 = 1;
                object3.mInsetsDirty = n11;
                object3.mViewHolder = object;
                object = object.itemView.getParent();
                if (object != null) {
                    n11 = 0;
                    object2 = null;
                }
                object3.mPendingInvalidate = n11;
                return;
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Inconsistency detected. Invalid item position ");
            ((StringBuilder)object2).append(n10);
            ((StringBuilder)object2).append("(offset:");
            ((StringBuilder)object2).append(n12);
            ((StringBuilder)object2).append(").state:");
            n10 = this.this$0.mState.getItemCount();
            ((StringBuilder)object2).append(n10);
            String string2 = this.this$0.exceptionLabel();
            ((StringBuilder)object2).append(string2);
            string2 = ((StringBuilder)object2).toString();
            object = new IndexOutOfBoundsException(string2);
            throw object;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter");
        String string3 = this.this$0.exceptionLabel();
        charSequence.append(string3);
        charSequence = charSequence.toString();
        object = new IllegalArgumentException((String)charSequence);
        throw object;
    }

    public void clear() {
        this.mAttachedScrap.clear();
        this.recycleAndClearCachedViews();
    }

    public void clearOldPositions() {
        RecyclerView$ViewHolder recyclerView$ViewHolder;
        int n10;
        ArrayList arrayList = this.mCachedViews;
        int n11 = arrayList.size();
        int n12 = 0;
        RecyclerView$ViewHolder recyclerView$ViewHolder2 = null;
        for (n10 = 0; n10 < n11; ++n10) {
            recyclerView$ViewHolder = (RecyclerView$ViewHolder)this.mCachedViews.get(n10);
            recyclerView$ViewHolder.clearOldPosition();
        }
        arrayList = this.mAttachedScrap;
        n11 = arrayList.size();
        recyclerView$ViewHolder2 = null;
        for (n10 = 0; n10 < n11; ++n10) {
            recyclerView$ViewHolder = (RecyclerView$ViewHolder)this.mAttachedScrap.get(n10);
            recyclerView$ViewHolder.clearOldPosition();
        }
        arrayList = this.mChangedScrap;
        if (arrayList != null) {
            n11 = arrayList.size();
            while (n12 < n11) {
                recyclerView$ViewHolder2 = (RecyclerView$ViewHolder)this.mChangedScrap.get(n12);
                recyclerView$ViewHolder2.clearOldPosition();
                ++n12;
            }
        }
    }

    public void clearScrap() {
        this.mAttachedScrap.clear();
        ArrayList arrayList = this.mChangedScrap;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public int convertPreLayoutPositionToPostLayout(int n10) {
        Object object;
        int n11;
        if (n10 >= 0 && n10 < (n11 = ((RecyclerView$State)(object = this.this$0.mState)).getItemCount())) {
            object = this.this$0.mState;
            n11 = (int)(((RecyclerView$State)object).isPreLayout() ? 1 : 0);
            if (n11 == 0) {
                return n10;
            }
            return this.this$0.mAdapterHelper.findPositionOffset(n10);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("invalid position ");
        stringBuilder.append(n10);
        stringBuilder.append(". State item count is ");
        n10 = this.this$0.mState.getItemCount();
        stringBuilder.append(n10);
        String string2 = this.this$0.exceptionLabel();
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        object = new IndexOutOfBoundsException(string2);
        throw object;
    }

    public void dispatchViewRecycled(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        Object object = this.this$0.mRecyclerListener;
        if (object != null) {
            object.onViewRecycled(recyclerView$ViewHolder);
        }
        object = this.this$0.mRecyclerListeners;
        int n10 = object.size();
        RecyclerView$State recyclerView$State = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            RecyclerView$RecyclerListener recyclerView$RecyclerListener = (RecyclerView$RecyclerListener)this.this$0.mRecyclerListeners.get(i10);
            recyclerView$RecyclerListener.onViewRecycled(recyclerView$ViewHolder);
        }
        object = this.this$0.mAdapter;
        if (object != null) {
            ((RecyclerView$Adapter)object).onViewRecycled(recyclerView$ViewHolder);
        }
        object = this.this$0;
        recyclerView$State = ((RecyclerView)object).mState;
        if (recyclerView$State != null) {
            object = ((RecyclerView)object).mViewInfoStore;
            ((ViewInfoStore)object).removeViewHolder(recyclerView$ViewHolder);
        }
    }

    public RecyclerView$ViewHolder getChangedScrapViewForPosition(int n10) {
        int n11;
        ArrayList arrayList = this.mChangedScrap;
        if (arrayList != null && (n11 = arrayList.size()) != 0) {
            int n12;
            int n13 = 0;
            int n14 = 0;
            Object object = null;
            while (true) {
                n12 = 32;
                if (n14 >= n11) break;
                RecyclerView$ViewHolder recyclerView$ViewHolder = (RecyclerView$ViewHolder)this.mChangedScrap.get(n14);
                int n15 = recyclerView$ViewHolder.wasReturnedFromScrap();
                if (n15 == 0 && (n15 = recyclerView$ViewHolder.getLayoutPosition()) == n10) {
                    recyclerView$ViewHolder.addFlags(n12);
                    return recyclerView$ViewHolder;
                }
                ++n14;
            }
            object = this.this$0.mAdapter;
            n14 = (int)(((RecyclerView$Adapter)object).hasStableIds() ? 1 : 0);
            if (n14 != 0 && (n10 = ((AdapterHelper)(object = this.this$0.mAdapterHelper)).findPositionOffset(n10)) > 0 && n10 < (n14 = ((RecyclerView$Adapter)(object = this.this$0.mAdapter)).getItemCount())) {
                object = this.this$0.mAdapter;
                long l10 = ((RecyclerView$Adapter)object).getItemId(n10);
                while (n13 < n11) {
                    long l11;
                    long l12;
                    RecyclerView$ViewHolder recyclerView$ViewHolder = (RecyclerView$ViewHolder)this.mChangedScrap.get(n13);
                    n14 = (int)(recyclerView$ViewHolder.wasReturnedFromScrap() ? 1 : 0);
                    if (n14 == 0 && (n14 = (int)((l12 = (l11 = recyclerView$ViewHolder.getItemId()) - l10) == 0L ? 0 : (l12 < 0L ? -1 : 1))) == 0) {
                        recyclerView$ViewHolder.addFlags(n12);
                        return recyclerView$ViewHolder;
                    }
                    ++n13;
                }
            }
        }
        return null;
    }

    public RecyclerView$RecycledViewPool getRecycledViewPool() {
        RecyclerView$RecycledViewPool recyclerView$RecycledViewPool = this.mRecyclerPool;
        if (recyclerView$RecycledViewPool == null) {
            this.mRecyclerPool = recyclerView$RecycledViewPool = new RecyclerView$RecycledViewPool();
        }
        return this.mRecyclerPool;
    }

    public int getScrapCount() {
        return this.mAttachedScrap.size();
    }

    public List getScrapList() {
        return this.mUnmodifiableAttachedScrap;
    }

    public RecyclerView$ViewHolder getScrapOrCachedViewForId(long l10, int n10, boolean bl2) {
        Object object;
        RecyclerView$ViewHolder recyclerView$ViewHolder;
        int n11;
        ArrayList arrayList = this.mAttachedScrap;
        for (n11 = arrayList.size() + -1; n11 >= 0; n11 += -1) {
            recyclerView$ViewHolder = (RecyclerView$ViewHolder)this.mAttachedScrap.get(n11);
            long l11 = recyclerView$ViewHolder.getItemId();
            long l12 = l11 - l10;
            Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2 != false || (object2 = (Object)recyclerView$ViewHolder.wasReturnedFromScrap()) != false) continue;
            object2 = recyclerView$ViewHolder.getItemViewType();
            if (n10 == object2) {
                RecyclerView$State recyclerView$State;
                recyclerView$ViewHolder.addFlags(32);
                int n12 = recyclerView$ViewHolder.isRemoved();
                if (n12 != 0 && (n12 = (recyclerView$State = this.this$0.mState).isPreLayout()) == 0) {
                    n12 = 2;
                    int n13 = 14;
                    recyclerView$ViewHolder.setFlags(n12, n13);
                }
                return recyclerView$ViewHolder;
            }
            if (bl2) continue;
            this.mAttachedScrap.remove(n11);
            object = this.this$0;
            View view = recyclerView$ViewHolder.itemView;
            ((RecyclerView)object).removeDetachedView(view, false);
            recyclerView$ViewHolder = recyclerView$ViewHolder.itemView;
            this.quickRecycleScrapView((View)recyclerView$ViewHolder);
        }
        arrayList = this.mCachedViews;
        n11 = arrayList.size() + -1;
        while (true) {
            recyclerView$ViewHolder = null;
            if (n11 < 0) break;
            object = (RecyclerView$ViewHolder)this.mCachedViews.get(n11);
            long l13 = ((RecyclerView$ViewHolder)object).getItemId();
            long l14 = l13 - l10;
            Object object3 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object3 == false && (object3 = (Object)((RecyclerView$ViewHolder)object).isAttachedToTransitionOverlay()) == false) {
                object3 = ((RecyclerView$ViewHolder)object).getItemViewType();
                if (n10 == object3) {
                    if (!bl2) {
                        ArrayList arrayList2 = this.mCachedViews;
                        arrayList2.remove(n11);
                    }
                    return object;
                }
                if (!bl2) {
                    this.recycleCachedViewAt(n11);
                    return null;
                }
            }
            n11 += -1;
        }
        return null;
    }

    public RecyclerView$ViewHolder getScrapOrHiddenOrCachedHolderForPosition(int n10, boolean n11) {
        Serializable serializable = this.mAttachedScrap;
        int n12 = ((ArrayList)serializable).size();
        int n13 = 0;
        RecyclerView$ViewHolder recyclerView$ViewHolder = null;
        for (int i10 = 0; i10 < n12; ++i10) {
            RecyclerView$ViewHolder recyclerView$ViewHolder2 = (RecyclerView$ViewHolder)this.mAttachedScrap.get(i10);
            int n14 = recyclerView$ViewHolder2.wasReturnedFromScrap();
            if (n14 != 0 || (n14 = recyclerView$ViewHolder2.getLayoutPosition()) != n10 || (n14 = (int)(recyclerView$ViewHolder2.isInvalid() ? 1 : 0)) != 0) continue;
            RecyclerView$State recyclerView$State = this.this$0.mState;
            n14 = (int)(recyclerView$State.mInPreLayout ? 1 : 0);
            if (n14 == 0 && (n14 = (int)(recyclerView$ViewHolder2.isRemoved() ? 1 : 0)) != 0) continue;
            recyclerView$ViewHolder2.addFlags(32);
            return recyclerView$ViewHolder2;
        }
        if (n11 == 0 && (serializable = this.this$0.mChildHelper.findHiddenNonRemovedView(n10)) != null) {
            Object object = RecyclerView.getChildViewHolderInt((View)serializable);
            this.this$0.mChildHelper.unhide((View)serializable);
            Object object2 = this.this$0.mChildHelper;
            n11 = ((ChildHelper)object2).indexOfChild((View)serializable);
            n13 = -1;
            if (n11 != n13) {
                this.this$0.mChildHelper.detachViewFromParent(n11);
                this.scrapView((View)serializable);
                ((RecyclerView$ViewHolder)object).addFlags(8224);
                return object;
            }
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append("layout index should not be -1 after unhiding a view:");
            ((StringBuilder)serializable).append(object);
            object = this.this$0.exceptionLabel();
            ((StringBuilder)serializable).append((String)object);
            object = ((StringBuilder)serializable).toString();
            object2 = new IllegalStateException((String)object);
            throw object2;
        }
        serializable = this.mCachedViews;
        n12 = ((ArrayList)serializable).size();
        while (n13 < n12) {
            recyclerView$ViewHolder = (RecyclerView$ViewHolder)this.mCachedViews.get(n13);
            int n15 = recyclerView$ViewHolder.isInvalid();
            if (n15 == 0 && (n15 = recyclerView$ViewHolder.getLayoutPosition()) == n10 && (n15 = (int)(recyclerView$ViewHolder.isAttachedToTransitionOverlay() ? 1 : 0)) == 0) {
                if (n11 == 0) {
                    ArrayList arrayList = this.mCachedViews;
                    arrayList.remove(n13);
                }
                return recyclerView$ViewHolder;
            }
            ++n13;
        }
        return null;
    }

    public View getScrapViewAt(int n10) {
        return ((RecyclerView$ViewHolder)this.mAttachedScrap.get((int)n10)).itemView;
    }

    public View getViewForPosition(int n10) {
        return this.getViewForPosition(n10, false);
    }

    public View getViewForPosition(int n10, boolean bl2) {
        return this.tryGetViewHolderForPositionByDeadline((int)n10, (boolean)bl2, (long)0x7FFFFFFFFFFFFFFFL).itemView;
    }

    public void markItemDecorInsetsDirty() {
        ArrayList arrayList = this.mCachedViews;
        int n10 = arrayList.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2;
            RecyclerView$LayoutParams recyclerView$LayoutParams = (RecyclerView$LayoutParams)((RecyclerView$ViewHolder)this.mCachedViews.get((int)i10)).itemView.getLayoutParams();
            if (recyclerView$LayoutParams == null) continue;
            recyclerView$LayoutParams.mInsetsDirty = bl2 = true;
        }
    }

    public void markKnownViewsInvalid() {
        Object object = this.mCachedViews;
        int n10 = ((ArrayList)object).size();
        for (int i10 = 0; i10 < n10; ++i10) {
            RecyclerView$ViewHolder recyclerView$ViewHolder = (RecyclerView$ViewHolder)this.mCachedViews.get(i10);
            if (recyclerView$ViewHolder == null) continue;
            recyclerView$ViewHolder.addFlags(6);
            recyclerView$ViewHolder.addChangePayload(null);
        }
        object = this.this$0.mAdapter;
        if (object == null || (n10 = (int)(((RecyclerView$Adapter)object).hasStableIds() ? 1 : 0)) == 0) {
            this.recycleAndClearCachedViews();
        }
    }

    public void offsetPositionRecordsForInsert(int n10, int n11) {
        ArrayList arrayList = this.mCachedViews;
        int n12 = arrayList.size();
        for (int i10 = 0; i10 < n12; ++i10) {
            int n13;
            RecyclerView$ViewHolder recyclerView$ViewHolder = (RecyclerView$ViewHolder)this.mCachedViews.get(i10);
            if (recyclerView$ViewHolder == null || (n13 = recyclerView$ViewHolder.mPosition) < n10) continue;
            recyclerView$ViewHolder.offsetPosition(n11, false);
        }
    }

    public void offsetPositionRecordsForMove(int n10, int n11) {
        int n12;
        int n13;
        int n14;
        if (n10 < n11) {
            n14 = -1;
            n13 = n10;
            n12 = n11;
        } else {
            n14 = 1;
            n12 = n10;
            n13 = n11;
        }
        ArrayList arrayList = this.mCachedViews;
        int n15 = arrayList.size();
        for (int i10 = 0; i10 < n15; ++i10) {
            int n16;
            RecyclerView$ViewHolder recyclerView$ViewHolder = (RecyclerView$ViewHolder)this.mCachedViews.get(i10);
            if (recyclerView$ViewHolder == null || (n16 = recyclerView$ViewHolder.mPosition) < n13 || n16 > n12) continue;
            if (n16 == n10) {
                n16 = n11 - n10;
                recyclerView$ViewHolder.offsetPosition(n16, false);
                continue;
            }
            recyclerView$ViewHolder.offsetPosition(n14, false);
        }
    }

    public void offsetPositionRecordsForRemove(int n10, int n11, boolean bl2) {
        int n12 = n10 + n11;
        ArrayList arrayList = this.mCachedViews;
        for (int i10 = arrayList.size() + -1; i10 >= 0; i10 += -1) {
            RecyclerView$ViewHolder recyclerView$ViewHolder = (RecyclerView$ViewHolder)this.mCachedViews.get(i10);
            if (recyclerView$ViewHolder == null) continue;
            int n13 = recyclerView$ViewHolder.mPosition;
            if (n13 >= n12) {
                n13 = -n11;
                recyclerView$ViewHolder.offsetPosition(n13, bl2);
                continue;
            }
            if (n13 < n10) continue;
            n13 = 8;
            recyclerView$ViewHolder.addFlags(n13);
            this.recycleCachedViewAt(i10);
        }
    }

    public void onAdapterChanged(RecyclerView$Adapter recyclerView$Adapter, RecyclerView$Adapter recyclerView$Adapter2, boolean bl2) {
        this.clear();
        this.getRecycledViewPool().onAdapterChanged(recyclerView$Adapter, recyclerView$Adapter2, bl2);
    }

    public void quickRecycleScrapView(View object) {
        object = RecyclerView.getChildViewHolderInt((View)object);
        ((RecyclerView$ViewHolder)object).mScrapContainer = null;
        ((RecyclerView$ViewHolder)object).mInChangeScrap = false;
        ((RecyclerView$ViewHolder)object).clearReturnedFromScrapFlag();
        this.recycleViewHolderInternal((RecyclerView$ViewHolder)object);
    }

    public void recycleAndClearCachedViews() {
        int n10;
        Object object = this.mCachedViews;
        for (n10 = ((ArrayList)object).size() + -1; n10 >= 0; n10 += -1) {
            this.recycleCachedViewAt(n10);
        }
        object = this.mCachedViews;
        ((ArrayList)object).clear();
        n10 = (int)(RecyclerView.ALLOW_THREAD_GAP_WORK ? 1 : 0);
        if (n10 != 0) {
            object = this.this$0.mPrefetchRegistry;
            ((GapWorker$LayoutPrefetchRegistryImpl)object).clearPrefetchPositions();
        }
    }

    public void recycleCachedViewAt(int n10) {
        RecyclerView$ViewHolder recyclerView$ViewHolder = (RecyclerView$ViewHolder)this.mCachedViews.get(n10);
        this.addViewHolderToRecycledViewPool(recyclerView$ViewHolder, true);
        this.mCachedViews.remove(n10);
    }

    public void recycleView(View object) {
        boolean bl2;
        RecyclerView$ViewHolder recyclerView$ViewHolder = RecyclerView.getChildViewHolderInt((View)object);
        boolean bl3 = recyclerView$ViewHolder.isTmpDetached();
        if (bl3) {
            RecyclerView recyclerView = this.this$0;
            recyclerView.removeDetachedView((View)object, false);
        }
        if (bl2 = recyclerView$ViewHolder.isScrap()) {
            recyclerView$ViewHolder.unScrap();
        } else {
            bl2 = recyclerView$ViewHolder.wasReturnedFromScrap();
            if (bl2) {
                recyclerView$ViewHolder.clearReturnedFromScrapFlag();
            }
        }
        this.recycleViewHolderInternal(recyclerView$ViewHolder);
        object = this.this$0.mItemAnimator;
        if (object != null && !(bl2 = recyclerView$ViewHolder.isRecyclable())) {
            object = this.this$0.mItemAnimator;
            ((RecyclerView$ItemAnimator)object).endAnimation(recyclerView$ViewHolder);
        }
    }

    public void recycleViewHolderInternal(RecyclerView$ViewHolder object) {
        Object object2;
        boolean bl2 = ((RecyclerView$ViewHolder)object).isScrap();
        int n10 = 0;
        CharSequence charSequence = null;
        int n11 = 1;
        float f10 = Float.MIN_VALUE;
        if (!bl2 && (object2 = ((RecyclerView$ViewHolder)object).itemView.getParent()) == null) {
            bl2 = ((RecyclerView$ViewHolder)object).isTmpDetached();
            if (!bl2) {
                bl2 = ((RecyclerView$ViewHolder)object).shouldIgnore();
                if (!bl2) {
                    int n12;
                    bl2 = ((RecyclerView$ViewHolder)object).doesTransientStatePreventRecycling();
                    Object object3 = this.this$0.mAdapter;
                    if (object3 != null && bl2 && (n12 = ((RecyclerView$Adapter)object3).onFailedToRecycleView((RecyclerView$ViewHolder)object)) != 0) {
                        n12 = n11;
                    } else {
                        n12 = 0;
                        object3 = null;
                    }
                    if (n12 == 0 && (n12 = ((RecyclerView$ViewHolder)object).isRecyclable()) == 0) {
                        n11 = 0;
                        f10 = 0.0f;
                    } else {
                        n12 = this.mViewCacheMax;
                        if (n12 > 0 && (n12 = (int)(((RecyclerView$ViewHolder)object).hasAnyOfTheFlags(526) ? 1 : 0)) == 0) {
                            int n13;
                            Object object4;
                            int n14;
                            object3 = this.mCachedViews;
                            n12 = ((ArrayList)object3).size();
                            if (n12 >= (n14 = this.mViewCacheMax) && n12 > 0) {
                                this.recycleCachedViewAt(0);
                                n12 += -1;
                            }
                            if ((n14 = (int)(RecyclerView.ALLOW_THREAD_GAP_WORK ? 1 : 0)) != 0 && n12 > 0 && (n14 = (int)(((GapWorker$LayoutPrefetchRegistryImpl)(object4 = this.this$0.mPrefetchRegistry)).lastPrefetchIncludedPosition(n13 = ((RecyclerView$ViewHolder)object).mPosition) ? 1 : 0)) == 0) {
                                n12 += -1;
                                while (n12 >= 0) {
                                    object4 = (RecyclerView$ViewHolder)this.mCachedViews.get(n12);
                                    n14 = ((RecyclerView$ViewHolder)object4).mPosition;
                                    GapWorker$LayoutPrefetchRegistryImpl gapWorker$LayoutPrefetchRegistryImpl = this.this$0.mPrefetchRegistry;
                                    if ((n14 = (int)(gapWorker$LayoutPrefetchRegistryImpl.lastPrefetchIncludedPosition(n14) ? 1 : 0)) == 0) break;
                                    n12 += -1;
                                }
                                n12 += n11;
                            }
                            object4 = this.mCachedViews;
                            ((ArrayList)object4).add(n12, object);
                            n12 = n11;
                        } else {
                            n12 = 0;
                            object3 = null;
                        }
                        if (n12 == 0) {
                            this.addViewHolderToRecycledViewPool((RecyclerView$ViewHolder)object, n11 != 0);
                        } else {
                            n11 = 0;
                            f10 = 0.0f;
                        }
                        n10 = n12;
                    }
                    object3 = this.this$0.mViewInfoStore;
                    ((ViewInfoStore)object3).removeViewHolder((RecyclerView$ViewHolder)object);
                    if (n10 == 0 && n11 == 0 && bl2) {
                        bl2 = false;
                        object2 = null;
                        ((RecyclerView$ViewHolder)object).mBindingAdapter = null;
                        ((RecyclerView$ViewHolder)object).mOwnerRecyclerView = null;
                    }
                    return;
                }
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
                charSequence = this.this$0.exceptionLabel();
                ((StringBuilder)object2).append((String)charSequence);
                object2 = ((StringBuilder)object2).toString();
                object = new IllegalArgumentException((String)object2);
                throw object;
            }
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
            ((StringBuilder)charSequence).append(object);
            object = this.this$0.exceptionLabel();
            ((StringBuilder)charSequence).append((String)object);
            object = ((StringBuilder)charSequence).toString();
            object2 = new IllegalArgumentException((String)object);
            throw object2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Scrapped or attached views may not be recycled. isScrap:");
        boolean bl3 = ((RecyclerView$ViewHolder)object).isScrap();
        stringBuilder.append(bl3);
        String string2 = " isAttached:";
        stringBuilder.append(string2);
        object = ((RecyclerView$ViewHolder)object).itemView.getParent();
        if (object != null) {
            n10 = n11;
        }
        stringBuilder.append(n10 != 0);
        object = this.this$0.exceptionLabel();
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }

    public void scrapView(View object) {
        Object object2;
        boolean bl2 = ((RecyclerView$ViewHolder)(object = RecyclerView.getChildViewHolderInt((View)object))).hasAnyOfTheFlags(12);
        if (!bl2 && (bl2 = ((RecyclerView$ViewHolder)object).isUpdated()) && !(bl2 = ((RecyclerView)(object2 = this.this$0)).canReuseUpdatedViewHolder((RecyclerView$ViewHolder)object))) {
            object2 = this.mChangedScrap;
            if (object2 == null) {
                object2 = new ArrayList();
                this.mChangedScrap = object2;
            }
            bl2 = true;
            ((RecyclerView$ViewHolder)object).setScrapContainer(this, bl2);
            object2 = this.mChangedScrap;
            ((ArrayList)object2).add(object);
        } else {
            bl2 = ((RecyclerView$ViewHolder)object).isInvalid();
            if (bl2 && !(bl2 = ((RecyclerView$ViewHolder)object).isRemoved()) && !(bl2 = ((RecyclerView$Adapter)(object2 = this.this$0.mAdapter)).hasStableIds())) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
                String string2 = this.this$0.exceptionLabel();
                ((StringBuilder)object2).append(string2);
                object2 = ((StringBuilder)object2).toString();
                object = new IllegalArgumentException((String)object2);
                throw object;
            }
            bl2 = false;
            ((RecyclerView$ViewHolder)object).setScrapContainer(this, false);
            object2 = this.mAttachedScrap;
            ((ArrayList)object2).add(object);
        }
    }

    public void setRecycledViewPool(RecyclerView$RecycledViewPool object) {
        RecyclerView$RecycledViewPool recyclerView$RecycledViewPool = this.mRecyclerPool;
        if (recyclerView$RecycledViewPool != null) {
            recyclerView$RecycledViewPool.detach();
        }
        this.mRecyclerPool = object;
        if (object != null && (object = this.this$0.getAdapter()) != null) {
            object = this.mRecyclerPool;
            ((RecyclerView$RecycledViewPool)object).attach();
        }
    }

    public void setViewCacheExtension(RecyclerView$ViewCacheExtension viewCacheExtension) {
        this.mViewCacheExtension = viewCacheExtension;
    }

    public void setViewCacheSize(int n10) {
        this.mRequestedCacheMax = n10;
        this.updateViewCacheSize();
    }

    /*
     * Unable to fully structure code
     */
    public RecyclerView$ViewHolder tryGetViewHolderForPositionByDeadline(int var1_1, boolean var2_2, long var3_3) {
        block26: {
            block33: {
                block32: {
                    block30: {
                        block31: {
                            block29: {
                                block28: {
                                    block27: {
                                        var5_4 = this;
                                        var6_5 = var1_1;
                                        var7_6 = var2_2;
                                        if (var1_1 < 0 || var1_1 >= (var9_8 = (var8_7 = this.this$0.mState).getItemCount())) break block26;
                                        var8_7 = this.this$0.mState;
                                        var9_8 = (int)var8_7.isPreLayout();
                                        var10_9 = 0;
                                        var11_11 = null;
                                        var12_13 = true;
                                        var13_14 = 1.4E-45f;
                                        if (var9_8 == 0) break block27;
                                        var8_7 = this.getChangedScrapViewForPosition(var1_1);
                                        if (var8_7 == null) break block28;
                                        var14_15 = var12_13;
                                        break block29;
                                    }
                                    var9_8 = 0;
                                    var8_7 = null;
                                }
                                var14_15 = false;
                                var15_16 = null;
                            }
                            if (var8_7 == null && (var8_7 = this.getScrapOrHiddenOrCachedHolderForPosition(var1_1, (boolean)var2_2)) != null) {
                                var16_17 = (int)var5_4.validateViewHolderForOffsetPosition((RecyclerView$ViewHolder)var8_7);
                                if (var16_17 == 0) {
                                    if (var7_6 == 0) {
                                        var8_7.addFlags(4);
                                        var16_17 = (int)var8_7.isScrap();
                                        if (var16_17 != 0) {
                                            var17_18 = var5_4.this$0;
                                            var18_19 = var8_7.itemView;
                                            var17_18.removeDetachedView((View)var18_19, false);
                                            var8_7.unScrap();
                                        } else {
                                            var16_17 = (int)var8_7.wasReturnedFromScrap();
                                            if (var16_17 != 0) {
                                                var8_7.clearReturnedFromScrapFlag();
                                            }
                                        }
                                        var5_4.recycleViewHolderInternal((RecyclerView$ViewHolder)var8_7);
                                    }
                                    var9_8 = 0;
                                    var8_7 = null;
                                } else {
                                    var14_15 = var12_13;
                                }
                            }
                            if (var8_7 != null) break block30;
                            var17_18 = var5_4.this$0.mAdapterHelper;
                            var16_17 = var17_18.findPositionOffset(var6_5);
                            if (var16_17 < 0 || var16_17 >= (var19_20 = (var18_19 = var5_4.this$0.mAdapter).getItemCount())) break block31;
                            var18_19 = var5_4.this$0.mAdapter;
                            var19_20 = var18_19.getItemViewType(var16_17);
                            var20_21 = var5_4.this$0.mAdapter;
                            var21_22 = var20_21.hasStableIds();
                            if (var21_22 && (var8_7 = var5_4.getScrapOrCachedViewForId(var22_23 = var5_4.this$0.mAdapter.getItemId(var16_17), var19_20, (boolean)var7_6)) != null) {
                                var8_7.mPosition = var16_17;
                                var14_15 = var12_13;
                            }
                            if (var8_7 == null && (var24_24 = var5_4.mViewCacheExtension) != null && (var24_24 = var24_24.getViewForPositionAndType(var5_4, var6_5, var19_20)) != null) {
                                var8_7 = var5_4.this$0.getChildViewHolder((View)var24_24);
                                if (var8_7 != null) {
                                    var7_6 = (int)var8_7.shouldIgnore();
                                    if (var7_6 != 0) {
                                        var8_7 = new StringBuilder();
                                        var8_7.append("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                                        var11_11 = var5_4.this$0.exceptionLabel();
                                        var8_7.append((String)var11_11);
                                        var8_7 = var8_7.toString();
                                        var24_24 = new IllegalArgumentException((String)var8_7);
                                        throw var24_24;
                                    }
                                } else {
                                    var8_7 = new StringBuilder();
                                    var8_7.append("getViewForPositionAndType returned a view which does not have a ViewHolder");
                                    var11_11 = var5_4.this$0.exceptionLabel();
                                    var8_7.append((String)var11_11);
                                    var8_7 = var8_7.toString();
                                    var24_24 = new IllegalArgumentException((String)var8_7);
                                    throw var24_24;
                                }
                            }
                            if (var8_7 == null) {
                                var24_24 = this.getRecycledViewPool().getRecycledView(var19_20);
                                if (var24_24 != null) {
                                    var24_24.resetInternal();
                                    var9_8 = (int)RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
                                    if (var9_8 != 0) {
                                        var5_4.invalidateDisplayListInt((RecyclerView$ViewHolder)var24_24);
                                    }
                                }
                                var8_7 = var24_24;
                            }
                            if (var8_7 != null) break block30;
                            var24_24 = var5_4.this$0;
                            var25_27 = var24_24.getNanoTime();
                            var22_23 = 0x7FFFFFFFFFFFFFFFL;
                            cfr_temp_0 = var3_3 - var22_23;
                            var16_17 = (int)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                            if (var16_17 != 0 && (var16_17 = (int)(var20_21 = var5_4.mRecyclerPool).willCreateInTime(var19_20, var25_27, var3_3)) == 0) {
                                return null;
                            }
                            var11_11 = var5_4.this$0;
                            var17_18 = var11_11.mAdapter;
                            var11_11 = var17_18.createViewHolder((ViewGroup)var11_11, var19_20);
                            var16_17 = (int)RecyclerView.ALLOW_THREAD_GAP_WORK;
                            if (var16_17 != 0 && (var17_18 = RecyclerView.findNestedRecyclerView(var11_11.itemView)) != null) {
                                var11_11.mNestedRecyclerView = var20_21 = new Object(var17_18);
                            }
                            var22_23 = var5_4.this$0.getNanoTime();
                            var17_18 = var5_4.mRecyclerPool;
                            var17_18.factorInCreateTime(var19_20, var22_23 -= var25_27);
                            var18_19 = var11_11;
                            break block32;
                        }
                        var8_7 = new StringBuilder();
                        var8_7.append("Inconsistency detected. Invalid item position ");
                        var8_7.append(var6_5);
                        var8_7.append("(offset:");
                        var8_7.append(var16_17);
                        var8_7.append(").state:");
                        var10_9 = var5_4.this$0.mState.getItemCount();
                        var8_7.append(var10_9);
                        var11_11 = var5_4.this$0.exceptionLabel();
                        var8_7.append((String)var11_11);
                        var8_7 = var8_7.toString();
                        var24_25 = new IndexOutOfBoundsException((String)var8_7);
                        throw var24_25;
                    }
                    var18_19 = var8_7;
                }
                var21_22 = var14_15;
                if (var14_15 && (var7_6 = (var24_24 = var5_4.this$0.mState).isPreLayout()) == 0 && (var9_8 = (int)var18_19.hasAnyOfTheFlags(var7_6 = 8192)) != 0) {
                    var18_19.setFlags(0, var7_6);
                    var24_24 = var5_4.this$0.mState;
                    var7_6 = (int)var24_24.mRunSimpleAnimations;
                    if (var7_6 != 0) {
                        var7_6 = RecyclerView$ItemAnimator.buildAdapterChangeFlagsForAnimations((RecyclerView$ViewHolder)var18_19) | 4096;
                        var8_7 = var5_4.this$0;
                        var11_11 = var8_7.mItemAnimator;
                        var8_7 = var8_7.mState;
                        var15_16 = var18_19.getUnmodifiedPayloads();
                        var24_24 = var11_11.recordPreLayoutInformation((RecyclerView$State)var8_7, (RecyclerView$ViewHolder)var18_19, var7_6, var15_16);
                        var8_7 = var5_4.this$0;
                        var8_7.recordAnimationInfoIfBouncedHiddenView((RecyclerView$ViewHolder)var18_19, (RecyclerView$ItemAnimator$ItemHolderInfo)var24_24);
                    }
                }
                if ((var7_6 = (var24_24 = var5_4.this$0.mState).isPreLayout()) == 0 || (var7_6 = (int)var18_19.isBound()) == 0) break block33;
                var18_19.mPreLayoutPosition = var6_5;
                ** GOTO lbl-1000
            }
            var7_6 = (int)var18_19.isBound();
            if (var7_6 != 0 && (var7_6 = (int)var18_19.needsUpdate()) == 0 && (var7_6 = (int)var18_19.isInvalid()) == 0) lbl-1000:
            // 2 sources

            {
                var7_6 = 0;
                var24_24 = null;
            } else {
                var10_9 = var5_4.this$0.mAdapterHelper.findPositionOffset(var6_5);
                var24_24 = this;
                var8_7 = var18_19;
                var6_5 = var1_1;
                var7_6 = (int)this.tryBindViewHolderByDeadline((RecyclerView$ViewHolder)var18_19, var10_9, var1_1, var3_3);
            }
            var8_7 = var18_19.itemView.getLayoutParams();
            if (var8_7 == null) {
                var8_7 = (RecyclerView$LayoutParams)var5_4.this$0.generateDefaultLayoutParams();
                var11_11 = var18_19.itemView;
                var11_11.setLayoutParams((ViewGroup.LayoutParams)var8_7);
            } else {
                var11_11 = var5_4.this$0;
                var10_9 = (int)var11_11.checkLayoutParams((ViewGroup.LayoutParams)var8_7);
                if (var10_9 == 0) {
                    var8_7 = (RecyclerView$LayoutParams)var5_4.this$0.generateLayoutParams((ViewGroup.LayoutParams)var8_7);
                    var11_11 = var18_19.itemView;
                    var11_11.setLayoutParams((ViewGroup.LayoutParams)var8_7);
                } else {
                    var8_7 = (RecyclerView$LayoutParams)var8_7;
                }
            }
            var8_7.mViewHolder = var18_19;
            if (!var21_22 || var7_6 == 0) {
                var12_13 = false;
                var13_14 = 0.0f;
            }
            var8_7.mPendingInvalidate = var12_13;
            return var18_19;
        }
        var8_7 = new StringBuilder();
        var8_7.append("Invalid item position ");
        var8_7.append(var6_5);
        var8_7.append("(");
        var8_7.append(var6_5);
        var8_7.append("). Item count:");
        var10_10 = var5_4.this$0.mState.getItemCount();
        var8_7.append(var10_10);
        var11_12 = var5_4.this$0.exceptionLabel();
        var8_7.append(var11_12);
        var8_7 = var8_7.toString();
        var24_26 = new IndexOutOfBoundsException((String)var8_7);
        throw var24_26;
    }

    public void unscrapView(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        boolean bl2 = recyclerView$ViewHolder.mInChangeScrap;
        if (bl2) {
            ArrayList arrayList = this.mChangedScrap;
            arrayList.remove(recyclerView$ViewHolder);
        } else {
            ArrayList arrayList = this.mAttachedScrap;
            arrayList.remove(recyclerView$ViewHolder);
        }
        recyclerView$ViewHolder.mScrapContainer = null;
        recyclerView$ViewHolder.mInChangeScrap = false;
        recyclerView$ViewHolder.clearReturnedFromScrapFlag();
    }

    public void updateViewCacheSize() {
        int n10;
        ArrayList arrayList;
        int n11;
        int n12;
        Object object = this.this$0.mLayout;
        if (object != null) {
            n12 = ((RecyclerView$LayoutManager)object).mPrefetchMaxCountObserved;
        } else {
            n12 = 0;
            object = null;
        }
        this.mViewCacheMax = n11 = this.mRequestedCacheMax + n12;
        object = this.mCachedViews;
        for (n12 = ((ArrayList)object).size() + -1; n12 >= 0 && (n11 = (arrayList = this.mCachedViews).size()) > (n10 = this.mViewCacheMax); n12 += -1) {
            this.recycleCachedViewAt(n12);
        }
    }

    public boolean validateViewHolderForOffsetPosition(RecyclerView$ViewHolder object) {
        Object object2;
        int n10;
        boolean n11 = ((RecyclerView$ViewHolder)object).isRemoved();
        if (n11) {
            return this.this$0.mState.isPreLayout();
        }
        int n12 = ((RecyclerView$ViewHolder)object).mPosition;
        if (n12 >= 0 && n12 < (n10 = ((RecyclerView$Adapter)(object2 = this.this$0.mAdapter)).getItemCount())) {
            int n13;
            Object object3 = this.this$0.mState;
            boolean bl2 = ((RecyclerView$State)object3).isPreLayout();
            n10 = 0;
            object2 = null;
            if (!bl2) {
                object3 = this.this$0.mAdapter;
                n13 = ((RecyclerView$ViewHolder)object).mPosition;
                int n14 = ((RecyclerView$Adapter)object3).getItemViewType(n13);
                if (n14 != (n13 = ((RecyclerView$ViewHolder)object).getItemViewType())) {
                    return false;
                }
            }
            object3 = this.this$0.mAdapter;
            boolean bl3 = ((RecyclerView$Adapter)object3).hasStableIds();
            n13 = 1;
            if (bl3) {
                long l10 = ((RecyclerView$ViewHolder)object).getItemId();
                object3 = this.this$0.mAdapter;
                int n15 = ((RecyclerView$ViewHolder)object).mPosition;
                long l11 = ((RecyclerView$Adapter)object3).getItemId(n15);
                long l12 = l10 - l11;
                if ((n15 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1))) == 0) {
                    n10 = n13;
                }
                return n10;
            }
            return n13;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Inconsistency detected. Invalid view holder adapter position");
        ((StringBuilder)object2).append(object);
        object = this.this$0.exceptionLabel();
        ((StringBuilder)object2).append((String)object);
        object = ((StringBuilder)object2).toString();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException((String)object);
        throw indexOutOfBoundsException;
    }

    public void viewRangeUpdate(int n10, int n11) {
        n11 += n10;
        ArrayList arrayList = this.mCachedViews;
        for (int i10 = arrayList.size() + -1; i10 >= 0; i10 += -1) {
            int n12;
            RecyclerView$ViewHolder recyclerView$ViewHolder = (RecyclerView$ViewHolder)this.mCachedViews.get(i10);
            if (recyclerView$ViewHolder == null || (n12 = recyclerView$ViewHolder.mPosition) < n10 || n12 >= n11) continue;
            n12 = 2;
            recyclerView$ViewHolder.addFlags(n12);
            this.recycleCachedViewAt(i10);
        }
    }
}

