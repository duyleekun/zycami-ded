/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzdp;
import java.util.AbstractSet;
import java.util.Iterator;

public final class zzdv
extends AbstractSet {
    private final /* synthetic */ zzdp zzmo;

    public zzdv(zzdp zzdp2) {
        this.zzmo = zzdp2;
    }

    public final void clear() {
        this.zzmo.clear();
    }

    public final boolean contains(Object object) {
        return this.zzmo.containsKey(object);
    }

    public final Iterator iterator() {
        return this.zzmo.zzcj();
    }

    public final boolean remove(Object object) {
        Object object2 = this.zzmo.zzcf();
        if (object2 != null) {
            return object2.keySet().remove(object);
        }
        return (object = zzdp.zza(this.zzmo, object)) != (object2 = zzdp.zzcm());
    }

    public final int size() {
        return this.zzmo.size();
    }
}

