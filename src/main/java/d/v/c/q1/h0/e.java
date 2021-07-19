/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.q1.h0;

import com.zhiyun.cama.set.bind.DeviceBindViewModel;
import com.zhiyun.stabilizer.Stabilizer;
import com.zhiyun.stabilizer.entities.ActiveInfo;
import d.v.e0.ie.l;

public final class e
implements l {
    public final /* synthetic */ DeviceBindViewModel a;
    public final /* synthetic */ Stabilizer b;

    public /* synthetic */ e(DeviceBindViewModel deviceBindViewModel, Stabilizer stabilizer) {
        this.a = deviceBindViewModel;
        this.b = stabilizer;
    }

    public final void call(Object object) {
        DeviceBindViewModel deviceBindViewModel = this.a;
        Stabilizer stabilizer = this.b;
        object = (ActiveInfo)object;
        deviceBindViewModel.P(stabilizer, (ActiveInfo)object);
    }
}

