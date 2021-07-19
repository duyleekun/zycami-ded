/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push.service.module;

public final class PushChannelRegion
extends Enum {
    private static final /* synthetic */ PushChannelRegion[] $VALUES;
    public static final /* enum */ PushChannelRegion China;
    public static final /* enum */ PushChannelRegion Europe;
    public static final /* enum */ PushChannelRegion Global;
    public static final /* enum */ PushChannelRegion India;
    public static final /* enum */ PushChannelRegion Russia;

    static {
        PushChannelRegion pushChannelRegion;
        PushChannelRegion pushChannelRegion2;
        PushChannelRegion pushChannelRegion3;
        PushChannelRegion pushChannelRegion4;
        PushChannelRegion pushChannelRegion5;
        China = pushChannelRegion5 = new PushChannelRegion("China", 0);
        int n10 = 1;
        Global = pushChannelRegion4 = new PushChannelRegion("Global", n10);
        int n11 = 2;
        Europe = pushChannelRegion3 = new PushChannelRegion("Europe", n11);
        int n12 = 3;
        Russia = pushChannelRegion2 = new PushChannelRegion("Russia", n12);
        int n13 = 4;
        India = pushChannelRegion = new PushChannelRegion("India", n13);
        PushChannelRegion[] pushChannelRegionArray = new PushChannelRegion[5];
        pushChannelRegionArray[0] = pushChannelRegion5;
        pushChannelRegionArray[n10] = pushChannelRegion4;
        pushChannelRegionArray[n11] = pushChannelRegion3;
        pushChannelRegionArray[n12] = pushChannelRegion2;
        pushChannelRegionArray[n13] = pushChannelRegion;
        $VALUES = pushChannelRegionArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private PushChannelRegion() {
        void var2_-1;
        void var1_-1;
    }

    public static PushChannelRegion valueOf(String string2) {
        return Enum.valueOf(PushChannelRegion.class, string2);
    }

    public static PushChannelRegion[] values() {
        return (PushChannelRegion[])$VALUES.clone();
    }
}

