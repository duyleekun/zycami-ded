/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.model.content;

public final class MergePaths$MergePathsMode
extends Enum {
    private static final /* synthetic */ MergePaths$MergePathsMode[] $VALUES;
    public static final /* enum */ MergePaths$MergePathsMode ADD;
    public static final /* enum */ MergePaths$MergePathsMode EXCLUDE_INTERSECTIONS;
    public static final /* enum */ MergePaths$MergePathsMode INTERSECT;
    public static final /* enum */ MergePaths$MergePathsMode MERGE;
    public static final /* enum */ MergePaths$MergePathsMode SUBTRACT;

    static {
        MergePaths$MergePathsMode mergePaths$MergePathsMode;
        MergePaths$MergePathsMode mergePaths$MergePathsMode2;
        MergePaths$MergePathsMode mergePaths$MergePathsMode3;
        MergePaths$MergePathsMode mergePaths$MergePathsMode4;
        MergePaths$MergePathsMode mergePaths$MergePathsMode5;
        MERGE = mergePaths$MergePathsMode5 = new MergePaths$MergePathsMode("MERGE", 0);
        int n10 = 1;
        ADD = mergePaths$MergePathsMode4 = new MergePaths$MergePathsMode("ADD", n10);
        int n11 = 2;
        SUBTRACT = mergePaths$MergePathsMode3 = new MergePaths$MergePathsMode("SUBTRACT", n11);
        int n12 = 3;
        INTERSECT = mergePaths$MergePathsMode2 = new MergePaths$MergePathsMode("INTERSECT", n12);
        int n13 = 4;
        EXCLUDE_INTERSECTIONS = mergePaths$MergePathsMode = new MergePaths$MergePathsMode("EXCLUDE_INTERSECTIONS", n13);
        MergePaths$MergePathsMode[] mergePaths$MergePathsModeArray = new MergePaths$MergePathsMode[5];
        mergePaths$MergePathsModeArray[0] = mergePaths$MergePathsMode5;
        mergePaths$MergePathsModeArray[n10] = mergePaths$MergePathsMode4;
        mergePaths$MergePathsModeArray[n11] = mergePaths$MergePathsMode3;
        mergePaths$MergePathsModeArray[n12] = mergePaths$MergePathsMode2;
        mergePaths$MergePathsModeArray[n13] = mergePaths$MergePathsMode;
        $VALUES = mergePaths$MergePathsModeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private MergePaths$MergePathsMode() {
        void var2_-1;
        void var1_-1;
    }

    public static MergePaths$MergePathsMode forId(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    n11 = 4;
                    if (n10 != n11) {
                        n11 = 5;
                        if (n10 != n11) {
                            return MERGE;
                        }
                        return EXCLUDE_INTERSECTIONS;
                    }
                    return INTERSECT;
                }
                return SUBTRACT;
            }
            return ADD;
        }
        return MERGE;
    }

    public static MergePaths$MergePathsMode valueOf(String string2) {
        return Enum.valueOf(MergePaths$MergePathsMode.class, string2);
    }

    public static MergePaths$MergePathsMode[] values() {
        return (MergePaths$MergePathsMode[])$VALUES.clone();
    }
}

