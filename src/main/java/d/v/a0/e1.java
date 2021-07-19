/*
 * Decompiled with CFR 0.151.
 */
package d.v.a0;

import d.v.a0.b;
import d.v.a0.e1$a;
import d.v.z.l.e;
import e.a.h0;
import e.a.v0.g;
import e.a.z;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import m.a.a;

public class e1 {
    private final e.a.s0.a a;
    private final d.v.z.n.e b;
    private e c;
    private String d;
    private long e;
    private final AtomicBoolean f;
    private e1$a g;

    public e1() {
        Object object = new e.a.s0.a();
        this.a = object;
        this.b = object = new d.v.z.n.e();
        this.e = -1;
        this.f = object = new AtomicBoolean();
    }

    private /* synthetic */ void e(Long object) {
        boolean bl2 = this.d();
        if (bl2) {
            this.a.e();
            object = this.g;
            if (object != null) {
                String string2 = this.d;
                object.a(string2);
            }
        }
    }

    private void k() {
        Object object = TimeUnit.MILLISECONDS;
        object = z.l3(100, 1000L, (TimeUnit)((Object)object));
        Object object2 = new b(this);
        object = ((z)object).f2((g)object2);
        object2 = e.a.c1.b.d();
        object = ((z)object).L5((h0)object2).a();
        this.a.b((e.a.s0.b)object);
    }

    public void a() {
        Object object = new Object[]{};
        String string2 = "\u6e05\u6389\u5fc3\u8df3-----------------";
        m.a.a.b(string2, (Object[])object);
        this.a.e();
        this.b.clear();
        object = this.c;
        if (object != null) {
            ((e)object).clear();
        }
        this.f.compareAndSet(true, false);
    }

    public e b() {
        return this.c;
    }

    public d.v.z.n.e c() {
        return this.b;
    }

    public boolean d() {
        long l10;
        long l11;
        long l12;
        AtomicBoolean atomicBoolean = this.f;
        int n10 = atomicBoolean.get();
        if (n10 != 0 && (n10 = (l12 = (l11 = System.currentTimeMillis()) - (l10 = this.e)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) <= 0) {
            n10 = 0;
            atomicBoolean = null;
        } else {
            n10 = 1;
        }
        return n10 != 0;
    }

    public /* synthetic */ void f(Long l10) {
        this.e(l10);
    }

    public void g(String string2) {
        this.d = string2;
    }

    public void h(e e10) {
        this.c = e10;
    }

    public void i(e1$a e1$a) {
        this.g = e1$a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void j(long l10) {
        AtomicBoolean atomicBoolean = this.f;
        boolean bl2 = atomicBoolean.get();
        if (!bl2) {
            Object[] objectArray = new Object[]{};
            m.a.a.b("\u5f00\u59cb\u5fc3\u8df3------------------", objectArray);
            this.k();
            atomicBoolean = this.f;
            boolean bl3 = true;
            atomicBoolean.compareAndSet(false, bl3);
        }
        synchronized (this) {
            long l11 = 5000L;
            this.e = l10 += l11;
            return;
        }
    }
}

