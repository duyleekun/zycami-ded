/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgs;
import com.google.android.gms.internal.vision.zzin;
import com.google.android.gms.internal.vision.zzkc;
import com.google.android.gms.internal.vision.zzlq;

public abstract class zzkx {
    public abstract void zza(Object var1, int var2, long var3);

    public abstract void zza(Object var1, int var2, zzgs var3);

    public abstract void zza(Object var1, int var2, Object var3);

    public abstract void zza(Object var1, zzlq var2);

    public abstract boolean zza(zzkc var1);

    public final boolean zza(Object object, zzkc object2) {
        int n10 = object2.getTag();
        int n11 = n10 >>> 3;
        int n12 = 1;
        if ((n10 &= 7) != 0) {
            if (n10 != n12) {
                int n13 = 2;
                if (n10 != n13) {
                    int n14;
                    n13 = 4;
                    int n15 = 3;
                    if (n10 != n15) {
                        if (n10 != n13) {
                            n13 = 5;
                            if (n10 == n13) {
                                int n16 = object2.zzeu();
                                this.zzd(object, n11, n16);
                                return n12 != 0;
                            }
                            throw zzin.zzhm();
                        }
                        return false;
                    }
                    Object object3 = this.zzjd();
                    n15 = n11 << 3;
                    n13 |= n15;
                    while ((n15 = object2.zzeo()) != (n14 = -1 >>> 1) && (n15 = (int)(this.zza(object3, (zzkc)object2) ? 1 : 0)) != 0) {
                    }
                    int n17 = object2.getTag();
                    if (n13 == n17) {
                        object2 = this.zzq(object3);
                        this.zza(object, n11, object2);
                        return n12 != 0;
                    }
                    throw zzin.zzhl();
                }
                object2 = object2.zzex();
                this.zza(object, n11, (zzgs)object2);
                return n12 != 0;
            }
            long l10 = object2.zzet();
            this.zzb(object, n11, l10);
            return n12 != 0;
        }
        long l11 = object2.zzer();
        this.zza(object, n11, l11);
        return n12 != 0;
    }

    public abstract int zzaa(Object var1);

    public abstract void zzb(Object var1, int var2, long var3);

    public abstract void zzc(Object var1, zzlq var2);

    public abstract void zzd(Object var1, int var2, int var3);

    public abstract void zzf(Object var1, Object var2);

    public abstract void zzg(Object var1, Object var2);

    public abstract Object zzh(Object var1, Object var2);

    public abstract void zzj(Object var1);

    public abstract Object zzjd();

    public abstract Object zzq(Object var1);

    public abstract int zzu(Object var1);

    public abstract Object zzy(Object var1);

    public abstract Object zzz(Object var1);
}

