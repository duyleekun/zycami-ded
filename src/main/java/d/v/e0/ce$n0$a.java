/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.stabilizer.Stabilizer$k;
import d.v.e0.ce$n0;
import e.a.b0;

public class ce$n0$a
extends Stabilizer$k {
    public final /* synthetic */ b0 e;
    public final /* synthetic */ ce$n0 f;

    public ce$n0$a(ce$n0 ce$n0, b0 b02) {
        this.f = ce$n0;
        this.e = b02;
    }

    public void h(int n10) {
        Object object = this.e;
        int n11 = object.isDisposed();
        if (n11 == 0) {
            object = this.e;
            Integer n12 = n10;
            object.onNext(n12);
            object = this.f;
            n11 = ((ce$n0)object).a;
            if (n10 >= n11) {
                b0 b02 = this.e;
                b02.onComplete();
            }
        }
    }
}

