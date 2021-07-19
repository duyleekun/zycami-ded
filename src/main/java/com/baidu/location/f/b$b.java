/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.telephony.PhoneStateListener
 *  android.telephony.SignalStrength
 */
package com.baidu.location.f;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import com.baidu.location.f.a;
import com.baidu.location.f.b;
import com.baidu.location.f.d;
import java.util.List;

public class b$b
extends PhoneStateListener {
    public final /* synthetic */ b a;

    public b$b(b b10) {
        this.a = b10;
    }

    public void onCellInfoChanged(List list) {
        if (list == null) {
            return;
        }
        list = b.b(this.a);
        d d10 = new d(this);
        list.post(d10);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void onSignalStrengthsChanged(SignalStrength signalStrength) {
        int n10;
        a a10 = b.c(this.a);
        if (a10 == null) return;
        a10 = b.c(this.a);
        int n11 = a10.i;
        int n12 = 103;
        if (n11 == n12) {
            a10 = b.c(this.a);
            n10 = signalStrength.getGsmSignalStrength();
        } else {
            a10 = b.c(this.a);
            n11 = a10.i;
            n12 = 99;
            if (n11 != n12) return;
            a10 = b.c(this.a);
            n10 = signalStrength.getCdmaDbm();
        }
        a10.h = n10;
    }
}

