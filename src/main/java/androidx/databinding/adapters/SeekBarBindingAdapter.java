/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.SeekBar
 *  android.widget.SeekBar$OnSeekBarChangeListener
 */
package androidx.databinding.adapters;

import android.widget.SeekBar;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.adapters.SeekBarBindingAdapter$1;
import androidx.databinding.adapters.SeekBarBindingAdapter$OnProgressChanged;
import androidx.databinding.adapters.SeekBarBindingAdapter$OnStartTrackingTouch;
import androidx.databinding.adapters.SeekBarBindingAdapter$OnStopTrackingTouch;

public class SeekBarBindingAdapter {
    public static void setOnSeekBarChangeListener(SeekBar seekBar, SeekBarBindingAdapter$OnStartTrackingTouch seekBarBindingAdapter$OnStartTrackingTouch, SeekBarBindingAdapter$OnStopTrackingTouch seekBarBindingAdapter$OnStopTrackingTouch, SeekBarBindingAdapter$OnProgressChanged seekBarBindingAdapter$OnProgressChanged, InverseBindingListener inverseBindingListener) {
        if (seekBarBindingAdapter$OnStartTrackingTouch == null && seekBarBindingAdapter$OnStopTrackingTouch == null && seekBarBindingAdapter$OnProgressChanged == null && inverseBindingListener == null) {
            seekBarBindingAdapter$OnStartTrackingTouch = null;
            seekBar.setOnSeekBarChangeListener(null);
        } else {
            SeekBarBindingAdapter$1 seekBarBindingAdapter$1 = new SeekBarBindingAdapter$1(seekBarBindingAdapter$OnProgressChanged, inverseBindingListener, seekBarBindingAdapter$OnStartTrackingTouch, seekBarBindingAdapter$OnStopTrackingTouch);
            seekBar.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)seekBarBindingAdapter$1);
        }
    }

    public static void setProgress(SeekBar seekBar, int n10) {
        int n11 = seekBar.getProgress();
        if (n10 != n11) {
            seekBar.setProgress(n10);
        }
    }
}

