/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.graphics;

import androidx.core.graphics.BlendModeCompat;

public class BlendModeUtils$1 {
    public static final /* synthetic */ int[] $SwitchMap$androidx$core$graphics$BlendModeCompat;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        BlendModeCompat blendModeCompat;
        int n12 = BlendModeCompat.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$androidx$core$graphics$BlendModeCompat = nArray;
        try {
            blendModeCompat = BlendModeCompat.CLEAR;
            n11 = blendModeCompat.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$core$graphics$BlendModeCompat;
            blendModeCompat = BlendModeCompat.SRC;
            n11 = blendModeCompat.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$core$graphics$BlendModeCompat;
            blendModeCompat = BlendModeCompat.DST;
            n11 = blendModeCompat.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$core$graphics$BlendModeCompat;
            blendModeCompat = BlendModeCompat.SRC_OVER;
            n11 = blendModeCompat.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$core$graphics$BlendModeCompat;
            blendModeCompat = BlendModeCompat.DST_OVER;
            n11 = blendModeCompat.ordinal();
            nArray[n11] = n10 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$core$graphics$BlendModeCompat;
            blendModeCompat = BlendModeCompat.SRC_IN;
            n11 = blendModeCompat.ordinal();
            nArray[n11] = n10 = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$core$graphics$BlendModeCompat;
            blendModeCompat = BlendModeCompat.DST_IN;
            n11 = blendModeCompat.ordinal();
            nArray[n11] = n10 = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$core$graphics$BlendModeCompat;
            blendModeCompat = BlendModeCompat.SRC_OUT;
            n11 = blendModeCompat.ordinal();
            nArray[n11] = n10 = 8;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$core$graphics$BlendModeCompat;
            blendModeCompat = BlendModeCompat.DST_OUT;
            n11 = blendModeCompat.ordinal();
            nArray[n11] = n10 = 9;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$core$graphics$BlendModeCompat;
            blendModeCompat = BlendModeCompat.SRC_ATOP;
            n11 = blendModeCompat.ordinal();
            nArray[n11] = n10 = 10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$core$graphics$BlendModeCompat;
            blendModeCompat = BlendModeCompat.DST_ATOP;
            n11 = blendModeCompat.ordinal();
            nArray[n11] = n10 = 11;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$core$graphics$BlendModeCompat;
            blendModeCompat = BlendModeCompat.XOR;
            n11 = blendModeCompat.ordinal();
            nArray[n11] = n10 = 12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$core$graphics$BlendModeCompat;
            blendModeCompat = BlendModeCompat.PLUS;
            n11 = blendModeCompat.ordinal();
            nArray[n11] = n10 = 13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$core$graphics$BlendModeCompat;
            blendModeCompat = BlendModeCompat.MODULATE;
            n11 = blendModeCompat.ordinal();
            nArray[n11] = n10 = 14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$core$graphics$BlendModeCompat;
            blendModeCompat = BlendModeCompat.SCREEN;
            n11 = blendModeCompat.ordinal();
            nArray[n11] = n10 = 15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$core$graphics$BlendModeCompat;
            blendModeCompat = BlendModeCompat.OVERLAY;
            n11 = blendModeCompat.ordinal();
            nArray[n11] = n10 = 16;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$core$graphics$BlendModeCompat;
            blendModeCompat = BlendModeCompat.DARKEN;
            n11 = blendModeCompat.ordinal();
            nArray[n11] = n10 = 17;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$core$graphics$BlendModeCompat;
            blendModeCompat = BlendModeCompat.LIGHTEN;
            n11 = blendModeCompat.ordinal();
            nArray[n11] = n10 = 18;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$core$graphics$BlendModeCompat;
            blendModeCompat = BlendModeCompat.COLOR_DODGE;
            n11 = blendModeCompat.ordinal();
            nArray[n11] = n10 = 19;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$core$graphics$BlendModeCompat;
            blendModeCompat = BlendModeCompat.COLOR_BURN;
            n11 = blendModeCompat.ordinal();
            nArray[n11] = n10 = 20;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$core$graphics$BlendModeCompat;
            blendModeCompat = BlendModeCompat.HARD_LIGHT;
            n11 = blendModeCompat.ordinal();
            nArray[n11] = n10 = 21;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$core$graphics$BlendModeCompat;
            blendModeCompat = BlendModeCompat.SOFT_LIGHT;
            n11 = blendModeCompat.ordinal();
            nArray[n11] = n10 = 22;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$core$graphics$BlendModeCompat;
            blendModeCompat = BlendModeCompat.DIFFERENCE;
            n11 = blendModeCompat.ordinal();
            nArray[n11] = n10 = 23;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$core$graphics$BlendModeCompat;
            blendModeCompat = BlendModeCompat.EXCLUSION;
            n11 = blendModeCompat.ordinal();
            nArray[n11] = n10 = 24;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$core$graphics$BlendModeCompat;
            blendModeCompat = BlendModeCompat.MULTIPLY;
            n11 = blendModeCompat.ordinal();
            nArray[n11] = n10 = 25;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$core$graphics$BlendModeCompat;
            blendModeCompat = BlendModeCompat.HUE;
            n11 = blendModeCompat.ordinal();
            nArray[n11] = n10 = 26;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$core$graphics$BlendModeCompat;
            blendModeCompat = BlendModeCompat.SATURATION;
            n11 = blendModeCompat.ordinal();
            nArray[n11] = n10 = 27;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$core$graphics$BlendModeCompat;
            blendModeCompat = BlendModeCompat.COLOR;
            n11 = blendModeCompat.ordinal();
            nArray[n11] = n10 = 28;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$core$graphics$BlendModeCompat;
            blendModeCompat = BlendModeCompat.LUMINOSITY;
            n11 = blendModeCompat.ordinal();
            nArray[n11] = n10 = 29;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

