/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.device.connection;

import com.zhiyun.device.connection.BleConnection;
import com.zhiyun.protocol.message.bl.active.ActiveState;
import com.zhiyun.stabilizer.entities.ActiveInfo;
import d.v.e0.ce;
import d.v.e0.ie.l;
import d.v.q.e;

public class BleConnection$e
implements l {
    public final /* synthetic */ l a;
    public final /* synthetic */ BleConnection b;

    public BleConnection$e(BleConnection bleConnection, l l10) {
        this.b = bleConnection;
        this.a = l10;
    }

    public void onFailed(Throwable object) {
        Object object2 = ce.E0().y0().e;
        object = new Object[]{object2};
        e.e(10000, "device sn = %s,\u83b7\u53d6\u6fc0\u6d3b\u72b6\u6001\u5931\u8d25", (Object[])object);
        object = this.a;
        object2 = new IllegalArgumentException("get activation state fail");
        object.onFailed((Throwable)object2);
    }

    public void s(ActiveInfo object) {
        BleConnection.i(this.b, (ActiveInfo)object);
        object = BleConnection.h((BleConnection)this.b).state;
        Object object2 = ActiveState.INACTIVATED;
        if (object == object2) {
            BleConnection.j(this.b);
            object = this.a;
            object2 = Boolean.FALSE;
            object.call(object2);
        } else {
            object = this.b;
            boolean bl2 = true;
            BleConnection.k((BleConnection)object, bl2);
            object = this.a;
            object2 = Boolean.TRUE;
            object.call(object2);
        }
    }
}

