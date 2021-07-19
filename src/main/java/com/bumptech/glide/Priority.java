/*
 * Decompiled with CFR 0.151.
 */
package com.bumptech.glide;

public final class Priority
extends Enum {
    public static final /* enum */ Priority HIGH;
    public static final /* enum */ Priority IMMEDIATE;
    public static final /* enum */ Priority LOW;
    public static final /* enum */ Priority NORMAL;
    private static final /* synthetic */ Priority[] a;

    static {
        Priority priority;
        Priority priority2;
        Priority priority3;
        Priority priority4;
        IMMEDIATE = priority4 = new Priority("IMMEDIATE", 0);
        int n10 = 1;
        HIGH = priority3 = new Priority("HIGH", n10);
        int n11 = 2;
        NORMAL = priority2 = new Priority("NORMAL", n11);
        int n12 = 3;
        LOW = priority = new Priority("LOW", n12);
        Priority[] priorityArray = new Priority[4];
        priorityArray[0] = priority4;
        priorityArray[n10] = priority3;
        priorityArray[n11] = priority2;
        priorityArray[n12] = priority;
        a = priorityArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Priority() {
        void var2_-1;
        void var1_-1;
    }

    public static Priority valueOf(String string2) {
        return Enum.valueOf(Priority.class, string2);
    }

    public static Priority[] values() {
        return (Priority[])a.clone();
    }
}

