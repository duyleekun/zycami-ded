/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.sdkinternal.model;

import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.mlkit_common.zzdx;
import com.google.android.gms.internal.mlkit_common.zzdx$zza;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import com.google.mlkit.common.sdkinternal.model.ModelFileHelper;
import com.google.mlkit.common.sdkinternal.model.ModelInfoRetrieverInterop;
import com.google.mlkit.common.sdkinternal.model.ModelValidator;
import com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager;
import com.google.mlkit.common.sdkinternal.model.RemoteModelFileManager;
import com.google.mlkit.common.sdkinternal.model.RemoteModelFileMover;
import com.google.mlkit.common.sdkinternal.model.RemoteModelLoaderHelper;
import java.io.File;
import java.nio.MappedByteBuffer;
import java.util.HashMap;
import java.util.Map;

public class RemoteModelLoader {
    private static final GmsLogger zza;
    private static final Map zzb;
    private final MlKitContext zzc;
    private final RemoteModel zzd;
    private final RemoteModelDownloadManager zze;
    private final RemoteModelFileManager zzf;
    private final zzdx zzg;
    private final RemoteModelLoaderHelper zzh;
    private final ModelType zzi;
    private boolean zzj;

    static {
        HashMap hashMap = new HashMap("RemoteModelLoader", "");
        zza = hashMap;
        zzb = hashMap = new HashMap();
    }

    private RemoteModelLoader(MlKitContext object, RemoteModel remoteModel, ModelValidator object2, RemoteModelLoaderHelper remoteModelLoaderHelper, RemoteModelFileMover object3) {
        RemoteModelFileManager remoteModelFileManager;
        ModelFileHelper modelFileHelper = new ModelFileHelper((MlKitContext)object);
        this.zzf = remoteModelFileManager = new RemoteModelFileManager((MlKitContext)object, remoteModel, (ModelValidator)object2, modelFileHelper, (RemoteModelFileMover)object3);
        this.zzj = true;
        this.zzg = object2 = (zzdx)((zzdx$zza)MlKitContext.getInstance().get(zzdx$zza.class)).get(remoteModel);
        object2 = new ModelFileHelper((MlKitContext)object);
        object3 = (ModelInfoRetrieverInterop)object.get(ModelInfoRetrieverInterop.class);
        this.zze = object2 = RemoteModelDownloadManager.getInstance(object, remoteModel, (ModelFileHelper)object2, remoteModelFileManager, (ModelInfoRetrieverInterop)object3);
        this.zzh = remoteModelLoaderHelper;
        this.zzc = object;
        this.zzd = remoteModel;
        object = remoteModel.getModelType();
        this.zzi = object;
    }

    public static RemoteModelLoader getInstance(MlKitContext object, RemoteModel remoteModel, ModelValidator modelValidator, RemoteModelLoaderHelper remoteModelLoaderHelper, RemoteModelFileMover remoteModelFileMover) {
        Class<RemoteModelLoader> clazz = RemoteModelLoader.class;
        synchronized (clazz) {
            String string2 = remoteModel.getUniqueModelNameForPersist();
            Map map = zzb;
            boolean bl2 = map.containsKey(string2);
            if (!bl2) {
                RemoteModelLoader remoteModelLoader = new RemoteModelLoader((MlKitContext)object, remoteModel, modelValidator, remoteModelLoaderHelper, remoteModelFileMover);
                map.put(string2, remoteModelLoader);
            }
            object = map.get(string2);
            object = (RemoteModelLoader)object;
            return object;
        }
    }

    private final MappedByteBuffer zza() {
        Object object = this.zzf.zza();
        if (object == null) {
            zza.d("RemoteModelLoader", "No existing model file");
            return null;
        }
        try {
            return this.zza((String)object);
        }
        catch (Exception exception) {
            Object object2 = this.zzf;
            File file = new File((String)object);
            ((RemoteModelFileManager)object2).zzb(file);
            object = SharedPrefManager.getInstance(this.zzc);
            object2 = this.zzd;
            ((SharedPrefManager)object).clearLatestModelHash((RemoteModel)object2);
            object = new MlKitException("Failed to load an already downloaded model.", 14, exception);
            throw object;
        }
    }

    private final MappedByteBuffer zza(File serializable) {
        String string2;
        try {
            string2 = serializable.getAbsolutePath();
        }
        catch (Exception exception) {
            this.zzf.zzb((File)serializable);
            serializable = new MlKitException("Failed to load newly downloaded model.", 14, exception);
            throw serializable;
        }
        return this.zza(string2);
    }

    private final MappedByteBuffer zza(String string2) {
        return this.zzh.loadModelAtPath(string2);
    }

    public RemoteModel getRemoteModel() {
        return this.zzd;
    }

    public MappedByteBuffer load() {
        synchronized (this) {
            Object object;
            Object object2;
            Object object3;
            GmsLogger gmsLogger;
            block53: {
                block51: {
                    block48: {
                        Object object4;
                        Object object5;
                        int n10;
                        block50: {
                            String string2;
                            String string3;
                            block52: {
                                block49: {
                                    gmsLogger = zza;
                                    object3 = "RemoteModelLoader";
                                    object2 = "Try to load newly downloaded model file.";
                                    gmsLogger.d((String)object3, (String)object2);
                                    n10 = this.zzj;
                                    object2 = this.zze;
                                    object2 = ((RemoteModelDownloadManager)object2).getDownloadingId();
                                    object5 = this.zze;
                                    object5 = ((RemoteModelDownloadManager)object5).getDownloadingModelHash();
                                    if (object2 == null || object5 == null) break block48;
                                    object = this.zze;
                                    object = ((RemoteModelDownloadManager)object).getDownloadingModelStatusCode();
                                    if (object != null) break block49;
                                    object3 = this.zze;
                                    ((RemoteModelDownloadManager)object3).removeOrCancelDownload();
                                }
                                object4 = "RemoteModelLoader";
                                string3 = String.valueOf(object);
                                string2 = String.valueOf(string3);
                                int n11 = string2.length() + 22;
                                StringBuilder stringBuilder = new StringBuilder(n11);
                                string2 = "Download Status code: ";
                                stringBuilder.append(string2);
                                stringBuilder.append(string3);
                                string3 = stringBuilder.toString();
                                gmsLogger.d((String)object4, string3);
                                int n12 = (Integer)object;
                                int n13 = 8;
                                if (n12 != n13) break block50;
                                object2 = this.zze;
                                object2 = ((RemoteModelDownloadManager)object2).zza((String)object5);
                                if (object2 == null) break block51;
                                object = this.zza((File)object2);
                                object4 = "RemoteModelLoader";
                                string3 = "Moved the downloaded model to private folder successfully: ";
                                string2 = ((File)object2).getParent();
                                string2 = String.valueOf(string2);
                                int n14 = string2.length();
                                if (n14 == 0) break block52;
                                string3 = string3.concat(string2);
                            }
                            string3 = string2 = new String(string3);
                            gmsLogger.d((String)object4, string3);
                            object4 = this.zze;
                            ((RemoteModelDownloadManager)object4).updateLatestModelHashAndType((String)object5);
                            if (n10 == 0) break block53;
                            object3 = this.zzf;
                            n10 = (int)(((RemoteModelFileManager)object3).zza((File)object2) ? 1 : 0);
                            if (n10 == 0) break block53;
                            object3 = "RemoteModelLoader";
                            object5 = "All old models are deleted.";
                            gmsLogger.d((String)object3, (String)object5);
                            object3 = this.zzf;
                            object3 = ((RemoteModelFileManager)object3).zzc((File)object2);
                            object = this.zza((File)object3);
                        }
                        n10 = (Integer)object;
                        int n15 = 16;
                        if (n10 != n15) break block51;
                        object3 = this.zzg;
                        n15 = 0;
                        object5 = null;
                        object = this.zzi;
                        object4 = this.zze;
                        int n16 = ((RemoteModelDownloadManager)object4).getFailureReason((Long)object2);
                        ((zzdx)object3).zza(false, (ModelType)((Object)object), n16);
                        object3 = this.zze;
                        ((RemoteModelDownloadManager)object3).removeOrCancelDownload();
                    }
                    object3 = "RemoteModelLoader";
                    object2 = "No new model is downloading.";
                    gmsLogger.d((String)object3, (String)object2);
                    object3 = this.zze;
                    ((RemoteModelDownloadManager)object3).removeOrCancelDownload();
                }
                object = null;
            }
            if (object == null) {
                object3 = "RemoteModelLoader";
                object2 = "Loading existing model file.";
                gmsLogger.d((String)object3, (String)object2);
                object = this.zza();
            }
            return object;
            finally {
            }
        }
    }
}

