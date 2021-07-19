/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.SeekBar
 */
package com.zhiyun.cama.voice.record.volume;

import android.widget.SeekBar;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.voice.record.volume.EditorRecordVolumeFragment;
import d.v.c.b1.t.g;
import d.v.c.q0.d$a;
import d.v.e.i.h;

public class EditorRecordVolumeFragment$a
extends d$a {
    public final /* synthetic */ EditorRecordVolumeFragment c;

    public EditorRecordVolumeFragment$a(EditorRecordVolumeFragment editorRecordVolumeFragment) {
        this.c = editorRecordVolumeFragment;
        super(editorRecordVolumeFragment);
    }

    public void c() {
        super.c();
        g g10 = EditorRecordVolumeFragment.y(this.c);
        int n10 = d.v.v.q.h.o();
        float f10 = EditorRecordVolumeFragment.x(this.c).c();
        g10.t3(n10, f10);
    }

    public void d() {
        EditorRecordVolumeFragment.z(this.c, 0x20000000L);
        super.d();
    }

    public void h(SeekBar object, int n10, boolean bl2) {
        object = EditorRecordVolumeFragment.x(this.c).b();
        Float f10 = Float.valueOf((float)n10 * 0.01f);
        h.g((MutableLiveData)object, f10);
    }

    public void i() {
        EditorRecordVolumeFragment.A((EditorRecordVolumeFragment)this.c).b.setProgress(0);
    }
}

