/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.gms.internal.mlkit_vision_face;

import android.content.Context;
import com.google.android.gms.internal.mlkit_vision_face.zzeh;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

public final class zzeg
implements ComponentFactory {
    public static final ComponentFactory zza;

    static {
        zzeg zzeg2 = new zzeg();
        zza = zzeg2;
    }

    private zzeg() {
    }

    public final Object create(ComponentContainer componentContainer) {
        componentContainer = (Context)componentContainer.get(Context.class);
        zzeh zzeh2 = new zzeh((Context)componentContainer);
        return zzeh2;
    }
}

