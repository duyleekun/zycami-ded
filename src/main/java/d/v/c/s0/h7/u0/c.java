/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 */
package d.v.c.s0.h7.u0;

import android.widget.CompoundButton;
import d.v.c.s0.h7.u0.j;
import d.v.c.w0.yh;

public final class c
implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ yh a;

    public /* synthetic */ c(yh yh2) {
        this.a = yh2;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean bl2) {
        j.f(this.a, compoundButton, bl2);
    }
}

