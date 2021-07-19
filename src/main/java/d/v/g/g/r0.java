/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.g;

import androidx.core.util.Pair;
import com.zhiyun.device.firmware.FirmwareUpgradeViewModel;
import e.a.b0;
import e.a.c0;

public final class r0
implements c0 {
    public final /* synthetic */ FirmwareUpgradeViewModel a;
    public final /* synthetic */ Pair b;

    public /* synthetic */ r0(FirmwareUpgradeViewModel firmwareUpgradeViewModel, Pair pair) {
        this.a = firmwareUpgradeViewModel;
        this.b = pair;
    }

    public final void subscribe(b0 b02) {
        FirmwareUpgradeViewModel firmwareUpgradeViewModel = this.a;
        Pair pair = this.b;
        firmwareUpgradeViewModel.C0(pair, b02);
    }
}

