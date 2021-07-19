/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.view.View$OnLongClickListener
 *  android.view.View$OnTouchListener
 */
package com.chad.library.adapter.base.module;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.chad.library.R$id;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.dragswipe.DragAndSwipeCallback;
import com.chad.library.adapter.base.listener.DraggableListenerImp;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;
import com.chad.library.adapter.base.module.BaseDraggableModule$Companion;
import com.chad.library.adapter.base.module.BaseDraggableModule$isDragOnLongPressEnabled$1;
import com.chad.library.adapter.base.module.BaseDraggableModule$isDragOnLongPressEnabled$2;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import f.h2.t.f0;
import java.util.Collections;
import java.util.List;

public class BaseDraggableModule
implements DraggableListenerImp {
    public static final BaseDraggableModule$Companion Companion;
    private static final int NO_TOGGLE_VIEW;
    private final BaseQuickAdapter baseQuickAdapter;
    private boolean isDragEnabled;
    private boolean isDragOnLongPressEnabled;
    private boolean isSwipeEnabled;
    public ItemTouchHelper itemTouchHelper;
    public DragAndSwipeCallback itemTouchHelperCallback;
    private OnItemDragListener mOnItemDragListener;
    private OnItemSwipeListener mOnItemSwipeListener;
    private View.OnLongClickListener mOnToggleViewLongClickListener;
    private View.OnTouchListener mOnToggleViewTouchListener;
    private int toggleViewId;

    static {
        BaseDraggableModule$Companion baseDraggableModule$Companion;
        Companion = baseDraggableModule$Companion = new BaseDraggableModule$Companion(null);
    }

    public BaseDraggableModule(BaseQuickAdapter baseQuickAdapter) {
        f0.q(baseQuickAdapter, "baseQuickAdapter");
        this.baseQuickAdapter = baseQuickAdapter;
        this.initItemTouch();
        this.isDragOnLongPressEnabled = true;
    }

    private final boolean inRange(int n10) {
        List list;
        int n11;
        n10 = n10 >= 0 && n10 < (n11 = (list = this.baseQuickAdapter.getData()).size()) ? 1 : 0;
        return n10 != 0;
    }

    private final void initItemTouch() {
        ItemTouchHelper itemTouchHelper;
        DragAndSwipeCallback dragAndSwipeCallback;
        this.itemTouchHelperCallback = dragAndSwipeCallback = new DragAndSwipeCallback(this);
        if (dragAndSwipeCallback == null) {
            String string2 = "itemTouchHelperCallback";
            f0.S(string2);
        }
        this.itemTouchHelper = itemTouchHelper = new ItemTouchHelper(dragAndSwipeCallback);
    }

    public final void attachToRecyclerView(RecyclerView recyclerView) {
        f0.q(recyclerView, "recyclerView");
        ItemTouchHelper itemTouchHelper = this.itemTouchHelper;
        if (itemTouchHelper == null) {
            String string2 = "itemTouchHelper";
            f0.S(string2);
        }
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    public final ItemTouchHelper getItemTouchHelper() {
        ItemTouchHelper itemTouchHelper = this.itemTouchHelper;
        if (itemTouchHelper == null) {
            String string2 = "itemTouchHelper";
            f0.S(string2);
        }
        return itemTouchHelper;
    }

    public final DragAndSwipeCallback getItemTouchHelperCallback() {
        DragAndSwipeCallback dragAndSwipeCallback = this.itemTouchHelperCallback;
        if (dragAndSwipeCallback == null) {
            String string2 = "itemTouchHelperCallback";
            f0.S(string2);
        }
        return dragAndSwipeCallback;
    }

    public final OnItemDragListener getMOnItemDragListener() {
        return this.mOnItemDragListener;
    }

    public final OnItemSwipeListener getMOnItemSwipeListener() {
        return this.mOnItemSwipeListener;
    }

    public final View.OnLongClickListener getMOnToggleViewLongClickListener() {
        return this.mOnToggleViewLongClickListener;
    }

    public final View.OnTouchListener getMOnToggleViewTouchListener() {
        return this.mOnToggleViewTouchListener;
    }

    public final int getToggleViewId() {
        return this.toggleViewId;
    }

    public final int getViewHolderPosition(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        f0.q(recyclerView$ViewHolder, "viewHolder");
        int n10 = recyclerView$ViewHolder.getAdapterPosition();
        int n11 = this.baseQuickAdapter.getHeaderLayoutCount();
        return n10 - n11;
    }

    public boolean hasToggleView() {
        int n10 = this.toggleViewId;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public final void initView$com_github_CymChad_brvah(BaseViewHolder baseViewHolder) {
        String string2 = "holder";
        f0.q(baseViewHolder, string2);
        boolean bl2 = this.isDragEnabled;
        if (bl2 && (bl2 = this.hasToggleView())) {
            string2 = baseViewHolder.itemView;
            int n10 = this.toggleViewId;
            if ((string2 = string2.findViewById(n10)) != null) {
                n10 = R$id.BaseQuickAdapter_viewholder_support;
                string2.setTag(n10, (Object)baseViewHolder);
                boolean bl3 = this.isDragOnLongPressEnabled();
                if (bl3) {
                    baseViewHolder = this.mOnToggleViewLongClickListener;
                    string2.setOnLongClickListener((View.OnLongClickListener)baseViewHolder);
                } else {
                    baseViewHolder = this.mOnToggleViewTouchListener;
                    string2.setOnTouchListener((View.OnTouchListener)baseViewHolder);
                }
            }
        }
    }

    public final boolean isDragEnabled() {
        return this.isDragEnabled;
    }

    public boolean isDragOnLongPressEnabled() {
        return this.isDragOnLongPressEnabled;
    }

    public final boolean isSwipeEnabled() {
        return this.isSwipeEnabled;
    }

    public void onItemDragEnd(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        f0.q(recyclerView$ViewHolder, "viewHolder");
        OnItemDragListener onItemDragListener = this.mOnItemDragListener;
        if (onItemDragListener != null) {
            int n10 = this.getViewHolderPosition(recyclerView$ViewHolder);
            onItemDragListener.onItemDragEnd(recyclerView$ViewHolder, n10);
        }
    }

    public void onItemDragMoving(RecyclerView$ViewHolder recyclerView$ViewHolder, RecyclerView$ViewHolder recyclerView$ViewHolder2) {
        Object object;
        f0.q(recyclerView$ViewHolder, "source");
        String string2 = "target";
        f0.q(recyclerView$ViewHolder2, string2);
        int n10 = this.getViewHolderPosition(recyclerView$ViewHolder);
        int n11 = this.getViewHolderPosition(recyclerView$ViewHolder2);
        int n12 = this.inRange(n10);
        if (n12 != 0 && (n12 = this.inRange(n11)) != 0) {
            int n13;
            int n14;
            if (n10 < n11) {
                n12 = n10;
                while (n12 < n11) {
                    List list = this.baseQuickAdapter.getData();
                    n14 = n12 + 1;
                    Collections.swap(list, n12, n14);
                    n12 = n14;
                }
            } else {
                n12 = n11 + 1;
                if (n10 >= n12) {
                    n13 = n10;
                    while (true) {
                        List list = this.baseQuickAdapter.getData();
                        int n15 = n13 + -1;
                        Collections.swap(list, n13, n15);
                        if (n13 == n12) break;
                        n13 += -1;
                    }
                }
            }
            object = this.baseQuickAdapter;
            n13 = recyclerView$ViewHolder.getAdapterPosition();
            n14 = recyclerView$ViewHolder2.getAdapterPosition();
            ((RecyclerView$Adapter)object).notifyItemMoved(n13, n14);
        }
        if ((object = this.mOnItemDragListener) != null) {
            object.onItemDragMoving(recyclerView$ViewHolder, n10, recyclerView$ViewHolder2, n11);
        }
    }

    public void onItemDragStart(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        f0.q(recyclerView$ViewHolder, "viewHolder");
        OnItemDragListener onItemDragListener = this.mOnItemDragListener;
        if (onItemDragListener != null) {
            int n10 = this.getViewHolderPosition(recyclerView$ViewHolder);
            onItemDragListener.onItemDragStart(recyclerView$ViewHolder, n10);
        }
    }

    public void onItemSwipeClear(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        Object object = "viewHolder";
        f0.q(recyclerView$ViewHolder, (String)object);
        boolean bl2 = this.isSwipeEnabled;
        if (bl2 && (object = this.mOnItemSwipeListener) != null) {
            int n10 = this.getViewHolderPosition(recyclerView$ViewHolder);
            object.clearView(recyclerView$ViewHolder, n10);
        }
    }

    public void onItemSwipeStart(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        Object object = "viewHolder";
        f0.q(recyclerView$ViewHolder, (String)object);
        boolean bl2 = this.isSwipeEnabled;
        if (bl2 && (object = this.mOnItemSwipeListener) != null) {
            int n10 = this.getViewHolderPosition(recyclerView$ViewHolder);
            object.onItemSwipeStart(recyclerView$ViewHolder, n10);
        }
    }

    public void onItemSwiped(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        String string2 = "viewHolder";
        f0.q(recyclerView$ViewHolder, string2);
        int n10 = this.getViewHolderPosition(recyclerView$ViewHolder);
        boolean bl2 = this.inRange(n10);
        if (bl2) {
            this.baseQuickAdapter.getData().remove(n10);
            Object object = this.baseQuickAdapter;
            int n11 = recyclerView$ViewHolder.getAdapterPosition();
            ((RecyclerView$Adapter)object).notifyItemRemoved(n11);
            bl2 = this.isSwipeEnabled;
            if (bl2 && (object = this.mOnItemSwipeListener) != null) {
                object.onItemSwiped(recyclerView$ViewHolder, n10);
            }
        }
    }

    public void onItemSwiping(Canvas canvas, RecyclerView$ViewHolder recyclerView$ViewHolder, float f10, float f11, boolean bl2) {
        OnItemSwipeListener onItemSwipeListener;
        boolean bl3 = this.isSwipeEnabled;
        if (bl3 && (onItemSwipeListener = this.mOnItemSwipeListener) != null) {
            onItemSwipeListener.onItemSwipeMoving(canvas, recyclerView$ViewHolder, f10, f11, bl2);
        }
    }

    public final void setDragEnabled(boolean bl2) {
        this.isDragEnabled = bl2;
    }

    public void setDragOnLongPressEnabled(boolean bl2) {
        this.isDragOnLongPressEnabled = bl2;
        if (bl2) {
            this.mOnToggleViewTouchListener = null;
            BaseDraggableModule$isDragOnLongPressEnabled$1 baseDraggableModule$isDragOnLongPressEnabled$1 = new BaseDraggableModule$isDragOnLongPressEnabled$1(this);
            this.mOnToggleViewLongClickListener = baseDraggableModule$isDragOnLongPressEnabled$1;
        } else {
            BaseDraggableModule$isDragOnLongPressEnabled$2 baseDraggableModule$isDragOnLongPressEnabled$2 = new BaseDraggableModule$isDragOnLongPressEnabled$2(this);
            this.mOnToggleViewTouchListener = baseDraggableModule$isDragOnLongPressEnabled$2;
            this.mOnToggleViewLongClickListener = null;
        }
    }

    public final void setItemTouchHelper(ItemTouchHelper itemTouchHelper) {
        f0.q(itemTouchHelper, "<set-?>");
        this.itemTouchHelper = itemTouchHelper;
    }

    public final void setItemTouchHelperCallback(DragAndSwipeCallback dragAndSwipeCallback) {
        f0.q(dragAndSwipeCallback, "<set-?>");
        this.itemTouchHelperCallback = dragAndSwipeCallback;
    }

    public final void setMOnItemDragListener(OnItemDragListener onItemDragListener) {
        this.mOnItemDragListener = onItemDragListener;
    }

    public final void setMOnItemSwipeListener(OnItemSwipeListener onItemSwipeListener) {
        this.mOnItemSwipeListener = onItemSwipeListener;
    }

    public final void setMOnToggleViewLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnToggleViewLongClickListener = onLongClickListener;
    }

    public final void setMOnToggleViewTouchListener(View.OnTouchListener onTouchListener) {
        this.mOnToggleViewTouchListener = onTouchListener;
    }

    public void setOnItemDragListener(OnItemDragListener onItemDragListener) {
        this.mOnItemDragListener = onItemDragListener;
    }

    public void setOnItemSwipeListener(OnItemSwipeListener onItemSwipeListener) {
        this.mOnItemSwipeListener = onItemSwipeListener;
    }

    public final void setSwipeEnabled(boolean bl2) {
        this.isSwipeEnabled = bl2;
    }

    public final void setToggleViewId(int n10) {
        this.toggleViewId = n10;
    }
}

