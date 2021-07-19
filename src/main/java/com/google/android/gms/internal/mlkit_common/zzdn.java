/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.gms.internal.mlkit_common;

import android.content.Context;
import com.google.android.gms.internal.mlkit_common.zzdo;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

public final class zzdn
implements ComponentFactory {
    public static final ComponentFactory zza;

    static {
        zzdn zzdn2 = new zzdn();
        zza = zzdn2;
    }

    private zzdn() {
    }

    public final Object create(ComponentContainer componentContainer) {
        componentContainer = (Context)componentContainer.get(Context.class);
        zzdo zzdo2 = new zzdo((Context)componentContainer);
        return zzdo2;
    }
}

