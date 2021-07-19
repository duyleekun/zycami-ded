/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemHolderInfo;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;

public interface ViewInfoStore$ProcessCallback {
    public void processAppeared(RecyclerView$ViewHolder var1, RecyclerView$ItemAnimator$ItemHolderInfo var2, RecyclerView$ItemAnimator$ItemHolderInfo var3);

    public void processDisappeared(RecyclerView$ViewHolder var1, RecyclerView$ItemAnimator$ItemHolderInfo var2, RecyclerView$ItemAnimator$ItemHolderInfo var3);

    public void processPersistent(RecyclerView$ViewHolder var1, RecyclerView$ItemAnimator$ItemHolderInfo var2, RecyclerView$ItemAnimator$ItemHolderInfo var3);

    public void unused(RecyclerView$ViewHolder var1);
}

