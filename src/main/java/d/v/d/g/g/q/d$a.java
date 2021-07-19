/*
 * Decompiled with CFR 0.151.
 */
package d.v.d.g.g.q;

import d.v.d.g.g.q.c;
import d.v.d.g.g.q.d;
import d.v.d.h.f;
import d.v.d.i.a.c$a;

public class d$a
implements c$a {
    public final /* synthetic */ d a;

    public d$a(d d10) {
        this.a = d10;
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
        if (n11 == n10) {
            object = d.C0(this.a);
            ((c)object).K();
        }
    }
}

