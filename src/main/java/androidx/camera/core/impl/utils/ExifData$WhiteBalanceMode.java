/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl.utils;

public final class ExifData$WhiteBalanceMode
extends Enum {
    private static final /* synthetic */ ExifData$WhiteBalanceMode[] $VALUES;
    public static final /* enum */ ExifData$WhiteBalanceMode AUTO;
    public static final /* enum */ ExifData$WhiteBalanceMode MANUAL;

    static {
        ExifData$WhiteBalanceMode exifData$WhiteBalanceMode;
        ExifData$WhiteBalanceMode exifData$WhiteBalanceMode2;
        AUTO = exifData$WhiteBalanceMode2 = new ExifData$WhiteBalanceMode("AUTO", 0);
        int n10 = 1;
        MANUAL = exifData$WhiteBalanceMode = new ExifData$WhiteBalanceMode("MANUAL", n10);
        ExifData$WhiteBalanceMode[] exifData$WhiteBalanceModeArray = new ExifData$WhiteBalanceMode[2];
        exifData$WhiteBalanceModeArray[0] = exifData$WhiteBalanceMode2;
        exifData$WhiteBalanceModeArray[n10] = exifData$WhiteBalanceMode;
        $VALUES = exifData$WhiteBalanceModeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ExifData$WhiteBalanceMode() {
        void var2_-1;
        void var1_-1;
    }

    public static ExifData$WhiteBalanceMode valueOf(String string2) {
        return Enum.valueOf(ExifData$WhiteBalanceMode.class, string2);
    }

    public static ExifData$WhiteBalanceMode[] values() {
        return (ExifData$WhiteBalanceMode[])$VALUES.clone();
    }
}

