/*
 * Decompiled with CFR 0.151.
 */
package d.v.w;

import com.zhiyun.pay.PayClientLifecycle;
import e.a.k0;
import e.a.m0;

public final class r
implements m0 {
    public final /* synthetic */ PayClientLifecycle a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ boolean d;

    public /* synthetic */ r(PayClientLifecycle payClientLifecycle, String string2, String string3, boolean bl2) {
        this.a = payClientLifecycle;
        this.b = string2;
        this.c = string3;
        this.d = bl2;
    }

    public final void subscribe(k0 k02) {
        PayClientLifecycle payClientLifecycle = this.a;
        String string2 = this.b;
        String string3 = this.c;
        boolean bl2 = this.d;
        payClientLifecycle.J0(string2, string3, bl2, k02);
    }
}

