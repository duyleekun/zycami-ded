/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.l1;

import com.zhiyun.cama.data.api.entity.OrderBean;
import d.v.c.l1.d0;
import e.a.v0.o;
import java.util.concurrent.atomic.AtomicBoolean;

public final class v
implements o {
    public final /* synthetic */ d0 a;
    public final /* synthetic */ AtomicBoolean b;

    public /* synthetic */ v(d0 d02, AtomicBoolean atomicBoolean) {
        this.a = d02;
        this.b = atomicBoolean;
    }

    public final Object apply(Object object) {
        d0 d02 = this.a;
        AtomicBoolean atomicBoolean = this.b;
        object = (OrderBean)object;
        return d02.J(atomicBoolean, (OrderBean)object);
    }
}

