/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.a;
import com.xiaomi.push.b;
import com.xiaomi.push.c;
import com.xiaomi.push.e;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class ek$i
extends e {
    private int a;
    private a a;
    private boolean a;

    public ek$i() {
        a a10;
        this.a = a10 = com.xiaomi.push.a.a;
        this.a = -1;
    }

    public static ek$i a(byte[] byArray) {
        ek$i ek$i = new ek$i();
        return (ek$i)ek$i.a(byArray);
    }

    public int a() {
        int n10 = this.a;
        if (n10 < 0) {
            this.b();
        }
        return this.a;
    }

    public a a() {
        return this.a;
    }

    public ek$i a(a a10) {
        this.a = true;
        this.a = a10;
        return this;
    }

    public ek$i a(b b10) {
        int n10;
        while ((n10 = b10.a()) != 0) {
            int n11 = 10;
            if (n10 != n11) {
                if ((n10 = (int)(this.a(b10, n10) ? 1 : 0)) != 0) continue;
                return this;
            }
            a a10 = b10.a();
            this.a(a10);
        }
        return this;
    }

    public void a(c c10) {
        int n10 = (int)(this.a() ? 1 : 0);
        if (n10 != 0) {
            n10 = 1;
            a a10 = this.a();
            c10.a(n10, a10);
        }
    }

    public boolean a() {
        return this.a;
    }

    public int b() {
        int n10 = this.a();
        int n11 = 0;
        if (n10 != 0) {
            a a10 = this.a();
            n10 = c.a(1, a10);
            n11 = 0 + n10;
        }
        this.a = n11;
        return n11;
    }
}

