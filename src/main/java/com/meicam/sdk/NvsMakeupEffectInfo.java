/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsArbitraryData;
import com.meicam.sdk.NvsMakeupEffectInfo$MakeupEffect;
import java.util.ArrayList;
import java.util.List;

public class NvsMakeupEffectInfo
extends NvsArbitraryData {
    public static final int MAKEUP_EFFECT_BLENDING_MODE_ADD = 4;
    public static final int MAKEUP_EFFECT_BLENDING_MODE_EXCLUSION = 5;
    public static final int MAKEUP_EFFECT_BLENDING_MODE_MULTIPLY = 1;
    public static final int MAKEUP_EFFECT_BLENDING_MODE_NORMAL = 0;
    public static final int MAKEUP_EFFECT_BLENDING_MODE_SCREEN = 3;
    public static final int MAKEUP_EFFECT_BLENDING_MODE_SUBTRACT = 2;
    public static final int MAKEUP_EFFECT_BLENDING_MODE_UNKNOWN = 255;
    public static final int MAKEUP_EFFECT_CUSTOM_ENABLED_FLAG_ALL = 255;
    public static final int MAKEUP_EFFECT_CUSTOM_ENABLED_FLAG_BLUSHER = 32;
    public static final int MAKEUP_EFFECT_CUSTOM_ENABLED_FLAG_BRIGHTEN = 128;
    public static final int MAKEUP_EFFECT_CUSTOM_ENABLED_FLAG_EYEBROW = 2;
    public static final int MAKEUP_EFFECT_CUSTOM_ENABLED_FLAG_EYELASH = 8;
    public static final int MAKEUP_EFFECT_CUSTOM_ENABLED_FLAG_EYELINER = 16;
    public static final int MAKEUP_EFFECT_CUSTOM_ENABLED_FLAG_EYESHADOW = 4;
    public static final int MAKEUP_EFFECT_CUSTOM_ENABLED_FLAG_LIP = 1;
    public static final int MAKEUP_EFFECT_CUSTOM_ENABLED_FLAG_NONE = 0;
    public static final int MAKEUP_EFFECT_CUSTOM_ENABLED_FLAG_SHADOW = 64;
    public static final int MAKEUP_EFFECT_LAYER_TYPE_3D = 0;
    public static final int MAKEUP_EFFECT_LAYER_TYPE_HIGHLIGHT = 2;
    public static final int MAKEUP_EFFECT_LAYER_TYPE_LUT = 1;
    private List makeupEffectArray;

    public NvsMakeupEffectInfo() {
        ArrayList arrayList;
        this.makeupEffectArray = arrayList = new ArrayList();
    }

    public void addMakeupEffect(NvsMakeupEffectInfo$MakeupEffect nvsMakeupEffectInfo$MakeupEffect) {
        this.makeupEffectArray.add(nvsMakeupEffectInfo$MakeupEffect);
    }

    public List getMakeupEffectArray() {
        return this.makeupEffectArray;
    }

    public void removeMakeupEffectByIndex(int n10) {
        List list;
        int n11;
        if (n10 >= 0 && n10 < (n11 = (list = this.makeupEffectArray).size())) {
            list = this.makeupEffectArray;
            list.remove(n10);
        }
    }
}

