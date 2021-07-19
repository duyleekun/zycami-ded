/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y0.c;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.device.firmware.FirmwareUpgradeFragment;

public final class n
implements Observer {
    public static final /* synthetic */ n a;

    static {
        n n10;
        a = n10 = new n();
    }

    public final void onChanged(Object object) {
        FirmwareUpgradeFragment.N((Boolean)object);
    }
}

