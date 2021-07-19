/*
 * Decompiled with CFR 0.151.
 */
package d.v.w;

import com.android.billingclient.api.Purchase;
import com.zhiyun.pay.PayClientLifecycle;
import java.util.function.Predicate;

public final class v
implements Predicate {
    public static final /* synthetic */ v a;

    static {
        v v10;
        a = v10 = new v();
    }

    public final boolean test(Object object) {
        return PayClientLifecycle.w0((Purchase)object);
    }
}

