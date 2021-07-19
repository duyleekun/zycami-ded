/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s1;

public class s {
    private double a;
    private String b;
    private boolean c;

    public s() {
        this.a = 1.0;
        this.b = "";
        this.c = false;
    }

    public s(double d10, String string2, boolean bl2) {
        this.a = d10;
        this.b = string2;
        this.c = bl2;
    }

    public String a() {
        return this.b;
    }

    public double b() {
        return this.a;
    }

    public boolean c() {
        return this.c;
    }

    public s d(String string2) {
        this.b = string2;
        return this;
    }

    public s e(double d10) {
        this.a = d10;
        return this;
    }

    public s f(boolean bl2) {
        this.c = bl2;
        return this;
    }
}

