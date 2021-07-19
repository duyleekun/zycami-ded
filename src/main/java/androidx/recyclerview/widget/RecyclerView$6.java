/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.AdapterHelper$Callback;
import androidx.recyclerview.widget.AdapterHelper$UpdateOp;
import androidx.recyclerview.widget.ChildHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView$State;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;

public class RecyclerView$6
implements AdapterHelper$Callback {
    public final /* synthetic */ RecyclerView this$0;

    public RecyclerView$6(RecyclerView recyclerView) {
        this.this$0 = recyclerView;
    }

    public void dispatchUpdate(AdapterHelper$UpdateOp object) {
        int n10 = ((AdapterHelper$UpdateOp)object).cmd;
        int n11 = 1;
        if (n10 != n11) {
            int n12 = 2;
            if (n10 != n12) {
                n12 = 4;
                if (n10 != n12) {
                    n12 = 8;
                    if (n10 == n12) {
                        RecyclerView recyclerView = this.this$0;
                        RecyclerView$LayoutManager recyclerView$LayoutManager = recyclerView.mLayout;
                        int n13 = ((AdapterHelper$UpdateOp)object).positionStart;
                        int n14 = ((AdapterHelper$UpdateOp)object).itemCount;
                        recyclerView$LayoutManager.onItemsMoved(recyclerView, n13, n14, n11);
                    }
                } else {
                    RecyclerView recyclerView = this.this$0;
                    RecyclerView$LayoutManager recyclerView$LayoutManager = recyclerView.mLayout;
                    n12 = ((AdapterHelper$UpdateOp)object).positionStart;
                    int n15 = ((AdapterHelper$UpdateOp)object).itemCount;
                    object = ((AdapterHelper$UpdateOp)object).payload;
                    recyclerView$LayoutManager.onItemsUpdated(recyclerView, n12, n15, object);
                }
            } else {
                RecyclerView recyclerView = this.this$0;
                RecyclerView$LayoutManager recyclerView$LayoutManager = recyclerView.mLayout;
                n12 = ((AdapterHelper$UpdateOp)object).positionStart;
                int n16 = ((AdapterHelper$UpdateOp)object).itemCount;
                recyclerView$LayoutManager.onItemsRemoved(recyclerView, n12, n16);
            }
        } else {
            RecyclerView recyclerView = this.this$0;
            RecyclerView$LayoutManager recyclerView$LayoutManager = recyclerView.mLayout;
            int n17 = ((AdapterHelper$UpdateOp)object).positionStart;
            int n18 = ((AdapterHelper$UpdateOp)object).itemCount;
            recyclerView$LayoutManager.onItemsAdded(recyclerView, n17, n18);
        }
    }

    public RecyclerView$ViewHolder findViewHolder(int n10) {
        RecyclerView recyclerView = this.this$0;
        boolean bl2 = true;
        RecyclerView$ViewHolder recyclerView$ViewHolder = recyclerView.findViewHolderForPosition(n10, bl2);
        recyclerView = null;
        if (recyclerView$ViewHolder == null) {
            return null;
        }
        ChildHelper childHelper = this.this$0.mChildHelper;
        View view = recyclerView$ViewHolder.itemView;
        bl2 = childHelper.isHidden(view);
        if (bl2) {
            return null;
        }
        return recyclerView$ViewHolder;
    }

    public void markViewHoldersUpdated(int n10, int n11, Object object) {
        this.this$0.viewRangeUpdate(n10, n11, object);
        this.this$0.mItemsChanged = true;
    }

    public void offsetPositionsForAdd(int n10, int n11) {
        this.this$0.offsetPositionRecordsForInsert(n10, n11);
        this.this$0.mItemsAddedOrRemoved = true;
    }

    public void offsetPositionsForMove(int n10, int n11) {
        this.this$0.offsetPositionRecordsForMove(n10, n11);
        this.this$0.mItemsAddedOrRemoved = true;
    }

    public void offsetPositionsForRemovingInvisible(int n10, int n11) {
        int n12;
        RecyclerView recyclerView = this.this$0;
        boolean bl2 = true;
        recyclerView.offsetPositionRecordsForRemove(n10, n11, bl2);
        Object object = this.this$0;
        ((RecyclerView)object).mItemsAddedOrRemoved = bl2;
        object = ((RecyclerView)object).mState;
        ((RecyclerView$State)object).mDeletedInvisibleItemCountSincePreviousLayout = n12 = ((RecyclerView$State)object).mDeletedInvisibleItemCountSincePreviousLayout + n11;
    }

    public void offsetPositionsForRemovingLaidOutOrNewView(int n10, int n11) {
        this.this$0.offsetPositionRecordsForRemove(n10, n11, false);
        this.this$0.mItemsAddedOrRemoved = true;
    }

    public void onDispatchFirstPass(AdapterHelper$UpdateOp adapterHelper$UpdateOp) {
        this.dispatchUpdate(adapterHelper$UpdateOp);
    }

    public void onDispatchSecondPass(AdapterHelper$UpdateOp adapterHelper$UpdateOp) {
        this.dispatchUpdate(adapterHelper$UpdateOp);
    }
}

