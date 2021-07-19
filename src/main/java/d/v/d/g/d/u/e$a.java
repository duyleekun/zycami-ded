/*
 * Decompiled with CFR 0.151.
 */
package d.v.d.g.d.u;

import d.v.d.g.d.u.d;
import d.v.d.g.d.u.e;
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
        switch (n11) {
            default: {
                break;
            }
            case 13: {
                object = e.V0(this.a);
                ((d)object).e0();
                break;
            }
            case 12: {
                object = e.V0(this.a);
                ((d)object).f0();
                break;
            }
            case 11: {
                object = e.V0(this.a);
                ((d)object).g0();
            }
        }
    }
}

