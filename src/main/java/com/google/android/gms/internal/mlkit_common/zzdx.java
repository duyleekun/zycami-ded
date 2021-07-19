/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 */
package com.google.android.gms.internal.mlkit_common;

import android.os.SystemClock;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.mlkit_common.zzav$zzad;
import com.google.android.gms.internal.mlkit_common.zzav$zzad$zza;
import com.google.android.gms.internal.mlkit_common.zzav$zzak;
import com.google.android.gms.internal.mlkit_common.zzav$zzak$zza;
import com.google.android.gms.internal.mlkit_common.zzav$zzak$zzb;
import com.google.android.gms.internal.mlkit_common.zzav$zzal;
import com.google.android.gms.internal.mlkit_common.zzav$zzal$zza;
import com.google.android.gms.internal.mlkit_common.zzav$zzal$zzb;
import com.google.android.gms.internal.mlkit_common.zzav$zzal$zzc;
import com.google.android.gms.internal.mlkit_common.zzav$zzam;
import com.google.android.gms.internal.mlkit_common.zzav$zzam$zza;
import com.google.android.gms.internal.mlkit_common.zzav$zzbh;
import com.google.android.gms.internal.mlkit_common.zzav$zzbh$zza;
import com.google.android.gms.internal.mlkit_common.zzbf;
import com.google.android.gms.internal.mlkit_common.zzbg;
import com.google.android.gms.internal.mlkit_common.zzds;
import com.google.android.gms.internal.mlkit_common.zzdw;
import com.google.android.gms.internal.mlkit_common.zzdx$zza;
import com.google.android.gms.internal.mlkit_common.zzdy;
import com.google.android.gms.internal.mlkit_common.zzdz;
import com.google.android.gms.internal.mlkit_common.zzea;
import com.google.android.gms.internal.mlkit_common.zzeb;
import com.google.android.gms.internal.mlkit_common.zzfq;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component$Builder;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

public final class zzdx {
    public static final Component zza;
    private static final GmsLogger zzb;
    private final zzds zzc;
    private final RemoteModel zzd;
    private final SharedPrefManager zze;

    static {
        Object object = new GmsLogger("ModelDownloadLogger", "");
        zzb = object;
        object = Component.builder(zzdx$zza.class);
        Object object2 = Dependency.required(zzds.class);
        object = ((Component$Builder)object).add((Dependency)object2);
        object2 = Dependency.required(SharedPrefManager.class);
        object = ((Component$Builder)object).add((Dependency)object2);
        object2 = zzdw.zza;
        zza = ((Component$Builder)object).factory((ComponentFactory)object2).build();
    }

    private zzdx(zzds zzds2, SharedPrefManager sharedPrefManager, RemoteModel remoteModel) {
        this.zzc = zzds2;
        this.zzd = remoteModel;
        this.zze = sharedPrefManager;
    }

    public /* synthetic */ zzdx(zzds zzds2, SharedPrefManager sharedPrefManager, RemoteModel remoteModel, zzdy zzdy2) {
        this(zzds2, sharedPrefManager, remoteModel);
    }

    public static final /* synthetic */ zzdx$zza zza(ComponentContainer object) {
        zzds zzds2 = (zzds)object.get(zzds.class);
        object = (SharedPrefManager)object.get(SharedPrefManager.class);
        zzdx$zza zzdx$zza = new zzdx$zza(zzds2, (SharedPrefManager)object, null);
        return zzdx$zza;
    }

    private final void zza(zzbf object, String object2, boolean object3, boolean bl2, ModelType object4, zzav$zzak$zza object5, int n10) {
        Object object6;
        Object object7;
        Object object8 = this.zzd;
        String string2 = ((RemoteModel)object8).getModelHash();
        object4 = zzea.zza((ModelType)((Object)object4));
        zzav$zzam$zza zzav$zzam$zza = zzav$zzam.zza();
        Object object9 = zzav$zzal.zza();
        object8 = ((RemoteModel)object8).getModelNameForBackend();
        object8 = ((zzav$zzal$zza)object9).zza((String)object8);
        object9 = zzav$zzal$zzc.zza;
        object8 = ((zzav$zzal$zza)object8).zza((zzav$zzal$zzc)object9);
        if (string2 == null) {
            string2 = "";
        }
        object4 = ((zzav$zzal$zza)object8).zzb(string2).zza((zzav$zzal$zzb)object4);
        object4 = (zzav$zzam)((zzfq)zzav$zzam$zza.zza((zzav$zzal$zza)object4).zzg());
        object8 = zzav$zzak.zza();
        object = ((zzav$zzak$zzb)object8).zza((zzbf)object).zza((zzav$zzak$zza)object5);
        long l10 = n10;
        object = ((zzav$zzak$zzb)object).zzc(l10).zza((zzav$zzam)object4);
        object4 = "Model downloaded without its beginning time recorded.";
        object5 = "ModelDownloadLogger";
        long l11 = 0L;
        if (object3) {
            object7 = this.zze;
            RemoteModel remoteModel = this.zzd;
            long l12 = ((SharedPrefManager)object7).getModelDownloadBeginTimeMs(remoteModel);
            long l13 = l12 - l11;
            object3 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (!object3) {
                object7 = zzb;
                ((GmsLogger)object7).w((String)object5, (String)object4);
            } else {
                object7 = this.zze;
                remoteModel = this.zzd;
                long l14 = ((SharedPrefManager)object7).getModelFirstUseTimeMs(remoteModel);
                long l15 = l14 - l11;
                object3 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
                if (!object3) {
                    l14 = SystemClock.elapsedRealtime();
                    object7 = this.zze;
                    remoteModel = this.zzd;
                    ((SharedPrefManager)object7).setModelFirstUseTimeMs(remoteModel, l14);
                }
                ((zzav$zzak$zzb)object).zza(l14 -= l12);
            }
        }
        if (bl2) {
            object7 = this.zze;
            object6 = this.zzd;
            long l16 = ((SharedPrefManager)object7).getModelDownloadBeginTimeMs((RemoteModel)object6);
            long l17 = l16 - l11;
            n10 = (int)(l17 == 0L ? 0 : (l17 < 0L ? -1 : 1));
            if (n10 == 0) {
                object7 = zzb;
                ((GmsLogger)object7).w((String)object5, (String)object4);
            } else {
                long l18 = SystemClock.elapsedRealtime() - l16;
                ((zzav$zzak$zzb)object).zzb(l18);
            }
        }
        object7 = this.zzc;
        object6 = zzav$zzad.zzb();
        object2 = zzav$zzbh.zzb().zzd((String)object2);
        object = ((zzav$zzad$zza)object6).zza((zzav$zzbh$zza)object2).zza((zzav$zzak$zzb)object);
        object2 = zzbg.zza;
        ((zzds)object7).zza((zzav$zzad$zza)object, (zzbg)object2);
    }

    public final void zza(int n10, ModelType modelType, int n11) {
        zzbf zzbf2 = zzeb.zza(0);
        zzav$zzak$zza zzav$zzak$zza = zzdz.zza(6);
        this.zza(zzbf2, "NA", false, true, modelType, zzav$zzak$zza, 0);
    }

    public final void zza(int n10, boolean bl2, ModelType modelType, int n11) {
        zzbf zzbf2 = zzeb.zza(n10);
        zzav$zzak$zza zzav$zzak$zza = zzdz.zza(n11);
        this.zza(zzbf2, "NA", bl2, false, modelType, zzav$zzak$zza, 0);
    }

    public final void zza(boolean bl2, ModelType modelType, int n10) {
        zzbf zzbf2 = zzbf.zzn;
        zzav$zzak$zza zzav$zzak$zza = zzav$zzak$zza.zzh;
        this.zza(zzbf2, "NA", false, false, modelType, zzav$zzak$zza, n10);
    }
}

