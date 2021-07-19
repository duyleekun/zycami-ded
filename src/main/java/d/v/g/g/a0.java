/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.g;

import androidx.core.util.Pair;
import com.zhiyun.device.firmware.FirmwareUpgradeViewModel;
import e.a.v0.o;

public final class a0
implements o {
    public final /* synthetic */ FirmwareUpgradeViewModel a;
    public final /* synthetic */ Pair b;

    public /* synthetic */ a0(FirmwareUpgradeViewModel firmwareUpgradeViewModel, Pair pair) {
        this.a = firmwareUpgradeViewModel;
        this.b = pair;
    }

    public final Object apply(Object object) {
        FirmwareUpgradeViewModel firmwareUpgradeViewModel = this.a;
        Pair pair = this.b;
        object = (String)object;
        return firmwareUpgradeViewModel.A0(pair, (String)object);
    }
}

