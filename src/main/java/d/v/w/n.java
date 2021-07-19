/*
 * Decompiled with CFR 0.151.
 */
package d.v.w;

import com.zhiyun.pay.PayClientLifecycle;
import d.b.a.b.h;
import d.b.a.b.j;
import e.a.k0;

public final class n
implements j {
    public final /* synthetic */ k0 a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ String c;

    public /* synthetic */ n(k0 k02, boolean bl2, String string2) {
        this.a = k02;
        this.b = bl2;
        this.c = string2;
    }

    public final void h(h h10, String string2) {
        k0 k02 = this.a;
        boolean bl2 = this.b;
        String string3 = this.c;
        PayClientLifecycle.z0(k02, bl2, string3, h10, string2);
    }
}

