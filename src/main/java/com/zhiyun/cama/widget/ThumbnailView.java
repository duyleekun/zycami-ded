/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.util.AttributeSet
 */
package com.zhiyun.cama.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import com.zhiyun.cama.widget.ThumbnailView$a;
import com.zhiyun.cama.widget.ThumbnailView$c;
import com.zhiyun.cama.widget.ThumbnailView$d;
import d.v.c.b2.m;
import d.v.c.b2.u;
import d.v.c.k1.a.s;
import d.v.c.m0;
import d.v.e.l.h2;
import d.v.v.q.h;
import java.util.List;

public class ThumbnailView
extends u {
    private ThumbnailView$c k;
    private List l;
    private long m;
    private double n;
    private String o;
    private int p;
    private int q;

    public ThumbnailView(Context context) {
        this(context, null);
    }

    public ThumbnailView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThumbnailView(Context object, AttributeSet attributeSet, int n10) {
        super((Context)object, attributeSet, n10);
        super();
        this.l = object;
        this.q = -1;
        this.Q();
        this.P();
    }

    public static /* synthetic */ ThumbnailView$c H(ThumbnailView thumbnailView) {
        return thumbnailView.k;
    }

    public static /* synthetic */ long I(ThumbnailView thumbnailView) {
        return thumbnailView.m;
    }

    public static /* synthetic */ long J(ThumbnailView thumbnailView, long l10) {
        thumbnailView.m = l10;
        return l10;
    }

    public static /* synthetic */ double K(ThumbnailView thumbnailView) {
        return thumbnailView.n;
    }

    public static /* synthetic */ int L(ThumbnailView thumbnailView) {
        return thumbnailView.p;
    }

    public static /* synthetic */ String M(ThumbnailView thumbnailView) {
        return thumbnailView.o;
    }

    public static /* synthetic */ List N(ThumbnailView thumbnailView) {
        return thumbnailView.l;
    }

    public static /* synthetic */ int O(ThumbnailView thumbnailView) {
        return thumbnailView.q;
    }

    private void P() {
        ThumbnailView$a thumbnailView$a = new ThumbnailView$a(this);
        this.setOnHandScrollListener(thumbnailView$a);
    }

    private void Q() {
        int n10 = h2.b(0.0f);
        int n11 = h2.b(0.0f);
        int n12 = h2.b(0.0f);
        Object object = new s(n10, n11, n12);
        this.addItemDecoration((RecyclerView$ItemDecoration)object);
        Context context = this.getContext();
        object = new LinearLayoutManager(context, 0, false);
        this.setLayoutManager((RecyclerView$LayoutManager)object);
    }

    private /* synthetic */ void R() {
        double d10 = this.m;
        double d11 = this.n;
        int n10 = (int)(d10 / d11);
        this.scrollBy(n10, 0);
    }

    private void W(String object, long l10, boolean bl2, int n10, long l11, long l12) {
        long l13;
        long l14;
        long l15;
        Long l16;
        Long l17;
        this.q = n10;
        List list = this.l;
        list.clear();
        this.m = l12;
        this.o = object;
        double d10 = l10;
        n10 = m0.l;
        double d11 = n10;
        this.n = d10 /= d11;
        l12 = h.C((String)object);
        long l18 = Math.max(l12, l11);
        int n11 = (int)(l18 / l10);
        long l19 = 0L;
        d11 = 0.0;
        long l20 = (l18 %= l10) - l19;
        Object object2 = l20 == 0L ? 0 : (l20 < 0L ? -1 : 1);
        if (object2 != false) {
            ++n11;
            double d12 = l18;
            double d13 = this.n;
            this.p = n10 = (int)(d12 /= d13);
        }
        if (bl2) {
            list = this.l;
            l11 = -1;
            l17 = l11;
            list.add(l17);
        }
        n10 = 0;
        list = null;
        l17 = null;
        for (int i10 = 0; i10 < n11; ++i10) {
            Long l21;
            List list2;
            object2 = l12 == l19 ? 0 : (l12 < l19 ? -1 : 1);
            if (object2 == false) {
                list2 = this.l;
                l21 = l19;
                list2.add(l21);
                continue;
            }
            list2 = this.l;
            long l22 = (long)i10 * l10 % l12;
            l21 = l22;
            list2.add(l21);
        }
        if (bl2) {
            object = this.l;
            l10 = -2;
            l16 = l10;
            object.add(l16);
        }
        if ((n11 = (object = this.l).size()) != 0) {
            l16 = null;
            object = new ThumbnailView$d(this, null);
            this.setAdapter((RecyclerView$Adapter)object);
        }
        if ((l15 = (l14 = (l13 = this.m) - l19) == 0L ? 0 : (l14 < 0L ? -1 : 1)) != false) {
            double d14 = l13;
            double d15 = this.n;
            n11 = (int)(d14 /= d15);
            this.scrollBy(n11, 0);
        }
    }

    public /* synthetic */ void S() {
        this.R();
    }

    public void T(String string2, long l10) {
        this.W(string2, l10, false, 0, 0L, 0L);
    }

    public void U(String string2, long l10, int n10) {
        this.W(string2, l10, true, n10, 0L, 0L);
    }

    public void V(String string2, long l10, int n10, long l11, long l12) {
        this.W(string2, l10, true, n10, l11, l12);
    }

    public int getFooterLayoutCount() {
        return 0;
    }

    public int getHeaderLayoutCount() {
        return 0;
    }

    public void onConfigurationChanged(Configuration object) {
        super.onConfigurationChanged(object);
        object = new ThumbnailView$d(this, null);
        this.setAdapter((RecyclerView$Adapter)object);
        object = new m(this);
        this.post((Runnable)object);
    }

    public void setOnThumbnailScrollListener(ThumbnailView$c thumbnailView$c) {
        this.k = thumbnailView$c;
    }
}

