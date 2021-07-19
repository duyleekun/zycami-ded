/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.polidea.rxandroidble2.exceptions.BleDisconnectedException;
import d.v.e0.l;
import d.v.e0.m;
import d.v.e0.n;
import d.v.e0.nc;
import d.v.e0.pd;
import e.a.e0;
import e.a.v0.g;
import e.a.v0.o;
import e.a.v0.r;
import e.a.z;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class pd$b
implements Callable {
    public final /* synthetic */ int a;
    public final /* synthetic */ pd b;

    public pd$b(pd pd2, int n10) {
        this.b = pd2;
        this.a = n10;
    }

    private /* synthetic */ e0 b(Long object) {
        object = pd.c(this.b);
        nc nc2 = nc.a;
        return ((z)object).K2(nc2);
    }

    private /* synthetic */ boolean d(Integer n10) {
        int n11;
        pd pd2 = this.b;
        int n12 = pd2.j();
        if (n12 != (n11 = n10.intValue())) {
            n11 = 1;
        } else {
            n11 = 0;
            n10 = null;
        }
        return n11;
    }

    private /* synthetic */ void f(Integer n10) {
        pd pd2 = this.b;
        int n11 = n10;
        pd2.E(n11);
    }

    public e0 a() {
        Object object = this.b;
        boolean bl2 = ((pd)object).k();
        if (bl2) {
            long l10 = this.a;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            object = z.n3(l10, timeUnit);
            Object object2 = new m(this);
            object = ((z)object).s2((o)object2);
            object2 = new n(this);
            object = ((z)object).o2((r)object2);
            object2 = new l(this);
            return ((z)object).f2((g)object2);
        }
        return z.m2(BleDisconnectedException.adapterDisabled(pd.b(this.b).e()));
    }

    public /* synthetic */ e0 c(Long l10) {
        return this.b(l10);
    }

    public /* synthetic */ boolean e(Integer n10) {
        return this.d(n10);
    }

    public /* synthetic */ void g(Integer n10) {
        this.f(n10);
    }
}

