/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.SeekBar
 */
package d.v.c.f1.a;

import android.widget.SeekBar;
import androidx.databinding.adapters.SeekBarBindingAdapter$OnProgressChanged;
import d.v.c.f1.a.g$a;

public final class g
implements SeekBarBindingAdapter$OnProgressChanged {
    public final g$a a;
    public final int b;

    public g(g$a g$a, int n10) {
        this.a = g$a;
        this.b = n10;
    }

    public void onProgressChanged(SeekBar seekBar, int n10, boolean bl2) {
        g$a g$a = this.a;
        int n11 = this.b;
        g$a.n(n11, seekBar, n10, bl2);
    }
}

