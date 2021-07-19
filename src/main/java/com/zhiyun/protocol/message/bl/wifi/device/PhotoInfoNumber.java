/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.message.bl.wifi.device;

public final class PhotoInfoNumber
extends Enum {
    public static final /* enum */ PhotoInfoNumber BOARD;
    public static final /* enum */ PhotoInfoNumber CAPABILITIES;
    public static final /* enum */ PhotoInfoNumber FIRMWARE;
    public static final /* enum */ PhotoInfoNumber HAS_DEFAULT_CREDENTIALS;
    public static final /* enum */ PhotoInfoNumber MAC;
    public static final /* enum */ PhotoInfoNumber MODEL;
    public static final /* enum */ PhotoInfoNumber NAME;
    public static final /* enum */ PhotoInfoNumber SERIAL;
    public static final /* enum */ PhotoInfoNumber SSID;
    private static final int a;
    private static final /* synthetic */ PhotoInfoNumber[] b;
    private final int number;

    static {
        PhotoInfoNumber photoInfoNumber;
        PhotoInfoNumber photoInfoNumber2;
        PhotoInfoNumber photoInfoNumber3;
        PhotoInfoNumber photoInfoNumber4;
        PhotoInfoNumber photoInfoNumber5;
        PhotoInfoNumber photoInfoNumber6;
        PhotoInfoNumber photoInfoNumber7;
        PhotoInfoNumber photoInfoNumber8;
        PhotoInfoNumber photoInfoNumber9;
        int n10 = 1;
        MODEL = photoInfoNumber9 = new PhotoInfoNumber("MODEL", 0, n10);
        int n11 = 2;
        NAME = photoInfoNumber8 = new PhotoInfoNumber("NAME", n10, n11);
        int n12 = 3;
        SERIAL = photoInfoNumber7 = new PhotoInfoNumber("SERIAL", n11, n12);
        int n13 = 4;
        FIRMWARE = photoInfoNumber6 = new PhotoInfoNumber("FIRMWARE", n12, n13);
        int n14 = 5;
        BOARD = photoInfoNumber5 = new PhotoInfoNumber("BOARD", n13, n14);
        int n15 = 6;
        MAC = photoInfoNumber4 = new PhotoInfoNumber("MAC", n14, n15);
        int n16 = 7;
        SSID = photoInfoNumber3 = new PhotoInfoNumber("SSID", n15, n16);
        n14 = 8;
        HAS_DEFAULT_CREDENTIALS = photoInfoNumber2 = new PhotoInfoNumber("HAS_DEFAULT_CREDENTIALS", n16, n14);
        n13 = 9;
        CAPABILITIES = photoInfoNumber = new PhotoInfoNumber("CAPABILITIES", n14, n13);
        PhotoInfoNumber[] photoInfoNumberArray = new PhotoInfoNumber[n13];
        photoInfoNumberArray[0] = photoInfoNumber9;
        photoInfoNumberArray[n10] = photoInfoNumber8;
        photoInfoNumberArray[n11] = photoInfoNumber7;
        photoInfoNumberArray[n12] = photoInfoNumber6;
        photoInfoNumberArray[4] = photoInfoNumber5;
        photoInfoNumberArray[5] = photoInfoNumber4;
        photoInfoNumberArray[6] = photoInfoNumber3;
        photoInfoNumberArray[7] = photoInfoNumber2;
        photoInfoNumberArray[n14] = photoInfoNumber;
        b = photoInfoNumberArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private PhotoInfoNumber() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.number = var3_1;
    }

    public static PhotoInfoNumber from(int n10) {
        PhotoInfoNumber photoInfoNumber = MODEL;
        int n11 = photoInfoNumber.number;
        if (n10 == n11) {
            return photoInfoNumber;
        }
        photoInfoNumber = NAME;
        n11 = photoInfoNumber.number;
        if (n10 == n11) {
            return photoInfoNumber;
        }
        photoInfoNumber = SERIAL;
        n11 = photoInfoNumber.number;
        if (n10 == n11) {
            return photoInfoNumber;
        }
        photoInfoNumber = FIRMWARE;
        n11 = photoInfoNumber.number;
        if (n10 == n11) {
            return photoInfoNumber;
        }
        photoInfoNumber = BOARD;
        n11 = photoInfoNumber.number;
        if (n10 == n11) {
            return photoInfoNumber;
        }
        photoInfoNumber = MAC;
        n11 = photoInfoNumber.number;
        if (n10 == n11) {
            return photoInfoNumber;
        }
        photoInfoNumber = SSID;
        n11 = photoInfoNumber.number;
        if (n10 == n11) {
            return photoInfoNumber;
        }
        photoInfoNumber = HAS_DEFAULT_CREDENTIALS;
        n11 = photoInfoNumber.number;
        if (n10 == n11) {
            return photoInfoNumber;
        }
        return CAPABILITIES;
    }

    public static PhotoInfoNumber valueOf(String string2) {
        return Enum.valueOf(PhotoInfoNumber.class, string2);
    }

    public static PhotoInfoNumber[] values() {
        return (PhotoInfoNumber[])b.clone();
    }

    public int getNumber() {
        return this.number;
    }
}

