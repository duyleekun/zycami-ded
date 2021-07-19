/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.g;

import com.zhiyun.device.data.local.entity.FirmwareInfo;
import com.zhiyun.device.firmware.FirmwareUpgradeViewModel;
import e.a.v0.g;

public final class y0
implements g {
    public final /* synthetic */ FirmwareUpgradeViewModel a;

    public /* synthetic */ y0(FirmwareUpgradeViewModel firmwareUpgradeViewModel) {
        this.a = firmwareUpgradeViewModel;
    }

    public final void accept(Object object) {
        FirmwareUpgradeViewModel firmwareUpgradeViewModel = this.a;
        object = (FirmwareInfo)object;
        firmwareUpgradeViewModel.r0((FirmwareInfo)object);
    }
}

