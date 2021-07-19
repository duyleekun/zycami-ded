/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl.utils;

import androidx.camera.core.impl.utils.Exif$Speed$Converter;

public final class Exif$Speed {
    private Exif$Speed() {
    }

    public static Exif$Speed$Converter fromKilometersPerHour(double d10) {
        Exif$Speed$Converter exif$Speed$Converter = new Exif$Speed$Converter(d10 *= 0.621371);
        return exif$Speed$Converter;
    }

    public static Exif$Speed$Converter fromKnots(double d10) {
        Exif$Speed$Converter exif$Speed$Converter = new Exif$Speed$Converter(d10 *= 1.15078);
        return exif$Speed$Converter;
    }

    public static Exif$Speed$Converter fromMetersPerSecond(double d10) {
        Exif$Speed$Converter exif$Speed$Converter = new Exif$Speed$Converter(d10 *= 2.23694);
        return exif$Speed$Converter;
    }

    public static Exif$Speed$Converter fromMilesPerHour(double d10) {
        Exif$Speed$Converter exif$Speed$Converter = new Exif$Speed$Converter(d10);
        return exif$Speed$Converter;
    }
}

