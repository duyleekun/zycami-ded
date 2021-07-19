/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.m1.e;

import com.zhiyun.cama.prime.web.PrimeWebFragment;
import d.v.c.m1.e.x;
import java.util.List;
import java.util.function.Function;

public final class t
implements Function {
    public final /* synthetic */ List a;

    public /* synthetic */ t(List list) {
        this.a = list;
    }

    public final Object apply(Object object) {
        List list = this.a;
        object = (x)object;
        return PrimeWebFragment.f0(list, (x)object);
    }
}

