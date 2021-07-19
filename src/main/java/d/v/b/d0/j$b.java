/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.SeekBar
 *  android.widget.SeekBar$OnSeekBarChangeListener
 */
package d.v.b.d0;

import android.widget.SeekBar;
import d.v.b.d0.j;
import d.v.b.d0.k.l;
import d.v.d.h.f;

public class j$b
implements SeekBar.OnSeekBarChangeListener {
    public final /* synthetic */ j a;

    public j$b(j j10) {
        this.a = j10;
    }

    public void onProgressChanged(SeekBar object, int n10, boolean bl2) {
        object = new StringBuilder();
        ((StringBuilder)object).append("on progress changed progress=");
        ((StringBuilder)object).append(n10);
        String string2 = ",formUser=";
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(bl2);
        object = ((StringBuilder)object).toString();
        f.a((String)object);
        if (bl2) {
            object = j.g(this.a);
            Object object2 = j.f(this.a);
            object.removeCallbacks((Runnable)object2);
            object = j.g(this.a);
            object2 = j.h(this.a);
            object.removeCallbacks((Runnable)object2);
            j.e(this.a, true);
            object = this.a;
            float f10 = 1.0f;
            j.i((j)object, f10);
            j.j(this.a).animate().cancel();
            object = j.k(this.a);
            object2 = (Integer)j.k(this.a).e();
            int n11 = (Integer)object2;
            Integer n12 = n10 += n11;
            ((l)object).o(n12);
        }
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        f.a("on start tracking");
        seekBar = j.g(this.a);
        Runnable runnable = j.h(this.a);
        seekBar.removeCallbacks(runnable);
        seekBar = j.g(this.a);
        runnable = j.f(this.a);
        seekBar.removeCallbacks(runnable);
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        f.a("on Stop tracking");
        seekBar = j.g(this.a);
        Runnable runnable = j.h(this.a);
        seekBar.removeCallbacks(runnable);
        seekBar = j.g(this.a);
        runnable = j.h(this.a);
        seekBar.postDelayed(runnable, 1500L);
    }
}

