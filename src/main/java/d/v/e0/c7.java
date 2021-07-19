/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.polidea.rxandroidble2.RxBleClient;
import d.n.a.r0.b;
import d.n.a.r0.e;
import d.v.e0.ce;
import e.a.v0.o;

public final class c7
implements o {
    public final /* synthetic */ e a;
    public final /* synthetic */ b b;

    public /* synthetic */ c7(e e10, b b10) {
        this.a = e10;
        this.b = b10;
    }

    public final Object apply(Object object) {
        e e10 = this.a;
        b b10 = this.b;
        object = (RxBleClient)object;
        return ce.x4(e10, b10, (RxBleClient)object);
    }
}

