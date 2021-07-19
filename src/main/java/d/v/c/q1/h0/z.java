/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.q1.h0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.set.bind.DeviceBindViewModel$BindOperateState;
import com.zhiyun.cama.set.bind.MyDeviceFragment;

public final class z
implements Observer {
    public final /* synthetic */ MyDeviceFragment a;

    public /* synthetic */ z(MyDeviceFragment myDeviceFragment) {
        this.a = myDeviceFragment;
    }

    public final void onChanged(Object object) {
        MyDeviceFragment myDeviceFragment = this.a;
        object = (DeviceBindViewModel$BindOperateState)((Object)object);
        myDeviceFragment.P((DeviceBindViewModel$BindOperateState)((Object)object));
    }
}

