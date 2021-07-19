/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.r;

import d.n.a.q0.b;
import d.n.a.q0.r.d;
import java.util.Map;

public class a
implements Map.Entry {
    private final String a;
    private final d b;

    public a(String string2, d d10) {
        this.a = string2;
        this.b = d10;
    }

    public String a() {
        return this.a;
    }

    public b b() {
        return (b)this.b.get();
    }

    public b c(b object) {
        object = new UnsupportedOperationException("Not implemented");
        throw object;
    }

    public boolean equals(Object object) {
        boolean bl2;
        boolean bl3 = true;
        if (this == object) {
            return bl3;
        }
        boolean bl4 = object instanceof a;
        if (!bl4) {
            return false;
        }
        Object object2 = this.a;
        String string2 = ((a)(object = (a)object)).a();
        bl4 = ((String)object2).equals(string2);
        if (!bl4 || !(bl2 = ((d)(object2 = this.b)).equals(object = ((a)object).b))) {
            bl3 = false;
        }
        return bl3;
    }

    public int hashCode() {
        int n10 = this.a.hashCode() * 31;
        int n11 = this.b.hashCode();
        return n10 + n11;
    }
}

