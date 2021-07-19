/*
 * Decompiled with CFR 0.151.
 */
package d.v.d.g.c.z;

import d.v.d.g.c.z.f;
import d.v.d.g.c.z.g;
import d.v.d.i.a.c$a;

public class g$a
implements c$a {
    public final /* synthetic */ g a;

    public g$a(g g10) {
        this.a = g10;
    }

    public void b(Integer object, int n10) {
        CharSequence charSequence = new StringBuilder();
        String string2 = "photo control change integer=";
        charSequence.append(string2);
        charSequence.append(object);
        charSequence = charSequence.toString();
        d.v.d.h.f.a((String)charSequence);
        int n11 = (Integer)object;
        n10 = 1;
        if (n10 == n11) {
            object = g.L0(this.a);
            ((f)object).O();
        }
    }
}

