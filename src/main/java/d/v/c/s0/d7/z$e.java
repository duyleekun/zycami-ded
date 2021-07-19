/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.d7;

import androidx.lifecycle.MutableLiveData;
import d.v.c.s0.d7.z;
import d.v.d.i.g.c;
import d.v.e.h.a;
import java.util.TimerTask;

public class z$e
extends TimerTask {
    public final /* synthetic */ z a;

    public z$e(z z10) {
        this.a = z10;
    }

    public void run() {
        long l10;
        long l11;
        long l12;
        Object object = this.a;
        int n10 = z.o((z)object);
        object = z.r((z)object, n10);
        z.d(this.a).postValue(object);
        object = this.a;
        Object object2 = ((z)object).m;
        object = z.o((z)object);
        ((MutableLiveData)object2).postValue(object);
        z.p(this.a);
        object = (Boolean)z.e(this.a).getValue();
        int n11 = d.v.e.h.a.c((Boolean)object);
        if (n11 != 0 && (n11 = d.v.e.h.a.c((Boolean)(object = (Boolean)this.a.F.getValue()))) == 0) {
            object = this.a;
            ((z)object).B0();
        }
        if ((n11 = d.v.e.h.a.c((Boolean)(object = (Boolean)this.a.F.getValue()))) != 0) {
            object = this.a;
            ((z)object).e = n10 = ((z)object).e + 1;
        }
        if ((n11 = d.v.e.h.a.c((Boolean)(object = (Boolean)this.a.F.getValue()))) != 0 && (n11 = (l12 = (l11 = c.p()) - (l10 = (long)100)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) < 0) {
            object = z.f(this.a);
            object2 = Boolean.TRUE;
            ((MutableLiveData)object).postValue(object2);
            object = z.e(this.a);
            object2 = Boolean.FALSE;
            ((MutableLiveData)object).postValue(object2);
            object = this.a;
            ((z)object).t();
        }
    }
}

