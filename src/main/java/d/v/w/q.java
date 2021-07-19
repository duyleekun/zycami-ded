/*
 * Decompiled with CFR 0.151.
 */
package d.v.w;

import com.zhiyun.pay.PayClientLifecycle;
import d.v.w.c0.f;
import e.a.k0;
import e.a.m0;

public final class q
implements m0 {
    public final /* synthetic */ PayClientLifecycle a;
    public final /* synthetic */ f b;

    public /* synthetic */ q(PayClientLifecycle payClientLifecycle, f f10) {
        this.a = payClientLifecycle;
        this.b = f10;
    }

    public final void subscribe(k0 k02) {
        PayClientLifecycle payClientLifecycle = this.a;
        f f10 = this.b;
        payClientLifecycle.m0(f10, k02);
    }
}

