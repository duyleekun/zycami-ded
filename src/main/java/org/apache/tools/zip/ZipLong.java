/*
 * Decompiled with CFR 0.151.
 */
package org.apache.tools.zip;

public final class ZipLong
implements Cloneable {
    private long value;

    public ZipLong(long l10) {
        this.value = l10;
    }

    public ZipLong(byte[] byArray) {
        this(byArray, 0);
    }

    public ZipLong(byte[] byArray, int n10) {
        long l10;
        this.value = l10 = ZipLong.getValue(byArray, n10);
    }

    public static byte[] getBytes(long l10) {
        byte by2 = (byte)(0xFFL & l10);
        by2 = (byte)((0xFF00L & l10) >> 8);
        by2 = (byte)((0xFF0000L & l10) >> 16);
        byte by3 = (byte)((l10 & 0xFF000000L) >> 24);
        byte[] byArray = new byte[]{by2, by2, by2, by3};
        return byArray;
    }

    public static long getValue(byte[] byArray) {
        return ZipLong.getValue(byArray, 0);
    }

    public static long getValue(byte[] byArray, int n10) {
        int n11 = n10 + 3;
        long l10 = (long)(byArray[n11] << 24) & 0xFF000000L;
        int n12 = n10 + 2;
        long l11 = byArray[n12] << 16 & 0xFF0000;
        l10 += l11;
        n12 = n10 + 1;
        l11 = byArray[n12] << 8 & 0xFF00;
        long l12 = byArray[n10] & 0xFF;
        return (l10 += l11) + l12;
    }

    public boolean equals(Object object) {
        long l10;
        long l11;
        long l12;
        long l13;
        boolean bl2;
        boolean bl3 = false;
        if (object != null && (bl2 = object instanceof ZipLong) && (l13 = (l12 = (l11 = this.value) - (l10 = ((ZipLong)(object = (ZipLong)object)).getValue())) == 0L ? 0 : (l12 < 0L ? -1 : 1)) == false) {
            bl3 = true;
        }
        return bl3;
    }

    public byte[] getBytes() {
        return ZipLong.getBytes(this.value);
    }

    public long getValue() {
        return this.value;
    }

    public int hashCode() {
        return (int)this.value;
    }
}

