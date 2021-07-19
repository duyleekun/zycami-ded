/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0.je;

import com.polidea.rxandroidble2.RxBleClient;
import d.v.e0.je.e;
import e.a.v0.o;
import java.util.List;

public final class d
implements o {
    public final /* synthetic */ RxBleClient a;

    public /* synthetic */ d(RxBleClient rxBleClient) {
        this.a = rxBleClient;
    }

    public final Object apply(Object object) {
        RxBleClient rxBleClient = this.a;
        object = (List)object;
        return e.g(rxBleClient, (List)object);
    }
}

