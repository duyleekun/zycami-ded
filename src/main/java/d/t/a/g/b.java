/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap$CompressFormat
 */
package d.t.a.g;

import android.graphics.Bitmap;
import d.t.a.g.c;

public class b {
    private int a;
    private int b;
    private Bitmap.CompressFormat c;
    private int d;
    private String e;
    private String f;
    private c g;

    public b(int n10, int n11, Bitmap.CompressFormat compressFormat, int n12, String string2, String string3, c c10) {
        this.a = n10;
        this.b = n11;
        this.c = compressFormat;
        this.d = n12;
        this.e = string2;
        this.f = string3;
        this.g = c10;
    }

    public Bitmap.CompressFormat a() {
        return this.c;
    }

    public int b() {
        return this.d;
    }

    public c c() {
        return this.g;
    }

    public String d() {
        return this.e;
    }

    public String e() {
        return this.f;
    }

    public int f() {
        return this.a;
    }

    public int g() {
        return this.b;
    }
}

