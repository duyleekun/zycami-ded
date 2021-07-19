/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 */
package d.v.c.i1.s2;

import android.widget.CompoundButton;
import d.v.c.i1.s2.r;

public final class f
implements CompoundButton.OnCheckedChangeListener {
    public static final /* synthetic */ f a;

    static {
        f f10;
        a = f10 = new f();
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean bl2) {
        r.G(compoundButton, bl2);
    }
}

