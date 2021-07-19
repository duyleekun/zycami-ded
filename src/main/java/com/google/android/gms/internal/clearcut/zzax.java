/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzay;
import com.google.android.gms.internal.clearcut.zzbb;
import com.google.android.gms.internal.clearcut.zzch;
import com.google.android.gms.internal.clearcut.zzci;
import com.google.android.gms.internal.clearcut.zzcn;
import com.google.android.gms.internal.clearcut.zzco;
import com.google.android.gms.internal.clearcut.zzey;
import com.google.android.gms.internal.clearcut.zzff;
import java.nio.charset.Charset;

public final class zzax {
    public static int zza(int n10, byte[] byArray, int n11, int n12, zzay zzay2) {
        int n13 = n10 >>> 3;
        if (n13 != 0) {
            n13 = n10 & 7;
            if (n13 != 0) {
                int n14 = 1;
                if (n13 != n14) {
                    n14 = 2;
                    if (n13 != n14) {
                        n14 = 3;
                        if (n13 != n14) {
                            n10 = 5;
                            if (n13 == n10) {
                                return n11 + 4;
                            }
                            throw zzco.zzbm();
                        }
                        n10 = n10 & 0xFFFFFFF8 | 4;
                        n13 = 0;
                        while (n11 < n12) {
                            n11 = zzax.zza(byArray, n11, zzay2);
                            n13 = zzay2.zzfd;
                            if (n13 == n10) break;
                            n11 = zzax.zza(n13, byArray, n11, n12, zzay2);
                        }
                        if (n11 <= n12 && n13 == n10) {
                            return n11;
                        }
                        throw zzco.zzbo();
                    }
                    n10 = zzax.zza(byArray, n11, zzay2);
                    int n15 = zzay2.zzfd;
                    return n10 + n15;
                }
                return n11 + 8;
            }
            return zzax.zzb(byArray, n11, zzay2);
        }
        throw zzco.zzbm();
    }

    public static int zza(int n10, byte[] byArray, int n11, int n12, zzcn zzcn2, zzay zzay2) {
        zzcn2 = (zzch)zzcn2;
        n11 = zzax.zza(byArray, n11, zzay2);
        while (true) {
            int n13 = zzay2.zzfd;
            ((zzch)zzcn2).zzac(n13);
            if (n11 >= n12) break;
            n13 = zzax.zza(byArray, n11, zzay2);
            int n14 = zzay2.zzfd;
            if (n10 != n14) break;
            n11 = zzax.zza(byArray, n13, zzay2);
        }
        return n11;
    }

    public static int zza(int n10, byte[] object, int n11, int n12, zzey zzey2, zzay zzay2) {
        int n13 = n10 >>> 3;
        if (n13 != 0) {
            n13 = n10 & 7;
            if (n13 != 0) {
                int n14 = 1;
                if (n13 != n14) {
                    n14 = 2;
                    if (n13 != n14) {
                        n14 = 3;
                        if (n13 != n14) {
                            n12 = 5;
                            if (n13 == n12) {
                                object = zzax.zzc((byte[])object, n11);
                                zzey2.zzb(n10, object);
                                return n11 + 4;
                            }
                            throw zzco.zzbm();
                        }
                        zzey zzey3 = zzey.zzeb();
                        int n15 = n10 & 0xFFFFFFF8 | 4;
                        n13 = 0;
                        while (n11 < n12) {
                            int n16 = zzax.zza((byte[])object, n11, zzay2);
                            n13 = n11 = zzay2.zzfd;
                            if (n11 != n15) {
                                int n17 = zzax.zza(n11, (byte[])object, n16, n12, zzey3, zzay2);
                                n13 = n11;
                                n11 = n17;
                                continue;
                            }
                            n11 = n16;
                            break;
                        }
                        if (n11 <= n12 && n13 == n15) {
                            zzey2.zzb(n10, zzey3);
                            return n11;
                        }
                        throw zzco.zzbo();
                    }
                    n11 = zzax.zza((byte[])object, n11, zzay2);
                    n12 = zzay2.zzfd;
                    object = n12 == 0 ? (Object)zzbb.zzfi : (Object)zzbb.zzb((byte[])object, n11, n12);
                    zzey2.zzb(n10, object);
                    return n11 + n12;
                }
                object = zzax.zzd((byte[])object, n11);
                zzey2.zzb(n10, object);
                return n11 + 8;
            }
            int n18 = zzax.zzb((byte[])object, n11, zzay2);
            Long l10 = zzay2.zzfe;
            zzey2.zzb(n10, l10);
            return n18;
        }
        throw zzco.zzbm();
    }

    /*
     * Enabled aggressive block sorting
     */
    public static int zza(int n10, byte[] byArray, int n11, zzay zzay2) {
        int n12;
        block13: {
            int n13;
            block11: {
                block12: {
                    int n14;
                    block9: {
                        block10: {
                            block8: {
                                n10 &= 0x7F;
                                n12 = n11 + 1;
                                if ((n11 = byArray[n11]) < 0) break block8;
                                n14 = n11 << 7;
                                break block9;
                            }
                            n11 = (n11 & 0x7F) << 7;
                            n10 |= n11;
                            n11 = n12 + 1;
                            if ((n12 = byArray[n12]) < 0) break block10;
                            n13 = n12 << 14;
                            break block11;
                        }
                        n12 = (n12 & 0x7F) << 14;
                        n10 |= n12;
                        n12 = n11 + 1;
                        if ((n11 = byArray[n11]) < 0) break block12;
                        n14 = n11 << 21;
                    }
                    zzay2.zzfd = n10 |= n14;
                    return n12;
                }
                n11 = (n11 & 0x7F) << 21;
                n10 |= n11;
                n11 = n12 + 1;
                if ((n12 = byArray[n12]) < 0) break block13;
                n13 = n12 << 28;
            }
            zzay2.zzfd = n10 |= n13;
            return n11;
        }
        n12 = (n12 & 0x7F) << 28;
        n10 |= n12;
        while (true) {
            n12 = n11 + 1;
            if ((n11 = byArray[n11]) >= 0) {
                zzay2.zzfd = n10;
                return n12;
            }
            n11 = n12;
        }
    }

    public static int zza(byte[] byArray, int n10, zzay zzay2) {
        int n11 = n10 + 1;
        if ((n10 = byArray[n10]) >= 0) {
            zzay2.zzfd = n10;
            return n11;
        }
        return zzax.zza(n10, byArray, n11, zzay2);
    }

    public static int zza(byte[] byArray, int n10, zzcn zzcn2, zzay zzay2) {
        zzcn2 = (zzch)zzcn2;
        n10 = zzax.zza(byArray, n10, zzay2);
        int n11 = zzay2.zzfd + n10;
        while (n10 < n11) {
            n10 = zzax.zza(byArray, n10, zzay2);
            int n12 = zzay2.zzfd;
            ((zzch)zzcn2).zzac(n12);
        }
        if (n10 == n11) {
            return n10;
        }
        throw zzco.zzbl();
    }

    public static int zzb(byte[] byArray, int n10, zzay zzay2) {
        int n11 = n10 + 1;
        long l10 = byArray[n10];
        long l11 = 0L;
        long l12 = l10 - l11;
        if ((n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1))) >= 0) {
            zzay2.zzfe = l10;
            return n11;
        }
        l10 &= (long)127;
        n10 = n11 + 1;
        n11 = byArray[n11];
        l11 = n11 & 0x7F;
        int n12 = 7;
        l10 |= (l11 <<= n12);
        int n13 = n12;
        while (n11 < 0) {
            n11 = n10 + 1;
            n10 = byArray[n10];
            int n14 = n10 & 0x7F;
            long l13 = (long)n14 << (n13 += n12);
            l10 |= l13;
            int n15 = n11;
            n11 = n10;
            n10 = n15;
        }
        zzay2.zzfe = l10;
        return n10;
    }

    public static int zzc(byte[] byArray, int n10) {
        int n11 = byArray[n10] & 0xFF;
        int n12 = n10 + 1;
        n12 = (byArray[n12] & 0xFF) << 8;
        n11 |= n12;
        n12 = n10 + 2;
        n12 = (byArray[n12] & 0xFF) << 16;
        return (byArray[n10 += 3] & 0xFF) << 24 | (n11 |= n12);
    }

    public static int zzc(byte[] byArray, int n10, zzay zzay2) {
        n10 = zzax.zza(byArray, n10, zzay2);
        int n11 = zzay2.zzfd;
        if (n11 == 0) {
            zzay2.zzff = "";
            return n10;
        }
        Charset charset = zzci.UTF_8;
        String string2 = new String(byArray, n10, n11, charset);
        zzay2.zzff = string2;
        return n10 + n11;
    }

    public static int zzd(byte[] byArray, int n10, zzay zzay2) {
        n10 = zzax.zza(byArray, n10, zzay2);
        int n11 = zzay2.zzfd;
        if (n11 == 0) {
            zzay2.zzff = "";
            return n10;
        }
        int n12 = n10 + n11;
        boolean bl2 = zzff.zze(byArray, n10, n12);
        if (bl2) {
            Charset charset = zzci.UTF_8;
            String string2 = new String(byArray, n10, n11, charset);
            zzay2.zzff = string2;
            return n12;
        }
        throw zzco.zzbp();
    }

    public static long zzd(byte[] byArray, int n10) {
        long l10 = byArray[n10];
        long l11 = 255L;
        l10 &= l11;
        int n11 = n10 + 1;
        long l12 = ((long)byArray[n11] & l11) << 8;
        l10 |= l12;
        n11 = n10 + 2;
        l12 = ((long)byArray[n11] & l11) << 16;
        l10 |= l12;
        n11 = n10 + 3;
        l12 = ((long)byArray[n11] & l11) << 24;
        l10 |= l12;
        n11 = n10 + 4;
        l12 = ((long)byArray[n11] & l11) << 32;
        l10 |= l12;
        n11 = n10 + 5;
        l12 = ((long)byArray[n11] & l11) << 40;
        l10 |= l12;
        n11 = n10 + 6;
        l12 = ((long)byArray[n11] & l11) << 48;
        return ((long)byArray[n10 += 7] & l11) << 56 | (l10 |= l12);
    }

    public static double zze(byte[] byArray, int n10) {
        return Double.longBitsToDouble(zzax.zzd(byArray, n10));
    }

    public static int zze(byte[] object, int n10, zzay zzay2) {
        n10 = zzax.zza(object, n10, zzay2);
        int n11 = zzay2.zzfd;
        if (n11 == 0) {
            object = zzbb.zzfi;
            zzay2.zzff = object;
            return n10;
        }
        object = zzbb.zzb(object, n10, n11);
        zzay2.zzff = object;
        return n10 + n11;
    }

    public static float zzf(byte[] byArray, int n10) {
        return Float.intBitsToFloat(zzax.zzc(byArray, n10));
    }
}

