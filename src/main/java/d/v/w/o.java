/*
 * Decompiled with CFR 0.151.
 */
package d.v.w;

import com.android.billingclient.api.Purchase;
import com.zhiyun.pay.PayClientLifecycle;
import java.util.function.Predicate;

public final class o
implements Predicate {
    public final /* synthetic */ String a;

    public /* synthetic */ o(String string2) {
        this.a = string2;
    }

    public final boolean test(Object object) {
        String string2 = this.a;
        object = (Purchase)object;
        return PayClientLifecycle.v0(string2, (Purchase)object);
    }
}

