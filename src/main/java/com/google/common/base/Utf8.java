/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Preconditions;

public final class Utf8 {
    private Utf8() {
    }

    public static int encodedLength(CharSequence object) {
        int n10;
        int n11;
        int n12;
        int n13 = object.length();
        for (n12 = 0; n12 < n13 && (n11 = (int)object.charAt(n12)) < (n10 = 128); ++n12) {
        }
        n11 = n13;
        while (n12 < n13) {
            int n14;
            n10 = object.charAt(n12);
            if (n10 < (n14 = 2048)) {
                n10 = 127 - n10 >>> 31;
                n11 += n10;
                ++n12;
                continue;
            }
            int n15 = Utf8.encodedLengthGeneral((CharSequence)object, n12);
            n11 += n15;
            break;
        }
        if (n11 >= n13) {
            return n11;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("UTF-8 length does not fit in int: ");
        long l10 = (long)n11 + 0x100000000L;
        charSequence.append(l10);
        charSequence = charSequence.toString();
        object = new IllegalArgumentException((String)charSequence);
        throw object;
    }

    private static int encodedLengthGeneral(CharSequence object, int n10) {
        int n11 = object.length();
        int n12 = 0;
        while (n10 < n11) {
            int n13;
            int n14 = object.charAt(n10);
            if (n14 < (n13 = 2048)) {
                n14 = 127 - n14 >>> 31;
                n12 += n14;
            } else {
                n12 += 2;
                n13 = 55296;
                if (n13 <= n14 && n14 <= (n13 = 57343)) {
                    n13 = Character.codePointAt((CharSequence)object, n10);
                    if (n13 != n14) {
                        ++n10;
                    } else {
                        String string2 = Utf8.unpairedSurrogateMsg(n10);
                        object = new IllegalArgumentException(string2);
                        throw object;
                    }
                }
            }
            ++n10;
        }
        return n12;
    }

    public static boolean isWellFormed(byte[] byArray) {
        int n10 = byArray.length;
        return Utf8.isWellFormed(byArray, 0, n10);
    }

    public static boolean isWellFormed(byte[] byArray, int n10, int n11) {
        int n12 = byArray.length;
        Preconditions.checkPositionIndexes(n10, n11 += n10, n12);
        while (n10 < n11) {
            n12 = byArray[n10];
            if (n12 < 0) {
                return Utf8.isWellFormedSlowPath(byArray, n10, n11);
            }
            ++n10;
        }
        return true;
    }

    private static boolean isWellFormedSlowPath(byte[] byArray, int n10, int n11) {
        while (true) {
            int n12;
            block13: {
                block14: {
                    if (n10 >= n11) {
                        return true;
                    }
                    n12 = n10 + 1;
                    if ((n10 = byArray[n10]) >= 0) break block13;
                    int n13 = -32;
                    int n14 = -65;
                    if (n10 < n13) {
                        if (n12 == n11) {
                            return false;
                        }
                        n13 = -62;
                        if (n10 >= n13) {
                            n10 = n12 + 1;
                            if ((n12 = byArray[n12]) <= n14) continue;
                        }
                        return false;
                    }
                    int n15 = -16;
                    if (n10 < n15) {
                        n15 = n12 + 1;
                        if (n15 >= n11) {
                            return false;
                        }
                        if ((n12 = byArray[n12]) <= n14) {
                            int n16 = -96;
                            if (!(n10 == n13 && n12 < n16 || n10 == (n13 = -19) && n16 <= n12)) {
                                n10 = n15 + 1;
                                n12 = byArray[n15];
                                if (n12 <= n14) continue;
                            }
                        }
                        return false;
                    }
                    n13 = n12 + 2;
                    if (n13 >= n11) {
                        return false;
                    }
                    n13 = n12 + 1;
                    if ((n12 = byArray[n12]) > n14) break block14;
                    n10 <<= 28;
                    if ((n10 = n10 + (n12 += 112) >> 30) != 0) break block14;
                    n10 = n13 + 1;
                    n12 = byArray[n13];
                    if (n12 > n14) break block14;
                    n12 = n10 + 1;
                    if ((n10 = byArray[n10]) <= n14) break block13;
                }
                return false;
            }
            n10 = n12;
        }
    }

    private static String unpairedSurrogateMsg(int n10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unpaired surrogate at index ");
        stringBuilder.append(n10);
        return stringBuilder.toString();
    }
}

