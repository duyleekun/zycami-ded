/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzge;
import com.google.android.gms.internal.measurement.zzgs;
import com.google.android.gms.internal.measurement.zzht;
import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zzia;
import com.google.android.gms.internal.measurement.zzic;
import com.google.android.gms.internal.measurement.zzja;
import com.google.android.gms.internal.measurement.zzji;
import com.google.android.gms.internal.measurement.zzjx;
import com.google.android.gms.internal.measurement.zzkn;
import java.nio.charset.Charset;

public final class zzgf {
    public static int zza(byte[] byArray, int n10, zzge zzge2) {
        int n11 = n10 + 1;
        if ((n10 = byArray[n10]) >= 0) {
            zzge2.zza = n10;
            return n11;
        }
        return zzgf.zzb(n10, byArray, n11, zzge2);
    }

    public static int zzb(int n10, byte[] byArray, int n11, zzge zzge2) {
        n10 &= 0x7F;
        int n12 = n11 + 1;
        if ((n11 = byArray[n11]) >= 0) {
            int n13 = n11 << 7;
            zzge2.zza = n10 |= n13;
            return n12;
        }
        n11 = (n11 & 0x7F) << 7;
        n10 |= n11;
        n11 = n12 + 1;
        if ((n12 = byArray[n12]) >= 0) {
            int n14 = n12 << 14;
            zzge2.zza = n10 |= n14;
            return n11;
        }
        n12 = (n12 & 0x7F) << 14;
        n10 |= n12;
        n12 = n11 + 1;
        if ((n11 = byArray[n11]) >= 0) {
            int n15 = n11 << 21;
            zzge2.zza = n10 |= n15;
            return n12;
        }
        n11 = (n11 & 0x7F) << 21;
        n10 |= n11;
        n11 = n12 + 1;
        if ((n12 = byArray[n12]) >= 0) {
            int n16 = n12 << 28;
            zzge2.zza = n10 |= n16;
            return n11;
        }
        n12 = (n12 & 0x7F) << 28;
        n10 |= n12;
        while (true) {
            n12 = n11 + 1;
            if ((n11 = byArray[n11]) >= 0) break;
            n11 = n12;
        }
        zzge2.zza = n10;
        return n12;
    }

    public static int zzc(byte[] byArray, int n10, zzge zzge2) {
        int n11 = n10 + 1;
        long l10 = byArray[n10];
        long l11 = 0L;
        long l12 = l10 - l11;
        if ((n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1))) < 0) {
            n10 = n11 + 1;
            n11 = byArray[n11];
            l10 &= (long)127;
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
            zzge2.zzb = l10;
            return n10;
        }
        zzge2.zzb = l10;
        return n11;
    }

    public static int zzd(byte[] byArray, int n10) {
        int n11 = byArray[n10] & 0xFF;
        int n12 = n10 + 1;
        n12 = (byArray[n12] & 0xFF) << 8;
        n11 |= n12;
        n12 = n10 + 2;
        n12 = (byArray[n12] & 0xFF) << 16;
        return (byArray[n10 += 3] & 0xFF) << 24 | (n11 |= n12);
    }

    public static long zze(byte[] byArray, int n10) {
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

    public static int zzf(byte[] byArray, int n10, zzge zzge2) {
        n10 = zzgf.zza(byArray, n10, zzge2);
        int n11 = zzge2.zza;
        if (n11 >= 0) {
            if (n11 == 0) {
                zzge2.zzc = "";
                return n10;
            }
            Charset charset = zzia.zza;
            String string2 = new String(byArray, n10, n11, charset);
            zzge2.zzc = string2;
            return n10 + n11;
        }
        throw zzic.zzb();
    }

    public static int zzg(byte[] object, int n10, zzge zzge2) {
        n10 = zzgf.zza(object, n10, zzge2);
        int n11 = zzge2.zza;
        if (n11 >= 0) {
            if (n11 == 0) {
                zzge2.zzc = "";
                return n10;
            }
            object = zzkn.zze(object, n10, n11);
            zzge2.zzc = object;
            return n10 + n11;
        }
        throw zzic.zzb();
    }

    public static int zzh(byte[] object, int n10, zzge zzge2) {
        n10 = zzgf.zza(object, n10, zzge2);
        int n11 = zzge2.zza;
        if (n11 >= 0) {
            int n12 = ((byte[])object).length - n10;
            if (n11 <= n12) {
                if (n11 == 0) {
                    object = zzgs.zzb;
                    zzge2.zzc = object;
                    return n10;
                }
                object = zzgs.zzj(object, n10, n11);
                zzge2.zzc = object;
                return n10 + n11;
            }
            throw zzic.zza();
        }
        throw zzic.zzb();
    }

    public static int zzi(zzji zzji2, byte[] byArray, int n10, int n11, zzge zzge2) {
        int n12 = n10 + 1;
        if ((n10 = byArray[n10]) < 0) {
            n12 = zzgf.zzb(n10, byArray, n12, zzge2);
            n10 = zzge2.zza;
        }
        if (n10 >= 0 && n10 <= (n11 -= n12)) {
            Object object = zzji2.zza();
            zzji2.zzh(object, byArray, n12, n10 += n12, zzge2);
            zzji2.zzi(object);
            zzge2.zzc = object;
            return n10;
        }
        throw zzic.zza();
    }

    public static int zzj(zzji zzji2, byte[] byArray, int n10, int n11, int n12, zzge zzge2) {
        zzji2 = (zzja)zzji2;
        Object object = ((zzja)zzji2).zza();
        int n13 = ((zzja)zzji2).zzg(object, byArray, n10, n11, n12, zzge2);
        ((zzja)zzji2).zzi(object);
        zzge2.zzc = object;
        return n13;
    }

    public static int zzk(int n10, byte[] byArray, int n11, int n12, zzhz zzhz2, zzge zzge2) {
        zzhz2 = (zzht)zzhz2;
        n11 = zzgf.zza(byArray, n11, zzge2);
        int n13 = zzge2.zza;
        ((zzht)zzhz2).zzh(n13);
        while (n11 < n12) {
            n13 = zzgf.zza(byArray, n11, zzge2);
            int n14 = zzge2.zza;
            if (n10 != n14) break;
            n11 = zzgf.zza(byArray, n13, zzge2);
            n13 = zzge2.zza;
            ((zzht)zzhz2).zzh(n13);
        }
        return n11;
    }

    public static int zzl(byte[] byArray, int n10, zzhz zzhz2, zzge zzge2) {
        zzhz2 = (zzht)zzhz2;
        n10 = zzgf.zza(byArray, n10, zzge2);
        int n11 = zzge2.zza + n10;
        while (n10 < n11) {
            n10 = zzgf.zza(byArray, n10, zzge2);
            int n12 = zzge2.zza;
            ((zzht)zzhz2).zzh(n12);
        }
        if (n10 == n11) {
            return n10;
        }
        throw zzic.zza();
    }

    public static int zzm(zzji zzji2, int n10, byte[] byArray, int n11, int n12, zzhz zzhz2, zzge zzge2) {
        n11 = zzgf.zzi(zzji2, byArray, n11, n12, zzge2);
        Object object = zzge2.zzc;
        zzhz2.add(object);
        while (n11 < n12) {
            int n13 = zzgf.zza(byArray, n11, zzge2);
            int n14 = zzge2.zza;
            if (n10 != n14) break;
            n11 = zzgf.zzi(zzji2, byArray, n13, n12, zzge2);
            object = zzge2.zzc;
            zzhz2.add(object);
        }
        return n11;
    }

    public static int zzn(int n10, byte[] object, int n11, int n12, zzjx zzjx2, zzge zzge2) {
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
                                object = zzgf.zzd(object, n11);
                                zzjx2.zzh(n10, object);
                                return n11 + 4;
                            }
                            throw zzic.zzc();
                        }
                        n13 = n10 & 0xFFFFFFF8 | 4;
                        zzjx zzjx3 = zzjx.zzb();
                        n14 = 0;
                        while (n11 < n12) {
                            int n15 = zzgf.zza(object, n11, zzge2);
                            n11 = zzge2.zza;
                            if (n11 == n13) {
                                n14 = n11;
                                n11 = n15;
                                break;
                            }
                            n14 = n11;
                            int n16 = zzgf.zzn(n11, object, n15, n12, zzjx3, zzge2);
                            n14 = n11;
                            n11 = n16;
                        }
                        if (n11 <= n12 && n14 == n13) {
                            zzjx2.zzh(n10, zzjx3);
                            return n11;
                        }
                        throw zzic.zze();
                    }
                    n11 = zzgf.zza(object, n11, zzge2);
                    n12 = zzge2.zza;
                    if (n12 >= 0) {
                        int n17 = ((byte[])object).length - n11;
                        if (n12 <= n17) {
                            if (n12 == 0) {
                                object = zzgs.zzb;
                                zzjx2.zzh(n10, object);
                            } else {
                                object = zzgs.zzj(object, n11, n12);
                                zzjx2.zzh(n10, object);
                            }
                            return n11 + n12;
                        }
                        throw zzic.zza();
                    }
                    throw zzic.zzb();
                }
                object = zzgf.zze(object, n11);
                zzjx2.zzh(n10, object);
                return n11 + 8;
            }
            int n18 = zzgf.zzc(object, n11, zzge2);
            Long l10 = zzge2.zzb;
            zzjx2.zzh(n10, l10);
            return n18;
        }
        throw zzic.zzc();
    }
}

