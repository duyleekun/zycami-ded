/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y0.b;

import androidx.lifecycle.Observer;
import com.zhiyun.device.connection.BleDevice;
import d.v.c.y0.b.s;

public final class f
implements Observer {
    public final /* synthetic */ s a;

    public /* synthetic */ f(s s10) {
        this.a = s10;
    }

    public final void onChanged(Object object) {
        s s10 = this.a;
        object = (BleDevice)object;
        s.H(s10, (BleDevice)object);
    }
}

