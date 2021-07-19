/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.vision.common.internal;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.mlkit.vision.common.internal.MultiFlavorDetectorCreator;
import com.google.mlkit.vision.common.internal.MultiFlavorDetectorCreator$Registration;
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
        object = object.setOf(MultiFlavorDetectorCreator$Registration.class);
        MultiFlavorDetectorCreator multiFlavorDetectorCreator = new MultiFlavorDetectorCreator((Set)object);
        return multiFlavorDetectorCreator;
    }
}

