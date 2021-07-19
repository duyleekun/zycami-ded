/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 */
package com.zhiyun.cama.list;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$SmoothScroller;
import androidx.recyclerview.widget.RecyclerView$State;
import com.zhiyun.cama.list.CenterLayoutManager$a;

public class CenterLayoutManager
extends LinearLayoutManager {
    private boolean a = true;

    public CenterLayoutManager(Context context) {
        super(context);
    }

    public CenterLayoutManager(Context context, int n10, boolean bl2) {
        super(context, n10, bl2);
    }

    public CenterLayoutManager(Context context, AttributeSet attributeSet, int n10, int n11) {
        super(context, attributeSet, n10, n11);
    }

    public boolean a() {
        return this.a;
    }

    public void b(boolean bl2) {
        this.a = bl2;
    }

    public boolean canScrollHorizontally() {
        boolean bl2 = this.a;
        bl2 = bl2 && (bl2 = super.canScrollHorizontally());
        return bl2;
    }

    public boolean canScrollVertically() {
        boolean bl2 = this.a;
        bl2 = bl2 && (bl2 = super.canScrollVertically());
        return bl2;
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView$State object, int n10) {
        recyclerView = recyclerView.getContext();
        object = new CenterLayoutManager$a((Context)recyclerView);
        ((RecyclerView$SmoothScroller)object).setTargetPosition(n10);
        this.startSmoothScroll((RecyclerView$SmoothScroller)object);
    }
}

