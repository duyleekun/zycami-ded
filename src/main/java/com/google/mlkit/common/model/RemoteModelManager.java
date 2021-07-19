/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.model;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.inject.Provider;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.model.RemoteModelManager$RemoteModelManagerRegistration;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.model.RemoteModelManagerInterface;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RemoteModelManager {
    private final Map zza;

    public RemoteModelManager(Set object) {
        boolean bl2;
        Object object2 = new HashMap();
        this.zza = object2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            object2 = (RemoteModelManager$RemoteModelManagerRegistration)object.next();
            Map map = this.zza;
            Class clazz = ((RemoteModelManager$RemoteModelManagerRegistration)object2).zza();
            object2 = ((RemoteModelManager$RemoteModelManagerRegistration)object2).zzb();
            map.put(clazz, object2);
        }
    }

    public static RemoteModelManager getInstance() {
        Class<RemoteModelManager> clazz = RemoteModelManager.class;
        synchronized (clazz) {
            Object object = MlKitContext.getInstance();
            object = ((MlKitContext)object).get(clazz);
            object = (RemoteModelManager)object;
            return object;
        }
    }

    private final RemoteModelManagerInterface zza(Class clazz) {
        return (RemoteModelManagerInterface)((Provider)this.zza.get(clazz)).get();
    }

    public Task deleteDownloadedModel(RemoteModel remoteModel) {
        Preconditions.checkNotNull(remoteModel, "RemoteModel cannot be null");
        Class<?> clazz = remoteModel.getClass();
        return this.zza(clazz).deleteDownloadedModel(remoteModel);
    }

    public Task download(RemoteModel object, DownloadConditions object2) {
        Preconditions.checkNotNull(object, "RemoteModel cannot be null");
        Preconditions.checkNotNull(object2, "DownloadConditions cannot be null");
        Object object3 = this.zza;
        Serializable serializable = object.getClass();
        int n10 = object3.containsKey(serializable);
        if (n10 != 0) {
            object3 = object.getClass();
            return this.zza((Class)object3).download((RemoteModel)object, (DownloadConditions)object2);
        }
        object = object.getClass().getSimpleName();
        n10 = String.valueOf(object).length() + 70;
        serializable = new StringBuilder(n10);
        ((StringBuilder)serializable).append("Feature model '");
        ((StringBuilder)serializable).append((String)object);
        ((StringBuilder)serializable).append("' doesn't have a corresponding modelmanager registered.");
        object = ((StringBuilder)serializable).toString();
        object2 = new MlKitException((String)object, 13);
        return Tasks.forException((Exception)object2);
    }

    public Task getDownloadedModels(Class clazz) {
        return ((RemoteModelManagerInterface)((Provider)this.zza.get(clazz)).get()).getDownloadedModels();
    }

    public Task isModelDownloaded(RemoteModel remoteModel) {
        Preconditions.checkNotNull(remoteModel, "RemoteModel cannot be null");
        Class<?> clazz = remoteModel.getClass();
        return this.zza(clazz).isModelDownloaded(remoteModel);
    }
}

