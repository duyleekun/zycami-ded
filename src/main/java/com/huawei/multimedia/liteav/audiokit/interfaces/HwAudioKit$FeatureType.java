/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.multimedia.liteav.audiokit.interfaces;

public final class HwAudioKit$FeatureType
extends Enum {
    public static final /* enum */ HwAudioKit$FeatureType HWAUDIO_FEATURE_KARAOKE;
    private static final /* synthetic */ HwAudioKit$FeatureType[] a;
    private int mFeatureType;

    static {
        HwAudioKit$FeatureType hwAudioKit$FeatureType;
        int n10 = 1;
        HWAUDIO_FEATURE_KARAOKE = hwAudioKit$FeatureType = new HwAudioKit$FeatureType("HWAUDIO_FEATURE_KARAOKE", 0, n10);
        HwAudioKit$FeatureType[] hwAudioKit$FeatureTypeArray = new HwAudioKit$FeatureType[n10];
        hwAudioKit$FeatureTypeArray[0] = hwAudioKit$FeatureType;
        a = hwAudioKit$FeatureTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private HwAudioKit$FeatureType() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.mFeatureType = var3_1;
    }

    public static HwAudioKit$FeatureType valueOf(String string2) {
        return Enum.valueOf(HwAudioKit$FeatureType.class, string2);
    }

    public static HwAudioKit$FeatureType[] values() {
        return (HwAudioKit$FeatureType[])a.clone();
    }

    public int getFeatureType() {
        return this.mFeatureType;
    }
}

