/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.e;

import com.zhiyun.device.connection.BleConnection;
import e.a.v0.o;

public final class k
implements o {
    public final /* synthetic */ BleConnection a;

    public /* synthetic */ k(BleConnection bleConnection) {
        this.a = bleConnection;
    }

    public final Object apply(Object object) {
        BleConnection bleConnection = this.a;
        object = (Boolean)object;
        return bleConnection.t0((Boolean)object);
    }
}

