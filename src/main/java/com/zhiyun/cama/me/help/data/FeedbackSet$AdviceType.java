/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.me.help.data;

public final class FeedbackSet$AdviceType
extends Enum {
    public static final /* enum */ FeedbackSet$AdviceType FIRMWARE;
    public static final /* enum */ FeedbackSet$AdviceType OTHER;
    public static final /* enum */ FeedbackSet$AdviceType PC;
    public static final /* enum */ FeedbackSet$AdviceType ZYCAMI;
    private static final /* synthetic */ FeedbackSet$AdviceType[] a;
    private String apiName;
    private int stringRes;

    static {
        FeedbackSet$AdviceType feedbackSet$AdviceType;
        FeedbackSet$AdviceType feedbackSet$AdviceType2;
        FeedbackSet$AdviceType feedbackSet$AdviceType3;
        FeedbackSet$AdviceType feedbackSet$AdviceType4;
        FIRMWARE = feedbackSet$AdviceType4 = new FeedbackSet$AdviceType("FIRMWARE", 0, "firmware", 2131952318);
        int n10 = 1;
        ZYCAMI = feedbackSet$AdviceType3 = new FeedbackSet$AdviceType("ZYCAMI", n10, "zycami", 2131952317);
        int n11 = 2;
        PC = feedbackSet$AdviceType2 = new FeedbackSet$AdviceType("PC", n11, "pc", 2131952319);
        int n12 = 3;
        OTHER = feedbackSet$AdviceType = new FeedbackSet$AdviceType("OTHER", n12, "other", 2131952303);
        FeedbackSet$AdviceType[] feedbackSet$AdviceTypeArray = new FeedbackSet$AdviceType[4];
        feedbackSet$AdviceTypeArray[0] = feedbackSet$AdviceType4;
        feedbackSet$AdviceTypeArray[n10] = feedbackSet$AdviceType3;
        feedbackSet$AdviceTypeArray[n11] = feedbackSet$AdviceType2;
        feedbackSet$AdviceTypeArray[n12] = feedbackSet$AdviceType;
        a = feedbackSet$AdviceTypeArray;
    }

    /*
     * WARNING - void declaration
     */
    private FeedbackSet$AdviceType() {
        void var4_2;
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.apiName = var3_1;
        this.stringRes = var4_2;
    }

    public static FeedbackSet$AdviceType from(String string2) {
        for (FeedbackSet$AdviceType feedbackSet$AdviceType : FeedbackSet$AdviceType.values()) {
            String string3 = feedbackSet$AdviceType.getApiName();
            boolean bl2 = string3.equals(string2);
            if (!bl2) continue;
            return feedbackSet$AdviceType;
        }
        return null;
    }

    public static FeedbackSet$AdviceType valueOf(String string2) {
        return Enum.valueOf(FeedbackSet$AdviceType.class, string2);
    }

    public static FeedbackSet$AdviceType[] values() {
        return (FeedbackSet$AdviceType[])a.clone();
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

