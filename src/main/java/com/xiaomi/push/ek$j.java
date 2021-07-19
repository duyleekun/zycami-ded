/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.a;
import com.xiaomi.push.b;
import com.xiaomi.push.c;
import com.xiaomi.push.e;
import com.xiaomi.push.ek$b;
import java.util.Objects;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class ek$j
extends e {
    private int a;
    private a a;
    private ek$b a;
    private boolean a;
    private boolean b;

    public ek$j() {
        a a10;
        this.a = a10 = com.xiaomi.push.a.a;
        this.a = null;
        this.a = -1;
    }

    public static ek$j a(byte[] byArray) {
        ek$j ek$j = new ek$j();
        return (ek$j)ek$j.a(byArray);
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

    public ek$b a() {
        return this.a;
    }

    public ek$j a(a a10) {
        this.a = true;
        this.a = a10;
        return this;
    }

    public ek$j a(b b10) {
        int n10;
        while ((n10 = b10.a()) != 0) {
            Object object;
            int n11 = 10;
            if (n10 != n11) {
                n11 = 18;
                if (n10 != n11) {
                    if ((n10 = (int)(this.a(b10, n10) ? 1 : 0)) != 0) continue;
                    return this;
                }
                object = new ek$b();
                b10.a((e)object);
                this.a((ek$b)object);
                continue;
            }
            object = b10.a();
            this.a((a)object);
        }
        return this;
    }

    public ek$j a(ek$b ek$b) {
        Objects.requireNonNull(ek$b);
        this.b = true;
        this.a = ek$b;
        return this;
    }

    public void a(c c10) {
        Object object;
        int n10 = this.a();
        if (n10 != 0) {
            n10 = 1;
            object = this.a();
            c10.a(n10, (a)object);
        }
        if ((n10 = this.b()) != 0) {
            n10 = 2;
            object = this.a();
            c10.a(n10, (e)object);
        }
    }

    public boolean a() {
        return this.a;
    }

    public int b() {
        Object object;
        int n10 = this.a();
        int n11 = 0;
        if (n10 != 0) {
            object = this.a();
            n10 = c.a(1, (a)object);
            n11 = 0 + n10;
        }
        if ((n10 = this.b()) != 0) {
            object = this.a();
            n10 = c.a(2, (e)object);
            n11 += n10;
        }
        this.a = n11;
        return n11;
    }

    public boolean b() {
        return this.b;
    }
}

