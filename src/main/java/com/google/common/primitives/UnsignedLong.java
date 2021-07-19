/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Longs;
import com.google.common.primitives.UnsignedLongs;
import java.io.Serializable;
import java.math.BigInteger;

public final class UnsignedLong
extends Number
implements Comparable,
Serializable {
    public static final UnsignedLong MAX_VALUE;
    public static final UnsignedLong ONE;
    private static final long UNSIGNED_MASK = Long.MAX_VALUE;
    public static final UnsignedLong ZERO;
    private final long value;

    static {
        UnsignedLong unsignedLong;
        ZERO = unsignedLong = new UnsignedLong(0L);
        ONE = unsignedLong = new UnsignedLong(1L);
        MAX_VALUE = unsignedLong = new UnsignedLong(-1);
    }

    private UnsignedLong(long l10) {
        this.value = l10;
    }

    public static UnsignedLong fromLongBits(long l10) {
        UnsignedLong unsignedLong = new UnsignedLong(l10);
        return unsignedLong;
    }

    public static UnsignedLong valueOf(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object >= 0 ? (Object)1 : (Object)0;
        Preconditions.checkArgument((boolean)object, "value (%s) is outside the range for an unsigned long value", l10);
        return UnsignedLong.fromLongBits(l10);
    }

    public static UnsignedLong valueOf(String string2) {
        return UnsignedLong.valueOf(string2, 10);
    }

    public static UnsignedLong valueOf(String string2, int n10) {
        return UnsignedLong.fromLongBits(UnsignedLongs.parseUnsignedLong(string2, n10));
    }

    public static UnsignedLong valueOf(BigInteger bigInteger) {
        int n10;
        Preconditions.checkNotNull(bigInteger);
        int n11 = bigInteger.signum();
        n11 = n11 >= 0 && (n11 = bigInteger.bitLength()) <= (n10 = 64) ? 1 : 0;
        Preconditions.checkArgument(n11 != 0, "value (%s) is outside the range for an unsigned long value", (Object)bigInteger);
        return UnsignedLong.fromLongBits(bigInteger.longValue());
    }

    public BigInteger bigIntegerValue() {
        long l10 = this.value;
        long l11 = Long.MAX_VALUE;
        BigInteger bigInteger = BigInteger.valueOf(l10 &= l11);
        long l12 = this.value;
        long l13 = 0L;
        long l14 = l12 - l13;
        Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object < 0) {
            object = 63;
            bigInteger = bigInteger.setBit((int)object);
        }
        return bigInteger;
    }

    public int compareTo(UnsignedLong unsignedLong) {
        Preconditions.checkNotNull(unsignedLong);
        long l10 = this.value;
        long l11 = unsignedLong.value;
        return UnsignedLongs.compare(l10, l11);
    }

    public UnsignedLong dividedBy(UnsignedLong unsignedLong) {
        long l10 = this.value;
        long l11 = ((UnsignedLong)Preconditions.checkNotNull((Object)unsignedLong)).value;
        return UnsignedLong.fromLongBits(UnsignedLongs.divide(l10, l11));
    }

    public double doubleValue() {
        long l10 = this.value;
        long l11 = Long.MAX_VALUE & l10;
        double d10 = l11;
        long l12 = 0L;
        long l13 = l10 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object < 0) {
            l10 = 4890909195324358656L;
            double d11 = 9.223372036854776E18;
            d10 += d11;
        }
        return d10;
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof UnsignedLong;
        boolean bl3 = false;
        if (bl2) {
            object = (UnsignedLong)object;
            long l10 = this.value;
            long l11 = ((UnsignedLong)object).value;
            long l12 = l10 - l11;
            Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2 == false) {
                bl3 = true;
            }
        }
        return bl3;
    }

    public float floatValue() {
        long l10 = this.value;
        long l11 = Long.MAX_VALUE & l10;
        float f10 = l11;
        long l12 = 0L;
        long l13 = l10 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object < 0) {
            object = 0x5F000000;
            float f11 = 9.223372E18f;
            f10 += f11;
        }
        return f10;
    }

    public int hashCode() {
        return Longs.hashCode(this.value);
    }

    public int intValue() {
        return (int)this.value;
    }

    public long longValue() {
        return this.value;
    }

    public UnsignedLong minus(UnsignedLong unsignedLong) {
        long l10 = this.value;
        long l11 = ((UnsignedLong)Preconditions.checkNotNull((Object)unsignedLong)).value;
        return UnsignedLong.fromLongBits(l10 - l11);
    }

    public UnsignedLong mod(UnsignedLong unsignedLong) {
        long l10 = this.value;
        long l11 = ((UnsignedLong)Preconditions.checkNotNull((Object)unsignedLong)).value;
        return UnsignedLong.fromLongBits(UnsignedLongs.remainder(l10, l11));
    }

    public UnsignedLong plus(UnsignedLong unsignedLong) {
        long l10 = this.value;
        long l11 = ((UnsignedLong)Preconditions.checkNotNull((Object)unsignedLong)).value;
        return UnsignedLong.fromLongBits(l10 + l11);
    }

    public UnsignedLong times(UnsignedLong unsignedLong) {
        long l10 = this.value;
        long l11 = ((UnsignedLong)Preconditions.checkNotNull((Object)unsignedLong)).value;
        return UnsignedLong.fromLongBits(l10 * l11);
    }

    public String toString() {
        return UnsignedLongs.toString(this.value);
    }

    public String toString(int n10) {
        return UnsignedLongs.toString(this.value, n10);
    }
}

