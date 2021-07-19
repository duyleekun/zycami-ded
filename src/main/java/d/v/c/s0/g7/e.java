/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.g7;

import androidx.lifecycle.LiveData;
import d.v.c.s0.g7.a;
import d.v.c.s0.g7.b;
import d.v.c.s0.g7.c;
import e.a.h0;
import e.a.v0.g;
import e.a.v0.o;
import e.a.z;
import java.util.concurrent.TimeUnit;

public class e
extends LiveData {
    private e.a.s0.b a;

    private void b() {
        e.a.s0.b b10 = this.a;
        if (b10 != null) {
            b10.dispose();
            b10 = null;
            this.a = null;
        }
    }

    public static /* synthetic */ void d(e e10, Object object) {
        e10.setValue(object);
    }

    public static /* synthetic */ void e(e e10) {
        e10.i();
    }

    public static /* synthetic */ Integer f(int n10, Long l10) {
        long l11 = n10 + -1;
        long l12 = l10;
        return (int)(l11 - l12);
    }

    private void h(int n10) {
        synchronized (this) {
            Object object;
            if (n10 == 0) {
                n10 = 0;
                object = null;
            } else {
                ++n10;
            }
            long l10 = 0L;
            long l11 = 1L;
            TimeUnit timeUnit = TimeUnit.SECONDS;
            h0 h02 = e.a.c1.b.g();
            Object object2 = z.m3(l10, l11, timeUnit, h02);
            long l12 = n10;
            object2 = ((z)object2).b6(l12);
            Object object3 = e.a.q0.c.a.c();
            object2 = ((z)object2).i4((h0)object3);
            object3 = new c(this);
            object2 = ((z)object2).h2((e.a.v0.a)object3);
            object3 = new a(n10);
            object = ((z)object2).H3((o)object3);
            object2 = new b(this);
            object = ((z)object).d((g)object2);
            this.a = object;
            return;
        }
    }

    private void i() {
        Integer n10 = -2;
        this.setValue(n10);
        this.b();
    }

    public void a() {
        Integer n10 = -3;
        this.setValue(n10);
        this.b();
    }

    public boolean c() {
        boolean bl2;
        e.a.s0.b b10 = this.a;
        if (b10 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            b10 = null;
        }
        return bl2;
    }

    public void g(int n10) {
        boolean bl2 = this.c();
        if (bl2) {
            this.a();
            return;
        }
        Integer n11 = -1;
        this.setValue(n11);
        this.h(n10);
    }
}

