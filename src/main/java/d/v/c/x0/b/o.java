/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.x0.b;

import com.zhiyun.editorinterface.decoration.DecorationType;
import d.v.c.b2.w.a;

public class o
extends a {
    private long m;
    private String n;
    private float o;
    private String p;
    private DecorationType q;

    public o(int n10, long l10, String string2, String string3, String string4, float f10, String string5, boolean bl2) {
        DecorationType decorationType;
        long l11 = n10;
        super(l11, string2, string4, bl2);
        this.q = decorationType = DecorationType.IMAGE_PASTER;
        this.m = l10;
        this.n = string3;
        this.o = f10;
        this.p = string5;
    }

    public DecorationType R() {
        return this.q;
    }

    public String S() {
        return this.p;
    }

    public float T() {
        return this.o;
    }

    public String U() {
        return this.n;
    }

    public long V() {
        return this.m;
    }

    public o W(DecorationType decorationType) {
        this.q = decorationType;
        return this;
    }

    public o X(String string2) {
        this.p = string2;
        return this;
    }

    public o Y(float f10) {
        this.o = f10;
        return this;
    }

    public o Z(String string2) {
        this.n = string2;
        return this;
    }

    public o a0(long l10) {
        this.m = l10;
        return this;
    }

    public long x() {
        return this.getId();
    }
}

