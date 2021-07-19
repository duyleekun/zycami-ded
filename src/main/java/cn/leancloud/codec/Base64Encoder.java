/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.codec;

import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class Base64Encoder
extends FilterOutputStream {
    private static final char[] chars;
    private int carryOver;
    private int charCount;

    static {
        char[] cArray;
        char[] cArray2 = cArray = new char[64];
        char[] cArray3 = cArray;
        cArray2[0] = 65;
        cArray3[1] = 66;
        cArray2[2] = 67;
        cArray3[3] = 68;
        cArray2[4] = 69;
        cArray3[5] = 70;
        cArray2[6] = 71;
        cArray3[7] = 72;
        cArray2[8] = 73;
        cArray3[9] = 74;
        cArray2[10] = 75;
        cArray3[11] = 76;
        cArray2[12] = 77;
        cArray3[13] = 78;
        cArray2[14] = 79;
        cArray3[15] = 80;
        cArray2[16] = 81;
        cArray3[17] = 82;
        cArray2[18] = 83;
        cArray3[19] = 84;
        cArray2[20] = 85;
        cArray3[21] = 86;
        cArray2[22] = 87;
        cArray3[23] = 88;
        cArray2[24] = 89;
        cArray3[25] = 90;
        cArray2[26] = 97;
        cArray3[27] = 98;
        cArray2[28] = 99;
        cArray3[29] = 100;
        cArray2[30] = 101;
        cArray3[31] = 102;
        cArray2[32] = 103;
        cArray3[33] = 104;
        cArray2[34] = 105;
        cArray3[35] = 106;
        cArray2[36] = 107;
        cArray3[37] = 108;
        cArray2[38] = 109;
        cArray3[39] = 110;
        cArray2[40] = 111;
        cArray3[41] = 112;
        cArray2[42] = 113;
        cArray3[43] = 114;
        cArray2[44] = 115;
        cArray3[45] = 116;
        cArray2[46] = 117;
        cArray3[47] = 118;
        cArray2[48] = 119;
        cArray3[49] = 120;
        cArray2[50] = 121;
        cArray3[51] = 122;
        cArray2[52] = 48;
        cArray3[53] = 49;
        cArray2[54] = 50;
        cArray3[55] = 51;
        cArray2[56] = 52;
        cArray3[57] = 53;
        cArray2[58] = 54;
        cArray3[59] = 55;
        cArray2[60] = 56;
        cArray3[61] = 57;
        cArray2[62] = 43;
        cArray3[63] = 47;
        chars = cArray;
    }

    public Base64Encoder(OutputStream outputStream) {
        super(outputStream);
    }

    public static String encode(String object) {
        String string2 = "UTF-8";
        try {
            object = ((String)object).getBytes(string2);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            object = null;
        }
        if (object == null) {
            return null;
        }
        return Base64Encoder.encode((byte[])object);
    }

    public static String encode(byte[] object) {
        if (object == null) {
            return null;
        }
        double d10 = ((byte[])object).length;
        double d11 = 1.37;
        int n10 = (int)(d10 *= d11);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(n10);
        Base64Encoder base64Encoder = new Base64Encoder(byteArrayOutputStream);
        try {
            base64Encoder.write((byte[])object);
            base64Encoder.close();
        }
        catch (IOException iOException) {
            return null;
        }
        object = "UTF-8";
        return byteArrayOutputStream.toString((String)object);
    }

    public void close() {
        int n10 = this.charCount;
        int n11 = n10 % 3;
        int n12 = 61;
        int n13 = 1;
        if (n11 == n13) {
            n10 = this.carryOver << 4 & 0x3F;
            OutputStream outputStream = this.out;
            char[] cArray = chars;
            n10 = cArray[n10];
            outputStream.write(n10);
            this.out.write(n12);
            OutputStream outputStream2 = this.out;
            outputStream2.write(n12);
        } else {
            n11 = 2;
            if ((n10 %= 3) == n11) {
                n10 = this.carryOver << n11 & 0x3F;
                OutputStream outputStream = this.out;
                char[] cArray = chars;
                n10 = cArray[n10];
                outputStream.write(n10);
                OutputStream outputStream3 = this.out;
                outputStream3.write(n12);
            }
        }
        super.close();
    }

    public void write(int n10) {
        OutputStream outputStream;
        if (n10 < 0) {
            n10 += 256;
        }
        int n11 = this.charCount;
        int n12 = n11 % 3;
        int n13 = 1;
        if (n12 == 0) {
            n11 = n10 >> 2;
            this.carryOver = n10 &= 3;
            outputStream = this.out;
            char[] cArray = chars;
            n11 = cArray[n11];
            outputStream.write(n11);
        } else {
            n12 = n11 % 3;
            if (n12 == n13) {
                n11 = this.carryOver << 4;
                n12 = n10 >> 4;
                n11 = n11 + n12 & 0x3F;
                this.carryOver = n10 &= 0xF;
                outputStream = this.out;
                char[] cArray = chars;
                n11 = cArray[n11];
                outputStream.write(n11);
            } else {
                n12 = 2;
                if ((n11 %= 3) == n12) {
                    n11 = this.carryOver << n12;
                    n12 = n10 >> 6;
                    n11 = n11 + n12 & 0x3F;
                    OutputStream outputStream2 = this.out;
                    char[] cArray = chars;
                    n11 = cArray[n11];
                    outputStream2.write(n11);
                    n10 &= 0x3F;
                    OutputStream outputStream3 = this.out;
                    n10 = cArray[n10];
                    outputStream3.write(n10);
                    n10 = 0;
                    outputStream = null;
                    this.carryOver = 0;
                }
            }
        }
        this.charCount = n10 = this.charCount + n13;
        if ((n10 %= 57) == 0) {
            outputStream = this.out;
            n11 = 10;
            outputStream.write(n11);
        }
    }

    public void write(byte[] byArray, int n10, int n11) {
        for (int i10 = 0; i10 < n11; ++i10) {
            int n12 = n10 + i10;
            n12 = byArray[n12];
            this.write(n12);
        }
    }
}

