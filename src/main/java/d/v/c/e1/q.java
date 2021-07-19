/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package d.v.c.e1;

import android.graphics.Bitmap;
import d.v.c.b2.w.a;

public class q
extends a {
    private int m;
    private int n;
    private String o;
    private String p;

    public q(int n10, int n11, String string2, String string3, String string4, Bitmap bitmap, boolean bl2) {
        long l10 = n10;
        super(l10, string2, string4, bl2);
        this.P(bitmap);
        this.m = n11;
        this.o = string3;
    }

    public String R() {
        return this.p;
    }

    public String S() {
        return this.o;
    }

    public int T() {
        return this.m;
    }

    public int U() {
        return this.n;
    }

    public void V(String string2) {
        this.p = string2;
    }

    public void W(String string2) {
        this.o = string2;
    }

    public void X(int n10) {
        this.m = n10;
    }

    public void Y(int n10) {
        this.n = n10;
    }

    public long x() {
        return this.getId();
    }
}

