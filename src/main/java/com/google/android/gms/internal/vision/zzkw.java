/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgs;
import com.google.android.gms.internal.vision.zzhl;
import com.google.android.gms.internal.vision.zzim;
import com.google.android.gms.internal.vision.zzin;
import com.google.android.gms.internal.vision.zzjo;
import com.google.android.gms.internal.vision.zzlq;
import com.google.android.gms.internal.vision.zzlt;
import java.util.Arrays;

public final class zzkw {
    private static final zzkw zzacc;
    private int count;
    private Object[] zzaal;
    private int[] zzacd;
    private boolean zztf;
    private int zzya;

    static {
        zzkw zzkw2;
        int[] nArray = new int[]{};
        Object[] objectArray = new Object[]{};
        zzacc = zzkw2 = new zzkw(0, nArray, objectArray, false);
    }

    private zzkw() {
        int n10 = 8;
        int[] nArray = new int[n10];
        Object[] objectArray = new Object[n10];
        this(0, nArray, objectArray, true);
    }

    private zzkw(int n10, int[] nArray, Object[] objectArray, boolean bl2) {
        this.zzya = -1;
        this.count = n10;
        this.zzacd = nArray;
        this.zzaal = objectArray;
        this.zztf = bl2;
    }

    public static zzkw zza(zzkw zzkw2, zzkw zzkw3) {
        int n10 = zzkw2.count;
        int n11 = zzkw3.count;
        int[] nArray = Arrays.copyOf(zzkw2.zzacd, n10 += n11);
        Object[] objectArray = zzkw3.zzacd;
        int n12 = zzkw2.count;
        int n13 = zzkw3.count;
        System.arraycopy(objectArray, 0, nArray, n12, n13);
        objectArray = Arrays.copyOf(zzkw2.zzaal, n10);
        Object[] objectArray2 = zzkw3.zzaal;
        int n14 = zzkw2.count;
        int n15 = zzkw3.count;
        System.arraycopy(objectArray2, 0, objectArray, n14, n15);
        zzkw2 = new zzkw(n10, nArray, objectArray, true);
        return zzkw2;
    }

    private static void zzb(int n10, Object object, zzlq zzlq2) {
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
                            zzlq2.zzm(n11, n10);
                            return;
                        }
                        object = zzin.zzhm();
                        RuntimeException runtimeException = new RuntimeException((Throwable)object);
                        throw runtimeException;
                    }
                    n10 = zzlq2.zzgd();
                    if (n10 == (n12 = zzlt.zzaex)) {
                        zzlq2.zzbq(n11);
                        ((zzkw)object).zzb(zzlq2);
                        zzlq2.zzbr(n11);
                        return;
                    }
                    zzlq2.zzbr(n11);
                    ((zzkw)object).zzb(zzlq2);
                    zzlq2.zzbq(n11);
                    return;
                }
                object = (zzgs)object;
                zzlq2.zza(n11, (zzgs)object);
                return;
            }
            long l10 = (Long)object;
            zzlq2.zzc(n11, l10);
            return;
        }
        long l11 = (Long)object;
        zzlq2.zzi(n11, l11);
    }

    public static zzkw zzja() {
        return zzacc;
    }

    public static zzkw zzjb() {
        zzkw zzkw2 = new zzkw();
        return zzkw2;
    }

    public final boolean equals(Object objectArray) {
        int n10 = 1;
        if (this == objectArray) {
            return n10 != 0;
        }
        if (objectArray == null) {
            return false;
        }
        int n11 = objectArray instanceof zzkw;
        if (!n11) {
            return false;
        }
        objectArray = (zzkw)objectArray;
        n11 = this.count;
        int n12 = objectArray.count;
        if (n11 == n12) {
            Object[] objectArray2;
            int n13;
            Object object;
            int[] nArray;
            block8: {
                int[] nArray2 = this.zzacd;
                nArray = objectArray.zzacd;
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
                    objectArray2 = this.zzaal;
                    objectArray = objectArray.zzaal;
                    n12 = this.count;
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
        int n11 = this.count;
        int n12 = (n11 + 527) * 31;
        int[] nArray = this.zzacd;
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
        Object[] objectArray = this.zzaal;
        int n17 = this.count;
        while (n13 < n17) {
            n14 *= 31;
            object = objectArray[n13];
            n10 = object.hashCode();
            n14 += n10;
            ++n13;
        }
        return n12 + n14;
    }

    public final void zza(zzlq zzlq2) {
        int n10;
        int n11 = zzlq2.zzgd();
        if (n11 == (n10 = zzlt.zzaey)) {
            for (n11 = this.count + -1; n11 >= 0; n11 += -1) {
                int[] nArray = this.zzacd;
                n10 = nArray[n11] >>> 3;
                Object object = this.zzaal[n11];
                zzlq2.zza(n10, object);
            }
            return;
        }
        for (n11 = 0; n11 < (n10 = this.count); ++n11) {
            int[] nArray = this.zzacd;
            n10 = nArray[n11] >>> 3;
            Object object = this.zzaal[n11];
            zzlq2.zza(n10, object);
        }
    }

    public final void zza(StringBuilder stringBuilder, int n10) {
        int n11;
        for (int i10 = 0; i10 < (n11 = this.count); ++i10) {
            n11 = this.zzacd[i10] >>> 3;
            String string2 = String.valueOf(n11);
            Object object = this.zzaal[i10];
            zzjo.zza(stringBuilder, n10, string2, object);
        }
    }

    public final void zzb(int n10, Object object) {
        int n11 = this.zztf;
        if (n11 != 0) {
            int[] nArray;
            n11 = this.count;
            Object[] objectArray = this.zzacd;
            int n12 = objectArray.length;
            if (n11 == n12) {
                n12 = 4;
                n12 = n11 < n12 ? 8 : n11 >> 1;
                this.zzacd = objectArray = Arrays.copyOf(objectArray, n11 += n12);
                objectArray = this.zzaal;
                nArray = Arrays.copyOf(objectArray, n11);
                this.zzaal = nArray;
            }
            nArray = this.zzacd;
            int n13 = this.count;
            nArray[n13] = n10;
            this.zzaal[n13] = object;
            this.count = ++n13;
            return;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public final void zzb(zzlq zzlq2) {
        int n10;
        int n11 = this.count;
        if (n11 == 0) {
            return;
        }
        n11 = zzlq2.zzgd();
        if (n11 == (n10 = zzlt.zzaex)) {
            for (n11 = 0; n11 < (n10 = this.count); ++n11) {
                int[] nArray = this.zzacd;
                n10 = nArray[n11];
                Object object = this.zzaal[n11];
                zzkw.zzb(n10, object, zzlq2);
            }
            return;
        }
        for (n11 = this.count + -1; n11 >= 0; n11 += -1) {
            int[] nArray = this.zzacd;
            n10 = nArray[n11];
            Object object = this.zzaal[n11];
            zzkw.zzb(n10, object, zzlq2);
        }
    }

    public final void zzej() {
        this.zztf = false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final int zzgz() {
        int n10 = this.zzya;
        int n11 = -1;
        if (n10 != n11) {
            return n10;
        }
        n10 = 0;
        IllegalStateException illegalStateException = null;
        n11 = 0;
        zzim zzim2 = null;
        while (true) {
            int n12;
            block8: {
                long l10;
                int n13;
                Object object;
                block9: {
                    block10: {
                        if (n10 >= (n12 = this.count)) {
                            this.zzya = n11;
                            return n11;
                        }
                        object = this.zzacd;
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
                                    zzim2 = zzin.zzhm();
                                    illegalStateException = new IllegalStateException(zzim2);
                                    throw illegalStateException;
                                }
                                object = (Integer)this.zzaal[n10];
                                n12 = (Integer)object;
                                n12 = zzhl.zzq(n13, n12);
                                break block8;
                            } else {
                                n12 = zzhl.zzbh(n13) << n14;
                                zzkw zzkw2 = (zzkw)this.zzaal[n10];
                                n13 = zzkw2.zzgz();
                                n12 += n13;
                            }
                            break block8;
                        } else {
                            object = (zzgs)this.zzaal[n10];
                            n12 = zzhl.zzc(n13, (zzgs)object);
                        }
                        break block8;
                    }
                    object = (Long)this.zzaal[n10];
                    l10 = (Long)object;
                    n12 = zzhl.zzg(n13, l10);
                    break block8;
                }
                object = (Long)this.zzaal[n10];
                l10 = (Long)object;
                n12 = zzhl.zze(n13, l10);
            }
            n11 += n12;
            ++n10;
        }
    }

    public final int zzjc() {
        int n10;
        int n11 = this.zzya;
        int n12 = -1;
        if (n11 != n12) {
            return n11;
        }
        n12 = 0;
        for (n11 = 0; n11 < (n10 = this.count); ++n11) {
            int[] nArray = this.zzacd;
            n10 = nArray[n11] >>> 3;
            zzgs zzgs2 = (zzgs)this.zzaal[n11];
            n10 = zzhl.zzd(n10, zzgs2);
            n12 += n10;
        }
        this.zzya = n12;
        return n12;
    }
}

