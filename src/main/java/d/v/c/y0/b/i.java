/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y0.b;

import androidx.lifecycle.Observer;
import com.zhiyun.device.connection.BleDeviceViewModel$OperationStatus;
import d.v.c.y0.b.s;

public final class i
implements Observer {
    public final /* synthetic */ s a;

    public /* synthetic */ i(s s10) {
        this.a = s10;
    }

    public final void onChanged(Object object) {
        s s10 = this.a;
        object = (BleDeviceViewModel$OperationStatus)((Object)object);
        s10.L((BleDeviceViewModel$OperationStatus)((Object)object));
    }
}

