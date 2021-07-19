/*
 * Decompiled with CFR 0.151.
 */
package com.chad.library.adapter.base.listener;

import androidx.recyclerview.widget.RecyclerView$ViewHolder;

public interface OnItemDragListener {
    public void onItemDragEnd(RecyclerView$ViewHolder var1, int var2);

    public void onItemDragMoving(RecyclerView$ViewHolder var1, int var2, RecyclerView$ViewHolder var3, int var4);

    public void onItemDragStart(RecyclerView$ViewHolder var1, int var2);
}

