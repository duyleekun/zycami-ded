/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.core;

public final class AVOSService
extends Enum {
    private static final /* synthetic */ AVOSService[] $VALUES;
    public static final /* enum */ AVOSService API;
    public static final /* enum */ AVOSService ENGINE;
    public static final /* enum */ AVOSService PUSH;
    public static final /* enum */ AVOSService RTM;
    public static final /* enum */ AVOSService STATS;
    private String service;

    static {
        AVOSService aVOSService;
        AVOSService aVOSService2;
        AVOSService aVOSService3;
        AVOSService aVOSService4;
        AVOSService aVOSService5;
        API = aVOSService5 = new AVOSService("API", 0, "api");
        int n10 = 1;
        PUSH = aVOSService4 = new AVOSService("PUSH", n10, "push");
        int n11 = 2;
        RTM = aVOSService3 = new AVOSService("RTM", n11, "rtm");
        int n12 = 3;
        STATS = aVOSService2 = new AVOSService("STATS", n12, "stats");
        int n13 = 4;
        ENGINE = aVOSService = new AVOSService("ENGINE", n13, "engine");
        AVOSService[] aVOSServiceArray = new AVOSService[5];
        aVOSServiceArray[0] = aVOSService5;
        aVOSServiceArray[n10] = aVOSService4;
        aVOSServiceArray[n11] = aVOSService3;
        aVOSServiceArray[n12] = aVOSService2;
        aVOSServiceArray[n13] = aVOSService;
        $VALUES = aVOSServiceArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private AVOSService() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.service = var3_1;
    }

    public static AVOSService valueOf(String string2) {
        return Enum.valueOf(AVOSService.class, string2);
    }

    public static AVOSService[] values() {
        return (AVOSService[])$VALUES.clone();
    }

    public String toString() {
        return this.service;
    }
}

