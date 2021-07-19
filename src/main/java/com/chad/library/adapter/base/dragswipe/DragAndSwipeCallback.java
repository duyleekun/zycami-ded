/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 */
package com.chad.library.adapter.base.dragswipe;

import android.graphics.Canvas;
import androidx.recyclerview.widget.ItemTouchHelper$Callback;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.chad.library.R$id;
import com.chad.library.adapter.base.module.BaseDraggableModule;

public class DragAndSwipeCallback
extends ItemTouchHelper$Callback {
    private int mDragMoveFlags = 15;
    private BaseDraggableModule mDraggableModule;
    private float mMoveThreshold = 0.1f;
    private int mSwipeMoveFlags = 32;
    private float mSwipeThreshold = 0.7f;

    public DragAndSwipeCallback(BaseDraggableModule baseDraggableModule) {
        this.mDraggableModule = baseDraggableModule;
    }

    private boolean isViewCreateByAdapter(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        int n10;
        int n11 = recyclerView$ViewHolder.getItemViewType();
        if (n11 != (n10 = 0x10000111) && n11 != (n10 = 0x10000222) && n11 != (n10 = 0x10000333) && n11 != (n10 = 0x10000555)) {
            n11 = 0;
            recyclerView$ViewHolder = null;
        } else {
            n11 = 1;
        }
        return n11 != 0;
    }

    public void clearView(RecyclerView object, RecyclerView$ViewHolder recyclerView$ViewHolder) {
        Boolean bl2 = Boolean.FALSE;
        super.clearView((RecyclerView)object, recyclerView$ViewHolder);
        boolean bl3 = this.isViewCreateByAdapter(recyclerView$ViewHolder);
        if (bl3) {
            return;
        }
        object = recyclerView$ViewHolder.itemView;
        int n10 = R$id.BaseQuickAdapter_dragging_support;
        if ((object = object.getTag(n10)) != null && (bl3 = ((Boolean)(object = (Boolean)recyclerView$ViewHolder.itemView.getTag(n10))).booleanValue())) {
            object = this.mDraggableModule;
            if (object != null) {
                ((BaseDraggableModule)object).onItemDragEnd(recyclerView$ViewHolder);
            }
            object = recyclerView$ViewHolder.itemView;
            object.setTag(n10, (Object)bl2);
        }
        object = recyclerView$ViewHolder.itemView;
        n10 = R$id.BaseQuickAdapter_swiping_support;
        if ((object = object.getTag(n10)) != null && (bl3 = ((Boolean)(object = (Boolean)recyclerView$ViewHolder.itemView.getTag(n10))).booleanValue())) {
            object = this.mDraggableModule;
            if (object != null) {
                ((BaseDraggableModule)object).onItemSwipeClear(recyclerView$ViewHolder);
            }
            object = recyclerView$ViewHolder.itemView;
            object.setTag(n10, (Object)bl2);
        }
    }

    public float getMoveThreshold(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        return this.mMoveThreshold;
    }

    public int getMovementFlags(RecyclerView recyclerView, RecyclerView$ViewHolder recyclerView$ViewHolder) {
        int n10 = this.isViewCreateByAdapter(recyclerView$ViewHolder);
        if (n10 != 0) {
            return ItemTouchHelper$Callback.makeMovementFlags(0, 0);
        }
        n10 = this.mDragMoveFlags;
        int n11 = this.mSwipeMoveFlags;
        return ItemTouchHelper$Callback.makeMovementFlags(n10, n11);
    }

    public float getSwipeThreshold(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        return this.mSwipeThreshold;
    }

    public boolean isItemViewSwipeEnabled() {
        BaseDraggableModule baseDraggableModule = this.mDraggableModule;
        if (baseDraggableModule != null) {
            return baseDraggableModule.isSwipeEnabled();
        }
        return false;
    }

    public boolean isLongPressDragEnabled() {
        boolean bl2;
        BaseDraggableModule baseDraggableModule = this.mDraggableModule;
        boolean bl3 = false;
        if (baseDraggableModule != null && (bl2 = baseDraggableModule.isDragEnabled()) && !(bl2 = (baseDraggableModule = this.mDraggableModule).hasToggleView())) {
            bl3 = true;
        }
        return bl3;
    }

    public void onChildDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView$ViewHolder recyclerView$ViewHolder, float f10, float f11, int n10, boolean bl2) {
        super.onChildDrawOver(canvas, recyclerView, recyclerView$ViewHolder, f10, f11, n10, bl2);
        int n11 = 1;
        float f12 = Float.MIN_VALUE;
        if (n10 == n11 && (n11 = (int)(this.isViewCreateByAdapter(recyclerView$ViewHolder) ? 1 : 0)) == 0) {
            recyclerView = recyclerView$ViewHolder.itemView;
            canvas.save();
            float f13 = 0.0f;
            float f14 = f10 - 0.0f;
            n10 = (int)(f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1));
            if (n10 > 0) {
                f13 = recyclerView.getLeft();
                int n12 = recyclerView.getTop();
                float f15 = n12;
                int n13 = recyclerView.getLeft();
                float f16 = (float)n13 + f10;
                int n14 = recyclerView.getBottom();
                float f17 = n14;
                canvas.clipRect(f13, f15, f16, f17);
                n10 = recyclerView.getLeft();
                f13 = n10;
                n11 = recyclerView.getTop();
                f12 = n11;
                canvas.translate(f13, f12);
            } else {
                f13 = (float)recyclerView.getRight() + f10;
                int n15 = recyclerView.getTop();
                float f18 = n15;
                int n16 = recyclerView.getRight();
                float f19 = n16;
                int n17 = recyclerView.getBottom();
                float f20 = n17;
                canvas.clipRect(f13, f18, f19, f20);
                n10 = recyclerView.getRight();
                f13 = (float)n10 + f10;
                n11 = recyclerView.getTop();
                f12 = n11;
                canvas.translate(f13, f12);
            }
            BaseDraggableModule baseDraggableModule = this.mDraggableModule;
            if (baseDraggableModule != null) {
                baseDraggableModule.onItemSwiping(canvas, recyclerView$ViewHolder, f10, f11, bl2);
            }
            canvas.restore();
        }
    }

    public boolean onMove(RecyclerView recyclerView, RecyclerView$ViewHolder recyclerView$ViewHolder, RecyclerView$ViewHolder recyclerView$ViewHolder2) {
        int n10;
        int n11 = recyclerView$ViewHolder.getItemViewType();
        n11 = n11 == (n10 = recyclerView$ViewHolder2.getItemViewType()) ? 1 : 0;
        return n11 != 0;
    }

    public void onMoved(RecyclerView object, RecyclerView$ViewHolder recyclerView$ViewHolder, int n10, RecyclerView$ViewHolder recyclerView$ViewHolder2, int n11, int n12, int n13) {
        super.onMoved((RecyclerView)object, recyclerView$ViewHolder, n10, recyclerView$ViewHolder2, n11, n12, n13);
        object = this.mDraggableModule;
        if (object != null) {
            ((BaseDraggableModule)object).onItemDragMoving(recyclerView$ViewHolder, recyclerView$ViewHolder2);
        }
    }

    public void onSelectedChanged(RecyclerView$ViewHolder recyclerView$ViewHolder, int n10) {
        Boolean bl2 = Boolean.TRUE;
        int n11 = 2;
        if (n10 == n11 && (n11 = (int)(this.isViewCreateByAdapter(recyclerView$ViewHolder) ? 1 : 0)) == 0) {
            BaseDraggableModule baseDraggableModule = this.mDraggableModule;
            if (baseDraggableModule != null) {
                baseDraggableModule.onItemDragStart(recyclerView$ViewHolder);
            }
            baseDraggableModule = recyclerView$ViewHolder.itemView;
            int n12 = R$id.BaseQuickAdapter_dragging_support;
            baseDraggableModule.setTag(n12, bl2);
        } else {
            n11 = 1;
            if (n10 == n11 && (n11 = (int)(this.isViewCreateByAdapter(recyclerView$ViewHolder) ? 1 : 0)) == 0) {
                BaseDraggableModule baseDraggableModule = this.mDraggableModule;
                if (baseDraggableModule != null) {
                    baseDraggableModule.onItemSwipeStart(recyclerView$ViewHolder);
                }
                baseDraggableModule = recyclerView$ViewHolder.itemView;
                int n13 = R$id.BaseQuickAdapter_swiping_support;
                baseDraggableModule.setTag(n13, bl2);
            }
        }
        super.onSelectedChanged(recyclerView$ViewHolder, n10);
    }

    public void onSwiped(RecyclerView$ViewHolder recyclerView$ViewHolder, int n10) {
        BaseDraggableModule baseDraggableModule;
        n10 = (int)(this.isViewCreateByAdapter(recyclerView$ViewHolder) ? 1 : 0);
        if (n10 == 0 && (baseDraggableModule = this.mDraggableModule) != null) {
            baseDraggableModule.onItemSwiped(recyclerView$ViewHolder);
        }
    }

    public void setDragMoveFlags(int n10) {
        this.mDragMoveFlags = n10;
    }

    public void setMoveThreshold(float f10) {
        this.mMoveThreshold = f10;
    }

    public void setSwipeMoveFlags(int n10) {
        this.mSwipeMoveFlags = n10;
    }

    public void setSwipeThreshold(float f10) {
        this.mSwipeThreshold = f10;
    }
}

