/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.stabilizer.Stabilizer$k;
import d.v.e0.ce;
import d.v.e0.ce$n0$a;
import d.v.e0.ce$n0$b;
import e.a.b0;
import e.a.c0;
import e.a.s0.b;
import e.a.s0.c;

public class ce$n0
implements c0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ ce b;

    public ce$n0(ce ce2, int n10) {
        this.b = ce2;
        this.a = n10;
    }

    public void subscribe(b0 b02) {
        Object object = new ce$n0$a(this, b02);
        this.b.v((Stabilizer$k)object);
        ce$n0$b ce$n0$b = new ce$n0$b(this, (Stabilizer$k)object);
        object = c.c(ce$n0$b);
        b02.setDisposable((b)object);
    }
}

