/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.device.firmware;

import com.zhiyun.device.firmware.FirmwareUpgradeViewModel;
import d.v.e0.ie.l;
import e.a.b0;

public class FirmwareUpgradeViewModel$b
implements l {
    public final /* synthetic */ b0 a;
    public final /* synthetic */ FirmwareUpgradeViewModel b;

    public FirmwareUpgradeViewModel$b(FirmwareUpgradeViewModel firmwareUpgradeViewModel, b0 b02) {
        this.b = firmwareUpgradeViewModel;
        this.a = b02;
    }

    public void onFailed(Throwable throwable) {
        this.a.onError(throwable);
    }

    public void s(Integer n10) {
        this.a.onNext(n10);
        this.a.onComplete();
    }
}

