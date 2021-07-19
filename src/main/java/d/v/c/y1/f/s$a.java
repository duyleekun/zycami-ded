/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y1.f;

import androidx.recyclerview.widget.DiffUtil$ItemCallback;
import d.v.c.k1.b.a;
import d.v.c.y1.f.q;

public class s$a
extends DiffUtil$ItemCallback {
    public boolean a(q q10, q q11) {
        boolean bl2;
        boolean bl3;
        int n10;
        int n11;
        long l10;
        long l11;
        a a10;
        long l12;
        long l13;
        long l14;
        long l15;
        String string2;
        Object object = q10.G().i();
        boolean n112 = ((String)object).equals(string2 = q11.G().i());
        if (n112 && (l15 = (l14 = (l13 = ((a)(object = q10.G())).c()) - (l12 = (a10 = q11.G()).c())) == 0L ? 0 : (l14 < 0L ? -1 : 1)) == false && (l11 = (l10 = (l13 = ((a)(object = q10.G())).h()) - (l12 = (a10 = q11.G()).h())) == 0L ? 0 : (l10 < 0L ? -1 : 1)) == false && (n11 = q10.t()) == (n10 = q11.t()) && (bl3 = q10.z()) == (bl2 = q11.z())) {
            bl3 = true;
        } else {
            bl3 = false;
            q10 = null;
        }
        return bl3;
    }

    public boolean b(q object, q object2) {
        object = ((q)object).G().g();
        object2 = ((q)object2).G().g();
        return ((String)object).equals(object2);
    }
}

