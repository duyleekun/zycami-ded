/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzcz;
import com.google.android.gms.internal.vision.zzdl;
import com.google.android.gms.internal.vision.zzdp;
import java.util.Map;

public final class zzdy
extends zzdl {
    private final /* synthetic */ zzdp zzmo;
    private final Object zzmr;
    private int zzms;

    public zzdy(zzdp object, int n10) {
        this.zzmo = object;
        this.zzmr = object = ((zzdp)object).zzmi[n10];
        this.zzms = n10;
    }

    private final void zzco() {
        block3: {
            Object object;
            Object object2;
            int n10;
            block2: {
                n10 = this.zzms;
                int n11 = -1;
                if (n10 == n11 || n10 >= (n11 = (object2 = this.zzmo).size())) break block2;
                object = this.zzmr;
                object2 = this.zzmo.zzmi;
                int n12 = this.zzms;
                n10 = (int)(zzcz.equal(object, object2 = object2[n12]) ? 1 : 0);
                if (n10 != 0) break block3;
            }
            object = this.zzmo;
            object2 = this.zzmr;
            this.zzms = n10 = zzdp.zzb((zzdp)object, object2);
        }
    }

    public final Object getKey() {
        return this.zzmr;
    }

    public final Object getValue() {
        Map map = this.zzmo.zzcf();
        if (map != null) {
            Object object = this.zzmr;
            return map.get(object);
        }
        this.zzco();
        int n10 = this.zzms;
        int n11 = -1;
        if (n10 == n11) {
            return null;
        }
        return this.zzmo.zzmj[n10];
    }

    public final Object setValue(Object object) {
        Map map = this.zzmo.zzcf();
        if (map != null) {
            Object object2 = this.zzmr;
            return map.put(object2, object);
        }
        this.zzco();
        int n10 = this.zzms;
        int n11 = -1;
        if (n10 == n11) {
            map = this.zzmo;
            Object object3 = this.zzmr;
            ((zzdp)map).put(object3, object);
            return null;
        }
        Object[] objectArray = this.zzmo.zzmj;
        Object object4 = objectArray[n10];
        objectArray[n10] = object;
        return object4;
    }
}

