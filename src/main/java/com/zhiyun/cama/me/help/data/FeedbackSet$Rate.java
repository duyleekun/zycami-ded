/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.me.help.data;

public final class FeedbackSet$Rate
extends Enum {
    public static final /* enum */ FeedbackSet$Rate FEW;
    public static final /* enum */ FeedbackSet$Rate OFTEN;
    public static final /* enum */ FeedbackSet$Rate ONCE;
    private static final /* synthetic */ FeedbackSet$Rate[] a;
    private String apiName;
    private int stringRes;

    static {
        FeedbackSet$Rate feedbackSet$Rate;
        FeedbackSet$Rate feedbackSet$Rate2;
        FeedbackSet$Rate feedbackSet$Rate3;
        ONCE = feedbackSet$Rate3 = new FeedbackSet$Rate("ONCE", 0, "1", 2131952312);
        int n10 = 1;
        FEW = feedbackSet$Rate2 = new FeedbackSet$Rate("FEW", n10, "2", 2131952310);
        int n11 = 2;
        OFTEN = feedbackSet$Rate = new FeedbackSet$Rate("OFTEN", n11, "3", 2131952311);
        FeedbackSet$Rate[] feedbackSet$RateArray = new FeedbackSet$Rate[3];
        feedbackSet$RateArray[0] = feedbackSet$Rate3;
        feedbackSet$RateArray[n10] = feedbackSet$Rate2;
        feedbackSet$RateArray[n11] = feedbackSet$Rate;
        a = feedbackSet$RateArray;
    }

    /*
     * WARNING - void declaration
     */
    private FeedbackSet$Rate() {
        void var4_2;
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.apiName = var3_1;
        this.stringRes = var4_2;
    }

    public static FeedbackSet$Rate from(String string2) {
        for (FeedbackSet$Rate feedbackSet$Rate : FeedbackSet$Rate.values()) {
            String string3 = feedbackSet$Rate.getApiName();
            boolean bl2 = string3.equals(string2);
            if (!bl2) continue;
            return feedbackSet$Rate;
        }
        return null;
    }

    public static FeedbackSet$Rate valueOf(String string2) {
        return Enum.valueOf(FeedbackSet$Rate.class, string2);
    }

    public static FeedbackSet$Rate[] values() {
        return (FeedbackSet$Rate[])a.clone();
    }

    public String getApiName() {
        return this.apiName;
    }

    public int getStringRes() {
        return this.stringRes;
    }

    public void setApiName(String string2) {
        this.apiName = string2;
    }

    public void setStringRes(int n10) {
        this.stringRes = n10;
    }
}

