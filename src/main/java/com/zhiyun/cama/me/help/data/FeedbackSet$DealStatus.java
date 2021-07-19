/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.me.help.data;

public final class FeedbackSet$DealStatus
extends Enum {
    public static final /* enum */ FeedbackSet$DealStatus CLOSE;
    public static final /* enum */ FeedbackSet$DealStatus ING;
    public static final /* enum */ FeedbackSet$DealStatus TO_BE;
    public static final /* enum */ FeedbackSet$DealStatus TO_BE_CONFIRM;
    private static final /* synthetic */ FeedbackSet$DealStatus[] a;
    private String apiName;
    private String colorStr;
    private int stringRes;

    static {
        FeedbackSet$DealStatus feedbackSet$DealStatus;
        FeedbackSet$DealStatus feedbackSet$DealStatus2;
        FeedbackSet$DealStatus feedbackSet$DealStatus3;
        FeedbackSet$DealStatus feedbackSet$DealStatus4 = feedbackSet$DealStatus3;
        TO_BE_CONFIRM = feedbackSet$DealStatus3 = new FeedbackSet$DealStatus("TO_BE_CONFIRM", 0, "1", 2131952282, "#FD3854");
        TO_BE = feedbackSet$DealStatus4 = new FeedbackSet$DealStatus("TO_BE", 1, "2", 2131952281, "#F7BD3C");
        ING = feedbackSet$DealStatus2 = new FeedbackSet$DealStatus("ING", 2, "3", 2131952279, "#2D92FF");
        CLOSE = feedbackSet$DealStatus = new FeedbackSet$DealStatus("CLOSE", 3, "4", 2131952278, "#9A9B9C");
        FeedbackSet$DealStatus[] feedbackSet$DealStatusArray = new FeedbackSet$DealStatus[]{feedbackSet$DealStatus3, feedbackSet$DealStatus4, feedbackSet$DealStatus2, feedbackSet$DealStatus};
        a = feedbackSet$DealStatusArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private FeedbackSet$DealStatus(String string3) {
        void var5_3;
        void var4_2;
        void var2_-1;
        void var1_-1;
        this.apiName = string3;
        this.stringRes = var4_2;
        this.colorStr = var5_3;
    }

    public static FeedbackSet$DealStatus from(String string2) {
        for (FeedbackSet$DealStatus feedbackSet$DealStatus : FeedbackSet$DealStatus.values()) {
            String string3 = feedbackSet$DealStatus.getApiName();
            boolean bl2 = string3.equals(string2);
            if (!bl2) continue;
            return feedbackSet$DealStatus;
        }
        return null;
    }

    public static FeedbackSet$DealStatus valueOf(String string2) {
        return Enum.valueOf(FeedbackSet$DealStatus.class, string2);
    }

    public static FeedbackSet$DealStatus[] values() {
        return (FeedbackSet$DealStatus[])a.clone();
    }

    public String getApiName() {
        return this.apiName;
    }

    public String getColorStr() {
        return this.colorStr;
    }

    public int getStringRes() {
        return this.stringRes;
    }

    public void setApiName(String string2) {
        this.apiName = string2;
    }

    public void setColorStr(String string2) {
        this.colorStr = string2;
    }

    public void setStringRes(int n10) {
        this.stringRes = n10;
    }
}

