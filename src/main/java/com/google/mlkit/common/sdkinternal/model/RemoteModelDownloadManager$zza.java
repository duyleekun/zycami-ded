/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 */
package com.google.mlkit.common.sdkinternal.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.mlkit_common.zzdx;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager;
import com.google.mlkit.common.sdkinternal.model.zzc;

public final class RemoteModelDownloadManager$zza
extends BroadcastReceiver {
    private final long zza;
    private final TaskCompletionSource zzb;
    private final /* synthetic */ RemoteModelDownloadManager zzc;

    private RemoteModelDownloadManager$zza(RemoteModelDownloadManager remoteModelDownloadManager, long l10, TaskCompletionSource taskCompletionSource) {
        this.zzc = remoteModelDownloadManager;
        this.zza = l10;
        this.zzb = taskCompletionSource;
    }

    public /* synthetic */ RemoteModelDownloadManager$zza(RemoteModelDownloadManager remoteModelDownloadManager, long l10, TaskCompletionSource taskCompletionSource, zzc zzc2) {
        this(remoteModelDownloadManager, l10, taskCompletionSource);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void onReceive(Context object, Intent object2) {
        block8: {
            int n10;
            Object object3;
            block9: {
                int n11;
                Object object4;
                Object object5;
                Object object6;
                long l10;
                object = "extra_download_id";
                long l11 = object2.getLongExtra((String)object, (long)-1);
                long l12 = l11 - (l10 = this.zza);
                Object object7 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object7 != false) {
                    return;
                }
                object3 = this.zzc.getDownloadingModelStatusCode();
                RemoteModelDownloadManager remoteModelDownloadManager = this.zzc;
                synchronized (remoteModelDownloadManager) {
                    try {
                        object6 = this.zzc;
                        object6 = RemoteModelDownloadManager.zza((RemoteModelDownloadManager)object6);
                        object6 = ((MlKitContext)object6).getApplicationContext();
                        object6.unregisterReceiver((BroadcastReceiver)this);
                    }
                    catch (IllegalArgumentException illegalArgumentException) {
                        object5 = RemoteModelDownloadManager.zza();
                        object4 = "ModelDownloadManager";
                        String string2 = "Exception thrown while trying to unregister the broadcast receiver for the download";
                        ((GmsLogger)object5).w((String)object4, string2, illegalArgumentException);
                    }
                    object6 = this.zzc;
                    object6 = RemoteModelDownloadManager.zzb((RemoteModelDownloadManager)object6);
                    long l13 = this.zza;
                    object6.remove(l13);
                    object6 = this.zzc;
                    object6 = RemoteModelDownloadManager.zzc((RemoteModelDownloadManager)object6);
                    l13 = this.zza;
                    object6.remove(l13);
                    // MONITOREXIT @DISABLED, blocks:[0, 3] lbl30 : MonitorExitStatement: MONITOREXIT : var9_8
                    remoteModelDownloadManager = null;
                    if (object3 == null) break block8;
                    int n12 = (Integer)object3;
                    if (n12 != (n11 = 16)) break block9;
                }
                object3 = RemoteModelDownloadManager.zze(this.zzc);
                object6 = RemoteModelDownloadManager.zzd(this.zzc).getModelType();
                object5 = this.zzc;
                object4 = l11;
                n11 = ((RemoteModelDownloadManager)object5).getFailureReason((Long)object4);
                ((zzdx)object3).zza(false, (ModelType)((Object)object6), n11);
                object3 = this.zzb;
                remoteModelDownloadManager = this.zzc;
                object = l11;
                object = RemoteModelDownloadManager.zza(remoteModelDownloadManager, (Long)object);
                ((TaskCompletionSource)object3).setException((Exception)object);
                return;
            }
            int n13 = (Integer)object3;
            if (n13 == (n10 = 8)) {
                object = RemoteModelDownloadManager.zze(this.zzc);
                object2 = RemoteModelDownloadManager.zzd(this.zzc).getModelType();
                ((zzdx)object).zza(0, (ModelType)((Object)object2), 6);
                this.zzb.setResult(null);
                return;
            }
        }
        object = RemoteModelDownloadManager.zze(this.zzc);
        object2 = RemoteModelDownloadManager.zzd(this.zzc).getModelType();
        ((zzdx)object).zza(false, (ModelType)((Object)object2), 0);
        object = this.zzb;
        object2 = new MlKitException("Model downloading failed", 13);
        ((TaskCompletionSource)object).setException((Exception)object2);
        return;
        {
            catch (Throwable throwable) {}
            throw throwable;
        }
    }
}

