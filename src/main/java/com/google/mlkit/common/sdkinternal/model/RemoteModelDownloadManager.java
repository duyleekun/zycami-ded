/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.DownloadManager
 *  android.app.DownloadManager$Query
 *  android.app.DownloadManager$Request
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.IntentFilter
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.ParcelFileDescriptor
 *  android.util.LongSparseArray
 */
package com.google.mlkit.common.sdkinternal.model;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.util.LongSparseArray;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_common.zzan;
import com.google.android.gms.internal.mlkit_common.zzdx;
import com.google.android.gms.internal.mlkit_common.zzdx$zza;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.CommonUtils;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.ModelInfo;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import com.google.mlkit.common.sdkinternal.model.ModelFileHelper;
import com.google.mlkit.common.sdkinternal.model.ModelInfoRetrieverInterop;
import com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager$zza;
import com.google.mlkit.common.sdkinternal.model.RemoteModelFileManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class RemoteModelDownloadManager {
    private static final GmsLogger zza;
    private static final Map zzb;
    private final LongSparseArray zzc;
    private final LongSparseArray zzd;
    private final MlKitContext zze;
    private final DownloadManager zzf;
    private final RemoteModel zzg;
    private final ModelType zzh;
    private final zzdx zzi;
    private final SharedPrefManager zzj;
    private final ModelFileHelper zzk;
    private final ModelInfoRetrieverInterop zzl;
    private final RemoteModelFileManager zzm;
    private DownloadConditions zzn;

    static {
        HashMap hashMap = new HashMap("ModelDownloadManager", "");
        zza = hashMap;
        zzb = hashMap = new HashMap();
    }

    private RemoteModelDownloadManager(MlKitContext object, RemoteModel object2, ModelFileHelper modelFileHelper, RemoteModelFileManager remoteModelFileManager, ModelInfoRetrieverInterop modelInfoRetrieverInterop) {
        Object object3 = new LongSparseArray();
        this.zzc = object3;
        object3 = new LongSparseArray();
        this.zzd = object3;
        this.zze = object;
        object3 = ((RemoteModel)object2).getModelType();
        this.zzh = object3;
        this.zzg = object2;
        object3 = ((MlKitContext)object).getApplicationContext();
        String string2 = "download";
        object3 = (DownloadManager)object3.getSystemService(string2);
        this.zzf = object3;
        if (object3 == null) {
            object3 = zza;
            string2 = "ModelDownloadManager";
            String string3 = "Download manager service is not available in the service.";
            ((GmsLogger)object3).d(string2, string3);
        }
        this.zzk = modelFileHelper;
        this.zzi = object2 = (zzdx)((zzdx$zza)((MlKitContext)object).get(zzdx$zza.class)).get(object2);
        this.zzj = object = SharedPrefManager.getInstance((MlKitContext)object);
        this.zzl = modelInfoRetrieverInterop;
        this.zzm = remoteModelFileManager;
    }

    public static RemoteModelDownloadManager getInstance(MlKitContext object, RemoteModel remoteModel, ModelFileHelper modelFileHelper, RemoteModelFileManager remoteModelFileManager, ModelInfoRetrieverInterop modelInfoRetrieverInterop) {
        Class<RemoteModelDownloadManager> clazz = RemoteModelDownloadManager.class;
        synchronized (clazz) {
            String string2 = remoteModel.getUniqueModelNameForPersist();
            Map map = zzb;
            boolean bl2 = map.containsKey(string2);
            if (!bl2) {
                RemoteModelDownloadManager remoteModelDownloadManager = new RemoteModelDownloadManager((MlKitContext)object, remoteModel, modelFileHelper, remoteModelFileManager, modelInfoRetrieverInterop);
                map.put(string2, remoteModelDownloadManager);
            }
            object = map.get(string2);
            object = (RemoteModelDownloadManager)object;
            return object;
        }
    }

    public static /* synthetic */ GmsLogger zza() {
        return zza;
    }

    public static /* synthetic */ MlKitException zza(RemoteModelDownloadManager remoteModelDownloadManager, Long l10) {
        return remoteModelDownloadManager.zza(l10);
    }

    private final MlKitException zza(Long object) {
        int n10;
        int n11;
        Object object2;
        Object object3;
        DownloadManager downloadManager = this.zzf;
        if (downloadManager != null && object != null) {
            long l10;
            object3 = new DownloadManager.Query();
            int n12 = 1;
            object2 = new long[n12];
            object2[0] = l10 = ((Long)object).longValue();
            object = object3.setFilterById((long[])object2);
            object = downloadManager.query((DownloadManager.Query)object);
        } else {
            n11 = 0;
            object = null;
        }
        int n13 = 13;
        if (object != null && (n10 = object.moveToFirst()) != 0) {
            object3 = "reason";
            n10 = object.getColumnIndex((String)object3);
            n11 = object.getInt(n10);
            if (n11 == (n10 = 1006)) {
                n13 = 101;
                object = "Model downloading failed due to insufficient space on the device.";
            } else {
                n10 = 84;
                object2 = new StringBuilder;
                ((StringBuilder)object2)(n10);
                object3 = "Model downloading failed due to error code: ";
                ((StringBuilder)object2).append((String)object3);
                ((StringBuilder)object2).append(n11);
                ((StringBuilder)object2).append(" from Android DownloadManager");
                object = ((StringBuilder)object2).toString();
            }
        } else {
            object = "Model downloading failed";
        }
        object3 = new MlKitException((String)object, n13);
        return object3;
    }

    public static /* synthetic */ MlKitContext zza(RemoteModelDownloadManager remoteModelDownloadManager) {
        return remoteModelDownloadManager.zze;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final RemoteModelDownloadManager$zza zza(long l10) {
        synchronized (this) {
            void var3_6;
            LongSparseArray longSparseArray = this.zzc;
            Object object = longSparseArray.get(l10);
            RemoteModelDownloadManager$zza remoteModelDownloadManager$zza = (RemoteModelDownloadManager$zza)((Object)object);
            if (remoteModelDownloadManager$zza == null) {
                RemoteModelDownloadManager$zza remoteModelDownloadManager$zza2;
                TaskCompletionSource taskCompletionSource = this.zzb(l10);
                RemoteModelDownloadManager$zza remoteModelDownloadManager$zza3 = remoteModelDownloadManager$zza2;
                remoteModelDownloadManager$zza2 = new RemoteModelDownloadManager$zza(this, l10, taskCompletionSource, null);
                LongSparseArray longSparseArray2 = this.zzc;
                longSparseArray2.put(l10, (Object)remoteModelDownloadManager$zza2);
            }
            return var3_6;
        }
    }

    private final Long zza(DownloadManager.Request object, ModelInfo object2) {
        synchronized (this) {
            DownloadManager downloadManager;
            block14: {
                downloadManager = this.zzf;
                if (downloadManager != null) break block14;
                return null;
            }
            long l10 = downloadManager.enqueue((DownloadManager.Request)object);
            object = zza;
            String string2 = "ModelDownloadManager";
            int n10 = 53;
            StringBuilder stringBuilder = new StringBuilder(n10);
            String string3 = "Schedule a new downloading task: ";
            stringBuilder.append(string3);
            stringBuilder.append(l10);
            string3 = stringBuilder.toString();
            ((GmsLogger)object).d(string2, string3);
            object = this.zzj;
            ((SharedPrefManager)object).setDownloadingModelInfo(l10, (ModelInfo)object2);
            object = this.zzi;
            object2 = object2.getModelType();
            int n11 = 4;
            n10 = 0;
            string3 = null;
            ((zzdx)object).zza(0, false, (ModelType)((Object)object2), n11);
            object = l10;
            return object;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final Long zza(ModelInfo object, DownloadConditions object2) {
        synchronized (this) {
            boolean bl2;
            int n10;
            String string2;
            boolean bl3;
            Object object3;
            Object object4 = "DownloadConditions can not be null";
            Preconditions.checkNotNull(object3, object4);
            object4 = this.zzj;
            Object object5 = this.zzg;
            object4 = ((SharedPrefManager)object4).getDownloadingModelHash((RemoteModel)object5);
            object5 = this.getDownloadingModelStatusCode();
            int n11 = 0;
            Object var6_6 = null;
            if (object4 != null && (bl3 = ((String)object4).equals(string2 = ((ModelInfo)object).getModelHash())) && object5 != null) {
                int n12;
                int n13;
                int n14;
                int n15;
                object = this.getDownloadingModelStatusCode();
                if (object != null && ((n15 = ((Integer)object).intValue()) == (n14 = 8) || (n13 = ((Integer)object).intValue()) == (n12 = 16))) {
                    n13 = 1;
                } else {
                    n13 = 0;
                    object = null;
                }
                if (n13 == 0) {
                    object = this.zzi;
                    object3 = this.zzg;
                    object3 = ((RemoteModel)object3).getModelType();
                    int n16 = 5;
                    ((zzdx)object).zza(0, false, (ModelType)((Object)object3), n16);
                }
                object = zza;
                object3 = "ModelDownloadManager";
                object4 = "New model is already in downloading, do nothing.";
                ((GmsLogger)object).d((String)object3, (String)object4);
                return null;
            }
            object4 = zza;
            object5 = "ModelDownloadManager";
            string2 = "Need to download a new model.";
            ((GmsLogger)object4).d((String)object5, string2);
            this.removeOrCancelDownload();
            string2 = ((ModelInfo)object).getModelUri();
            object5 = new DownloadManager.Request((Uri)string2);
            object5.setDestinationUri(null);
            ModelFileHelper modelFileHelper = this.zzk;
            string2 = ((ModelInfo)object).getModelNameForPersist();
            ModelType modelType = ((ModelInfo)object).getModelType();
            n11 = modelFileHelper.modelExistsLocally(string2, modelType);
            if (n11 != 0) {
                String string3 = "ModelDownloadManager";
                string2 = "Model update is enabled and have a previous downloaded model, use download condition";
                ((GmsLogger)object4).d(string3, string2);
                object4 = this.zzi;
                ModelType modelType2 = ((ModelInfo)object).getModelType();
                int n17 = 9;
                ((zzdx)object4).zza(0, false, modelType2, n17);
            }
            if ((n10 = Build.VERSION.SDK_INT) >= (n11 = 24)) {
                boolean bl4 = ((DownloadConditions)object3).isChargingRequired();
                object5.setRequiresCharging(bl4);
            }
            if (!(bl2 = ((DownloadConditions)object3).isWifiRequired())) return this.zza((DownloadManager.Request)object5, (ModelInfo)object);
            int n18 = 2;
            object5.setAllowedNetworkTypes(n18);
            return this.zza((DownloadManager.Request)object5, (ModelInfo)object);
        }
    }

    public static /* synthetic */ LongSparseArray zzb(RemoteModelDownloadManager remoteModelDownloadManager) {
        return remoteModelDownloadManager.zzc;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final TaskCompletionSource zzb(long l10) {
        synchronized (this) {
            void var3_6;
            LongSparseArray longSparseArray = this.zzd;
            Object object = longSparseArray.get(l10);
            TaskCompletionSource taskCompletionSource = (TaskCompletionSource)object;
            if (taskCompletionSource == null) {
                TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
                LongSparseArray longSparseArray2 = this.zzd;
                longSparseArray2.put(l10, (Object)taskCompletionSource2);
            }
            return var3_6;
        }
    }

    /*
     * Unable to fully structure code
     */
    private final ModelInfo zzb() {
        synchronized (this) {
            block44: {
                block48: {
                    block47: {
                        block46: {
                            block45: {
                                var1_1 = this.modelExistsLocally();
                                var2_2 = 0;
                                var3_3 = null;
                                if (var1_1 == 0) ** GOTO lbl18
                                var4_4 = this.zzi;
                                var5_5 = this.zzg;
                                var5_5 = var5_5.getModelType();
                                var6_6 = 8;
                                var4_4.zza(0, false, (ModelType)var5_5, var6_6);
lbl18:
                                // 2 sources

                                if ((var4_4 = this.zzl) == null) break block44;
                                var5_5 = this.zzg;
                                var4_4 = var4_4.retrieveRemoteModelInfo((RemoteModel)var5_5);
                                var5_5 = null;
                                if (var4_4 != null) break block45;
                                return null;
                            }
                            var7_7 = this.zze;
                            var8_8 = this.zzg;
                            var9_9 = var4_4.getModelHash();
                            var10_10 = SharedPrefManager.getInstance((MlKitContext)var7_7);
                            var8_8 = var10_10.getIncompatibleModelHash((RemoteModel)var8_8);
                            var11_11 = var9_9.equals(var8_8);
                            var12_12 = 1;
                            if (!var11_11) break block46;
                            var7_7 = var7_7.getApplicationContext();
                            var7_7 = CommonUtils.getAppVersion((Context)var7_7);
                            var8_8 = var10_10.getPreviousAppVersion();
                            var6_6 = (int)var7_7.equals(var8_8);
                            if (var6_6 == 0) break block46;
                            var6_6 = var12_12;
                            break block47;
                        }
                        var6_6 = 0;
                        var7_7 = null;
                    }
                    if (var6_6 != 0) {
                        var7_7 = RemoteModelDownloadManager.zza;
                        var8_8 = "ModelDownloadManager";
                        var10_10 = "The model is incompatible with TFLite and the app is not upgraded, do not download";
                        var7_7.e((String)var8_8, (String)var10_10);
                    } else {
                        var2_2 = var12_12;
                    }
                    if (var1_1 != 0) ** GOTO lbl72
                    var7_7 = this.zzj;
                    var8_8 = this.zzg;
                    var7_7.clearLatestModelHash((RemoteModel)var8_8);
lbl72:
                    // 2 sources

                    var7_7 = this.zze;
                    var8_8 = this.zzg;
                    var10_10 = var4_4.getModelHash();
                    var7_7 = SharedPrefManager.getInstance((MlKitContext)var7_7);
                    var7_7 = var7_7.getLatestModelHash((RemoteModel)var8_8);
                    var6_6 = var10_10.equals(var7_7) ^ var12_12;
                    if (var2_2 == 0 || var1_1 != 0 && var6_6 == 0) break block48;
                    return var4_4;
                }
                if (var1_1 != 0 && (var1_1 = var6_6 ^ var2_2) != 0) {
                    return null;
                }
                var3_3 = this.zzg;
                var3_3 = var3_3.getModelName();
                var4_4 = String.valueOf(var3_3);
                var14_15 = var4_4.length() + 46;
                var5_5 = new StringBuilder(var14_15);
                var4_4 = "The model ";
                var5_5.append((String)var4_4);
                var5_5.append((String)var3_3);
                var3_3 = " is incompatible with TFLite runtime";
                var5_5.append((String)var3_3);
                var3_3 = var5_5.toString();
                var14_15 = 100;
                var13_13 = new MlKitException((String)var3_3, var14_15);
                throw var13_13;
            }
            var3_3 = "Please include com.google.mlkit:linkfirebase sdk as your dependency when you try to download from Firebase.";
            var14_16 = 14;
            var13_13 = new MlKitException((String)var3_3, var14_16);
            throw var13_13;
        }
    }

    public static /* synthetic */ LongSparseArray zzc(RemoteModelDownloadManager remoteModelDownloadManager) {
        return remoteModelDownloadManager.zzd;
    }

    private final Task zzc(long l10) {
        RemoteModelDownloadManager$zza remoteModelDownloadManager$zza = this.zza(l10);
        Context context = this.zze.getApplicationContext();
        IntentFilter intentFilter = new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE");
        Handler handler = MLTaskExecutor.getInstance().getHandler();
        context.registerReceiver((BroadcastReceiver)remoteModelDownloadManager$zza, intentFilter, null, handler);
        return this.zzb(l10).getTask();
    }

    public static /* synthetic */ RemoteModel zzd(RemoteModelDownloadManager remoteModelDownloadManager) {
        return remoteModelDownloadManager.zzg;
    }

    public static /* synthetic */ zzdx zze(RemoteModelDownloadManager remoteModelDownloadManager) {
        return remoteModelDownloadManager.zzi;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Task ensureModelDownloaded() {
        Throwable throwable;
        Object object = this.zzi;
        ModelType modelType = ModelType.UNKNOWN;
        Object object2 = null;
        int n10 = 1;
        ((zzdx)object).zza(0, false, modelType, n10);
        object = null;
        try {
            ModelInfo modelInfo = this.zzb();
            throwable = null;
        }
        catch (MlKitException mlKitException) {
            Object var2_5 = null;
        }
        int n11 = 13;
        try {
            void var2_6;
            int n12;
            Integer n13 = this.getDownloadingModelStatusCode();
            Long l10 = this.getDownloadingId();
            int n14 = this.modelExistsLocally();
            if (n14 == 0 && (n13 == null || (n14 = n13.intValue()) != (n12 = 8))) {
                String string2;
                int n15;
                if (n13 != null && (n14 = n13.intValue()) == (n12 = 16)) {
                    object = this.zza(l10);
                    this.removeOrCancelDownload();
                    return Tasks.forException((Exception)object);
                }
                if (n13 == null || (n14 = n13.intValue()) != (n12 = 4) && (n14 = n13.intValue()) != (n12 = 2) && (n15 = n13.intValue()) != n10) {
                    n10 = 0;
                    string2 = null;
                }
                if (n10 != 0 && l10 != null && (string2 = this.getDownloadingModelHash()) != null) {
                    object = this.zzi;
                    RemoteModel remoteModel = this.zzg;
                    ModelType modelType2 = remoteModel.getModelType();
                    n10 = 5;
                    ((zzdx)object).zza(0, false, modelType2, n10);
                    long l11 = l10;
                    return this.zzc(l11);
                }
                if (var2_6 != null) {
                    object = this.zzn;
                    object = this.zza((ModelInfo)var2_6, (DownloadConditions)object);
                }
                if (object == null) {
                    String string3 = "Failed to schedule the download task";
                    object = new MlKitException(string3, n11, throwable);
                    return Tasks.forException((Exception)object);
                }
                long l12 = (Long)object;
                return this.zzc(l12);
            }
            if (var2_6 != null) {
                object2 = this.zzn;
                Long l13 = this.zza((ModelInfo)var2_6, (DownloadConditions)object2);
                if (l13 != null) {
                    long l14 = l13;
                    return this.zzc(l14);
                }
                GmsLogger gmsLogger = zza;
                object2 = "ModelDownloadManager";
                String string4 = "Didn't schedule download for the updated model";
                gmsLogger.i((String)object2, string4);
            }
            return Tasks.forResult(null);
        }
        catch (MlKitException mlKitException) {
            MlKitException mlKitException2 = new MlKitException("Failed to ensure the model is downloaded.", n11, mlKitException);
            return Tasks.forException(mlKitException2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ParcelFileDescriptor getDownloadedFile() {
        synchronized (this) {
            Object object = this.getDownloadingId();
            Object object2 = this.zzf;
            ParcelFileDescriptor parcelFileDescriptor = null;
            if (object2 == null) return null;
            if (object != null) {
                try {
                    long l10 = (Long)object;
                    return object2.openDownloadedFile(l10);
                }
                catch (FileNotFoundException fileNotFoundException) {
                    object = zza;
                    object2 = "ModelDownloadManager";
                    String string2 = "Downloaded file is not found";
                    ((GmsLogger)object).e((String)object2, string2);
                }
                return parcelFileDescriptor;
            }
            return null;
        }
    }

    public Long getDownloadingId() {
        synchronized (this) {
            Object object = this.zzj;
            RemoteModel remoteModel = this.zzg;
            object = ((SharedPrefManager)object).getDownloadingModelId(remoteModel);
            return object;
        }
    }

    public String getDownloadingModelHash() {
        synchronized (this) {
            Object object = this.zzj;
            RemoteModel remoteModel = this.zzg;
            object = ((SharedPrefManager)object).getDownloadingModelHash(remoteModel);
            return object;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Integer getDownloadingModelStatusCode() {
        synchronized (this) {
            Throwable throwable2;
            Long l10;
            block17: {
                Object object;
                block16: {
                    Object object2;
                    block15: {
                        int n10;
                        block14: {
                            int n11;
                            block13: {
                                long l11;
                                l10 = this.getDownloadingId();
                                object2 = this.zzf;
                                object = null;
                                if (object2 == null) return null;
                                if (l10 == null) {
                                    return null;
                                }
                                DownloadManager.Query query = new DownloadManager.Query();
                                n10 = 1;
                                long[] lArray = new long[n10];
                                lArray[0] = l11 = l10.longValue();
                                l10 = query.setFilterById(lArray);
                                if ((l10 = object2.query((DownloadManager.Query)l10)) != null) {
                                    n11 = l10.moveToFirst();
                                    if (n11 == 0) break block13;
                                    object2 = "status";
                                    n11 = l10.getColumnIndex((String)object2);
                                    n11 = l10.getInt(n11);
                                    object2 = n11;
                                    break block14;
                                }
                            }
                            n11 = 0;
                            object2 = null;
                        }
                        if (object2 == null) {
                            if (l10 == null) return null;
                            l10.close();
                            return null;
                        }
                        try {
                            int n12 = (Integer)object2;
                            int n13 = 2;
                            if (n12 == n13 || (n12 = ((Integer)object2).intValue()) == (n13 = 4) || (n12 = ((Integer)object2).intValue()) == n10 || (n12 = ((Integer)object2).intValue()) == (n10 = 8) || (n12 = ((Integer)object2).intValue()) == (n10 = 16)) break block15;
                            break block16;
                        }
                        catch (Throwable throwable2) {
                            break block17;
                        }
                    }
                    object = object2;
                }
                if (l10 == null) return object;
                l10.close();
                return object;
            }
            if (l10 == null) throw throwable2;
            try {
                l10.close();
                throw throwable2;
            }
            catch (Throwable throwable3) {
                zzan.zza(throwable2, throwable3);
            }
            throw throwable2;
        }
    }

    public int getFailureReason(Long l10) {
        int n10;
        int n11;
        Object object = this.zzf;
        int n12 = 0;
        if (object != null && l10 != null) {
            long l11;
            DownloadManager.Query query = new DownloadManager.Query();
            int n13 = 1;
            long[] lArray = new long[n13];
            lArray[0] = l11 = l10.longValue();
            l10 = query.setFilterById(lArray);
            l10 = object.query((DownloadManager.Query)l10);
        } else {
            l10 = null;
        }
        if (l10 != null && (n11 = l10.moveToFirst()) != 0 && (n11 = l10.getColumnIndex((String)(object = "reason"))) != (n10 = -1)) {
            n12 = l10.getInt(n11);
        }
        return n12;
    }

    public boolean isModelDownloadedAndValid() {
        String string2;
        Object object;
        Object object2 = "ModelDownloadManager";
        boolean bl2 = true;
        try {
            boolean bl3 = this.modelExistsLocally();
            if (bl3) {
                return bl2;
            }
        }
        catch (MlKitException mlKitException) {
            object = zza;
            string2 = "Failed to check if the model exist locally.";
            ((GmsLogger)object).d((String)object2, string2);
        }
        object = this.getDownloadingId();
        string2 = this.getDownloadingModelHash();
        if (object != null && string2 != null) {
            object = this.getDownloadingModelStatusCode();
            GmsLogger gmsLogger = zza;
            String string3 = String.valueOf(object);
            int n10 = String.valueOf(string3).length() + 22;
            StringBuilder stringBuilder = new StringBuilder(n10);
            String string4 = "Download Status code: ";
            stringBuilder.append(string4);
            stringBuilder.append(string3);
            string3 = stringBuilder.toString();
            gmsLogger.d((String)object2, string3);
            if (object == null) {
                this.removeOrCancelDownload();
                return false;
            }
            object2 = 8;
            boolean bl4 = Objects.equal(object, object2);
            if (bl4 && (object2 = this.zza(string2)) != null) {
                return bl2;
            }
            return false;
        }
        zza.d((String)object2, "No new model is downloading.");
        this.removeOrCancelDownload();
        return false;
    }

    public boolean modelExistsLocally() {
        ModelFileHelper modelFileHelper = this.zzk;
        String string2 = this.zzg.getUniqueModelNameForPersist();
        ModelType modelType = this.zzh;
        return modelFileHelper.modelExistsLocally(string2, modelType);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void removeOrCancelDownload() {
        synchronized (this) {
            Object object = this.getDownloadingId();
            Object object2 = this.zzf;
            if (object2 != null && object != null) {
                long l10;
                object2 = zza;
                String string2 = "ModelDownloadManager";
                String string3 = String.valueOf(object);
                String string4 = String.valueOf(string3);
                int n10 = string4.length() + 44;
                StringBuilder stringBuilder = new StringBuilder(n10);
                string4 = "Cancel or remove existing downloading task: ";
                stringBuilder.append(string4);
                stringBuilder.append(string3);
                string3 = stringBuilder.toString();
                ((GmsLogger)object2).d(string2, string3);
                object2 = this.zzf;
                int n11 = 1;
                long[] lArray = new long[n11];
                string3 = null;
                lArray[0] = l10 = ((Long)object).longValue();
                int n12 = object2.remove(lArray);
                if (n12 > 0 || (object = this.getDownloadingModelStatusCode()) == null) {
                    object = this.zzk;
                    object2 = this.zzg;
                    object2 = ((RemoteModel)object2).getUniqueModelNameForPersist();
                    RemoteModel remoteModel = this.zzg;
                    ModelType modelType = remoteModel.getModelType();
                    ((ModelFileHelper)object).deleteTempFilesInPrivateFolder((String)object2, modelType);
                    object = this.zzj;
                    object2 = this.zzg;
                    ((SharedPrefManager)object).clearDownloadingModelInfo((RemoteModel)object2);
                }
                return;
            }
            return;
        }
    }

    public void setDownloadConditions(DownloadConditions downloadConditions) {
        Preconditions.checkNotNull(downloadConditions, "DownloadConditions can not be null");
        this.zzn = downloadConditions;
    }

    public void updateLatestModelHashAndType(String string2) {
        synchronized (this) {
            SharedPrefManager sharedPrefManager = this.zzj;
            RemoteModel remoteModel = this.zzg;
            sharedPrefManager.setLatestModelHash(remoteModel, string2);
            this.removeOrCancelDownload();
            return;
        }
    }

    public final File zza(String object) {
        Object object2 = zza;
        Object object3 = "ModelDownloadManager";
        ((GmsLogger)object2).d((String)object3, "Model downloaded successfully");
        zzdx zzdx2 = this.zzi;
        Object object4 = this.zzh;
        boolean bl2 = true;
        int n10 = 6;
        zzdx2.zza(0, bl2, (ModelType)((Object)object4), n10);
        zzdx2 = this.getDownloadedFile();
        if (zzdx2 == null) {
            this.removeOrCancelDownload();
            return null;
        }
        object4 = "moving downloaded model from external storage to private folder.";
        ((GmsLogger)object2).d((String)object3, (String)object4);
        try {
            object2 = this.zzm;
            object3 = this.zzg;
            object = ((RemoteModelFileManager)object2).moveModelToPrivateFolder((ParcelFileDescriptor)zzdx2, (String)object, (RemoteModel)object3);
            return object;
        }
        finally {
            this.removeOrCancelDownload();
        }
    }
}

