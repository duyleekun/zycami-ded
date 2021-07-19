/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y0.c;

import androidx.core.util.Pair;
import androidx.lifecycle.Observer;
import com.zhiyun.cama.device.firmware.FirmwareUpgradeFragment;

public final class e
implements Observer {
    public final /* synthetic */ FirmwareUpgradeFragment a;

    public /* synthetic */ e(FirmwareUpgradeFragment firmwareUpgradeFragment) {
        this.a = firmwareUpgradeFragment;
    }

    public final void onChanged(Object object) {
        FirmwareUpgradeFragment firmwareUpgradeFragment = this.a;
        object = (Pair)object;
        firmwareUpgradeFragment.M((Pair)object);
    }
}

