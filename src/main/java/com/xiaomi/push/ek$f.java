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
public final class ek$f
extends e {
    private int a;
    private ek$b a;
    private String a;
    private boolean a;
    private String b;
    private boolean b;
    private boolean c;

    public ek$f() {
        String string2;
        this.a = string2 = "";
        this.b = string2;
        this.a = null;
        this.a = -1;
    }

    public static ek$f a(byte[] byArray) {
        ek$f ek$f = new ek$f();
        return (ek$f)ek$f.a(byArray);
    }

    public int a() {
        int n10 = this.a;
        if (n10 < 0) {
            this.b();
        }
        return this.a;
    }

    public ek$b a() {
        return this.a;
    }

    public ek$f a(b b10) {
        int n10;
        while ((n10 = b10.a()) != 0) {
            Object object;
            int n11 = 10;
            if (n10 != n11) {
                n11 = 18;
                if (n10 != n11) {
                    n11 = 26;
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
                this.b((String)object);
                continue;
            }
            object = b10.a();
            this.a((String)object);
        }
        return this;
    }

    public ek$f a(ek$b ek$b) {
        Objects.requireNonNull(ek$b);
        this.c = true;
        this.a = ek$b;
        return this;
    }

    public ek$f a(String string2) {
        this.a = true;
        this.a = string2;
        return this;
    }

    public String a() {
        return this.a;
    }

    public void a(c c10) {
        Object object;
        int n10 = this.a();
        if (n10 != 0) {
            n10 = 1;
            object = this.a();
            c10.a(n10, (String)object);
        }
        if ((n10 = this.b()) != 0) {
            n10 = 2;
            object = this.b();
            c10.a(n10, (String)object);
        }
        if ((n10 = (int)(this.c() ? 1 : 0)) != 0) {
            n10 = 3;
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
            n10 = com.xiaomi.push.c.a(1, (String)object);
            n11 = 0 + n10;
        }
        if ((n10 = this.b()) != 0) {
            object = this.b();
            n10 = com.xiaomi.push.c.a(2, (String)object);
            n11 += n10;
        }
        if ((n10 = (int)(this.c() ? 1 : 0)) != 0) {
            object = this.a();
            n10 = com.xiaomi.push.c.a(3, (e)object);
            n11 += n10;
        }
        this.a = n11;
        return n11;
    }

    public ek$f b(String string2) {
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

    public boolean c() {
        return this.c;
    }
}

