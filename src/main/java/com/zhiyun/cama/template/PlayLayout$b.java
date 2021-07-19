/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.template;

import com.zhiyun.cama.template.PlayState;

public class PlayLayout$b {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        PlayState playState;
        int n12 = PlayState.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            playState = PlayState.STATE_PLAYING;
            n11 = playState.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            playState = PlayState.STATE_PLAY_PREPARE;
            n11 = playState.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            playState = PlayState.STATE_PAUSE;
            n11 = playState.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            playState = PlayState.STATE_COMPLETED;
            n11 = playState.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            playState = PlayState.STATE_IDLE;
            n11 = playState.ordinal();
            nArray[n11] = n10 = 5;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

