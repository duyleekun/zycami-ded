/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzic;
import com.google.android.gms.internal.measurement.zzkh;
import com.google.android.gms.internal.measurement.zzki;
import com.google.android.gms.internal.measurement.zzkj;
import com.google.android.gms.internal.measurement.zzkl;
import com.google.android.gms.internal.measurement.zzkn;

public final class zzkm
extends zzkj {
    private static int zze(byte[] object, int n10, long l10, int n11) {
        if (n11 != 0) {
            int n12 = 1;
            if (n11 != n12) {
                n12 = 2;
                if (n11 == n12) {
                    n11 = zzkh.zzp(object, l10);
                    byte by2 = zzkh.zzp(object, ++l10);
                    return zzkn.zzg(n10, n11, by2);
                }
                object = new AssertionError;
                object();
                throw object;
            }
            byte by3 = zzkh.zzp(object, l10);
            return zzkn.zzf(n10, by3);
        }
        return zzkn.zzi(n10);
    }

    /*
     * Enabled aggressive block sorting
     */
    public final int zzb(int n10, byte[] byArray, int n11, int n12) {
        int n13;
        long l10;
        long l11;
        long l12;
        int n14;
        int n15;
        int n16;
        int n17;
        int n18;
        int n19;
        int n20;
        byte[] byArray2;
        block18: {
            byArray2 = byArray;
            n20 = n11;
            n19 = n12;
            n18 = byArray.length;
            n17 = n11 | n12;
            n16 = n18 - n12;
            n17 |= n16;
            n16 = 2;
            n15 = 3;
            n14 = 0;
            if (n17 < 0) {
                Object object;
                Object[] objectArray = new Object[n15];
                Integer n21 = n18;
                objectArray[0] = n21;
                objectArray[1] = object = Integer.valueOf(n11);
                objectArray[n16] = object = Integer.valueOf(n12);
                object = String.format("Array length=%d, index=%d, limit=%d", objectArray);
                ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException((String)object);
                throw arrayIndexOutOfBoundsException;
            }
            l12 = n11;
            long l13 = (long)n12 - l12;
            n20 = (int)l13;
            n19 = 16;
            l11 = 1L;
            if (n20 < n19) {
                n19 = 0;
            } else {
                l10 = l12;
                for (n19 = 0; n19 < n20; ++n19) {
                    long l14 = l10 + l11;
                    n13 = zzkh.zzp(byArray2, l10);
                    if (n13 >= 0) {
                        l10 = l14;
                        continue;
                    }
                    break block18;
                }
                n19 = n20;
            }
        }
        n20 -= n19;
        l10 = n19;
        l12 += l10;
        while (true) {
            long l15;
            n19 = 0;
            while (n20 > 0) {
                l10 = l12 + l11;
                n19 = zzkh.zzp(byArray2, l12);
                if (n19 >= 0) {
                    n20 += -1;
                    l12 = l10;
                    continue;
                }
                l12 = l10;
                break;
            }
            n13 = -1;
            if (n20 == 0) {
                return n14;
            }
            n20 += -1;
            int n22 = -32;
            int n23 = -65;
            if (n19 < n22) {
                if (n20 == 0) {
                    return n19;
                }
                n20 += -1;
                n22 = -62;
                if (n19 < n22) return n13;
                l15 = l12 + l11;
                n19 = zzkh.zzp(byArray2, l12);
                if (n19 > n23) {
                    return n13;
                }
            } else {
                long l16;
                int n24 = -16;
                if (n19 < n24) {
                    if (n20 < n16) {
                        return zzkm.zze(byArray2, n19, l12, n20);
                    }
                    n20 += -2;
                    l15 = l12 + l11;
                    n18 = zzkh.zzp(byArray2, l12);
                    if (n18 > n23) return n13;
                    n17 = -96;
                    if (n19 == n22) {
                        if (n18 < n17) return n13;
                    }
                    if (n19 == (n22 = -19)) {
                        if (n18 >= n17) return n13;
                    }
                    l16 = l15 + l11;
                    n17 = zzkh.zzp(byArray2, l15);
                    if (n17 > n23) return n13;
                    l12 = l16;
                    continue;
                }
                if (n20 < n15) {
                    return zzkm.zze(byArray2, n19, l12, n20);
                }
                n20 += -3;
                l15 = l12 + l11;
                n18 = zzkh.zzp(byArray2, l12);
                if (n18 > n23) return n13;
                n19 <<= 28;
                if ((n19 = n19 + (n18 += 112) >> 30) != 0) return n13;
                l16 = l15 + l11;
                n17 = zzkh.zzp(byArray2, l15);
                if (n17 > n23) return n13;
                l15 = l16 + l11;
                n19 = zzkh.zzp(byArray2, l16);
                if (n19 > n23) return n13;
            }
            l12 = l15;
        }
    }

    public final String zzc(byte[] object, int n10, int n11) {
        Object object2;
        int n12 = ((byte[])object).length;
        int n13 = n10 | n11;
        int n14 = n12 - n10 - n11;
        n13 |= n14;
        n14 = 0;
        if (n13 >= 0) {
            long l10;
            char c10;
            int n15;
            n12 = n10 + n11;
            char[] cArray = new char[n11];
            n13 = 0;
            Object var8_8 = null;
            while (n10 < n12 && (n15 = zzki.zza((byte)(c10 = zzkh.zzp(object, l10 = (long)n10)))) != 0) {
                ++n10;
                n15 = n13 + 1;
                cArray[n13] = c10 = (char)c10;
                n13 = n15;
            }
            block1: while (n10 < n12) {
                int n16;
                long l11;
                int n17;
                c10 = n10 + 1;
                long l12 = n10;
                n15 = zzki.zza((byte)(n10 = (int)zzkh.zzp(object, l12)));
                if (n15 != 0) {
                    n15 = n13 + 1;
                    cArray[n13] = n10 = (int)((char)n10);
                    n10 = c10;
                    while (true) {
                        n13 = n15;
                        if (n10 >= n12 || (n15 = (int)(zzki.zza((byte)(c10 = (char)zzkh.zzp(object, l10 = (long)n10))) ? 1 : 0)) == 0) continue block1;
                        ++n10;
                        n15 = n13 + 1;
                        cArray[n13] = c10 = (char)c10;
                    }
                }
                n15 = (int)(zzki.zzb((byte)n10) ? 1 : 0);
                if (n15 != 0) {
                    if (c10 < n12) {
                        n15 = c10 + '\u0001';
                        n17 = n13 + 1;
                        l11 = c10;
                        c10 = (char)zzkh.zzp(object, l11);
                        zzki.zzc((byte)n10, (byte)c10, cArray, n13);
                        n10 = n15;
                        n13 = n17;
                        continue;
                    }
                    throw zzic.zzf();
                }
                n15 = (int)(zzki.zzd((byte)n10) ? 1 : 0);
                if (n15 != 0) {
                    n15 = n12 + -1;
                    if (c10 < n15) {
                        n15 = c10 + '\u0001';
                        n17 = n15 + 1;
                        n16 = n13 + 1;
                        long l13 = c10;
                        c10 = (char)zzkh.zzp(object, l13);
                        l13 = n15;
                        n15 = zzkh.zzp(object, l13);
                        zzki.zze((byte)n10, (byte)c10, (byte)n15, cArray, n13);
                        n10 = n17;
                        n13 = n16;
                        continue;
                    }
                    throw zzic.zzf();
                }
                n15 = n12 + -2;
                if (c10 < n15) {
                    n15 = c10 + '\u0001';
                    n17 = n15 + 1;
                    int n18 = n17 + 1;
                    l11 = c10;
                    n16 = zzkh.zzp(object, l11);
                    l10 = n15;
                    byte by2 = zzkh.zzp(object, l10);
                    l10 = n17;
                    int n19 = zzkh.zzp(object, l10);
                    c10 = (char)n10;
                    n15 = n16;
                    n17 = by2;
                    n16 = n19;
                    n19 = n13;
                    zzki.zzf((byte)n10, (byte)n15, by2, (byte)n16, cArray, n13);
                    n13 += 2;
                    n10 = n18;
                    continue;
                }
                throw zzic.zzf();
            }
            object = new String;
            object(cArray, 0, n13);
            return object;
        }
        object = new ArrayIndexOutOfBoundsException;
        Object[] objectArray = new Object[3];
        Integer n20 = n12;
        objectArray[0] = n20;
        objectArray[1] = object2 = Integer.valueOf(n10);
        objectArray[2] = object2 = Integer.valueOf(n11);
        object2 = String.format("buffer length=%d, index=%d, size=%d", objectArray);
        object((String)object2);
        throw object;
    }

    public final int zzd(CharSequence charSequence, byte[] byArray, int n10, int n11) {
        String string2;
        String string3;
        int n12;
        int n13;
        Object object;
        Object object2;
        block6: {
            long l10;
            block7: {
                int n14;
                double d10;
                long l11;
                float f10;
                int n15;
                object2 = charSequence;
                object = byArray;
                n13 = n10;
                n12 = n11;
                l10 = n10;
                long l12 = (long)n11 + l10;
                int n16 = charSequence.length();
                string3 = " at index ";
                string2 = "Failed writing ";
                if (n16 > n11 || (n15 = byArray.length - n11) < n10) break block6;
                n13 = 0;
                while (true) {
                    n12 = 128;
                    f10 = 1.794E-43f;
                    l11 = 1L;
                    d10 = Double.MIN_VALUE;
                    if (n13 >= n16 || (n14 = object2.charAt(n13)) >= n12) break;
                    n12 = (byte)n14;
                    zzkh.zzq((byte[])object, l10, (byte)n12);
                    ++n13;
                    l10 = l11 += l10;
                }
                if (n13 == n16) break block7;
                while (n13 < n16) {
                    block15: {
                        block16: {
                            int n17;
                            block12: {
                                block13: {
                                    block14: {
                                        long l13;
                                        float f11;
                                        long l14;
                                        double d11;
                                        block9: {
                                            long l15;
                                            long l16;
                                            block11: {
                                                long l17;
                                                long l18;
                                                byte by2;
                                                long l19;
                                                block10: {
                                                    long l20;
                                                    block8: {
                                                        n14 = object2.charAt(n13);
                                                        if (n14 >= n12 || (n17 = (int)(l10 == l12 ? 0 : (l10 < l12 ? -1 : 1))) >= 0) break block8;
                                                        l16 = l10 + l11;
                                                        n14 = (byte)n14;
                                                        zzkh.zzq((byte[])object, l10, (byte)n14);
                                                        l10 = l11;
                                                        d11 = d10;
                                                        l14 = l16;
                                                        n15 = n12;
                                                        f11 = f10;
                                                        break block9;
                                                    }
                                                    n17 = 2048;
                                                    if (n14 >= n17 || (n17 = (int)((l20 = l10 - (l16 = (long)-2 + l12)) == 0L ? 0 : (l20 < 0L ? -1 : 1))) > 0) break block10;
                                                    l16 = l10 + l11;
                                                    n12 = (byte)(n14 >>> 6 | 0x3C0);
                                                    zzkh.zzq((byte[])object, l10, (byte)n12);
                                                    l19 = l16 + l11;
                                                    by2 = n14 & 0x3F;
                                                    n14 = 128;
                                                    by2 = (byte)(by2 | n14);
                                                    zzkh.zzq((byte[])object, l16, by2);
                                                    l13 = l11;
                                                    n15 = 128;
                                                    f11 = 1.794E-43f;
                                                    l14 = l19;
                                                    l10 = l11;
                                                    d11 = d10;
                                                    break block9;
                                                }
                                                n12 = 57343;
                                                f10 = 8.0355E-41f;
                                                n17 = 55296;
                                                if (n14 >= n17 && n14 <= n12 || (l15 = (l18 = l10 - (l17 = (long)-3 + l12)) == 0L ? 0 : (l18 < 0L ? -1 : 1)) > 0) break block11;
                                                l16 = l10 + l11;
                                                n12 = (byte)(n14 >>> 12 | 0x1E0);
                                                zzkh.zzq((byte[])object, l10, (byte)n12);
                                                l19 = l16 + l11;
                                                by2 = n14 >>> 6 & 0x3F;
                                                n15 = 128;
                                                by2 = (byte)(by2 | n15);
                                                zzkh.zzq((byte[])object, l16, by2);
                                                l16 = 1L;
                                                long l21 = l19 + l16;
                                                by2 = (byte)(n14 & 0x3F | n15);
                                                zzkh.zzq((byte[])object, l19, by2);
                                                l14 = l21;
                                                l10 = 1L;
                                                d11 = Double.MIN_VALUE;
                                                n15 = 128;
                                                f11 = 1.794E-43f;
                                                break block9;
                                            }
                                            d10 = 0.0 / 0.0;
                                            l11 = (long)-4 + l12;
                                            long l21 = l10 - l11;
                                            n15 = (int)(l21 == 0L ? 0 : (l21 < 0L ? -1 : 1));
                                            if (n15 > 0) break block12;
                                            n12 = n13 + 1;
                                            if (n12 == n16) break block13;
                                            n13 = object2.charAt(n12);
                                            n15 = (int)(Character.isSurrogatePair((char)n14, (char)n13) ? 1 : 0);
                                            if (n15 == 0) break block14;
                                            n13 = Character.toCodePoint((char)n14, (char)n13);
                                            l11 = 1L;
                                            d10 = Double.MIN_VALUE;
                                            long l23 = l10 + l11;
                                            l15 = (byte)(n13 >>> 18 | 0xF0);
                                            zzkh.zzq((byte[])object, l10, (byte)l15);
                                            l10 = l23 + l11;
                                            l15 = n13 >>> 12 & 0x3F;
                                            n15 = 128;
                                            f11 = 1.794E-43f;
                                            byte by3 = (byte)(l15 | 0x80);
                                            zzkh.zzq((byte[])object, l23, by3);
                                            l16 = l10 + 1L;
                                            int n18 = n13 >>> 6;
                                            by3 = (byte)(n18 & 0x3F | n15);
                                            zzkh.zzq((byte[])object, l10, by3);
                                            l10 = 1L;
                                            d11 = Double.MIN_VALUE;
                                            l14 = l16 + l10;
                                            n13 = (byte)(n13 & 0x3F | n15);
                                            zzkh.zzq((byte[])object, l16, (byte)n13);
                                            n13 = n12;
                                        }
                                        ++n13;
                                        n12 = n15;
                                        f10 = f11;
                                        l13 = l10;
                                        l10 = l14;
                                        l11 = l13;
                                        d10 = d11;
                                        continue;
                                    }
                                    n13 = n12;
                                }
                                object2 = new zzkl(n13 += -1, n16);
                                throw object2;
                            }
                            if (n14 < n17 || n14 > n12) break block15;
                            int n19 = n13 + 1;
                            if (n19 == n16) break block16;
                            char c10 = object2.charAt(n19);
                            if ((c10 = (char)(Character.isSurrogatePair((char)n14, c10) ? 1 : 0)) != '\u0000') break block15;
                        }
                        object2 = new zzkl(n13, n16);
                        throw object2;
                    }
                    object = new StringBuilder;
                    ((StringBuilder)object)(46);
                    ((StringBuilder)object).append(string2);
                    ((StringBuilder)object).append((char)n14);
                    ((StringBuilder)object).append(string3);
                    ((StringBuilder)object).append(l10);
                    object = ((StringBuilder)object).toString();
                    object2 = new ArrayIndexOutOfBoundsException((String)object);
                    throw object2;
                }
                return (int)l10;
            }
            return (int)l10;
        }
        object = new ArrayIndexOutOfBoundsException;
        int n20 = object2.charAt(n16 += -1);
        StringBuilder stringBuilder = new StringBuilder(37);
        stringBuilder.append(string2);
        stringBuilder.append((char)n20);
        stringBuilder.append(string3);
        n20 = n13 + n12;
        stringBuilder.append(n20);
        object2 = stringBuilder.toString();
        ((ArrayIndexOutOfBoundsException)object)((String)object2);
        throw object;
    }
}

