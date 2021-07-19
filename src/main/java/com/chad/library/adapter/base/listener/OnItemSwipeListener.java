/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 */
package com.chad.library.adapter.base.listener;

import android.graphics.Canvas;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;

public interface OnItemSwipeListener {
    public void clearView(RecyclerView$ViewHolder var1, int var2);

    public void onItemSwipeMoving(Canvas var1, RecyclerView$ViewHolder var2, float var3, float var4, boolean var5);

    public void onItemSwipeStart(RecyclerView$ViewHolder var1, int var2);

    public void onItemSwiped(RecyclerView$ViewHolder var1, int var2);
}

