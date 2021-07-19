/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.location.Location
 *  android.location.LocationListener
 *  android.location.LocationManager
 *  android.os.Handler
 *  android.os.Handler$Callback
 */
package com.mob.tools.utils;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Handler;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.LocationHelper$1;
import com.mob.tools.utils.LocationHelper$2;

public class LocationHelper {
    private DeviceHelper deviceHelper;
    private boolean gpsRequesting;
    private int gpsTimeoutSec;
    private Handler handler;
    private LocationListener listener;
    private LocationManager lm;
    private boolean networkRequesting;
    private int networkTimeoutSec;
    private Location res;

    public LocationHelper() {
        Handler.Callback callback = this.newCallback();
        callback = MobHandlerThread.newHandler("h", callback);
        this.handler = callback;
        this.newLocationListener();
    }

    public static /* synthetic */ DeviceHelper access$000(LocationHelper locationHelper) {
        return locationHelper.deviceHelper;
    }

    public static /* synthetic */ void access$100(LocationHelper locationHelper) {
        locationHelper.onRequest();
    }

    public static /* synthetic */ boolean access$200(LocationHelper locationHelper) {
        return locationHelper.gpsRequesting;
    }

    public static /* synthetic */ void access$300(LocationHelper locationHelper) {
        locationHelper.onGPSTimeout();
    }

    public static /* synthetic */ boolean access$400(LocationHelper locationHelper) {
        return locationHelper.networkRequesting;
    }

    public static /* synthetic */ LocationManager access$500(LocationHelper locationHelper) {
        return locationHelper.lm;
    }

    public static /* synthetic */ LocationListener access$600(LocationHelper locationHelper) {
        return locationHelper.listener;
    }

    public static /* synthetic */ void access$700(LocationHelper locationHelper) {
        locationHelper.quit();
    }

    public static /* synthetic */ Location access$802(LocationHelper locationHelper, Location location) {
        locationHelper.res = location;
        return location;
    }

    public static /* synthetic */ Handler access$900(LocationHelper locationHelper) {
        return locationHelper.handler;
    }

    private Handler.Callback newCallback() {
        LocationHelper$1 locationHelper$1 = new LocationHelper$1(this);
        return locationHelper$1;
    }

    private void newLocationListener() {
        LocationHelper$2 locationHelper$2 = new LocationHelper$2(this);
        this.listener = locationHelper$2;
    }

    private void onGPSTimeout() {
        LocationManager locationManager = this.lm;
        Object object = this.listener;
        locationManager.removeUpdates(object);
        int n10 = 0;
        locationManager = null;
        this.gpsRequesting = false;
        int n11 = this.networkTimeoutSec;
        int n12 = 1;
        if (n11 != 0) {
            n10 = n12;
        }
        if (n10 != 0 && (n10 = (locationManager = this.lm).isProviderEnabled((String)(object = "network"))) != 0) {
            this.networkRequesting = n12;
            LocationManager locationManager2 = this.lm;
            long l10 = 1000L;
            LocationListener locationListener = this.listener;
            String string2 = "network";
            locationManager2.requestLocationUpdates(string2, l10, 0.0f, locationListener);
            n10 = this.networkTimeoutSec;
            if (n10 > 0) {
                object = this.handler;
                long l11 = n10 *= 1000;
                object.sendEmptyMessageDelayed(n12, l11);
            }
        } else {
            this.quit();
        }
    }

    private void onRequest() {
        LocationManager locationManager;
        String string2;
        int n10 = this.gpsTimeoutSec;
        int n11 = 0;
        Object object = null;
        int n12 = 1;
        if (n10 != 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        int n13 = this.networkTimeoutSec;
        if (n13 != 0) {
            n11 = n12;
        }
        if ((locationManager = this.lm) != null) {
            if (n10 != 0 && (n10 = (int)(locationManager.isProviderEnabled(string2 = "gps") ? 1 : 0)) != 0) {
                block18: {
                    this.gpsRequesting = n12;
                    locationManager = this.lm;
                    String string3 = "gps";
                    long l10 = 1000L;
                    LocationListener locationListener = this.listener;
                    locationManager.requestLocationUpdates(string3, l10, 0.0f, locationListener);
                    n10 = this.gpsTimeoutSec;
                    if (n10 <= 0) break block18;
                    object = this.handler;
                    long l11 = n10 *= 1000;
                    try {
                        object.sendEmptyMessageDelayed(n12, l11);
                    }
                    catch (Throwable throwable) {
                        object = MobLog.getInstance();
                        ((NLog)object).w(throwable);
                        Handler handler = this.handler;
                        handler.sendEmptyMessage(n12);
                    }
                }
                return;
            }
            if (n11 != 0 && (n10 = (int)((string2 = this.lm).isProviderEnabled((String)(object = "network")) ? 1 : 0)) != 0) {
                block19: {
                    this.networkRequesting = n12;
                    locationManager = this.lm;
                    String string4 = "network";
                    long l12 = 1000L;
                    LocationListener locationListener = this.listener;
                    locationManager.requestLocationUpdates(string4, l12, 0.0f, locationListener);
                    n10 = this.networkTimeoutSec;
                    if (n10 <= 0) break block19;
                    object = this.handler;
                    long l13 = n10 *= 1000;
                    try {
                        object.sendEmptyMessageDelayed(n12, l13);
                    }
                    catch (Throwable throwable) {
                        object = MobLog.getInstance();
                        ((NLog)object).w(throwable);
                        Handler handler = this.handler;
                        handler.sendEmptyMessage(n12);
                    }
                }
                return;
            }
        }
        this.quit();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void quit() {
        try {
            synchronized (this) {
                this.notifyAll();
            }
        }
        catch (Throwable throwable) {
            NLog nLog = MobLog.getInstance();
            nLog.d(throwable);
            return;
        }
        {
            Handler handler = this.handler;
            handler = handler.getLooper();
            handler.quit();
            return;
        }
    }

    public Location getLocation(Context context) {
        return this.getLocation(context, 0);
    }

    public Location getLocation(Context context, int n10) {
        return this.getLocation(context, n10, 0);
    }

    public Location getLocation(Context context, int n10, int n11) {
        return this.getLocation(context, n10, n11, true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Location getLocation(Context object, int n10, int n11, boolean bl2) {
        object = DeviceHelper.getInstance((Context)object);
        this.deviceHelper = object;
        this.gpsTimeoutSec = n10;
        this.networkTimeoutSec = n11;
        String string2 = "location";
        object = (LocationManager)((DeviceHelper)object).getSystemServiceSafe(string2);
        this.lm = object;
        if (object == null) {
            return null;
        }
        synchronized (this) {
            object = this.handler;
            n10 = 0;
            string2 = null;
            long l10 = 50;
            object.sendEmptyMessageDelayed(0, l10);
            this.wait();
        }
        object = this.res;
        if (object == null && bl2) {
            object = this.lm;
            string2 = "gps";
            object = object.getLastKnownLocation(string2);
            this.res = object;
            if (object == null) {
                object = this.lm;
                string2 = "network";
                object = object.getLastKnownLocation(string2);
                this.res = object;
            }
        }
        return this.res;
    }
}

