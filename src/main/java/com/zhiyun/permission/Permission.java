/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.permission;

public final class Permission
extends Enum {
    public static final /* enum */ Permission CAMERA;
    public static final /* enum */ Permission CAMERA_GROUP;
    public static final /* enum */ Permission LOCATION;
    public static final /* enum */ Permission PHONE;
    public static final /* enum */ Permission RECORD;
    public static final /* enum */ Permission STORAGE;
    public static final /* enum */ Permission STORAGE_GROUP;
    private static final /* synthetic */ Permission[] a;

    static {
        Permission permission;
        Permission permission2;
        Permission permission3;
        Permission permission4;
        Permission permission5;
        Permission permission6;
        Permission permission7;
        CAMERA = permission7 = new Permission("CAMERA", 0);
        int n10 = 1;
        CAMERA_GROUP = permission6 = new Permission("CAMERA_GROUP", n10);
        int n11 = 2;
        STORAGE = permission5 = new Permission("STORAGE", n11);
        int n12 = 3;
        STORAGE_GROUP = permission4 = new Permission("STORAGE_GROUP", n12);
        int n13 = 4;
        PHONE = permission3 = new Permission("PHONE", n13);
        int n14 = 5;
        LOCATION = permission2 = new Permission("LOCATION", n14);
        int n15 = 6;
        RECORD = permission = new Permission("RECORD", n15);
        Permission[] permissionArray = new Permission[7];
        permissionArray[0] = permission7;
        permissionArray[n10] = permission6;
        permissionArray[n11] = permission5;
        permissionArray[n12] = permission4;
        permissionArray[n13] = permission3;
        permissionArray[n14] = permission2;
        permissionArray[n15] = permission;
        a = permissionArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Permission() {
        void var2_-1;
        void var1_-1;
    }

    public static Permission valueOf(String string2) {
        return Enum.valueOf(Permission.class, string2);
    }

    public static Permission[] values() {
        return (Permission[])a.clone();
    }
}

