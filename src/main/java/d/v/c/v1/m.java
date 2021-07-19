/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v1;

import d.v.e.l.w1;

public class m {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private int g;
    private String h;
    private String i;

    public String a() {
        String string2 = w1.a();
        String string3 = this.d();
        String string4 = "zh_CN".toLowerCase();
        boolean bl2 = string2.equals(string4);
        if (bl2) {
            string3 = this.i();
        } else {
            string4 = "zh_TW".toLowerCase();
            boolean bl3 = string2.equals(string4);
            if (bl3) {
                string3 = this.f();
            }
        }
        return string3;
    }

    public String b() {
        return this.h;
    }

    public String c() {
        return this.i;
    }

    public String d() {
        return this.b;
    }

    public String e() {
        return this.f;
    }

    public String f() {
        return this.c;
    }

    public String g() {
        return this.d;
    }

    public String h() {
        return this.e;
    }

    public String i() {
        return this.a;
    }

    public int j() {
        return this.g;
    }

    public m k(String string2) {
        this.h = string2;
        return this;
    }

    public m l(String string2) {
        this.i = string2;
        return this;
    }

    public m m(String string2) {
        this.b = string2;
        return this;
    }

    public m n(String string2) {
        this.f = string2;
        return this;
    }

    public m o(String string2) {
        this.c = string2;
        return this;
    }

    public m p(String string2) {
        this.d = string2;
        return this;
    }

    public m q(String string2) {
        this.e = string2;
        return this;
    }

    public m r(String string2) {
        this.a = string2;
        return this;
    }

    public m s(int n10) {
        this.g = n10;
        return this;
    }
}

