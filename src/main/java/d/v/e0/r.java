/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.polidea.rxandroidble2.RxBleConnection;
import d.v.e0.pd;
import e.a.v0.c;
import e.a.z;
import java.util.UUID;

public final class r
implements c {
    public final /* synthetic */ pd a;
    public final /* synthetic */ UUID b;
    public final /* synthetic */ byte[] c;

    public /* synthetic */ r(pd pd2, UUID uUID, byte[] byArray) {
        this.a = pd2;
        this.b = uUID;
        this.c = byArray;
    }

    public final Object apply(Object object, Object object2) {
        pd pd2 = this.a;
        UUID uUID = this.b;
        byte[] byArray = this.c;
        object = (RxBleConnection)object;
        object2 = (z)object2;
        return pd2.s(uUID, byArray, (RxBleConnection)object, (z)object2);
    }
}

