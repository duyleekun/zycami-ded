/*
 * Decompiled with CFR 0.151.
 */
package d.v.w;

import com.zhiyun.pay.PayClientLifecycle;
import e.a.k0;
import e.a.m0;

public final class f
implements m0 {
    public final /* synthetic */ PayClientLifecycle a;
    public final /* synthetic */ String b;
    public final /* synthetic */ boolean c;

    public /* synthetic */ f(PayClientLifecycle payClientLifecycle, String string2, boolean bl2) {
        this.a = payClientLifecycle;
        this.b = string2;
        this.c = bl2;
    }

    public final void subscribe(k0 k02) {
        PayClientLifecycle payClientLifecycle = this.a;
        String string2 = this.b;
        boolean bl2 = this.c;
        payClientLifecycle.o0(string2, bl2, k02);
    }
}

