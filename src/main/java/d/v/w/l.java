/*
 * Decompiled with CFR 0.151.
 */
package d.v.w;

import com.zhiyun.pay.PayClientLifecycle;
import e.a.v0.o;

public final class l
implements o {
    public final /* synthetic */ PayClientLifecycle a;

    public /* synthetic */ l(PayClientLifecycle payClientLifecycle) {
        this.a = payClientLifecycle;
    }

    public final Object apply(Object object) {
        PayClientLifecycle payClientLifecycle = this.a;
        object = (String)object;
        return payClientLifecycle.X0((String)object);
    }
}

