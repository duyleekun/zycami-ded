/*
 * Decompiled with CFR 0.151.
 */
package d.v.d.g.c.y;

import d.v.d.g.c.y.g;
import d.v.d.g.c.y.h;
import d.v.d.h.f;
import d.v.d.i.a.c$a;

public class h$a
implements c$a {
    public final /* synthetic */ h a;

    public h$a(h h10) {
        this.a = h10;
    }

    public void b(Integer object, int n10) {
        CharSequence charSequence = new StringBuilder();
        String string2 = "photo control change integer=";
        charSequence.append(string2);
        charSequence.append(object);
        charSequence = charSequence.toString();
        f.a((String)charSequence);
        int n11 = (Integer)object;
        n10 = 11;
        if (n10 == n11) {
            object = h.L0(this.a);
            ((g)object).V();
        }
    }
}

