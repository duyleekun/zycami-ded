/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsColor;
import com.meicam.sdk.NvsMakeupEffectInfo$MakeupEffectLayer;
import java.util.ArrayList;
import java.util.List;

public class NvsMakeupEffectInfo$MakeupEffect {
    public NvsColor color;
    public String effectId;
    public float intensity;
    private List makeupEffectLayerArray;

    public NvsMakeupEffectInfo$MakeupEffect() {
        ArrayList arrayList;
        this.makeupEffectLayerArray = arrayList = new ArrayList();
    }

    public void addMakeupEffectLayer(NvsMakeupEffectInfo$MakeupEffectLayer nvsMakeupEffectInfo$MakeupEffectLayer) {
        this.makeupEffectLayerArray.add(nvsMakeupEffectInfo$MakeupEffectLayer);
    }

    public NvsColor getColor() {
        return this.color;
    }

    public String getEffectId() {
        return this.effectId;
    }

    public float getIntensity() {
        return this.intensity;
    }

    public List getMakeupEffectLayerArray() {
        return this.makeupEffectLayerArray;
    }

    public void removeMakeupEffectLayerByIndex(int n10) {
        List list;
        int n11;
        if (n10 >= 0 && n10 < (n11 = (list = this.makeupEffectLayerArray).size())) {
            list = this.makeupEffectLayerArray;
            list.remove(n10);
        }
    }
}

