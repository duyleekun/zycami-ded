/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.m1.d;

import com.zhiyun.cama.prime.dialog.PrimeGetDialogViewModel$PRIME_STATUS;
import com.zhiyun.cama.prime.model.PrimeInfo;
import d.v.c.m1.c;
import d.v.c.m1.d.p;

public class p$a {
    public final /* synthetic */ p a;

    public p$a(p p10) {
        this.a = p10;
    }

    public void a() {
        boolean bl2;
        Object object = (PrimeInfo)p.u(this.a).l().getValue();
        if (object != null && (bl2 = ((c)(object = p.u(this.a))).p())) {
            object = this.a;
            p.v((p)object);
        }
        this.a.dismiss();
    }

    public void b() {
        PrimeGetDialogViewModel$PRIME_STATUS primeGetDialogViewModel$PRIME_STATUS;
        Object object = p.w(this.a).n();
        if (object == (primeGetDialogViewModel$PRIME_STATUS = PrimeGetDialogViewModel$PRIME_STATUS.PRIME_STATUS_SUCCESS)) {
            object = this.a;
            p.x((p)object);
        }
        this.a.dismiss();
    }

    public void c() {
        PrimeGetDialogViewModel$PRIME_STATUS primeGetDialogViewModel$PRIME_STATUS;
        Object object = p.w(this.a).n();
        if (object == (primeGetDialogViewModel$PRIME_STATUS = PrimeGetDialogViewModel$PRIME_STATUS.PRIME_STATUS_SUCCESS)) {
            this.a.dismiss();
            object = this.a;
            p.x((p)object);
        } else {
            object = this.a;
            p.y((p)object);
        }
    }
}

