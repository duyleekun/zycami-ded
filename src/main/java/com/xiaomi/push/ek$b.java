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
public final class ek$b
extends e {
    private int a;
    private boolean a = 0;
    private int b;
    private boolean b = 0;
    private int c;
    private boolean c = 0;
    private int d;
    private boolean d = -1;
    private boolean e;

    public static ek$b a(byte[] byArray) {
        ek$b ek$b = new ek$b();
        return (ek$b)ek$b.a(byArray);
    }

    public int a() {
        int n10 = this.d;
        if (n10 < 0) {
            this.b();
        }
        return this.d;
    }

    public ek$b a(int n10) {
        this.c = true;
        this.a = n10;
        return this;
    }

    public ek$b a(b b10) {
        int n10;
        while ((n10 = b10.a()) != 0) {
            int n11 = 8;
            if (n10 != n11) {
                n11 = 24;
                if (n10 != n11) {
                    n11 = 32;
                    if (n10 != n11) {
                        n11 = 40;
                        if (n10 != n11) {
                            if ((n10 = (int)(this.a(b10, n10) ? 1 : 0)) != 0) continue;
                            return this;
                        }
                        n10 = b10.b();
                        this.c(n10);
                        continue;
                    }
                    n10 = b10.b();
                    this.b(n10);
                    continue;
                }
                n10 = b10.b();
                this.a(n10);
                continue;
            }
            n10 = (int)(b10.a() ? 1 : 0);
            this.a(n10 != 0);
        }
        return this;
    }

    public ek$b a(boolean bl2) {
        this.a = true;
        this.b = bl2;
        return this;
    }

    public void a(c c10) {
        int n10;
        int n11 = this.b();
        if (n11 != 0) {
            n11 = 1;
            n10 = this.a();
            c10.a(n11, n10 != 0);
        }
        if ((n11 = this.c()) != 0) {
            n11 = 3;
            n10 = this.c();
            c10.a(n11, n10);
        }
        if ((n11 = (int)(this.d() ? 1 : 0)) != 0) {
            n11 = 4;
            n10 = this.d();
            c10.a(n11, n10);
        }
        if ((n11 = (int)(this.e() ? 1 : 0)) != 0) {
            n11 = 5;
            n10 = this.e();
            c10.a(n11, n10);
        }
    }

    public boolean a() {
        return this.b;
    }

    public int b() {
        int n10;
        int n11 = this.b();
        int n12 = 0;
        if (n11 != 0) {
            n10 = this.a();
            n11 = com.xiaomi.push.c.a(1, n10 != 0);
            n12 = 0 + n11;
        }
        if ((n11 = this.c()) != 0) {
            n10 = this.c();
            n11 = com.xiaomi.push.c.a(3, n10);
            n12 += n11;
        }
        if ((n11 = (int)(this.d() ? 1 : 0)) != 0) {
            n10 = this.d();
            n11 = com.xiaomi.push.c.a(4, n10);
            n12 += n11;
        }
        if ((n11 = (int)(this.e() ? 1 : 0)) != 0) {
            n10 = this.e();
            n11 = com.xiaomi.push.c.a(5, n10);
            n12 += n11;
        }
        this.d = n12;
        return n12;
    }

    public ek$b b(int n10) {
        this.d = true;
        this.b = n10;
        return this;
    }

    public boolean b() {
        return this.a;
    }

    public int c() {
        return this.a;
    }

    public ek$b c(int n10) {
        this.e = true;
        this.c = n10;
        return this;
    }

    public boolean c() {
        return this.c;
    }

    public int d() {
        return this.b;
    }

    public boolean d() {
        return this.d;
    }

    public int e() {
        return this.c;
    }

    public boolean e() {
        return this.e;
    }
}

