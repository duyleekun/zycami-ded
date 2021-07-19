/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView$ViewHolder;

public class DefaultItemAnimator$MoveInfo {
    public int fromX;
    public int fromY;
    public RecyclerView$ViewHolder holder;
    public int toX;
    public int toY;

    public DefaultItemAnimator$MoveInfo(RecyclerView$ViewHolder recyclerView$ViewHolder, int n10, int n11, int n12, int n13) {
        this.holder = recyclerView$ViewHolder;
        this.fromX = n10;
        this.fromY = n11;
        this.toX = n12;
        this.toY = n13;
    }
}

