/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

public final class StorageClass
extends Enum {
    private static final /* synthetic */ StorageClass[] $VALUES;
    public static final /* enum */ StorageClass Archive;
    public static final /* enum */ StorageClass IA;
    public static final /* enum */ StorageClass Standard;
    public static final /* enum */ StorageClass Unknown;
    private String storageClassString;

    static {
        StorageClass storageClass;
        Object object = "Standard";
        Standard = storageClass = new StorageClass(object, 0, object);
        Object object2 = "IA";
        int n10 = 1;
        object = new StorageClass(object2, n10, object2);
        IA = object;
        Object object3 = "Archive";
        int n11 = 2;
        object2 = new StorageClass(object3, n11, object3);
        Archive = object2;
        StorageClass[] storageClassArray = "Unknown";
        int n12 = 3;
        object3 = new StorageClass((String)storageClassArray, n12, (String)storageClassArray);
        Unknown = object3;
        storageClassArray = new StorageClass[4];
        storageClassArray[0] = storageClass;
        storageClassArray[n10] = object;
        storageClassArray[n11] = object2;
        storageClassArray[n12] = object3;
        $VALUES = storageClassArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private StorageClass() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.storageClassString = var3_1;
    }

    public static StorageClass parse(String string2) {
        for (StorageClass storageClass : StorageClass.values()) {
            String string3 = storageClass.toString();
            boolean bl2 = string3.equals(string2);
            if (!bl2) continue;
            return storageClass;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to parse ");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static StorageClass valueOf(String string2) {
        return Enum.valueOf(StorageClass.class, string2);
    }

    public static StorageClass[] values() {
        return (StorageClass[])$VALUES.clone();
    }

    public String toString() {
        return this.storageClassString;
    }
}

