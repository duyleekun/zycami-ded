/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.vision.common.internal;

import com.google.android.gms.internal.mlkit_vision_common.zzcm;
import com.google.android.gms.internal.mlkit_vision_common.zzco;
import com.google.android.gms.internal.mlkit_vision_common.zzcq;
import com.google.android.gms.internal.mlkit_vision_common.zzh;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component$Builder;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.mlkit.vision.common.internal.MultiFlavorDetectorCreator;
import com.google.mlkit.vision.common.internal.MultiFlavorDetectorCreator$Registration;
import com.google.mlkit.vision.common.internal.zzd;
import java.util.List;

public class VisionCommonRegistrar
implements ComponentRegistrar {
    public List getComponents() {
        Component component = zzco.zza;
        Component component2 = zzcm.zza;
        Component component3 = zzcq.zza;
        Object object = Component.builder(MultiFlavorDetectorCreator.class);
        Object object2 = Dependency.setOf(MultiFlavorDetectorCreator$Registration.class);
        object = ((Component$Builder)object).add((Dependency)object2);
        object2 = zzd.zza;
        object = ((Component$Builder)object).factory((ComponentFactory)object2).build();
        return zzh.zza(component, component2, component3, object);
    }
}

