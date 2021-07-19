/*
 * Decompiled with CFR 0.151.
 */
package d.v.k0.f.c;

public class i {
    private int a;
    private String b;
    private int c;

    private i(int n10, String string2, int n11) {
        this.a = n10;
        this.b = string2;
        this.c = n11;
    }

    public static i a(int n10, String string2, int n11) {
        i i10 = new i(n10, string2, n11);
        return i10;
    }

    public int b() {
        return this.c;
    }

    public String c() {
        return this.b;
    }

    public int d() {
        return this.a;
    }

    public i e(int n10) {
        this.c = n10;
        return this;
    }

    public i f(String string2) {
        this.b = string2;
        return this;
    }

    public i g(int n10) {
        this.a = n10;
        return this;
    }
}

