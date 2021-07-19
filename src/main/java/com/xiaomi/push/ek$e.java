/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.b;
import com.xiaomi.push.c;
import com.xiaomi.push.e;
import com.xiaomi.push.ek$b;
import java.util.Objects;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class ek$e
extends e {
    private int a;
    private ek$b a;
    private String a;
    private boolean a = 0;
    private int b;
    private String b;
    private boolean b;
    private int c;
    private String c;
    private boolean c;
    private int d;
    private String d;
    private boolean d;
    private String e;
    private boolean e;
    private String f;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;

    public ek$e() {
        String string2;
        this.a = string2 = "";
        this.b = string2;
        this.c = string2;
        this.b = 0;
        this.d = string2;
        this.e = string2;
        this.f = string2;
        this.a = null;
        this.c = 0;
        this.d = -1;
    }

    public int a() {
        int n10 = this.d;
        if (n10 < 0) {
            this.b();
        }
        return this.d;
    }

    public ek$b a() {
        return this.a;
    }

    public ek$e a(int n10) {
        this.a = true;
        this.a = n10;
        return this;
    }

    public ek$e a(b b10) {
        block13: while (true) {
            int n10 = b10.a();
            switch (n10) {
                default: {
                    if ((n10 = (int)(this.a(b10, n10) ? 1 : 0)) != 0) continue block13;
                    return this;
                }
                case 80: {
                    n10 = b10.b();
                    this.c(n10);
                    continue block13;
                }
                case 74: {
                    Object object = new ek$b();
                    b10.a((e)object);
                    this.a((ek$b)object);
                    continue block13;
                }
                case 66: {
                    Object object = b10.a();
                    this.f((String)object);
                    continue block13;
                }
                case 58: {
                    Object object = b10.a();
                    this.e((String)object);
                    continue block13;
                }
                case 50: {
                    Object object = b10.a();
                    this.d((String)object);
                    continue block13;
                }
                case 40: {
                    n10 = b10.b();
                    this.b(n10);
                    continue block13;
                }
                case 34: {
                    Object object = b10.a();
                    this.c((String)object);
                    continue block13;
                }
                case 26: {
                    Object object = b10.a();
                    this.b((String)object);
                    continue block13;
                }
                case 18: {
                    Object object = b10.a();
                    this.a((String)object);
                    continue block13;
                }
                case 8: {
                    n10 = b10.c();
                    this.a(n10);
                    continue block13;
                }
                case 0: 
            }
            break;
        }
        return this;
    }

    public ek$e a(ek$b ek$b) {
        Objects.requireNonNull(ek$b);
        this.i = true;
        this.a = ek$b;
        return this;
    }

    public ek$e a(String string2) {
        this.b = true;
        this.a = string2;
        return this;
    }

    public String a() {
        return this.a;
    }

    public void a(c c10) {
        Object object;
        int n10;
        int n11 = this.a();
        if (n11 != 0) {
            n11 = 1;
            n10 = this.c();
            c10.b(n11, n10);
        }
        if ((n11 = this.b()) != 0) {
            n11 = 2;
            object = this.a();
            c10.a(n11, (String)object);
        }
        if ((n11 = (int)(this.c() ? 1 : 0)) != 0) {
            n11 = 3;
            object = this.b();
            c10.a(n11, (String)object);
        }
        if ((n11 = (int)(this.d() ? 1 : 0)) != 0) {
            n11 = 4;
            object = this.c();
            c10.a(n11, (String)object);
        }
        if ((n11 = (int)(this.e() ? 1 : 0)) != 0) {
            n11 = 5;
            n10 = this.d();
            c10.a(n11, n10);
        }
        if ((n11 = (int)(this.f() ? 1 : 0)) != 0) {
            n11 = 6;
            object = this.d();
            c10.a(n11, (String)object);
        }
        if ((n11 = (int)(this.g() ? 1 : 0)) != 0) {
            n11 = 7;
            object = this.e();
            c10.a(n11, (String)object);
        }
        if ((n11 = (int)(this.h() ? 1 : 0)) != 0) {
            n11 = 8;
            object = this.f();
            c10.a(n11, (String)object);
        }
        if ((n11 = (int)(this.i() ? 1 : 0)) != 0) {
            n11 = 9;
            object = this.a();
            c10.a(n11, (e)object);
        }
        if ((n11 = (int)(this.j() ? 1 : 0)) != 0) {
            n11 = 10;
            n10 = this.e();
            c10.a(n11, n10);
        }
    }

    public boolean a() {
        return this.a;
    }

    public int b() {
        Object object;
        int n10;
        int n11 = this.a();
        int n12 = 0;
        if (n11 != 0) {
            n10 = this.c();
            n11 = com.xiaomi.push.c.b(1, n10);
            n12 = 0 + n11;
        }
        if ((n11 = this.b()) != 0) {
            object = this.a();
            n11 = com.xiaomi.push.c.a(2, (String)object);
            n12 += n11;
        }
        if ((n11 = (int)(this.c() ? 1 : 0)) != 0) {
            object = this.b();
            n11 = com.xiaomi.push.c.a(3, (String)object);
            n12 += n11;
        }
        if ((n11 = (int)(this.d() ? 1 : 0)) != 0) {
            object = this.c();
            n11 = com.xiaomi.push.c.a(4, (String)object);
            n12 += n11;
        }
        if ((n11 = (int)(this.e() ? 1 : 0)) != 0) {
            n10 = this.d();
            n11 = com.xiaomi.push.c.a(5, n10);
            n12 += n11;
        }
        if ((n11 = (int)(this.f() ? 1 : 0)) != 0) {
            object = this.d();
            n11 = com.xiaomi.push.c.a(6, (String)object);
            n12 += n11;
        }
        if ((n11 = (int)(this.g() ? 1 : 0)) != 0) {
            object = this.e();
            n11 = com.xiaomi.push.c.a(7, (String)object);
            n12 += n11;
        }
        if ((n11 = (int)(this.h() ? 1 : 0)) != 0) {
            object = this.f();
            n11 = com.xiaomi.push.c.a(8, (String)object);
            n12 += n11;
        }
        if ((n11 = (int)(this.i() ? 1 : 0)) != 0) {
            object = this.a();
            n11 = com.xiaomi.push.c.a(9, (e)object);
            n12 += n11;
        }
        if ((n11 = (int)(this.j() ? 1 : 0)) != 0) {
            n10 = this.e();
            n11 = com.xiaomi.push.c.a(10, n10);
            n12 += n11;
        }
        this.d = n12;
        return n12;
    }

    public ek$e b(int n10) {
        this.e = true;
        this.b = n10;
        return this;
    }

    public ek$e b(String string2) {
        this.c = true;
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

    public ek$e c(int n10) {
        this.j = true;
        this.c = n10;
        return this;
    }

    public ek$e c(String string2) {
        this.d = true;
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

    public ek$e d(String string2) {
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

    public ek$e e(String string2) {
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

    public ek$e f(String string2) {
        this.h = true;
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
}

