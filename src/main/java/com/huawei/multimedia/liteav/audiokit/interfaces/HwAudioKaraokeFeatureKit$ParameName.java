/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.multimedia.liteav.audiokit.interfaces;

public final class HwAudioKaraokeFeatureKit$ParameName
extends Enum {
    public static final /* enum */ HwAudioKaraokeFeatureKit$ParameName CMD_SET_AUDIO_EFFECT_MODE_BASE;
    public static final /* enum */ HwAudioKaraokeFeatureKit$ParameName CMD_SET_VOCAL_EQUALIZER_MODE;
    public static final /* enum */ HwAudioKaraokeFeatureKit$ParameName CMD_SET_VOCAL_VOLUME_BASE;
    private static final /* synthetic */ HwAudioKaraokeFeatureKit$ParameName[] a;
    private String mParameName;

    static {
        HwAudioKaraokeFeatureKit$ParameName hwAudioKaraokeFeatureKit$ParameName;
        HwAudioKaraokeFeatureKit$ParameName hwAudioKaraokeFeatureKit$ParameName2;
        HwAudioKaraokeFeatureKit$ParameName hwAudioKaraokeFeatureKit$ParameName3;
        CMD_SET_AUDIO_EFFECT_MODE_BASE = hwAudioKaraokeFeatureKit$ParameName3 = new HwAudioKaraokeFeatureKit$ParameName("CMD_SET_AUDIO_EFFECT_MODE_BASE", 0, "Karaoke_reverb_mode=");
        int n10 = 1;
        CMD_SET_VOCAL_VOLUME_BASE = hwAudioKaraokeFeatureKit$ParameName2 = new HwAudioKaraokeFeatureKit$ParameName("CMD_SET_VOCAL_VOLUME_BASE", n10, "Karaoke_volume=");
        int n11 = 2;
        CMD_SET_VOCAL_EQUALIZER_MODE = hwAudioKaraokeFeatureKit$ParameName = new HwAudioKaraokeFeatureKit$ParameName("CMD_SET_VOCAL_EQUALIZER_MODE", n11, "Karaoke_eq_mode=");
        HwAudioKaraokeFeatureKit$ParameName[] hwAudioKaraokeFeatureKit$ParameNameArray = new HwAudioKaraokeFeatureKit$ParameName[3];
        hwAudioKaraokeFeatureKit$ParameNameArray[0] = hwAudioKaraokeFeatureKit$ParameName3;
        hwAudioKaraokeFeatureKit$ParameNameArray[n10] = hwAudioKaraokeFeatureKit$ParameName2;
        hwAudioKaraokeFeatureKit$ParameNameArray[n11] = hwAudioKaraokeFeatureKit$ParameName;
        a = hwAudioKaraokeFeatureKit$ParameNameArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private HwAudioKaraokeFeatureKit$ParameName() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.mParameName = var3_1;
    }

    public static HwAudioKaraokeFeatureKit$ParameName valueOf(String string2) {
        return Enum.valueOf(HwAudioKaraokeFeatureKit$ParameName.class, string2);
    }

    public static HwAudioKaraokeFeatureKit$ParameName[] values() {
        return (HwAudioKaraokeFeatureKit$ParameName[])a.clone();
    }

    public String getParameName() {
        return this.mParameName;
    }
}

