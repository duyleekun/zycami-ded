/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.codec;

import cn.leancloud.codec.Base64$Decoder;
import cn.leancloud.codec.Base64$Encoder;
import java.io.UnsupportedEncodingException;

public class Base64 {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int CRLF = 4;
    public static final int DEFAULT = 0;
    public static final int NO_CLOSE = 16;
    public static final int NO_PADDING = 1;
    public static final int NO_WRAP = 2;
    public static final int URL_SAFE = 8;

    private Base64() {
    }

    public static byte[] decode(String string2, int n10) {
        return Base64.decode(string2.getBytes(), n10);
    }

    public static byte[] decode(byte[] byArray, int n10) {
        int n11 = byArray.length;
        return Base64.decode(byArray, 0, n11, n10);
    }

    public static byte[] decode(byte[] object, int n10, int n11, int n12) {
        int n13 = n11 * 3 / 4;
        byte[] byArray = new byte[n13];
        Base64$Decoder base64$Decoder = new Base64$Decoder(n12, byArray);
        int n14 = base64$Decoder.process((byte[])object, n10, n11, (n12 = 1) != 0);
        if (n14 != 0) {
            n14 = base64$Decoder.op;
            byte[] byArray2 = base64$Decoder.output;
            n11 = byArray2.length;
            if (n14 == n11) {
                return byArray2;
            }
            byte[] byArray3 = new byte[n14];
            System.arraycopy(byArray2, 0, byArray3, 0, n14);
            return byArray3;
        }
        object = new IllegalArgumentException;
        object("bad base-64");
        throw object;
    }

    public static byte[] encode(byte[] byArray, int n10) {
        int n11 = byArray.length;
        return Base64.encode(byArray, 0, n11, n10);
    }

    public static byte[] encode(byte[] byArray, int n10, int n11, int n12) {
        Base64$Encoder base64$Encoder = new Base64$Encoder(n12, null);
        n12 = n11 / 3 * 4;
        int n13 = base64$Encoder.do_padding;
        int n14 = 2;
        int n15 = 1;
        if (n13 != 0) {
            n13 = n11 % 3;
            if (n13 > 0) {
                n12 += 4;
            }
        } else {
            n13 = n11 % 3;
            if (n13 != n15) {
                if (n13 == n14) {
                    n12 += 3;
                }
            } else {
                n12 += 2;
            }
        }
        if ((n13 = (int)(base64$Encoder.do_newline ? 1 : 0)) != 0 && n11 > 0) {
            n13 = (n11 + -1) / 57 + n15;
            boolean bl2 = base64$Encoder.do_cr;
            if (!bl2) {
                n14 = n15;
            }
            n12 += (n13 *= n14);
        }
        byte[] byArray2 = new byte[n12];
        base64$Encoder.output = byArray2;
        base64$Encoder.process(byArray, n10, n11, n15 != 0);
        return base64$Encoder.output;
    }

    public static String encodeToString(byte[] byArray, int n10) {
        Object object;
        try {
            byArray = Base64.encode(byArray, n10);
            object = "US-ASCII";
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            object = new AssertionError((Object)unsupportedEncodingException);
            throw object;
        }
        String string2 = new String(byArray, (String)object);
        return string2;
    }

    public static String encodeToString(byte[] byArray, int n10, int n11, int n12) {
        Object object;
        try {
            byArray = Base64.encode(byArray, n10, n11, n12);
            object = "US-ASCII";
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            object = new AssertionError((Object)unsupportedEncodingException);
            throw object;
        }
        String string2 = new String(byArray, (String)object);
        return string2;
    }
}

