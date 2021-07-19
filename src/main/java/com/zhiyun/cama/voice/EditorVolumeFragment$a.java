/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 *  android.widget.SeekBar
 */
package com.zhiyun.cama.voice;

import android.util.SparseArray;
import android.widget.SeekBar;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.voice.EditorVolumeFragment;
import d.v.c.i1.i2;
import d.v.c.q0.d$a;
import d.v.c.q0.e;
import d.v.e.i.h;

public class EditorVolumeFragment$a
extends d$a {
    public final /* synthetic */ EditorVolumeFragment c;

    public EditorVolumeFragment$a(EditorVolumeFragment editorVolumeFragment) {
        this.c = editorVolumeFragment;
        super(editorVolumeFragment);
    }

    /*
     * WARNING - void declaration
     */
    public void c() {
        Object object;
        super.c();
        Object object2 = EditorVolumeFragment.x(this.c).d();
        boolean n10 = ((e)object2).c();
        if (n10) {
            object = EditorVolumeFragment.D(this.c);
            Float f10 = (Float)((e)object2).a();
            float f11 = f10.floatValue();
            ((i2)object).Q(f11);
        } else {
            Object object3;
            int n11;
            void var2_4;
            boolean bl2 = false;
            object = null;
            while (++var2_4 < (n11 = (object3 = ((e)object2).b()).size())) {
                object3 = EditorVolumeFragment.E(this.c);
                SparseArray sparseArray = ((e)object2).b();
                int n12 = sparseArray.keyAt((int)var2_4);
                Float f12 = (Float)((e)object2).b().valueAt((int)var2_4);
                float f13 = f12.floatValue();
                ((i2)object3).V(n12, f13);
            }
        }
        EditorVolumeFragment.F(this.c, false);
        object = EditorVolumeFragment.G(this.c).r1();
        object2 = ((e)object2).c();
        h.g((MutableLiveData)object, object2);
    }

    public void d() {
        super.d();
        EditorVolumeFragment.H(this.c, 8);
    }

    public void e() {
        super.e();
        MutableLiveData mutableLiveData = EditorVolumeFragment.B(this.c).r1();
        Boolean bl2 = EditorVolumeFragment.C(this.c).s1() ^ true;
        h.g(mutableLiveData, bl2);
    }

    public void f() {
        super.f();
        EditorVolumeFragment.y(this.c, 1.0f);
        EditorVolumeFragment.A(this.c);
    }

    public void h(SeekBar object, int n10, boolean bl2) {
        object = EditorVolumeFragment.x(this.c).c();
        Float f10 = Float.valueOf((float)n10 * 0.01f);
        h.g((MutableLiveData)object, f10);
    }

    public void i() {
        EditorVolumeFragment.z((EditorVolumeFragment)this.c).c.setProgress(0);
    }
}

