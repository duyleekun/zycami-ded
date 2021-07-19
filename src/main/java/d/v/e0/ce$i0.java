/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import d.v.e0.ce;
import d.v.e0.ce$i0$a;
import e.a.v0.o;
import e.a.z;
import java.util.concurrent.TimeUnit;

public class ce$i0
implements o {
    public final /* synthetic */ ce a;

    public ce$i0(ce ce2) {
        this.a = ce2;
    }

    public z a(Long object) {
        object = ce.s(this.a).c0();
        Object object2 = TimeUnit.MILLISECONDS;
        object = ((z)object).E6(190L, (TimeUnit)((Object)object2));
        object2 = new ce$i0$a(this);
        return ((z)object).n4((o)object2);
    }
}

