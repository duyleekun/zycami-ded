/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera.data;

public final class CameraSet$CountDownTime
extends Enum {
    private static final /* synthetic */ CameraSet$CountDownTime[] a;
    public static final /* enum */ CameraSet$CountDownTime c_0;
    public static final /* enum */ CameraSet$CountDownTime c_3;
    public static final /* enum */ CameraSet$CountDownTime c_5;
    public static final /* enum */ CameraSet$CountDownTime c_7;
    private int drawableRes;
    private String text;
    private int time;

    static {
        CameraSet$CountDownTime cameraSet$CountDownTime;
        CameraSet$CountDownTime cameraSet$CountDownTime2;
        CameraSet$CountDownTime cameraSet$CountDownTime3;
        CameraSet$CountDownTime cameraSet$CountDownTime4 = cameraSet$CountDownTime3;
        c_7 = cameraSet$CountDownTime3 = new CameraSet$CountDownTime("c_7", 0, 7, "7s", 2131231407);
        c_5 = cameraSet$CountDownTime4 = new CameraSet$CountDownTime("c_5", 1, 5, "5s", 2131231405);
        c_3 = cameraSet$CountDownTime2 = new CameraSet$CountDownTime("c_3", 2, 3, "3s", 2131231403);
        c_0 = cameraSet$CountDownTime = new CameraSet$CountDownTime("c_0", 3, 0, "off", 2131231402);
        CameraSet$CountDownTime[] cameraSet$CountDownTimeArray = new CameraSet$CountDownTime[]{cameraSet$CountDownTime3, cameraSet$CountDownTime4, cameraSet$CountDownTime2, cameraSet$CountDownTime};
        a = cameraSet$CountDownTimeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private CameraSet$CountDownTime(int n11) {
        void var5_3;
        void var4_2;
        void var2_-1;
        void var1_-1;
        this.time = n11;
        this.text = var4_2;
        this.drawableRes = var5_3;
    }

    public static CameraSet$CountDownTime fromTime(int n10) {
        CameraSet$CountDownTime cameraSet$CountDownTime = c_3;
        int n11 = cameraSet$CountDownTime.getTime();
        if (n11 == n10) {
            return cameraSet$CountDownTime;
        }
        cameraSet$CountDownTime = c_5;
        n11 = cameraSet$CountDownTime.getTime();
        if (n11 == n10) {
            return cameraSet$CountDownTime;
        }
        cameraSet$CountDownTime = c_7;
        n11 = cameraSet$CountDownTime.getTime();
        if (n11 == n10) {
            return cameraSet$CountDownTime;
        }
        return c_0;
    }

    public static CameraSet$CountDownTime valueOf(String string2) {
        return Enum.valueOf(CameraSet$CountDownTime.class, string2);
    }

    public static CameraSet$CountDownTime[] values() {
        return (CameraSet$CountDownTime[])a.clone();
    }

    public int getDrawableRes() {
        return this.drawableRes;
    }

    public String getText() {
        return this.text;
    }

    public int getTime() {
        return this.time;
    }

    public void setDrawableRes(int n10) {
        this.drawableRes = n10;
    }

    public void setText(String string2) {
        this.text = string2;
    }

    public void setTime(int n10) {
        this.time = n10;
    }
}

