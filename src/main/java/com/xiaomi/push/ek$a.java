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
public final class ek$a
extends e {
    private int a;
    private long a;
    private String a;
    private boolean a = 0L;
    private int b;
    private String b;
    private boolean b;
    private int c;
    private String c;
    private boolean c;
    private int d;
    private String d;
    private boolean d;
    private int e;
    private String e;
    private boolean e;
    private String f;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;

    public ek$a() {
        String string2;
        this.a = string2 = "";
        this.b = string2;
        this.c = string2;
        this.d = string2;
        this.e = string2;
        this.b = 1;
        this.c = 0;
        this.d = 0;
        this.f = string2;
        this.e = -1;
    }

    public int a() {
        int n10 = this.e;
        if (n10 < 0) {
            this.b();
        }
        return this.e;
    }

    public long a() {
        return this.a;
    }

    public ek$a a() {
        this.f = false;
        this.d = "";
        return this;
    }

    public ek$a a(int n10) {
        this.a = true;
        this.a = n10;
        return this;
    }

    public ek$a a(long l10) {
        this.b = true;
        this.a = l10;
        return this;
    }

    public ek$a a(b b10) {
        block14: while (true) {
            int n10 = b10.a();
            switch (n10) {
                default: {
                    if ((n10 = (int)(this.a(b10, n10) ? 1 : 0)) != 0) continue block14;
                    return this;
                }
                case 90: {
                    String string2 = b10.a();
                    this.f(string2);
                    continue block14;
                }
                case 80: {
                    n10 = b10.b();
                    this.d(n10);
                    continue block14;
                }
                case 72: {
                    n10 = b10.b();
                    this.c(n10);
                    continue block14;
                }
                case 64: {
                    n10 = b10.b();
                    this.b(n10);
                    continue block14;
                }
                case 58: {
                    String string2 = b10.a();
                    this.e(string2);
                    continue block14;
                }
                case 50: {
                    String string2 = b10.a();
                    this.d(string2);
                    continue block14;
                }
                case 42: {
                    String string2 = b10.a();
                    this.c(string2);
                    continue block14;
                }
                case 34: {
                    String string2 = b10.a();
                    this.b(string2);
                    continue block14;
                }
                case 26: {
                    String string2 = b10.a();
                    this.a(string2);
                    continue block14;
                }
                case 16: {
                    long l10 = b10.b();
                    this.a(l10);
                    continue block14;
                }
                case 8: {
                    n10 = b10.b();
                    this.a(n10);
                    continue block14;
                }
                case 0: 
            }
            break;
        }
        return this;
    }

    public ek$a a(String string2) {
        this.c = true;
        this.a = string2;
        return this;
    }

    public String a() {
        return this.a;
    }

    public void a(c c10) {
        String string2;
        int n10;
        int n11 = this.a();
        if (n11 != 0) {
            n11 = 1;
            n10 = this.c();
            c10.a(n11, n10);
        }
        if ((n11 = this.b()) != 0) {
            n11 = 2;
            long l10 = this.a();
            c10.b(n11, l10);
        }
        if ((n11 = (int)(this.c() ? 1 : 0)) != 0) {
            n11 = 3;
            string2 = this.a();
            c10.a(n11, string2);
        }
        if ((n11 = (int)(this.d() ? 1 : 0)) != 0) {
            n11 = 4;
            string2 = this.b();
            c10.a(n11, string2);
        }
        if ((n11 = (int)(this.e() ? 1 : 0)) != 0) {
            n11 = 5;
            string2 = this.c();
            c10.a(n11, string2);
        }
        if ((n11 = (int)(this.f() ? 1 : 0)) != 0) {
            n11 = 6;
            string2 = this.d();
            c10.a(n11, string2);
        }
        if ((n11 = (int)(this.g() ? 1 : 0)) != 0) {
            n11 = 7;
            string2 = this.e();
            c10.a(n11, string2);
        }
        if ((n11 = (int)(this.h() ? 1 : 0)) != 0) {
            n11 = 8;
            n10 = this.d();
            c10.a(n11, n10);
        }
        if ((n11 = (int)(this.i() ? 1 : 0)) != 0) {
            n11 = 9;
            n10 = this.e();
            c10.a(n11, n10);
        }
        if ((n11 = (int)(this.j() ? 1 : 0)) != 0) {
            n11 = 10;
            n10 = this.f();
            c10.a(n11, n10);
        }
        if ((n11 = (int)(this.k() ? 1 : 0)) != 0) {
            n11 = 11;
            string2 = this.f();
            c10.a(n11, string2);
        }
    }

    public boolean a() {
        return this.a;
    }

    public int b() {
        String string2;
        int n10;
        int n11 = this.a();
        int n12 = 0;
        if (n11 != 0) {
            n10 = this.c();
            n11 = com.xiaomi.push.c.a(1, n10);
            n12 = 0 + n11;
        }
        if ((n11 = this.b()) != 0) {
            long l10 = this.a();
            n11 = com.xiaomi.push.c.b(2, l10);
            n12 += n11;
        }
        if ((n11 = (int)(this.c() ? 1 : 0)) != 0) {
            string2 = this.a();
            n11 = com.xiaomi.push.c.a(3, string2);
            n12 += n11;
        }
        if ((n11 = (int)(this.d() ? 1 : 0)) != 0) {
            string2 = this.b();
            n11 = com.xiaomi.push.c.a(4, string2);
            n12 += n11;
        }
        if ((n11 = (int)(this.e() ? 1 : 0)) != 0) {
            string2 = this.c();
            n11 = com.xiaomi.push.c.a(5, string2);
            n12 += n11;
        }
        if ((n11 = (int)(this.f() ? 1 : 0)) != 0) {
            string2 = this.d();
            n11 = com.xiaomi.push.c.a(6, string2);
            n12 += n11;
        }
        if ((n11 = (int)(this.g() ? 1 : 0)) != 0) {
            string2 = this.e();
            n11 = com.xiaomi.push.c.a(7, string2);
            n12 += n11;
        }
        if ((n11 = (int)(this.h() ? 1 : 0)) != 0) {
            n10 = this.d();
            n11 = com.xiaomi.push.c.a(8, n10);
            n12 += n11;
        }
        if ((n11 = (int)(this.i() ? 1 : 0)) != 0) {
            n10 = this.e();
            n11 = com.xiaomi.push.c.a(9, n10);
            n12 += n11;
        }
        if ((n11 = (int)(this.j() ? 1 : 0)) != 0) {
            n10 = this.f();
            n11 = com.xiaomi.push.c.a(10, n10);
            n12 += n11;
        }
        if ((n11 = (int)(this.k() ? 1 : 0)) != 0) {
            string2 = this.f();
            n11 = com.xiaomi.push.c.a(11, string2);
            n12 += n11;
        }
        this.e = n12;
        return n12;
    }

    public ek$a b(int n10) {
        this.h = true;
        this.b = n10;
        return this;
    }

    public ek$a b(String string2) {
        this.d = true;
        this.b = string2;
        return this;
    }

    public String b() {
        return this.b;
    }

    public boolean b() {
        return this.b;
    }

    public int c() {
        return this.a;
    }

    public ek$a c(int n10) {
        this.i = true;
        this.c = n10;
        return this;
    }

    public ek$a c(String string2) {
        this.e = true;
        this.c = string2;
        return this;
    }

    public String c() {
        return this.c;
    }

    public boolean c() {
        return this.c;
    }

    public int d() {
        return this.b;
    }

    public ek$a d(int n10) {
        this.j = true;
        this.d = n10;
        return this;
    }

    public ek$a d(String string2) {
        this.f = true;
        this.d = string2;
        return this;
    }

    public String d() {
        return this.d;
    }

    public boolean d() {
        return this.d;
    }

    public int e() {
        return this.c;
    }

    public ek$a e(String string2) {
        this.g = true;
        this.e = string2;
        return this;
    }

    public String e() {
        return this.e;
    }

    public boolean e() {
        return this.e;
    }

    public int f() {
        return this.d;
    }

    public ek$a f(String string2) {
        this.k = true;
        this.f = string2;
        return this;
    }

    public String f() {
        return this.f;
    }

    public boolean f() {
        return this.f;
    }

    public boolean g() {
        return this.g;
    }

    public boolean h() {
        return this.h;
    }

    public boolean i() {
        return this.i;
    }

    public boolean j() {
        return this.j;
    }

    public boolean k() {
        return this.k;
    }
}

