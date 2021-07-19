/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView$ViewHolder;

public class RecyclerView$ItemAnimator$ItemHolderInfo {
    public int bottom;
    public int changeFlags;
    public int left;
    public int right;
    public int top;

    public RecyclerView$ItemAnimator$ItemHolderInfo setFrom(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        return this.setFrom(recyclerView$ViewHolder, 0);
    }

    public RecyclerView$ItemAnimator$ItemHolderInfo setFrom(RecyclerView$ViewHolder recyclerView$ViewHolder, int n10) {
        int n11;
        recyclerView$ViewHolder = recyclerView$ViewHolder.itemView;
        this.left = n10 = recyclerView$ViewHolder.getLeft();
        this.top = n10 = recyclerView$ViewHolder.getTop();
        this.right = n10 = recyclerView$ViewHolder.getRight();
        this.bottom = n11 = recyclerView$ViewHolder.getBottom();
        return this;
    }
}

