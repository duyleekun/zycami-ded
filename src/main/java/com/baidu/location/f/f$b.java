/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.location.GnssNavigationMessage
 *  android.location.GnssNavigationMessage$Callback
 */
package com.baidu.location.f;

import android.location.GnssNavigationMessage;
import com.baidu.location.b.ad;
import com.baidu.location.f.f;
import com.baidu.location.f.g;

public class f$b
extends GnssNavigationMessage.Callback {
    public int a = 0;
    public final /* synthetic */ f b;

    private f$b(f f10) {
        this.b = f10;
    }

    public /* synthetic */ f$b(f f10, g g10) {
        this(f10);
    }

    public void onGnssNavigationMessageReceived(GnssNavigationMessage gnssNavigationMessage) {
        long l10;
        long l11;
        Object object = this.b;
        long l12 = f.e((f)object);
        long l13 = l12 - (l11 = 0L);
        Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object2 != false) {
            object = ad.a();
            f f10 = this.b;
            l10 = f.e(f10);
        } else {
            object = ad.a();
            l10 = System.currentTimeMillis();
            long l14 = 1000L;
            l10 /= l14;
        }
        ((ad)object).a(gnssNavigationMessage, l10);
    }

    public void onStatusChanged(int n10) {
        this.a = n10;
    }
}

