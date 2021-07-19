/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.codec;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Base64Decoder
extends FilterInputStream {
    private static final char[] chars;
    private static final int[] ints;
    private int carryOver;
    private int charCount;

    static {
        char[] cArray;
        int n10 = 64;
        char[] cArray2 = cArray = new char[n10];
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
        ints = new int[128];
        int n11 = 0;
        cArray = null;
        while (n11 < n10) {
            int[] nArray = ints;
            char[] cArray4 = chars;
            char c10 = cArray4[n11];
            nArray[c10] = n11++;
        }
    }

    public Base64Decoder(InputStream inputStream) {
        super(inputStream);
    }

    public static String decode(String object) {
        object = Base64Decoder.decodeToBytes((String)object);
        String string2 = new String((byte[])object);
        return string2;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static byte[] decodeToBytes(String object) {
        double d10;
        Closeable closeable;
        Object object2 = "UTF-8";
        try {
            object = ((String)object).getBytes((String)object2);
            closeable = new ByteArrayInputStream((byte[])object);
            object2 = new Base64Decoder((InputStream)closeable);
            double d11 = ((Object)object).length;
            d10 = 0.67;
        }
        catch (UnsupportedEncodingException iOException) {
            return null;
        }
        int n10 = (int)(d11 *= d10);
        {
            closeable = new ByteArrayOutputStream(n10);
            n10 = 4096;
        }
        {
            object = new byte[n10];
            while (true) {
                int n11;
                int n12;
                if ((n12 = ((FilterInputStream)object2).read((byte[])object)) == (n11 = -1)) {
                    ((ByteArrayOutputStream)closeable).close();
                    return ((ByteArrayOutputStream)closeable).toByteArray();
                }
                n11 = 0;
                ((ByteArrayOutputStream)closeable).write((byte[])object, 0, n12);
            }
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void main(String[] object) {
        void var0_3;
        FilterInputStream filterInputStream;
        block7: {
            int n12;
            Base64Decoder base64Decoder;
            Closeable closeable;
            int n10 = ((Object)object).length;
            int n11 = 1;
            if (n10 != n11) {
                System.err.println("Usage: java Base64Decoder fileToDecode");
                return;
            }
            n10 = 0;
            filterInputStream = null;
            try {
                object = object[0];
                FileInputStream fileInputStream = new FileInputStream((String)object);
                closeable = new BufferedInputStream(fileInputStream);
                base64Decoder = new Base64Decoder((InputStream)closeable);
                n12 = 4096;
            }
            catch (Throwable throwable) {
                // empty catch block
                break block7;
            }
            try {
                int n13;
                object = new byte[n12];
                while ((n10 = base64Decoder.read((byte[])object)) != (n13 = -1)) {
                    closeable = System.out;
                    ((PrintStream)closeable).write((byte[])object, 0, n10);
                }
            }
            catch (Throwable throwable) {
                filterInputStream = base64Decoder;
                break block7;
            }
            base64Decoder.close();
            return;
        }
        if (filterInputStream != null) {
            filterInputStream.close();
        }
        throw var0_3;
    }

    public int read() {
        int n10;
        int n11;
        int n12;
        do {
            InputStream inputStream;
            if ((n11 = (inputStream = this.in).read()) != (n10 = -1)) continue;
            return n10;
        } while ((n12 = Character.isWhitespace((char)n11)) != 0);
        n12 = this.charCount;
        int n13 = 1;
        this.charCount = n12 += n13;
        int n14 = 61;
        if (n11 == n14) {
            return n10;
        }
        int[] nArray = ints;
        n11 = nArray[n11];
        if ((n12 = (n12 - n13) % 4) == 0) {
            this.carryOver = n11 &= 0x3F;
            return this.read();
        }
        n14 = 2;
        if (n12 == n13) {
            n10 = this.carryOver << n14;
            n12 = n11 >> 4;
            n10 = n10 + n12 & 0xFF;
            this.carryOver = n11 &= 0xF;
            return n10;
        }
        n13 = 3;
        if (n12 == n14) {
            n10 = this.carryOver << 4;
            n12 = n11 >> 2;
            n10 = n10 + n12 & 0xFF;
            this.carryOver = n11 &= n13;
            return n10;
        }
        if (n12 == n13) {
            return (this.carryOver << 6) + n11 & 0xFF;
        }
        return n10;
    }

    public int read(byte[] object, int n10, int n11) {
        int n12 = ((byte[])object).length;
        int n13 = n11 + n10 + -1;
        if (n12 >= n13) {
            Object var6_6 = null;
            for (n12 = 0; n12 < n11; ++n12) {
                int n14;
                n13 = this.read();
                if (n13 == (n14 = -1) && n12 == 0) {
                    return n14;
                }
                if (n13 == n14) break;
                n14 = n10 + n12;
                object[n14] = n13 = (int)((byte)n13);
            }
            return n12;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The input buffer is too small: ");
        stringBuilder.append(n11);
        stringBuilder.append(" bytes requested starting at offset ");
        stringBuilder.append(n10);
        stringBuilder.append(" while the buffer  is only ");
        int n15 = ((byte[])object).length;
        stringBuilder.append(n15);
        stringBuilder.append(" bytes long.");
        object = stringBuilder.toString();
        IOException iOException = new IOException((String)object);
        throw iOException;
    }
}

