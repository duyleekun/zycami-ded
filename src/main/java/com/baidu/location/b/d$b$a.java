/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.location.Location
 *  android.location.LocationListener
 *  android.os.Bundle
 */
package com.baidu.location.b;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import com.baidu.location.b.d$b;
import com.baidu.location.b.e;

public class d$b$a
implements LocationListener {
    public final /* synthetic */ d$b a;

    private d$b$a(d$b b10) {
        this.a = b10;
    }

    public /* synthetic */ d$b$a(d$b b10, e e10) {
        this(b10);
    }

    public void onLocationChanged(Location location) {
        d$b.a(this.a);
        this.a.d = true;
    }

    public void onProviderDisabled(String string2) {
    }

    public void onProviderEnabled(String string2) {
    }

    public void onStatusChanged(String string2, int n10, Bundle bundle) {
    }
}

