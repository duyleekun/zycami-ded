/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s1;

import androidx.recyclerview.widget.DiffUtil$ItemCallback;
import d.v.c.s1.t;

public class r$a
extends DiffUtil$ItemCallback {
    public boolean a(t t10, t t11) {
        double d10;
        double d11;
        double d12;
        boolean bl2;
        boolean bl3;
        boolean bl4 = t10.u();
        if (bl4 == (bl3 = t11.u()) && !(bl2 = (d12 = (d11 = t10.s()) - (d10 = t11.s())) == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1))) {
            bl2 = true;
        } else {
            bl2 = false;
            t10 = null;
        }
        return bl2;
    }

    public boolean b(t t10, t t11) {
        return true;
    }
}

