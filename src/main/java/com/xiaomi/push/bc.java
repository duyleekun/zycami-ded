/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class bc {
    private static final String a;
    private static byte[] a;
    private static char[] a;

    static {
        int n10;
        char[] cArray;
        int n11;
        int n12;
        String string2;
        a = string2 = System.getProperty("line.separator");
        int n13 = 64;
        a = new char[n13];
        int n14 = 0;
        int n15 = 0;
        Object[] objectArray = null;
        for (n12 = 65; n12 <= (n11 = 90); n12 = (int)((char)(n12 + 1))) {
            cArray = a;
            n10 = n15 + 1;
            cArray[n15] = n12;
            n15 = n10;
        }
        for (n12 = 97; n12 <= (n11 = 122); n12 = (int)((char)(n12 + 1))) {
            cArray = a;
            n10 = n15 + 1;
            cArray[n15] = n12;
            n15 = n10;
        }
        for (n12 = 48; n12 <= (n11 = 57); n12 = (int)((char)(n12 + 1))) {
            cArray = a;
            n10 = n15 + 1;
            cArray[n15] = n12;
            n15 = n10;
        }
        Object[] objectArray2 = a;
        n11 = n15 + 1;
        objectArray2[n15] = n10 = 43;
        objectArray2[n11] = n15 = 47;
        a = new byte[128];
        objectArray2 = null;
        for (n12 = 0; n12 < (n11 = (objectArray = a).length); ++n12) {
            objectArray[n12] = n11 = -1;
        }
        while (n14 < n13) {
            objectArray2 = a;
            objectArray = a;
            n15 = objectArray[n14];
            objectArray2[n15] = n11 = (int)((byte)n14);
            ++n14;
        }
    }

    public static String a(String object) {
        object = bc.a(((String)object).getBytes());
        String string2 = new String((char[])object);
        return string2;
    }

    public static byte[] a(String string2) {
        return bc.a(string2.toCharArray());
    }

    public static byte[] a(char[] cArray) {
        int n10 = cArray.length;
        return bc.a(cArray, 0, n10);
    }

    public static byte[] a(char[] object, int n10, int n11) {
        int n12 = n11 % 4;
        if (n12 == 0) {
            while (n11 > 0) {
                n12 = n10 + n11 + -1;
                int n13 = 61;
                if ((n12 = object[n12]) != n13) break;
                n11 += -1;
            }
            n12 = n11 * 3 / 4;
            byte[] byArray = new byte[n12];
            n11 += n10;
            int n14 = 0;
            while (n10 < n11) {
                int n15;
                int n16 = n10 + 1;
                n10 = object[n10];
                int n17 = n16 + 1;
                n16 = object[n16];
                int n18 = 65;
                if (n17 < n11) {
                    n15 = n17 + 1;
                    n17 = object[n17];
                } else {
                    n15 = n17;
                    n17 = n18;
                }
                if (n15 < n11) {
                    n18 = n15 + 1;
                    n15 = object[n15];
                } else {
                    int n19 = n15;
                    n15 = n18;
                    n18 = n19;
                }
                String string2 = "Illegal character in Base64 encoded data.";
                int n20 = 127;
                if (n10 <= n20 && n16 <= n20 && n17 <= n20 && n15 <= n20) {
                    byte[] byArray2 = a;
                    n10 = byArray2[n10];
                    n16 = byArray2[n16];
                    n17 = byArray2[n17];
                    n15 = byArray2[n15];
                    if (n10 >= 0 && n16 >= 0 && n17 >= 0 && n15 >= 0) {
                        n10 <<= 2;
                        int n21 = n16 >>> 4;
                        n10 |= n21;
                        n16 = (n16 & 0xF) << 4;
                        n21 = n17 >>> 2;
                        n16 |= n21;
                        n17 = (n17 & 3) << 6 | n15;
                        n15 = n14 + 1;
                        byArray[n14] = n10 = (int)((byte)n10);
                        if (n15 < n12) {
                            n10 = n15 + 1;
                            byArray[n15] = n14 = (int)((byte)n16);
                            n15 = n10;
                        }
                        if (n15 < n12) {
                            n10 = n15 + 1;
                            byArray[n15] = n14 = (int)((byte)n17);
                            n14 = n10;
                        } else {
                            n14 = n15;
                        }
                        n10 = n18;
                        continue;
                    }
                    object = new IllegalArgumentException;
                    object(string2);
                    throw object;
                }
                object = new IllegalArgumentException;
                object(string2);
                throw object;
            }
            return byArray;
        }
        object = new IllegalArgumentException;
        object("Length of Base64 encoded input string is not a multiple of 4.");
        throw object;
    }

    public static char[] a(byte[] byArray) {
        int n10 = byArray.length;
        return bc.a(byArray, 0, n10);
    }

    public static char[] a(byte[] byArray, int n10, int n11) {
        int n12 = (n11 * 4 + 2) / 3;
        int n13 = (n11 + 2) / 3 * 4;
        char[] cArray = new char[n13];
        n11 += n10;
        int n14 = 0;
        while (n10 < n11) {
            int n15;
            int n16;
            int n17 = n10 + 1;
            n10 = byArray[n10] & 0xFF;
            if (n17 < n11) {
                n16 = n17 + 1;
                n17 = byArray[n17] & 0xFF;
            } else {
                n16 = n17;
                n17 = 0;
            }
            if (n16 < n11) {
                n15 = n16 + 1;
                n16 = byArray[n16] & 0xFF;
                int n18 = n15;
                n15 = n16;
                n16 = n18;
            } else {
                n15 = 0;
            }
            int n19 = n10 >>> 2;
            n10 = (n10 & 3) << 4;
            int n20 = n17 >>> 4;
            n10 |= n20;
            n17 = (n17 & 0xF) << 2;
            n20 = n15 >>> 6;
            n17 |= n20;
            n15 &= 0x3F;
            n20 = n14 + 1;
            char[] cArray2 = a;
            cArray[n14] = n19 = cArray2[n19];
            n14 = n20 + 1;
            cArray[n20] = n10 = cArray2[n10];
            n10 = 61;
            n17 = n14 < n12 ? cArray2[n17] : n10;
            cArray[n14] = n17;
            if (++n14 < n12) {
                n10 = cArray2[n15];
            }
            cArray[n14] = n10;
            ++n14;
            n10 = n16;
        }
        return cArray;
    }

    public static String b(String object) {
        object = bc.a((String)object);
        String string2 = new String((byte[])object);
        return string2;
    }
}

