/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s1;

import androidx.databinding.BaseObservable;

public class t
extends BaseObservable {
    private String a;
    private double b;
    private boolean c;

    public double s() {
        return this.b;
    }

    public String t() {
        return this.a;
    }

    public boolean u() {
        return this.c;
    }

    public t v(boolean bl2) {
        this.c = bl2;
        return this;
    }

    public t w(double d10) {
        this.b = d10;
        return this;
    }

    public t x(String string2) {
        this.a = string2;
        return this;
    }
}

