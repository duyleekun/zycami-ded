/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.telephony.CellSignalStrength
 *  android.telephony.PhoneStateListener
 *  android.telephony.SignalStrength
 */
package com.zhiyun.common.viewmodel;

import android.os.Build;
import android.telephony.CellSignalStrength;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import androidx.core.util.Pair;
import com.zhiyun.common.viewmodel.DeviceViewModel;
import e.a.l;

public class DeviceViewModel$d
extends PhoneStateListener {
    public final int a;
    public final int b;
    public final /* synthetic */ l c;
    public final /* synthetic */ DeviceViewModel d;

    public DeviceViewModel$d(DeviceViewModel deviceViewModel, l l10) {
        this.d = deviceViewModel;
        this.c = l10;
        this.a = 99;
        this.b = -113;
    }

    private int a(SignalStrength signalStrength) {
        int n10 = signalStrength.isGsm();
        if (n10 != 0) {
            int n11 = signalStrength.getGsmSignalStrength();
            if (n11 >= (n10 = 99)) {
                n11 = 0;
                signalStrength = null;
            }
            return n11 * 2 + -113;
        }
        return signalStrength.getCdmaDbm();
    }

    private int b(SignalStrength object) {
        boolean bl2 = (object = object.getCellSignalStrengths()).isEmpty();
        if (bl2) {
            return -113;
        }
        return ((CellSignalStrength)object.get(0)).getDbm();
    }

    public void onSignalStrengthsChanged(SignalStrength object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        int n12 = n10 >= n11 ? this.b((SignalStrength)object) : this.a((SignalStrength)object);
        l l10 = this.c;
        object = n12;
        Boolean bl2 = this.d.i();
        object = Pair.create(object, bl2);
        l10.onNext(object);
    }
}

