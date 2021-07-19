/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package d.v.c.e1;

import android.graphics.Bitmap;
import d.v.e.l.w1;

public class r {
    private int a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private Bitmap g;
    private boolean h;
    private String i;

    public String a() {
        return this.c;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.e;
    }

    public String d() {
        return this.d;
    }

    public Bitmap e() {
        return this.g;
    }

    public String f() {
        return this.f;
    }

    public String g() {
        String string2 = this.i;
        if (string2 == null) {
            String string3;
            string2 = w1.a();
            this.i = string3 = this.a();
            string3 = "zh_CN".toLowerCase();
            boolean bl2 = string2.equals(string3);
            if (bl2) {
                this.i = string2 = this.b();
            } else {
                string3 = "zh_TW".toLowerCase();
                boolean bl3 = string2.equals(string3);
                if (bl3) {
                    this.i = string2 = this.d();
                }
            }
        }
        return this.i;
    }

    public int h() {
        return this.a;
    }

    public boolean i() {
        return this.h;
    }

    public r j(boolean bl2) {
        this.h = bl2;
        return this;
    }

    public r k(String string2) {
        this.c = string2;
        return this;
    }

    public r l(String string2) {
        this.b = string2;
        return this;
    }

    public r m(String string2) {
        this.e = string2;
        return this;
    }

    public r n(String string2) {
        this.d = string2;
        return this;
    }

    public r o(Bitmap bitmap) {
        this.g = bitmap;
        return this;
    }

    public r p(String string2) {
        this.f = string2;
        return this;
    }

    public r q(String string2) {
        this.i = string2;
        return this;
    }

    public r r(int n10) {
        this.a = n10;
        return this;
    }
}

