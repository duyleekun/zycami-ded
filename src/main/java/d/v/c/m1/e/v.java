/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.m1.e;

import com.zhiyun.cama.prime.web.PrimeWebFragment;
import d.v.c.m1.e.x;
import d.v.w.c0.e;
import java.util.function.Predicate;

public final class v
implements Predicate {
    public final /* synthetic */ x a;

    public /* synthetic */ v(x x10) {
        this.a = x10;
    }

    public final boolean test(Object object) {
        x x10 = this.a;
        object = (e)object;
        return PrimeWebFragment.T(x10, (e)object);
    }
}

