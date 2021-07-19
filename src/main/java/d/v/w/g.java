/*
 * Decompiled with CFR 0.151.
 */
package d.v.w;

import com.zhiyun.pay.PayClientLifecycle;
import d.b.a.b.h;
import d.b.a.b.p;
import e.a.k0;
import java.util.List;

public final class g
implements p {
    public final /* synthetic */ PayClientLifecycle a;
    public final /* synthetic */ String b;
    public final /* synthetic */ k0 c;

    public /* synthetic */ g(PayClientLifecycle payClientLifecycle, String string2, k0 k02) {
        this.a = payClientLifecycle;
        this.b = string2;
        this.c = k02;
    }

    public final void c(h h10, List list) {
        PayClientLifecycle payClientLifecycle = this.a;
        String string2 = this.b;
        k0 k02 = this.c;
        payClientLifecycle.y0(string2, k02, h10, list);
    }
}

