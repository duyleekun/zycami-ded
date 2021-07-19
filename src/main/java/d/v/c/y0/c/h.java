/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y0.c;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.device.firmware.FirmwareUpgradeFragment;

public final class h
implements Observer {
    public final /* synthetic */ FirmwareUpgradeFragment a;

    public /* synthetic */ h(FirmwareUpgradeFragment firmwareUpgradeFragment) {
        this.a = firmwareUpgradeFragment;
    }

    public final void onChanged(Object object) {
        FirmwareUpgradeFragment firmwareUpgradeFragment = this.a;
        object = (Integer)object;
        firmwareUpgradeFragment.K((Integer)object);
    }
}

