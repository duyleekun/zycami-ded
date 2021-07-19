/*
 * Decompiled with CFR 0.151.
 */
package d.v.w;

import androidx.core.util.Pair;
import com.zhiyun.pay.PayClientLifecycle;
import e.a.v0.o;

public final class e
implements o {
    public final /* synthetic */ PayClientLifecycle a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ e(PayClientLifecycle payClientLifecycle, boolean bl2) {
        this.a = payClientLifecycle;
        this.b = bl2;
    }

    public final Object apply(Object object) {
        PayClientLifecycle payClientLifecycle = this.a;
        boolean bl2 = this.b;
        object = (Pair)object;
        return payClientLifecycle.s0(bl2, (Pair)object);
    }
}

