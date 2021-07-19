/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.me.help;

import com.zhiyun.cama.me.help.data.FeedbackSet$Type;

public class FeedbackEditFragment$b {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        FeedbackSet$Type feedbackSet$Type;
        int n12 = FeedbackSet$Type.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            feedbackSet$Type = FeedbackSet$Type.FIRMWARE;
            n11 = feedbackSet$Type.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            feedbackSet$Type = FeedbackSet$Type.SOFTWARE;
            n11 = feedbackSet$Type.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            feedbackSet$Type = FeedbackSet$Type.ADVICE;
            n11 = feedbackSet$Type.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            feedbackSet$Type = FeedbackSet$Type.OTHER;
            n11 = feedbackSet$Type.ordinal();
            nArray[n11] = n10 = 4;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

