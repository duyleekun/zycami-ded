/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.s0;

import com.zhiyun.cama.camera.story.review.StoryReviewViewModel$ReviewStatus;

public class y$a {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        StoryReviewViewModel$ReviewStatus storyReviewViewModel$ReviewStatus;
        int n12 = StoryReviewViewModel$ReviewStatus.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            storyReviewViewModel$ReviewStatus = StoryReviewViewModel$ReviewStatus.SINGLE_REVIEW;
            n11 = storyReviewViewModel$ReviewStatus.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            storyReviewViewModel$ReviewStatus = StoryReviewViewModel$ReviewStatus.TOTAL_REVIEW;
            n11 = storyReviewViewModel$ReviewStatus.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            storyReviewViewModel$ReviewStatus = StoryReviewViewModel$ReviewStatus.SETTING_REVIEW;
            n11 = storyReviewViewModel$ReviewStatus.ordinal();
            nArray[n11] = n10 = 3;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

