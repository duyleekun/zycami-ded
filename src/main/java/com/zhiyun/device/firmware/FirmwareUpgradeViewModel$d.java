/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.device.firmware;

import com.zhiyun.device.firmware.FirmwareUpgradeViewModel;
import d.v.e0.ie.l;
import e.a.b0;
import java.util.List;

public class FirmwareUpgradeViewModel$d
implements l {
    public final /* synthetic */ b0 a;
    public final /* synthetic */ FirmwareUpgradeViewModel b;

    public FirmwareUpgradeViewModel$d(FirmwareUpgradeViewModel firmwareUpgradeViewModel, b0 b02) {
        this.b = firmwareUpgradeViewModel;
        this.a = b02;
    }

    public void onFailed(Throwable throwable) {
        this.a.onError(throwable);
    }

    public void s(List list) {
        this.a.onNext(list);
        this.a.onComplete();
    }
}

