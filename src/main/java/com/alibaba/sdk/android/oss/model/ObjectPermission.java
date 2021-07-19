/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

public final class ObjectPermission
extends Enum {
    private static final /* synthetic */ ObjectPermission[] $VALUES;
    public static final /* enum */ ObjectPermission Default;
    public static final /* enum */ ObjectPermission Private;
    public static final /* enum */ ObjectPermission PublicRead;
    public static final /* enum */ ObjectPermission PublicReadWrite;
    public static final /* enum */ ObjectPermission Unknown;
    private String permissionString;

    static {
        ObjectPermission objectPermission;
        ObjectPermission objectPermission2;
        ObjectPermission objectPermission3;
        ObjectPermission objectPermission4;
        ObjectPermission objectPermission5;
        Private = objectPermission5 = new ObjectPermission("Private", 0, "private");
        int n10 = 1;
        PublicRead = objectPermission4 = new ObjectPermission("PublicRead", n10, "public-read");
        int n11 = 2;
        PublicReadWrite = objectPermission3 = new ObjectPermission("PublicReadWrite", n11, "public-read-write");
        int n12 = 3;
        Default = objectPermission2 = new ObjectPermission("Default", n12, "default");
        int n13 = 4;
        Unknown = objectPermission = new ObjectPermission("Unknown", n13, "");
        ObjectPermission[] objectPermissionArray = new ObjectPermission[5];
        objectPermissionArray[0] = objectPermission5;
        objectPermissionArray[n10] = objectPermission4;
        objectPermissionArray[n11] = objectPermission3;
        objectPermissionArray[n12] = objectPermission2;
        objectPermissionArray[n13] = objectPermission;
        $VALUES = objectPermissionArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ObjectPermission() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.permissionString = var3_1;
    }

    public static ObjectPermission parsePermission(String string2) {
        int n10 = 4;
        ObjectPermission[] objectPermissionArray = new ObjectPermission[n10];
        ObjectPermission objectPermission = Private;
        objectPermissionArray[0] = objectPermission;
        objectPermissionArray[1] = objectPermission = PublicRead;
        objectPermissionArray[2] = objectPermission = PublicReadWrite;
        objectPermission = Default;
        int n11 = 3;
        objectPermissionArray[n11] = objectPermission;
        for (int i10 = 0; i10 < n10; ++i10) {
            objectPermission = objectPermissionArray[i10];
            String string3 = objectPermission.permissionString;
            n11 = (int)(string3.equals(string2) ? 1 : 0);
            if (n11 == 0) continue;
            return objectPermission;
        }
        return Unknown;
    }

    public static ObjectPermission valueOf(String string2) {
        return Enum.valueOf(ObjectPermission.class, string2);
    }

    public static ObjectPermission[] values() {
        return (ObjectPermission[])$VALUES.clone();
    }

    public String toString() {
        return this.permissionString;
    }
}

