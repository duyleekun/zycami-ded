/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.device.firmware;

import androidx.lifecycle.MutableLiveData;
import com.zhiyun.device.firmware.FirmwareUpgradeViewModel;
import d.v.e.i.h;
import d.v.g.g.d1$b;

public class FirmwareUpgradeViewModel$a
implements d1$b {
    public final /* synthetic */ FirmwareUpgradeViewModel a;

    public FirmwareUpgradeViewModel$a(FirmwareUpgradeViewModel firmwareUpgradeViewModel) {
        this.a = firmwareUpgradeViewModel;
    }

    public void a(Exception object) {
        object = FirmwareUpgradeViewModel.b(this.a);
        Integer n10 = 2;
        h.e((MutableLiveData)object, n10);
    }

    public void onComplete() {
        MutableLiveData mutableLiveData = FirmwareUpgradeViewModel.b(this.a);
        Integer n10 = 4;
        h.e(mutableLiveData, n10);
    }

    public void onProgress(int n10) {
        int n11;
        Object object = (Integer)FirmwareUpgradeViewModel.b(this.a).getValue();
        int n12 = (Integer)object;
        if (n12 != (n11 = 1)) {
            object = FirmwareUpgradeViewModel.b(this.a);
            Integer n13 = n11;
            h.e((MutableLiveData)object, n13);
        }
        object = FirmwareUpgradeViewModel.c(this.a);
        Integer n14 = n10;
        h.e((MutableLiveData)object, n14);
    }
}

