/*
 * Decompiled with CFR 0.151.
 */
package d.v.d.g.g.p;

import d.v.d.g.g.p.d;
import d.v.d.g.g.p.e;
import d.v.d.h.f;
import d.v.d.i.a.c$a;

public class e$a
implements c$a {
    public final /* synthetic */ e a;

    public e$a(e e10) {
        this.a = e10;
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
            object = this.a.r;
            ((d)object).M();
        }
    }
}

