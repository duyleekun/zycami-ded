/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera.story.review;

public final class StoryReviewViewModel$ReviewStatus
extends Enum {
    public static final /* enum */ StoryReviewViewModel$ReviewStatus SETTING_REVIEW;
    public static final /* enum */ StoryReviewViewModel$ReviewStatus SINGLE_REVIEW;
    public static final /* enum */ StoryReviewViewModel$ReviewStatus TOTAL_REVIEW;
    private static final /* synthetic */ StoryReviewViewModel$ReviewStatus[] a;

    static {
        StoryReviewViewModel$ReviewStatus storyReviewViewModel$ReviewStatus;
        StoryReviewViewModel$ReviewStatus storyReviewViewModel$ReviewStatus2;
        StoryReviewViewModel$ReviewStatus storyReviewViewModel$ReviewStatus3;
        SINGLE_REVIEW = storyReviewViewModel$ReviewStatus3 = new StoryReviewViewModel$ReviewStatus("SINGLE_REVIEW", 0);
        int n10 = 1;
        TOTAL_REVIEW = storyReviewViewModel$ReviewStatus2 = new StoryReviewViewModel$ReviewStatus("TOTAL_REVIEW", n10);
        int n11 = 2;
        SETTING_REVIEW = storyReviewViewModel$ReviewStatus = new StoryReviewViewModel$ReviewStatus("SETTING_REVIEW", n11);
        StoryReviewViewModel$ReviewStatus[] storyReviewViewModel$ReviewStatusArray = new StoryReviewViewModel$ReviewStatus[3];
        storyReviewViewModel$ReviewStatusArray[0] = storyReviewViewModel$ReviewStatus3;
        storyReviewViewModel$ReviewStatusArray[n10] = storyReviewViewModel$ReviewStatus2;
        storyReviewViewModel$ReviewStatusArray[n11] = storyReviewViewModel$ReviewStatus;
        a = storyReviewViewModel$ReviewStatusArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private StoryReviewViewModel$ReviewStatus() {
        void var2_-1;
        void var1_-1;
    }

    public static StoryReviewViewModel$ReviewStatus valueOf(String string2) {
        return Enum.valueOf(StoryReviewViewModel$ReviewStatus.class, string2);
    }

    public static StoryReviewViewModel$ReviewStatus[] values() {
        return (StoryReviewViewModel$ReviewStatus[])a.clone();
    }
}

