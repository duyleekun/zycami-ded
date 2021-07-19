/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 */
package com.chad.library.adapter.base.module;

import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.chad.library.R$id;
import com.chad.library.adapter.base.module.BaseDraggableModule;
import f.h2.t.f0;
import kotlin.TypeCastException;

public final class BaseDraggableModule$isDragOnLongPressEnabled$2
implements View.OnTouchListener {
    public final /* synthetic */ BaseDraggableModule this$0;

    public BaseDraggableModule$isDragOnLongPressEnabled$2(BaseDraggableModule baseDraggableModule) {
        this.this$0 = baseDraggableModule;
    }

    public final boolean onTouch(View object, MotionEvent object2) {
        boolean bl2;
        String string2 = "event";
        f0.h(object2, string2);
        int n10 = object2.getAction();
        if (n10 == 0 && (n10 = (int)(((BaseDraggableModule)(object2 = this.this$0)).isDragOnLongPressEnabled() ? 1 : 0)) == 0) {
            object2 = this.this$0;
            n10 = (int)(((BaseDraggableModule)object2).isDragEnabled() ? 1 : 0);
            if (n10 != 0) {
                object2 = this.this$0.getItemTouchHelper();
                int n11 = R$id.BaseQuickAdapter_viewholder_support;
                if ((object = object.getTag(n11)) != null) {
                    object = (RecyclerView$ViewHolder)object;
                    ((ItemTouchHelper)object2).startDrag((RecyclerView$ViewHolder)object);
                } else {
                    object = new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.ViewHolder");
                    throw object;
                }
            }
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }
}

