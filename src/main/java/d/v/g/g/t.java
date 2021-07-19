/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 */
package d.v.g.g;

import android.util.SparseArray;
import com.zhiyun.device.firmware.FirmwareUpgradeViewModel;
import e.a.v0.g;

public final class t
implements g {
    public final /* synthetic */ FirmwareUpgradeViewModel a;
    public final /* synthetic */ SparseArray b;

    public /* synthetic */ t(FirmwareUpgradeViewModel firmwareUpgradeViewModel, SparseArray sparseArray) {
        this.a = firmwareUpgradeViewModel;
        this.b = sparseArray;
    }

    public final void accept(Object object) {
        FirmwareUpgradeViewModel firmwareUpgradeViewModel = this.a;
        SparseArray sparseArray = this.b;
        object = (Boolean)object;
        firmwareUpgradeViewModel.n0(sparseArray, (Boolean)object);
    }
}

