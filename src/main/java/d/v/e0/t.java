/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.polidea.rxandroidble2.RxBleConnection;
import d.v.e0.pd;
import e.a.v0.o;
import java.util.UUID;

public final class t
implements o {
    public final /* synthetic */ pd a;
    public final /* synthetic */ UUID b;
    public final /* synthetic */ byte[] c;

    public /* synthetic */ t(pd pd2, UUID uUID, byte[] byArray) {
        this.a = pd2;
        this.b = uUID;
        this.c = byArray;
    }

    public final Object apply(Object object) {
        pd pd2 = this.a;
        UUID uUID = this.b;
        byte[] byArray = this.c;
        object = (RxBleConnection)object;
        return pd2.w(uUID, byArray, (RxBleConnection)object);
    }
}

