/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzde;
import com.google.android.gms.internal.vision.zzeb;
import com.google.android.gms.internal.vision.zzee;
import com.google.android.gms.internal.vision.zzey;
import java.util.Iterator;
import java.util.Set;

public abstract class zzej
extends zzeb
implements Set {
    private transient zzee zznf;

    public static int zzy(int n10) {
        n10 = Math.max(n10, 2);
        int n11 = 1;
        int n12 = 0x2CCCCCCC;
        if (n10 < n12) {
            double d10;
            double d11;
            double d12;
            n12 = Integer.highestOneBit(n10 + -1);
            n11 = n12 << 1;
            while ((n12 = (int)((d12 = (d11 = (double)n11 * 0.7) - (d10 = (double)n10)) == 0.0 ? 0 : (d12 < 0.0 ? -1 : 1))) < 0) {
                n11 <<= 1;
            }
            return n11;
        }
        n12 = 0x40000000;
        if (n10 >= n12) {
            n11 = 0;
        }
        zzde.checkArgument(n11 != 0, "collection too large");
        return n12;
    }

    public boolean equals(Object object) {
        boolean bl2;
        if (object == this) {
            return true;
        }
        boolean n10 = object instanceof zzej;
        if (n10 && (bl2 = this.zzcz())) {
            int n11;
            int n12;
            Object object2 = object;
            object2 = (zzej)object;
            boolean bl3 = ((zzej)object2).zzcz();
            if (bl3 && (n12 = this.hashCode()) != (n11 = object.hashCode())) {
                return false;
            }
        }
        return zzey.zza(this, object);
    }

    public int hashCode() {
        return zzey.zza(this);
    }

    public /* synthetic */ Iterator iterator() {
        return this.zzcp();
    }

    public zzee zzct() {
        zzee zzee2 = this.zznf;
        if (zzee2 == null) {
            this.zznf = zzee2 = this.zzda();
        }
        return zzee2;
    }

    public boolean zzcz() {
        return false;
    }

    public zzee zzda() {
        return zzee.zza(this.toArray());
    }
}

