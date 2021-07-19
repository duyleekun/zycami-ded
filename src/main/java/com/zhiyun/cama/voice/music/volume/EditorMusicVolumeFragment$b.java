/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.SeekBar
 */
package com.zhiyun.cama.voice.music.volume;

import android.widget.SeekBar;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.voice.music.volume.EditorMusicVolumeFragment;
import d.v.c.b1.t.g;
import d.v.c.i1.i2;
import d.v.c.q0.d$a;
import d.v.c.y1.f.y.e;
import d.v.e.i.h;

public class EditorMusicVolumeFragment$b
extends d$a {
    public final /* synthetic */ EditorMusicVolumeFragment c;

    public EditorMusicVolumeFragment$b(EditorMusicVolumeFragment editorMusicVolumeFragment) {
        this.c = editorMusicVolumeFragment;
        super(editorMusicVolumeFragment);
    }

    public void c() {
        super.c();
        Object object = EditorMusicVolumeFragment.B(this.c);
        int n10 = EditorMusicVolumeFragment.z(this.c);
        Object object2 = EditorMusicVolumeFragment.y(this.c);
        float f10 = ((e)object2).y();
        Object object3 = this.c;
        boolean bl2 = EditorMusicVolumeFragment.A((EditorMusicVolumeFragment)object3);
        ((i2)object).e3(n10, f10, bl2);
        object = EditorMusicVolumeFragment.y(this.c).x();
        Object object4 = EditorMusicVolumeFragment.y(this.c).u();
        if (object != null && object4 != null) {
            object3 = EditorMusicVolumeFragment.C(this.c);
            long l10 = (Long)object;
            long l11 = (Long)object4;
            boolean bl3 = EditorMusicVolumeFragment.A(this.c);
            ((i2)object3).w0(l10, l11, bl3, false);
            object = EditorMusicVolumeFragment.D(this.c);
            n10 = EditorMusicVolumeFragment.z(this.c);
            long l12 = EditorMusicVolumeFragment.y(this.c).v();
            ((i2)object).o3(n10, l12);
            object = EditorMusicVolumeFragment.E(this.c);
            object4 = this.c;
            n10 = EditorMusicVolumeFragment.z((EditorMusicVolumeFragment)object4);
            object2 = EditorMusicVolumeFragment.y(this.c).w();
            l12 = (Long)object2;
            ((i2)object).p3(n10, l12);
        }
    }

    public void d() {
        super.d();
        EditorMusicVolumeFragment editorMusicVolumeFragment = this.c;
        boolean bl2 = EditorMusicVolumeFragment.A(editorMusicVolumeFragment);
        long l10 = bl2 ? 0x2000000L : 0x20000000L;
        EditorMusicVolumeFragment.F(editorMusicVolumeFragment, l10);
    }

    public void h(SeekBar object, int n10, boolean n11) {
        int n12;
        n11 = object.getId();
        if (n11 == (n12 = 2131363182)) {
            object = EditorMusicVolumeFragment.y(this.c).l();
            Float f10 = Float.valueOf((float)n10 * 0.01f);
            h.g((MutableLiveData)object, f10);
            return;
        }
        n11 = object.getId();
        if (n11 == (n12 = 2131363183)) {
            object = EditorMusicVolumeFragment.y(this.c).j();
            Long l10 = EditorMusicVolumeFragment.y(this.c).d(n10);
            h.g((MutableLiveData)object, l10);
            return;
        }
        int n13 = object.getId();
        if (n13 == (n11 = 2131363184)) {
            object = EditorMusicVolumeFragment.y(this.c).k();
            e e10 = EditorMusicVolumeFragment.y(this.c);
            long l11 = e10.d(n10);
            Long l12 = l11;
            h.g((MutableLiveData)object, l12);
        }
    }

    public void i(int n10) {
        EditorMusicVolumeFragment.y(this.c).c(n10);
    }

    public void j() {
        long l10 = EditorMusicVolumeFragment.y(this.c).p();
        long l11 = EditorMusicVolumeFragment.y(this.c).g();
        g g10 = EditorMusicVolumeFragment.G(this.c);
        boolean bl2 = EditorMusicVolumeFragment.A(this.c);
        g10.w0(l10, l11, bl2, true);
    }

    public void k() {
    }

    public void l() {
        EditorMusicVolumeFragment.x((EditorMusicVolumeFragment)this.c).c.setProgress(0);
    }
}

