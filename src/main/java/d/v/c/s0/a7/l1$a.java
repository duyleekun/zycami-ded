/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.a7;

import androidx.lifecycle.MutableLiveData;
import d.v.c.s0.a7.l1;
import d.v.e.h.c;
import d.v.e.l.m2$b;
import e.a.s0.b;

public class l1$a
implements m2$b {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ l1 c;

    public l1$a(l1 l12, boolean bl2, boolean bl3) {
        this.c = l12;
        this.a = bl2;
        this.b = bl3;
    }

    public void a(Long object) {
        Object object2 = this.a;
        if (object2 == 0) {
            double d10;
            object2 = this.b;
            object = object2 != 0 ? (Float)l1.w((l1)this.c).K.getValue() : (Float)l1.w((l1)this.c).J.getValue();
            float f10 = d.v.e.h.c.c((Float)object);
            double d11 = f10;
            double d12 = d11 - (d10 = 10.0);
            object2 = d12 == 0.0 ? 0 : (d12 < 0.0 ? -1 : 1);
            if (object2 < 0) {
                object = this.c;
                boolean bl2 = this.b;
                MutableLiveData mutableLiveData = bl2 ? l1.w((l1)object).K : l1.w((l1)object).J;
                boolean bl3 = false;
                l1.x((l1)object, mutableLiveData, false);
            } else {
                object = this.c;
                l1.y((l1)object);
            }
        } else {
            double d13;
            object2 = this.b;
            object = object2 != 0 ? (Float)l1.w((l1)this.c).K.getValue() : (Float)l1.w((l1)this.c).J.getValue();
            float f11 = d.v.e.h.c.c((Float)object);
            double d14 = f11;
            double d15 = d14 - (d13 = -10.0);
            object2 = d15 == 0.0 ? 0 : (d15 > 0.0 ? 1 : -1);
            if (object2 > 0) {
                object = this.c;
                boolean bl4 = this.b;
                MutableLiveData mutableLiveData = bl4 ? l1.w((l1)object).K : l1.w((l1)object).J;
                boolean bl5 = true;
                l1.x((l1)object, mutableLiveData, bl5);
            } else {
                object = this.c;
                l1.y((l1)object);
            }
        }
    }

    public void onComplete() {
    }

    public void onError(Throwable throwable) {
    }

    public void onSubscribe(b b10) {
    }
}

