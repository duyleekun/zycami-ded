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
public final class ek$h
extends e {
    private int a;
    private String a;
    private boolean a = "";
    private int b;
    private boolean b = -1;

    public static ek$h a(byte[] byArray) {
        ek$h ek$h = new ek$h();
        return (ek$h)ek$h.a(byArray);
    }

    public int a() {
        int n10 = this.b;
        if (n10 < 0) {
            this.b();
        }
        return this.b;
    }

    public ek$h a(int n10) {
        this.a = true;
        this.a = n10;
        return this;
    }

    public ek$h a(b b10) {
        int n10;
        while ((n10 = b10.a()) != 0) {
            int n11 = 8;
            if (n10 != n11) {
                n11 = 18;
                if (n10 != n11) {
                    if ((n10 = (int)(this.a(b10, n10) ? 1 : 0)) != 0) continue;
                    return this;
                }
                String string2 = b10.a();
                this.a(string2);
                continue;
            }
            n10 = b10.b();
            this.a(n10);
        }
        return this;
    }

    public ek$h a(String string2) {
        this.b = true;
        this.a = string2;
        return this;
    }

    public String a() {
        return this.a;
    }

    public void a(c c10) {
        int n10 = this.a();
        if (n10 != 0) {
            n10 = 1;
            int n11 = this.c();
            c10.a(n10, n11);
        }
        if ((n10 = this.b()) != 0) {
            n10 = 2;
            String string2 = this.a();
            c10.a(n10, string2);
        }
    }

    public boolean a() {
        return this.a;
    }

    public int b() {
        int n10 = this.a();
        int n11 = 0;
        if (n10 != 0) {
            int n12 = this.c();
            n10 = c.a(1, n12);
            n11 = 0 + n10;
        }
        if ((n10 = this.b()) != 0) {
            String string2 = this.a();
            n10 = c.a(2, string2);
            n11 += n10;
        }
        this.b = n11;
        return n11;
    }

    public boolean b() {
        return this.b;
    }

    public int c() {
        return this.a;
    }
}

