/*
 * Decompiled with CFR 0.151.
 */
package com.bumptech.glide.load;

public final class DataSource
extends Enum {
    public static final /* enum */ DataSource DATA_DISK_CACHE;
    public static final /* enum */ DataSource LOCAL;
    public static final /* enum */ DataSource MEMORY_CACHE;
    public static final /* enum */ DataSource REMOTE;
    public static final /* enum */ DataSource RESOURCE_DISK_CACHE;
    private static final /* synthetic */ DataSource[] a;

    static {
        DataSource dataSource;
        DataSource dataSource2;
        DataSource dataSource3;
        DataSource dataSource4;
        DataSource dataSource5;
        LOCAL = dataSource5 = new DataSource("LOCAL", 0);
        int n10 = 1;
        REMOTE = dataSource4 = new DataSource("REMOTE", n10);
        int n11 = 2;
        DATA_DISK_CACHE = dataSource3 = new DataSource("DATA_DISK_CACHE", n11);
        int n12 = 3;
        RESOURCE_DISK_CACHE = dataSource2 = new DataSource("RESOURCE_DISK_CACHE", n12);
        int n13 = 4;
        MEMORY_CACHE = dataSource = new DataSource("MEMORY_CACHE", n13);
        DataSource[] dataSourceArray = new DataSource[5];
        dataSourceArray[0] = dataSource5;
        dataSourceArray[n10] = dataSource4;
        dataSourceArray[n11] = dataSource3;
        dataSourceArray[n12] = dataSource2;
        dataSourceArray[n13] = dataSource;
        a = dataSourceArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private DataSource() {
        void var2_-1;
        void var1_-1;
    }

    public static DataSource valueOf(String string2) {
        return Enum.valueOf(DataSource.class, string2);
    }

    public static DataSource[] values() {
        return (DataSource[])a.clone();
    }
}

