/*
 * Decompiled with CFR 0.151.
 */
package d.v.w;

import com.zhiyun.pay.PayClientLifecycle;
import e.a.k0;
import e.a.m0;

public final class j
implements m0 {
    public final /* synthetic */ PayClientLifecycle a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ String c;

    public /* synthetic */ j(PayClientLifecycle payClientLifecycle, boolean bl2, String string2) {
        this.a = payClientLifecycle;
        this.b = bl2;
        this.c = string2;
    }

    public final void subscribe(k0 k02) {
        PayClientLifecycle payClientLifecycle = this.a;
        boolean bl2 = this.b;
        String string2 = this.c;
        payClientLifecycle.B0(bl2, string2, k02);
    }
}

