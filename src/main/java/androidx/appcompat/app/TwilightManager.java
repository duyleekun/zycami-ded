/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.location.Location
 *  android.location.LocationManager
 *  android.util.Log
 */
package androidx.appcompat.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import androidx.appcompat.app.TwilightCalculator;
import androidx.appcompat.app.TwilightManager$TwilightState;
import androidx.core.content.PermissionChecker;
import java.util.Calendar;

public class TwilightManager {
    private static final int SUNRISE = 6;
    private static final int SUNSET = 22;
    private static final String TAG = "TwilightManager";
    private static TwilightManager sInstance;
    private final Context mContext;
    private final LocationManager mLocationManager;
    private final TwilightManager$TwilightState mTwilightState;

    public TwilightManager(Context context, LocationManager locationManager) {
        TwilightManager$TwilightState twilightManager$TwilightState;
        this.mTwilightState = twilightManager$TwilightState = new TwilightManager$TwilightState();
        this.mContext = context;
        this.mLocationManager = locationManager;
    }

    public static TwilightManager getInstance(Context context) {
        TwilightManager twilightManager = sInstance;
        if (twilightManager == null) {
            context = context.getApplicationContext();
            LocationManager locationManager = (LocationManager)context.getSystemService("location");
            sInstance = twilightManager = new TwilightManager(context, locationManager);
        }
        return sInstance;
    }

    private Location getLastKnownLocation() {
        Context context = this.mContext;
        int n10 = PermissionChecker.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION");
        Location location = null;
        if (n10 == 0) {
            context = this.getLastKnownLocationForProvider("network");
        } else {
            n10 = 0;
            context = null;
        }
        Context context2 = this.mContext;
        String string2 = "android.permission.ACCESS_FINE_LOCATION";
        int n11 = PermissionChecker.checkSelfPermission(context2, string2);
        if (n11 == 0) {
            location = this.getLastKnownLocationForProvider("gps");
        }
        if (location != null && context != null) {
            long l10;
            long l11 = location.getTime();
            long l12 = l11 - (l10 = context.getTime());
            n11 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (n11 > 0) {
                context = location;
            }
            return context;
        }
        if (location != null) {
            context = location;
        }
        return context;
    }

    private Location getLastKnownLocationForProvider(String string2) {
        block5: {
            Object object = this.mLocationManager;
            boolean bl2 = object.isProviderEnabled(string2);
            if (!bl2) break block5;
            object = this.mLocationManager;
            try {
                return object.getLastKnownLocation(string2);
            }
            catch (Exception exception) {
                object = TAG;
                String string3 = "Failed to get last known location";
                Log.d((String)object, (String)string3, (Throwable)exception);
            }
        }
        return null;
    }

    private boolean isStateValid() {
        TwilightManager$TwilightState twilightManager$TwilightState = this.mTwilightState;
        long l10 = twilightManager$TwilightState.nextUpdate;
        long l11 = System.currentTimeMillis();
        long l12 = l10 - l11;
        long l13 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (l13 > 0) {
            l13 = 1;
        } else {
            l13 = 0;
            twilightManager$TwilightState = null;
        }
        return (boolean)l13;
    }

    public static void setInstance(TwilightManager twilightManager) {
        sInstance = twilightManager;
    }

    private void updateState(Location location) {
        long l10;
        TwilightManager$TwilightState twilightManager$TwilightState = this.mTwilightState;
        long l11 = System.currentTimeMillis();
        TwilightCalculator twilightCalculator = TwilightCalculator.getInstance();
        long l12 = 86400000L;
        long l13 = l11 - l12;
        double d10 = location.getLatitude();
        double d11 = location.getLongitude();
        twilightCalculator.calculateTwilight(l13, d10, d11);
        long l14 = twilightCalculator.sunset;
        d10 = location.getLatitude();
        d11 = location.getLongitude();
        l13 = l11;
        twilightCalculator.calculateTwilight(l11, d10, d11);
        int n10 = twilightCalculator.state;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        long l15 = twilightCalculator.sunrise;
        l13 = twilightCalculator.sunset;
        double d12 = location.getLatitude();
        double d13 = location.getLongitude();
        long l16 = l14;
        l14 = l13;
        l13 = l12 += l11;
        l12 = l15;
        d10 = d12;
        int n12 = n11;
        d11 = d13;
        twilightCalculator.calculateTwilight(l13, d12, d13);
        long l17 = twilightCalculator.sunrise;
        long l18 = 0L;
        long l19 = -1;
        long l20 = l15 == l19 ? 0 : (l15 < l19 ? -1 : 1);
        if (l20 != false && (l10 = l14 == l19 ? 0 : (l14 < l19 ? -1 : 1)) != false) {
            l10 = l11 == l14 ? 0 : (l11 < l14 ? -1 : 1);
            l18 = l10 > 0 ? (l18 += l17) : ((l10 = l11 == l15 ? 0 : (l11 < l15 ? -1 : 1)) > 0 ? (l18 += l14) : (l18 += l15));
            l19 = 60000L;
            l18 += l19;
        } else {
            l18 = 43200000L + l11;
        }
        twilightManager$TwilightState.isNight = n12;
        l19 = l16;
        twilightManager$TwilightState.yesterdaySunset = l16;
        twilightManager$TwilightState.todaySunrise = l12;
        twilightManager$TwilightState.todaySunset = l14;
        twilightManager$TwilightState.tomorrowSunrise = l17;
        twilightManager$TwilightState.nextUpdate = l18;
    }

    /*
     * WARNING - void declaration
     */
    public boolean isNight() {
        void var4_9;
        int n10;
        Object object = this.mTwilightState;
        boolean bl2 = this.isStateValid();
        if (bl2) {
            return ((TwilightManager$TwilightState)object).isNight;
        }
        Object object2 = this.getLastKnownLocation();
        if (object2 != null) {
            this.updateState((Location)object2);
            return ((TwilightManager$TwilightState)object).isNight;
        }
        object2 = "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.";
        Log.i((String)TAG, (String)object2);
        object = Calendar.getInstance();
        int n11 = ((Calendar)object).get(11);
        int n12 = 6;
        if (n11 >= n12 && n11 < (n10 = 22)) {
            boolean bl3 = false;
            object = null;
        } else {
            boolean bl4 = true;
        }
        return (boolean)var4_9;
    }
}

