/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera.liveassistant;

import com.zhiyun.cama.camera.liveassistant.LiveAssistantState;

public class LiveAssistantFragment$b {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        LiveAssistantState liveAssistantState;
        int n12 = LiveAssistantState.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            liveAssistantState = LiveAssistantState.OPEN;
            n11 = liveAssistantState.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            liveAssistantState = LiveAssistantState.OPEN_SUCCESS;
            n11 = liveAssistantState.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            liveAssistantState = LiveAssistantState.OPENING;
            n11 = liveAssistantState.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            liveAssistantState = LiveAssistantState.CLOSE;
            n11 = liveAssistantState.ordinal();
            nArray[n11] = n10 = 4;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

