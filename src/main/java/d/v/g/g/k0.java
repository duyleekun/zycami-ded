/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.g;

import com.zhiyun.device.data.local.entity.FirmwareInfo;
import com.zhiyun.device.firmware.FirmwareUpgradeViewModel;
import e.a.v0.r;

public final class k0
implements r {
    public final /* synthetic */ FirmwareUpgradeViewModel a;

    public /* synthetic */ k0(FirmwareUpgradeViewModel firmwareUpgradeViewModel) {
        this.a = firmwareUpgradeViewModel;
    }

    public final boolean test(Object object) {
        FirmwareUpgradeViewModel firmwareUpgradeViewModel = this.a;
        object = (FirmwareInfo)object;
        return FirmwareUpgradeViewModel.R(firmwareUpgradeViewModel, (FirmwareInfo)object);
    }
}

