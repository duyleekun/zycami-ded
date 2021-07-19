/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzbb;
import com.google.android.gms.internal.clearcut.zzbt;
import com.google.android.gms.internal.clearcut.zzco;
import com.google.android.gms.internal.clearcut.zzdo;

public class zzcv {
    private static final zzbt zzez = zzbt.zzan();
    private zzbb zzln;
    private volatile zzdo zzlo;
    private volatile zzbb zzlp;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final zzdo zzh(zzdo object) {
        Object object2 = this.zzlo;
        if (object2 != null) return this.zzlo;
        synchronized (this) {
            object2 = this.zzlo;
            if (object2 == null) {
                try {
                    this.zzlo = object;
                    this.zzlp = object2 = zzbb.zzfi;
                }
                catch (zzco zzco2) {
                    this.zzlo = object;
                    this.zzlp = object = zzbb.zzfi;
                }
            }
            return this.zzlo;
        }
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        boolean bl2 = object instanceof zzcv;
        if (!bl2) {
            return false;
        }
        object = (zzcv)object;
        Object object2 = this.zzlo;
        zzdo zzdo2 = ((zzcv)object).zzlo;
        if (object2 == null && zzdo2 == null) {
            object2 = this.zzr();
            object = ((zzcv)object).zzr();
            return ((zzbb)object2).equals(object);
        }
        if (object2 != null && zzdo2 != null) {
            return object2.equals(zzdo2);
        }
        if (object2 != null) {
            zzdo2 = object2.zzbe();
            object = super.zzh(zzdo2);
            return object2.equals(object);
        }
        object = zzdo2.zzbe();
        return this.zzh((zzdo)object).equals(zzdo2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zzas() {
        Object object = this.zzlp;
        if (object != null) {
            return this.zzlp.size();
        }
        object = this.zzlo;
        if (object != null) {
            return this.zzlo.zzas();
        }
        return 0;
    }

    public final zzdo zzi(zzdo zzdo2) {
        zzdo zzdo3 = this.zzlo;
        this.zzln = null;
        this.zzlp = null;
        this.zzlo = zzdo2;
        return zzdo3;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final zzbb zzr() {
        Object object = this.zzlp;
        if (object != null) {
            return this.zzlp;
        }
        synchronized (this) {
            object = this.zzlp;
            if (object != null) {
                return this.zzlp;
            }
            object = this.zzlo;
            if (object == null) {
                object = zzbb.zzfi;
            } else {
                object = this.zzlo;
                object = object.zzr();
            }
            this.zzlp = object;
            return this.zzlp;
        }
    }
}

