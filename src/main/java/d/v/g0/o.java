/*
 * Decompiled with CFR 0.151.
 */
package d.v.g0;

public class o {
    private String a;
    private int b;

    public o() {
    }

    public o(String string2, int n10) {
        this.a = string2;
        this.b = n10;
    }

    public int a() {
        return this.b;
    }

    public String b() {
        return this.a;
    }

    public o c(int n10) {
        this.b = n10;
        return this;
    }

    public o d(String string2) {
        this.a = string2;
        return this;
    }
}

