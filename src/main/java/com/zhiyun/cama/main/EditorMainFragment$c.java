/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.view.View
 */
package com.zhiyun.cama.main;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView$State;
import com.zhiyun.cama.main.EditorMainFragment;
import d.v.c.i1.n2;
import d.v.e.l.h2;

public class EditorMainFragment$c
extends RecyclerView$ItemDecoration {
    public final /* synthetic */ LinearLayoutManager a;
    public final /* synthetic */ n2 b;
    public final /* synthetic */ EditorMainFragment c;

    public EditorMainFragment$c(EditorMainFragment editorMainFragment, LinearLayoutManager linearLayoutManager, n2 n22) {
        this.c = editorMainFragment;
        this.a = linearLayoutManager;
        this.b = n22;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView object, RecyclerView$State recyclerView$State) {
        int n10;
        object = this.a;
        int n11 = ((RecyclerView$LayoutManager)object).getPosition(view);
        if (n11 > 0 && n11 < (n10 = ((n2)(object = this.b)).getItemCount() + -1)) {
            float f10 = 3.0f;
            rect.left = n11 = h2.b(f10);
        } else {
            n11 = 0;
            float f11 = 0.0f;
            view = null;
            rect.left = 0;
        }
        rect.right = n11 = rect.left;
        rect.top = n11 = h2.b(194.0f);
    }
}

