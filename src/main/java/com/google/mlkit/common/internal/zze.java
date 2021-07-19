/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.internal;

import com.google.android.gms.internal.mlkit_common.zzds;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.mlkit.common.sdkinternal.Cleaner;
import com.google.mlkit.common.sdkinternal.CloseGuard$Factory;

public final class zze
implements ComponentFactory {
    public static final ComponentFactory zza;

    static {
        zze zze2 = new zze();
        zza = zze2;
    }

    private zze() {
    }

    public final Object create(ComponentContainer object) {
        Cleaner cleaner = (Cleaner)object.get(Cleaner.class);
        object = (zzds)object.get(zzds.class);
        CloseGuard$Factory closeGuard$Factory = new CloseGuard$Factory(cleaner, (zzds)object);
        return closeGuard$Factory;
    }
}

