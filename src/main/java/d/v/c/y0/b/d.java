/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y0.b;

import androidx.lifecycle.Observer;
import com.zhiyun.device.connection.BleDeviceViewModel$ConnectStatus;
import d.v.c.y0.b.s;

public final class d
implements Observer {
    public final /* synthetic */ s a;

    public /* synthetic */ d(s s10) {
        this.a = s10;
    }

    public final void onChanged(Object object) {
        s s10 = this.a;
        object = (BleDeviceViewModel$ConnectStatus)((Object)object);
        s10.J((BleDeviceViewModel$ConnectStatus)((Object)object));
    }
}

