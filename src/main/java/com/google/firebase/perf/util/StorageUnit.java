/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.util;

import com.google.firebase.perf.util.StorageUnit$1;
import com.google.firebase.perf.util.StorageUnit$2;
import com.google.firebase.perf.util.StorageUnit$3;
import com.google.firebase.perf.util.StorageUnit$4;
import com.google.firebase.perf.util.StorageUnit$5;

public abstract class StorageUnit
extends Enum {
    private static final /* synthetic */ StorageUnit[] $VALUES;
    public static final /* enum */ StorageUnit BYTES;
    public static final /* enum */ StorageUnit GIGABYTES;
    public static final /* enum */ StorageUnit KILOBYTES;
    public static final /* enum */ StorageUnit MEGABYTES;
    public static final /* enum */ StorageUnit TERABYTES;
    public long numBytes;

    static {
        StorageUnit$1 storageUnit$1 = new StorageUnit$1(0x10000000000L);
        TERABYTES = storageUnit$1;
        int n10 = 1;
        StorageUnit$2 storageUnit$2 = new StorageUnit$2(0x40000000L);
        GIGABYTES = storageUnit$2;
        int n11 = 2;
        StorageUnit$3 storageUnit$3 = new StorageUnit$3(0x100000L);
        MEGABYTES = storageUnit$3;
        int n12 = 3;
        StorageUnit$4 storageUnit$4 = new StorageUnit$4(1024L);
        KILOBYTES = storageUnit$4;
        int n13 = 4;
        StorageUnit$5 storageUnit$5 = new StorageUnit$5(1L);
        BYTES = storageUnit$5;
        StorageUnit[] storageUnitArray = new StorageUnit[5];
        storageUnitArray[0] = storageUnit$1;
        storageUnitArray[n10] = storageUnit$2;
        storageUnitArray[n11] = storageUnit$3;
        storageUnitArray[n12] = storageUnit$4;
        storageUnitArray[n13] = storageUnit$5;
        $VALUES = storageUnitArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private StorageUnit() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.numBytes = var3_1;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public /* synthetic */ StorageUnit(long l10, StorageUnit$1 storageUnit$1) {
        this((String)var1_-1, (int)var2_1, (long)storageUnit$1);
        void var2_1;
        void var1_-1;
    }

    public static StorageUnit valueOf(String string2) {
        return Enum.valueOf(StorageUnit.class, string2);
    }

    public static StorageUnit[] values() {
        return (StorageUnit[])$VALUES.clone();
    }

    public abstract long convert(long var1, StorageUnit var3);

    public long toBytes(long l10) {
        long l11 = this.numBytes;
        return l10 * l11;
    }

    public long toGigabytes(long l10) {
        long l11 = this.numBytes;
        l10 *= l11;
        l11 = StorageUnit.GIGABYTES.numBytes;
        return l10 / l11;
    }

    public long toKilobytes(long l10) {
        long l11 = this.numBytes;
        l10 *= l11;
        l11 = StorageUnit.KILOBYTES.numBytes;
        return l10 / l11;
    }

    public long toMegabytes(long l10) {
        long l11 = this.numBytes;
        l10 *= l11;
        l11 = StorageUnit.MEGABYTES.numBytes;
        return l10 / l11;
    }

    public long toTerabytes(long l10) {
        long l11 = this.numBytes;
        l10 *= l11;
        l11 = StorageUnit.TERABYTES.numBytes;
        return l10 / l11;
    }
}

