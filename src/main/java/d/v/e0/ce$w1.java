/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.stabilizer.Stabilizer$k;
import d.v.e0.ce;
import d.v.e0.ce$w1$a;
import d.v.e0.ie.d;
import d.v.e0.l7;
import e.a.b0;
import e.a.c0;
import e.a.s0.b;
import e.a.s0.c;
import e.a.v0.a;

public class ce$w1
implements c0 {
    public final /* synthetic */ d a;
    public final /* synthetic */ ce b;

    public ce$w1(ce ce2, d d10) {
        this.b = ce2;
        this.a = d10;
    }

    private /* synthetic */ void a(Stabilizer$k stabilizer$k) {
        this.b.l5(stabilizer$k);
    }

    public /* synthetic */ void b(Stabilizer$k stabilizer$k) {
        this.a(stabilizer$k);
    }

    public void subscribe(b0 b02) {
        ce$w1$a ce$w1$a = new ce$w1$a(this, b02);
        Object object = new l7(this, ce$w1$a);
        object = c.c((a)object);
        b02.setDisposable((b)object);
        this.b.v(ce$w1$a);
    }
}

