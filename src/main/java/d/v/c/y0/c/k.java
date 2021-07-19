/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y0.c;

import androidx.fragment.app.DialogFragment;
import com.zhiyun.cama.device.firmware.FirmwareUpgradeFragment;
import d.v.f.f.a;

public final class k
implements a {
    public final /* synthetic */ FirmwareUpgradeFragment a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ k(FirmwareUpgradeFragment firmwareUpgradeFragment, boolean bl2) {
        this.a = firmwareUpgradeFragment;
        this.b = bl2;
    }

    public final void a(DialogFragment dialogFragment) {
        FirmwareUpgradeFragment firmwareUpgradeFragment = this.a;
        boolean bl2 = this.b;
        firmwareUpgradeFragment.P(bl2, dialogFragment);
    }
}

