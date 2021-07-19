/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.mlkit.vision.face.internal;

import android.content.Context;
import com.google.android.gms.internal.mlkit_vision_face.zzaq;
import com.google.android.gms.internal.mlkit_vision_face.zzeh;
import com.google.android.gms.internal.mlkit_vision_face.zzej;
import com.google.android.gms.internal.mlkit_vision_face.zzel;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component$Builder;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.sdkinternal.ExecutorSelector;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.vision.face.internal.FaceDetectorImpl$zza;
import com.google.mlkit.vision.face.internal.zzc;
import com.google.mlkit.vision.face.internal.zzf;
import com.google.mlkit.vision.face.internal.zzg;
import java.util.List;

public class FaceRegistrar
implements ComponentRegistrar {
    public List getComponents() {
        Component component = zzej.zza;
        Component component2 = zzeh.zza;
        Component component3 = zzel.zza;
        Object object = Component.builder(zzc.class);
        Object object2 = Dependency.required(MlKitContext.class);
        object = ((Component$Builder)object).add((Dependency)object2);
        object2 = zzf.zza;
        object = ((Component$Builder)object).factory((ComponentFactory)object2).build();
        object2 = Component.builder(FaceDetectorImpl$zza.class);
        Object object3 = Dependency.required(Context.class);
        object2 = ((Component$Builder)object2).add((Dependency)object3);
        object3 = Dependency.required(zzel.class);
        object2 = ((Component$Builder)object2).add((Dependency)object3);
        object3 = Dependency.required(ExecutorSelector.class);
        object2 = ((Component$Builder)object2).add((Dependency)object3);
        object3 = zzg.zza;
        object2 = ((Component$Builder)object2).factory((ComponentFactory)object3).build();
        return zzaq.zza(component, component2, component3, object, object2);
    }
}

