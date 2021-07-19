/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.location.GnssStatus
 *  android.location.GpsStatus
 */
package androidx.core.location;

import android.location.GnssStatus;
import android.location.GpsStatus;
import androidx.core.location.GnssStatusWrapper;
import androidx.core.location.GpsStatusWrapper;

public abstract class GnssStatusCompat {
    public static final int CONSTELLATION_BEIDOU = 5;
    public static final int CONSTELLATION_GALILEO = 6;
    public static final int CONSTELLATION_GLONASS = 3;
    public static final int CONSTELLATION_GPS = 1;
    public static final int CONSTELLATION_IRNSS = 7;
    public static final int CONSTELLATION_QZSS = 4;
    public static final int CONSTELLATION_SBAS = 2;
    public static final int CONSTELLATION_UNKNOWN;

    public static GnssStatusCompat wrap(GnssStatus gnssStatus) {
        GnssStatusWrapper gnssStatusWrapper = new GnssStatusWrapper(gnssStatus);
        return gnssStatusWrapper;
    }

    public static GnssStatusCompat wrap(GpsStatus gpsStatus) {
        GpsStatusWrapper gpsStatusWrapper = new GpsStatusWrapper(gpsStatus);
        return gpsStatusWrapper;
    }

    public abstract float getAzimuthDegrees(int var1);

    public abstract float getBasebandCn0DbHz(int var1);

    public abstract float getCarrierFrequencyHz(int var1);

    public abstract float getCn0DbHz(int var1);

    public abstract int getConstellationType(int var1);

    public abstract float getElevationDegrees(int var1);

    public abstract int getSatelliteCount();

    public abstract int getSvid(int var1);

    public abstract boolean hasAlmanacData(int var1);

    public abstract boolean hasBasebandCn0DbHz(int var1);

    public abstract boolean hasCarrierFrequencyHz(int var1);

    public abstract boolean hasEphemerisData(int var1);

    public abstract boolean usedInFix(int var1);
}

