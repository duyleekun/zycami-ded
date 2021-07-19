/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.me.help.data;

public final class FeedbackSet$Type
extends Enum {
    public static final /* enum */ FeedbackSet$Type ADVICE;
    public static final /* enum */ FeedbackSet$Type FIRMWARE;
    public static final /* enum */ FeedbackSet$Type OTHER;
    public static final /* enum */ FeedbackSet$Type SOFTWARE;
    private static final /* synthetic */ FeedbackSet$Type[] a;
    private String apiName;
    private int stringRes;

    static {
        FeedbackSet$Type feedbackSet$Type;
        FeedbackSet$Type feedbackSet$Type2;
        FeedbackSet$Type feedbackSet$Type3;
        FeedbackSet$Type feedbackSet$Type4;
        SOFTWARE = feedbackSet$Type4 = new FeedbackSet$Type("SOFTWARE", 0, "feedback_software", 2131952313);
        int n10 = 1;
        FIRMWARE = feedbackSet$Type3 = new FeedbackSet$Type("FIRMWARE", n10, "feedback_firmware", 2131952295);
        int n11 = 2;
        ADVICE = feedbackSet$Type2 = new FeedbackSet$Type("ADVICE", n11, "advice", 2131952261);
        int n12 = 3;
        OTHER = feedbackSet$Type = new FeedbackSet$Type("OTHER", n12, "other", 2131952303);
        FeedbackSet$Type[] feedbackSet$TypeArray = new FeedbackSet$Type[4];
        feedbackSet$TypeArray[0] = feedbackSet$Type4;
        feedbackSet$TypeArray[n10] = feedbackSet$Type3;
        feedbackSet$TypeArray[n11] = feedbackSet$Type2;
        feedbackSet$TypeArray[n12] = feedbackSet$Type;
        a = feedbackSet$TypeArray;
    }

    /*
     * WARNING - void declaration
     */
    private FeedbackSet$Type() {
        void var4_2;
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.apiName = var3_1;
        this.stringRes = var4_2;
    }

    public static FeedbackSet$Type from(String string2) {
        for (FeedbackSet$Type feedbackSet$Type : FeedbackSet$Type.values()) {
            String string3 = feedbackSet$Type.getApiName();
            boolean bl2 = string3.equals(string2);
            if (!bl2) continue;
            return feedbackSet$Type;
        }
        return null;
    }

    public static FeedbackSet$Type valueOf(String string2) {
        return Enum.valueOf(FeedbackSet$Type.class, string2);
    }

    public static FeedbackSet$Type[] values() {
        return (FeedbackSet$Type[])a.clone();
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

