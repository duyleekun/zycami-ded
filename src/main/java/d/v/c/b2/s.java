/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.SeekBar
 *  android.widget.SeekBar$OnSeekBarChangeListener
 */
package d.v.c.b2;

import android.widget.SeekBar;

public interface s
extends SeekBar.OnSeekBarChangeListener {
    default public void onProgressChanged(SeekBar seekBar, int n10, boolean bl2) {
    }

    default public void onStartTrackingTouch(SeekBar seekBar) {
    }

    default public void onStopTrackingTouch(SeekBar seekBar) {
    }
}

