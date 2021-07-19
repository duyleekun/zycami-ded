/*
 * Decompiled with CFR 0.151.
 */
package d.v.h.d;

public class d$a
implements Cloneable {
    private String a;

    public d$a a() {
        d$a d$a = new d$a();
        String string2 = this.b();
        return d$a.c(string2);
    }

    public String b() {
        return this.a;
    }

    public d$a c(String string2) {
        this.a = string2;
        return this;
    }
}

