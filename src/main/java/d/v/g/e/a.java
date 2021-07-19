/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.e;

import com.zhiyun.device.connection.BleConnection;
import com.zhiyun.device.connection.BleConnection$RESTRICTION_STATE;
import e.a.v0.g;

public final class a
implements g {
    public final /* synthetic */ BleConnection a;

    public /* synthetic */ a(BleConnection bleConnection) {
        this.a = bleConnection;
    }

    public final void accept(Object object) {
        BleConnection bleConnection = this.a;
        object = (BleConnection$RESTRICTION_STATE)((Object)object);
        bleConnection.n0((BleConnection$RESTRICTION_STATE)((Object)object));
    }
}

