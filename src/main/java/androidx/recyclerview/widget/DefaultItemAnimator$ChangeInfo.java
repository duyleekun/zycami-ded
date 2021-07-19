/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView$ViewHolder;

public class DefaultItemAnimator$ChangeInfo {
    public int fromX;
    public int fromY;
    public RecyclerView$ViewHolder newHolder;
    public RecyclerView$ViewHolder oldHolder;
    public int toX;
    public int toY;

    private DefaultItemAnimator$ChangeInfo(RecyclerView$ViewHolder recyclerView$ViewHolder, RecyclerView$ViewHolder recyclerView$ViewHolder2) {
        this.oldHolder = recyclerView$ViewHolder;
        this.newHolder = recyclerView$ViewHolder2;
    }

    public DefaultItemAnimator$ChangeInfo(RecyclerView$ViewHolder recyclerView$ViewHolder, RecyclerView$ViewHolder recyclerView$ViewHolder2, int n10, int n11, int n12, int n13) {
        this(recyclerView$ViewHolder, recyclerView$ViewHolder2);
        this.fromX = n10;
        this.fromY = n11;
        this.toX = n12;
        this.toY = n13;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ChangeInfo{oldHolder=");
        RecyclerView$ViewHolder recyclerView$ViewHolder = this.oldHolder;
        stringBuilder.append(recyclerView$ViewHolder);
        stringBuilder.append(", newHolder=");
        recyclerView$ViewHolder = this.newHolder;
        stringBuilder.append(recyclerView$ViewHolder);
        stringBuilder.append(", fromX=");
        int n10 = this.fromX;
        stringBuilder.append(n10);
        stringBuilder.append(", fromY=");
        n10 = this.fromY;
        stringBuilder.append(n10);
        stringBuilder.append(", toX=");
        n10 = this.toX;
        stringBuilder.append(n10);
        stringBuilder.append(", toY=");
        n10 = this.toY;
        stringBuilder.append(n10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

