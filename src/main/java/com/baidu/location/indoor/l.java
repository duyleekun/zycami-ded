/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.location.Location
 */
package com.baidu.location.indoor;

import android.location.Location;
import java.util.ArrayList;
import java.util.List;

public class l {
    private List a;
    private String b;
    private Location c;

    public l(String string2, Location[] locationArray) {
        int n10 = 0;
        this.c = null;
        if (locationArray != null && (n10 = locationArray.length) > 0) {
            this.a(locationArray);
            this.b = string2;
        }
    }

    private void a(Location[] locationArray) {
        int n10;
        if (locationArray != null && (n10 = locationArray.length) > 0) {
            Object object;
            double d10;
            int n11;
            double d11;
            Location location = this.a;
            if (location == null) {
                this.a = location = new ArrayList();
            }
            location = null;
            double d12 = d11 = 0.0;
            for (n10 = 0; n10 < (n11 = locationArray.length); ++n10) {
                d10 = locationArray[n10].getLatitude();
                d11 += d10;
                d10 = locationArray[n10].getLongitude();
                d12 += d10;
                object = this.a;
                Location location2 = locationArray[n10];
                object.add(location2);
            }
            location = this.c;
            if (location == null) {
                object = "gps";
                this.c = location = new Location((String)object);
                n11 = locationArray.length;
                d10 = n11;
                location.setLatitude(d11 /= d10);
                location = this.c;
                int n12 = locationArray.length;
                d11 = n12;
                location.setLongitude(d12 /= d11);
            }
        }
    }

    public String a() {
        return this.b;
    }
}

