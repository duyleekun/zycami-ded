/*
 * Decompiled with CFR 0.151.
 */
package d.v.d.g.d.v;

import d.v.d.g.d.v.h;
import d.v.d.g.d.v.i;
import d.v.d.h.f;
import d.v.d.i.a.c$a;

public class i$a
implements c$a {
    public final /* synthetic */ i a;

    public i$a(i i10) {
        this.a = i10;
    }

    public void b(Integer object, int n10) {
        CharSequence charSequence = new StringBuilder();
        String string2 = "photo control change integer=";
        charSequence.append(string2);
        charSequence.append(object);
        charSequence = charSequence.toString();
        f.a((String)charSequence);
        int n11 = (Integer)object;
        n10 = 1;
        if (n10 == n11) {
            object = i.V0(this.a);
            ((h)object).Z();
        }
    }
}

