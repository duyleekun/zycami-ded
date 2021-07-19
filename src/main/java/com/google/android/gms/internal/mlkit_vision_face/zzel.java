/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.os.SystemClock
 */
package com.google.android.gms.internal.mlkit_vision_face;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.SystemClock;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import com.google.android.gms.common.internal.LibraryVersion;
import com.google.android.gms.internal.mlkit_vision_face.zzab;
import com.google.android.gms.internal.mlkit_vision_face.zzau;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzab;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzab$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzad;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzad$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbh;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbh$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzcb;
import com.google.android.gms.internal.mlkit_vision_face.zzek;
import com.google.android.gms.internal.mlkit_vision_face.zzel$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzel$zzb;
import com.google.android.gms.internal.mlkit_vision_face.zzel$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzem;
import com.google.android.gms.internal.mlkit_vision_face.zzen;
import com.google.android.gms.internal.mlkit_vision_face.zzeo;
import com.google.android.gms.internal.mlkit_vision_face.zzgd;
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
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public final class zzel {
    public static final Component zza;
    private static List zzb;
    private static boolean zzk = true;
    private static boolean zzl = true;
    private final String zzc;
    private final String zzd;
    private final zzel$zzb zze;
    private final SharedPrefManager zzf;
    private final Task zzg;
    private final Task zzh;
    private final Map zzi;
    private final Map zzj;

    static {
        Component$Builder component$Builder = Component.builder(zzel.class);
        Object object = Dependency.required(Context.class);
        component$Builder = component$Builder.add((Dependency)object);
        object = Dependency.required(SharedPrefManager.class);
        component$Builder = component$Builder.add((Dependency)object);
        object = Dependency.required(zzel$zzb.class);
        component$Builder = component$Builder.add((Dependency)object);
        object = zzeo.zza;
        zza = component$Builder.factory((ComponentFactory)object).build();
    }

    private zzel(Context object, SharedPrefManager object2, zzel$zzb object3) {
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
        object3 = zzek.zza;
        this.zzg = object = ((MLTaskExecutor)object).scheduleCallable((Callable)object3);
        object = MLTaskExecutor.getInstance();
        object2.getClass();
        object2 = zzen.zza((SharedPrefManager)object2);
        this.zzh = object = ((MLTaskExecutor)object).scheduleCallable((Callable)object2);
    }

    private static long zza(List list, double d10) {
        double d11 = list.size();
        int n10 = Math.max((int)Math.ceil((d10 /= 100.0) * d11) + -1, 0);
        return (Long)list.get(n10);
    }

    public static final /* synthetic */ zzel zza(ComponentContainer object) {
        Context context = (Context)object.get(Context.class);
        SharedPrefManager sharedPrefManager = (SharedPrefManager)object.get(SharedPrefManager.class);
        object = (zzel$zzb)object.get(zzel$zzb.class);
        zzel zzel2 = new zzel(context, sharedPrefManager, (zzel$zzb)object);
        return zzel2;
    }

    public static final /* synthetic */ String zza() {
        return LibraryVersion.getInstance().getVersion("play-services-mlkit-face-detection");
    }

    private final boolean zza(zzcb enum_, long l10, long l11) {
        Object object = this.zzi.get(enum_);
        boolean bl2 = true;
        if (object == null) {
            return bl2;
        }
        object = this.zzi;
        long l12 = (Long)object.get(enum_);
        enum_ = TimeUnit.SECONDS;
        long l13 = (l10 -= l12) - (l12 = ((TimeUnit)enum_).toMillis(30));
        Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object2 > 0) {
            return bl2;
        }
        return false;
    }

    private static List zzb() {
        Class<zzel> clazz = zzel.class;
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

    public final void zza(zzbm$zzad$zza zzbm$zzad$zza, zzcb zzcb2) {
        Executor executor = MLTaskExecutor.workerThreadExecutor();
        zzem zzem2 = new zzem(this, zzbm$zzad$zza, zzcb2);
        executor.execute(zzem2);
    }

    public final void zza(zzel$zzc object, zzcb zzcb2) {
        long l10 = SystemClock.elapsedRealtime();
        long l11 = 30;
        Object object2 = this;
        Object object3 = zzcb2;
        boolean bl2 = this.zza(zzcb2, l10, l11);
        if (!bl2) {
            return;
        }
        object2 = this.zzi;
        object3 = l10;
        object2.put(zzcb2, object3);
        object = object.zza();
        this.zza((zzbm$zzad$zza)object, zzcb2);
    }

    public final void zza(Object iterator2, long l10, zzcb zzcb2, zzel$zza zzel$zza) {
        boolean bl2;
        Object object;
        boolean bl3 = zzk;
        if (!bl3) {
            return;
        }
        Object object2 = this.zzj;
        bl3 = object2.containsKey(zzcb2);
        if (!bl3) {
            object2 = this.zzj;
            object = zzab.zzh();
            object2.put(zzcb2, object);
        }
        object2 = (zzau)this.zzj.get(zzcb2);
        Object object3 = l10;
        object2.zza(iterator2, object3);
        long l11 = SystemClock.elapsedRealtime();
        long l12 = 30;
        object = this;
        boolean bl4 = this.zza(zzcb2, l11, l12);
        if (!bl4) {
            return;
        }
        Object object4 = this.zzi;
        iterator2 = l11;
        object4.put(zzcb2, iterator2);
        iterator2 = object2.zzf().iterator();
        while (bl2 = iterator2.hasNext()) {
            boolean bl5;
            object3 = iterator2.next();
            object4 = object2.zzb(object3);
            Collections.sort(object4);
            object = zzbm$zzab.zza();
            long l13 = 0L;
            double d10 = 0.0;
            Iterator iterator3 = object4.iterator();
            while (bl5 = iterator3.hasNext()) {
                Long l14 = (Long)iterator3.next();
                l12 = l14;
                l13 += l12;
            }
            int n10 = object4.size();
            long l15 = n10;
            object = ((zzbm$zzab$zza)object).zzc(l13 /= l15);
            l13 = zzel.zza((List)object4, 100.0);
            object = ((zzbm$zzab$zza)object).zza(l13);
            l13 = zzel.zza((List)object4, 75.0);
            object = ((zzbm$zzab$zza)object).zzf(l13);
            l13 = zzel.zza((List)object4, 50.0);
            object = ((zzbm$zzab$zza)object).zze(l13);
            l13 = zzel.zza((List)object4, 25.0);
            object = ((zzbm$zzab$zza)object).zzd(l13);
            d10 = 0.0;
            l13 = zzel.zza((List)object4, d10);
            object4 = (zzbm$zzab)((zzgd)((zzbm$zzab$zza)object).zzb(l13).zzh());
            object = object2.zzb(object3);
            int n11 = object.size();
            object3 = zzel$zza.zza(object3, n11, (zzbm$zzab)object4);
            this.zza((zzbm$zzad$zza)object3, zzcb2);
        }
        this.zzj.remove(zzcb2);
    }

    public final /* synthetic */ void zzb(zzbm$zzad$zza zzhn2, zzcb object) {
        String string2;
        Object object2 = "NA";
        Object object3 = zzhn2.zza().zza();
        boolean bl2 = ((String)object2).equals(object3);
        if (bl2 || (bl2 = (string2 = "").equals(object3))) {
            object3 = object2;
        }
        object2 = zzbm$zzbh.zzb();
        string2 = this.zzc;
        object2 = ((zzbm$zzbh$zza)object2).zza(string2);
        string2 = this.zzd;
        object3 = ((zzbm$zzbh$zza)object2).zzb(string2).zzd((String)object3);
        object2 = zzel.zzb();
        object3 = ((zzbm$zzbh$zza)object3).zza((Iterable)object2).zzb(true);
        object2 = this.zzg;
        boolean bl3 = ((Task)object2).isSuccessful();
        if (bl3) {
            object2 = (String)this.zzg.getResult();
        } else {
            object2 = LibraryVersion.getInstance();
            string2 = "play-services-mlkit-face-detection";
            object2 = ((LibraryVersion)object2).getVersion(string2);
        }
        object3 = ((zzbm$zzbh$zza)object3).zzc((String)object2);
        bl3 = zzl;
        if (bl3) {
            object2 = this.zzh;
            bl3 = ((Task)object2).isSuccessful();
            object2 = bl3 ? (String)this.zzh.getResult() : this.zzf.getMlSdkInstanceId();
            ((zzbm$zzbh$zza)object3).zze((String)object2);
        }
        zzhn2.zza((zzcb)object).zza((zzbm$zzbh$zza)object3);
        object = this.zze;
        zzhn2 = (zzbm$zzad)((zzgd)zzhn2.zzh());
        object.zza((zzbm$zzad)zzhn2);
    }
}

