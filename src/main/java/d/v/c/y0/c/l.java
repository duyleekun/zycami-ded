/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y0.c;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.device.firmware.FirmwareUpgradeFragment;
import com.zhiyun.device.data.local.entity.FirmwareInfo;

public final class l
implements Observer {
    public final /* synthetic */ FirmwareUpgradeFragment a;

    public /* synthetic */ l(FirmwareUpgradeFragment firmwareUpgradeFragment) {
        this.a = firmwareUpgradeFragment;
    }

    public final void onChanged(Object object) {
        FirmwareUpgradeFragment firmwareUpgradeFragment = this.a;
        object = (FirmwareInfo)object;
        firmwareUpgradeFragment.G((FirmwareInfo)object);
    }
}

