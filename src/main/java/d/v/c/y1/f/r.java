/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y1.f;

import androidx.databinding.BaseObservable;
import d.v.e.l.w1;

public class r
extends BaseObservable {
    private int a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private long g;
    private long h;
    private boolean i;
    private int j;
    private boolean k;
    private boolean l;
    private boolean m;

    public String A() {
        return this.f;
    }

    public String B() {
        return this.c;
    }

    public boolean C() {
        return this.m;
    }

    public boolean D() {
        return this.l;
    }

    public boolean E() {
        return this.i;
    }

    public boolean F() {
        return this.k;
    }

    public r G(int n10) {
        this.a = n10;
        return this;
    }

    public r H(boolean bl2) {
        this.m = bl2;
        return this;
    }

    public r I(boolean bl2) {
        this.l = bl2;
        return this;
    }

    public r J(boolean bl2) {
        this.i = bl2;
        return this;
    }

    public r K(int n10) {
        this.j = n10;
        return this;
    }

    public r L(long l10) {
        this.h = l10;
        return this;
    }

    public r M(String string2) {
        this.b = string2;
        return this;
    }

    public r N(boolean bl2) {
        this.k = bl2;
        return this;
    }

    public r O(String string2) {
        this.e = string2;
        return this;
    }

    public r P(long l10) {
        this.g = l10;
        return this;
    }

    public r Q(String string2) {
        this.d = string2;
        return this;
    }

    public r R(String string2) {
        this.f = string2;
        return this;
    }

    public r S(String string2) {
        this.c = string2;
        return this;
    }

    public int s() {
        return this.a;
    }

    public String t() {
        String string2 = w1.a();
        String string3 = this.w();
        String string4 = "zh_CN".toLowerCase();
        boolean bl2 = string2.equals(string4);
        if (bl2) {
            string3 = this.B();
        } else {
            string4 = "zh_TW".toLowerCase();
            boolean bl3 = string2.equals(string4);
            if (bl3) {
                string3 = this.z();
            }
        }
        return string3;
    }

    public int u() {
        return this.j;
    }

    public long v() {
        return this.h;
    }

    public String w() {
        return this.b;
    }

    public String x() {
        return this.e;
    }

    public long y() {
        return this.g;
    }

    public String z() {
        return this.d;
    }
}

