/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.g;

import androidx.core.util.Pair;
import com.zhiyun.device.firmware.FirmwareUpgradeViewModel;
import e.a.v0.r;

public final class v
implements r {
    public final /* synthetic */ FirmwareUpgradeViewModel a;

    public /* synthetic */ v(FirmwareUpgradeViewModel firmwareUpgradeViewModel) {
        this.a = firmwareUpgradeViewModel;
    }

    public final boolean test(Object object) {
        FirmwareUpgradeViewModel firmwareUpgradeViewModel = this.a;
        object = (Pair)object;
        return FirmwareUpgradeViewModel.K(firmwareUpgradeViewModel, (Pair)object);
    }
}

