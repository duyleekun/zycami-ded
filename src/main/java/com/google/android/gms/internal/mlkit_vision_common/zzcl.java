/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.gms.internal.mlkit_vision_common;

import android.content.Context;
import com.google.android.gms.internal.mlkit_vision_common.zzcm;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

public final class zzcl
implements ComponentFactory {
    public static final ComponentFactory zza;

    static {
        zzcl zzcl2 = new zzcl();
        zza = zzcl2;
    }

    private zzcl() {
    }

    public final Object create(ComponentContainer componentContainer) {
        componentContainer = (Context)componentContainer.get(Context.class);
        zzcm zzcm2 = new zzcm((Context)componentContainer);
        return zzcm2;
    }
}

