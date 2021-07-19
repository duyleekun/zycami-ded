/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

public final class AVObject$Hook
extends Enum {
    private static final /* synthetic */ AVObject$Hook[] $VALUES;
    public static final /* enum */ AVObject$Hook afterDelete;
    public static final /* enum */ AVObject$Hook afterSave;
    public static final /* enum */ AVObject$Hook afterUpdate;
    public static final /* enum */ AVObject$Hook beforeDelete;
    public static final /* enum */ AVObject$Hook beforeSave;
    public static final /* enum */ AVObject$Hook beforeUpdate;

    static {
        AVObject$Hook aVObject$Hook;
        AVObject$Hook aVObject$Hook2;
        AVObject$Hook aVObject$Hook3;
        AVObject$Hook aVObject$Hook4;
        AVObject$Hook aVObject$Hook5;
        AVObject$Hook aVObject$Hook6;
        beforeSave = aVObject$Hook6 = new AVObject$Hook("beforeSave", 0);
        int n10 = 1;
        afterSave = aVObject$Hook5 = new AVObject$Hook("afterSave", n10);
        int n11 = 2;
        beforeUpdate = aVObject$Hook4 = new AVObject$Hook("beforeUpdate", n11);
        int n12 = 3;
        afterUpdate = aVObject$Hook3 = new AVObject$Hook("afterUpdate", n12);
        int n13 = 4;
        beforeDelete = aVObject$Hook2 = new AVObject$Hook("beforeDelete", n13);
        int n14 = 5;
        afterDelete = aVObject$Hook = new AVObject$Hook("afterDelete", n14);
        AVObject$Hook[] aVObject$HookArray = new AVObject$Hook[6];
        aVObject$HookArray[0] = aVObject$Hook6;
        aVObject$HookArray[n10] = aVObject$Hook5;
        aVObject$HookArray[n11] = aVObject$Hook4;
        aVObject$HookArray[n12] = aVObject$Hook3;
        aVObject$HookArray[n13] = aVObject$Hook2;
        aVObject$HookArray[n14] = aVObject$Hook;
        $VALUES = aVObject$HookArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private AVObject$Hook() {
        void var2_-1;
        void var1_-1;
    }

    public static AVObject$Hook valueOf(String string2) {
        return Enum.valueOf(AVObject$Hook.class, string2);
    }

    public static AVObject$Hook[] values() {
        return (AVObject$Hook[])$VALUES.clone();
    }
}

