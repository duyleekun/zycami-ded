/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.SeekBar
 *  android.widget.SeekBar$OnSeekBarChangeListener
 */
package com.zhiyun.cama.camera.dialog.more;

import android.widget.SeekBar;
import com.zhiyun.cama.camera.dialog.more.WhiteBalanceFragment;
import java.util.Locale;

public class WhiteBalanceFragment$a
implements SeekBar.OnSeekBarChangeListener {
    public final /* synthetic */ WhiteBalanceFragment a;

    public WhiteBalanceFragment$a(WhiteBalanceFragment whiteBalanceFragment) {
        this.a = whiteBalanceFragment;
    }

    public void onProgressChanged(SeekBar seekBar, int n10, boolean bl2) {
        n10 = (n10 + 2) * 100;
        WhiteBalanceFragment.j(this.a).q2(n10);
        seekBar = WhiteBalanceFragment.k((WhiteBalanceFragment)this.a).c;
        Locale locale = Locale.getDefault();
        Object object = n10;
        Object[] objectArray = new Object[]{object};
        object = String.format(locale, "%dK", objectArray);
        seekBar.setText((CharSequence)object);
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}

