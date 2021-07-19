/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.telephony.PhoneStateListener
 *  android.telephony.TelephonyManager
 */
package d.v.e.m;

import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.zhiyun.common.viewmodel.DeviceViewModel;
import e.a.v0.f;

public final class b
implements f {
    public final /* synthetic */ TelephonyManager a;
    public final /* synthetic */ PhoneStateListener b;

    public /* synthetic */ b(TelephonyManager telephonyManager, PhoneStateListener phoneStateListener) {
        this.a = telephonyManager;
        this.b = phoneStateListener;
    }

    public final void cancel() {
        TelephonyManager telephonyManager = this.a;
        PhoneStateListener phoneStateListener = this.b;
        DeviceViewModel.n(telephonyManager, phoneStateListener);
    }
}

