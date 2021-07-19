/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 */
package com.zhiyun.cama.camera.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView$OnScrollListener;
import androidx.recyclerview.widget.SnapHelper;
import com.zhiyun.cama.camera.widget.StringScrollView$b;
import com.zhiyun.cama.camera.widget.StringScrollView$c;
import com.zhiyun.cama.camera.widget.StringScrollView$d;
import com.zhiyun.cama.list.CenterLayoutManager;
import java.util.List;

public class StringScrollView
extends RecyclerView {
    private CenterLayoutManager a;
    private LinearSnapHelper b;
    private StringScrollView$b c;
    private int d;
    private StringScrollView$c e;
    private boolean f;
    private boolean g;
    private boolean h;
    private float i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;

    public StringScrollView(Context context) {
        super(context, null);
        boolean bl2;
        this.f = bl2 = true;
        this.g = bl2;
        this.h = false;
        this.k = (int)(bl2 ? 1 : 0);
        this.l = 0;
        this.m = 0;
        this.n = 0;
    }

    public StringScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        boolean bl2;
        this.f = bl2 = true;
        this.g = bl2;
        this.h = false;
        this.k = (int)(bl2 ? 1 : 0);
        this.l = 0;
        this.m = 0;
        this.n = 0;
    }

    public StringScrollView(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        boolean bl2;
        this.f = bl2 = true;
        this.g = bl2;
        this.h = false;
        this.k = (int)(bl2 ? 1 : 0);
        this.l = 0;
        this.m = 0;
        this.n = 0;
    }

    public static /* synthetic */ CenterLayoutManager a(StringScrollView stringScrollView) {
        return stringScrollView.a;
    }

    public static /* synthetic */ LinearSnapHelper b(StringScrollView stringScrollView) {
        return stringScrollView.b;
    }

    public static /* synthetic */ int c(StringScrollView stringScrollView) {
        return stringScrollView.n;
    }

    public static /* synthetic */ boolean d(StringScrollView stringScrollView) {
        return stringScrollView.f;
    }

    public static /* synthetic */ float e(StringScrollView stringScrollView) {
        return stringScrollView.i;
    }

    public static /* synthetic */ boolean f(StringScrollView stringScrollView) {
        return stringScrollView.h;
    }

    public static /* synthetic */ int g(StringScrollView stringScrollView) {
        return stringScrollView.d;
    }

    public static /* synthetic */ int h(StringScrollView stringScrollView, int n10) {
        stringScrollView.d = n10;
        return n10;
    }

    public static /* synthetic */ StringScrollView$b i(StringScrollView stringScrollView) {
        return stringScrollView.c;
    }

    public static /* synthetic */ StringScrollView$c j(StringScrollView stringScrollView) {
        return stringScrollView.e;
    }

    public static /* synthetic */ int k(StringScrollView stringScrollView) {
        return stringScrollView.l;
    }

    public static /* synthetic */ int l(StringScrollView stringScrollView) {
        return stringScrollView.m;
    }

    public static /* synthetic */ int m(StringScrollView stringScrollView) {
        return stringScrollView.k;
    }

    public static /* synthetic */ int n(StringScrollView stringScrollView) {
        return stringScrollView.j;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean bl2 = this.g;
        if (bl2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return false;
    }

    public int getItemRotation() {
        return this.n;
    }

    public int getRecyclerViewWidth() {
        return this.j;
    }

    public int getSelected() {
        return this.d;
    }

    public void o(int n10, int n11) {
        this.l = n10;
        this.m = n11;
    }

    public void setData(List object) {
        Object object2 = this.c;
        if (object2 != null) {
            ((StringScrollView$b)object2).e((List)object);
            return;
        }
        Context context = this.getContext();
        int n10 = this.k;
        this.a = object2 = new CenterLayoutManager(context, n10, false);
        this.setLayoutManager((RecyclerView$LayoutManager)object2);
        this.b = object2 = new LinearSnapHelper();
        ((SnapHelper)object2).attachToRecyclerView(this);
        this.c = object2 = new StringScrollView$b(this);
        ((StringScrollView$b)object2).e((List)object);
        object = this.c;
        this.setAdapter((RecyclerView$Adapter)object);
        object = new StringScrollView$d(this, null);
        this.addOnScrollListener((RecyclerView$OnScrollListener)object);
    }

    public void setItemRotation(int n10) {
        this.n = n10;
    }

    public void setOnSelectListener(StringScrollView$c stringScrollView$c) {
        this.e = stringScrollView$c;
    }

    public void setOrientation(int n10) {
        this.k = n10;
    }

    public void setRecyclerViewWidth(int n10) {
        this.j = n10;
    }

    public void setScrollEnable(boolean bl2) {
        boolean bl3 = this.f;
        if (bl3 == bl2) {
            return;
        }
        this.f = bl2;
        this.a.b(bl2);
        this.c.notifyDataSetChanged();
    }

    public void setSelected(int n10) {
        Object object;
        int n11;
        if (n10 >= 0 && n10 <= (n11 = (object = this.c.getData()).size() + -1)) {
            object = this.c;
            ((RecyclerView$Adapter)object).notifyDataSetChanged();
            this.smoothScrollToPosition(++n10);
        }
    }

    public void setTextSize(float f10) {
        this.i = f10;
    }

    public void setTouchable(boolean bl2) {
        this.g = bl2;
    }

    public void setUseTheme(boolean bl2) {
        this.h = bl2;
    }
}

