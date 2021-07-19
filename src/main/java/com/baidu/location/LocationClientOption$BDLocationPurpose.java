/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location;

public final class LocationClientOption$BDLocationPurpose
extends Enum {
    private static final /* synthetic */ LocationClientOption$BDLocationPurpose[] $VALUES;
    public static final /* enum */ LocationClientOption$BDLocationPurpose SignIn;
    public static final /* enum */ LocationClientOption$BDLocationPurpose Sport;
    public static final /* enum */ LocationClientOption$BDLocationPurpose Transport;

    static {
        LocationClientOption$BDLocationPurpose locationClientOption$BDLocationPurpose;
        LocationClientOption$BDLocationPurpose locationClientOption$BDLocationPurpose2;
        LocationClientOption$BDLocationPurpose locationClientOption$BDLocationPurpose3;
        SignIn = locationClientOption$BDLocationPurpose3 = new LocationClientOption$BDLocationPurpose("SignIn", 0);
        int n10 = 1;
        Sport = locationClientOption$BDLocationPurpose2 = new LocationClientOption$BDLocationPurpose("Sport", n10);
        int n11 = 2;
        Transport = locationClientOption$BDLocationPurpose = new LocationClientOption$BDLocationPurpose("Transport", n11);
        LocationClientOption$BDLocationPurpose[] locationClientOption$BDLocationPurposeArray = new LocationClientOption$BDLocationPurpose[3];
        locationClientOption$BDLocationPurposeArray[0] = locationClientOption$BDLocationPurpose3;
        locationClientOption$BDLocationPurposeArray[n10] = locationClientOption$BDLocationPurpose2;
        locationClientOption$BDLocationPurposeArray[n11] = locationClientOption$BDLocationPurpose;
        $VALUES = locationClientOption$BDLocationPurposeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private LocationClientOption$BDLocationPurpose() {
        void var2_-1;
        void var1_-1;
    }

    public static LocationClientOption$BDLocationPurpose valueOf(String string2) {
        return Enum.valueOf(LocationClientOption$BDLocationPurpose.class, string2);
    }

    public static LocationClientOption$BDLocationPurpose[] values() {
        return (LocationClientOption$BDLocationPurpose[])$VALUES.clone();
    }
}

