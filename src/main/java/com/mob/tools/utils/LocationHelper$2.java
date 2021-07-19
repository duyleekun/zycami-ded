/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.location.Location
 *  android.location.LocationListener
 *  android.os.Bundle
 */
package com.mob.tools.utils;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.LocationHelper;

public class LocationHelper$2
implements LocationListener {
    public final /* synthetic */ LocationHelper this$0;

    public LocationHelper$2(LocationHelper locationHelper) {
        this.this$0 = locationHelper;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onLocationChanged(Location object) {
        Object object2;
        try {
            object2 = this.this$0;
            synchronized (object2) {
            }
        }
        catch (Throwable throwable) {
            object2 = MobLog.getInstance();
            ((NLog)object2).d(throwable);
            return;
        }
        {
            LocationHelper locationHelper;
            try {
                locationHelper = this.this$0;
                locationHelper = LocationHelper.access$500(locationHelper);
                locationHelper.removeUpdates(this);
            }
            catch (Throwable throwable) {
                NLog nLog = MobLog.getInstance();
                nLog.d(throwable);
            }
            locationHelper = this.this$0;
            LocationHelper.access$802(locationHelper, (Location)object);
            object = this.this$0;
            object.notifyAll();
        }
        {
            object = this.this$0;
            object = LocationHelper.access$900((LocationHelper)object);
            object = object.getLooper();
            object.quit();
            return;
        }
    }

    public void onProviderDisabled(String string2) {
    }

    public void onProviderEnabled(String string2) {
    }

    public void onStatusChanged(String string2, int n10, Bundle bundle) {
    }
}

