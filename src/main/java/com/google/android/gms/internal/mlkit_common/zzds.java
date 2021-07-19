/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 */
package com.google.android.gms.internal.mlkit_common;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import com.google.android.gms.common.internal.LibraryVersion;
import com.google.android.gms.internal.mlkit_common.zzav$zzad;
import com.google.android.gms.internal.mlkit_common.zzav$zzad$zza;
import com.google.android.gms.internal.mlkit_common.zzav$zzbh;
import com.google.android.gms.internal.mlkit_common.zzav$zzbh$zza;
import com.google.android.gms.internal.mlkit_common.zzbg;
import com.google.android.gms.internal.mlkit_common.zzdr;
import com.google.android.gms.internal.mlkit_common.zzds$zza;
import com.google.android.gms.internal.mlkit_common.zzdt;
import com.google.android.gms.internal.mlkit_common.zzdu;
import com.google.android.gms.internal.mlkit_common.zzdv;
import com.google.android.gms.internal.mlkit_common.zzfq;
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
import java.util.concurrent.Executor;

public final class zzds {
    public static final Component zza;
    private static List zzb;
    private static boolean zzk = true;
    private static boolean zzl = true;
    private final String zzc;
    private final String zzd;
    private final zzds$zza zze;
    private final SharedPrefManager zzf;
    private final Task zzg;
    private final Task zzh;
    private final Map zzi;
    private final Map zzj;

    static {
        Component$Builder component$Builder = Component.builder(zzds.class);
        Object object = Dependency.required(Context.class);
        component$Builder = component$Builder.add((Dependency)object);
        object = Dependency.required(SharedPrefManager.class);
        component$Builder = component$Builder.add((Dependency)object);
        object = Dependency.required(zzds$zza.class);
        component$Builder = component$Builder.add((Dependency)object);
        object = zzdv.zza;
        zza = component$Builder.factory((ComponentFactory)object).build();
    }

    private zzds(Context object, SharedPrefManager object2, zzds$zza object3) {
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
        object3 = zzdr.zza;
        this.zzg = object = ((MLTaskExecutor)object).scheduleCallable((Callable)object3);
        object = MLTaskExecutor.getInstance();
        object2.getClass();
        object2 = zzdu.zza((SharedPrefManager)object2);
        this.zzh = object = ((MLTaskExecutor)object).scheduleCallable((Callable)object2);
    }

    public static final /* synthetic */ zzds zza(ComponentContainer object) {
        Context context = (Context)object.get(Context.class);
        SharedPrefManager sharedPrefManager = (SharedPrefManager)object.get(SharedPrefManager.class);
        object = (zzds$zza)object.get(zzds$zza.class);
        zzds zzds2 = new zzds(context, sharedPrefManager, (zzds$zza)object);
        return zzds2;
    }

    public static final /* synthetic */ String zza() {
        return LibraryVersion.getInstance().getVersion("common");
    }

    private static List zzb() {
        Class<zzds> clazz = zzds.class;
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

    public final void zza(zzav$zzad$zza zzav$zzad$zza, zzbg zzbg2) {
        Executor executor = MLTaskExecutor.workerThreadExecutor();
        zzdt zzdt2 = new zzdt(this, zzav$zzad$zza, zzbg2);
        executor.execute(zzdt2);
    }

    public final /* synthetic */ void zzb(zzav$zzad$zza zzhd2, zzbg object) {
        String string2;
        Object object2 = "NA";
        Object object3 = zzhd2.zza().zza();
        boolean bl2 = ((String)object2).equals(object3);
        if (bl2 || (bl2 = (string2 = "").equals(object3))) {
            object3 = object2;
        }
        object2 = zzav$zzbh.zzb();
        string2 = this.zzc;
        object2 = ((zzav$zzbh$zza)object2).zza(string2);
        string2 = this.zzd;
        object3 = ((zzav$zzbh$zza)object2).zzb(string2).zzd((String)object3);
        object2 = zzds.zzb();
        object3 = ((zzav$zzbh$zza)object3).zza((Iterable)object2).zzb(true);
        object2 = this.zzg;
        boolean bl3 = ((Task)object2).isSuccessful();
        if (bl3) {
            object2 = (String)this.zzg.getResult();
        } else {
            object2 = LibraryVersion.getInstance();
            string2 = "common";
            object2 = ((LibraryVersion)object2).getVersion(string2);
        }
        object3 = ((zzav$zzbh$zza)object3).zzc((String)object2);
        bl3 = zzl;
        if (bl3) {
            object2 = this.zzh;
            bl3 = ((Task)object2).isSuccessful();
            object2 = bl3 ? (String)this.zzh.getResult() : this.zzf.getMlSdkInstanceId();
            ((zzav$zzbh$zza)object3).zze((String)object2);
        }
        zzhd2.zza((zzbg)object).zza((zzav$zzbh$zza)object3);
        object = this.zze;
        zzhd2 = (zzav$zzad)((zzfq)zzhd2.zzg());
        object.zza((zzav$zzad)zzhd2);
    }
}

