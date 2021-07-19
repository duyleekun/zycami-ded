/*
 * Decompiled with CFR 0.151.
 */
package d.v.k0.f.d;

public class a {
    private int a = -1;
    private String b;
    private String c;
    private byte[] d;

    public void a() {
        this.a = -1;
        this.b = null;
        this.c = null;
        this.d = null;
    }

    public a b() {
        a a10 = new a();
        Object object = this.b;
        object = a10.h((String)object);
        int n10 = this.a;
        object = ((a)object).j(n10);
        String string2 = this.c;
        ((a)object).i(string2);
        return a10;
    }

    public byte[] c() {
        return this.d;
    }

    public String d() {
        return this.b;
    }

    public String e() {
        return this.c;
    }

    public int f() {
        return this.a;
    }

    public a g(byte[] byArray) {
        this.d = byArray;
        return this;
    }

    public a h(String string2) {
        this.b = string2;
        return this;
    }

    public a i(String string2) {
        this.c = string2;
        return this;
    }

    public a j(int n10) {
        this.a = n10;
        return this;
    }
}

