/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 */
package d.v.c.z0;

import android.widget.CompoundButton;
import d.v.c.z0.k;

public final class g
implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ k a;

    public /* synthetic */ g(k k10) {
        this.a = k10;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean bl2) {
        k.B(this.a, compoundButton, bl2);
    }
}

