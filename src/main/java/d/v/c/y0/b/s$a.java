/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y0.b;

import com.zhiyun.device.connection.BleConnection;
import com.zhiyun.device.connection.BleDevice;
import d.v.c.y0.b.s;
import d.v.c.y0.b.v.b;

public class s$a
extends b {
    public final /* synthetic */ s c;

    public s$a(s s10, boolean bl2) {
        this.c = s10;
        super(bl2);
    }

    public void h(BleDevice bleDevice, int n10) {
        Object object = BleConnection.W();
        boolean bl2 = ((BleConnection)object).d0();
        if (!bl2) {
            object = this.c;
            s.u((s)object, bleDevice, n10);
        }
    }
}

