/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.RadioGroup
 */
package com.zhiyun.cama.decoration.sticker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback;
import com.zhiyun.account.widget.StatusView;
import com.zhiyun.cama.data.api.entity.sticker.StickerTabInfo;
import com.zhiyun.cama.decoration.sticker.EditorStickerFragment$a;
import com.zhiyun.cama.decoration.sticker.EditorStickerFragment$b;
import com.zhiyun.cama.decoration.sticker.EditorStickerFragment$c;
import com.zhiyun.editorinterface.decoration.DecorationType;
import d.v.c.b1.t.g;
import d.v.c.i1.i2;
import d.v.c.q0.d;
import d.v.c.w0.ic;
import d.v.c.w0.v7;
import d.v.c.x0.b.o;
import d.v.c.x0.b.s;
import d.v.e.i.h;
import d.v.e.l.h2;
import d.v.h.d.c;
import d.v.i0.b;
import d.v.j.e.h.k;
import java.util.ArrayList;
import java.util.List;

public class EditorStickerFragment
extends d {
    private v7 j;
    private s k;
    private EditorStickerFragment$b l;
    private boolean m;
    private int n = 0;
    private List o;
    private EditorStickerFragment$c p;

    public EditorStickerFragment() {
        ArrayList arrayList;
        this.o = arrayList = new ArrayList();
    }

    public static /* synthetic */ g A(EditorStickerFragment editorStickerFragment) {
        return editorStickerFragment.g;
    }

    public static /* synthetic */ g B(EditorStickerFragment editorStickerFragment) {
        return editorStickerFragment.g;
    }

    public static /* synthetic */ boolean C(EditorStickerFragment editorStickerFragment) {
        return editorStickerFragment.K();
    }

    public static /* synthetic */ void D(EditorStickerFragment editorStickerFragment) {
        editorStickerFragment.O();
    }

    public static /* synthetic */ void E(EditorStickerFragment editorStickerFragment) {
        editorStickerFragment.t();
    }

    public static /* synthetic */ boolean F(EditorStickerFragment editorStickerFragment) {
        return editorStickerFragment.m;
    }

    private int G(long l10) {
        Object object;
        int n10;
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = (object = this.o).size()); ++i10) {
            object = (StickerTabInfo)this.o.get(i10);
            long l11 = ((StickerTabInfo)object).getId();
            long l12 = l10 - l11;
            n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            if (n10 != 0) continue;
            n11 = i10;
            break;
        }
        return n11;
    }

    private void H() {
        Object object = this.j.e;
        Object object2 = new EditorStickerFragment$a(this);
        ((ViewPager2)((Object)object)).registerOnPageChangeCallback((ViewPager2$OnPageChangeCallback)object2);
        object = this.k.e();
        object2 = this.getViewLifecycleOwner();
        Observer observer = d.v.c.x0.b.c.a;
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.k.f();
        object2 = this.getViewLifecycleOwner();
        observer = new d.v.c.x0.b.b(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
    }

    private void I(List list) {
        int n10;
        this.j.c.removeAllViews();
        ViewPager2 viewPager2 = null;
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            View view;
            StickerTabInfo stickerTabInfo = (StickerTabInfo)list.get(i10);
            Object object = this.getLayoutInflater();
            RadioGroup radioGroup = this.j.c;
            object = (ic)DataBindingUtil.inflate((LayoutInflater)object, 2131558648, (ViewGroup)radioGroup, false);
            int n11 = 0x41400000;
            float f10 = 12.0f;
            int n12 = 1101004800;
            float f11 = 20.0f;
            if (i10 == 0) {
                view = ((ViewDataBinding)object).getRoot();
                n12 = h2.b(f11);
                n11 = h2.b(f10);
                view.setPadding(n12, 0, n11, 0);
            } else {
                int n13 = list.size() + -1;
                if (i10 == n13) {
                    view = ((ViewDataBinding)object).getRoot();
                    n11 = h2.b(f10);
                    n12 = h2.b(f11);
                    view.setPadding(n11, 0, n12, 0);
                }
            }
            Object object2 = this.l;
            ((ic)object).B((EditorStickerFragment$b)object2);
            object2 = this.k;
            ((ic)object).C((s)object2);
            ((ic)object).D(stickerTabInfo);
            ((ViewDataBinding)object).setLifecycleOwner(this);
            stickerTabInfo = this.j.c;
            object = ((ViewDataBinding)object).getRoot();
            stickerTabInfo.addView((View)object);
        }
        viewPager2 = this.j.e;
        int n14 = list.size() + -1;
        viewPager2.setOffscreenPageLimit(n14);
    }

    private void J() {
        boolean bl2;
        this.j.d.e();
        this.k.g();
        Object object = this.g.W0();
        if (object != null) {
            object = ((c)object).t();
        }
        s s10 = this.k;
        s10.l((c)object);
        object = this.g.W0();
        boolean bl3 = true;
        if (object != null) {
            bl2 = bl3;
        } else {
            bl2 = false;
            object = null;
        }
        this.m = bl2;
        this.p = object = new EditorStickerFragment$c(this, this);
        this.j.e.setAdapter((RecyclerView$Adapter)object);
        object = this.p;
        Object object2 = this.o;
        EditorStickerFragment$c.a((EditorStickerFragment$c)object, (List)object2);
        object = this.k.c();
        object2 = this.n;
        h.g((MutableLiveData)object, object2);
        object = this.j.e;
        int n10 = this.n;
        ((ViewPager2)((Object)object)).setCurrentItem(n10);
        object = this.g;
        object2 = DecorationType.IMAGE_PASTER;
        ((i2)object).F3((DecorationType)((Object)object2), bl3, false);
    }

    private boolean K() {
        boolean bl2;
        o o10 = this.k.b();
        if (o10 != null && (bl2 = o10.J()) && !(bl2 = d.v.c.m1.b.a())) {
            bl2 = true;
        } else {
            bl2 = false;
            o10 = null;
        }
        return bl2;
    }

    public static /* synthetic */ void L(k k10) {
    }

    private /* synthetic */ void M(List list) {
        int n10 = d.v.j.b.f(list);
        if (n10 != 0) {
            return;
        }
        this.o = list;
        this.I(list);
        Object object = this.p;
        Object object2 = this.o;
        EditorStickerFragment$c.a((EditorStickerFragment$c)object, (List)object2);
        object = this.g.W0();
        if (object != null) {
            long l10 = ((c)object).z();
            this.n = n10 = this.G(l10);
            object2 = this.j.e;
            ((ViewPager2)((Object)object2)).setCurrentItem(n10);
        }
        boolean bl2 = list.isEmpty();
        this.P(bl2);
    }

    private void O() {
        boolean bl2 = true;
        this.v(bl2);
        Object object = this.k.j();
        Object object2 = this.g.W0();
        if (object == null && object2 == null) {
            return;
        }
        if (object == null) {
            long l10 = 16384L;
            this.w(l10);
        } else if (object2 == null) {
            long l11 = 32768L;
            this.w(l11);
        } else {
            long l12 = 131072L;
            this.w(l12);
        }
        object = this.g;
        object2 = DecorationType.IMAGE_PASTER;
        ((i2)object).F3((DecorationType)((Object)object2), bl2, bl2);
    }

    private void P(boolean bl2) {
        if (bl2) {
            StatusView statusView = this.j.d;
            statusView.d();
        } else {
            StatusView statusView = this.j.d;
            statusView.a();
        }
    }

    public static /* synthetic */ s x(EditorStickerFragment editorStickerFragment) {
        return editorStickerFragment.k;
    }

    public static /* synthetic */ v7 y(EditorStickerFragment editorStickerFragment) {
        return editorStickerFragment.j;
    }

    public static /* synthetic */ g z(EditorStickerFragment editorStickerFragment) {
        return editorStickerFragment.g;
    }

    public /* synthetic */ void N(List list) {
        this.M(list);
    }

    public int h() {
        return 2131558585;
    }

    public void i(ViewDataBinding object) {
        super.i((ViewDataBinding)object);
        object = (v7)object;
        this.j = object;
        this.l = object = new EditorStickerFragment$b(this);
        this.j.z((EditorStickerFragment$b)object);
        this.k = object = (s)d.v.i0.b.a(this).get(s.class);
        this.J();
        this.H();
    }

    public void j() {
        this.O();
        this.u();
    }

    public void k() {
        super.k();
        this.j.u().c();
    }

    public boolean s(int n10) {
        this.j.u().g(n10);
        return this.K() ^ true;
    }
}

