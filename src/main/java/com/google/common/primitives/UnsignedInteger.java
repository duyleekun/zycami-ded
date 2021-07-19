/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.base.Preconditions;
import com.google.common.primitives.UnsignedInts;
import java.math.BigInteger;

public final class UnsignedInteger
extends Number
implements Comparable {
    public static final UnsignedInteger MAX_VALUE;
    public static final UnsignedInteger ONE;
    public static final UnsignedInteger ZERO;
    private final int value = n10 &= 0xFFFFFFFF;

    static {
        ZERO = UnsignedInteger.fromIntBits(0);
        ONE = UnsignedInteger.fromIntBits(1);
        MAX_VALUE = UnsignedInteger.fromIntBits(-1);
    }

    private UnsignedInteger(int n10) {
    }

    public static UnsignedInteger fromIntBits(int n10) {
        UnsignedInteger unsignedInteger = new UnsignedInteger(n10);
        return unsignedInteger;
    }

    public static UnsignedInteger valueOf(long l10) {
        long l11 = 0xFFFFFFFFL & l10;
        long l12 = l11 - l10;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object == false ? (Object)1 : (Object)0;
        Preconditions.checkArgument((boolean)object, "value (%s) is outside the range for an unsigned integer value", l10);
        return UnsignedInteger.fromIntBits((int)l10);
    }

    public static UnsignedInteger valueOf(String string2) {
        return UnsignedInteger.valueOf(string2, 10);
    }

    public static UnsignedInteger valueOf(String string2, int n10) {
        return UnsignedInteger.fromIntBits(UnsignedInts.parseUnsignedInt(string2, n10));
    }

    public static UnsignedInteger valueOf(BigInteger bigInteger) {
        int n10;
        Preconditions.checkNotNull(bigInteger);
        int n11 = bigInteger.signum();
        n11 = n11 >= 0 && (n11 = bigInteger.bitLength()) <= (n10 = 32) ? 1 : 0;
        Preconditions.checkArgument(n11 != 0, "value (%s) is outside the range for an unsigned integer value", (Object)bigInteger);
        return UnsignedInteger.fromIntBits(bigInteger.intValue());
    }

    public BigInteger bigIntegerValue() {
        return BigInteger.valueOf(this.longValue());
    }

    public int compareTo(UnsignedInteger unsignedInteger) {
        Preconditions.checkNotNull(unsignedInteger);
        int n10 = this.value;
        int n11 = unsignedInteger.value;
        return UnsignedInts.compare(n10, n11);
    }

    public UnsignedInteger dividedBy(UnsignedInteger unsignedInteger) {
        int n10 = this.value;
        int n11 = ((UnsignedInteger)Preconditions.checkNotNull((Object)unsignedInteger)).value;
        return UnsignedInteger.fromIntBits(UnsignedInts.divide(n10, n11));
    }

    public double doubleValue() {
        return this.longValue();
    }

    public boolean equals(Object object) {
        int n10 = object instanceof UnsignedInteger;
        boolean bl2 = false;
        if (n10 != 0) {
            object = (UnsignedInteger)object;
            n10 = this.value;
            int n11 = ((UnsignedInteger)object).value;
            if (n10 == n11) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public float floatValue() {
        return this.longValue();
    }

    public int hashCode() {
        return this.value;
    }

    public int intValue() {
        return this.value;
    }

    public long longValue() {
        return UnsignedInts.toLong(this.value);
    }

    public UnsignedInteger minus(UnsignedInteger unsignedInteger) {
        int n10 = this.value;
        int n11 = ((UnsignedInteger)Preconditions.checkNotNull((Object)unsignedInteger)).value;
        return UnsignedInteger.fromIntBits(n10 - n11);
    }

    public UnsignedInteger mod(UnsignedInteger unsignedInteger) {
        int n10 = this.value;
        int n11 = ((UnsignedInteger)Preconditions.checkNotNull((Object)unsignedInteger)).value;
        return UnsignedInteger.fromIntBits(UnsignedInts.remainder(n10, n11));
    }

    public UnsignedInteger plus(UnsignedInteger unsignedInteger) {
        int n10 = this.value;
        int n11 = ((UnsignedInteger)Preconditions.checkNotNull((Object)unsignedInteger)).value;
        return UnsignedInteger.fromIntBits(n10 + n11);
    }

    public UnsignedInteger times(UnsignedInteger unsignedInteger) {
        int n10 = this.value;
        int n11 = ((UnsignedInteger)Preconditions.checkNotNull((Object)unsignedInteger)).value;
        return UnsignedInteger.fromIntBits(n10 * n11);
    }

    public String toString() {
        return this.toString(10);
    }

    public String toString(int n10) {
        return UnsignedInts.toString(this.value, n10);
    }
}

