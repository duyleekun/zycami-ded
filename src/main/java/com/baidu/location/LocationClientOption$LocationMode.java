/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location;

public final class LocationClientOption$LocationMode
extends Enum {
    private static final /* synthetic */ LocationClientOption$LocationMode[] $VALUES;
    public static final /* enum */ LocationClientOption$LocationMode Battery_Saving;
    public static final /* enum */ LocationClientOption$LocationMode Device_Sensors;
    public static final /* enum */ LocationClientOption$LocationMode Hight_Accuracy;

    static {
        LocationClientOption$LocationMode locationClientOption$LocationMode;
        LocationClientOption$LocationMode locationClientOption$LocationMode2;
        LocationClientOption$LocationMode locationClientOption$LocationMode3;
        Hight_Accuracy = locationClientOption$LocationMode3 = new LocationClientOption$LocationMode("Hight_Accuracy", 0);
        int n10 = 1;
        Battery_Saving = locationClientOption$LocationMode2 = new LocationClientOption$LocationMode("Battery_Saving", n10);
        int n11 = 2;
        Device_Sensors = locationClientOption$LocationMode = new LocationClientOption$LocationMode("Device_Sensors", n11);
        LocationClientOption$LocationMode[] locationClientOption$LocationModeArray = new LocationClientOption$LocationMode[3];
        locationClientOption$LocationModeArray[0] = locationClientOption$LocationMode3;
        locationClientOption$LocationModeArray[n10] = locationClientOption$LocationMode2;
        locationClientOption$LocationModeArray[n11] = locationClientOption$LocationMode;
        $VALUES = locationClientOption$LocationModeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private LocationClientOption$LocationMode() {
        void var2_-1;
        void var1_-1;
    }

    public static LocationClientOption$LocationMode valueOf(String string2) {
        return Enum.valueOf(LocationClientOption$LocationMode.class, string2);
    }

    public static LocationClientOption$LocationMode[] values() {
        return (LocationClientOption$LocationMode[])$VALUES.clone();
    }
}

