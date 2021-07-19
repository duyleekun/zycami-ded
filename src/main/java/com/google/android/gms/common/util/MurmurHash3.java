/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.util;

public class MurmurHash3 {
    private MurmurHash3() {
    }

    public static int murmurhash3_x86_32(byte[] byArray, int n10, int n11, int n12) {
        int n13;
        block5: {
            int n14;
            int n15;
            int n16;
            block3: {
                int n17;
                block4: {
                    int n18;
                    n16 = (n11 & 0xFFFFFFFC) + n10;
                    while (true) {
                        n15 = 461845907;
                        n14 = -862048943;
                        if (n10 >= n16) break;
                        n17 = byArray[n10] & 0xFF;
                        n18 = n10 + 1;
                        n18 = (byArray[n18] & 0xFF) << 8;
                        n17 |= n18;
                        n18 = n10 + 2;
                        n18 = (byArray[n18] & 0xFF) << 16;
                        n17 |= n18;
                        n18 = n10 + 3;
                        n18 = byArray[n18] << 24;
                        n17 = (n17 | n18) * n14;
                        n14 = n17 << 15;
                        n14 = (n14 | (n17 >>>= 17)) * n15;
                        n15 = (n12 ^= n14) << 13;
                        n12 = (n12 >>> 19 | n15) * 5;
                        n15 = -430675100;
                        n12 += n15;
                        n10 += 4;
                    }
                    n10 = 0;
                    n17 = n11 & 3;
                    n18 = 1;
                    if (n17 == n18) break block3;
                    n18 = 2;
                    if (n17 == n18) break block4;
                    n10 = 3;
                    if (n17 != n10) break block5;
                    n10 = n16 + 2;
                    n10 = (byArray[n10] & 0xFF) << 16;
                }
                n17 = n16 + 1;
                n17 = (byArray[n17] & 0xFF) << 8;
                n10 |= n17;
            }
            n13 = (byArray[n16] & 0xFF | n10) * n14;
            n10 = n13 << 15;
            n13 = (n13 >>> 17 | n10) * n15;
            n12 ^= n13;
        }
        n13 = n12 ^ n11;
        n10 = n13 >>> 16;
        n13 = (n13 ^ n10) * -2048144789;
        n10 = n13 >>> 13;
        n13 = (n13 ^ n10) * -1028477387;
        n10 = n13 >>> 16;
        return n13 ^ n10;
    }
}

