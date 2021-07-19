/*
 * Decompiled with CFR 0.151.
 */
package androidx.appcompat.app;

public class TwilightCalculator {
    private static final float ALTIDUTE_CORRECTION_CIVIL_TWILIGHT = -0.10471976f;
    private static final float C1 = 0.0334196f;
    private static final float C2 = 3.49066E-4f;
    private static final float C3 = 5.236E-6f;
    public static final int DAY = 0;
    private static final float DEGREES_TO_RADIANS = (float)Math.PI / 180;
    private static final float J0 = 9.0E-4f;
    public static final int NIGHT = 1;
    private static final float OBLIQUITY = 0.4092797f;
    private static final long UTC_2000 = 946728000000L;
    private static TwilightCalculator sInstance;
    public int state;
    public long sunrise;
    public long sunset;

    public static TwilightCalculator getInstance() {
        TwilightCalculator twilightCalculator = sInstance;
        if (twilightCalculator == null) {
            sInstance = twilightCalculator = new TwilightCalculator();
        }
        return sInstance;
    }

    public void calculateTwilight(long l10, double d10, double d11) {
        long l11;
        TwilightCalculator twilightCalculator = this;
        long l12 = 946728000000L;
        long l13 = l10 - l12;
        float f10 = (float)l13 / 8.64E7f;
        float f11 = 0.01720197f * f10;
        float f12 = 6.24006f;
        double d12 = f11 += f12;
        double d13 = Math.sin(d12) * (double)0.0334196f + d12;
        double d14 = Math.sin(2.0f * f11) * 3.4906598739326E-4;
        d13 += d14;
        float f13 = 3.0f;
        d14 = Math.sin(f11 * f13) * (double)5.236E-6f;
        d13 = d13 + d14 + 1.796593063 + Math.PI;
        d14 = d11;
        d14 = -d11 / 360.0;
        f11 = 9.0E-4f;
        long l14 = Math.round((double)(f10 - f11) - d14);
        f10 = (float)l14 + f11;
        double d15 = (double)f10 + d14;
        d12 = Math.sin(d12) * 0.0053;
        d15 += d12;
        d12 = Math.sin(2.0 * d13) * -0.0069;
        d15 += d12;
        d12 = Math.sin(d13);
        d13 = Math.sin(0.4092797040939331);
        d12 = Math.asin(d12 * d13);
        d13 = 0.01745329238474369 * d10;
        long l15 = -4631161762379464704L;
        d14 = Math.sin(-0.10471975803375244);
        double d16 = Math.sin(d13);
        double d17 = Math.sin(d12);
        d14 -= (d16 *= d17);
        d13 = Math.cos(d13);
        d12 = Math.cos(d12);
        d14 /= (d13 *= d12);
        d12 = 1.0;
        double d18 = d14 == d12 ? 0 : (d14 > d12 ? 1 : -1);
        int n10 = 1;
        long l16 = -1;
        d13 = 0.0 / 0.0;
        if (d18 >= 0) {
            this.state = n10;
            this.sunset = l16;
            this.sunrise = l16;
            return;
        }
        l14 = -4616189618054758400L;
        d16 = -1.0;
        double d19 = d14 - d16;
        d18 = d19 == 0.0 ? 0 : (d19 < 0.0 ? -1 : 1);
        if (d18 <= 0) {
            this.state = 0;
            this.sunset = l16;
            this.sunrise = l16;
            return;
        }
        f12 = (float)(Math.acos(d14) / (Math.PI * 2));
        d13 = f12;
        d14 = d15 + d13;
        double d20 = 8.64E7;
        this.sunset = l15 = Math.round(d14 *= d20) + l12;
        d15 = (d15 - d13) * d20;
        this.sunrise = l13 = Math.round(d15) + l12;
        long l17 = l13 == l10 ? 0 : (l13 < l10 ? -1 : 1);
        if (l17 < 0 && (l17 = (l11 = (l12 = this.sunset) - l10) == 0L ? 0 : (l11 < 0L ? -1 : 1)) > 0) {
            this.state = 0;
        } else {
            twilightCalculator.state = n10;
        }
    }
}

