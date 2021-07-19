/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera.data;

public final class CameraSet$DelayTime
extends Enum {
    private static final /* synthetic */ CameraSet$DelayTime[] a;
    public static final /* enum */ CameraSet$DelayTime t_10m;
    public static final /* enum */ CameraSet$DelayTime t_1h;
    public static final /* enum */ CameraSet$DelayTime t_1m;
    public static final /* enum */ CameraSet$DelayTime t_20m;
    public static final /* enum */ CameraSet$DelayTime t_2h;
    public static final /* enum */ CameraSet$DelayTime t_2m;
    public static final /* enum */ CameraSet$DelayTime t_30m;
    public static final /* enum */ CameraSet$DelayTime t_3h;
    public static final /* enum */ CameraSet$DelayTime t_3m;
    public static final /* enum */ CameraSet$DelayTime t_4m;
    public static final /* enum */ CameraSet$DelayTime t_5h;
    public static final /* enum */ CameraSet$DelayTime t_5m;
    public static final /* enum */ CameraSet$DelayTime t_infinite;
    private String formatStr;
    private String str;
    private long time;

    static {
        CameraSet$DelayTime cameraSet$DelayTime;
        CameraSet$DelayTime cameraSet$DelayTime2;
        CameraSet$DelayTime cameraSet$DelayTime3;
        CameraSet$DelayTime cameraSet$DelayTime4;
        CameraSet$DelayTime cameraSet$DelayTime5;
        CameraSet$DelayTime cameraSet$DelayTime6;
        CameraSet$DelayTime cameraSet$DelayTime7;
        CameraSet$DelayTime cameraSet$DelayTime8;
        CameraSet$DelayTime cameraSet$DelayTime9;
        CameraSet$DelayTime cameraSet$DelayTime10;
        CameraSet$DelayTime cameraSet$DelayTime11 = cameraSet$DelayTime10;
        t_infinite = cameraSet$DelayTime10 = new CameraSet$DelayTime("t_infinite", 0, 0L, "\u221e", "\u221e");
        CameraSet$DelayTime cameraSet$DelayTime12 = cameraSet$DelayTime11;
        t_1m = cameraSet$DelayTime11 = new CameraSet$DelayTime("t_1m", 1, 60000L, "1min", "00:01:00");
        t_2m = cameraSet$DelayTime9 = new CameraSet$DelayTime("t_2m", 2, 120000L, "2min", "00:02:00");
        cameraSet$DelayTime12 = cameraSet$DelayTime8;
        t_3m = cameraSet$DelayTime8 = new CameraSet$DelayTime("t_3m", 3, 180000L, "3min", "00:03:00");
        t_4m = cameraSet$DelayTime7 = new CameraSet$DelayTime("t_4m", 4, 240000L, "4min", "00:04:00");
        cameraSet$DelayTime12 = cameraSet$DelayTime6;
        t_5m = cameraSet$DelayTime6 = new CameraSet$DelayTime("t_5m", 5, 300000L, "5min", "00:05:00");
        t_10m = cameraSet$DelayTime5 = new CameraSet$DelayTime("t_10m", 6, 600000L, "10min", "00:10:00");
        cameraSet$DelayTime12 = cameraSet$DelayTime4;
        t_20m = cameraSet$DelayTime4 = new CameraSet$DelayTime("t_20m", 7, 1200000L, "20min", "00:20:00");
        t_30m = cameraSet$DelayTime12 = new CameraSet$DelayTime("t_30m", 8, 1800000L, "30min", "00:30:00");
        CameraSet$DelayTime cameraSet$DelayTime13 = cameraSet$DelayTime3;
        t_1h = cameraSet$DelayTime3 = new CameraSet$DelayTime("t_1h", 9, 3600000L, "1h", "01:00:00");
        t_2h = cameraSet$DelayTime13 = new CameraSet$DelayTime("t_2h", 10, 0x6DDD00L, "2h", "02:00:00");
        t_3h = cameraSet$DelayTime2 = new CameraSet$DelayTime("t_3h", 11, 10800000L, "3h", "03:00:00");
        t_5h = cameraSet$DelayTime = new CameraSet$DelayTime("t_5h", 12, 18000000L, "5h", "05:00:00");
        CameraSet$DelayTime[] cameraSet$DelayTimeArray = new CameraSet$DelayTime[]{cameraSet$DelayTime10, cameraSet$DelayTime11, cameraSet$DelayTime9, cameraSet$DelayTime8, cameraSet$DelayTime7, cameraSet$DelayTime6, cameraSet$DelayTime5, cameraSet$DelayTime4, cameraSet$DelayTime12, cameraSet$DelayTime3, cameraSet$DelayTime13, cameraSet$DelayTime2, cameraSet$DelayTime};
        a = cameraSet$DelayTimeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private CameraSet$DelayTime(String string3) {
        void var6_4;
        void var5_3;
        void var2_-1;
        void var1_-1;
        this.time = (long)string2;
        this.str = var5_3;
        this.formatStr = var6_4;
    }

    public static CameraSet$DelayTime fromTime(float f10) {
        for (CameraSet$DelayTime cameraSet$DelayTime : CameraSet$DelayTime.values()) {
            long l10 = cameraSet$DelayTime.getTime();
            float f11 = l10;
            float f12 = f10 - f11;
            Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
            if (object != false) continue;
            return cameraSet$DelayTime;
        }
        return t_infinite;
    }

    public static CameraSet$DelayTime valueOf(String string2) {
        return Enum.valueOf(CameraSet$DelayTime.class, string2);
    }

    public static CameraSet$DelayTime[] values() {
        return (CameraSet$DelayTime[])a.clone();
    }

    public String getFormatStr() {
        return this.formatStr;
    }

    public String getStr() {
        return this.str;
    }

    public long getTime() {
        return this.time;
    }

    public void setFormatStr(String string2) {
        this.formatStr = string2;
    }

    public void setStr(String string2) {
        this.str = string2;
    }

    public void setTime(long l10) {
        this.time = l10;
    }
}

