/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzaf;
import java.util.AbstractCollection;
import java.util.Iterator;

public final class zzan
extends AbstractCollection {
    private final /* synthetic */ zzaf zza;

    public zzan(zzaf zzaf2) {
        this.zza = zzaf2;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final Iterator iterator() {
        return this.zza.zzg();
    }

    public final int size() {
        return this.zza.size();
    }
}

