/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.g;

import com.zhiyun.device.data.local.entity.FirmwareInfo;
import com.zhiyun.device.firmware.FirmwareUpgradeViewModel;
import e.a.v0.o;

public final class s
implements o {
    public final /* synthetic */ FirmwareUpgradeViewModel a;

    public /* synthetic */ s(FirmwareUpgradeViewModel firmwareUpgradeViewModel) {
        this.a = firmwareUpgradeViewModel;
    }

    public final Object apply(Object object) {
        FirmwareUpgradeViewModel firmwareUpgradeViewModel = this.a;
        object = (FirmwareInfo)object;
        return FirmwareUpgradeViewModel.J(firmwareUpgradeViewModel, (FirmwareInfo)object);
    }
}

