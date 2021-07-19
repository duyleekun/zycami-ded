/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.SeekBar
 *  android.widget.SeekBar$OnSeekBarChangeListener
 */
package com.zhiyun.cama.camera.widget;

import android.widget.SeekBar;
import com.zhiyun.cama.camera.widget.PartitionSeekBar;

public class PartitionSeekBar$a
implements SeekBar.OnSeekBarChangeListener {
    public final /* synthetic */ PartitionSeekBar a;

    public PartitionSeekBar$a(PartitionSeekBar partitionSeekBar) {
        this.a = partitionSeekBar;
    }

    public void onProgressChanged(SeekBar seekBar, int n10, boolean bl2) {
        Object object;
        if (bl2 && (object = PartitionSeekBar.a(this.a)) != null) {
            PartitionSeekBar partitionSeekBar;
            object = (Float)PartitionSeekBar.a(this.a).getLower();
            float f10 = object.floatValue();
            float f11 = this.a.getMax();
            int n11 = (int)(f10 *= f11);
            Float f12 = (Float)PartitionSeekBar.a(this.a).getUpper();
            f11 = f12.floatValue();
            PartitionSeekBar partitionSeekBar2 = this.a;
            int n12 = partitionSeekBar2.getMax();
            float f13 = n12;
            int n13 = (int)(f11 *= f13);
            if ((n10 < n11 || n10 > n13) && (n10 = Math.min(Math.max((partitionSeekBar = this.a).getProgress(), n11), n13)) != (n11 = (object = this.a).getProgress())) {
                object = this.a;
                object.setProgress(n10);
            }
        }
        if ((object = PartitionSeekBar.b(this.a)) != null) {
            object = PartitionSeekBar.b(this.a);
            object.onProgressChanged(seekBar, n10, bl2);
        }
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = PartitionSeekBar.b(this.a);
        if (onSeekBarChangeListener != null) {
            onSeekBarChangeListener = PartitionSeekBar.b(this.a);
            onSeekBarChangeListener.onStartTrackingTouch(seekBar);
        }
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = PartitionSeekBar.b(this.a);
        if (onSeekBarChangeListener != null) {
            onSeekBarChangeListener = PartitionSeekBar.b(this.a);
            onSeekBarChangeListener.onStopTrackingTouch(seekBar);
        }
    }
}

