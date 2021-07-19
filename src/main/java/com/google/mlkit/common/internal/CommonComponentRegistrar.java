/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.internal;

import com.google.android.gms.internal.mlkit_common.zzad;
import com.google.android.gms.internal.mlkit_common.zzdo;
import com.google.android.gms.internal.mlkit_common.zzdq;
import com.google.android.gms.internal.mlkit_common.zzds;
import com.google.android.gms.internal.mlkit_common.zzdx;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component$Builder;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.internal.zza;
import com.google.mlkit.common.internal.zzb;
import com.google.mlkit.common.internal.zzc;
import com.google.mlkit.common.internal.zzd;
import com.google.mlkit.common.internal.zze;
import com.google.mlkit.common.internal.zzf;
import com.google.mlkit.common.model.RemoteModelManager;
import com.google.mlkit.common.model.RemoteModelManager$RemoteModelManagerRegistration;
import com.google.mlkit.common.sdkinternal.Cleaner;
import com.google.mlkit.common.sdkinternal.CloseGuard$Factory;
import com.google.mlkit.common.sdkinternal.ExecutorSelector;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.MlKitThreadPool;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import com.google.mlkit.common.sdkinternal.model.ModelFileHelper;
import java.util.List;

public class CommonComponentRegistrar
implements ComponentRegistrar {
    public List getComponents() {
        Object object = Cleaner.class;
        Component component = zzds.zza;
        Component component2 = SharedPrefManager.COMPONENT;
        Component component3 = zzdx.zza;
        Component component4 = zzdq.zza;
        Component component5 = zzdo.zza;
        Object object2 = Component.builder(ModelFileHelper.class);
        Object object3 = Dependency.required(MlKitContext.class);
        object2 = ((Component$Builder)object2).add((Dependency)object3);
        object3 = zzb.zza;
        object2 = ((Component$Builder)object2).factory((ComponentFactory)object3).build();
        object3 = Component.builder(MlKitThreadPool.class);
        Object object4 = zza.zza;
        object3 = ((Component$Builder)object3).factory((ComponentFactory)object4).build();
        object4 = Component.builder(RemoteModelManager.class);
        Object object5 = Dependency.setOf(RemoteModelManager$RemoteModelManagerRegistration.class);
        object4 = ((Component$Builder)object4).add((Dependency)object5);
        object5 = zzd.zza;
        object4 = ((Component$Builder)object4).factory((ComponentFactory)object5).build();
        object5 = Component.builder(ExecutorSelector.class);
        Object object6 = Dependency.requiredProvider(MlKitThreadPool.class);
        object5 = ((Component$Builder)object5).add((Dependency)object6);
        object6 = zzc.zza;
        object5 = ((Component$Builder)object5).factory((ComponentFactory)object6).build();
        object6 = Component.builder(object);
        Object object7 = zzf.zza;
        object6 = ((Component$Builder)object6).factory((ComponentFactory)object7).build();
        object7 = Component.builder(CloseGuard$Factory.class);
        object = Dependency.required(object);
        object = ((Component$Builder)object7).add((Dependency)object);
        object7 = Dependency.required(zzds.class);
        object = ((Component$Builder)object).add((Dependency)object7);
        object7 = zze.zza;
        object7 = ((Component$Builder)object).factory((ComponentFactory)object7).build();
        return zzad.zza(component, component2, component3, component4, component5, object2, object3, object4, object5, object6, object7);
    }
}

