/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.collect.Hashing;
import java.util.Arrays;

public final class CompactHashing {
    private static final int BYTE_MASK = 255;
    private static final int BYTE_MAX_SIZE = 256;
    public static final int DEFAULT_SIZE = 3;
    public static final int HASH_TABLE_BITS_MASK = 31;
    private static final int HASH_TABLE_BITS_MAX_BITS = 5;
    public static final int MAX_SIZE = 0x3FFFFFFF;
    private static final int MIN_HASH_TABLE_SIZE = 4;
    public static final int MODIFICATION_COUNT_INCREMENT = 32;
    private static final int SHORT_MASK = 65535;
    private static final int SHORT_MAX_SIZE = 65536;
    public static final byte UNSET;

    private CompactHashing() {
    }

    public static Object createTable(int n10) {
        int n11 = 2;
        if (n10 >= n11 && n10 <= (n11 = 0x40000000) && (n11 = Integer.highestOneBit(n10)) == n10) {
            n11 = 256;
            if (n10 <= n11) {
                return new byte[n10];
            }
            n11 = 65536;
            if (n10 <= n11) {
                return new short[n10];
            }
            return new int[n10];
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("must be power of 2 between 2^1 and 2^30: ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static int getHashPrefix(int n10, int n11) {
        return n10 & (n11 ^= 0xFFFFFFFF);
    }

    public static int getNext(int n10, int n11) {
        return n10 & n11;
    }

    public static int maskCombine(int n10, int n11, int n12) {
        int n13 = ~n12;
        return (n10 &= n13) | (n11 &= n12);
    }

    public static int newCapacity(int n10) {
        int n11 = 32;
        n11 = n10 < n11 ? 4 : 2;
        return n11 * ++n10;
    }

    public static int remove(Object object, Object object2, int n10, Object object3, int[] nArray, Object[] objectArray, Object[] objectArray2) {
        int n11 = Hashing.smearedHash(object);
        int n12 = n11 & n10;
        int n13 = CompactHashing.tableGet(object3, n12);
        int n14 = -1;
        if (n13 == 0) {
            return n14;
        }
        n11 = CompactHashing.getHashPrefix(n11, n10);
        int n15 = n14;
        while (true) {
            Object object4;
            int n16;
            int n17;
            if ((n17 = CompactHashing.getHashPrefix(n16 = nArray[n13 += -1], n10)) == n11 && (n17 = (int)(Objects.equal(object, object4 = objectArray[n13]) ? 1 : 0)) != 0 && (objectArray2 == null || (n17 = (int)(Objects.equal(object2, object4 = objectArray2[n13]) ? 1 : 0)) != 0)) {
                int n18 = CompactHashing.getNext(n16, n10);
                if (n15 == n14) {
                    CompactHashing.tableSet(object3, n12, n18);
                } else {
                    int n19 = nArray[n15];
                    nArray[n15] = n18 = CompactHashing.maskCombine(n19, n18, n10);
                }
                return n13;
            }
            n15 = CompactHashing.getNext(n16, n10);
            if (n15 == 0) {
                return n14;
            }
            int n20 = n15;
            n15 = n13;
            n13 = n20;
        }
    }

    public static void tableClear(Object object) {
        boolean bl2 = object instanceof byte[];
        if (bl2) {
            object = (byte[])object;
            Arrays.fill((byte[])object, (byte)0);
        } else {
            bl2 = object instanceof short[];
            if (bl2) {
                object = (short[])object;
                Arrays.fill((short[])object, (short)0);
            } else {
                object = (int[])object;
                Arrays.fill((int[])object, 0);
            }
        }
    }

    public static int tableGet(Object object, int n10) {
        boolean bl2 = object instanceof byte[];
        if (bl2) {
            return ((byte[])object)[n10] & 0xFF;
        }
        bl2 = object instanceof short[];
        if (bl2) {
            return ((short[])object)[n10] & (char)-1;
        }
        return ((int[])object)[n10];
    }

    public static void tableSet(Object object, int n10, int n11) {
        boolean bl2 = object instanceof byte[];
        if (bl2) {
            object = (byte[])object;
            n11 = (byte)n11;
            object[n10] = n11;
        } else {
            bl2 = object instanceof short[];
            if (bl2) {
                object = (short[])object;
                n11 = (short)n11;
                object[n10] = n11;
            } else {
                object = (int[])object;
                object[n10] = n11;
            }
        }
    }

    public static int tableSize(int n10) {
        n10 = Hashing.closedTableSize(n10 + 1, 1.0);
        return Math.max(4, n10);
    }
}

