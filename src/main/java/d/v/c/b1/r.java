/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.c.b1;

import android.content.Context;
import androidx.databinding.BaseObservable;
import d.v.e.l.l2;
import d.v.f.i.g;

public class r
extends BaseObservable {
    private long a;
    private String b;
    private String c;
    private double d;
    private int e;

    public r() {
    }

    public r(long l10, String string2, String string3, double d10, int n10) {
        this.a = l10;
        this.b = string2;
        this.c = string3;
        this.d = d10;
        this.e = n10;
    }

    public void A(long l10) {
        this.a = l10;
    }

    public r B(double d10) {
        this.d = d10;
        return this;
    }

    public r C(int n10) {
        this.e = n10;
        return this;
    }

    public r D(String string2) {
        this.b = string2;
        return this;
    }

    public String s() {
        return this.c;
    }

    public long t() {
        return this.a;
    }

    public double u() {
        return this.d;
    }

    public int v() {
        return this.e;
    }

    public String w(Context object) {
        StringBuilder stringBuilder = new StringBuilder();
        object = g.m(object, 2131952108);
        stringBuilder.append((String)object);
        stringBuilder.append(" ");
        int n10 = this.e;
        stringBuilder.append(n10);
        stringBuilder.append("p");
        return stringBuilder.toString();
    }

    public String x(Context object) {
        StringBuilder stringBuilder = new StringBuilder();
        object = g.m(object, 2131952101);
        stringBuilder.append((String)object);
        stringBuilder.append(" ");
        object = l2.d((long)(this.d * 1000000.0));
        stringBuilder.append((String)object);
        return stringBuilder.toString();
    }

    public String y() {
        return this.b;
    }

    public r z(String string2) {
        this.c = string2;
        return this;
    }
}

