/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzds;
import com.google.android.gms.internal.mlkit_common.zzdx;
import com.google.android.gms.internal.mlkit_common.zzdy;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.LazyInstanceMap;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

public class zzdx$zza
extends LazyInstanceMap {
    private final zzds zza;
    private final SharedPrefManager zzb;

    private zzdx$zza(zzds zzds2, SharedPrefManager sharedPrefManager) {
        this.zza = zzds2;
        this.zzb = sharedPrefManager;
    }

    public /* synthetic */ zzdx$zza(zzds zzds2, SharedPrefManager sharedPrefManager, zzdy zzdy2) {
        this(zzds2, sharedPrefManager);
    }

    public /* synthetic */ Object create(Object object) {
        object = (RemoteModel)object;
        zzds zzds2 = this.zza;
        SharedPrefManager sharedPrefManager = this.zzb;
        zzdx zzdx2 = new zzdx(zzds2, sharedPrefManager, (RemoteModel)object, null);
        return zzdx2;
    }
}

