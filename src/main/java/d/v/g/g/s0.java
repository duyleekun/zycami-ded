/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.g;

import com.zhiyun.device.data.local.entity.FirmwareInfo;
import com.zhiyun.device.firmware.FirmwareUpgradeViewModel;
import d.v.e0.xd;
import e.a.v0.o;

public final class s0
implements o {
    public final /* synthetic */ xd a;

    public /* synthetic */ s0(xd xd2) {
        this.a = xd2;
    }

    public final Object apply(Object object) {
        xd xd2 = this.a;
        object = (FirmwareInfo)object;
        return FirmwareUpgradeViewModel.w0(xd2, (FirmwareInfo)object);
    }
}

