/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push.service;

import com.xiaomi.push.service.g$b;
import com.xiaomi.push.service.g$d;
import com.xiaomi.push.service.h;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class g$c$a {
    private int a;
    private g$d[] a;
    private int b;
    private int c;

    private g$c$a() {
        int n10;
        this.a = n10 = 256;
        g$d[] g$dArray = new g$d[n10];
        this.a = g$dArray;
        this.b = 0;
        this.c = 0;
    }

    public /* synthetic */ g$c$a(h h10) {
        this();
    }

    public static /* synthetic */ int a(g$c$a g$c$a, g$d g$d) {
        return g$c$a.a(g$d);
    }

    private int a(g$d g$d) {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = ((g$d[])(object = this.a)).length); ++i10) {
            if ((object = object[i10]) != g$d) continue;
            return i10;
        }
        return -1;
    }

    private void c() {
        int n10 = this.b + -1;
        int n11 = (n10 + -1) / 2;
        while (true) {
            g$d g$d;
            g$d[] g$dArray = this.a;
            g$d g$d2 = g$dArray[n10];
            long l10 = g$d2.a;
            g$d g$d3 = g$dArray[n11];
            long l11 = g$d3.a;
            long l12 = l10 - l11;
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object >= 0) break;
            g$d2 = g$dArray[n10];
            g$dArray[n10] = g$d = g$dArray[n11];
            g$dArray[n11] = g$d2;
            n10 = (n11 + -1) / 2;
            int n12 = n11;
            n11 = n10;
            n10 = n12;
        }
    }

    private void c(int n10) {
        int n11;
        int n12 = n10 * 2 + 1;
        while (n12 < (n11 = this.b) && n11 > 0) {
            g$d g$d;
            Object object;
            int n13 = n12 + 1;
            if (n13 < n11) {
                object = this.a;
                g$d = object[n13];
                long l10 = g$d.a;
                object = object[n12];
                long l11 = object.a;
                long l12 = l10 - l11;
                n11 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
                if (n11 < 0) {
                    n12 = n13;
                }
            }
            object = this.a;
            g$d g$d2 = object[n10];
            long l13 = g$d2.a;
            g$d g$d3 = object[n12];
            long l14 = g$d3.a;
            long l15 = l13 - l14;
            n13 = (int)(l15 == 0L ? 0 : (l15 < 0L ? -1 : 1));
            if (n13 < 0) break;
            g$d2 = object[n10];
            object[n10] = g$d = object[n12];
            object[n12] = g$d2;
            n10 = n12 * 2 + 1;
            int n14 = n12;
            n12 = n10;
            n10 = n14;
        }
    }

    public g$d a() {
        return this.a[0];
    }

    public void a() {
        g$d[] g$dArray = new g$d[this.a];
        this.a = g$dArray;
        this.b = 0;
    }

    public void a(int n10) {
        int n11;
        for (int i10 = 0; i10 < (n11 = this.b); ++i10) {
            Object object = this.a;
            g$d g$d = object[i10];
            int n12 = g$d.a;
            if (n12 != n10) continue;
            object = object[i10];
            ((g$d)object).a();
        }
        this.b();
    }

    public void a(int n10, g$b g$b) {
        int n11;
        for (n10 = 0; n10 < (n11 = this.b); ++n10) {
            Object object = this.a;
            g$b g$b2 = object[n10].a;
            if (g$b2 != g$b) continue;
            object = object[n10];
            ((g$d)object).a();
        }
        this.b();
    }

    public void a(g$d g$d) {
        g$d[] g$dArray = this.a;
        int n10 = g$dArray.length;
        int n11 = this.b;
        if (n10 == n11) {
            n10 = n11 * 2;
            g$d[] g$dArray2 = new g$d[n10];
            System.arraycopy(g$dArray, 0, g$dArray2, 0, n11);
            this.a = g$dArray2;
        }
        g$dArray = this.a;
        n10 = this.b;
        this.b = n11 = n10 + 1;
        g$dArray[n10] = g$d;
        this.c();
    }

    public boolean a() {
        int n10 = this.b;
        n10 = n10 == 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean a(int n10) {
        int n11;
        for (int i10 = 0; i10 < (n11 = this.b); ++i10) {
            g$d g$d = this.a[i10];
            n11 = g$d.a;
            if (n11 != n10) continue;
            return true;
        }
        return false;
    }

    public void b() {
        int n10;
        for (int i10 = 0; i10 < (n10 = this.b); ++i10) {
            g$d g$d = this.a[i10];
            n10 = (int)(g$d.a ? 1 : 0);
            if (n10 == 0) continue;
            this.c = n10 = this.c + 1;
            this.b(i10);
            i10 += -1;
        }
    }

    public void b(int n10) {
        int n11;
        if (n10 >= 0 && n10 < (n11 = this.b)) {
            g$d g$d;
            g$d[] g$dArray = this.a;
            this.b = n11 += -1;
            g$dArray[n10] = g$d = g$dArray[n11];
            g$d = null;
            g$dArray[n11] = null;
            this.c(n10);
        }
    }
}

