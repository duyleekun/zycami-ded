/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.location.LocationListener
 *  android.location.LocationManager
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package com.mob.tools.utils;

import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Message;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.LocationHelper;

public class LocationHelper$1
implements Handler.Callback {
    public final /* synthetic */ LocationHelper this$0;

    public LocationHelper$1(LocationHelper locationHelper) {
        this.this$0 = locationHelper;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean handleMessage(Message object) {
        try {
            Object object2 = this.this$0;
            object2 = LocationHelper.access$000((LocationHelper)object2);
            String string2 = "android.permission.ACCESS_FINE_LOCATION";
            boolean bl2 = ((DeviceHelper)object2).checkPermission(string2);
            if (!bl2) {
                LocationHelper locationHelper = this.this$0;
                LocationHelper.access$700(locationHelper);
                return false;
            }
            int n10 = object.what;
            if (n10 == 0) {
                LocationHelper locationHelper = this.this$0;
                LocationHelper.access$100(locationHelper);
                return false;
            }
            LocationHelper locationHelper = this.this$0;
            n10 = (int)(LocationHelper.access$200(locationHelper) ? 1 : 0);
            if (n10 != 0) {
                LocationHelper locationHelper2 = this.this$0;
                LocationHelper.access$300(locationHelper2);
                return false;
            }
            LocationHelper locationHelper3 = this.this$0;
            n10 = (int)(LocationHelper.access$400(locationHelper3) ? 1 : 0);
            if (n10 == 0) return false;
            LocationHelper locationHelper4 = this.this$0;
            LocationManager locationManager = LocationHelper.access$500(locationHelper4);
            if (locationManager != null) {
                LocationHelper locationHelper5 = this.this$0;
                LocationManager locationManager2 = LocationHelper.access$500(locationHelper5);
                object2 = this.this$0;
                object2 = LocationHelper.access$600((LocationHelper)object2);
                locationManager2.removeUpdates((LocationListener)object2);
            }
            LocationHelper locationHelper6 = this.this$0;
            LocationHelper.access$700(locationHelper6);
            return false;
        }
        catch (Throwable throwable) {
            NLog nLog = MobLog.getInstance();
            nLog.d(throwable);
            LocationHelper locationHelper = this.this$0;
            LocationHelper.access$700(locationHelper);
        }
        return false;
    }
}

