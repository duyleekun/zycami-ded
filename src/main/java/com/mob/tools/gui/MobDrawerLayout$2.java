/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.gui;

import com.mob.tools.gui.MobDrawerLayout$DrawerType;

public class MobDrawerLayout$2 {
    public static final /* synthetic */ int[] $SwitchMap$com$mob$tools$gui$MobDrawerLayout$DrawerType;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        MobDrawerLayout$DrawerType mobDrawerLayout$DrawerType;
        int n12 = MobDrawerLayout$DrawerType.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$com$mob$tools$gui$MobDrawerLayout$DrawerType = nArray;
        try {
            mobDrawerLayout$DrawerType = MobDrawerLayout$DrawerType.LEFT_COVER;
            n11 = mobDrawerLayout$DrawerType.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$mob$tools$gui$MobDrawerLayout$DrawerType;
            mobDrawerLayout$DrawerType = MobDrawerLayout$DrawerType.RIGHT_COVER;
            n11 = mobDrawerLayout$DrawerType.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$mob$tools$gui$MobDrawerLayout$DrawerType;
            mobDrawerLayout$DrawerType = MobDrawerLayout$DrawerType.LEFT_BOTTOM;
            n11 = mobDrawerLayout$DrawerType.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$mob$tools$gui$MobDrawerLayout$DrawerType;
            mobDrawerLayout$DrawerType = MobDrawerLayout$DrawerType.LEFT_PUSH;
            n11 = mobDrawerLayout$DrawerType.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$mob$tools$gui$MobDrawerLayout$DrawerType;
            mobDrawerLayout$DrawerType = MobDrawerLayout$DrawerType.RIGHT_BOTTOM;
            n11 = mobDrawerLayout$DrawerType.ordinal();
            nArray[n11] = n10 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$mob$tools$gui$MobDrawerLayout$DrawerType;
            mobDrawerLayout$DrawerType = MobDrawerLayout$DrawerType.RIGHT_PUSH;
            n11 = mobDrawerLayout$DrawerType.ordinal();
            nArray[n11] = n10 = 6;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

