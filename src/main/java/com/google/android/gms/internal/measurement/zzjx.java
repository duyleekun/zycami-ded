/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgs;
import com.google.android.gms.internal.measurement.zzgz;
import com.google.android.gms.internal.measurement.zzha;
import com.google.android.gms.internal.measurement.zzib;
import com.google.android.gms.internal.measurement.zzic;
import com.google.android.gms.internal.measurement.zziz;
import java.util.Arrays;

public final class zzjx {
    private static final zzjx zza;
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    static {
        zzjx zzjx2;
        int[] nArray = new int[]{};
        Object[] objectArray = new Object[]{};
        zza = zzjx2 = new zzjx(0, nArray, objectArray, false);
    }

    private zzjx() {
        int n10 = 8;
        int[] nArray = new int[n10];
        Object[] objectArray = new Object[n10];
        this(0, nArray, objectArray, true);
    }

    private zzjx(int n10, int[] nArray, Object[] objectArray, boolean bl2) {
        this.zze = -1;
        this.zzb = n10;
        this.zzc = nArray;
        this.zzd = objectArray;
        this.zzf = bl2;
    }

    public static zzjx zza() {
        return zza;
    }

    public static zzjx zzb() {
        int n10 = 8;
        int[] nArray = new int[n10];
        Object[] objectArray = new Object[n10];
        zzjx zzjx2 = new zzjx(0, nArray, objectArray, true);
        return zzjx2;
    }

    public static zzjx zzc(zzjx zzjx2, zzjx zzjx3) {
        int n10 = zzjx2.zzb;
        int n11 = zzjx3.zzb;
        int[] nArray = Arrays.copyOf(zzjx2.zzc, n10 += n11);
        Object[] objectArray = zzjx3.zzc;
        int n12 = zzjx2.zzb;
        int n13 = zzjx3.zzb;
        System.arraycopy(objectArray, 0, nArray, n12, n13);
        objectArray = Arrays.copyOf(zzjx2.zzd, n10);
        Object[] objectArray2 = zzjx3.zzd;
        int n14 = zzjx2.zzb;
        int n15 = zzjx3.zzb;
        System.arraycopy(objectArray2, 0, objectArray, n14, n15);
        zzjx2 = new zzjx(n10, nArray, objectArray, true);
        return zzjx2;
    }

    public final boolean equals(Object objectArray) {
        block8: {
            boolean bl2 = true;
            if (this == objectArray) {
                return bl2;
            }
            if (objectArray == null) {
                return false;
            }
            int n10 = objectArray instanceof zzjx;
            if (n10 == 0) {
                return false;
            }
            objectArray = (zzjx)objectArray;
            n10 = this.zzb;
            int n11 = objectArray.zzb;
            if (n10 == n11) {
                int n12;
                int[] nArray = this.zzc;
                int[] nArray2 = objectArray.zzc;
                Object object = null;
                for (n12 = 0; n12 < n10; ++n12) {
                    int n13 = nArray[n12];
                    int n14 = nArray2[n12];
                    if (n13 == n14) {
                        continue;
                    }
                    break block8;
                }
                Object[] objectArray2 = this.zzd;
                objectArray = objectArray.zzd;
                n11 = this.zzb;
                nArray2 = null;
                for (int i10 = 0; i10 < n11; ++i10) {
                    object = objectArray2[i10];
                    Object object2 = objectArray[i10];
                    n12 = (int)(object.equals(object2) ? 1 : 0);
                    if (n12 != 0) {
                        continue;
                    }
                    break block8;
                }
                return bl2;
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

    public final void zzd() {
        this.zzf = false;
    }

    public final int zze() {
        int n10 = this.zze;
        int n11 = -1;
        if (n10 == n11) {
            int n12;
            n11 = 0;
            for (n10 = 0; n10 < (n12 = this.zzb); ++n10) {
                int[] nArray = this.zzc;
                n12 = nArray[n10];
                zzgs zzgs2 = (zzgs)this.zzd[n10];
                int n13 = zzgz.zzw(8);
                int n14 = zzgz.zzw(16);
                n12 = zzgz.zzw(n12 >>> 3);
                int n15 = zzgz.zzw(24);
                int n16 = zzgs2.zzc();
                n13 += n13;
                n13 += (n14 += n12);
                n12 = zzgz.zzw(n16) + n16;
                n11 += (n13 += (n15 += n12));
            }
            this.zze = n11;
            return n11;
        }
        return n10;
    }

    public final int zzf() {
        int n10;
        block1: {
            int n11;
            n10 = this.zze;
            int n12 = -1;
            if (n10 != n12) break block1;
            IllegalStateException illegalStateException = null;
            n12 = 0;
            zzib zzib2 = null;
            for (n10 = 0; n10 < (n11 = this.zzb); ++n10) {
                block7: {
                    int n13;
                    block8: {
                        Object object;
                        block2: {
                            block3: {
                                int n14;
                                block4: {
                                    block5: {
                                        block6: {
                                            object = this.zzc;
                                            n11 = object[n10];
                                            n13 = n11 >>> 3;
                                            if ((n11 &= 7) == 0) break block2;
                                            n14 = 1;
                                            if (n11 == n14) break block3;
                                            n14 = 2;
                                            if (n11 == n14) break block4;
                                            n14 = 3;
                                            if (n11 == n14) break block5;
                                            n14 = 5;
                                            if (n11 != n14) break block6;
                                            object = (Integer)this.zzd[n10];
                                            ((Integer)object).intValue();
                                            n11 = zzgz.zzw(n13 << 3) + 4;
                                            break block7;
                                        }
                                        zzib2 = zzic.zzd();
                                        illegalStateException = new IllegalStateException(zzib2);
                                        throw illegalStateException;
                                    }
                                    n11 = zzgz.zzu(n13);
                                    n11 += n11;
                                    zzjx zzjx2 = (zzjx)this.zzd[n10];
                                    n13 = zzjx2.zzf();
                                    break block8;
                                }
                                object = (zzgs)this.zzd[n10];
                                n13 = zzgz.zzw(n13 << 3);
                                n11 = ((zzgs)object).zzc();
                                n14 = zzgz.zzw(n11) + n11;
                                n12 += (n13 += n14);
                                continue;
                            }
                            object = (Long)this.zzd[n10];
                            ((Long)object).longValue();
                            n11 = zzgz.zzw(n13 << 3) + 8;
                            break block7;
                        }
                        object = (Long)this.zzd[n10];
                        long l10 = (Long)object;
                        n11 = zzgz.zzw(n13 << 3);
                        n13 = zzgz.zzx(l10);
                    }
                    n11 += n13;
                }
                n12 += n11;
            }
            this.zze = n12;
            return n12;
        }
        return n10;
    }

    public final void zzg(StringBuilder stringBuilder, int n10) {
        int n11;
        for (int i10 = 0; i10 < (n11 = this.zzb); ++i10) {
            n11 = this.zzc[i10] >>> 3;
            String string2 = String.valueOf(n11);
            Object object = this.zzd[i10];
            zziz.zzb(stringBuilder, n10, string2, object);
        }
    }

    public final void zzh(int n10, Object object) {
        int n11 = this.zzf;
        if (n11 != 0) {
            int[] nArray;
            n11 = this.zzb;
            Object[] objectArray = this.zzc;
            int n12 = objectArray.length;
            if (n11 == n12) {
                n12 = 4;
                n12 = n11 < n12 ? 8 : n11 >> 1;
                this.zzc = objectArray = Arrays.copyOf(objectArray, n11 += n12);
                objectArray = this.zzd;
                nArray = Arrays.copyOf(objectArray, n11);
                this.zzd = nArray;
            }
            nArray = this.zzc;
            int n13 = this.zzb;
            nArray[n13] = n10;
            this.zzd[n13] = object;
            this.zzb = ++n13;
            return;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public final void zzi(zzha object) {
        int n10 = this.zzb;
        if (n10 != 0) {
            int n11;
            zzib zzib2 = null;
            for (n10 = 0; n10 < (n11 = this.zzb); ++n10) {
                long l10;
                int[] nArray = this.zzc;
                n11 = nArray[n10];
                Object object2 = this.zzd[n10];
                int n12 = n11 >>> 3;
                if ((n11 &= 7) != 0) {
                    int n13 = 1;
                    if (n11 != n13) {
                        n13 = 2;
                        if (n11 != n13) {
                            n13 = 3;
                            if (n11 != n13) {
                                n13 = 5;
                                if (n11 == n13) {
                                    object2 = (Integer)object2;
                                    n11 = (Integer)object2;
                                    ((zzha)object).zzk(n12, n11);
                                    continue;
                                }
                                zzib2 = zzic.zzd();
                                object = new RuntimeException(zzib2);
                                throw object;
                            }
                            ((zzha)object).zzt(n12);
                            object2 = (zzjx)object2;
                            ((zzjx)object2).zzi((zzha)object);
                            ((zzha)object).zzu(n12);
                            continue;
                        }
                        object2 = (zzgs)object2;
                        ((zzha)object).zzn(n12, (zzgs)object2);
                        continue;
                    }
                    object2 = (Long)object2;
                    l10 = (Long)object2;
                    ((zzha)object).zzj(n12, l10);
                    continue;
                }
                object2 = (Long)object2;
                l10 = (Long)object2;
                ((zzha)object).zzc(n12, l10);
            }
        }
    }
}

