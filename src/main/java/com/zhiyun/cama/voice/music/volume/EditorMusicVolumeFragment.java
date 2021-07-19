/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.View
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 */
package com.zhiyun.cama.voice.music.volume;

import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.zhiyun.cama.voice.music.volume.EditorMusicVolumeFragment$a;
import com.zhiyun.cama.voice.music.volume.EditorMusicVolumeFragment$b;
import d.v.c.b1.t.g;
import d.v.c.i1.i2;
import d.v.c.w0.h7;
import d.v.c.y1.f.y.a;
import d.v.c.y1.f.y.c;
import d.v.c.y1.f.y.d;
import d.v.c.y1.f.y.e;
import d.v.e.i.h;
import d.v.i0.b;

public class EditorMusicVolumeFragment
extends d.v.c.q0.d {
    private h7 j;
    private e k;
    private boolean l;
    private int m;

    public static /* synthetic */ boolean A(EditorMusicVolumeFragment editorMusicVolumeFragment) {
        return editorMusicVolumeFragment.l;
    }

    public static /* synthetic */ g B(EditorMusicVolumeFragment editorMusicVolumeFragment) {
        return editorMusicVolumeFragment.g;
    }

    public static /* synthetic */ g C(EditorMusicVolumeFragment editorMusicVolumeFragment) {
        return editorMusicVolumeFragment.g;
    }

    public static /* synthetic */ g D(EditorMusicVolumeFragment editorMusicVolumeFragment) {
        return editorMusicVolumeFragment.g;
    }

    public static /* synthetic */ g E(EditorMusicVolumeFragment editorMusicVolumeFragment) {
        return editorMusicVolumeFragment.g;
    }

    public static /* synthetic */ void F(EditorMusicVolumeFragment editorMusicVolumeFragment, long l10) {
        editorMusicVolumeFragment.w(l10);
    }

    public static /* synthetic */ g G(EditorMusicVolumeFragment editorMusicVolumeFragment) {
        return editorMusicVolumeFragment.g;
    }

    private void H() {
        Object object;
        int n10 = this.m;
        int n11 = -1;
        if (n10 == n11) {
            this.r();
            return;
        }
        n10 = (int)(this.l ? 1 : 0);
        if (n10 != 0) {
            object = this.g.H1();
            n11 = this.m;
            object = (d.v.h.h.b)object.get(n11);
        } else {
            object = this.g.O1();
            n11 = this.m;
            object = (d.v.h.h.b)object.get(n11);
        }
        if (object == null) {
            this.r();
            return;
        }
        this.k.z((d.v.h.h.b)object);
        e e10 = this.k;
        long l10 = ((d.v.h.h.b)object).m();
        e10.H(l10);
        e10 = this.k;
        l10 = ((d.v.h.h.b)object).f();
        e10.A(l10);
        object = this.g;
        long l11 = d.v.v.q.h.F(this.m);
        long l12 = d.v.v.q.h.D(this.m);
        ((i2)object).x3(l11, l12);
        object = this.g;
        n11 = this.m;
        long l13 = ((i2)object).F1(n11);
        this.k.F(l13);
        Object object2 = this.k.j();
        Long l14 = l13;
        h.g(object2, l14);
        object2 = this.j.d;
        n10 = this.k.e(l13);
        object2.setProgress(n10);
        object = this.g;
        n11 = this.m;
        l13 = ((i2)object).G1(n11);
        this.k.G(l13);
        object2 = this.k.k();
        l14 = l13;
        h.g(object2, l14);
        object2 = this.j.e;
        n10 = this.k.e(l13);
        object2.setProgress(n10);
    }

    private void I() {
        MutableLiveData mutableLiveData = this.k.l();
        Object object = this.getViewLifecycleOwner();
        Observer observer = new a(this);
        mutableLiveData.observe((LifecycleOwner)object, observer);
        mutableLiveData = this.j.b.getViewTreeObserver();
        object = new EditorMusicVolumeFragment$a(this);
        mutableLiveData.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)object);
        mutableLiveData = this.k.j();
        object = this.getViewLifecycleOwner();
        observer = new c(this);
        mutableLiveData.observe((LifecycleOwner)object, observer);
        mutableLiveData = this.k.k();
        object = this.getViewLifecycleOwner();
        observer = new d.v.c.y1.f.y.b(this);
        mutableLiveData.observe((LifecycleOwner)object, observer);
    }

    private void J() {
        Object object = this.g;
        int n10 = this.m;
        boolean bl2 = this.l;
        float f10 = ((i2)object).D0(n10, bl2);
        this.k.I(f10);
        MutableLiveData mutableLiveData = this.k.l();
        object = Float.valueOf(f10);
        h.g(mutableLiveData, object);
    }

    private /* synthetic */ void K(Float f10) {
        g g10 = this.g;
        int n10 = this.m;
        float f11 = f10.floatValue();
        boolean bl2 = this.l;
        g10.e3(n10, f11, bl2);
    }

    private /* synthetic */ void M(Long l10) {
        g g10 = this.g;
        int n10 = this.m;
        long l11 = l10;
        g10.o3(n10, l11);
    }

    private /* synthetic */ void O(Long l10) {
        g g10 = this.g;
        int n10 = this.m;
        long l11 = l10;
        g10.p3(n10, l11);
    }

    public static /* synthetic */ h7 x(EditorMusicVolumeFragment editorMusicVolumeFragment) {
        return editorMusicVolumeFragment.j;
    }

    public static /* synthetic */ e y(EditorMusicVolumeFragment editorMusicVolumeFragment) {
        return editorMusicVolumeFragment.k;
    }

    public static /* synthetic */ int z(EditorMusicVolumeFragment editorMusicVolumeFragment) {
        return editorMusicVolumeFragment.m;
    }

    public /* synthetic */ void L(Float f10) {
        this.K(f10);
    }

    public /* synthetic */ void N(Long l10) {
        this.M(l10);
    }

    public /* synthetic */ void P(Long l10) {
        this.O(l10);
    }

    public int h() {
        return 2131558578;
    }

    public void i(ViewDataBinding object) {
        super.i((ViewDataBinding)object);
        object = (h7)object;
        this.j = object;
        this.k = object = (e)d.v.i0.b.a(this).get(e.class);
        this.j.B((e)object);
        object = this.j;
        EditorMusicVolumeFragment$b editorMusicVolumeFragment$b = new EditorMusicVolumeFragment$b(this);
        ((h7)object).A(editorMusicVolumeFragment$b);
    }

    public void onViewCreated(View object, Bundle bundle) {
        int n10;
        super.onViewCreated((View)object, bundle);
        object = this.getArguments();
        if (object == null) {
            return;
        }
        object = d.v.c.y1.f.y.d.b(this.getArguments());
        this.l = n10 = ((d)object).c();
        n10 = n10 != 0 ? d.v.v.q.h.m() : d.v.v.q.h.o();
        this.m = n10;
        int n11 = -1;
        if (n10 == n11) {
            this.r();
            return;
        }
        this.J();
        this.H();
        this.I();
    }

    public boolean s(int n10) {
        this.j.u().g(n10);
        return true;
    }
}

