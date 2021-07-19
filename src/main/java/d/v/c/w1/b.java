/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 */
package d.v.c.w1;

import android.widget.CompoundButton;
import d.v.c.w1.c;

public final class b
implements CompoundButton.OnCheckedChangeListener {
    public static final /* synthetic */ b a;

    static {
        b b10;
        a = b10 = new b();
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean bl2) {
        c.w(compoundButton, bl2);
    }
}

