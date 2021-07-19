/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzaa;
import com.google.android.gms.internal.mlkit_vision_face.zzad;
import com.google.android.gms.internal.mlkit_vision_face.zzaf;
import com.google.android.gms.internal.mlkit_vision_face.zzn;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class zzab
extends zzaa {
    private transient int zza;

    private zzab() {
        this(12, 3);
    }

    private zzab(int n10, int n11) {
        zzaf zzaf2 = new zzaf(12);
        super(zzaf2);
        n10 = 3;
        zzad.zza(n10, "expectedValuesPerKey");
        this.zza = n10;
    }

    public static zzab zzh() {
        zzab zzab2 = new zzab();
        return zzab2;
    }

    public final /* synthetic */ Collection zza() {
        return ((zzn)this).zze();
    }

    public final List zze() {
        int n10 = this.zza;
        ArrayList arrayList = new ArrayList(n10);
        return arrayList;
    }
}

