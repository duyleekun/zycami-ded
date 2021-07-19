/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import d.v.e0.ce;
import d.v.e0.oe.q;
import e.a.v0.r;

public class ce$m1
implements r {
    public final /* synthetic */ ce a;

    public ce$m1(ce ce2) {
        this.a = ce2;
    }

    public boolean a(Integer n10) {
        CharSequence charSequence = new StringBuilder();
        String string2 = "Filter nodes count, node count = ";
        charSequence.append(string2);
        charSequence.append(n10);
        charSequence = charSequence.toString();
        q.i((String)charSequence);
        boolean bl2 = n10.intValue();
        boolean bl3 = true;
        if (bl2 < bl3) {
            bl3 = false;
            charSequence = null;
        }
        return bl3;
    }
}

