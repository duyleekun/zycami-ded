/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.b;
import com.xiaomi.push.c;
import com.xiaomi.push.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class ej$a
extends e {
    private int a;
    private List a;
    private boolean a = 0;
    private int b;
    private boolean b = 0;
    private int c;
    private boolean c = false;
    private boolean d;
    private boolean e;
    private boolean f = false;

    public ej$a() {
        List list;
        this.a = list = Collections.emptyList();
        this.c = -1;
    }

    public static ej$a a(byte[] byArray) {
        ej$a ej$a = new ej$a();
        return (ej$a)ej$a.a(byArray);
    }

    public static ej$a b(b b10) {
        ej$a ej$a = new ej$a();
        return ej$a.a(b10);
    }

    public int a() {
        int n10 = this.c;
        if (n10 < 0) {
            this.b();
        }
        return this.c;
    }

    public ej$a a(int n10) {
        this.a = true;
        this.a = n10;
        return this;
    }

    public ej$a a(b b10) {
        int n10;
        while ((n10 = b10.a()) != 0) {
            int n11 = 8;
            if (n10 != n11) {
                n11 = 16;
                if (n10 != n11) {
                    n11 = 24;
                    if (n10 != n11) {
                        n11 = 32;
                        if (n10 != n11) {
                            n11 = 42;
                            if (n10 != n11) {
                                if ((n10 = (int)(this.a(b10, n10) ? 1 : 0)) != 0) continue;
                                return this;
                            }
                            String string2 = b10.a();
                            this.a(string2);
                            continue;
                        }
                        n10 = (int)(b10.a() ? 1 : 0);
                        this.b(n10 != 0);
                        continue;
                    }
                    n10 = b10.b();
                    this.b(n10);
                    continue;
                }
                n10 = (int)(b10.a() ? 1 : 0);
                this.a(n10 != 0);
                continue;
            }
            n10 = b10.c();
            this.a(n10);
        }
        return this;
    }

    public ej$a a(String string2) {
        Objects.requireNonNull(string2);
        ArrayList arrayList = this.a;
        boolean bl2 = arrayList.isEmpty();
        if (bl2) {
            this.a = arrayList = new ArrayList();
        }
        this.a.add(string2);
        return this;
    }

    public ej$a a(boolean bl2) {
        this.b = true;
        this.c = bl2;
        return this;
    }

    public List a() {
        return this.a;
    }

    public void a(c c10) {
        boolean bl2;
        int n10 = this.a();
        if (n10 != 0) {
            n10 = 1;
            int bl22 = this.c();
            c10.b(n10, bl22);
        }
        if ((n10 = this.c()) != 0) {
            n10 = 2;
            boolean bl3 = this.b();
            c10.a(n10, bl3);
        }
        if ((n10 = (int)(this.d() ? 1 : 0)) != 0) {
            n10 = 3;
            int n11 = this.d();
            c10.a(n10, n11);
        }
        if ((n10 = (int)(this.f() ? 1 : 0)) != 0) {
            n10 = 4;
            boolean bl4 = this.e();
            c10.a(n10, bl4);
        }
        Iterator iterator2 = this.a().iterator();
        while (bl2 = iterator2.hasNext()) {
            String string2 = (String)iterator2.next();
            int n12 = 5;
            c10.a(n12, string2);
        }
    }

    public boolean a() {
        return this.a;
    }

    public int b() {
        int n10;
        int n11 = this.a();
        int n12 = 1;
        int n13 = 0;
        if (n11 != 0) {
            n11 = this.c();
            n11 = com.xiaomi.push.c.b(n12, n11) + 0;
        } else {
            n11 = 0;
        }
        int n14 = this.c();
        if (n14 != 0) {
            n10 = this.b();
            n14 = com.xiaomi.push.c.a(2, n10 != 0);
            n11 += n14;
        }
        if ((n14 = this.d()) != 0) {
            n10 = this.d();
            n14 = com.xiaomi.push.c.a(3, n10);
            n11 += n14;
        }
        if ((n14 = (int)(this.f() ? 1 : 0)) != 0) {
            n10 = (int)(this.e() ? 1 : 0);
            n14 = com.xiaomi.push.c.a(4, n10 != 0);
            n11 += n14;
        }
        Iterator iterator2 = this.a().iterator();
        while ((n10 = iterator2.hasNext()) != 0) {
            String string2 = (String)iterator2.next();
            n10 = com.xiaomi.push.c.a(string2);
            n13 += n10;
        }
        n11 += n13;
        n13 = this.a().size() * n12;
        this.c = n11 += n13;
        return n11;
    }

    public ej$a b(int n10) {
        this.d = true;
        this.b = n10;
        return this;
    }

    public ej$a b(boolean bl2) {
        this.e = true;
        this.f = bl2;
        return this;
    }

    public boolean b() {
        return this.c;
    }

    public int c() {
        return this.a;
    }

    public boolean c() {
        return this.b;
    }

    public int d() {
        return this.b;
    }

    public boolean d() {
        return this.d;
    }

    public int e() {
        return this.a.size();
    }

    public boolean e() {
        return this.f;
    }

    public boolean f() {
        return this.e;
    }
}

