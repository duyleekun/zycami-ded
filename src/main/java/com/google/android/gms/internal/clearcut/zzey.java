/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzbb;
import com.google.android.gms.internal.clearcut.zzbn;
import com.google.android.gms.internal.clearcut.zzcg$zzg;
import com.google.android.gms.internal.clearcut.zzco;
import com.google.android.gms.internal.clearcut.zzcp;
import com.google.android.gms.internal.clearcut.zzdr;
import com.google.android.gms.internal.clearcut.zzfr;
import java.util.Arrays;

public final class zzey {
    private static final zzey zzoz;
    private int count;
    private boolean zzfa;
    private int zzjq;
    private Object[] zzmj;
    private int[] zzpa;

    static {
        zzey zzey2;
        int[] nArray = new int[]{};
        Object[] objectArray = new Object[]{};
        zzoz = zzey2 = new zzey(0, nArray, objectArray, false);
    }

    private zzey() {
        int n10 = 8;
        int[] nArray = new int[n10];
        Object[] objectArray = new Object[n10];
        this(0, nArray, objectArray, true);
    }

    private zzey(int n10, int[] nArray, Object[] objectArray, boolean bl2) {
        this.zzjq = -1;
        this.count = n10;
        this.zzpa = nArray;
        this.zzmj = objectArray;
        this.zzfa = bl2;
    }

    public static zzey zza(zzey zzey2, zzey zzey3) {
        int n10 = zzey2.count;
        int n11 = zzey3.count;
        int[] nArray = Arrays.copyOf(zzey2.zzpa, n10 += n11);
        Object[] objectArray = zzey3.zzpa;
        int n12 = zzey2.count;
        int n13 = zzey3.count;
        System.arraycopy(objectArray, 0, nArray, n12, n13);
        objectArray = Arrays.copyOf(zzey2.zzmj, n10);
        Object[] objectArray2 = zzey3.zzmj;
        int n14 = zzey2.count;
        int n15 = zzey3.count;
        System.arraycopy(objectArray2, 0, objectArray, n14, n15);
        zzey2 = new zzey(n10, nArray, objectArray, true);
        return zzey2;
    }

    private static void zzb(int n10, Object object, zzfr zzfr2) {
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
                            zzfr2.zzf(n11, n10);
                            return;
                        }
                        object = zzco.zzbn();
                        RuntimeException runtimeException = new RuntimeException((Throwable)object);
                        throw runtimeException;
                    }
                    n10 = zzfr2.zzaj();
                    if (n10 == (n12 = zzcg$zzg.zzko)) {
                        zzfr2.zzaa(n11);
                        ((zzey)object).zzb(zzfr2);
                        zzfr2.zzab(n11);
                        return;
                    }
                    zzfr2.zzab(n11);
                    ((zzey)object).zzb(zzfr2);
                    zzfr2.zzaa(n11);
                    return;
                }
                object = (zzbb)object;
                zzfr2.zza(n11, (zzbb)object);
                return;
            }
            long l10 = (Long)object;
            zzfr2.zzc(n11, l10);
            return;
        }
        long l11 = (Long)object;
        zzfr2.zzi(n11, l11);
    }

    public static zzey zzea() {
        return zzoz;
    }

    public static zzey zzeb() {
        zzey zzey2 = new zzey();
        return zzey2;
    }

    public final boolean equals(Object objectArray) {
        int n10 = 1;
        if (this == objectArray) {
            return n10 != 0;
        }
        if (objectArray == null) {
            return false;
        }
        int n11 = objectArray instanceof zzey;
        if (!n11) {
            return false;
        }
        objectArray = (zzey)objectArray;
        n11 = this.count;
        int n12 = objectArray.count;
        if (n11 == n12) {
            Object[] objectArray2;
            int n13;
            Object object;
            int[] nArray;
            block8: {
                int[] nArray2 = this.zzpa;
                nArray = objectArray.zzpa;
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
                    objectArray2 = this.zzmj;
                    objectArray = objectArray.zzmj;
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
        int[] nArray = this.zzpa;
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
        Object[] objectArray = this.zzmj;
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

    public final void zza(zzfr zzfr2) {
        int n10;
        int n11 = zzfr2.zzaj();
        if (n11 == (n10 = zzcg$zzg.zzkp)) {
            for (n11 = this.count + -1; n11 >= 0; n11 += -1) {
                int[] nArray = this.zzpa;
                n10 = nArray[n11] >>> 3;
                Object object = this.zzmj[n11];
                zzfr2.zza(n10, object);
            }
            return;
        }
        for (n11 = 0; n11 < (n10 = this.count); ++n11) {
            int[] nArray = this.zzpa;
            n10 = nArray[n11] >>> 3;
            Object object = this.zzmj[n11];
            zzfr2.zza(n10, object);
        }
    }

    public final void zza(StringBuilder stringBuilder, int n10) {
        int n11;
        for (int i10 = 0; i10 < (n11 = this.count); ++i10) {
            n11 = this.zzpa[i10] >>> 3;
            String string2 = String.valueOf(n11);
            Object object = this.zzmj[i10];
            zzdr.zza(stringBuilder, n10, string2, object);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public final int zzas() {
        int n10 = this.zzjq;
        int n11 = -1;
        if (n10 != n11) {
            return n10;
        }
        n10 = 0;
        IllegalStateException illegalStateException = null;
        n11 = 0;
        zzcp zzcp2 = null;
        while (true) {
            int n12;
            block8: {
                long l10;
                int n13;
                Object object;
                block9: {
                    block10: {
                        if (n10 >= (n12 = this.count)) {
                            this.zzjq = n11;
                            return n11;
                        }
                        object = this.zzpa;
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
                                    zzcp2 = zzco.zzbn();
                                    illegalStateException = new IllegalStateException(zzcp2);
                                    throw illegalStateException;
                                }
                                object = (Integer)this.zzmj[n10];
                                n12 = (Integer)object;
                                n12 = zzbn.zzj(n13, n12);
                                break block8;
                            } else {
                                n12 = zzbn.zzr(n13) << n14;
                                zzey zzey2 = (zzey)this.zzmj[n10];
                                n13 = zzey2.zzas();
                                n12 += n13;
                            }
                            break block8;
                        } else {
                            object = (zzbb)this.zzmj[n10];
                            n12 = zzbn.zzc(n13, (zzbb)object);
                        }
                        break block8;
                    }
                    object = (Long)this.zzmj[n10];
                    l10 = (Long)object;
                    n12 = zzbn.zzg(n13, l10);
                    break block8;
                }
                object = (Long)this.zzmj[n10];
                l10 = (Long)object;
                n12 = zzbn.zze(n13, l10);
            }
            n11 += n12;
            ++n10;
        }
    }

    public final void zzb(int n10, Object object) {
        int n11 = this.zzfa;
        if (n11 != 0) {
            int[] nArray;
            n11 = this.count;
            Object[] objectArray = this.zzpa;
            int n12 = objectArray.length;
            if (n11 == n12) {
                n12 = 4;
                n12 = n11 < n12 ? 8 : n11 >> 1;
                this.zzpa = objectArray = Arrays.copyOf(objectArray, n11 += n12);
                objectArray = this.zzmj;
                nArray = Arrays.copyOf(objectArray, n11);
                this.zzmj = nArray;
            }
            nArray = this.zzpa;
            int n13 = this.count;
            nArray[n13] = n10;
            this.zzmj[n13] = object;
            this.count = ++n13;
            return;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public final void zzb(zzfr zzfr2) {
        int n10;
        int n11 = this.count;
        if (n11 == 0) {
            return;
        }
        n11 = zzfr2.zzaj();
        if (n11 == (n10 = zzcg$zzg.zzko)) {
            for (n11 = 0; n11 < (n10 = this.count); ++n11) {
                int[] nArray = this.zzpa;
                n10 = nArray[n11];
                Object object = this.zzmj[n11];
                zzey.zzb(n10, object, zzfr2);
            }
            return;
        }
        for (n11 = this.count + -1; n11 >= 0; n11 += -1) {
            int[] nArray = this.zzpa;
            n10 = nArray[n11];
            Object object = this.zzmj[n11];
            zzey.zzb(n10, object, zzfr2);
        }
    }

    public final int zzec() {
        int n10;
        int n11 = this.zzjq;
        int n12 = -1;
        if (n11 != n12) {
            return n11;
        }
        n12 = 0;
        for (n11 = 0; n11 < (n10 = this.count); ++n11) {
            int[] nArray = this.zzpa;
            n10 = nArray[n11] >>> 3;
            zzbb zzbb2 = (zzbb)this.zzmj[n11];
            n10 = zzbn.zzd(n10, zzbb2);
            n12 += n10;
        }
        this.zzjq = n12;
        return n12;
    }

    public final void zzv() {
        this.zzfa = false;
    }
}

