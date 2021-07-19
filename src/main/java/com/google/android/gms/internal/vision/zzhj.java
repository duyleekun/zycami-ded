/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgq;
import com.google.android.gms.internal.vision.zzgs;
import com.google.android.gms.internal.vision.zzhe;
import com.google.android.gms.internal.vision.zzhi;
import com.google.android.gms.internal.vision.zzhm;
import com.google.android.gms.internal.vision.zzho;
import com.google.android.gms.internal.vision.zzhz;
import com.google.android.gms.internal.vision.zzie;
import com.google.android.gms.internal.vision.zzif;
import com.google.android.gms.internal.vision.zzim;
import com.google.android.gms.internal.vision.zzin;
import com.google.android.gms.internal.vision.zziu;
import com.google.android.gms.internal.vision.zzjb;
import com.google.android.gms.internal.vision.zzje;
import com.google.android.gms.internal.vision.zzkb;
import com.google.android.gms.internal.vision.zzkc;
import com.google.android.gms.internal.vision.zzkf;
import com.google.android.gms.internal.vision.zzlk;
import java.util.List;
import java.util.Map;

public final class zzhj
implements zzkc {
    private int tag;
    private int zzts;
    private final zzhe zzul;
    private int zzum = 0;

    private zzhj(zzhe zzhe2) {
        this.zzul = zzhe2 = (zzhe)zzie.zza(zzhe2, "input");
        zzhe2.zzue = this;
    }

    public static zzhj zza(zzhe zzhe2) {
        zzhj zzhj2 = zzhe2.zzue;
        if (zzhj2 != null) {
            return zzhj2;
        }
        zzhj2 = new zzhj(zzhe2);
        return zzhj2;
    }

    private final Object zza(zzlk object, Class clazz, zzho zzho2) {
        int[] nArray = zzhi.zztn;
        int n10 = object.ordinal();
        n10 = nArray[n10];
        switch (n10) {
            default: {
                object = new RuntimeException("unsupported field type.");
                throw object;
            }
            case 17: {
                return this.zzeq();
            }
            case 16: {
                return this.zzey();
            }
            case 15: {
                return this.zzew();
            }
            case 14: {
                return this.zzfd();
            }
            case 13: {
                return this.zzfc();
            }
            case 12: {
                return this.zzfb();
            }
            case 11: {
                return this.zzfa();
            }
            case 10: {
                return this.zza(clazz, zzho2);
            }
            case 9: {
                return this.zzer();
            }
            case 8: {
                return this.zzes();
            }
            case 7: {
                return Float.valueOf(this.readFloat());
            }
            case 6: {
                return this.zzet();
            }
            case 5: {
                return this.zzeu();
            }
            case 4: {
                return this.zzez();
            }
            case 3: {
                return this.readDouble();
            }
            case 2: {
                return this.zzex();
            }
            case 1: 
        }
        return this.zzev();
    }

    private final void zza(List object, boolean n10) {
        int n11 = this.tag & 7;
        int n12 = 2;
        if (n11 == n12) {
            Object object2;
            n11 = object instanceof zziu;
            if (n11 != 0 && n10 == 0) {
                int n13;
                Object list = object;
                list = (zziu)object;
                do {
                    object = this.zzex();
                    list.zzc((zzgs)object);
                    object = this.zzul;
                    n13 = ((zzhe)object).zzen();
                    if (n13 == 0) continue;
                    return;
                } while ((n13 = ((zzhe)(object = this.zzul)).zzfr()) == (n10 = this.tag));
                this.zzum = n13;
                return;
            }
            do {
                object2 = n10 != 0 ? this.zzew() : this.readString();
                ((List)object).add(object2);
                object2 = this.zzul;
                n11 = (int)(((zzhe)object2).zzen() ? 1 : 0);
                if (n11 == 0) continue;
                return;
            } while ((n11 = ((zzhe)(object2 = this.zzul)).zzfr()) == (n12 = this.tag));
            this.zzum = n11;
            return;
        }
        throw zzin.zzhm();
    }

    private final void zzaq(int n10) {
        int n11 = this.tag & 7;
        if (n11 == n10) {
            return;
        }
        throw zzin.zzhm();
    }

    private static void zzar(int n10) {
        if ((n10 &= 7) == 0) {
            return;
        }
        throw zzin.zzhn();
    }

    private static void zzas(int n10) {
        if ((n10 &= 3) == 0) {
            return;
        }
        throw zzin.zzhn();
    }

    private final void zzat(int n10) {
        zzhe zzhe2 = this.zzul;
        int n11 = zzhe2.zzft();
        if (n11 == n10) {
            return;
        }
        throw zzin.zzhh();
    }

    private final Object zzb(zzkf object, zzho zzho2) {
        zzhe zzhe2 = this.zzul;
        int n10 = zzhe2.zzey();
        Object object2 = this.zzul;
        int n11 = ((zzhe)object2).zzub;
        int n12 = ((zzhe)object2).zzuc;
        if (n11 < n12) {
            int n13;
            n10 = ((zzhe)object2).zzaz(n10);
            object2 = object.newInstance();
            zzhe zzhe3 = this.zzul;
            zzhe3.zzub = n12 = zzhe3.zzub + 1;
            object.zza(object2, this, zzho2);
            object.zzj(object2);
            this.zzul.zzax(0);
            object = this.zzul;
            ((zzhe)object).zzub = n13 = ((zzhe)object).zzub + -1;
            ((zzhe)object).zzba(n10);
            return object2;
        }
        object = new zzin("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        throw object;
    }

    private final Object zzd(zzkf object, zzho zzho2) {
        block7: {
            Object object2;
            int n10;
            int n11 = this.zzts;
            this.zzts = n10 = this.tag >>> 3 << 3 | 4;
            try {
                object2 = object.newInstance();
            }
            catch (Throwable throwable) {
                this.zzts = n11;
                throw throwable;
            }
            object.zza(object2, this, zzho2);
            object.zzj(object2);
            int n12 = this.tag;
            int n13 = this.zzts;
            if (n12 != n13) break block7;
            this.zzts = n11;
            return object2;
        }
        object = zzin.zzhn();
        throw object;
    }

    public final int getTag() {
        return this.tag;
    }

    public final double readDouble() {
        this.zzaq(1);
        return this.zzul.readDouble();
    }

    public final float readFloat() {
        this.zzaq(5);
        return this.zzul.readFloat();
    }

    public final String readString() {
        this.zzaq(2);
        return this.zzul.readString();
    }

    public final void readStringList(List list) {
        this.zza(list, false);
    }

    public final Object zza(zzkf zzkf2, zzho zzho2) {
        this.zzaq(2);
        return this.zzb(zzkf2, zzho2);
    }

    public final Object zza(Class object, zzho zzho2) {
        this.zzaq(2);
        object = zzkb.zzik().zzf((Class)object);
        return this.zzb((zzkf)object, zzho2);
    }

    public final void zza(List object) {
        Object object2;
        int n10 = object instanceof zzhm;
        int n11 = 2;
        int n12 = 1;
        if (n10 != 0) {
            List list = object;
            list = (zzhm)object;
            int n13 = this.tag & 7;
            if (n13 != n12) {
                if (n13 == n11) {
                    object = this.zzul;
                    n13 = ((zzhe)object).zzey();
                    zzhj.zzar(n13);
                    zzhe zzhe2 = this.zzul;
                    n11 = zzhe2.zzft() + n13;
                    do {
                        double d10 = this.zzul.readDouble();
                        ((zzhm)list).zzc(d10);
                    } while ((n13 = ((zzhe)(object = this.zzul)).zzft()) < n11);
                    return;
                }
                throw zzin.zzhm();
            }
            do {
                double d11 = this.zzul.readDouble();
                ((zzhm)list).zzc(d11);
                object = this.zzul;
                n13 = (int)(((zzhe)object).zzen() ? 1 : 0);
                if (n13 == 0) continue;
                return;
            } while ((n13 = ((zzhe)(object = this.zzul)).zzfr()) == (n11 = this.tag));
            this.zzum = n13;
            return;
        }
        n10 = this.tag & 7;
        if (n10 != n12) {
            if (n10 == n11) {
                Object object3 = this.zzul;
                n10 = ((zzhe)object3).zzey();
                zzhj.zzar(n10);
                zzhe zzhe3 = this.zzul;
                n11 = zzhe3.zzft() + n10;
                do {
                    double d12 = this.zzul.readDouble();
                    object3 = d12;
                    object.add(object3);
                } while ((n10 = ((zzhe)(object3 = this.zzul)).zzft()) < n11);
                return;
            }
            throw zzin.zzhm();
        }
        do {
            double d13 = this.zzul.readDouble();
            object2 = d13;
            object.add(object2);
            object2 = this.zzul;
            n10 = (int)(((zzhe)object2).zzen() ? 1 : 0);
            if (n10 == 0) continue;
            return;
        } while ((n10 = ((zzhe)(object2 = this.zzul)).zzfr()) == (n11 = this.tag));
        this.zzum = n10;
    }

    public final void zza(List list, zzkf zzkf2, zzho zzho2) {
        int n10 = this.tag;
        int n11 = n10 & 7;
        int n12 = 2;
        if (n11 == n12) {
            block2: {
                Object object;
                do {
                    object = this.zzb(zzkf2, zzho2);
                    list.add(object);
                    object = this.zzul;
                    n11 = (int)(((zzhe)object).zzen() ? 1 : 0);
                    if (n11 != 0 || (n11 = this.zzum) != 0) break block2;
                } while ((n11 = ((zzhe)(object = this.zzul)).zzfr()) == n10);
                this.zzum = n11;
            }
            return;
        }
        throw zzin.zzhm();
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final void zza(Map var1_1, zzje var2_3, zzho var3_4) {
        var4_5 = 2;
        this.zzaq(var4_5);
        var5_6 = this.zzul;
        var6_7 = var5_6.zzey();
        var6_7 = this.zzul.zzaz(var6_7);
        var7_8 = var2_3.zzaad;
        var8_9 = var2_3.zzgk;
        while (true) lbl-1000:
        // 5 sources

        {
            block19: {
                var9_10 = this.zzeo();
                var10_11 = -1 >>> 1;
                if (var9_10 == var10_11) break;
                var11_12 = this.zzul;
                var10_11 = (int)var11_12.zzen();
                if (var10_11 != 0) break;
                var10_11 = 1;
                var12_13 = "Unable to parse map entry.";
                if (var9_10 == var10_11) break block19;
                if (var9_10 == var4_5) ** GOTO lbl28
                var9_10 = (int)this.zzep();
                if (var9_10 != 0) continue;
                var13_14 /* !! */  = new zzin(var12_13);
                throw var13_14 /* !! */ ;
lbl28:
                // 1 sources

                var13_14 /* !! */  = var2_3.zzaae;
                var11_12 = var2_3.zzgk;
                var11_12 = var11_12.getClass();
                var8_9 = this.zza(var13_14 /* !! */ , var11_12, var3_4);
            }
            var13_14 /* !! */  = var2_3.zzaac;
            var10_11 = 0;
            var11_12 = null;
            try {
                var7_8 = this.zza(var13_14 /* !! */ , null, null);
                continue;
            }
            catch (zzim v0) {
                var9_10 = (int)this.zzep();
                if (var9_10 == 0) ** break;
                continue;
                var1_1 = new zzin(var12_13);
                throw var1_1;
            }
            break;
        }
        var1_1.put(var7_8, var8_9);
        return;
        {
            catch (Throwable var1_2) {
                throw var1_2;
            }
        }
        ** GOTO lbl-1000
        finally {
            this.zzul.zzba(var6_7);
        }
    }

    public final Object zzb(Class object, zzho zzho2) {
        this.zzaq(3);
        object = zzkb.zzik().zzf((Class)object);
        return this.zzd((zzkf)object, zzho2);
    }

    public final void zzb(List object) {
        int n10 = object instanceof zzhz;
        int n11 = 5;
        int n12 = 2;
        if (n10 != 0) {
            List list = object;
            list = (zzhz)object;
            int n13 = this.tag & 7;
            if (n13 != n12) {
                if (n13 == n11) {
                    do {
                        float f10 = this.zzul.readFloat();
                        ((zzhz)list).zzu(f10);
                        object = this.zzul;
                        n13 = (int)(((zzhe)object).zzen() ? 1 : 0);
                        if (n13 == 0) continue;
                        return;
                    } while ((n13 = ((zzhe)(object = this.zzul)).zzfr()) == (n11 = this.tag));
                    this.zzum = n13;
                    return;
                }
                throw zzin.zzhm();
            }
            object = this.zzul;
            n13 = ((zzhe)object).zzey();
            zzhj.zzas(n13);
            zzhe zzhe2 = this.zzul;
            n11 = zzhe2.zzft();
            int n14 = n11 + n13;
            do {
                float f11 = this.zzul.readFloat();
                ((zzhz)list).zzu(f11);
            } while ((n13 = ((zzhe)(object = this.zzul)).zzft()) < n14);
            return;
        }
        n10 = this.tag & 7;
        if (n10 != n12) {
            if (n10 == n11) {
                Object object2;
                do {
                    float f12 = this.zzul.readFloat();
                    object2 = Float.valueOf(f12);
                    object.add(object2);
                    object2 = this.zzul;
                    n10 = (int)(((zzhe)object2).zzen() ? 1 : 0);
                    if (n10 == 0) continue;
                    return;
                } while ((n10 = ((zzhe)(object2 = this.zzul)).zzfr()) == (n11 = this.tag));
                this.zzum = n10;
                return;
            }
            throw zzin.zzhm();
        }
        Object object3 = this.zzul;
        n10 = ((zzhe)object3).zzey();
        zzhj.zzas(n10);
        zzhe zzhe3 = this.zzul;
        n11 = zzhe3.zzft() + n10;
        do {
            float f13 = this.zzul.readFloat();
            object3 = Float.valueOf(f13);
            object.add(object3);
        } while ((n10 = ((zzhe)(object3 = this.zzul)).zzft()) < n11);
    }

    public final void zzb(List list, zzkf zzkf2, zzho zzho2) {
        int n10 = this.tag;
        int n11 = n10 & 7;
        int n12 = 3;
        if (n11 == n12) {
            block2: {
                Object object;
                do {
                    object = this.zzd(zzkf2, zzho2);
                    list.add(object);
                    object = this.zzul;
                    n11 = (int)(((zzhe)object).zzen() ? 1 : 0);
                    if (n11 != 0 || (n11 = this.zzum) != 0) break block2;
                } while ((n11 = ((zzhe)(object = this.zzul)).zzfr()) == n10);
                this.zzum = n11;
            }
            return;
        }
        throw zzin.zzhm();
    }

    public final Object zzc(zzkf zzkf2, zzho zzho2) {
        this.zzaq(3);
        return this.zzd(zzkf2, zzho2);
    }

    public final void zzc(List object) {
        Object object2;
        int n10 = object instanceof zzjb;
        int n11 = 2;
        if (n10 != 0) {
            List list = object;
            list = (zzjb)object;
            int n12 = this.tag & 7;
            if (n12 != 0) {
                if (n12 == n11) {
                    object = this.zzul;
                    n12 = ((zzhe)object).zzey();
                    zzhe zzhe2 = this.zzul;
                    n11 = zzhe2.zzft() + n12;
                    do {
                        long l10 = this.zzul.zzeq();
                        ((zzjb)list).zzac(l10);
                    } while ((n12 = ((zzhe)(object = this.zzul)).zzft()) < n11);
                    this.zzat(n11);
                    return;
                }
                throw zzin.zzhm();
            }
            do {
                long l11 = this.zzul.zzeq();
                ((zzjb)list).zzac(l11);
                object = this.zzul;
                n12 = (int)(((zzhe)object).zzen() ? 1 : 0);
                if (n12 == 0) continue;
                return;
            } while ((n12 = ((zzhe)(object = this.zzul)).zzfr()) == (n11 = this.tag));
            this.zzum = n12;
            return;
        }
        n10 = this.tag & 7;
        if (n10 != 0) {
            if (n10 == n11) {
                Object object3 = this.zzul;
                n10 = ((zzhe)object3).zzey();
                zzhe zzhe3 = this.zzul;
                n11 = zzhe3.zzft() + n10;
                do {
                    long l12 = this.zzul.zzeq();
                    object3 = l12;
                    object.add(object3);
                } while ((n10 = ((zzhe)(object3 = this.zzul)).zzft()) < n11);
                this.zzat(n11);
                return;
            }
            throw zzin.zzhm();
        }
        do {
            long l13 = this.zzul.zzeq();
            object2 = l13;
            object.add(object2);
            object2 = this.zzul;
            n10 = (int)(((zzhe)object2).zzen() ? 1 : 0);
            if (n10 == 0) continue;
            return;
        } while ((n10 = ((zzhe)(object2 = this.zzul)).zzfr()) == (n11 = this.tag));
        this.zzum = n10;
    }

    public final void zzd(List object) {
        Object object2;
        int n10 = object instanceof zzjb;
        int n11 = 2;
        if (n10 != 0) {
            List list = object;
            list = (zzjb)object;
            int n12 = this.tag & 7;
            if (n12 != 0) {
                if (n12 == n11) {
                    object = this.zzul;
                    n12 = ((zzhe)object).zzey();
                    zzhe zzhe2 = this.zzul;
                    n11 = zzhe2.zzft() + n12;
                    do {
                        long l10 = this.zzul.zzer();
                        ((zzjb)list).zzac(l10);
                    } while ((n12 = ((zzhe)(object = this.zzul)).zzft()) < n11);
                    this.zzat(n11);
                    return;
                }
                throw zzin.zzhm();
            }
            do {
                long l11 = this.zzul.zzer();
                ((zzjb)list).zzac(l11);
                object = this.zzul;
                n12 = (int)(((zzhe)object).zzen() ? 1 : 0);
                if (n12 == 0) continue;
                return;
            } while ((n12 = ((zzhe)(object = this.zzul)).zzfr()) == (n11 = this.tag));
            this.zzum = n12;
            return;
        }
        n10 = this.tag & 7;
        if (n10 != 0) {
            if (n10 == n11) {
                Object object3 = this.zzul;
                n10 = ((zzhe)object3).zzey();
                zzhe zzhe3 = this.zzul;
                n11 = zzhe3.zzft() + n10;
                do {
                    long l12 = this.zzul.zzer();
                    object3 = l12;
                    object.add(object3);
                } while ((n10 = ((zzhe)(object3 = this.zzul)).zzft()) < n11);
                this.zzat(n11);
                return;
            }
            throw zzin.zzhm();
        }
        do {
            long l13 = this.zzul.zzer();
            object2 = l13;
            object.add(object2);
            object2 = this.zzul;
            n10 = (int)(((zzhe)object2).zzen() ? 1 : 0);
            if (n10 == 0) continue;
            return;
        } while ((n10 = ((zzhe)(object2 = this.zzul)).zzfr()) == (n11 = this.tag));
        this.zzum = n10;
    }

    public final void zze(List object) {
        Object object2;
        int n10 = object instanceof zzif;
        int n11 = 2;
        if (n10 != 0) {
            List list = object;
            list = (zzif)object;
            int n12 = this.tag & 7;
            if (n12 != 0) {
                if (n12 == n11) {
                    object = this.zzul;
                    n12 = ((zzhe)object).zzey();
                    zzhe zzhe2 = this.zzul;
                    n11 = zzhe2.zzft() + n12;
                    do {
                        n12 = this.zzul.zzes();
                        ((zzif)list).zzbs(n12);
                    } while ((n12 = ((zzhe)(object = this.zzul)).zzft()) < n11);
                    this.zzat(n11);
                    return;
                }
                throw zzin.zzhm();
            }
            do {
                n12 = this.zzul.zzes();
                ((zzif)list).zzbs(n12);
                object = this.zzul;
                n12 = (int)(((zzhe)object).zzen() ? 1 : 0);
                if (n12 == 0) continue;
                return;
            } while ((n12 = ((zzhe)(object = this.zzul)).zzfr()) == (n11 = this.tag));
            this.zzum = n12;
            return;
        }
        n10 = this.tag & 7;
        if (n10 != 0) {
            if (n10 == n11) {
                Object object3 = this.zzul;
                n10 = ((zzhe)object3).zzey();
                zzhe zzhe3 = this.zzul;
                n11 = zzhe3.zzft() + n10;
                do {
                    object3 = this.zzul.zzes();
                    object.add(object3);
                } while ((n10 = ((zzhe)(object3 = this.zzul)).zzft()) < n11);
                this.zzat(n11);
                return;
            }
            throw zzin.zzhm();
        }
        do {
            object2 = this.zzul.zzes();
            object.add(object2);
            object2 = this.zzul;
            n10 = (int)(((zzhe)object2).zzen() ? 1 : 0);
            if (n10 == 0) continue;
            return;
        } while ((n10 = ((zzhe)(object2 = this.zzul)).zzfr()) == (n11 = this.tag));
        this.zzum = n10;
    }

    public final int zzeo() {
        int n10;
        int n11 = this.zzum;
        if (n11 != 0) {
            this.tag = n11;
            n11 = 0;
            Object var2_2 = null;
            this.zzum = 0;
        } else {
            zzhe zzhe2 = this.zzul;
            this.tag = n11 = zzhe2.zzfr();
        }
        n11 = this.tag;
        if (n11 != 0 && n11 != (n10 = this.zzts)) {
            return n11 >>> 3;
        }
        return -1 >>> 1;
    }

    public final boolean zzep() {
        int n10;
        zzhe zzhe2 = this.zzul;
        int n11 = zzhe2.zzen();
        if (n11 == 0 && (n11 = this.tag) != (n10 = this.zzts)) {
            return this.zzul.zzay(n11);
        }
        return false;
    }

    public final long zzeq() {
        this.zzaq(0);
        return this.zzul.zzeq();
    }

    public final long zzer() {
        this.zzaq(0);
        return this.zzul.zzer();
    }

    public final int zzes() {
        this.zzaq(0);
        return this.zzul.zzes();
    }

    public final long zzet() {
        this.zzaq(1);
        return this.zzul.zzet();
    }

    public final int zzeu() {
        this.zzaq(5);
        return this.zzul.zzeu();
    }

    public final boolean zzev() {
        this.zzaq(0);
        return this.zzul.zzev();
    }

    public final String zzew() {
        this.zzaq(2);
        return this.zzul.zzew();
    }

    public final zzgs zzex() {
        this.zzaq(2);
        return this.zzul.zzex();
    }

    public final int zzey() {
        this.zzaq(0);
        return this.zzul.zzey();
    }

    public final int zzez() {
        this.zzaq(0);
        return this.zzul.zzez();
    }

    public final void zzf(List object) {
        Object object2;
        int n10 = object instanceof zzjb;
        int n11 = 2;
        int n12 = 1;
        if (n10 != 0) {
            List list = object;
            list = (zzjb)object;
            int n13 = this.tag & 7;
            if (n13 != n12) {
                if (n13 == n11) {
                    object = this.zzul;
                    n13 = ((zzhe)object).zzey();
                    zzhj.zzar(n13);
                    zzhe zzhe2 = this.zzul;
                    n11 = zzhe2.zzft() + n13;
                    do {
                        long l10 = this.zzul.zzet();
                        ((zzjb)list).zzac(l10);
                    } while ((n13 = ((zzhe)(object = this.zzul)).zzft()) < n11);
                    return;
                }
                throw zzin.zzhm();
            }
            do {
                long l11 = this.zzul.zzet();
                ((zzjb)list).zzac(l11);
                object = this.zzul;
                n13 = (int)(((zzhe)object).zzen() ? 1 : 0);
                if (n13 == 0) continue;
                return;
            } while ((n13 = ((zzhe)(object = this.zzul)).zzfr()) == (n11 = this.tag));
            this.zzum = n13;
            return;
        }
        n10 = this.tag & 7;
        if (n10 != n12) {
            if (n10 == n11) {
                Object object3 = this.zzul;
                n10 = ((zzhe)object3).zzey();
                zzhj.zzar(n10);
                zzhe zzhe3 = this.zzul;
                n11 = zzhe3.zzft() + n10;
                do {
                    long l12 = this.zzul.zzet();
                    object3 = l12;
                    object.add(object3);
                } while ((n10 = ((zzhe)(object3 = this.zzul)).zzft()) < n11);
                return;
            }
            throw zzin.zzhm();
        }
        do {
            long l13 = this.zzul.zzet();
            object2 = l13;
            object.add(object2);
            object2 = this.zzul;
            n10 = (int)(((zzhe)object2).zzen() ? 1 : 0);
            if (n10 == 0) continue;
            return;
        } while ((n10 = ((zzhe)(object2 = this.zzul)).zzfr()) == (n11 = this.tag));
        this.zzum = n10;
    }

    public final int zzfa() {
        this.zzaq(5);
        return this.zzul.zzfa();
    }

    public final long zzfb() {
        this.zzaq(1);
        return this.zzul.zzfb();
    }

    public final int zzfc() {
        this.zzaq(0);
        return this.zzul.zzfc();
    }

    public final long zzfd() {
        this.zzaq(0);
        return this.zzul.zzfd();
    }

    public final void zzg(List object) {
        int n10 = object instanceof zzif;
        int n11 = 5;
        int n12 = 2;
        if (n10 != 0) {
            List list = object;
            list = (zzif)object;
            int n13 = this.tag & 7;
            if (n13 != n12) {
                if (n13 == n11) {
                    do {
                        n13 = this.zzul.zzeu();
                        ((zzif)list).zzbs(n13);
                        object = this.zzul;
                        n13 = (int)(((zzhe)object).zzen() ? 1 : 0);
                        if (n13 == 0) continue;
                        return;
                    } while ((n13 = ((zzhe)(object = this.zzul)).zzfr()) == (n11 = this.tag));
                    this.zzum = n13;
                    return;
                }
                throw zzin.zzhm();
            }
            object = this.zzul;
            n13 = ((zzhe)object).zzey();
            zzhj.zzas(n13);
            zzhe zzhe2 = this.zzul;
            n11 = zzhe2.zzft();
            int n14 = n11 + n13;
            do {
                n13 = this.zzul.zzeu();
                ((zzif)list).zzbs(n13);
            } while ((n13 = ((zzhe)(object = this.zzul)).zzft()) < n14);
            return;
        }
        n10 = this.tag & 7;
        if (n10 != n12) {
            if (n10 == n11) {
                Object object2;
                do {
                    object2 = this.zzul.zzeu();
                    object.add(object2);
                    object2 = this.zzul;
                    n10 = (int)(((zzhe)object2).zzen() ? 1 : 0);
                    if (n10 == 0) continue;
                    return;
                } while ((n10 = ((zzhe)(object2 = this.zzul)).zzfr()) == (n11 = this.tag));
                this.zzum = n10;
                return;
            }
            throw zzin.zzhm();
        }
        Object object3 = this.zzul;
        n10 = ((zzhe)object3).zzey();
        zzhj.zzas(n10);
        zzhe zzhe3 = this.zzul;
        n11 = zzhe3.zzft() + n10;
        do {
            object3 = this.zzul.zzeu();
            object.add(object3);
        } while ((n10 = ((zzhe)(object3 = this.zzul)).zzft()) < n11);
    }

    public final void zzh(List object) {
        Object object2;
        int n10 = object instanceof zzgq;
        int n11 = 2;
        if (n10 != 0) {
            List list = object;
            list = (zzgq)object;
            int n12 = this.tag & 7;
            if (n12 != 0) {
                if (n12 == n11) {
                    object = this.zzul;
                    n12 = ((zzhe)object).zzey();
                    zzhe zzhe2 = this.zzul;
                    n11 = zzhe2.zzft() + n12;
                    do {
                        n12 = (int)(this.zzul.zzev() ? 1 : 0);
                        ((zzgq)list).addBoolean(n12 != 0);
                    } while ((n12 = ((zzhe)(object = this.zzul)).zzft()) < n11);
                    this.zzat(n11);
                    return;
                }
                throw zzin.zzhm();
            }
            do {
                n12 = (int)(this.zzul.zzev() ? 1 : 0);
                ((zzgq)list).addBoolean(n12 != 0);
                object = this.zzul;
                n12 = (int)(((zzhe)object).zzen() ? 1 : 0);
                if (n12 == 0) continue;
                return;
            } while ((n12 = ((zzhe)(object = this.zzul)).zzfr()) == (n11 = this.tag));
            this.zzum = n12;
            return;
        }
        n10 = this.tag & 7;
        if (n10 != 0) {
            if (n10 == n11) {
                Object object3 = this.zzul;
                n10 = ((zzhe)object3).zzey();
                zzhe zzhe3 = this.zzul;
                n11 = zzhe3.zzft() + n10;
                do {
                    object3 = this.zzul.zzev();
                    object.add(object3);
                } while ((n10 = ((zzhe)(object3 = this.zzul)).zzft()) < n11);
                this.zzat(n11);
                return;
            }
            throw zzin.zzhm();
        }
        do {
            object2 = this.zzul.zzev();
            object.add(object2);
            object2 = this.zzul;
            n10 = (int)(((zzhe)object2).zzen() ? 1 : 0);
            if (n10 == 0) continue;
            return;
        } while ((n10 = ((zzhe)(object2 = this.zzul)).zzfr()) == (n11 = this.tag));
        this.zzum = n10;
    }

    public final void zzi(List list) {
        this.zza(list, true);
    }

    public final void zzj(List list) {
        int n10 = this.tag & 7;
        int n11 = 2;
        if (n10 == n11) {
            Object object;
            do {
                object = this.zzex();
                list.add(object);
                object = this.zzul;
                n10 = (int)(((zzhe)object).zzen() ? 1 : 0);
                if (n10 == 0) continue;
                return;
            } while ((n10 = ((zzhe)(object = this.zzul)).zzfr()) == (n11 = this.tag));
            this.zzum = n10;
            return;
        }
        throw zzin.zzhm();
    }

    public final void zzk(List object) {
        Object object2;
        int n10 = object instanceof zzif;
        int n11 = 2;
        if (n10 != 0) {
            List list = object;
            list = (zzif)object;
            int n12 = this.tag & 7;
            if (n12 != 0) {
                if (n12 == n11) {
                    object = this.zzul;
                    n12 = ((zzhe)object).zzey();
                    zzhe zzhe2 = this.zzul;
                    n11 = zzhe2.zzft() + n12;
                    do {
                        n12 = this.zzul.zzey();
                        ((zzif)list).zzbs(n12);
                    } while ((n12 = ((zzhe)(object = this.zzul)).zzft()) < n11);
                    this.zzat(n11);
                    return;
                }
                throw zzin.zzhm();
            }
            do {
                n12 = this.zzul.zzey();
                ((zzif)list).zzbs(n12);
                object = this.zzul;
                n12 = (int)(((zzhe)object).zzen() ? 1 : 0);
                if (n12 == 0) continue;
                return;
            } while ((n12 = ((zzhe)(object = this.zzul)).zzfr()) == (n11 = this.tag));
            this.zzum = n12;
            return;
        }
        n10 = this.tag & 7;
        if (n10 != 0) {
            if (n10 == n11) {
                Object object3 = this.zzul;
                n10 = ((zzhe)object3).zzey();
                zzhe zzhe3 = this.zzul;
                n11 = zzhe3.zzft() + n10;
                do {
                    object3 = this.zzul.zzey();
                    object.add(object3);
                } while ((n10 = ((zzhe)(object3 = this.zzul)).zzft()) < n11);
                this.zzat(n11);
                return;
            }
            throw zzin.zzhm();
        }
        do {
            object2 = this.zzul.zzey();
            object.add(object2);
            object2 = this.zzul;
            n10 = (int)(((zzhe)object2).zzen() ? 1 : 0);
            if (n10 == 0) continue;
            return;
        } while ((n10 = ((zzhe)(object2 = this.zzul)).zzfr()) == (n11 = this.tag));
        this.zzum = n10;
    }

    public final void zzl(List object) {
        Object object2;
        int n10 = object instanceof zzif;
        int n11 = 2;
        if (n10 != 0) {
            List list = object;
            list = (zzif)object;
            int n12 = this.tag & 7;
            if (n12 != 0) {
                if (n12 == n11) {
                    object = this.zzul;
                    n12 = ((zzhe)object).zzey();
                    zzhe zzhe2 = this.zzul;
                    n11 = zzhe2.zzft() + n12;
                    do {
                        n12 = this.zzul.zzez();
                        ((zzif)list).zzbs(n12);
                    } while ((n12 = ((zzhe)(object = this.zzul)).zzft()) < n11);
                    this.zzat(n11);
                    return;
                }
                throw zzin.zzhm();
            }
            do {
                n12 = this.zzul.zzez();
                ((zzif)list).zzbs(n12);
                object = this.zzul;
                n12 = (int)(((zzhe)object).zzen() ? 1 : 0);
                if (n12 == 0) continue;
                return;
            } while ((n12 = ((zzhe)(object = this.zzul)).zzfr()) == (n11 = this.tag));
            this.zzum = n12;
            return;
        }
        n10 = this.tag & 7;
        if (n10 != 0) {
            if (n10 == n11) {
                Object object3 = this.zzul;
                n10 = ((zzhe)object3).zzey();
                zzhe zzhe3 = this.zzul;
                n11 = zzhe3.zzft() + n10;
                do {
                    object3 = this.zzul.zzez();
                    object.add(object3);
                } while ((n10 = ((zzhe)(object3 = this.zzul)).zzft()) < n11);
                this.zzat(n11);
                return;
            }
            throw zzin.zzhm();
        }
        do {
            object2 = this.zzul.zzez();
            object.add(object2);
            object2 = this.zzul;
            n10 = (int)(((zzhe)object2).zzen() ? 1 : 0);
            if (n10 == 0) continue;
            return;
        } while ((n10 = ((zzhe)(object2 = this.zzul)).zzfr()) == (n11 = this.tag));
        this.zzum = n10;
    }

    public final void zzm(List object) {
        int n10 = object instanceof zzif;
        int n11 = 5;
        int n12 = 2;
        if (n10 != 0) {
            List list = object;
            list = (zzif)object;
            int n13 = this.tag & 7;
            if (n13 != n12) {
                if (n13 == n11) {
                    do {
                        n13 = this.zzul.zzfa();
                        ((zzif)list).zzbs(n13);
                        object = this.zzul;
                        n13 = (int)(((zzhe)object).zzen() ? 1 : 0);
                        if (n13 == 0) continue;
                        return;
                    } while ((n13 = ((zzhe)(object = this.zzul)).zzfr()) == (n11 = this.tag));
                    this.zzum = n13;
                    return;
                }
                throw zzin.zzhm();
            }
            object = this.zzul;
            n13 = ((zzhe)object).zzey();
            zzhj.zzas(n13);
            zzhe zzhe2 = this.zzul;
            n11 = zzhe2.zzft();
            int n14 = n11 + n13;
            do {
                n13 = this.zzul.zzfa();
                ((zzif)list).zzbs(n13);
            } while ((n13 = ((zzhe)(object = this.zzul)).zzft()) < n14);
            return;
        }
        n10 = this.tag & 7;
        if (n10 != n12) {
            if (n10 == n11) {
                Object object2;
                do {
                    object2 = this.zzul.zzfa();
                    object.add(object2);
                    object2 = this.zzul;
                    n10 = (int)(((zzhe)object2).zzen() ? 1 : 0);
                    if (n10 == 0) continue;
                    return;
                } while ((n10 = ((zzhe)(object2 = this.zzul)).zzfr()) == (n11 = this.tag));
                this.zzum = n10;
                return;
            }
            throw zzin.zzhm();
        }
        Object object3 = this.zzul;
        n10 = ((zzhe)object3).zzey();
        zzhj.zzas(n10);
        zzhe zzhe3 = this.zzul;
        n11 = zzhe3.zzft() + n10;
        do {
            object3 = this.zzul.zzfa();
            object.add(object3);
        } while ((n10 = ((zzhe)(object3 = this.zzul)).zzft()) < n11);
    }

    public final void zzn(List object) {
        Object object2;
        int n10 = object instanceof zzjb;
        int n11 = 2;
        int n12 = 1;
        if (n10 != 0) {
            List list = object;
            list = (zzjb)object;
            int n13 = this.tag & 7;
            if (n13 != n12) {
                if (n13 == n11) {
                    object = this.zzul;
                    n13 = ((zzhe)object).zzey();
                    zzhj.zzar(n13);
                    zzhe zzhe2 = this.zzul;
                    n11 = zzhe2.zzft() + n13;
                    do {
                        long l10 = this.zzul.zzfb();
                        ((zzjb)list).zzac(l10);
                    } while ((n13 = ((zzhe)(object = this.zzul)).zzft()) < n11);
                    return;
                }
                throw zzin.zzhm();
            }
            do {
                long l11 = this.zzul.zzfb();
                ((zzjb)list).zzac(l11);
                object = this.zzul;
                n13 = (int)(((zzhe)object).zzen() ? 1 : 0);
                if (n13 == 0) continue;
                return;
            } while ((n13 = ((zzhe)(object = this.zzul)).zzfr()) == (n11 = this.tag));
            this.zzum = n13;
            return;
        }
        n10 = this.tag & 7;
        if (n10 != n12) {
            if (n10 == n11) {
                Object object3 = this.zzul;
                n10 = ((zzhe)object3).zzey();
                zzhj.zzar(n10);
                zzhe zzhe3 = this.zzul;
                n11 = zzhe3.zzft() + n10;
                do {
                    long l12 = this.zzul.zzfb();
                    object3 = l12;
                    object.add(object3);
                } while ((n10 = ((zzhe)(object3 = this.zzul)).zzft()) < n11);
                return;
            }
            throw zzin.zzhm();
        }
        do {
            long l13 = this.zzul.zzfb();
            object2 = l13;
            object.add(object2);
            object2 = this.zzul;
            n10 = (int)(((zzhe)object2).zzen() ? 1 : 0);
            if (n10 == 0) continue;
            return;
        } while ((n10 = ((zzhe)(object2 = this.zzul)).zzfr()) == (n11 = this.tag));
        this.zzum = n10;
    }

    public final void zzo(List object) {
        Object object2;
        int n10 = object instanceof zzif;
        int n11 = 2;
        if (n10 != 0) {
            List list = object;
            list = (zzif)object;
            int n12 = this.tag & 7;
            if (n12 != 0) {
                if (n12 == n11) {
                    object = this.zzul;
                    n12 = ((zzhe)object).zzey();
                    zzhe zzhe2 = this.zzul;
                    n11 = zzhe2.zzft() + n12;
                    do {
                        n12 = this.zzul.zzfc();
                        ((zzif)list).zzbs(n12);
                    } while ((n12 = ((zzhe)(object = this.zzul)).zzft()) < n11);
                    this.zzat(n11);
                    return;
                }
                throw zzin.zzhm();
            }
            do {
                n12 = this.zzul.zzfc();
                ((zzif)list).zzbs(n12);
                object = this.zzul;
                n12 = (int)(((zzhe)object).zzen() ? 1 : 0);
                if (n12 == 0) continue;
                return;
            } while ((n12 = ((zzhe)(object = this.zzul)).zzfr()) == (n11 = this.tag));
            this.zzum = n12;
            return;
        }
        n10 = this.tag & 7;
        if (n10 != 0) {
            if (n10 == n11) {
                Object object3 = this.zzul;
                n10 = ((zzhe)object3).zzey();
                zzhe zzhe3 = this.zzul;
                n11 = zzhe3.zzft() + n10;
                do {
                    object3 = this.zzul.zzfc();
                    object.add(object3);
                } while ((n10 = ((zzhe)(object3 = this.zzul)).zzft()) < n11);
                this.zzat(n11);
                return;
            }
            throw zzin.zzhm();
        }
        do {
            object2 = this.zzul.zzfc();
            object.add(object2);
            object2 = this.zzul;
            n10 = (int)(((zzhe)object2).zzen() ? 1 : 0);
            if (n10 == 0) continue;
            return;
        } while ((n10 = ((zzhe)(object2 = this.zzul)).zzfr()) == (n11 = this.tag));
        this.zzum = n10;
    }

    public final void zzp(List object) {
        Object object2;
        int n10 = object instanceof zzjb;
        int n11 = 2;
        if (n10 != 0) {
            List list = object;
            list = (zzjb)object;
            int n12 = this.tag & 7;
            if (n12 != 0) {
                if (n12 == n11) {
                    object = this.zzul;
                    n12 = ((zzhe)object).zzey();
                    zzhe zzhe2 = this.zzul;
                    n11 = zzhe2.zzft() + n12;
                    do {
                        long l10 = this.zzul.zzfd();
                        ((zzjb)list).zzac(l10);
                    } while ((n12 = ((zzhe)(object = this.zzul)).zzft()) < n11);
                    this.zzat(n11);
                    return;
                }
                throw zzin.zzhm();
            }
            do {
                long l11 = this.zzul.zzfd();
                ((zzjb)list).zzac(l11);
                object = this.zzul;
                n12 = (int)(((zzhe)object).zzen() ? 1 : 0);
                if (n12 == 0) continue;
                return;
            } while ((n12 = ((zzhe)(object = this.zzul)).zzfr()) == (n11 = this.tag));
            this.zzum = n12;
            return;
        }
        n10 = this.tag & 7;
        if (n10 != 0) {
            if (n10 == n11) {
                Object object3 = this.zzul;
                n10 = ((zzhe)object3).zzey();
                zzhe zzhe3 = this.zzul;
                n11 = zzhe3.zzft() + n10;
                do {
                    long l12 = this.zzul.zzfd();
                    object3 = l12;
                    object.add(object3);
                } while ((n10 = ((zzhe)(object3 = this.zzul)).zzft()) < n11);
                this.zzat(n11);
                return;
            }
            throw zzin.zzhm();
        }
        do {
            long l13 = this.zzul.zzfd();
            object2 = l13;
            object.add(object2);
            object2 = this.zzul;
            n10 = (int)(((zzhe)object2).zzen() ? 1 : 0);
            if (n10 == 0) continue;
            return;
        } while ((n10 = ((zzhe)(object2 = this.zzul)).zzfr()) == (n11 = this.tag));
        this.zzum = n10;
    }
}

