/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger;

public final class StackSize
extends Enum {
    private static final /* synthetic */ StackSize[] $VALUES;
    public static final /* enum */ StackSize FULL;
    public static final /* enum */ StackSize LARGE;
    public static final /* enum */ StackSize MEDIUM;
    public static final /* enum */ StackSize NONE;
    public static final /* enum */ StackSize SMALL;
    private final int maxDepth;

    static {
        StackSize stackSize;
        StackSize stackSize2;
        StackSize stackSize3;
        StackSize stackSize4;
        StackSize stackSize5;
        SMALL = stackSize5 = new StackSize("SMALL", 0, 10);
        int n10 = 1;
        MEDIUM = stackSize4 = new StackSize("MEDIUM", n10, 20);
        int n11 = 2;
        LARGE = stackSize3 = new StackSize("LARGE", n11, 50);
        int n12 = 3;
        FULL = stackSize2 = new StackSize("FULL", n12, -1);
        int n13 = 4;
        NONE = stackSize = new StackSize("NONE", n13, 0);
        StackSize[] stackSizeArray = new StackSize[5];
        stackSizeArray[0] = stackSize5;
        stackSizeArray[n10] = stackSize4;
        stackSizeArray[n11] = stackSize3;
        stackSizeArray[n12] = stackSize2;
        stackSizeArray[n13] = stackSize;
        $VALUES = stackSizeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private StackSize() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.maxDepth = var3_1;
    }

    public static StackSize valueOf(String string2) {
        return Enum.valueOf(StackSize.class, string2);
    }

    public static StackSize[] values() {
        return (StackSize[])$VALUES.clone();
    }

    public int getMaxDepth() {
        return this.maxDepth;
    }
}

