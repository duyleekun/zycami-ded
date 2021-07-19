/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera.data;

public final class CameraSet$Theme
extends Enum {
    public static final /* enum */ CameraSet$Theme DEFAULT;
    public static final /* enum */ CameraSet$Theme PEARL;
    public static final /* enum */ CameraSet$Theme PINK;
    private static final /* synthetic */ CameraSet$Theme[] a;
    private int drawableRes;
    private int id;
    private String skinName;
    private int stringRes;

    static {
        CameraSet$Theme cameraSet$Theme;
        CameraSet$Theme cameraSet$Theme2;
        CameraSet$Theme cameraSet$Theme3 = cameraSet$Theme2;
        DEFAULT = cameraSet$Theme2 = new CameraSet$Theme("DEFAULT", 0, 0, "", 2131951821, 2131232231);
        PINK = cameraSet$Theme3 = new CameraSet$Theme("PINK", 1, 1, "pink", 2131951823, 2131232233);
        PEARL = cameraSet$Theme = new CameraSet$Theme("PEARL", 2, 2, "pearl", 2131951822, 2131232232);
        CameraSet$Theme[] cameraSet$ThemeArray = new CameraSet$Theme[]{cameraSet$Theme2, cameraSet$Theme3, cameraSet$Theme};
        a = cameraSet$ThemeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private CameraSet$Theme(int n11, int n12) {
        void var6_4;
        void var5_3;
        void var2_-1;
        void var1_-1;
        this.id = n11;
        this.skinName = (String)n12;
        this.stringRes = var5_3;
        this.drawableRes = var6_4;
    }

    public static CameraSet$Theme fromId(int n10) {
        for (CameraSet$Theme cameraSet$Theme : CameraSet$Theme.values()) {
            int n11 = cameraSet$Theme.getId();
            if (n10 != n11) continue;
            return cameraSet$Theme;
        }
        return DEFAULT;
    }

    public static CameraSet$Theme valueOf(String string2) {
        return Enum.valueOf(CameraSet$Theme.class, string2);
    }

    public static CameraSet$Theme[] values() {
        return (CameraSet$Theme[])a.clone();
    }

    public int getDrawableRes() {
        return this.drawableRes;
    }

    public int getId() {
        return this.id;
    }

    public String getSkinName() {
        return this.skinName;
    }

    public int getStringRes() {
        return this.stringRes;
    }

    public void setDrawableRes(int n10) {
        this.drawableRes = n10;
    }

    public void setId(int n10) {
        this.id = n10;
    }

    public void setSkinName(String string2) {
        this.skinName = string2;
    }

    public void setStringRes(int n10) {
        this.stringRes = n10;
    }
}

