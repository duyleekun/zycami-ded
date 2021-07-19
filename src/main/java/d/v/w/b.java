/*
 * Decompiled with CFR 0.151.
 */
package d.v.w;

import com.zhiyun.pay.PayClientLifecycle;
import e.a.v0.o;

public final class b
implements o {
    public final /* synthetic */ PayClientLifecycle a;
    public final /* synthetic */ String b;
    public final /* synthetic */ boolean c;

    public /* synthetic */ b(PayClientLifecycle payClientLifecycle, String string2, boolean bl2) {
        this.a = payClientLifecycle;
        this.b = string2;
        this.c = bl2;
    }

    public final Object apply(Object object) {
        PayClientLifecycle payClientLifecycle = this.a;
        String string2 = this.b;
        boolean bl2 = this.c;
        object = (String)object;
        return payClientLifecycle.Z0(string2, bl2, (String)object);
    }
}

