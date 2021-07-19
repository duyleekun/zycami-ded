/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgk;
import com.google.android.gms.internal.vision.zzgm;
import com.google.android.gms.internal.vision.zzgs;
import com.google.android.gms.internal.vision.zzho;
import com.google.android.gms.internal.vision.zzhq;
import com.google.android.gms.internal.vision.zzht;
import com.google.android.gms.internal.vision.zzhv;
import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.internal.vision.zzid$zze;
import com.google.android.gms.internal.vision.zzid$zzg;
import com.google.android.gms.internal.vision.zzin;
import com.google.android.gms.internal.vision.zziq;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzkb;
import com.google.android.gms.internal.vision.zzkc;
import com.google.android.gms.internal.vision.zzkf;
import com.google.android.gms.internal.vision.zzkh;
import com.google.android.gms.internal.vision.zzkw;
import com.google.android.gms.internal.vision.zzkx;
import com.google.android.gms.internal.vision.zzlq;
import com.google.android.gms.internal.vision.zzlr;
import java.util.Map;

public final class zzjt
implements zzkf {
    private final zzjn zzaao;
    private final boolean zzaap;
    private final zzkx zzaay;
    private final zzhq zzaaz;

    private zzjt(zzkx zzkx2, zzhq zzhq2, zzjn zzjn2) {
        boolean bl2;
        this.zzaay = zzkx2;
        this.zzaap = bl2 = zzhq2.zze(zzjn2);
        this.zzaaz = zzhq2;
        this.zzaao = zzjn2;
    }

    public static zzjt zza(zzkx zzkx2, zzhq zzhq2, zzjn zzjn2) {
        zzjt zzjt2 = new zzjt(zzkx2, zzhq2, zzjn2);
        return zzjt2;
    }

    public final boolean equals(Object object, Object object2) {
        Object object3;
        Object object4 = this.zzaay.zzy(object);
        boolean bl2 = object4.equals(object3 = this.zzaay.zzy(object2));
        if (!bl2) {
            return false;
        }
        bl2 = this.zzaap;
        if (bl2) {
            object = this.zzaaz.zzh(object);
            object2 = this.zzaaz.zzh(object2);
            return ((zzht)object).equals(object2);
        }
        return true;
    }

    public final int hashCode(Object object) {
        Object object2 = this.zzaay.zzy(object);
        int n10 = object2.hashCode();
        boolean bl2 = this.zzaap;
        if (bl2) {
            zzhq zzhq2 = this.zzaaz;
            object = zzhq2.zzh(object);
            n10 *= 53;
            int n11 = ((zzht)object).hashCode();
            n10 += n11;
        }
        return n10;
    }

    public final Object newInstance() {
        return this.zzaao.zzhd().zzgv();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zza(Object object, zzkc object2, zzho zzho2) {
        block19: {
            zzkx zzkx2 = this.zzaay;
            zzhq zzhq2 = this.zzaaz;
            Object object3 = zzkx2.zzz(object);
            zzht zzht2 = zzhq2.zzi(object);
            try {
                int n10;
                do {
                    block18: {
                        int n11;
                        Object object4;
                        int n12;
                        int n13;
                        if ((n10 = object2.zzeo()) == (n13 = -1 >>> 1)) {
                            zzkx2.zzg(object, object3);
                            return;
                        }
                        n10 = object2.getTag();
                        if (n10 != (n12 = 11)) {
                            n13 = n10 & 7;
                            n12 = 2;
                            if (n13 == n12) {
                                zzjn zzjn2 = this.zzaao;
                                object4 = zzhq2.zza(zzho2, zzjn2, n10 >>>= 3);
                                if (object4 != null) {
                                    zzhq2.zza((zzkc)object2, object4, zzho2, zzht2);
                                    break block18;
                                } else {
                                    n10 = (int)(zzkx2.zza(object3, (zzkc)object2) ? 1 : 0);
                                    continue;
                                }
                            }
                            n10 = (int)(object2.zzep() ? 1 : 0);
                            continue;
                        }
                        n10 = 0;
                        object4 = null;
                        n12 = 0;
                        Object object5 = null;
                        zzgs zzgs2 = null;
                        while ((n11 = object2.zzeo()) != n13) {
                            int n14;
                            n11 = object2.getTag();
                            if (n11 == (n14 = 16)) {
                                n10 = object2.zzey();
                                object5 = this.zzaao;
                                object5 = zzhq2.zza(zzho2, (zzjn)object5, n10);
                                continue;
                            }
                            n14 = 26;
                            if (n11 == n14) {
                                if (object5 != null) {
                                    zzhq2.zza((zzkc)object2, object5, zzho2, zzht2);
                                    continue;
                                }
                                zzgs2 = object2.zzex();
                                continue;
                            }
                            n11 = (int)(object2.zzep() ? 1 : 0);
                            if (n11 != 0) continue;
                        }
                        if ((n13 = object2.getTag()) != (n11 = 12)) break block19;
                        if (zzgs2 != null) {
                            if (object5 != null) {
                                zzhq2.zza(zzgs2, object5, zzho2, zzht2);
                            } else {
                                zzkx2.zza(object3, n10, zzgs2);
                            }
                        }
                    }
                    n10 = 1;
                } while (n10 != 0);
                zzkx2.zzg(object, object3);
                return;
            }
            catch (Throwable throwable) {
                zzkx2.zzg(object, object3);
                throw throwable;
            }
        }
        object2 = zzin.zzhl();
        throw object2;
    }

    public final void zza(Object object, zzlq zzlq2) {
        boolean bl2;
        Object object2 = this.zzaaz.zzh(object).iterator();
        while (bl2 = object2.hasNext()) {
            boolean bl3;
            zzlr zzlr2;
            Object object3 = (Map.Entry)object2.next();
            zzhv zzhv2 = (zzhv)object3.getKey();
            zzlr zzlr3 = zzhv2.zzgn();
            if (zzlr3 == (zzlr2 = zzlr.zzaei) && !(bl3 = zzhv2.zzgo()) && !(bl3 = zzhv2.zzgp())) {
                int n10;
                bl3 = object3 instanceof zziq;
                if (bl3) {
                    n10 = zzhv2.zzak();
                    object3 = ((zziq)object3).zzhr().zzee();
                    zzlq2.zza(n10, object3);
                    continue;
                }
                n10 = zzhv2.zzak();
                object3 = object3.getValue();
                zzlq2.zza(n10, object3);
                continue;
            }
            object = new IllegalStateException("Found invalid MessageSet item.");
            throw object;
        }
        object2 = this.zzaay;
        object = ((zzkx)object2).zzy(object);
        ((zzkx)object2).zzc(object, zzlq2);
    }

    public final void zza(Object object, byte[] byArray, int n10, int n11, zzgm zzgm2) {
        Object object2 = object;
        object2 = (zzid)object;
        zzkw zzkw2 = ((zzid)object2).zzxz;
        Object object3 = zzkw.zzja();
        if (zzkw2 == object3) {
            ((zzid)object2).zzxz = zzkw2 = zzkw.zzjb();
        }
        object = ((zzid$zze)object).zzhe();
        object2 = null;
        object3 = null;
        while (n10 < n11) {
            Object object4;
            Object object5;
            Object object6;
            int n12;
            Object object7;
            int n13 = zzgk.zza(byArray, n10, zzgm2);
            n10 = zzgm2.zztk;
            int n14 = 11;
            int n15 = 2;
            if (n10 != n14) {
                n14 = n10 & 7;
                if (n14 == n15) {
                    object3 = this.zzaaz;
                    object7 = zzgm2.zzcu;
                    zzjn zzjn2 = this.zzaao;
                    n12 = n10 >>> 3;
                    object3 = ((zzhq)object3).zza((zzho)object7, zzjn2, n12);
                    Object object8 = object3;
                    object8 = (zzid$zzg)object3;
                    if (object8 != null) {
                        object6 = zzkb.zzik();
                        object3 = ((zzid$zzg)object8).zzyq.getClass();
                        object6 = ((zzkb)object6).zzf((Class)object3);
                        n10 = zzgk.zza((zzkf)object6, byArray, n13, n11, zzgm2);
                        object3 = ((zzid$zzg)object8).zzyr;
                        object7 = zzgm2.zztm;
                        ((zzht)object).zza((zzhv)object3, object7);
                    } else {
                        object7 = byArray;
                        n15 = n11;
                        object5 = zzkw2;
                        object4 = zzgm2;
                        n10 = zzgk.zza(n10, byArray, n13, n11, zzkw2, zzgm2);
                    }
                    object3 = object8;
                    continue;
                }
                n10 = zzgk.zza(n10, byArray, n13, n11, zzgm2);
                continue;
            }
            n10 = 0;
            object6 = null;
            n14 = 0;
            object7 = null;
            while (n13 < n11) {
                n13 = zzgk.zza(byArray, n13, zzgm2);
                n12 = zzgm2.zztk;
                int n16 = n12 >>> 3;
                int n17 = n12 & 7;
                if (n16 != n15) {
                    int n18 = 3;
                    if (n16 == n18) {
                        if (object3 != null) {
                            object5 = zzkb.zzik();
                            object4 = ((zzid$zzg)object3).zzyq.getClass();
                            n13 = zzgk.zza(((zzkb)object5).zzf((Class)object4), byArray, n13, n11, zzgm2);
                            object5 = ((zzid$zzg)object3).zzyr;
                            object4 = zzgm2.zztm;
                            ((zzht)object).zza((zzhv)object5, object4);
                            continue;
                        }
                        if (n17 == n15) {
                            n13 = zzgk.zze(byArray, n13, zzgm2);
                            object7 = (zzgs)zzgm2.zztm;
                            continue;
                        }
                    }
                } else if (n17 == 0) {
                    n13 = zzgk.zza(byArray, n13, zzgm2);
                    n10 = zzgm2.zztk;
                    object3 = this.zzaaz;
                    object5 = zzgm2.zzcu;
                    object4 = this.zzaao;
                    object3 = (zzid$zzg)((zzhq)object3).zza((zzho)object5, (zzjn)object4, n10);
                    continue;
                }
                if (n12 == (n16 = 12)) break;
                n13 = zzgk.zza(n12, byArray, n13, n11, zzgm2);
            }
            if (object7 != null) {
                n10 = n10 << 3 | n15;
                zzkw2.zzb(n10, object7);
            }
            n10 = n13;
        }
        if (n10 == n11) {
            return;
        }
        throw zzin.zzhn();
    }

    public final void zzd(Object object, Object object2) {
        Object object3 = this.zzaay;
        zzkh.zza((zzkx)object3, object, object2);
        boolean bl2 = this.zzaap;
        if (bl2) {
            object3 = this.zzaaz;
            zzkh.zza((zzhq)object3, object, object2);
        }
    }

    public final void zzj(Object object) {
        this.zzaay.zzj(object);
        this.zzaaz.zzj(object);
    }

    public final int zzu(Object object) {
        zzkx zzkx2 = this.zzaay;
        Object object2 = zzkx2.zzy(object);
        int n10 = zzkx2.zzaa(object2) + 0;
        boolean bl2 = this.zzaap;
        if (bl2) {
            object2 = this.zzaaz;
            object = ((zzhq)object2).zzh(object);
            int n11 = ((zzht)object).zzgi();
            n10 += n11;
        }
        return n10;
    }

    public final boolean zzw(Object object) {
        return this.zzaaz.zzh(object).isInitialized();
    }
}

