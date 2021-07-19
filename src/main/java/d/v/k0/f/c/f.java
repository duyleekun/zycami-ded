/*
 * Decompiled with CFR 0.151.
 */
package d.v.k0.f.c;

public class f {
    private int a;
    private int b;

    private f(int n10, int n11) {
        this.a = n10;
        this.b = n11;
    }

    public static f a(int n10, int n11) {
        f f10 = new f(n10, n11);
        return f10;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.a;
    }

    public f d(int n10) {
        this.b = n10;
        return this;
    }

    public f e(int n10) {
        this.a = n10;
        return this;
    }
}

