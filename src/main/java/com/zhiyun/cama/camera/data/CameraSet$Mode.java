/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera.data;

import com.zhiyun.cama.camera.data.CameraSet$a;

public final class CameraSet$Mode
extends Enum {
    private static final /* synthetic */ CameraSet$Mode[] a;
    public static final /* enum */ CameraSet$Mode delay_video;
    public static final /* enum */ CameraSet$Mode dolly_zoom;
    public static final /* enum */ CameraSet$Mode live;
    public static final /* enum */ CameraSet$Mode panorama;
    public static final /* enum */ CameraSet$Mode photograph;
    public static final /* enum */ CameraSet$Mode slow_motion;
    public static final /* enum */ CameraSet$Mode sport_delay;
    public static final /* enum */ CameraSet$Mode story;
    public static final /* enum */ CameraSet$Mode video;
    private int actionDrawableRes;
    private int drawableRes;
    private int hintRes;
    private int id;
    private boolean saveEnable = true;
    private int stringRes;

    static {
        CameraSet$Mode cameraSet$Mode;
        CameraSet$Mode cameraSet$Mode2;
        CameraSet$Mode cameraSet$Mode3;
        CameraSet$Mode cameraSet$Mode4;
        CameraSet$Mode cameraSet$Mode5;
        CameraSet$Mode cameraSet$Mode6;
        CameraSet$Mode cameraSet$Mode7 = cameraSet$Mode6;
        story = cameraSet$Mode6 = new CameraSet$Mode("story", 0, 0, 2131951820, 2131231656, 2131231876, false);
        CameraSet$Mode cameraSet$Mode8 = cameraSet$Mode7;
        panorama = cameraSet$Mode7 = new CameraSet$Mode("panorama", 1, 1, 2131951803, 2131231670, 2131231871);
        CameraSet$Mode cameraSet$Mode9 = cameraSet$Mode8;
        photograph = cameraSet$Mode8 = new CameraSet$Mode("photograph", 2, 2, 2131951809, 2131231674, 2131231872);
        video = cameraSet$Mode9 = new CameraSet$Mode("video", 3, 3, 2131951827, 2131231676, 2131231879);
        slow_motion = cameraSet$Mode5 = new CameraSet$Mode("slow_motion", 4, 4, 2131951802, 2131231675, 2131231873);
        delay_video = cameraSet$Mode4 = new CameraSet$Mode("delay_video", 5, 5, 2131951790, 2131231666, 2131231867);
        sport_delay = cameraSet$Mode3 = new CameraSet$Mode("sport_delay", 6, 6, 2131951819, 2131231668, 2131231867);
        live = cameraSet$Mode2 = new CameraSet$Mode("live", 7, 7, 2131951800, 2131231676, 2131231879, false);
        dolly_zoom = cameraSet$Mode = new CameraSet$Mode("dolly_zoom", 8, 8, 2131952323, 2131231667, 2131231879);
        CameraSet$Mode[] cameraSet$ModeArray = new CameraSet$Mode[]{cameraSet$Mode6, cameraSet$Mode7, cameraSet$Mode8, cameraSet$Mode9, cameraSet$Mode5, cameraSet$Mode4, cameraSet$Mode3, cameraSet$Mode2, cameraSet$Mode};
        a = cameraSet$ModeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private CameraSet$Mode(int n11, int n12) {
        void var6_4;
        void var5_3;
        void var2_-1;
        void var1_-1;
        this.id = n11;
        this.stringRes = n12;
        this.hintRes = n12;
        this.drawableRes = var5_3;
        this.actionDrawableRes = var6_4;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private CameraSet$Mode(int n11, int n12, int n13, boolean bl2) {
        void var8_6;
        void var7_5;
        void var2_-1;
        void var1_-1;
        this.id = n11;
        this.stringRes = n12;
        this.hintRes = n13;
        this.drawableRes = (int)(bl2 ? 1 : 0);
        this.actionDrawableRes = var7_5;
        this.saveEnable = var8_6;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private CameraSet$Mode(int n11, int n12, boolean bl2) {
        void var7_5;
        void var6_4;
        void var2_-1;
        void var1_-1;
        this.id = n11;
        this.stringRes = n12;
        this.hintRes = n12;
        this.drawableRes = (int)(bl2 ? 1 : 0);
        this.actionDrawableRes = var6_4;
        this.saveEnable = var7_5;
    }

    public static CameraSet$Mode fromId(int n10) {
        for (CameraSet$Mode cameraSet$Mode : CameraSet$Mode.values()) {
            int n11 = cameraSet$Mode.getId();
            if (n11 != n10) continue;
            return cameraSet$Mode;
        }
        return video;
    }

    public static String fromMode(CameraSet$Mode cameraSet$Mode, boolean bl2) {
        int[] nArray = CameraSet$a.a;
        int n10 = cameraSet$Mode.ordinal();
        n10 = nArray[n10];
        switch (n10) {
            default: {
                return "";
            }
            case 8: {
                return "AILive";
            }
            case 7: {
                return "HyperLapse";
            }
            case 6: {
                if (bl2) {
                    return "TimeLapse";
                }
                return "TimeLapsePath";
            }
            case 5: {
                return "SlowMotion";
            }
            case 4: {
                return "Video";
            }
            case 3: {
                return "Photo";
            }
            case 2: {
                return "Pano";
            }
            case 1: 
        }
        return "Smart";
    }

    public static CameraSet$Mode valueOf(String string2) {
        return Enum.valueOf(CameraSet$Mode.class, string2);
    }

    public static CameraSet$Mode[] values() {
        return (CameraSet$Mode[])a.clone();
    }

    public int getActionDrawableRes() {
        return this.actionDrawableRes;
    }

    public int getDrawableRes() {
        return this.drawableRes;
    }

    public int getHintRes() {
        return this.hintRes;
    }

    public int getId() {
        return this.id;
    }

    public int getStringRes() {
        return this.stringRes;
    }

    public boolean isSaveEnable() {
        return this.saveEnable;
    }

    public void setActionDrawableRes(int n10) {
        this.actionDrawableRes = n10;
    }

    public void setDrawableRes(int n10) {
        this.drawableRes = n10;
    }

    public void setHintRes(int n10) {
        this.hintRes = n10;
    }

    public void setId(int n10) {
        this.id = n10;
    }

    public void setSaveEnable(boolean bl2) {
        this.saveEnable = bl2;
    }

    public void setStringRes(int n10) {
        this.stringRes = n10;
    }
}

