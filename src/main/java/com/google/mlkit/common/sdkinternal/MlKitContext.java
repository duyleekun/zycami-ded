/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.mlkit.common.sdkinternal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentDiscovery;
import com.google.firebase.components.ComponentRuntime;
import com.google.mlkit.common.internal.MlKitComponentDiscoveryService;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

public class MlKitContext {
    private static final AtomicReference zzb;
    private final ComponentRuntime zza;

    static {
        AtomicReference atomicReference;
        zzb = atomicReference = new AtomicReference();
    }

    private MlKitContext(Context object) {
        ComponentRuntime componentRuntime;
        List list = ComponentDiscovery.forContext(object, MlKitComponentDiscoveryService.class).discover();
        Executor executor = TaskExecutors.MAIN_THREAD;
        Component[] componentArray = new Component[2];
        Class[] classArray = new Class[]{};
        object = Component.of(object, Context.class, classArray);
        componentArray[0] = object;
        Class[] classArray2 = new Class[]{};
        object = Component.of(this, MlKitContext.class, classArray2);
        boolean bl2 = true;
        componentArray[bl2] = object;
        this.zza = componentRuntime = new ComponentRuntime(executor, (Iterable)list, componentArray);
        componentRuntime.initializeEagerComponents(bl2);
    }

    public static MlKitContext getInstance() {
        MlKitContext mlKitContext = (MlKitContext)zzb.get();
        boolean bl2 = mlKitContext != null;
        Preconditions.checkState(bl2, "MlKitContext has not been initialized");
        return mlKitContext;
    }

    public static MlKitContext zza(Context object) {
        boolean bl2;
        MlKitContext mlKitContext;
        Context context = object.getApplicationContext();
        if (context != null) {
            object = context;
        }
        if ((object = zzb.getAndSet(mlKitContext = new MlKitContext((Context)object))) == null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        Preconditions.checkState(bl2, "MlKitContext is already initialized");
        return mlKitContext;
    }

    public Object get(Class clazz) {
        boolean bl2;
        Object v10 = zzb.get();
        if (v10 == this) {
            bl2 = true;
        } else {
            bl2 = false;
            v10 = null;
        }
        Preconditions.checkState(bl2, "MlKitContext has been deleted");
        return this.zza.get(clazz);
    }

    public Context getApplicationContext() {
        return (Context)this.get(Context.class);
    }
}

