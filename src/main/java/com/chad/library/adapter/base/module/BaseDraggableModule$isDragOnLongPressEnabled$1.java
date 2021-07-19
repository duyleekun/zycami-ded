/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnLongClickListener
 */
package com.chad.library.adapter.base.module;

import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.chad.library.R$id;
import com.chad.library.adapter.base.module.BaseDraggableModule;
import kotlin.TypeCastException;

public final class BaseDraggableModule$isDragOnLongPressEnabled$1
implements View.OnLongClickListener {
    public final /* synthetic */ BaseDraggableModule this$0;

    public BaseDraggableModule$isDragOnLongPressEnabled$1(BaseDraggableModule baseDraggableModule) {
        this.this$0 = baseDraggableModule;
    }

    public final boolean onLongClick(View object) {
        Object object2 = this.this$0;
        boolean bl2 = ((BaseDraggableModule)object2).isDragEnabled();
        if (bl2) {
            object2 = this.this$0.getItemTouchHelper();
            int n10 = R$id.BaseQuickAdapter_viewholder_support;
            if ((object = object.getTag(n10)) != null) {
                object = (RecyclerView$ViewHolder)object;
                ((ItemTouchHelper)object2).startDrag((RecyclerView$ViewHolder)object);
            } else {
                object = new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.ViewHolder");
                throw object;
            }
        }
        return true;
    }
}

