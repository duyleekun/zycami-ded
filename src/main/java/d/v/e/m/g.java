/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.telephony.TelephonyManager
 */
package d.v.e.m;

import android.telephony.TelephonyManager;
import com.zhiyun.common.viewmodel.DeviceViewModel;
import e.a.l;
import e.a.m;

public final class g
implements m {
    public final /* synthetic */ DeviceViewModel a;
    public final /* synthetic */ TelephonyManager b;

    public /* synthetic */ g(DeviceViewModel deviceViewModel, TelephonyManager telephonyManager) {
        this.a = deviceViewModel;
        this.b = telephonyManager;
    }

    public final void subscribe(l l10) {
        DeviceViewModel deviceViewModel = this.a;
        TelephonyManager telephonyManager = this.b;
        deviceViewModel.p(telephonyManager, l10);
    }
}

