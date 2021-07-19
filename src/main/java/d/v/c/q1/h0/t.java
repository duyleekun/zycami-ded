/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.q1.h0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.set.bind.DeviceBindViewModel$Status;
import com.zhiyun.cama.set.bind.MyDeviceFragment;

public final class t
implements Observer {
    public final /* synthetic */ MyDeviceFragment a;

    public /* synthetic */ t(MyDeviceFragment myDeviceFragment) {
        this.a = myDeviceFragment;
    }

    public final void onChanged(Object object) {
        MyDeviceFragment myDeviceFragment = this.a;
        object = (DeviceBindViewModel$Status)((Object)object);
        myDeviceFragment.H((DeviceBindViewModel$Status)((Object)object));
    }
}

