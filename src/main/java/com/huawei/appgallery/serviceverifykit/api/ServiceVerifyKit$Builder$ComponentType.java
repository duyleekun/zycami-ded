/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.appgallery.serviceverifykit.api;

public final class ServiceVerifyKit$Builder$ComponentType
extends Enum {
    public static final /* enum */ ServiceVerifyKit$Builder$ComponentType ACTIVITY;
    public static final /* enum */ ServiceVerifyKit$Builder$ComponentType BROADCAST;
    public static final /* enum */ ServiceVerifyKit$Builder$ComponentType SERVICE;
    private static final /* synthetic */ ServiceVerifyKit$Builder$ComponentType[] a;

    static {
        ServiceVerifyKit$Builder$ComponentType serviceVerifyKit$Builder$ComponentType;
        ServiceVerifyKit$Builder$ComponentType serviceVerifyKit$Builder$ComponentType2;
        ServiceVerifyKit$Builder$ComponentType serviceVerifyKit$Builder$ComponentType3;
        ACTIVITY = serviceVerifyKit$Builder$ComponentType3 = new ServiceVerifyKit$Builder$ComponentType("ACTIVITY", 0);
        int n10 = 1;
        SERVICE = serviceVerifyKit$Builder$ComponentType2 = new ServiceVerifyKit$Builder$ComponentType("SERVICE", n10);
        int n11 = 2;
        BROADCAST = serviceVerifyKit$Builder$ComponentType = new ServiceVerifyKit$Builder$ComponentType("BROADCAST", n11);
        ServiceVerifyKit$Builder$ComponentType[] serviceVerifyKit$Builder$ComponentTypeArray = new ServiceVerifyKit$Builder$ComponentType[3];
        serviceVerifyKit$Builder$ComponentTypeArray[0] = serviceVerifyKit$Builder$ComponentType3;
        serviceVerifyKit$Builder$ComponentTypeArray[n10] = serviceVerifyKit$Builder$ComponentType2;
        serviceVerifyKit$Builder$ComponentTypeArray[n11] = serviceVerifyKit$Builder$ComponentType;
        a = serviceVerifyKit$Builder$ComponentTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ServiceVerifyKit$Builder$ComponentType() {
        void var2_-1;
        void var1_-1;
    }

    public static ServiceVerifyKit$Builder$ComponentType valueOf(String string2) {
        return Enum.valueOf(ServiceVerifyKit$Builder$ComponentType.class, string2);
    }

    public static ServiceVerifyKit$Builder$ComponentType[] values() {
        return (ServiceVerifyKit$Builder$ComponentType[])a.clone();
    }
}

