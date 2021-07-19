/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.audio;

public final class AuxEffectInfo {
    public static final int NO_AUX_EFFECT_ID;
    public final int effectId;
    public final float sendLevel;

    public AuxEffectInfo(int n10, float f10) {
        this.effectId = n10;
        this.sendLevel = f10;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Class<AuxEffectInfo> clazz2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (clazz2 = AuxEffectInfo.class) == (clazz = object.getClass())) {
            float f10;
            float f11;
            int n10;
            object = (AuxEffectInfo)object;
            int n11 = this.effectId;
            int n12 = ((AuxEffectInfo)object).effectId;
            if (n11 != n12 || (n10 = Float.compare(f11 = ((AuxEffectInfo)object).sendLevel, f10 = this.sendLevel)) != 0) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10 = this.effectId;
        int n11 = (527 + n10) * 31;
        n10 = Float.floatToIntBits(this.sendLevel);
        return n11 + n10;
    }
}

