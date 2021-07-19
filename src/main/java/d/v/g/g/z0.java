/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.g;

import androidx.core.util.Pair;
import com.zhiyun.device.firmware.FirmwareUpgradeViewModel;
import e.a.v0.r;

public final class z0
implements r {
    public final /* synthetic */ Pair a;

    public /* synthetic */ z0(Pair pair) {
        this.a = pair;
    }

    public final boolean test(Object object) {
        Pair pair = this.a;
        object = (Boolean)object;
        return FirmwareUpgradeViewModel.x0(pair, (Boolean)object);
    }
}

