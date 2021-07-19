/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.ItemTouchHelper$Callback;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;

public abstract class ItemTouchHelper$SimpleCallback
extends ItemTouchHelper$Callback {
    private int mDefaultDragDirs;
    private int mDefaultSwipeDirs;

    public ItemTouchHelper$SimpleCallback(int n10, int n11) {
        this.mDefaultSwipeDirs = n11;
        this.mDefaultDragDirs = n10;
    }

    public int getDragDirs(RecyclerView recyclerView, RecyclerView$ViewHolder recyclerView$ViewHolder) {
        return this.mDefaultDragDirs;
    }

    public int getMovementFlags(RecyclerView recyclerView, RecyclerView$ViewHolder recyclerView$ViewHolder) {
        int n10 = this.getDragDirs(recyclerView, recyclerView$ViewHolder);
        int n11 = this.getSwipeDirs(recyclerView, recyclerView$ViewHolder);
        return ItemTouchHelper$Callback.makeMovementFlags(n10, n11);
    }

    public int getSwipeDirs(RecyclerView recyclerView, RecyclerView$ViewHolder recyclerView$ViewHolder) {
        return this.mDefaultSwipeDirs;
    }

    public void setDefaultDragDirs(int n10) {
        this.mDefaultDragDirs = n10;
    }

    public void setDefaultSwipeDirs(int n10) {
        this.mDefaultSwipeDirs = n10;
    }
}

