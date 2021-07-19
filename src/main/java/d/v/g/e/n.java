/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.e;

import com.zhiyun.device.connection.BleConnection;
import e.a.v0.g;

public final class n
implements g {
    public final /* synthetic */ BleConnection a;

    public /* synthetic */ n(BleConnection bleConnection) {
        this.a = bleConnection;
    }

    public final void accept(Object object) {
        BleConnection bleConnection = this.a;
        object = (Throwable)object;
        bleConnection.p0((Throwable)object);
    }
}

