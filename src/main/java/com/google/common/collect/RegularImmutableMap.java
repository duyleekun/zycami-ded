/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Hashing;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableMap$EntrySet;
import com.google.common.collect.RegularImmutableMap$KeySet;
import com.google.common.collect.RegularImmutableMap$KeysOrValuesAsList;
import java.util.Arrays;

public final class RegularImmutableMap
extends ImmutableMap {
    private static final byte ABSENT = -1;
    private static final int BYTE_MASK = 255;
    private static final int BYTE_MAX_SIZE = 128;
    public static final ImmutableMap EMPTY;
    private static final int SHORT_MASK = 65535;
    private static final int SHORT_MAX_SIZE = 32768;
    private static final long serialVersionUID;
    public final transient Object[] alternatingKeysAndValues;
    private final transient Object hashTable;
    private final transient int size;

    static {
        Object[] objectArray = new Object[]{};
        RegularImmutableMap regularImmutableMap = new RegularImmutableMap(null, objectArray, 0);
        EMPTY = regularImmutableMap;
    }

    private RegularImmutableMap(Object object, Object[] objectArray, int n10) {
        this.hashTable = object;
        this.alternatingKeysAndValues = objectArray;
        this.size = n10;
    }

    public static RegularImmutableMap create(int n10, Object[] objectArray) {
        if (n10 == 0) {
            return (RegularImmutableMap)EMPTY;
        }
        Object object = null;
        int n11 = 1;
        if (n10 == n11) {
            Object object2 = objectArray[0];
            object = objectArray[n11];
            CollectPreconditions.checkEntryNotNull(object2, object);
            object2 = new RegularImmutableMap(null, objectArray, n11);
            return object2;
        }
        n11 = objectArray.length >> 1;
        Preconditions.checkPositionIndex(n10, n11);
        n11 = ImmutableSet.chooseTableSize(n10);
        object = RegularImmutableMap.createHashTable(objectArray, n10, n11, 0);
        RegularImmutableMap regularImmutableMap = new RegularImmutableMap(object, objectArray, n10);
        return regularImmutableMap;
    }

    public static Object createHashTable(Object[] objectArray, int n10, int n11, int n12) {
        int n13;
        int n14 = 1;
        if (n10 == n14) {
            Object object = objectArray[n12];
            n11 = n12 ^ 1;
            objectArray = objectArray[n11];
            CollectPreconditions.checkEntryNotNull(object, objectArray);
            return null;
        }
        n14 = n11 + -1;
        int n15 = 128;
        int n16 = -1;
        if (n11 <= n15) {
            byte[] byArray = new byte[n11];
            Arrays.fill(byArray, (byte)n16);
            block0: for (n13 = 0; n13 < n10; ++n13) {
                int n17;
                n15 = n13 * 2 + n12;
                Object object = objectArray[n15];
                int n18 = n15 ^ 1;
                Object object2 = objectArray[n18];
                CollectPreconditions.checkEntryNotNull(object, object2);
                int n19 = Hashing.smear(object.hashCode());
                while (true) {
                    n17 = byArray[n19 &= n14];
                    int n20 = 255;
                    if ((n17 &= n20) == n20) {
                        byArray[n19] = n15 = (int)((byte)n15);
                        continue block0;
                    }
                    Object object3 = objectArray[n17];
                    n20 = (int)(object3.equals(object) ? 1 : 0);
                    if (n20 != 0) break;
                    ++n19;
                }
                throw RegularImmutableMap.duplicateKeyException(object, object2, objectArray, n17);
            }
            return byArray;
        }
        n15 = 32768;
        if (n11 <= n15) {
            short[] sArray = new short[n11];
            Arrays.fill(sArray, (short)n16);
            block2: while (n13 < n10) {
                int n21;
                n15 = n13 * 2 + n12;
                Object object = objectArray[n15];
                int n22 = n15 ^ 1;
                Object object4 = objectArray[n22];
                CollectPreconditions.checkEntryNotNull(object, object4);
                int n23 = Hashing.smear(object.hashCode());
                while (true) {
                    n21 = sArray[n23 &= n14];
                    char c10 = (char)-1;
                    if ((n21 &= c10) == c10) {
                        sArray[n23] = n15 = (int)((short)n15);
                        ++n13;
                        continue block2;
                    }
                    Object object5 = objectArray[n21];
                    c10 = (char)(object5.equals(object) ? 1 : 0);
                    if (c10 != '\u0000') break;
                    ++n23;
                }
                throw RegularImmutableMap.duplicateKeyException(object, object4, objectArray, n21);
            }
            return sArray;
        }
        int[] nArray = new int[n11];
        Arrays.fill(nArray, n16);
        block4: while (n13 < n10) {
            int n24;
            n15 = n13 * 2 + n12;
            Object object = objectArray[n15];
            int n25 = n15 ^ 1;
            Object object6 = objectArray[n25];
            CollectPreconditions.checkEntryNotNull(object, object6);
            int n26 = Hashing.smear(object.hashCode());
            while (true) {
                if ((n24 = nArray[n26 &= n14]) == n16) {
                    nArray[n26] = n15;
                    ++n13;
                    continue block4;
                }
                Object object7 = objectArray[n24];
                boolean bl2 = object7.equals(object);
                if (bl2) break;
                ++n26;
            }
            throw RegularImmutableMap.duplicateKeyException(object, object6, objectArray, n24);
        }
        return nArray;
    }

    private static IllegalArgumentException duplicateKeyException(Object object, Object object2, Object[] objectArray, int n10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Multiple entries with same key: ");
        stringBuilder.append(object);
        object = "=";
        stringBuilder.append((String)object);
        stringBuilder.append(object2);
        stringBuilder.append(" and ");
        object2 = objectArray[n10];
        stringBuilder.append(object2);
        stringBuilder.append((String)object);
        int n11 = n10 ^ 1;
        object = objectArray[n11];
        stringBuilder.append(object);
        object = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        return illegalArgumentException;
    }

    public static Object get(Object object, Object[] objectArray, int n10, int n11, Object object2) {
        Object object3 = null;
        if (object2 == null) {
            return null;
        }
        int n12 = 1;
        if (n10 == n12) {
            object = objectArray[n11];
            int n13 = object.equals(object2);
            if (n13 != 0) {
                n13 = n11 ^ 1;
                object3 = objectArray[n13];
            }
            return object3;
        }
        if (object == null) {
            return null;
        }
        n10 = object instanceof byte[];
        if (n10 != 0) {
            Object object4 = object;
            object4 = (byte[])object;
            n11 = ((Object)object4).length + -1;
            int n14 = Hashing.smear(object2.hashCode());
            while (true) {
                Object object5 = object4[n14 &= n11];
                int n15 = 255;
                if ((object5 = (Object)(object5 & n15)) == n15) {
                    return null;
                }
                Object object6 = objectArray[object5];
                n15 = (int)(object6.equals(object2) ? 1 : 0);
                if (n15 != 0) {
                    n14 = object5 ^ 1;
                    return objectArray[n14];
                }
                ++n14;
            }
        }
        n10 = object instanceof short[];
        if (n10 != 0) {
            Object object7 = object;
            object7 = (short[])object;
            n11 = ((Object)object7).length + -1;
            int n16 = Hashing.smear(object2.hashCode());
            while (true) {
                Object object8 = object7[n16 &= n11];
                char c10 = (char)-1;
                if ((object8 = (Object)(object8 & c10)) == c10) {
                    return null;
                }
                Object object9 = objectArray[object8];
                c10 = (char)(object9.equals(object2) ? 1 : 0);
                if (c10 != '\u0000') {
                    n16 = object8 ^ 1;
                    return objectArray[n16];
                }
                ++n16;
            }
        }
        object = (int[])object;
        n10 = ((Object)object).length - n12;
        n11 = Hashing.smear(object2.hashCode());
        int n17;
        Object object10;
        while ((object10 = object[n11 &= n10]) != (n17 = -1)) {
            Object object11 = objectArray[object10];
            n17 = (int)(object11.equals(object2) ? 1 : 0);
            if (n17 != 0) {
                int n18 = object10 ^ 1;
                return objectArray[n18];
            }
            ++n11;
        }
        return null;
    }

    public ImmutableSet createEntrySet() {
        Object[] objectArray = this.alternatingKeysAndValues;
        int n10 = this.size;
        RegularImmutableMap$EntrySet regularImmutableMap$EntrySet = new RegularImmutableMap$EntrySet(this, objectArray, 0, n10);
        return regularImmutableMap$EntrySet;
    }

    public ImmutableSet createKeySet() {
        Object object = this.alternatingKeysAndValues;
        int n10 = this.size;
        RegularImmutableMap$KeysOrValuesAsList regularImmutableMap$KeysOrValuesAsList = new RegularImmutableMap$KeysOrValuesAsList((Object[])object, 0, n10);
        object = new RegularImmutableMap$KeySet(this, regularImmutableMap$KeysOrValuesAsList);
        return object;
    }

    public ImmutableCollection createValues() {
        Object[] objectArray = this.alternatingKeysAndValues;
        int n10 = this.size;
        RegularImmutableMap$KeysOrValuesAsList regularImmutableMap$KeysOrValuesAsList = new RegularImmutableMap$KeysOrValuesAsList(objectArray, 1, n10);
        return regularImmutableMap$KeysOrValuesAsList;
    }

    public Object get(Object object) {
        Object object2 = this.hashTable;
        Object[] objectArray = this.alternatingKeysAndValues;
        int n10 = this.size;
        return RegularImmutableMap.get(object2, objectArray, n10, 0, object);
    }

    public boolean isPartialView() {
        return false;
    }

    public int size() {
        return this.size;
    }
}

