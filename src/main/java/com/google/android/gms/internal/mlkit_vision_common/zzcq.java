/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.os.SystemClock
 */
package com.google.android.gms.internal.mlkit_vision_common;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.SystemClock;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import com.google.android.gms.common.internal.LibraryVersion;
import com.google.android.gms.internal.mlkit_vision_common.zzag;
import com.google.android.gms.internal.mlkit_vision_common.zzcp;
import com.google.android.gms.internal.mlkit_vision_common.zzcq$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzcq$zzb;
import com.google.android.gms.internal.mlkit_vision_common.zzcr;
import com.google.android.gms.internal.mlkit_vision_common.zzcs;
import com.google.android.gms.internal.mlkit_vision_common.zzct;
import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzad;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzad$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzbh;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzbh$zza;
import com.google.android.gms.tasks.Task;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component$Builder;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.sdkinternal.CommonUtils;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public final class zzcq {
    public static final Component zza;
    private static List zzb;
    private static boolean zzk = true;
    private static boolean zzl = true;
    private final String zzc;
    private final String zzd;
    private final zzcq$zzb zze;
    private final SharedPrefManager zzf;
    private final Task zzg;
    private final Task zzh;
    private final Map zzi;
    private final Map zzj;

    static {
        Component$Builder component$Builder = Component.builder(zzcq.class);
        Object object = Dependency.required(Context.class);
        component$Builder = component$Builder.add((Dependency)object);
        object = Dependency.required(SharedPrefManager.class);
        component$Builder = component$Builder.add((Dependency)object);
        object = Dependency.required(zzcq$zzb.class);
        component$Builder = component$Builder.add((Dependency)object);
        object = zzct.zza;
        zza = component$Builder.factory((ComponentFactory)object).build();
    }

    private zzcq(Context object, SharedPrefManager object2, zzcq$zzb object3) {
        Object object4 = new HashMap();
        this.zzi = object4;
        object4 = new HashMap();
        this.zzj = object4;
        this.zzc = object4 = object.getPackageName();
        object = CommonUtils.getAppVersion((Context)object);
        this.zzd = object;
        this.zzf = object2;
        this.zze = object3;
        object = MLTaskExecutor.getInstance();
        object3 = zzcp.zza;
        this.zzg = object = ((MLTaskExecutor)object).scheduleCallable((Callable)object3);
        object = MLTaskExecutor.getInstance();
        object2.getClass();
        object2 = zzcs.zza((SharedPrefManager)object2);
        this.zzh = object = ((MLTaskExecutor)object).scheduleCallable((Callable)object2);
    }

    public static final /* synthetic */ zzcq zza(ComponentContainer object) {
        Context context = (Context)object.get(Context.class);
        SharedPrefManager sharedPrefManager = (SharedPrefManager)object.get(SharedPrefManager.class);
        object = (zzcq$zzb)object.get(zzcq$zzb.class);
        zzcq zzcq2 = new zzcq(context, sharedPrefManager, (zzcq$zzb)object);
        return zzcq2;
    }

    public static final /* synthetic */ String zza() {
        return LibraryVersion.getInstance().getVersion("vision-common");
    }

    private static List zzb() {
        Class<zzcq> clazz = zzcq.class;
        synchronized (clazz) {
            ArrayList arrayList;
            Object object;
            block17: {
                object = zzb;
                if (object == null) break block17;
                return object;
            }
            object = Resources.getSystem();
            object = object.getConfiguration();
            object = ConfigurationCompat.getLocales((Configuration)object);
            int n10 = ((LocaleListCompat)object).size();
            zzb = arrayList = new ArrayList(n10);
            int n11 = 0;
            arrayList = null;
            while (true) {
                n10 = ((LocaleListCompat)object).size();
                if (n11 >= n10) break;
                Object object2 = ((LocaleListCompat)object).get(n11);
                List list = zzb;
                object2 = CommonUtils.languageTagFromLocale((Locale)object2);
                list.add(object2);
                ++n11;
                continue;
                break;
            }
            try {
                object = zzb;
                return object;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
            finally {
            }
        }
    }

    public final void zza(zzcq$zza object, zzag zzag2) {
        long l10 = SystemClock.elapsedRealtime();
        Object object2 = this.zzi.get(zzag2);
        boolean bl2 = true;
        if (object2 != null) {
            long l11 = (Long)this.zzi.get(zzag2);
            object2 = TimeUnit.SECONDS;
            long l12 = ((TimeUnit)((Object)object2)).toMillis(30);
            long l13 = (l11 = l10 - l11) - l12;
            Object object3 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object3 <= 0) {
                bl2 = false;
            }
        }
        if (!bl2) {
            return;
        }
        object2 = this.zzi;
        Object object4 = l10;
        object2.put((zzag)zzag2, (Long)object4);
        object = object.zza();
        object4 = MLTaskExecutor.workerThreadExecutor();
        zzcr zzcr2 = new zzcr(this, (zzr$zzad$zza)object, zzag2);
        object4.execute(zzcr2);
    }

    public final /* synthetic */ void zza(zzr$zzad$zza zzft2, zzag object) {
        String string2;
        Object object2 = "NA";
        Object object3 = zzft2.zza().zza();
        boolean bl2 = ((String)object2).equals(object3);
        if (bl2 || (bl2 = (string2 = "").equals(object3))) {
            object3 = object2;
        }
        object2 = zzr$zzbh.zzb();
        string2 = this.zzc;
        object2 = ((zzr$zzbh$zza)object2).zza(string2);
        string2 = this.zzd;
        object3 = ((zzr$zzbh$zza)object2).zzb(string2).zzd((String)object3);
        object2 = zzcq.zzb();
        object3 = ((zzr$zzbh$zza)object3).zza((Iterable)object2).zzb(true);
        object2 = this.zzg;
        boolean bl3 = ((Task)object2).isSuccessful();
        if (bl3) {
            object2 = (String)this.zzg.getResult();
        } else {
            object2 = LibraryVersion.getInstance();
            string2 = "vision-common";
            object2 = ((LibraryVersion)object2).getVersion(string2);
        }
        object3 = ((zzr$zzbh$zza)object3).zzc((String)object2);
        bl3 = zzl;
        if (bl3) {
            object2 = this.zzh;
            bl3 = ((Task)object2).isSuccessful();
            object2 = bl3 ? (String)this.zzh.getResult() : this.zzf.getMlSdkInstanceId();
            ((zzr$zzbh$zza)object3).zze((String)object2);
        }
        zzft2.zza((zzag)object).zza((zzr$zzbh$zza)object3);
        object = this.zze;
        zzft2 = (zzr$zzad)((zzej)zzft2.zzh());
        object.zza((zzr$zzad)zzft2);
    }
}

