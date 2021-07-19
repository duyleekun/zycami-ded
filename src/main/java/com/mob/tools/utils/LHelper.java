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
import com.mob.tools.utils.LHelper$1;
import com.mob.tools.utils.LHelper$2;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.Strings;

public class LHelper {
    private static final int CACHE_LIFE_CYCLE = 5000;
    private static final int CANCEL_GPS_LOCATING = 1;
    private static final int CANCEL_NETWORK_LOCATING = 2;
    private static final int START_LOCATING;
    private static LHelper instance;
    private Location cache;
    private int gpsTimeoutSec;
    private Handler handler;
    private LocationListener listener;
    private LocationManager lm;
    private int networkTimeoutSec;
    private long requestAt;

    private LHelper() {
        Object object = new LHelper$1(this);
        object = MobHandlerThread.newHandler("T-lct", (Handler.Callback)object);
        this.handler = object;
        object = new LHelper$2(this);
        this.listener = object;
    }

    public static /* synthetic */ void access$000(LHelper lHelper) {
        lHelper.onRequest();
    }

    public static /* synthetic */ void access$100(LHelper lHelper) {
        lHelper.onGPSTimeout();
    }

    public static /* synthetic */ void access$200(LHelper lHelper) {
        lHelper.onNetworkTimeout();
    }

    public static /* synthetic */ void access$300(LHelper lHelper) {
        lHelper.finished();
    }

    public static /* synthetic */ LocationManager access$400(LHelper lHelper) {
        return lHelper.lm;
    }

    public static /* synthetic */ Location access$502(LHelper lHelper, Location location) {
        lHelper.cache = location;
        return location;
    }

    public static /* synthetic */ long access$602(LHelper lHelper, long l10) {
        lHelper.requestAt = l10;
        return l10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void finished() {
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
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static LHelper getInstance() {
        Object object = instance;
        if (object != null) return instance;
        object = LHelper.class;
        synchronized (object) {
            LHelper lHelper = instance;
            if (lHelper != null) return instance;
            instance = lHelper = new LHelper();
            return instance;
        }
    }

    private void onGPSTimeout() {
        LocationManager locationManager = this.lm;
        if (locationManager != null) {
            Object object = this.listener;
            locationManager.removeUpdates(object);
            int n10 = this.networkTimeoutSec;
            if (n10 != 0) {
                n10 = 1;
            } else {
                n10 = 0;
                locationManager = null;
            }
            if (n10 != 0 && (n10 = (int)((locationManager = this.lm).isProviderEnabled((String)(object = "network")) ? 1 : 0)) != 0) {
                this.onRequestNetwork();
            } else {
                this.finished();
            }
        }
    }

    private void onNetworkTimeout() {
        LocationManager locationManager = this.lm;
        if (locationManager != null) {
            LocationListener locationListener = this.listener;
            locationManager.removeUpdates(locationListener);
        }
        this.finished();
    }

    private void onRequest() {
        String string2;
        String string3;
        int n10 = this.gpsTimeoutSec;
        int n11 = 1;
        LocationManager locationManager = null;
        if (n10 != 0) {
            n10 = n11;
        } else {
            n10 = 0;
            string3 = null;
        }
        int n12 = this.networkTimeoutSec;
        if (n12 == 0) {
            n11 = 0;
            string2 = null;
        }
        locationManager = this.lm;
        if (locationManager != null) {
            if (n10 != 0 && (n10 = (int)(locationManager.isProviderEnabled(string3 = "gps") ? 1 : 0)) != 0) {
                this.onRequestGps();
            } else if (n11 != 0 && (n10 = (int)((string3 = this.lm).isProviderEnabled(string2 = "network") ? 1 : 0)) != 0) {
                this.onRequestNetwork();
            } else {
                this.finished();
            }
        } else {
            this.finished();
        }
    }

    private void onRequestGps() {
        block17: {
            int n10 = 1;
            LocationManager locationManager = this.lm;
            int n11 = 124;
            Object object = Strings.getString(n11);
            int n12 = 4;
            Object[] objectArray = new Object[n12];
            int n13 = 122;
            String string2 = Strings.getString(n13);
            Class<Number> clazz = null;
            objectArray[0] = string2;
            n13 = 1000;
            Object object2 = n13;
            objectArray[n10] = object2;
            object2 = 0;
            int n14 = 2;
            objectArray[n14] = object2;
            object2 = this.listener;
            int n15 = 3;
            objectArray[n15] = object2;
            Class[] classArray = new Class[n12];
            object2 = String.class;
            classArray[0] = object2;
            clazz = Long.TYPE;
            classArray[n10] = clazz;
            clazz = Float.TYPE;
            classArray[n14] = clazz;
            clazz = LocationListener.class;
            classArray[n15] = clazz;
            ReflectHelper.invokeInstanceMethod((Object)locationManager, (String)object, objectArray, classArray);
            int n16 = this.gpsTimeoutSec;
            if (n16 <= 0) break block17;
            object = this.handler;
            long l10 = n16 *= n13;
            try {
                object.sendEmptyMessageDelayed(n10, l10);
            }
            catch (Throwable throwable) {
                object = MobLog.getInstance();
                ((NLog)object).w(throwable);
                Handler handler = this.handler;
                handler.sendEmptyMessage(n10);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Location onRequestLastKnown() {
        Object object;
        Object object3;
        block4: {
            int n11;
            Object[] objectArray;
            int n10;
            object3 = null;
            try {
                object = this.lm;
                n10 = 121;
                objectArray = Strings.getString(n10);
                n11 = 1;
                Object[] objectArray2 = new Object[n11];
                int n12 = 122;
                String string2 = Strings.getString(n12);
                objectArray2[0] = string2;
                object = ReflectHelper.invokeInstanceMethod(object, (String)objectArray, objectArray2);
                object = (Location)object;
                if (object != null) return object;
            }
            catch (Throwable throwable) {
                object = null;
                object3 = throwable;
                break block4;
            }
            try {
                object3 = this.lm;
                String object2 = Strings.getString(n10);
                objectArray = new Object[n11];
                n11 = 123;
                String string2 = Strings.getString(n11);
                objectArray[0] = string2;
                object3 = ReflectHelper.invokeInstanceMethod(object3, object2, objectArray);
                object3 = (Location)object3;
                return object3;
            }
            catch (Throwable throwable) {}
        }
        NLog nLog = MobLog.getInstance();
        nLog.w((Throwable)object3);
        return object;
    }

    private void onRequestNetwork() {
        block17: {
            int n10 = 2;
            LocationManager locationManager = this.lm;
            int n11 = 124;
            Object object = Strings.getString(n11);
            int n12 = 4;
            Object[] objectArray = new Object[n12];
            int n13 = 123;
            String string2 = Strings.getString(n13);
            Class<Number> clazz = null;
            objectArray[0] = string2;
            n13 = 1000;
            Object object2 = n13;
            int n14 = 1;
            objectArray[n14] = object2;
            object2 = 0;
            objectArray[n10] = object2;
            object2 = this.listener;
            int n15 = 3;
            objectArray[n15] = object2;
            Class[] classArray = new Class[n12];
            object2 = String.class;
            classArray[0] = object2;
            clazz = Long.TYPE;
            classArray[n14] = clazz;
            clazz = Float.TYPE;
            classArray[n10] = clazz;
            clazz = LocationListener.class;
            classArray[n15] = clazz;
            ReflectHelper.invokeInstanceMethod((Object)locationManager, (String)object, objectArray, classArray);
            int n16 = this.networkTimeoutSec;
            if (n16 <= 0) break block17;
            object = this.handler;
            long l10 = n16 *= n13;
            try {
                object.sendEmptyMessageDelayed(n10, l10);
            }
            catch (Throwable throwable) {
                object = MobLog.getInstance();
                ((NLog)object).w(throwable);
                Handler handler = this.handler;
                handler.sendEmptyMessage(n10);
            }
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private Location quickResponse(boolean object) {
        if (object != 0) return null;
        Location location = this.cache;
        if (location == null) return null;
        long l10 = System.currentTimeMillis();
        long l11 = this.requestAt;
        long l12 = (l10 -= l11) - (l11 = 5000L);
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 > 0) return null;
        return this.cache;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Location requestLocation(Context object, int n10, int n11, boolean bl2) {
        Object object2;
        Location location = null;
        try {
            object = DeviceHelper.getInstance((Context)object);
            String string2 = "android.permission.ACCESS_FINE_LOCATION";
            boolean bl3 = ((DeviceHelper)object).checkPermission(string2);
            if (!bl3) return location;
            this.gpsTimeoutSec = n10;
            this.networkTimeoutSec = n11;
            object2 = this.lm;
            if (object2 == null) {
                object2 = "location";
                object = ((DeviceHelper)object).getSystemServiceSafe((String)object2);
                object = (LocationManager)object;
                this.lm = object;
            }
            if ((object = this.lm) == null) {
                return null;
            }
            synchronized (this) {
                object = this.handler;
                n10 = 0;
                object2 = null;
            }
        }
        catch (Throwable throwable) {
            object2 = MobLog.getInstance();
            ((NLog)object2).d(throwable);
            return location;
        }
        {
            long l10 = 50;
            object.sendEmptyMessageDelayed(0, l10);
            this.wait();
        }
        {
            long l11;
            object = this.cache;
            if (object != null) return this.cache;
            if (!bl2) return this.cache;
            object = this.onRequestLastKnown();
            this.cache = object;
            this.requestAt = l11 = System.currentTimeMillis();
            return this.cache;
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

    public Location getLocation(Context context, int n10, int n11, boolean bl2) {
        return this.getLocation(context, n10, n11, bl2, false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Location getLocation(Context context, int n10, int n11, boolean bl2, boolean bl3) {
        Location location = this.quickResponse(bl3);
        if (location != null) return location;
        Class<LHelper> clazz = LHelper.class;
        synchronized (clazz) {
            Location location2 = this.quickResponse(bl3);
            if (location2 != null) return location2;
            context = this.requestLocation(context, n10, n11, bl2);
            return context;
        }
    }
}

