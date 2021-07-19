/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0.ne;

import com.polidea.rxandroidble2.RxBleConnection;
import d.v.e0.ne.k0;
import e.a.v0.o;

public final class d
implements o {
    public final /* synthetic */ byte[] a;

    public /* synthetic */ d(byte[] byArray) {
        this.a = byArray;
    }

    public final Object apply(Object object) {
        byte[] byArray = this.a;
        object = (RxBleConnection)object;
        return k0.S(byArray, (RxBleConnection)object);
    }
}

