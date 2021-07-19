/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera;

public final class DynamicZoomViewModel$TargetModel
extends Enum {
    public static final /* enum */ DynamicZoomViewModel$TargetModel FAR;
    public static final /* enum */ DynamicZoomViewModel$TargetModel NEAR;
    private static final /* synthetic */ DynamicZoomViewModel$TargetModel[] a;
    private final int value;

    static {
        DynamicZoomViewModel$TargetModel dynamicZoomViewModel$TargetModel;
        DynamicZoomViewModel$TargetModel dynamicZoomViewModel$TargetModel2;
        FAR = dynamicZoomViewModel$TargetModel2 = new DynamicZoomViewModel$TargetModel("FAR", 0, 0);
        int n10 = 1;
        NEAR = dynamicZoomViewModel$TargetModel = new DynamicZoomViewModel$TargetModel("NEAR", n10, n10);
        DynamicZoomViewModel$TargetModel[] dynamicZoomViewModel$TargetModelArray = new DynamicZoomViewModel$TargetModel[2];
        dynamicZoomViewModel$TargetModelArray[0] = dynamicZoomViewModel$TargetModel2;
        dynamicZoomViewModel$TargetModelArray[n10] = dynamicZoomViewModel$TargetModel;
        a = dynamicZoomViewModel$TargetModelArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private DynamicZoomViewModel$TargetModel() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static DynamicZoomViewModel$TargetModel valueOf(String string2) {
        return Enum.valueOf(DynamicZoomViewModel$TargetModel.class, string2);
    }

    public static DynamicZoomViewModel$TargetModel[] values() {
        return (DynamicZoomViewModel$TargetModel[])a.clone();
    }

    public int getValue() {
        return this.value;
    }
}

