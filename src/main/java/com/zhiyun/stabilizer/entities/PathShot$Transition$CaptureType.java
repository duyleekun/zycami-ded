/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.stabilizer.entities;

public final class PathShot$Transition$CaptureType
extends Enum {
    private static final /* synthetic */ PathShot$Transition$CaptureType[] $VALUES;
    public static final /* enum */ PathShot$Transition$CaptureType PHOTO;
    public static final /* enum */ PathShot$Transition$CaptureType VIDEO;

    static {
        PathShot$Transition$CaptureType pathShot$Transition$CaptureType;
        PathShot$Transition$CaptureType pathShot$Transition$CaptureType2;
        PHOTO = pathShot$Transition$CaptureType2 = new PathShot$Transition$CaptureType("PHOTO", 0);
        int n10 = 1;
        VIDEO = pathShot$Transition$CaptureType = new PathShot$Transition$CaptureType("VIDEO", n10);
        PathShot$Transition$CaptureType[] pathShot$Transition$CaptureTypeArray = new PathShot$Transition$CaptureType[2];
        pathShot$Transition$CaptureTypeArray[0] = pathShot$Transition$CaptureType2;
        pathShot$Transition$CaptureTypeArray[n10] = pathShot$Transition$CaptureType;
        $VALUES = pathShot$Transition$CaptureTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private PathShot$Transition$CaptureType() {
        void var2_-1;
        void var1_-1;
    }

    public static PathShot$Transition$CaptureType valueOf(String string2) {
        return Enum.valueOf(PathShot$Transition$CaptureType.class, string2);
    }

    public static PathShot$Transition$CaptureType[] values() {
        return (PathShot$Transition$CaptureType[])$VALUES.clone();
    }
}

