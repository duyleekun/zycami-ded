/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzcz;
import com.google.android.gms.internal.vision.zzdp;
import com.google.android.gms.internal.vision.zzea;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

public final class zzdt
extends AbstractSet {
    private final /* synthetic */ zzdp zzmo;

    public zzdt(zzdp zzdp2) {
        this.zzmo = zzdp2;
    }

    public final void clear() {
        this.zzmo.clear();
    }

    public final boolean contains(Object object) {
        boolean bl2;
        int n10;
        Object object2;
        Map map = this.zzmo.zzcf();
        if (map != null) {
            return map.entrySet().contains(object);
        }
        int n11 = object instanceof Map.Entry;
        return n11 != 0 && (n11 = zzdp.zzb((zzdp)(map = this.zzmo), object2 = (object = (Map.Entry)object).getKey())) != (n10 = -1) && (bl2 = zzcz.equal(map = (object2 = this.zzmo.zzmj)[n11], object = object.getValue()));
    }

    public final Iterator iterator() {
        return this.zzmo.zzck();
    }

    public final boolean remove(Object object) {
        Map map = this.zzmo.zzcf();
        if (map != null) {
            return map.entrySet().remove(object);
        }
        boolean n10 = object instanceof Map.Entry;
        if (n10) {
            int n11;
            object = (Map.Entry)object;
            map = this.zzmo;
            boolean bl2 = ((zzdp)map).zzce();
            if (bl2) {
                return false;
            }
            map = this.zzmo;
            int n12 = zzdp.zzb((zzdp)map);
            Object k10 = object.getKey();
            Object v10 = object.getValue();
            Object object2 = zzdp.zzc(this.zzmo);
            object = this.zzmo;
            int[] nArray = ((zzdp)object).zzmh;
            Object[] objectArray = ((zzdp)object).zzmi;
            Object[] objectArray2 = ((zzdp)object).zzmj;
            int n13 = zzea.zza(k10, v10, n12, object2, nArray, objectArray, objectArray2);
            if (n13 == (n11 = -1)) {
                return false;
            }
            this.zzmo.zzf(n13, n12);
            zzdp.zzd(this.zzmo);
            this.zzmo.zzch();
            return true;
        }
        return false;
    }

    public final int size() {
        return this.zzmo.size();
    }
}

