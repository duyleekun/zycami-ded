/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView$ItemAnimator;
import androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemHolderInfo;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;

public abstract class SimpleItemAnimator
extends RecyclerView$ItemAnimator {
    private static final boolean DEBUG = false;
    private static final String TAG = "SimpleItemAnimator";
    public boolean mSupportsChangeAnimations = true;

    public abstract boolean animateAdd(RecyclerView$ViewHolder var1);

    public boolean animateAppearance(RecyclerView$ViewHolder recyclerView$ViewHolder, RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo, RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo2) {
        int n10;
        int n11;
        int n12;
        int n13;
        if (recyclerView$ItemAnimator$ItemHolderInfo != null && ((n13 = recyclerView$ItemAnimator$ItemHolderInfo.left) != (n12 = recyclerView$ItemAnimator$ItemHolderInfo2.left) || (n11 = recyclerView$ItemAnimator$ItemHolderInfo.top) != (n10 = recyclerView$ItemAnimator$ItemHolderInfo2.top))) {
            int n14 = recyclerView$ItemAnimator$ItemHolderInfo.top;
            int n15 = recyclerView$ItemAnimator$ItemHolderInfo2.top;
            return this.animateMove(recyclerView$ViewHolder, n13, n14, n12, n15);
        }
        return this.animateAdd(recyclerView$ViewHolder);
    }

    public abstract boolean animateChange(RecyclerView$ViewHolder var1, RecyclerView$ViewHolder var2, int var3, int var4, int var5, int var6);

    public boolean animateChange(RecyclerView$ViewHolder recyclerView$ViewHolder, RecyclerView$ViewHolder recyclerView$ViewHolder2, RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo, RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo2) {
        int n10;
        int n11;
        int n12 = recyclerView$ItemAnimator$ItemHolderInfo.left;
        int n13 = recyclerView$ItemAnimator$ItemHolderInfo.top;
        boolean bl2 = recyclerView$ViewHolder2.shouldIgnore();
        if (bl2) {
            int n14;
            int n15 = recyclerView$ItemAnimator$ItemHolderInfo.left;
            n11 = n14 = recyclerView$ItemAnimator$ItemHolderInfo.top;
            n10 = n15;
        } else {
            int n16 = recyclerView$ItemAnimator$ItemHolderInfo2.left;
            int n17 = recyclerView$ItemAnimator$ItemHolderInfo2.top;
            n10 = n16;
            n11 = n17;
        }
        return this.animateChange(recyclerView$ViewHolder, recyclerView$ViewHolder2, n12, n13, n10, n11);
    }

    public boolean animateDisappearance(RecyclerView$ViewHolder recyclerView$ViewHolder, RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo, RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo2) {
        int n10 = recyclerView$ItemAnimator$ItemHolderInfo.left;
        int n11 = recyclerView$ItemAnimator$ItemHolderInfo.top;
        recyclerView$ItemAnimator$ItemHolderInfo = recyclerView$ViewHolder.itemView;
        int n12 = recyclerView$ItemAnimator$ItemHolderInfo2 == null ? recyclerView$ItemAnimator$ItemHolderInfo.getLeft() : recyclerView$ItemAnimator$ItemHolderInfo2.left;
        int n13 = n12;
        int n14 = recyclerView$ItemAnimator$ItemHolderInfo2 == null ? recyclerView$ItemAnimator$ItemHolderInfo.getTop() : recyclerView$ItemAnimator$ItemHolderInfo2.top;
        int n15 = n14;
        n14 = (int)(recyclerView$ViewHolder.isRemoved() ? 1 : 0);
        if (n14 == 0 && (n10 != n13 || n11 != n15)) {
            n14 = recyclerView$ItemAnimator$ItemHolderInfo.getWidth() + n13;
            n12 = recyclerView$ItemAnimator$ItemHolderInfo.getHeight() + n15;
            recyclerView$ItemAnimator$ItemHolderInfo.layout(n13, n15, n14, n12);
            return this.animateMove(recyclerView$ViewHolder, n10, n11, n13, n15);
        }
        return this.animateRemove(recyclerView$ViewHolder);
    }

    public abstract boolean animateMove(RecyclerView$ViewHolder var1, int var2, int var3, int var4, int var5);

    public boolean animatePersistence(RecyclerView$ViewHolder recyclerView$ViewHolder, RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo, RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo2) {
        int n10;
        int n11;
        int n12 = recyclerView$ItemAnimator$ItemHolderInfo.left;
        int n13 = recyclerView$ItemAnimator$ItemHolderInfo2.left;
        if (n12 == n13 && (n11 = recyclerView$ItemAnimator$ItemHolderInfo.top) == (n10 = recyclerView$ItemAnimator$ItemHolderInfo2.top)) {
            this.dispatchMoveFinished(recyclerView$ViewHolder);
            return false;
        }
        int n14 = recyclerView$ItemAnimator$ItemHolderInfo.top;
        int n15 = recyclerView$ItemAnimator$ItemHolderInfo2.top;
        return this.animateMove(recyclerView$ViewHolder, n12, n14, n13, n15);
    }

    public abstract boolean animateRemove(RecyclerView$ViewHolder var1);

    public boolean canReuseUpdatedViewHolder(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        boolean bl2;
        boolean bl3 = this.mSupportsChangeAnimations;
        if (bl3 && !(bl2 = recyclerView$ViewHolder.isInvalid())) {
            bl2 = false;
            recyclerView$ViewHolder = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public final void dispatchAddFinished(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        this.onAddFinished(recyclerView$ViewHolder);
        this.dispatchAnimationFinished(recyclerView$ViewHolder);
    }

    public final void dispatchAddStarting(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        this.onAddStarting(recyclerView$ViewHolder);
    }

    public final void dispatchChangeFinished(RecyclerView$ViewHolder recyclerView$ViewHolder, boolean bl2) {
        this.onChangeFinished(recyclerView$ViewHolder, bl2);
        this.dispatchAnimationFinished(recyclerView$ViewHolder);
    }

    public final void dispatchChangeStarting(RecyclerView$ViewHolder recyclerView$ViewHolder, boolean bl2) {
        this.onChangeStarting(recyclerView$ViewHolder, bl2);
    }

    public final void dispatchMoveFinished(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        this.onMoveFinished(recyclerView$ViewHolder);
        this.dispatchAnimationFinished(recyclerView$ViewHolder);
    }

    public final void dispatchMoveStarting(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        this.onMoveStarting(recyclerView$ViewHolder);
    }

    public final void dispatchRemoveFinished(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        this.onRemoveFinished(recyclerView$ViewHolder);
        this.dispatchAnimationFinished(recyclerView$ViewHolder);
    }

    public final void dispatchRemoveStarting(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        this.onRemoveStarting(recyclerView$ViewHolder);
    }

    public boolean getSupportsChangeAnimations() {
        return this.mSupportsChangeAnimations;
    }

    public void onAddFinished(RecyclerView$ViewHolder recyclerView$ViewHolder) {
    }

    public void onAddStarting(RecyclerView$ViewHolder recyclerView$ViewHolder) {
    }

    public void onChangeFinished(RecyclerView$ViewHolder recyclerView$ViewHolder, boolean bl2) {
    }

    public void onChangeStarting(RecyclerView$ViewHolder recyclerView$ViewHolder, boolean bl2) {
    }

    public void onMoveFinished(RecyclerView$ViewHolder recyclerView$ViewHolder) {
    }

    public void onMoveStarting(RecyclerView$ViewHolder recyclerView$ViewHolder) {
    }

    public void onRemoveFinished(RecyclerView$ViewHolder recyclerView$ViewHolder) {
    }

    public void onRemoveStarting(RecyclerView$ViewHolder recyclerView$ViewHolder) {
    }

    public void setSupportsChangeAnimations(boolean bl2) {
        this.mSupportsChangeAnimations = bl2;
    }
}

