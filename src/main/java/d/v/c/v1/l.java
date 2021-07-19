/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v1;

import d.v.c.b2.w.a;

public class l
extends a {
    private int m;
    private String n;
    private String o;
    private String p;

    public l(int n10, int n11, String string2, String string3, String string4, String string5, String string6, boolean bl2) {
        long l10 = n10;
        super(l10, string4, string2, bl2);
        this.m = n11;
        this.n = string3;
        this.o = string5;
        this.p = string6;
    }

    public String R() {
        return this.o;
    }

    public String S() {
        return this.p;
    }

    public String T() {
        return this.n;
    }

    public int U() {
        return this.m;
    }

    public l V(String string2) {
        this.o = string2;
        return this;
    }

    public l W(String string2) {
        this.p = string2;
        return this;
    }

    public l X(String string2) {
        this.n = string2;
        return this;
    }

    public l Y(int n10) {
        this.m = n10;
        return this;
    }
}

