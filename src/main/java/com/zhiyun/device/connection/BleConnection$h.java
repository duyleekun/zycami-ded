/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.device.connection;

import com.zhiyun.device.connection.BleConnection;
import com.zhiyun.device.connection.BleConnection$RESTRICTION_STATE;
import com.zhiyun.net.BaseEntity;
import d.v.g.d.a;
import e.a.b0;

public class BleConnection$h
extends a {
    public final /* synthetic */ b0 c;
    public final /* synthetic */ BleConnection d;

    public BleConnection$h(BleConnection bleConnection, b0 b02) {
        this.d = bleConnection;
        this.c = b02;
    }

    public void a(BaseEntity object) {
        BleConnection.t(this.d, false);
        BleConnection.q(this.d);
        object = this.c;
        BleConnection$RESTRICTION_STATE bleConnection$RESTRICTION_STATE = BleConnection$RESTRICTION_STATE.RESTRICTION_STATE_NO_RESTRICT;
        object.onNext((Object)bleConnection$RESTRICTION_STATE);
        this.c.onComplete();
    }

    public void onError(Throwable object, int n10, String string2) {
        int n11 = -1;
        if (n10 != n11 && n10 != (n11 = -2)) {
            object = this.d;
            Object object2 = String.valueOf(n10);
            BleConnection.x((BleConnection)object, object2);
            object = this.c;
            object2 = BleConnection$RESTRICTION_STATE.RESTRICTION_STATE_RESTRICT;
            object.onNext(object2);
            object = this.d;
            n10 = 0;
            object2 = null;
            BleConnection.y((BleConnection)object, false);
        } else {
            object = this.d;
            Object object3 = BleConnection.u((BleConnection)object);
            BleConnection.w((BleConnection)object, object3);
            object = this.c;
            object3 = BleConnection$RESTRICTION_STATE.RESTRICTION_STATE_NORMAL;
            object.onNext(object3);
        }
        this.c.onComplete();
    }
}

