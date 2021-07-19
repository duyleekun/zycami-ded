/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.codec;

import java.security.MessageDigest;

public class SHA1 {
    public static String compute(byte[] byArray) {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        int n10 = byArray.length;
        messageDigest.update(byArray, 0, n10);
        return SHA1.convertToHex(messageDigest.digest());
    }

    private static String convertToHex(byte[] byArray) {
        StringBuilder stringBuilder = new StringBuilder();
        block0: for (byte by2 : byArray) {
            int n10 = by2 >>> 4 & 0xF;
            int n11 = 0;
            while (true) {
                int n12;
                n10 = n10 >= 0 && n10 <= (n12 = 9) ? (n10 += 48) : n10 + -10 + 97;
                n10 = (char)n10;
                stringBuilder.append((char)n10);
                n10 = by2 & 0xF;
                n12 = n11 + 1;
                int n13 = 1;
                if (n11 >= n13) {
                    continue block0;
                }
                n11 = n12;
            }
        }
        return stringBuilder.toString();
    }
}

