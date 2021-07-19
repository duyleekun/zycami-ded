/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.utils;

public final class PackageManagerHelper$PackageStates
extends Enum {
    public static final /* enum */ PackageManagerHelper$PackageStates DISABLED;
    public static final /* enum */ PackageManagerHelper$PackageStates ENABLED;
    public static final /* enum */ PackageManagerHelper$PackageStates NOT_INSTALLED;
    public static final /* synthetic */ PackageManagerHelper$PackageStates[] a;

    static {
        PackageManagerHelper$PackageStates packageManagerHelper$PackageStates;
        PackageManagerHelper$PackageStates packageManagerHelper$PackageStates2;
        PackageManagerHelper$PackageStates packageManagerHelper$PackageStates3;
        ENABLED = packageManagerHelper$PackageStates3 = new PackageManagerHelper$PackageStates("ENABLED", 0);
        int n10 = 1;
        DISABLED = packageManagerHelper$PackageStates2 = new PackageManagerHelper$PackageStates("DISABLED", n10);
        int n11 = 2;
        NOT_INSTALLED = packageManagerHelper$PackageStates = new PackageManagerHelper$PackageStates("NOT_INSTALLED", n11);
        PackageManagerHelper$PackageStates[] packageManagerHelper$PackageStatesArray = new PackageManagerHelper$PackageStates[3];
        packageManagerHelper$PackageStatesArray[0] = packageManagerHelper$PackageStates3;
        packageManagerHelper$PackageStatesArray[n10] = packageManagerHelper$PackageStates2;
        packageManagerHelper$PackageStatesArray[n11] = packageManagerHelper$PackageStates;
        a = packageManagerHelper$PackageStatesArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public PackageManagerHelper$PackageStates() {
        void var2_-1;
        void var1_-1;
    }

    public static PackageManagerHelper$PackageStates valueOf(String string2) {
        return Enum.valueOf(PackageManagerHelper$PackageStates.class, string2);
    }

    public static PackageManagerHelper$PackageStates[] values() {
        return (PackageManagerHelper$PackageStates[])a.clone();
    }
}

