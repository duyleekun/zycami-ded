/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y0.c;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.device.firmware.FirmwareUpgradeFragment;
import com.zhiyun.device.firmware.FirmwareUpgradeViewModel$FirmwareFailType;

public final class i
implements Observer {
    public final /* synthetic */ FirmwareUpgradeFragment a;

    public /* synthetic */ i(FirmwareUpgradeFragment firmwareUpgradeFragment) {
        this.a = firmwareUpgradeFragment;
    }

    public final void onChanged(Object object) {
        FirmwareUpgradeFragment firmwareUpgradeFragment = this.a;
        object = (FirmwareUpgradeViewModel$FirmwareFailType)((Object)object);
        firmwareUpgradeFragment.C((FirmwareUpgradeViewModel$FirmwareFailType)((Object)object));
    }
}

