/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.polidea.rxandroidble2.RxBleConnection;
import d.v.e0.pd;
import e.a.v0.o;

public final class p
implements o {
    public final /* synthetic */ int a;

    public /* synthetic */ p(int n10) {
        this.a = n10;
    }

    public final Object apply(Object object) {
        int n10 = this.a;
        object = (RxBleConnection)object;
        return pd.u(n10, (RxBleConnection)object);
    }
}

