/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzdp;
import java.util.AbstractCollection;
import java.util.Iterator;

public final class zzdx
extends AbstractCollection {
    private final /* synthetic */ zzdp zzmo;

    public zzdx(zzdp zzdp2) {
        this.zzmo = zzdp2;
    }

    public final void clear() {
        this.zzmo.clear();
    }

    public final Iterator iterator() {
        return this.zzmo.zzcl();
    }

    public final int size() {
        return this.zzmo.size();
    }
}

