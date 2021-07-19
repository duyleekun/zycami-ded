/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.t1.t;

import androidx.lifecycle.MutableLiveData;
import d.v.c.t1.t.a;
import d.v.c.t1.t.b;
import d.v.c.t1.t.c;
import d.v.c.t1.t.d;
import e.a.h0;
import e.a.j;
import e.a.v0.g;
import e.a.v0.o;
import java.util.concurrent.TimeUnit;

public class e {
    private static volatile e e;
    public final MutableLiveData a;
    public final MutableLiveData b;
    private e.a.s0.b c;
    private int d;

    private e() {
        MutableLiveData mutableLiveData;
        this.a = mutableLiveData = new MutableLiveData();
        this.b = mutableLiveData = new MutableLiveData();
    }

    private void a() {
        MutableLiveData mutableLiveData = this.b;
        Boolean bl2 = Boolean.TRUE;
        mutableLiveData.setValue(bl2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static e b() {
        Object object = e;
        if (object != null) return e;
        object = e.class;
        synchronized (object) {
            e e10 = e;
            if (e10 != null) return e;
            e = e10 = new e();
            return e;
        }
    }

    private boolean c() {
        boolean bl2;
        e.a.s0.b b10 = this.c;
        if (b10 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            b10 = null;
        }
        return bl2;
    }

    public static /* synthetic */ void d(e e10) {
        e10.a();
    }

    public static /* synthetic */ void e(e e10, Integer n10) {
        e10.j(n10);
    }

    public static /* synthetic */ Integer f(int n10, Long l10) {
        int n11 = l10.intValue();
        return n10 - n11;
    }

    public static /* synthetic */ void g(Throwable throwable) {
    }

    private void j(Integer n10) {
        this.a.setValue(n10);
    }

    public void h() {
        this.l();
        Integer n10 = (Integer)this.a.getValue();
        if (n10 != null) {
            int n11;
            this.d = n11 = n10.intValue();
        }
    }

    public void i() {
        int n10 = this.c();
        if (n10 == 0) {
            n10 = this.d;
            this.k(n10);
        }
    }

    public void k(int n10) {
        this.l();
        Object object = this.a;
        Object object2 = n10;
        ((MutableLiveData)object).setValue(object2);
        object = this.b;
        object2 = Boolean.FALSE;
        ((MutableLiveData)object).setValue(object2);
        long l10 = n10;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        object = j.y3(1L, l10, 1L, 1L, timeUnit);
        object2 = new a(n10);
        Object object3 = ((j)object).R3((o)object2);
        object = e.a.q0.c.a.c();
        object3 = ((j)object3).s4((h0)object);
        object = new c(this);
        object2 = d.v.c.t1.t.d.a;
        b b10 = new b(this);
        this.c = object3 = ((j)object3).f((g)object, (g)object2, b10);
    }

    public void l() {
        e.a.s0.b b10 = this.c;
        if (b10 != null) {
            b10.dispose();
            b10 = null;
            this.c = null;
        }
    }
}

