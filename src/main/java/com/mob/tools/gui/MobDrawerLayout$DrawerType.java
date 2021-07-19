/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.gui;

public final class MobDrawerLayout$DrawerType
extends Enum {
    private static final /* synthetic */ MobDrawerLayout$DrawerType[] $VALUES;
    public static final /* enum */ MobDrawerLayout$DrawerType LEFT_BOTTOM;
    public static final /* enum */ MobDrawerLayout$DrawerType LEFT_COVER;
    public static final /* enum */ MobDrawerLayout$DrawerType LEFT_PUSH;
    public static final /* enum */ MobDrawerLayout$DrawerType RIGHT_BOTTOM;
    public static final /* enum */ MobDrawerLayout$DrawerType RIGHT_COVER;
    public static final /* enum */ MobDrawerLayout$DrawerType RIGHT_PUSH;

    static {
        MobDrawerLayout$DrawerType mobDrawerLayout$DrawerType;
        MobDrawerLayout$DrawerType mobDrawerLayout$DrawerType2;
        MobDrawerLayout$DrawerType mobDrawerLayout$DrawerType3;
        MobDrawerLayout$DrawerType mobDrawerLayout$DrawerType4;
        MobDrawerLayout$DrawerType mobDrawerLayout$DrawerType5;
        MobDrawerLayout$DrawerType mobDrawerLayout$DrawerType6;
        LEFT_COVER = mobDrawerLayout$DrawerType6 = new MobDrawerLayout$DrawerType("LEFT_COVER", 0);
        int n10 = 1;
        RIGHT_COVER = mobDrawerLayout$DrawerType5 = new MobDrawerLayout$DrawerType("RIGHT_COVER", n10);
        int n11 = 2;
        LEFT_BOTTOM = mobDrawerLayout$DrawerType4 = new MobDrawerLayout$DrawerType("LEFT_BOTTOM", n11);
        int n12 = 3;
        RIGHT_BOTTOM = mobDrawerLayout$DrawerType3 = new MobDrawerLayout$DrawerType("RIGHT_BOTTOM", n12);
        int n13 = 4;
        LEFT_PUSH = mobDrawerLayout$DrawerType2 = new MobDrawerLayout$DrawerType("LEFT_PUSH", n13);
        int n14 = 5;
        RIGHT_PUSH = mobDrawerLayout$DrawerType = new MobDrawerLayout$DrawerType("RIGHT_PUSH", n14);
        MobDrawerLayout$DrawerType[] mobDrawerLayout$DrawerTypeArray = new MobDrawerLayout$DrawerType[6];
        mobDrawerLayout$DrawerTypeArray[0] = mobDrawerLayout$DrawerType6;
        mobDrawerLayout$DrawerTypeArray[n10] = mobDrawerLayout$DrawerType5;
        mobDrawerLayout$DrawerTypeArray[n11] = mobDrawerLayout$DrawerType4;
        mobDrawerLayout$DrawerTypeArray[n12] = mobDrawerLayout$DrawerType3;
        mobDrawerLayout$DrawerTypeArray[n13] = mobDrawerLayout$DrawerType2;
        mobDrawerLayout$DrawerTypeArray[n14] = mobDrawerLayout$DrawerType;
        $VALUES = mobDrawerLayout$DrawerTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private MobDrawerLayout$DrawerType() {
        void var2_-1;
        void var1_-1;
    }

    public static MobDrawerLayout$DrawerType valueOf(String string2) {
        return Enum.valueOf(MobDrawerLayout$DrawerType.class, string2);
    }

    public static MobDrawerLayout$DrawerType[] values() {
        return (MobDrawerLayout$DrawerType[])$VALUES.clone();
    }
}

