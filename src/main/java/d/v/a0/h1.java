/*
 * Decompiled with CFR 0.151.
 */
package d.v.a0;

import d.v.k0.f.d.a;
import d.v.z.n.g;

public class h1 {
    private g a;
    private String b;

    public h1(g object, a a10) {
        this.a = object;
        this.b = object = a10.d();
    }

    public h1(g g10, String string2) {
        this.a = g10;
        this.b = string2;
    }

    public String a() {
        return this.b;
    }

    public g b() {
        return this.a;
    }

    public h1 c(String string2) {
        this.b = string2;
        return this;
    }

    public h1 d(g g10) {
        this.a = g10;
        return this;
    }
}

