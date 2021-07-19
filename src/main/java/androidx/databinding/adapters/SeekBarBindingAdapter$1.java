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
import androidx.databinding.adapters.SeekBarBindingAdapter$OnProgressChanged;
import androidx.databinding.adapters.SeekBarBindingAdapter$OnStartTrackingTouch;
import androidx.databinding.adapters.SeekBarBindingAdapter$OnStopTrackingTouch;

public final class SeekBarBindingAdapter$1
implements SeekBar.OnSeekBarChangeListener {
    public final /* synthetic */ InverseBindingListener val$attrChanged;
    public final /* synthetic */ SeekBarBindingAdapter$OnProgressChanged val$progressChanged;
    public final /* synthetic */ SeekBarBindingAdapter$OnStartTrackingTouch val$start;
    public final /* synthetic */ SeekBarBindingAdapter$OnStopTrackingTouch val$stop;

    public SeekBarBindingAdapter$1(SeekBarBindingAdapter$OnProgressChanged onProgressChanged, InverseBindingListener inverseBindingListener, SeekBarBindingAdapter$OnStartTrackingTouch onStartTrackingTouch, SeekBarBindingAdapter$OnStopTrackingTouch onStopTrackingTouch) {
        this.val$progressChanged = onProgressChanged;
        this.val$attrChanged = inverseBindingListener;
        this.val$start = onStartTrackingTouch;
        this.val$stop = onStopTrackingTouch;
    }

    public void onProgressChanged(SeekBar object, int n10, boolean bl2) {
        SeekBarBindingAdapter$OnProgressChanged seekBarBindingAdapter$OnProgressChanged = this.val$progressChanged;
        if (seekBarBindingAdapter$OnProgressChanged != null) {
            seekBarBindingAdapter$OnProgressChanged.onProgressChanged((SeekBar)object, n10, bl2);
        }
        if ((object = this.val$attrChanged) != null) {
            object.onChange();
        }
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        SeekBarBindingAdapter$OnStartTrackingTouch seekBarBindingAdapter$OnStartTrackingTouch = this.val$start;
        if (seekBarBindingAdapter$OnStartTrackingTouch != null) {
            seekBarBindingAdapter$OnStartTrackingTouch.onStartTrackingTouch(seekBar);
        }
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        SeekBarBindingAdapter$OnStopTrackingTouch seekBarBindingAdapter$OnStopTrackingTouch = this.val$stop;
        if (seekBarBindingAdapter$OnStopTrackingTouch != null) {
            seekBarBindingAdapter$OnStopTrackingTouch.onStopTrackingTouch(seekBar);
        }
    }
}

