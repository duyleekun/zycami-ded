/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl.utils;

public final class Exif$Speed$Converter {
    public final double mMph;

    public Exif$Speed$Converter(double d10) {
        this.mMph = d10;
    }

    public double toKilometersPerHour() {
        return this.mMph / 0.621371;
    }

    public double toKnots() {
        return this.mMph / 1.15078;
    }

    public double toMetersPerSecond() {
        return this.mMph / 2.23694;
    }

    public double toMilesPerHour() {
        return this.mMph;
    }
}

