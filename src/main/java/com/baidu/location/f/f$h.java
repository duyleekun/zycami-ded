/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.location.Location
 *  android.location.LocationListener
 *  android.os.Bundle
 *  android.os.Message
 *  android.text.TextUtils
 */
package com.baidu.location.f;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.location.b.ac;
import com.baidu.location.f.f;
import com.baidu.location.f.g;

public class f$h
implements LocationListener {
    public final /* synthetic */ f a;
    private long b = 0L;

    private f$h(f f10) {
        this.a = f10;
    }

    public /* synthetic */ f$h(f f10, g g10) {
        this(f10);
    }

    public void onLocationChanged(Location location) {
        String string2;
        Object object = this.a;
        Object object2 = f.a((f)object);
        if (object2 != 0) {
            return;
        }
        if (location != null && (object2 = TextUtils.equals((CharSequence)(object = location.getProvider()), (CharSequence)(string2 = "gps"))) != 0) {
            double d10;
            long l10 = System.currentTimeMillis();
            long l11 = this.b;
            l10 -= l11;
            l11 = 10000L;
            double d11 = 4.9407E-320;
            object2 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (object2 < 0) {
                return;
            }
            double d12 = Math.abs(location.getLatitude());
            l11 = 4645040803167600640L;
            d11 = 360.0;
            double d13 = d12 - d11;
            object2 = d13 == 0.0 ? 0 : (d13 > 0.0 ? 1 : -1);
            if (object2 <= 0 && (object2 = (Object)((d10 = (d12 = Math.abs(location.getLongitude())) - d11) == 0.0 ? 0 : (d10 > 0.0 ? 1 : -1))) <= 0) {
                object = null;
                object2 = ac.a(location, false);
                if (object2 != 0) {
                    this.b = l10 = System.currentTimeMillis();
                    object = f.b(this.a);
                    if (object != null) {
                        object = f.b(this.a);
                        int n10 = 4;
                        location = object.obtainMessage(n10, (Object)location);
                        object = f.b(this.a);
                        object.sendMessage((Message)location);
                    }
                }
            }
        }
    }

    public void onProviderDisabled(String string2) {
    }

    public void onProviderEnabled(String string2) {
    }

    public void onStatusChanged(String string2, int n10, Bundle bundle) {
    }
}

