/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.b;

import com.baidu.location.BDLocation;
import com.baidu.location.b.b;
import com.baidu.location.b.q$a;
import com.baidu.location.b.q$b;
import com.baidu.location.f.a;
import com.baidu.location.f.f;
import com.baidu.location.f.h;
import com.baidu.location.f.i;

public class q {
    private h a = null;
    private a b = null;
    private long c = 0L;
    private long d = 1000L;
    private BDLocation e = null;
    private q$b f;

    public static /* synthetic */ BDLocation a(q q10) {
        return q10.e;
    }

    public static /* synthetic */ BDLocation a(q q10, BDLocation bDLocation) {
        q10.e = bDLocation;
        return bDLocation;
    }

    public static q a() {
        return q$a.a();
    }

    private boolean a(a a10) {
        a a11 = com.baidu.location.f.b.a().f();
        if (a11 == a10) {
            return false;
        }
        boolean bl2 = true;
        if (a11 != null && a10 != null) {
            return a10.a(a11) ^ bl2;
        }
        return bl2;
    }

    private boolean a(h h10) {
        h h11 = i.a().p();
        if (h10 == h11) {
            return false;
        }
        boolean bl2 = true;
        if (h11 != null && h10 != null) {
            return h10.c(h11) ^ bl2;
        }
        return bl2;
    }

    public void b() {
        Object object;
        Object object2;
        block9: {
            block8: {
                block7: {
                    boolean bl2;
                    boolean bl3;
                    boolean bl4;
                    object2 = this.f;
                    if (object2 == null) {
                        object2 = new q$b(this);
                        this.f = object2;
                    }
                    long l10 = System.currentTimeMillis();
                    long l11 = this.c;
                    long l12 = (l10 -= l11) - (l11 = this.d);
                    Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                    if (object3 < 0 && (object2 = this.e) != null) {
                        return;
                    }
                    this.c = l10 = System.currentTimeMillis();
                    object2 = this.a;
                    object3 = this.a((h)object2);
                    object = this.b;
                    boolean bl32 = this.a((a)object);
                    if (object3 == false && !bl32 && (object2 = this.e) != null) {
                        return;
                    }
                    this.b = object2 = com.baidu.location.f.b.a().f();
                    this.a = object2 = i.a().p();
                    int n10 = 1024;
                    object2 = new StringBuffer(n10);
                    object = this.b;
                    if (object != null && (bl4 = ((a)object).b())) {
                        object = this.b.i();
                        ((StringBuffer)object2).append((String)object);
                    }
                    if ((object = this.a) == null || (bl3 = ((h)object).a()) <= (bl2 = true)) break block7;
                    object = this.a;
                    int n11 = 15;
                    object = ((h)object).a(n11, bl2, false);
                    break block8;
                }
                object = i.a().m();
                if (object == null) break block9;
            }
            ((StringBuffer)object2).append((String)object);
        }
        ((StringBuffer)object2).append("&coor=gcj02");
        ((StringBuffer)object2).append("&usage=nlwim");
        object = com.baidu.location.f.f.a().m();
        ((StringBuffer)object2).append((String)object);
        object = com.baidu.location.h.b.a().a(false);
        ((StringBuffer)object2).append((String)object);
        object = com.baidu.location.b.b.a().d();
        ((StringBuffer)object2).append((String)object);
        object = this.f;
        object2 = ((StringBuffer)object2).toString();
        ((q$b)object).a((String)object2);
    }

    public BDLocation c() {
        return this.e;
    }
}

