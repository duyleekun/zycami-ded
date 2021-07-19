/*
 * Decompiled with CFR 0.151.
 */
package d.v.x;

import com.zhiyun.permission.Permission;

public class c$a {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        Permission permission;
        int n12 = Permission.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            permission = Permission.PHONE;
            n11 = permission.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            permission = Permission.CAMERA;
            n11 = permission.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            permission = Permission.RECORD;
            n11 = permission.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            permission = Permission.STORAGE;
            n11 = permission.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            permission = Permission.STORAGE_GROUP;
            n11 = permission.ordinal();
            nArray[n11] = n10 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            permission = Permission.LOCATION;
            n11 = permission.ordinal();
            nArray[n11] = n10 = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            permission = Permission.CAMERA_GROUP;
            n11 = permission.ordinal();
            nArray[n11] = n10 = 7;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

