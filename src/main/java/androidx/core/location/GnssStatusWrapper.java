/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.location.GnssStatus
 *  android.os.Build$VERSION
 */
package androidx.core.location;

import android.location.GnssStatus;
import android.os.Build;
import androidx.core.location.GnssStatusCompat;
import androidx.core.util.Preconditions;

public class GnssStatusWrapper
extends GnssStatusCompat {
    private final GnssStatus mWrapped;

    public GnssStatusWrapper(GnssStatus gnssStatus) {
        this.mWrapped = gnssStatus = (GnssStatus)Preconditions.checkNotNull(gnssStatus);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        boolean bl2 = object instanceof GnssStatusWrapper;
        if (!bl2) {
            return false;
        }
        object = (GnssStatusWrapper)object;
        GnssStatus gnssStatus = this.mWrapped;
        object = ((GnssStatusWrapper)object).mWrapped;
        return gnssStatus.equals(object);
    }

    public float getAzimuthDegrees(int n10) {
        return this.mWrapped.getAzimuthDegrees(n10);
    }

    public float getBasebandCn0DbHz(int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 30;
        if (n11 >= n12) {
            return this.mWrapped.getBasebandCn0DbHz(n10);
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public float getCarrierFrequencyHz(int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 26;
        if (n11 >= n12) {
            return this.mWrapped.getCarrierFrequencyHz(n10);
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public float getCn0DbHz(int n10) {
        return this.mWrapped.getCn0DbHz(n10);
    }

    public int getConstellationType(int n10) {
        return this.mWrapped.getConstellationType(n10);
    }

    public float getElevationDegrees(int n10) {
        return this.mWrapped.getElevationDegrees(n10);
    }

    public int getSatelliteCount() {
        return this.mWrapped.getSatelliteCount();
    }

    public int getSvid(int n10) {
        return this.mWrapped.getSvid(n10);
    }

    public boolean hasAlmanacData(int n10) {
        return this.mWrapped.hasAlmanacData(n10);
    }

    public boolean hasBasebandCn0DbHz(int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 30;
        if (n11 >= n12) {
            return this.mWrapped.hasBasebandCn0DbHz(n10);
        }
        return false;
    }

    public boolean hasCarrierFrequencyHz(int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 26;
        if (n11 >= n12) {
            return this.mWrapped.hasCarrierFrequencyHz(n10);
        }
        return false;
    }

    public boolean hasEphemerisData(int n10) {
        return this.mWrapped.hasEphemerisData(n10);
    }

    public int hashCode() {
        return this.mWrapped.hashCode();
    }

    public boolean usedInFix(int n10) {
        return this.mWrapped.usedInFix(n10);
    }
}

