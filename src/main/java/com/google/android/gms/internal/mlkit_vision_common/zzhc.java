/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzdf;
import com.google.android.gms.internal.mlkit_vision_common.zzdw;
import com.google.android.gms.internal.mlkit_vision_common.zzer;
import com.google.android.gms.internal.mlkit_vision_common.zzeu;
import com.google.android.gms.internal.mlkit_vision_common.zzfw;
import com.google.android.gms.internal.mlkit_vision_common.zzht;
import com.google.android.gms.internal.mlkit_vision_common.zzhw;
import java.util.Arrays;

public final class zzhc {
    private static final zzhc zza;
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    static {
        zzhc zzhc2;
        int[] nArray = new int[]{};
        Object[] objectArray = new Object[]{};
        zza = zzhc2 = new zzhc(0, nArray, objectArray, false);
    }

    private zzhc() {
        int n10 = 8;
        int[] nArray = new int[n10];
        Object[] objectArray = new Object[n10];
        this(0, nArray, objectArray, true);
    }

    private zzhc(int n10, int[] nArray, Object[] objectArray, boolean bl2) {
        this.zze = -1;
        this.zzb = n10;
        this.zzc = nArray;
        this.zzd = objectArray;
        this.zzf = bl2;
    }

    public static zzhc zza() {
        return zza;
    }

    public static zzhc zza(zzhc zzhc2, zzhc zzhc3) {
        int n10 = zzhc2.zzb;
        int n11 = zzhc3.zzb;
        int[] nArray = Arrays.copyOf(zzhc2.zzc, n10 += n11);
        Object[] objectArray = zzhc3.zzc;
        int n12 = zzhc2.zzb;
        int n13 = zzhc3.zzb;
        System.arraycopy(objectArray, 0, nArray, n12, n13);
        objectArray = Arrays.copyOf(zzhc2.zzd, n10);
        Object[] objectArray2 = zzhc3.zzd;
        int n14 = zzhc2.zzb;
        int n15 = zzhc3.zzb;
        System.arraycopy(objectArray2, 0, objectArray, n14, n15);
        zzhc2 = new zzhc(n10, nArray, objectArray, true);
        return zzhc2;
    }

    private static void zza(int n10, Object object, zzht zzht2) {
        int n11 = n10 >>> 3;
        if ((n10 &= 7) != 0) {
            int n12 = 1;
            if (n10 != n12) {
                n12 = 2;
                if (n10 != n12) {
                    n12 = 3;
                    if (n10 != n12) {
                        n12 = 5;
                        if (n10 == n12) {
                            n10 = (Integer)object;
                            zzht2.zzd(n11, n10);
                            return;
                        }
                        object = zzer.zza();
                        RuntimeException runtimeException = new RuntimeException((Throwable)object);
                        throw runtimeException;
                    }
                    n10 = zzht2.zza();
                    if (n10 == (n12 = zzhw.zza)) {
                        zzht2.zza(n11);
                        ((zzhc)object).zzb(zzht2);
                        zzht2.zzb(n11);
                        return;
                    }
                    zzht2.zzb(n11);
                    ((zzhc)object).zzb(zzht2);
                    zzht2.zza(n11);
                    return;
                }
                object = (zzdf)object;
                zzht2.zza(n11, (zzdf)object);
                return;
            }
            long l10 = (Long)object;
            zzht2.zzd(n11, l10);
            return;
        }
        long l11 = (Long)object;
        zzht2.zza(n11, l11);
    }

    public final boolean equals(Object objectArray) {
        int n10 = 1;
        if (this == objectArray) {
            return n10 != 0;
        }
        if (objectArray == null) {
            return false;
        }
        int n11 = objectArray instanceof zzhc;
        if (!n11) {
            return false;
        }
        objectArray = (zzhc)objectArray;
        n11 = this.zzb;
        int n12 = objectArray.zzb;
        if (n11 == n12) {
            Object[] objectArray2;
            int n13;
            Object object;
            int[] nArray;
            block8: {
                int[] nArray2 = this.zzc;
                nArray = objectArray.zzc;
                object = null;
                for (n13 = 0; n13 < n11; n13 += 1) {
                    int n14 = nArray2[n13];
                    int n15 = nArray[n13];
                    if (n14 == n15) continue;
                    n11 = 0;
                    objectArray2 = null;
                    break block8;
                }
                n11 = n10;
            }
            if (n11) {
                int n16;
                block9: {
                    objectArray2 = this.zzd;
                    objectArray = objectArray.zzd;
                    n12 = this.zzb;
                    nArray = null;
                    for (int i10 = 0; i10 < n12; ++i10) {
                        object = objectArray2[i10];
                        Object object2 = objectArray[i10];
                        n13 = object.equals(object2);
                        if (n13) continue;
                        n16 = 0;
                        objectArray = null;
                        break block9;
                    }
                    n16 = n10;
                }
                if (n16) {
                    return n10 != 0;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int n10;
        int n11 = this.zzb;
        int n12 = (n11 + 527) * 31;
        int[] nArray = this.zzc;
        int n13 = 0;
        int n14 = 17;
        Object object = null;
        int n15 = n14;
        for (n10 = 0; n10 < n11; ++n10) {
            n15 *= 31;
            int n16 = nArray[n10];
            n15 += n16;
        }
        n12 = (n12 + n15) * 31;
        Object[] objectArray = this.zzd;
        int n17 = this.zzb;
        while (n13 < n17) {
            n14 *= 31;
            object = objectArray[n13];
            n10 = object.hashCode();
            n14 += n10;
            ++n13;
        }
        return n12 + n14;
    }

    public final void zza(zzht zzht2) {
        int n10;
        int n11 = zzht2.zza();
        if (n11 == (n10 = zzhw.zzb)) {
            for (n11 = this.zzb + -1; n11 >= 0; n11 += -1) {
                int[] nArray = this.zzc;
                n10 = nArray[n11] >>> 3;
                Object object = this.zzd[n11];
                zzht2.zza(n10, object);
            }
            return;
        }
        for (n11 = 0; n11 < (n10 = this.zzb); ++n11) {
            int[] nArray = this.zzc;
            n10 = nArray[n11] >>> 3;
            Object object = this.zzd[n11];
            zzht2.zza(n10, object);
        }
    }

    public final void zza(StringBuilder stringBuilder, int n10) {
        int n11;
        for (int i10 = 0; i10 < (n11 = this.zzb); ++i10) {
            n11 = this.zzc[i10] >>> 3;
            String string2 = String.valueOf(n11);
            Object object = this.zzd[i10];
            zzfw.zza(stringBuilder, n10, string2, object);
        }
    }

    public final void zzb() {
        this.zzf = false;
    }

    public final void zzb(zzht zzht2) {
        int n10;
        int n11 = this.zzb;
        if (n11 == 0) {
            return;
        }
        n11 = zzht2.zza();
        if (n11 == (n10 = zzhw.zza)) {
            for (n11 = 0; n11 < (n10 = this.zzb); ++n11) {
                int[] nArray = this.zzc;
                n10 = nArray[n11];
                Object object = this.zzd[n11];
                zzhc.zza(n10, object, zzht2);
            }
            return;
        }
        for (n11 = this.zzb + -1; n11 >= 0; n11 += -1) {
            int[] nArray = this.zzc;
            n10 = nArray[n11];
            Object object = this.zzd[n11];
            zzhc.zza(n10, object, zzht2);
        }
    }

    public final int zzc() {
        int n10;
        int n11 = this.zze;
        int n12 = -1;
        if (n11 != n12) {
            return n11;
        }
        n12 = 0;
        for (n11 = 0; n11 < (n10 = this.zzb); ++n11) {
            int[] nArray = this.zzc;
            n10 = nArray[n11] >>> 3;
            zzdf zzdf2 = (zzdf)this.zzd[n11];
            n10 = zzdw.zzd(n10, zzdf2);
            n12 += n10;
        }
        this.zze = n12;
        return n12;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final int zzd() {
        int n10 = this.zze;
        int n11 = -1;
        if (n10 != n11) {
            return n10;
        }
        n10 = 0;
        IllegalStateException illegalStateException = null;
        n11 = 0;
        zzeu zzeu2 = null;
        while (true) {
            int n12;
            block8: {
                long l10;
                int n13;
                Object object;
                block9: {
                    block10: {
                        if (n10 >= (n12 = this.zzb)) {
                            this.zze = n11;
                            return n11;
                        }
                        object = this.zzc;
                        n12 = object[n10];
                        n13 = n12 >>> 3;
                        if ((n12 &= 7) == 0) break block9;
                        int n14 = 1;
                        if (n12 == n14) break block10;
                        int n15 = 2;
                        if (n12 != n15) {
                            n15 = 3;
                            if (n12 != n15) {
                                n14 = 5;
                                if (n12 != n14) {
                                    zzeu2 = zzer.zza();
                                    illegalStateException = new IllegalStateException(zzeu2);
                                    throw illegalStateException;
                                }
                                object = (Integer)this.zzd[n10];
                                n12 = (Integer)object;
                                n12 = zzdw.zzi(n13, n12);
                                break block8;
                            } else {
                                n12 = zzdw.zze(n13) << n14;
                                zzhc zzhc2 = (zzhc)this.zzd[n10];
                                n13 = zzhc2.zzd();
                                n12 += n13;
                            }
                            break block8;
                        } else {
                            object = (zzdf)this.zzd[n10];
                            n12 = zzdw.zzc(n13, (zzdf)object);
                        }
                        break block8;
                    }
                    object = (Long)this.zzd[n10];
                    l10 = (Long)object;
                    n12 = zzdw.zzg(n13, l10);
                    break block8;
                }
                object = (Long)this.zzd[n10];
                l10 = (Long)object;
                n12 = zzdw.zze(n13, l10);
            }
            n11 += n12;
            ++n10;
        }
    }
}

