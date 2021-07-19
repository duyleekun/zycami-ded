/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.animation.content;

import com.airbnb.lottie.model.content.MergePaths$MergePathsMode;

public class MergePathsContent$1 {
    public static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$content$MergePaths$MergePathsMode;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        MergePaths$MergePathsMode mergePaths$MergePathsMode;
        int n12 = MergePaths$MergePathsMode.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$com$airbnb$lottie$model$content$MergePaths$MergePathsMode = nArray;
        try {
            mergePaths$MergePathsMode = MergePaths$MergePathsMode.MERGE;
            n11 = mergePaths$MergePathsMode.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$airbnb$lottie$model$content$MergePaths$MergePathsMode;
            mergePaths$MergePathsMode = MergePaths$MergePathsMode.ADD;
            n11 = mergePaths$MergePathsMode.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$airbnb$lottie$model$content$MergePaths$MergePathsMode;
            mergePaths$MergePathsMode = MergePaths$MergePathsMode.SUBTRACT;
            n11 = mergePaths$MergePathsMode.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$airbnb$lottie$model$content$MergePaths$MergePathsMode;
            mergePaths$MergePathsMode = MergePaths$MergePathsMode.INTERSECT;
            n11 = mergePaths$MergePathsMode.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$airbnb$lottie$model$content$MergePaths$MergePathsMode;
            mergePaths$MergePathsMode = MergePaths$MergePathsMode.EXCLUDE_INTERSECTIONS;
            n11 = mergePaths$MergePathsMode.ordinal();
            nArray[n11] = n10 = 5;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

