/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode$BytesHashCode;
import com.google.common.hash.HashCode$IntHashCode;
import com.google.common.hash.HashCode$LongHashCode;
import com.google.common.primitives.Ints;

public abstract class HashCode {
    private static final char[] hexDigits = "0123456789abcdef".toCharArray();

    private static int decode(char n10) {
        int n11;
        int n12 = 48;
        if (n10 >= n12 && n10 <= (n11 = 57)) {
            return n10 - n12;
        }
        n12 = 97;
        if (n10 >= n12 && n10 <= (n11 = 102)) {
            return n10 - n12 + 10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Illegal hexadecimal character: ");
        stringBuilder.append((char)n10);
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static HashCode fromBytes(byte[] byArray) {
        boolean bl2 = byArray.length;
        boolean bl3 = true;
        if (bl2 < bl3) {
            bl3 = false;
        }
        Preconditions.checkArgument(bl3, "A HashCode must contain at least 1 byte.");
        return HashCode.fromBytesNoCopy((byte[])byArray.clone());
    }

    public static HashCode fromBytesNoCopy(byte[] byArray) {
        HashCode$BytesHashCode hashCode$BytesHashCode = new HashCode$BytesHashCode(byArray);
        return hashCode$BytesHashCode;
    }

    public static HashCode fromInt(int n10) {
        HashCode$IntHashCode hashCode$IntHashCode = new HashCode$IntHashCode(n10);
        return hashCode$IntHashCode;
    }

    public static HashCode fromLong(long l10) {
        HashCode$LongHashCode hashCode$LongHashCode = new HashCode$LongHashCode(l10);
        return hashCode$LongHashCode;
    }

    public static HashCode fromString(String string2) {
        byte[] byArray;
        int n10 = string2.length();
        int n11 = 1;
        int n12 = 0;
        int n13 = 2;
        if (n10 >= n13) {
            n10 = n11;
        } else {
            n10 = 0;
            byArray = null;
        }
        String string3 = "input string (%s) must have at least 2 characters";
        Preconditions.checkArgument(n10 != 0, string3, (Object)string2);
        n10 = string2.length() % n13;
        if (n10 != 0) {
            n11 = 0;
        }
        Preconditions.checkArgument(n11 != 0, "input string (%s) must have an even number of characters", (Object)string2);
        n10 = string2.length() / n13;
        byArray = new byte[n10];
        while (n12 < (n11 = string2.length())) {
            n11 = HashCode.decode(string2.charAt(n12)) << 4;
            n13 = n12 + 1;
            n13 = HashCode.decode(string2.charAt(n13));
            int n14 = n12 / 2;
            byArray[n14] = n11 = (int)((byte)(n11 + n13));
            n12 += 2;
        }
        return HashCode.fromBytesNoCopy(byArray);
    }

    public abstract byte[] asBytes();

    public abstract int asInt();

    public abstract long asLong();

    public abstract int bits();

    public final boolean equals(Object object) {
        int n10 = object instanceof HashCode;
        boolean bl2 = false;
        if (n10 != 0) {
            boolean bl3;
            int n11;
            object = (HashCode)object;
            n10 = this.bits();
            if (n10 == (n11 = ((HashCode)object).bits()) && (bl3 = this.equalsSameBits((HashCode)object))) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public abstract boolean equalsSameBits(HashCode var1);

    public byte[] getBytesInternal() {
        return this.asBytes();
    }

    public final int hashCode() {
        int n10;
        int n11;
        int n12 = this.bits();
        if (n12 >= (n11 = 32)) {
            return this.asInt();
        }
        byte[] byArray = this.getBytesInternal();
        n11 = byArray[0] & 0xFF;
        for (int i10 = 1; i10 < (n10 = byArray.length); ++i10) {
            n10 = byArray[i10] & 0xFF;
            int n13 = i10 * 8;
            n11 |= (n10 <<= n13);
        }
        return n11;
    }

    public abstract long padToLong();

    public final String toString() {
        byte[] byArray = this.getBytesInternal();
        int n10 = byArray.length * 2;
        StringBuilder stringBuilder = new StringBuilder(n10);
        for (char c10 : byArray) {
            char[] cArray = hexDigits;
            char c11 = c10 >> 4 & 0xF;
            c11 = cArray[c11];
            stringBuilder.append(c11);
            c10 &= 0xF;
            c10 = cArray[c10];
            stringBuilder.append(c10);
        }
        return stringBuilder.toString();
    }

    public int writeBytesTo(byte[] byArray, int n10, int n11) {
        int[] nArray = new int[]{n11, n11 = this.bits() / 8};
        n11 = Ints.min(nArray);
        int n12 = n10 + n11;
        int n13 = byArray.length;
        Preconditions.checkPositionIndexes(n10, n12, n13);
        this.writeBytesToImpl(byArray, n10, n11);
        return n11;
    }

    public abstract void writeBytesToImpl(byte[] var1, int var2, int var3);
}

