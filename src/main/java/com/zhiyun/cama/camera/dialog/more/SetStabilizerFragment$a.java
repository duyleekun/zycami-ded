/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.SeekBar
 *  android.widget.SeekBar$OnSeekBarChangeListener
 */
package com.zhiyun.cama.camera.dialog.more;

import android.widget.SeekBar;
import com.zhiyun.cama.camera.dialog.more.SetStabilizerFragment;
import d.v.c.s0.u6;

public class SetStabilizerFragment$a
implements SeekBar.OnSeekBarChangeListener {
    public final /* synthetic */ SetStabilizerFragment a;

    public SetStabilizerFragment$a(SetStabilizerFragment setStabilizerFragment) {
        this.a = setStabilizerFragment;
    }

    public void onProgressChanged(SeekBar object, int n10, boolean bl2) {
        if (bl2) {
            object = SetStabilizerFragment.j(this.a);
            ((u6)object).r2(n10);
        }
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}

