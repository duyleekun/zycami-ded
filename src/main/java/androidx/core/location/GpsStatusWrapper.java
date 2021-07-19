/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.location.GpsSatellite
 *  android.location.GpsStatus
 *  android.os.Build$VERSION
 */
package androidx.core.location;

import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.os.Build;
import androidx.core.location.GnssStatusCompat;
import androidx.core.util.Preconditions;
import java.util.Iterator;

public class GpsStatusWrapper
extends GnssStatusCompat {
    private static final int BEIDOU_PRN_COUNT = 35;
    private static final int BEIDOU_PRN_OFFSET = 200;
    private static final int GLONASS_PRN_COUNT = 24;
    private static final int GLONASS_PRN_OFFSET = 64;
    private static final int GPS_PRN_COUNT = 32;
    private static final int GPS_PRN_OFFSET = 0;
    private static final int QZSS_SVID_MAX = 200;
    private static final int QZSS_SVID_MIN = 193;
    private static final int SBAS_PRN_MAX = 64;
    private static final int SBAS_PRN_MIN = 33;
    private static final int SBAS_PRN_OFFSET = 169;
    private Iterator mCachedIterator;
    private int mCachedIteratorPosition;
    private GpsSatellite mCachedSatellite;
    private int mCachedSatelliteCount;
    private final GpsStatus mWrapped;

    public GpsStatusWrapper(GpsStatus object) {
        int n10;
        this.mWrapped = object = (GpsStatus)Preconditions.checkNotNull(object);
        this.mCachedSatelliteCount = n10 = -1;
        object = object.getSatellites().iterator();
        this.mCachedIterator = object;
        this.mCachedIteratorPosition = n10;
        this.mCachedSatellite = null;
    }

    private static int getConstellationFromPrn(int n10) {
        int n11;
        if (n10 > 0 && n10 <= (n11 = 32)) {
            return 1;
        }
        n11 = 33;
        int n12 = 64;
        if (n10 >= n11 && n10 <= n12) {
            return 2;
        }
        if (n10 > n12 && n10 <= (n11 = 88)) {
            return 3;
        }
        n11 = 200;
        if (n10 > n11 && n10 <= (n12 = 235)) {
            return 5;
        }
        n12 = 193;
        if (n10 >= n12 && n10 <= n11) {
            return 4;
        }
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private GpsSatellite getSatellite(int n10) {
        GpsStatus gpsStatus = this.mWrapped;
        synchronized (gpsStatus) {
            GpsSatellite gpsSatellite;
            Object object;
            int n11 = this.mCachedIteratorPosition;
            if (n10 < n11) {
                object = this.mWrapped;
                object = object.getSatellites();
                object = object.iterator();
                this.mCachedIterator = object;
                this.mCachedIteratorPosition = n11 = -1;
            }
            while ((n11 = this.mCachedIteratorPosition) < n10) {
                this.mCachedIteratorPosition = ++n11;
                object = this.mCachedIterator;
                n11 = (int)(object.hasNext() ? 1 : 0);
                if (n11 == 0) {
                    n10 = 0;
                    gpsSatellite = null;
                    this.mCachedSatellite = null;
                    break;
                }
                object = this.mCachedIterator;
                object = object.next();
                object = (GpsSatellite)object;
                this.mCachedSatellite = object;
            }
            gpsSatellite = this.mCachedSatellite;
            return (GpsSatellite)Preconditions.checkNotNull(gpsSatellite);
        }
    }

    private static int getSvidFromPrn(int n10) {
        int n11;
        int n12 = GpsStatusWrapper.getConstellationFromPrn(n10);
        if (n12 != (n11 = 2)) {
            n11 = 3;
            if (n12 != n11) {
                n11 = 5;
                if (n12 == n11) {
                    n10 += -200;
                }
            } else {
                n10 += -64;
            }
        } else {
            n10 += 87;
        }
        return n10;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        boolean bl2 = object instanceof GpsStatusWrapper;
        if (!bl2) {
            return false;
        }
        object = (GpsStatusWrapper)object;
        GpsStatus gpsStatus = this.mWrapped;
        object = ((GpsStatusWrapper)object).mWrapped;
        return gpsStatus.equals(object);
    }

    public float getAzimuthDegrees(int n10) {
        return this.getSatellite(n10).getAzimuth();
    }

    public float getBasebandCn0DbHz(int n10) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public float getCarrierFrequencyHz(int n10) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public float getCn0DbHz(int n10) {
        return this.getSatellite(n10).getSnr();
    }

    public int getConstellationType(int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 24;
        if (n11 < n12) {
            return 1;
        }
        return GpsStatusWrapper.getConstellationFromPrn(this.getSatellite(n10).getPrn());
    }

    public float getElevationDegrees(int n10) {
        return this.getSatellite(n10).getElevation();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int getSatelliteCount() {
        GpsStatus gpsStatus = this.mWrapped;
        synchronized (gpsStatus) {
            int n10 = this.mCachedSatelliteCount;
            int n11 = -1;
            if (n10 != n11) return this.mCachedSatelliteCount;
            Object object = this.mWrapped;
            object = object.getSatellites();
            object = object.iterator();
            while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                Object object2 = object.next();
                object2 = (GpsSatellite)object2;
                this.mCachedSatelliteCount = n11 = this.mCachedSatelliteCount + 1;
            }
            this.mCachedSatelliteCount = n10 = this.mCachedSatelliteCount + 1;
            return this.mCachedSatelliteCount;
        }
    }

    public int getSvid(int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 24;
        if (n11 < n12) {
            return this.getSatellite(n10).getPrn();
        }
        return GpsStatusWrapper.getSvidFromPrn(this.getSatellite(n10).getPrn());
    }

    public boolean hasAlmanacData(int n10) {
        return this.getSatellite(n10).hasAlmanac();
    }

    public boolean hasBasebandCn0DbHz(int n10) {
        return false;
    }

    public boolean hasCarrierFrequencyHz(int n10) {
        return false;
    }

    public boolean hasEphemerisData(int n10) {
        return this.getSatellite(n10).hasEphemeris();
    }

    public int hashCode() {
        return this.mWrapped.hashCode();
    }

    public boolean usedInFix(int n10) {
        return this.getSatellite(n10).usedInFix();
    }
}

