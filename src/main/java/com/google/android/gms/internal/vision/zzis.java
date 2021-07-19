/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgs;
import com.google.android.gms.internal.vision.zzho;
import com.google.android.gms.internal.vision.zzin;
import com.google.android.gms.internal.vision.zzjn;

public class zzis {
    private static final zzho zzth = zzho.zzgf();
    private zzgs zzzn;
    private volatile zzjn zzzo;
    private volatile zzgs zzzp;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final zzjn zzh(zzjn object) {
        Object object2 = this.zzzo;
        if (object2 != null) return this.zzzo;
        synchronized (this) {
            object2 = this.zzzo;
            if (object2 != null) {
                return this.zzzo;
            }
            try {
                this.zzzo = object;
                this.zzzp = object2 = zzgs.zztt;
            }
            catch (zzin zzin2) {
                this.zzzo = object;
                this.zzzp = object = zzgs.zztt;
            }
            return this.zzzo;
        }
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        boolean bl2 = object instanceof zzis;
        if (!bl2) {
            return false;
        }
        object = (zzis)object;
        Object object2 = this.zzzo;
        zzjn zzjn2 = ((zzis)object).zzzo;
        if (object2 == null && zzjn2 == null) {
            object2 = this.zzee();
            object = ((zzis)object).zzee();
            return ((zzgs)object2).equals(object);
        }
        if (object2 != null && zzjn2 != null) {
            return object2.equals(zzjn2);
        }
        if (object2 != null) {
            zzjn2 = object2.zzgx();
            object = super.zzh(zzjn2);
            return object2.equals(object);
        }
        object = zzjn2.zzgx();
        return this.zzh((zzjn)object).equals(zzjn2);
    }

    public int hashCode() {
        return 1;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final zzgs zzee() {
        Object object = this.zzzp;
        if (object != null) {
            return this.zzzp;
        }
        synchronized (this) {
            object = this.zzzp;
            if (object != null) {
                return this.zzzp;
            }
            object = this.zzzo;
            if (object == null) {
                this.zzzp = object = zzgs.zztt;
                return this.zzzp;
            } else {
                object = this.zzzo;
                this.zzzp = object = object.zzee();
            }
            return this.zzzp;
        }
    }

    public final int zzgz() {
        Object object = this.zzzp;
        if (object != null) {
            return this.zzzp.size();
        }
        object = this.zzzo;
        if (object != null) {
            return this.zzzo.zzgz();
        }
        return 0;
    }

    public final zzjn zzi(zzjn zzjn2) {
        zzjn zzjn3 = this.zzzo;
        this.zzzn = null;
        this.zzzp = null;
        this.zzzo = zzjn2;
        return zzjn3;
    }
}

