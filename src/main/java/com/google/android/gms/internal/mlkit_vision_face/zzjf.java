/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zziz;
import com.google.android.gms.internal.mlkit_vision_face.zzjc;
import com.google.android.gms.internal.mlkit_vision_face.zzje;
import com.google.android.gms.internal.mlkit_vision_face.zzjg;

public final class zzjf
extends zzje {
    private static int zza(byte[] object, int n10, long l10, int n11) {
        if (n11 != 0) {
            int n12 = 1;
            if (n11 != n12) {
                n12 = 2;
                if (n11 == n12) {
                    n11 = zziz.zza(object, l10);
                    byte by2 = zziz.zza(object, ++l10);
                    return zzjc.zza(n10, n11, (int)by2);
                }
                object = new AssertionError;
                object();
                throw object;
            }
            byte by3 = zziz.zza(object, l10);
            return zzjc.zza(n10, by3);
        }
        return zzjc.zza(n10);
    }

    public final int zza(int n10, byte[] byArray, int n11, int n12) {
        Object object = byArray;
        int n13 = n11;
        int n14 = n12;
        int n15 = n11 | n12;
        int n16 = byArray.length - n12;
        n15 |= n16;
        n16 = 2;
        int n17 = 3;
        if (n15 >= 0) {
            int n18;
            long l10;
            long l11;
            long l12;
            block18: {
                l12 = n11;
                long l13 = (long)n12 - l12;
                n13 = (int)l13;
                n14 = 16;
                l11 = 1L;
                if (n13 < n14) {
                    n14 = 0;
                } else {
                    long l14 = l12;
                    for (n14 = 0; n14 < n13; ++n14) {
                        l10 = l14 + l11;
                        n15 = zziz.zza(object, l14);
                        if (n15 >= 0) {
                            l14 = l10;
                            continue;
                        }
                        break block18;
                    }
                    n14 = n13;
                }
            }
            n13 -= n14;
            long l15 = n14;
            l12 += l15;
            while (true) {
                byte by2;
                n14 = 0;
                while (n13 > 0) {
                    l15 = l12 + l11;
                    by2 = zziz.zza(object, l12);
                    if (by2 >= 0) {
                        n13 += -1;
                        n14 = by2;
                        l12 = l15;
                        continue;
                    }
                    n14 = by2;
                    l12 = l15;
                    break;
                }
                if (n13 == 0) {
                    return 0;
                }
                n13 += -1;
                n15 = -32;
                byte by3 = -65;
                n18 = -1;
                if (n14 < n15) {
                    if (n13 == 0) {
                        return n14;
                    }
                    n13 += -1;
                    n15 = -62;
                    if (n14 >= n15) {
                        l15 = l12 + l11;
                        by2 = zziz.zza(object, l12);
                        if (by2 <= by3) {
                            l12 = l15;
                            continue;
                        }
                    }
                    return n18;
                }
                int n19 = -16;
                if (n14 < n19) {
                    if (n13 < n16) {
                        return zzjf.zza(object, n14, l12, n13);
                    }
                    n13 += -2;
                    l10 = l12 + l11;
                    by2 = zziz.zza(object, l12);
                    if (by2 <= by3) {
                        byte by4 = -96;
                        if (!(n14 == n15 && by2 < by4 || n14 == (n15 = -19) && by2 >= by4)) {
                            l12 = l10 + l11;
                            n14 = zziz.zza(object, l10);
                            if (n14 <= by3) continue;
                        }
                    }
                    return n18;
                }
                if (n13 < n17) {
                    return zzjf.zza(object, n14, l12, n13);
                }
                n13 += -3;
                l10 = l12 + l11;
                n15 = zziz.zza(object, l12);
                if (n15 > by3) break;
                n14 <<= 28;
                if ((n14 = n14 + (n15 += 112) >> 30) != 0) break;
                l15 = l10 + l11;
                by2 = zziz.zza(object, l10);
                if (by2 > by3) break;
                l12 = l15 + l11;
                n14 = zziz.zza(object, l15);
                if (n14 > by3) break;
            }
            return n18;
        }
        Object[] objectArray = new Object[n17];
        object = byArray.length;
        objectArray[0] = object;
        object = n11;
        objectArray[1] = object;
        object = n12;
        objectArray[n16] = object;
        object = String.format("Array length=%d, index=%d, limit=%d", objectArray);
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException((String)object);
        throw arrayIndexOutOfBoundsException;
    }

    /*
     * WARNING - void declaration
     */
    public final int zza(CharSequence charSequence, byte[] byArray, int n10, int n11) {
        String string2;
        String string3;
        int n12;
        int by5;
        Object object;
        Object object2;
        block9: {
            int n13;
            void var7_9;
            double d10;
            long l10;
            float f10;
            int n14;
            object2 = charSequence;
            object = byArray;
            by5 = n10;
            n12 = n11;
            long l11 = n10;
            long l12 = (long)n11 + l11;
            int n15 = charSequence.length();
            string3 = " at index ";
            string2 = "Failed writing ";
            if (n15 > n11 || (n14 = byArray.length - n11) < n10) break block9;
            boolean bl2 = false;
            StringBuilder stringBuilder = null;
            while (true) {
                byte by2;
                byte by3 = 128;
                f10 = 1.794E-43f;
                l10 = 1L;
                d10 = Double.MIN_VALUE;
                if (++var7_9 >= n15 || (by2 = object2.charAt((int)var7_9)) >= by3) break;
                by3 = by2;
                zziz.zza(object, l11, by3);
                l11 = l10 += l11;
            }
            if (var7_9 == n15) {
                return (int)l11;
            }
            while (++n13 < n15) {
                int n16;
                block17: {
                    block18: {
                        int n17;
                        int n18;
                        block14: {
                            int n19;
                            block15: {
                                block16: {
                                    long l13;
                                    float f11;
                                    int n20;
                                    long l14;
                                    double d11;
                                    block11: {
                                        long l15;
                                        long l16;
                                        block13: {
                                            long l17;
                                            long l18;
                                            byte by4;
                                            long l19;
                                            block12: {
                                                long l20;
                                                block10: {
                                                    n16 = object2.charAt(n13);
                                                    if (n16 >= n18 || (n17 = (int)(l11 == l12 ? 0 : (l11 < l12 ? -1 : 1))) >= 0) break block10;
                                                    l16 = l11 + l10;
                                                    n16 = (byte)n16;
                                                    zziz.zza(object, l11, (byte)n16);
                                                    l11 = l10;
                                                    d11 = d10;
                                                    l14 = l16;
                                                    n20 = n18;
                                                    f11 = f10;
                                                    break block11;
                                                }
                                                n17 = 2048;
                                                if (n16 >= n17 || (n17 = (int)((l20 = l11 - (l16 = l12 - (long)2)) == 0L ? 0 : (l20 < 0L ? -1 : 1))) > 0) break block12;
                                                l16 = l11 + l10;
                                                n18 = (byte)(n16 >>> 6 | 0x3C0);
                                                zziz.zza(object, l11, (byte)n18);
                                                l19 = l16 + l10;
                                                by4 = n16 & 0x3F;
                                                n16 = 128;
                                                by4 = (byte)(by4 | n16);
                                                zziz.zza(object, l16, by4);
                                                l13 = l10;
                                                n20 = 128;
                                                f11 = 1.794E-43f;
                                                l14 = l19;
                                                l11 = l10;
                                                d11 = d10;
                                                break block11;
                                            }
                                            n18 = 57343;
                                            f10 = 8.0355E-41f;
                                            n17 = 55296;
                                            if (n16 >= n17 && n18 >= n16 || (l15 = (l18 = l11 - (l17 = l12 - (long)3)) == 0L ? 0 : (l18 < 0L ? -1 : 1)) > 0) break block13;
                                            l16 = l11 + l10;
                                            n18 = (byte)(n16 >>> 12 | 0x1E0);
                                            zziz.zza(object, l11, (byte)n18);
                                            l19 = l16 + l10;
                                            by4 = n16 >>> 6 & 0x3F;
                                            n20 = 128;
                                            by4 = (byte)(by4 | n20);
                                            zziz.zza(object, l16, by4);
                                            l16 = 1L;
                                            long l21 = l19 + l16;
                                            by4 = (byte)(n16 & 0x3F | n20);
                                            zziz.zza(object, l19, by4);
                                            l14 = l21;
                                            l11 = 1L;
                                            d11 = Double.MIN_VALUE;
                                            n20 = 128;
                                            f11 = 1.794E-43f;
                                            break block11;
                                        }
                                        d10 = 2.0E-323;
                                        l10 = l12 - (long)4;
                                        long l22 = l11 - l10;
                                        n20 = (int)(l22 == 0L ? 0 : (l22 < 0L ? -1 : 1));
                                        if (n20 > 0) break block14;
                                        n18 = n13 + true;
                                        if (n18 == n15) break block15;
                                        n13 = object2.charAt(n18);
                                        n20 = (int)(Character.isSurrogatePair((char)n16, (char)n13) ? 1 : 0);
                                        if (n20 == 0) break block16;
                                        n13 = Character.toCodePoint((char)n16, (char)n13);
                                        l10 = 1L;
                                        d10 = Double.MIN_VALUE;
                                        long l23 = l11 + l10;
                                        l15 = (byte)(n13 >>> 18 | 0xF0);
                                        zziz.zza(object, l11, (byte)l15);
                                        l11 = l23 + l10;
                                        l15 = n13 >>> 12 & 0x3F;
                                        n20 = 128;
                                        f11 = 1.794E-43f;
                                        byte by6 = (byte)(l15 | 0x80);
                                        zziz.zza(object, l23, by6);
                                        l16 = l11 + 1L;
                                        int n21 = n13 >>> 6;
                                        by6 = (byte)(n21 & 0x3F | n20);
                                        zziz.zza(object, l11, by6);
                                        l11 = 1L;
                                        d11 = Double.MIN_VALUE;
                                        l14 = l16 + l11;
                                        n13 = (byte)(n13 & 0x3F | n20);
                                        zziz.zza(object, l16, (byte)n13);
                                        n13 = n18;
                                    }
                                    n18 = n20;
                                    f10 = f11;
                                    l13 = l11;
                                    l11 = l14;
                                    l10 = l13;
                                    d10 = d11;
                                    continue;
                                }
                                n19 = n18;
                            }
                            void var7_12 = n19 + -1;
                            object2 = new zzjg((int)var7_12, n15);
                            throw object2;
                        }
                        if (n17 > n16 || n16 > n18) break block17;
                        void var46_44 = n13 + true;
                        if (var46_44 == n15) break block18;
                        char c10 = object2.charAt((int)var46_44);
                        if ((c10 = (char)(Character.isSurrogatePair((char)n16, c10) ? 1 : 0)) != '\u0000') break block17;
                    }
                    object2 = new zzjg(n13, n15);
                    throw object2;
                }
                stringBuilder = new StringBuilder(46);
                stringBuilder.append(string2);
                stringBuilder.append((char)n16);
                stringBuilder.append(string3);
                stringBuilder.append(l11);
                object = stringBuilder.toString();
                object2 = new ArrayIndexOutOfBoundsException((String)object);
                throw object2;
            }
            return (int)l11;
        }
        object = new ArrayIndexOutOfBoundsException;
        char c11 = object2.charAt(n15 += -1);
        int n22 = by5 + n12;
        StringBuilder stringBuilder = new StringBuilder(37);
        stringBuilder.append(string2);
        stringBuilder.append(c11);
        stringBuilder.append(string3);
        stringBuilder.append(n22);
        object2 = stringBuilder.toString();
        object((String)object2);
        throw object;
    }
}

