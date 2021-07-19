/*
 * Decompiled with CFR 0.151.
 */
package org.apache.tools.zip;

public final class ZipShort
implements Cloneable {
    private int value;

    public ZipShort(int n10) {
        this.value = n10;
    }

    public ZipShort(byte[] byArray) {
        this(byArray, 0);
    }

    public ZipShort(byte[] byArray, int n10) {
        int n11;
        this.value = n11 = ZipShort.getValue(byArray, n10);
    }

    public static byte[] getBytes(int n10) {
        byte by2 = (byte)(n10 & 0xFF);
        byte[] byArray = new byte[]{by2, n10 = (int)((byte)((n10 & 0xFF00) >> 8))};
        return byArray;
    }

    public static int getValue(byte[] byArray) {
        return ZipShort.getValue(byArray, 0);
    }

    public static int getValue(byte[] byArray, int n10) {
        int n11 = n10 + 1;
        n11 = byArray[n11] << 8 & 0xFF00;
        int n12 = byArray[n10] & 0xFF;
        return n11 + n12;
    }

    public boolean equals(Object object) {
        int n10;
        int n11;
        boolean bl2 = false;
        if (object != null && (n11 = object instanceof ZipShort) != 0 && (n11 = this.value) == (n10 = ((ZipShort)(object = (ZipShort)object)).getValue())) {
            bl2 = true;
        }
        return bl2;
    }

    public byte[] getBytes() {
        byte by2;
        byte[] byArray = new byte[2];
        int n10 = this.value;
        byArray[0] = by2 = (byte)(n10 & 0xFF);
        byArray[1] = n10 = (int)((byte)((n10 & 0xFF00) >> 8));
        return byArray;
    }

    public int getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value;
    }
}

