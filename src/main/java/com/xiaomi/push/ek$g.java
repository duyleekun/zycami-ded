/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.b;
import com.xiaomi.push.c;
import com.xiaomi.push.e;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class ek$g
extends e {
    private int a;
    private String a;
    private boolean a;
    private String b;
    private boolean b;
    private String c;
    private boolean c;

    public ek$g() {
        String string2;
        this.a = string2 = "";
        this.b = string2;
        this.c = string2;
        this.a = -1;
    }

    public static ek$g a(byte[] byArray) {
        ek$g ek$g = new ek$g();
        return (ek$g)ek$g.a(byArray);
    }

    public int a() {
        int n10 = this.a;
        if (n10 < 0) {
            this.b();
        }
        return this.a;
    }

    public ek$g a(b b10) {
        int n10;
        while ((n10 = b10.a()) != 0) {
            String string2;
            int n11 = 10;
            if (n10 != n11) {
                n11 = 18;
                if (n10 != n11) {
                    n11 = 26;
                    if (n10 != n11) {
                        if ((n10 = (int)(this.a(b10, n10) ? 1 : 0)) != 0) continue;
                        return this;
                    }
                    string2 = b10.a();
                    this.c(string2);
                    continue;
                }
                string2 = b10.a();
                this.b(string2);
                continue;
            }
            string2 = b10.a();
            this.a(string2);
        }
        return this;
    }

    public ek$g a(String string2) {
        this.a = true;
        this.a = string2;
        return this;
    }

    public String a() {
        return this.a;
    }

    public void a(c c10) {
        String string2;
        int n10 = this.a();
        if (n10 != 0) {
            n10 = 1;
            string2 = this.a();
            c10.a(n10, string2);
        }
        if ((n10 = this.b()) != 0) {
            n10 = 2;
            string2 = this.b();
            c10.a(n10, string2);
        }
        if ((n10 = (int)(this.c() ? 1 : 0)) != 0) {
            n10 = 3;
            string2 = this.c();
            c10.a(n10, string2);
        }
    }

    public boolean a() {
        return this.a;
    }

    public int b() {
        String string2;
        int n10 = this.a();
        int n11 = 0;
        if (n10 != 0) {
            string2 = this.a();
            n10 = com.xiaomi.push.c.a(1, string2);
            n11 = 0 + n10;
        }
        if ((n10 = this.b()) != 0) {
            string2 = this.b();
            n10 = com.xiaomi.push.c.a(2, string2);
            n11 += n10;
        }
        if ((n10 = (int)(this.c() ? 1 : 0)) != 0) {
            string2 = this.c();
            n10 = com.xiaomi.push.c.a(3, string2);
            n11 += n10;
        }
        this.a = n11;
        return n11;
    }

    public ek$g b(String string2) {
        this.b = true;
        this.b = string2;
        return this;
    }

    public String b() {
        return this.b;
    }

    public boolean b() {
        return this.b;
    }

    public ek$g c(String string2) {
        this.c = true;
        this.c = string2;
        return this;
    }

    public String c() {
        return this.c;
    }

    public boolean c() {
        return this.c;
    }
}

