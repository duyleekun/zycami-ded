/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AdapterHelper$UpdateOp;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;

public interface AdapterHelper$Callback {
    public RecyclerView.ViewHolder findViewHolder(int var1);

    public void markViewHoldersUpdated(int var1, int var2, Object var3);

    public void offsetPositionsForAdd(int var1, int var2);

    public void offsetPositionsForMove(int var1, int var2);

    public void offsetPositionsForRemovingInvisible(int var1, int var2);

    public void offsetPositionsForRemovingLaidOutOrNewView(int var1, int var2);

    public void onDispatchFirstPass(AdapterHelper.UpdateOp var1);

    public void onDispatchSecondPass(AdapterHelper.UpdateOp var1);
}

