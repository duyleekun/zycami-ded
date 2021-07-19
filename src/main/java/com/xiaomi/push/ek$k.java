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
public final class ek$k
extends e {
    private int a;
    private long a;
    private String a;
    private boolean a;
    private int b;
    private long b;
    private String b;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;

    public ek$k() {
        long l10;
        String string2;
        this.a = string2 = "";
        this.b = string2;
        this.a = l10 = 0L;
        this.b = l10;
        this.f = false;
        this.a = 0;
        this.b = -1;
    }

    public static ek$k a(byte[] byArray) {
        ek$k ek$k = new ek$k();
        return (ek$k)ek$k.a(byArray);
    }

    public int a() {
        int n10 = this.b;
        if (n10 < 0) {
            this.b();
        }
        return this.b;
    }

    public long a() {
        return this.a;
    }

    public ek$k a(int n10) {
        this.g = true;
        this.a = n10;
        return this;
    }

    public ek$k a(long l10) {
        this.c = true;
        this.a = l10;
        return this;
    }

    public ek$k a(b b10) {
        int n10;
        while ((n10 = b10.a()) != 0) {
            String string2;
            int n11 = 10;
            if (n10 != n11) {
                n11 = 18;
                if (n10 != n11) {
                    long l10;
                    n11 = 24;
                    if (n10 != n11) {
                        n11 = 32;
                        if (n10 != n11) {
                            n11 = 40;
                            if (n10 != n11) {
                                n11 = 48;
                                if (n10 != n11) {
                                    if ((n10 = (int)(this.a(b10, n10) ? 1 : 0)) != 0) continue;
                                    return this;
                                }
                                n10 = b10.b();
                                this.a(n10);
                                continue;
                            }
                            n10 = (int)(b10.a() ? 1 : 0);
                            this.a(n10 != 0);
                            continue;
                        }
                        l10 = b10.a();
                        this.b(l10);
                        continue;
                    }
                    l10 = b10.a();
                    this.a(l10);
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

    public ek$k a(String string2) {
        this.a = true;
        this.a = string2;
        return this;
    }

    public ek$k a(boolean bl2) {
        this.e = true;
        this.f = bl2;
        return this;
    }

    public String a() {
        return this.a;
    }

    public void a(c c10) {
        int n10;
        long l10;
        String string2;
        int n11 = this.a();
        if (n11 != 0) {
            n11 = 1;
            string2 = this.a();
            c10.a(n11, string2);
        }
        if ((n11 = this.b()) != 0) {
            n11 = 2;
            string2 = this.b();
            c10.a(n11, string2);
        }
        if ((n11 = (int)(this.c() ? 1 : 0)) != 0) {
            n11 = 3;
            l10 = this.a();
            c10.a(n11, l10);
        }
        if ((n11 = (int)(this.d() ? 1 : 0)) != 0) {
            n11 = 4;
            l10 = this.b();
            c10.a(n11, l10);
        }
        if ((n11 = (int)(this.f() ? 1 : 0)) != 0) {
            n11 = 5;
            n10 = this.e();
            c10.a(n11, n10 != 0);
        }
        if ((n11 = (int)(this.g() ? 1 : 0)) != 0) {
            n11 = 6;
            n10 = this.c();
            c10.a(n11, n10);
        }
    }

    public boolean a() {
        return this.a;
    }

    public int b() {
        int n10;
        long l10;
        String string2;
        int n11 = this.a();
        int n12 = 0;
        if (n11 != 0) {
            string2 = this.a();
            n11 = com.xiaomi.push.c.a(1, string2);
            n12 = 0 + n11;
        }
        if ((n11 = this.b()) != 0) {
            string2 = this.b();
            n11 = com.xiaomi.push.c.a(2, string2);
            n12 += n11;
        }
        if ((n11 = (int)(this.c() ? 1 : 0)) != 0) {
            l10 = this.a();
            n11 = com.xiaomi.push.c.a(3, l10);
            n12 += n11;
        }
        if ((n11 = (int)(this.d() ? 1 : 0)) != 0) {
            l10 = this.b();
            n11 = com.xiaomi.push.c.a(4, l10);
            n12 += n11;
        }
        if ((n11 = (int)(this.f() ? 1 : 0)) != 0) {
            n10 = this.e();
            n11 = com.xiaomi.push.c.a(5, n10 != 0);
            n12 += n11;
        }
        if ((n11 = (int)(this.g() ? 1 : 0)) != 0) {
            n10 = this.c();
            n11 = com.xiaomi.push.c.a(6, n10);
            n12 += n11;
        }
        this.b = n12;
        return n12;
    }

    public long b() {
        return this.b;
    }

    public ek$k b(long l10) {
        this.d = true;
        this.b = l10;
        return this;
    }

    public ek$k b(String string2) {
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

    public int c() {
        return this.a;
    }

    public boolean c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }

    public boolean e() {
        return this.f;
    }

    public boolean f() {
        return this.e;
    }

    public boolean g() {
        return this.g;
    }
}

