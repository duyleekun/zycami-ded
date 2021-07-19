/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.internal;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.mlkit.common.model.RemoteModelManager;
import com.google.mlkit.common.model.RemoteModelManager$RemoteModelManagerRegistration;
import java.util.Set;

public final class zzd
implements ComponentFactory {
    public static final ComponentFactory zza;

    static {
        zzd zzd2 = new zzd();
        zza = zzd2;
    }

    private zzd() {
    }

    public final Object create(ComponentContainer object) {
        object = object.setOf(RemoteModelManager$RemoteModelManagerRegistration.class);
        RemoteModelManager remoteModelManager = new RemoteModelManager((Set)object);
        return remoteModelManager;
    }
}

