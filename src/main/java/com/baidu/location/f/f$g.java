/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.location.GpsStatus$NmeaListener
 */
package com.baidu.location.f;

import android.location.GpsStatus;
import com.baidu.location.f.f;
import com.baidu.location.f.g;

public class f$g
implements GpsStatus.NmeaListener {
    public final /* synthetic */ f a;

    private f$g(f f10) {
        this.a = f10;
    }

    public /* synthetic */ f$g(f f10, g g10) {
        this(f10);
    }

    public void onNmeaReceived(long l10, String string2) {
        f.a(this.a, string2);
    }
}

