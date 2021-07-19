/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

public final class MapField$StorageMode
extends Enum {
    private static final /* synthetic */ MapField$StorageMode[] $VALUES;
    public static final /* enum */ MapField$StorageMode BOTH;
    public static final /* enum */ MapField$StorageMode LIST;
    public static final /* enum */ MapField$StorageMode MAP;

    static {
        MapField$StorageMode mapField$StorageMode;
        MapField$StorageMode mapField$StorageMode2;
        MapField$StorageMode mapField$StorageMode3;
        MAP = mapField$StorageMode3 = new MapField$StorageMode("MAP", 0);
        int n10 = 1;
        LIST = mapField$StorageMode2 = new MapField$StorageMode("LIST", n10);
        int n11 = 2;
        BOTH = mapField$StorageMode = new MapField$StorageMode("BOTH", n11);
        MapField$StorageMode[] mapField$StorageModeArray = new MapField$StorageMode[3];
        mapField$StorageModeArray[0] = mapField$StorageMode3;
        mapField$StorageModeArray[n10] = mapField$StorageMode2;
        mapField$StorageModeArray[n11] = mapField$StorageMode;
        $VALUES = mapField$StorageModeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private MapField$StorageMode() {
        void var2_-1;
        void var1_-1;
    }

    public static MapField$StorageMode valueOf(String string2) {
        return Enum.valueOf(MapField$StorageMode.class, string2);
    }

    public static MapField$StorageMode[] values() {
        return (MapField$StorageMode[])$VALUES.clone();
    }
}

