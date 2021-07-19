/*
 * Decompiled with CFR 0.151.
 */
package d.v.w;

import com.zhiyun.pay.PayClientLifecycle;
import e.a.k0;
import e.a.m0;

public final class h
implements m0 {
    public final /* synthetic */ PayClientLifecycle a;
    public final /* synthetic */ String b;

    public /* synthetic */ h(PayClientLifecycle payClientLifecycle, String string2) {
        this.a = payClientLifecycle;
        this.b = string2;
    }

    public final void subscribe(k0 k02) {
        PayClientLifecycle payClientLifecycle = this.a;
        String string2 = this.b;
        payClientLifecycle.T0(string2, k02);
    }
}

