/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.voice.record.volume;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.voice.record.volume.EditorRecordVolumeFragment$a;
import d.v.c.b1.t.g;
import d.v.c.i1.i2;
import d.v.c.q0.d;
import d.v.c.w0.n7;
import d.v.c.y1.g.n.a;
import d.v.c.y1.g.n.b;
import d.v.e.i.h;

public class EditorRecordVolumeFragment
extends d {
    private b j;
    private n7 k;

    public static /* synthetic */ n7 A(EditorRecordVolumeFragment editorRecordVolumeFragment) {
        return editorRecordVolumeFragment.k;
    }

    private void B() {
        MutableLiveData mutableLiveData = this.j.b();
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        a a10 = new a(this);
        mutableLiveData.observe(lifecycleOwner, a10);
    }

    private void C() {
        Object object = this.g;
        int n10 = d.v.v.q.h.o();
        float f10 = ((i2)object).P1(n10);
        this.j.d(f10);
        MutableLiveData mutableLiveData = this.j.b();
        object = Float.valueOf(f10);
        h.g(mutableLiveData, object);
    }

    private /* synthetic */ void D(Float f10) {
        g g10 = this.g;
        int n10 = d.v.v.q.h.o();
        float f11 = f10.floatValue();
        g10.t3(n10, f11);
    }

    public static /* synthetic */ b x(EditorRecordVolumeFragment editorRecordVolumeFragment) {
        return editorRecordVolumeFragment.j;
    }

    public static /* synthetic */ g y(EditorRecordVolumeFragment editorRecordVolumeFragment) {
        return editorRecordVolumeFragment.g;
    }

    public static /* synthetic */ void z(EditorRecordVolumeFragment editorRecordVolumeFragment, long l10) {
        editorRecordVolumeFragment.w(l10);
    }

    public /* synthetic */ void E(Float f10) {
        this.D(f10);
    }

    public int h() {
        return 2131558581;
    }

    public void i(ViewDataBinding object) {
        super.i((ViewDataBinding)object);
        object = (n7)object;
        this.k = object;
        this.j = object = (b)d.v.i0.b.a(this).get(b.class);
        this.k.B((b)object);
        object = this.k;
        EditorRecordVolumeFragment$a editorRecordVolumeFragment$a = new EditorRecordVolumeFragment$a(this);
        ((n7)object).A(editorRecordVolumeFragment$a);
        this.C();
        this.B();
    }

    public boolean s(int n10) {
        this.k.u().g(n10);
        return true;
    }
}

