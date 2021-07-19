/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.indoor;

import com.baidu.location.f.i;
import com.baidu.location.indoor.g;
import com.baidu.location.indoor.g$e;
import com.baidu.location.indoor.n;

public class g$g
extends Thread {
    public final /* synthetic */ g a;
    private volatile boolean b = true;
    private long c;
    private long d;
    private long e;

    public g$g(g g10) {
        long l10;
        this.a = g10;
        this.c = l10 = 0L;
        this.d = l10;
        this.e = l10;
    }

    public static /* synthetic */ boolean a(g$g g$g, boolean bl2) {
        g$g.b = bl2;
        return bl2;
    }

    public void run() {
        int n10;
        while ((n10 = this.b) != 0) {
            long l10;
            long l11;
            Object object;
            long l12;
            int n11;
            Object object2;
            block20: {
                float f10;
                float f11;
                block19: {
                    long l13;
                    object2 = this.a;
                    n10 = g.n((g)object2);
                    long l14 = 5000L;
                    n11 = 1;
                    f11 = Float.MIN_VALUE;
                    if (n10 == n11 && (n10 = (int)(g.o((g)(object2 = this.a)) ? 1 : 0)) == 0) {
                        object2 = this.a;
                        g.a((g)object2, l14);
                    } else {
                        object2 = this.a;
                        l13 = 3000L;
                        g.a((g)object2, l13);
                    }
                    object2 = g.f(this.a);
                    n10 = ((n)object2).c();
                    if (n10 == n11) {
                        this.d = l13 = System.currentTimeMillis();
                    }
                    l13 = System.currentTimeMillis();
                    long l15 = this.c;
                    long l16 = (l13 -= l15) - (l15 = 17500L);
                    n10 = (int)(l16 == 0L ? 0 : (l16 < 0L ? -1 : 1));
                    if (n10 > 0) {
                        n10 = n11;
                        f10 = f11;
                    } else {
                        n10 = 0;
                        object2 = null;
                        f10 = 0.0f;
                    }
                    l12 = System.currentTimeMillis();
                    long l17 = this.d;
                    long l18 = (l12 -= l17) - l14;
                    Object object3 = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
                    if (object3 >= 0) break block19;
                    l14 = System.currentTimeMillis();
                    l12 = this.c;
                    long l19 = (l14 -= l12) - (l12 = 10000L);
                    object3 = l19 == 0L ? 0 : (l19 < 0L ? -1 : 1);
                    if (object3 > 0) {
                        n10 = n11;
                        f10 = f11;
                    }
                    l14 = System.currentTimeMillis();
                    l12 = this.c;
                    object = this.a;
                    long l20 = (l14 -= l12) - (l12 = g.p((g)object));
                    object3 = l20 == 0L ? 0 : (l20 < 0L ? -1 : 1);
                    if (object3 > 0) break block20;
                }
                n11 = n10;
                f11 = f10;
            }
            if (n11 != 0) {
                i.a().i();
                g.f(this.a).f();
                this.c = l11 = System.currentTimeMillis();
                object2 = this.a;
                g.c((g)object2, false);
            }
            if ((n10 = (int)(((i)(object2 = i.a())).r() ? 1 : 0)) != 0) {
                this.e = l11 = 0L;
            } else {
                this.e = l11 = this.e + 1L;
                l10 = 10;
                long l21 = l11 - l10;
                n10 = (int)(l21 == 0L ? 0 : (l21 < 0L ? -1 : 1));
                if (n10 >= 0) {
                    this.b = false;
                    this.a.d();
                    return;
                }
            }
            object2 = this.a;
            n10 = (int)(g.c((g)object2) ? 1 : 0);
            if (n10 != 0 && (object2 = g.a(this.a)) != null) {
                l11 = System.currentTimeMillis();
                g g10 = this.a;
                l10 = g.q(g10);
                long l22 = (l11 -= l10) - (l10 = 30000L);
                n10 = (int)(l22 == 0L ? 0 : (l22 < 0L ? -1 : 1));
                if (n10 > 0) {
                    l11 = System.currentTimeMillis();
                    object = g.a(this.a);
                    l12 = g$e.g((g$e)object);
                    long l23 = (l11 -= l12) - l10;
                    n10 = (int)(l23 == 0L ? 0 : (l23 < 0L ? -1 : 1));
                    if (n10 > 0) {
                        object2 = g.a();
                        ((g)object2).d();
                    }
                }
            }
            l11 = 2000L;
            try {
                Thread.sleep(l11);
            }
            catch (InterruptedException interruptedException) {
                this.b = false;
                break;
            }
        }
    }
}

