/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera.data;

public final class CameraSet$Panorama
extends Enum {
    public static final /* enum */ CameraSet$Panorama P_180;
    public static final /* enum */ CameraSet$Panorama P_240;
    public static final /* enum */ CameraSet$Panorama P_3x3;
    public static final /* enum */ CameraSet$Panorama P_CLONE;
    private static final /* synthetic */ CameraSet$Panorama[] a;
    private int drawableRes;
    private String text;

    static {
        CameraSet$Panorama cameraSet$Panorama;
        CameraSet$Panorama cameraSet$Panorama2;
        CameraSet$Panorama cameraSet$Panorama3;
        CameraSet$Panorama cameraSet$Panorama4;
        P_CLONE = cameraSet$Panorama4 = new CameraSet$Panorama("P_CLONE", 0, "Clone", 2131231944);
        int n10 = 1;
        P_3x3 = cameraSet$Panorama3 = new CameraSet$Panorama("P_3x3", n10, "3x3", 2131231941);
        int n11 = 2;
        P_240 = cameraSet$Panorama2 = new CameraSet$Panorama("P_240", n11, "240\u00b0", 2131231938);
        int n12 = 3;
        P_180 = cameraSet$Panorama = new CameraSet$Panorama("P_180", n12, "180\u00b0", 2131231935);
        CameraSet$Panorama[] cameraSet$PanoramaArray = new CameraSet$Panorama[4];
        cameraSet$PanoramaArray[0] = cameraSet$Panorama4;
        cameraSet$PanoramaArray[n10] = cameraSet$Panorama3;
        cameraSet$PanoramaArray[n11] = cameraSet$Panorama2;
        cameraSet$PanoramaArray[n12] = cameraSet$Panorama;
        a = cameraSet$PanoramaArray;
    }

    /*
     * WARNING - void declaration
     */
    private CameraSet$Panorama() {
        void var4_2;
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.text = var3_1;
        this.drawableRes = var4_2;
    }

    public static CameraSet$Panorama fromText(String string2) {
        CameraSet$Panorama cameraSet$Panorama = P_240;
        String string3 = cameraSet$Panorama.getText();
        boolean bl2 = string3.equals(string2);
        if (bl2) {
            return cameraSet$Panorama;
        }
        cameraSet$Panorama = P_3x3;
        string3 = cameraSet$Panorama.getText();
        bl2 = string3.equals(string2);
        if (bl2) {
            return cameraSet$Panorama;
        }
        cameraSet$Panorama = P_CLONE;
        string3 = cameraSet$Panorama.getText();
        boolean bl3 = string3.equals(string2);
        if (bl3) {
            return cameraSet$Panorama;
        }
        return P_180;
    }

    public static CameraSet$Panorama valueOf(String string2) {
        return Enum.valueOf(CameraSet$Panorama.class, string2);
    }

    public static CameraSet$Panorama[] values() {
        return (CameraSet$Panorama[])a.clone();
    }

    public int getDrawableRes() {
        return this.drawableRes;
    }

    public String getText() {
        return this.text;
    }

    public void setDrawableRes(int n10) {
        this.drawableRes = n10;
    }

    public void setText(String string2) {
        this.text = string2;
    }
}

