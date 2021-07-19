/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgm;
import com.google.android.gms.internal.vision.zzgs;
import com.google.android.gms.internal.vision.zzie;
import com.google.android.gms.internal.vision.zzif;
import com.google.android.gms.internal.vision.zzik;
import com.google.android.gms.internal.vision.zzin;
import com.google.android.gms.internal.vision.zzjr;
import com.google.android.gms.internal.vision.zzkf;
import com.google.android.gms.internal.vision.zzkw;
import com.google.android.gms.internal.vision.zzlf;
import java.nio.charset.Charset;

public final class zzgk {
    public static int zza(int n10, byte[] byArray, int n11, int n12, zzgm zzgm2) {
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
                            throw zzin.zzhk();
                        }
                        n10 = n10 & 0xFFFFFFF8 | 4;
                        n13 = 0;
                        while (n11 < n12) {
                            n11 = zzgk.zza(byArray, n11, zzgm2);
                            n13 = zzgm2.zztk;
                            if (n13 == n10) break;
                            n11 = zzgk.zza(n13, byArray, n11, n12, zzgm2);
                        }
                        if (n11 <= n12 && n13 == n10) {
                            return n11;
                        }
                        throw zzin.zzhn();
                    }
                    n10 = zzgk.zza(byArray, n11, zzgm2);
                    int n15 = zzgm2.zztk;
                    return n10 + n15;
                }
                return n11 + 8;
            }
            return zzgk.zzb(byArray, n11, zzgm2);
        }
        throw zzin.zzhk();
    }

    public static int zza(int n10, byte[] byArray, int n11, int n12, zzik zzik2, zzgm zzgm2) {
        zzik2 = (zzif)zzik2;
        n11 = zzgk.zza(byArray, n11, zzgm2);
        int n13 = zzgm2.zztk;
        ((zzif)zzik2).zzbs(n13);
        while (n11 < n12) {
            n13 = zzgk.zza(byArray, n11, zzgm2);
            int n14 = zzgm2.zztk;
            if (n10 != n14) break;
            n11 = zzgk.zza(byArray, n13, zzgm2);
            n13 = zzgm2.zztk;
            ((zzif)zzik2).zzbs(n13);
        }
        return n11;
    }

    public static int zza(int n10, byte[] object, int n11, int n12, zzkw zzkw2, zzgm zzgm2) {
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
                                object = zzgk.zza(object, n11);
                                zzkw2.zzb(n10, object);
                                return n11 + 4;
                            }
                            throw zzin.zzhk();
                        }
                        zzkw zzkw3 = zzkw.zzjb();
                        int n15 = n10 & 0xFFFFFFF8 | 4;
                        n13 = 0;
                        while (n11 < n12) {
                            int n16 = zzgk.zza(object, n11, zzgm2);
                            n13 = n11 = zzgm2.zztk;
                            if (n11 != n15) {
                                int n17 = zzgk.zza(n11, object, n16, n12, zzkw3, zzgm2);
                                n13 = n11;
                                n11 = n17;
                                continue;
                            }
                            n11 = n16;
                            break;
                        }
                        if (n11 <= n12 && n13 == n15) {
                            zzkw2.zzb(n10, zzkw3);
                            return n11;
                        }
                        throw zzin.zzhn();
                    }
                    n11 = zzgk.zza(object, n11, zzgm2);
                    n12 = zzgm2.zztk;
                    if (n12 >= 0) {
                        int n18 = ((byte[])object).length - n11;
                        if (n12 <= n18) {
                            if (n12 == 0) {
                                object = zzgs.zztt;
                                zzkw2.zzb(n10, object);
                            } else {
                                object = zzgs.zza(object, n11, n12);
                                zzkw2.zzb(n10, object);
                            }
                            return n11 + n12;
                        }
                        throw zzin.zzhh();
                    }
                    throw zzin.zzhi();
                }
                object = zzgk.zzb(object, n11);
                zzkw2.zzb(n10, object);
                return n11 + 8;
            }
            int n19 = zzgk.zzb(object, n11, zzgm2);
            Long l10 = zzgm2.zztl;
            zzkw2.zzb(n10, l10);
            return n19;
        }
        throw zzin.zzhk();
    }

    public static int zza(int n10, byte[] byArray, int n11, zzgm zzgm2) {
        n10 &= 0x7F;
        int n12 = n11 + 1;
        if ((n11 = byArray[n11]) >= 0) {
            int n13 = n11 << 7;
            zzgm2.zztk = n10 |= n13;
            return n12;
        }
        n11 = (n11 & 0x7F) << 7;
        n10 |= n11;
        n11 = n12 + 1;
        if ((n12 = byArray[n12]) >= 0) {
            int n14 = n12 << 14;
            zzgm2.zztk = n10 |= n14;
            return n11;
        }
        n12 = (n12 & 0x7F) << 14;
        n10 |= n12;
        n12 = n11 + 1;
        if ((n11 = byArray[n11]) >= 0) {
            int n15 = n11 << 21;
            zzgm2.zztk = n10 |= n15;
            return n12;
        }
        n11 = (n11 & 0x7F) << 21;
        n10 |= n11;
        n11 = n12 + 1;
        if ((n12 = byArray[n12]) >= 0) {
            int n16 = n12 << 28;
            zzgm2.zztk = n10 |= n16;
            return n11;
        }
        n12 = (n12 & 0x7F) << 28;
        n10 |= n12;
        while (true) {
            n12 = n11 + 1;
            if ((n11 = byArray[n11]) >= 0) {
                zzgm2.zztk = n10;
                return n12;
            }
            n11 = n12;
        }
    }

    public static int zza(zzkf zzkf2, int n10, byte[] byArray, int n11, int n12, zzik zzik2, zzgm zzgm2) {
        n11 = zzgk.zza(zzkf2, byArray, n11, n12, zzgm2);
        Object object = zzgm2.zztm;
        zzik2.add(object);
        while (n11 < n12) {
            int n13 = zzgk.zza(byArray, n11, zzgm2);
            int n14 = zzgm2.zztk;
            if (n10 != n14) break;
            n11 = zzgk.zza(zzkf2, byArray, n13, n12, zzgm2);
            object = zzgm2.zztm;
            zzik2.add(object);
        }
        return n11;
    }

    public static int zza(zzkf zzkf2, byte[] byArray, int n10, int n11, int n12, zzgm zzgm2) {
        zzkf2 = (zzjr)zzkf2;
        Object object = ((zzjr)zzkf2).newInstance();
        int n13 = ((zzjr)zzkf2).zza(object, byArray, n10, n11, n12, zzgm2);
        ((zzjr)zzkf2).zzj(object);
        zzgm2.zztm = object;
        return n13;
    }

    public static int zza(zzkf zzkf2, byte[] byArray, int n10, int n11, zzgm zzgm2) {
        int n12 = n10 + 1;
        if ((n10 = byArray[n10]) < 0) {
            n12 = zzgk.zza(n10, byArray, n12, zzgm2);
            n10 = zzgm2.zztk;
        }
        if (n10 >= 0 && n10 <= (n11 -= n12)) {
            Object object = zzkf2.newInstance();
            zzkf2.zza(object, byArray, n12, n10 += n12, zzgm2);
            zzkf2.zzj(object);
            zzgm2.zztm = object;
            return n10;
        }
        throw zzin.zzhh();
    }

    public static int zza(byte[] byArray, int n10) {
        int n11 = byArray[n10] & 0xFF;
        int n12 = n10 + 1;
        n12 = (byArray[n12] & 0xFF) << 8;
        n11 |= n12;
        n12 = n10 + 2;
        n12 = (byArray[n12] & 0xFF) << 16;
        return (byArray[n10 += 3] & 0xFF) << 24 | (n11 |= n12);
    }

    public static int zza(byte[] byArray, int n10, zzgm zzgm2) {
        int n11 = n10 + 1;
        if ((n10 = byArray[n10]) >= 0) {
            zzgm2.zztk = n10;
            return n11;
        }
        return zzgk.zza(n10, byArray, n11, zzgm2);
    }

    public static int zza(byte[] byArray, int n10, zzik zzik2, zzgm zzgm2) {
        zzik2 = (zzif)zzik2;
        n10 = zzgk.zza(byArray, n10, zzgm2);
        int n11 = zzgm2.zztk + n10;
        while (n10 < n11) {
            n10 = zzgk.zza(byArray, n10, zzgm2);
            int n12 = zzgm2.zztk;
            ((zzif)zzik2).zzbs(n12);
        }
        if (n10 == n11) {
            return n10;
        }
        throw zzin.zzhh();
    }

    public static int zzb(byte[] byArray, int n10, zzgm zzgm2) {
        int n11 = n10 + 1;
        long l10 = byArray[n10];
        long l11 = 0L;
        long l12 = l10 - l11;
        if ((n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1))) >= 0) {
            zzgm2.zztl = l10;
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
        zzgm2.zztl = l10;
        return n10;
    }

    public static long zzb(byte[] byArray, int n10) {
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

    public static double zzc(byte[] byArray, int n10) {
        return Double.longBitsToDouble(zzgk.zzb(byArray, n10));
    }

    public static int zzc(byte[] byArray, int n10, zzgm zzgm2) {
        n10 = zzgk.zza(byArray, n10, zzgm2);
        int n11 = zzgm2.zztk;
        if (n11 >= 0) {
            if (n11 == 0) {
                zzgm2.zztm = "";
                return n10;
            }
            Charset charset = zzie.UTF_8;
            String string2 = new String(byArray, n10, n11, charset);
            zzgm2.zztm = string2;
            return n10 + n11;
        }
        throw zzin.zzhi();
    }

    public static float zzd(byte[] byArray, int n10) {
        return Float.intBitsToFloat(zzgk.zza(byArray, n10));
    }

    public static int zzd(byte[] object, int n10, zzgm zzgm2) {
        n10 = zzgk.zza(object, n10, zzgm2);
        int n11 = zzgm2.zztk;
        if (n11 >= 0) {
            if (n11 == 0) {
                zzgm2.zztm = "";
                return n10;
            }
            object = zzlf.zzh(object, n10, n11);
            zzgm2.zztm = object;
            return n10 + n11;
        }
        throw zzin.zzhi();
    }

    public static int zze(byte[] object, int n10, zzgm zzgm2) {
        n10 = zzgk.zza(object, n10, zzgm2);
        int n11 = zzgm2.zztk;
        if (n11 >= 0) {
            int n12 = ((byte[])object).length - n10;
            if (n11 <= n12) {
                if (n11 == 0) {
                    object = zzgs.zztt;
                    zzgm2.zztm = object;
                    return n10;
                }
                object = zzgs.zza(object, n10, n11);
                zzgm2.zztm = object;
                return n10 + n11;
            }
            throw zzin.zzhh();
        }
        throw zzin.zzhi();
    }
}

