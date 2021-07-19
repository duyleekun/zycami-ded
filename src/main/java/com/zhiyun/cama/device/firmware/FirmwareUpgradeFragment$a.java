/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.device.firmware;

import androidx.activity.OnBackPressedCallback;
import com.zhiyun.cama.device.firmware.FirmwareUpgradeFragment;
import com.zhiyun.cama.device.firmware.FirmwareUpgradeFragment$b;

public class FirmwareUpgradeFragment$a
extends OnBackPressedCallback {
    public final /* synthetic */ FirmwareUpgradeFragment a;

    public FirmwareUpgradeFragment$a(FirmwareUpgradeFragment firmwareUpgradeFragment, boolean bl2) {
        this.a = firmwareUpgradeFragment;
        super(bl2);
    }

    public void handleOnBackPressed() {
        Object object = FirmwareUpgradeFragment.j((FirmwareUpgradeFragment)this.a).b;
        int n10 = object.getVisibility();
        if (n10 != 0) {
            object = FirmwareUpgradeFragment.k(this.a);
            ((FirmwareUpgradeFragment$b)object).a();
        }
    }
}

