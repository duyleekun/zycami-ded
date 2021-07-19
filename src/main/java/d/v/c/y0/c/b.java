/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y0.c;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.device.firmware.FirmwareUpgradeFragment;

public final class b
implements Observer {
    public final /* synthetic */ FirmwareUpgradeFragment a;

    public /* synthetic */ b(FirmwareUpgradeFragment firmwareUpgradeFragment) {
        this.a = firmwareUpgradeFragment;
    }

    public final void onChanged(Object object) {
        FirmwareUpgradeFragment firmwareUpgradeFragment = this.a;
        object = (Throwable)object;
        firmwareUpgradeFragment.I((Throwable)object);
    }
}

