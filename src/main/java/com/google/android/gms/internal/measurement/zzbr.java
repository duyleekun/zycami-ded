/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.BadParcelableException
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.NetworkOnMainThreadException
 *  android.os.RemoteException
 *  android.util.Log
 *  android.util.Pair
 */
package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.NetworkOnMainThreadException;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.DynamiteModule$LoadingException;
import com.google.android.gms.dynamite.DynamiteModule$VersionPolicy;
import com.google.android.gms.internal.measurement.zzaa;
import com.google.android.gms.internal.measurement.zzab;
import com.google.android.gms.internal.measurement.zzac;
import com.google.android.gms.internal.measurement.zzad;
import com.google.android.gms.internal.measurement.zzae;
import com.google.android.gms.internal.measurement.zzaf;
import com.google.android.gms.internal.measurement.zzag;
import com.google.android.gms.internal.measurement.zzah;
import com.google.android.gms.internal.measurement.zzai;
import com.google.android.gms.internal.measurement.zzaj;
import com.google.android.gms.internal.measurement.zzak;
import com.google.android.gms.internal.measurement.zzal;
import com.google.android.gms.internal.measurement.zzam;
import com.google.android.gms.internal.measurement.zzan;
import com.google.android.gms.internal.measurement.zzao;
import com.google.android.gms.internal.measurement.zzap;
import com.google.android.gms.internal.measurement.zzaq;
import com.google.android.gms.internal.measurement.zzar;
import com.google.android.gms.internal.measurement.zzas;
import com.google.android.gms.internal.measurement.zzat;
import com.google.android.gms.internal.measurement.zzau;
import com.google.android.gms.internal.measurement.zzav;
import com.google.android.gms.internal.measurement.zzaw;
import com.google.android.gms.internal.measurement.zzax;
import com.google.android.gms.internal.measurement.zzay;
import com.google.android.gms.internal.measurement.zzaz;
import com.google.android.gms.internal.measurement.zzba;
import com.google.android.gms.internal.measurement.zzbb;
import com.google.android.gms.internal.measurement.zzbc;
import com.google.android.gms.internal.measurement.zzbd;
import com.google.android.gms.internal.measurement.zzbe;
import com.google.android.gms.internal.measurement.zzbf;
import com.google.android.gms.internal.measurement.zzbg;
import com.google.android.gms.internal.measurement.zzbh;
import com.google.android.gms.internal.measurement.zzbi;
import com.google.android.gms.internal.measurement.zzbq;
import com.google.android.gms.internal.measurement.zzk;
import com.google.android.gms.internal.measurement.zzm;
import com.google.android.gms.internal.measurement.zzo;
import com.google.android.gms.internal.measurement.zzp;
import com.google.android.gms.internal.measurement.zzv;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzfd;
import com.google.android.gms.measurement.internal.zzgl;
import com.google.android.gms.measurement.internal.zzgm;
import com.google.android.gms.measurement.internal.zzht;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;

public final class zzbr {
    private static volatile zzbr zzc;
    private static Boolean zzh;
    public final Clock zza;
    public final ExecutorService zzb;
    private final String zzd;
    private final AppMeasurementSdk zze;
    private final List zzf;
    private int zzg;
    private boolean zzi;
    private final String zzj;
    private volatile zzp zzk;

    public zzbr(Context context, String object, String string2, String string3, Bundle bundle) {
        int n10;
        int n11;
        if (object != null && (n11 = zzbr.zzX(string2, string3)) != 0) {
            this.zzd = object;
        } else {
            object = "FA";
            this.zzd = object;
        }
        this.zza = object = DefaultClock.getInstance();
        object = com.google.android.gms.internal.measurement.zzk.zza();
        Object object2 = new zzav(this);
        int n12 = 1;
        this.zzb = object = object.zzb((ThreadFactory)object2, n12);
        this.zze = object = new AppMeasurementSdk(this);
        object = new ArrayList();
        this.zzf = object;
        try {
            object = zzfd.zza(context);
            object2 = "google_app_id";
        }
        catch (IllegalStateException illegalStateException) {}
        object = zzht.zzb(context, (String)object2, (String)object);
        if (object != null && (n10 = zzbr.zzT()) == 0) {
            this.zzj = null;
            this.zzi = n12;
            Log.w((String)this.zzd, (String)"Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
            return;
        }
        if ((n10 = zzbr.zzX(string2, string3)) == 0) {
            this.zzj = object = "fa";
            if (string2 != null && string3 != null) {
                object = this.zzd;
                object2 = "Deferring to Google Analytics for Firebase for event data collection. https://goo.gl/J1sWQy";
                Log.v((String)object, (String)object2);
            } else {
                n10 = 0;
                object = null;
                if (string2 == null) {
                    n11 = n12;
                } else {
                    n11 = 0;
                    object2 = null;
                }
                if (string3 != null) {
                    n12 = 0;
                }
                n10 = n11 ^ n12;
                if (n10 != 0) {
                    object = this.zzd;
                    object2 = "Specified origin or custom app id is null. Both parameters will be ignored.";
                    Log.w((String)object, (String)object2);
                }
            }
        } else {
            this.zzj = string2;
        }
        object = new zzak(this, string2, string3, context, bundle);
        this.zzU((zzbg)object);
        context = (Application)context.getApplicationContext();
        if (context == null) {
            Log.w((String)this.zzd, (String)"Unable to register lifecycle notifications. Application null.");
            return;
        }
        object = new zzbq(this);
        context.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)object);
    }

    public static /* synthetic */ boolean zzK(zzbr zzbr2) {
        return zzbr2.zzi;
    }

    public static /* synthetic */ void zzL(zzbr zzbr2, Exception exception, boolean bl2, boolean bl3) {
        zzbr2.zzV(exception, bl2, bl3);
    }

    public static /* synthetic */ boolean zzM(zzbr zzbr2, String string2, String string3) {
        return zzbr.zzX(string2, string3);
    }

    public static /* synthetic */ String zzN(zzbr zzbr2) {
        return zzbr2.zzd;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void zzO(Context context) {
        Boolean bl2 = Boolean.TRUE;
        Class<zzbr> clazz = zzbr.class;
        String string2 = "allow_remote_dynamite";
        synchronized (clazz) {
            Throwable throwable2;
            block13: {
                block11: {
                    boolean bl3;
                    Object object;
                    try {
                        block10: {
                            try {
                                object = zzh;
                                if (object == null) break block10;
                            }
                            catch (Exception exception) {
                                string2 = "FA";
                                object = "Exception reading flag from SharedPreferences.";
                                Log.e((String)string2, (String)object, (Throwable)exception);
                                zzh = bl2;
                                break block11;
                            }
                            return;
                        }
                        object = "app_measurement_internal_disable_startup_flags";
                        {
                            PackageManagerWrapper packageManagerWrapper;
                            block12: {
                                Preconditions.checkNotEmpty((String)object);
                                try {
                                    packageManagerWrapper = Wrappers.packageManager(context);
                                    String string3 = context.getPackageName();
                                    int n10 = 128;
                                    packageManagerWrapper = packageManagerWrapper.getApplicationInfo(string3, n10);
                                    if (packageManagerWrapper == null || (packageManagerWrapper = ((ApplicationInfo)packageManagerWrapper).metaData) == null || !(bl3 = packageManagerWrapper.getBoolean((String)object))) break block12;
                                    zzh = bl2;
                                }
                                catch (PackageManager.NameNotFoundException nameNotFoundException) {}
                                return;
                            }
                            object = "com.google.android.gms.measurement.prefs";
                            packageManagerWrapper = null;
                        }
                    }
                    catch (Throwable throwable2) {
                        break block13;
                    }
                    {
                        context = context.getSharedPreferences((String)object, 0);
                        bl3 = true;
                        bl3 = context.getBoolean(string2, bl3);
                        zzh = object = Boolean.valueOf(bl3);
                        context = context.edit();
                        context.remove(string2);
                        context.apply();
                    }
                }
                return;
            }
            throw throwable2;
        }
    }

    public static /* synthetic */ Boolean zzP() {
        return zzh;
    }

    public static /* synthetic */ zzp zzQ(zzbr zzbr2, zzp zzp2) {
        zzbr2.zzk = zzp2;
        return zzp2;
    }

    public static /* synthetic */ zzp zzR(zzbr zzbr2) {
        return zzbr2.zzk;
    }

    public static /* synthetic */ void zzS(zzbr zzbr2, zzbg zzbg2) {
        zzbr2.zzU(zzbg2);
    }

    public static final boolean zzT() {
        String string2 = "com.google.firebase.analytics.FirebaseAnalytics";
        try {
            Class.forName(string2);
            return true;
        }
        catch (ClassNotFoundException classNotFoundException) {
            return false;
        }
    }

    private final void zzU(zzbg zzbg2) {
        this.zzb.execute(zzbg2);
    }

    private final void zzV(Exception exception, boolean bl2, boolean bl3) {
        boolean bl4;
        this.zzi = bl4 = this.zzi | bl2;
        if (bl2) {
            Log.w((String)this.zzd, (String)"Data collection startup failed. No data will be collected.", (Throwable)exception);
            return;
        }
        String string2 = "Error with data collection. Data lost.";
        if (bl3) {
            int n10 = 5;
            this.zzC(n10, string2, exception, null, null);
        }
        Log.w((String)this.zzd, (String)string2, (Throwable)exception);
    }

    private final void zzW(String string2, String string3, Bundle bundle, boolean bl2, boolean bl3, Long l10) {
        zzbe zzbe2 = new zzbe(this, l10, string2, string3, bundle, bl2, bl3);
        this.zzU(zzbe2);
    }

    private static final boolean zzX(String string2, String string3) {
        boolean bl2;
        return string3 != null && string2 != null && !(bl2 = zzbr.zzT());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static zzbr zza(Context context, String string2, String string3, String string4, Bundle bundle) {
        Preconditions.checkNotNull(context);
        Object object = zzc;
        if (object != null) return zzc;
        object = zzbr.class;
        synchronized (object) {
            zzbr zzbr2 = zzc;
            if (zzbr2 != null) return zzc;
            zzc = zzbr2 = new zzbr(context, string2, string3, string4, bundle);
            return zzc;
        }
    }

    public final String zzA() {
        zzm zzm2 = new zzm();
        zzar zzar2 = new zzar(this, zzm2);
        this.zzU(zzar2);
        return zzm2.zzc(500L);
    }

    public final Map zzB(String string2, String hashMap, boolean bl2) {
        int n10;
        zzas zzas2;
        zzm zzm2 = new zzm();
        Object object = zzas2;
        Object object2 = this;
        zzas2 = new zzas(this, string2, (String)((Object)hashMap), bl2, zzm2);
        this.zzU(zzas2);
        long l10 = 5000L;
        string2 = zzm2.zzd(l10);
        if (string2 != null && (n10 = string2.size()) != 0) {
            boolean bl3;
            int n11 = string2.size();
            hashMap = new HashMap<Object, Object>(n11);
            Iterator iterator2 = string2.keySet().iterator();
            while (bl3 = iterator2.hasNext()) {
                object = (String)iterator2.next();
                object2 = string2.get((String)object);
                boolean bl4 = object2 instanceof Double;
                if (!bl4 && !(bl4 = object2 instanceof Long) && !(bl4 = object2 instanceof String)) continue;
                hashMap.put(object, object2);
            }
            return hashMap;
        }
        return Collections.emptyMap();
    }

    public final void zzC(int n10, String string2, Object object, Object object2, Object object3) {
        zzat zzat2 = new zzat(this, false, 5, string2, object, null, null);
        this.zzU(zzat2);
    }

    public final Bundle zzD(Bundle bundle, boolean bl2) {
        zzm zzm2 = new zzm();
        zzau zzau2 = new zzau(this, bundle, zzm2);
        this.zzU(zzau2);
        if (bl2) {
            return zzm2.zzd(5000L);
        }
        return null;
    }

    public final int zzE(String object) {
        Object object2 = new zzm();
        zzaw zzaw2 = new zzaw(this, (String)object, (zzm)object2);
        this.zzU(zzaw2);
        long l10 = 10000L;
        object = ((zzm)object2).zzd(l10);
        object2 = Integer.class;
        object = (Integer)zzm.zze((Bundle)object, (Class)object2);
        if (object == null) {
            return 25;
        }
        return (Integer)object;
    }

    public final String zzF() {
        zzm zzm2 = new zzm();
        zzax zzax2 = new zzax(this, zzm2);
        this.zzU(zzax2);
        return zzm2.zzc(120000L);
    }

    public final String zzG() {
        return this.zzj;
    }

    public final Object zzH(int n10) {
        zzm zzm2 = new zzm();
        zzay zzay2 = new zzay(this, zzm2, n10);
        this.zzU(zzay2);
        return zzm.zze(zzm2.zzd(15000L), Object.class);
    }

    public final void zzI(boolean bl2) {
        zzaz zzaz2 = new zzaz(this, bl2);
        this.zzU(zzaz2);
    }

    public final void zzJ(Bundle bundle) {
        zzba zzba2 = new zzba(this, bundle);
        this.zzU(zzba2);
    }

    public final AppMeasurementSdk zzb() {
        return this.zze;
    }

    public final zzp zzc(Context object, boolean bl2) {
        Object object2;
        if (bl2) {
            object2 = DynamiteModule.PREFER_HIGHEST_OR_REMOTE_VERSION;
        } else {
            object2 = DynamiteModule.PREFER_LOCAL;
        }
        String string2 = "com.google.android.gms.measurement.dynamite";
        try {
            object = DynamiteModule.load((Context)object, (DynamiteModule$VersionPolicy)object2, string2);
            object2 = "com.google.android.gms.measurement.internal.AppMeasurementDynamiteService";
        }
        catch (DynamiteModule$LoadingException dynamiteModule$LoadingException) {
            this.zzV(dynamiteModule$LoadingException, true, false);
            return null;
        }
        object = ((DynamiteModule)object).instantiate((String)object2);
        return zzo.asInterface((IBinder)object);
    }

    public final void zzd(zzgl object) {
        zzbh zzbh2 = new zzbh((zzgl)object);
        object = this.zzk;
        if (object != null) {
            object = this.zzk;
            try {
                object.setEventInterceptor(zzbh2);
                return;
            }
            catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException throwable) {
                object = this.zzd;
                String string2 = "Failed to set event interceptor on calling thread. Trying again on the dynamite thread.";
                Log.w((String)object, (String)string2);
            }
        }
        object = new zzbb(this, zzbh2);
        this.zzU((zzbg)object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zze(zzgm object) {
        Object object2;
        Preconditions.checkNotNull(object);
        Object object3 = this.zzf;
        synchronized (object3) {
            Object object4;
            int n10;
            object2 = null;
            for (int i10 = 0; i10 < (n10 = (object4 = this.zzf).size()); ++i10) {
                object4 = this.zzf;
                object4 = object4.get(i10);
                object4 = (Pair)object4;
                object4 = ((Pair)object4).first;
                n10 = (int)(object.equals(object4) ? 1 : 0);
                if (n10 == 0) continue;
                object = this.zzd;
                object2 = "OnEventListener already registered.";
                Log.w((String)object, (String)object2);
                return;
            }
            object2 = new zzbi((zzgm)object);
            object4 = this.zzf;
            Pair pair = new Pair(object, object2);
            object4.add(pair);
        }
        object = this.zzk;
        if (object != null) {
            try {
                object = this.zzk;
                object.registerOnMeasurementEventListener((zzv)object2);
                return;
            }
            catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException throwable) {
                object = this.zzd;
                object3 = "Failed to register event listener on calling thread. Trying again on the dynamite thread.";
                Log.w((String)object, (String)object3);
            }
        }
        object = new zzbc(this, (zzbi)object2);
        this.zzU((zzbg)object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zzf(zzgm object) {
        Object object2;
        Preconditions.checkNotNull(object);
        Object object3 = this.zzf;
        synchronized (object3) {
            block8: {
                Object object4;
                int n10;
                object2 = null;
                for (int i10 = 0; i10 < (n10 = (object4 = this.zzf).size()); ++i10) {
                    object4 = this.zzf;
                    object4 = object4.get(i10);
                    object4 = (Pair)object4;
                    object4 = ((Pair)object4).first;
                    n10 = (int)(object.equals(object4) ? 1 : 0);
                    if (n10 == 0) continue;
                    object = this.zzf;
                    object = object.get(i10);
                    object = (Pair)object;
                    break block8;
                }
                object = null;
            }
            if (object == null) {
                object = this.zzd;
                object2 = "OnEventListener had not been registered.";
                Log.w((String)object, (String)object2);
                return;
            }
            object2 = this.zzf;
            object2.remove(object);
            object = ((Pair)object).second;
            object = (zzbi)object;
        }
        object3 = this.zzk;
        if (object3 != null) {
            try {
                object3 = this.zzk;
                object3.unregisterOnMeasurementEventListener((zzv)object);
                return;
            }
            catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException throwable) {
                object3 = this.zzd;
                object2 = "Failed to unregister event listener on calling thread. Trying again on the dynamite thread.";
                Log.w((String)object3, (String)object2);
            }
        }
        object3 = new zzbd(this, (zzbi)object);
        this.zzU((zzbg)object3);
    }

    public final void zzg(String string2, Bundle bundle) {
        this.zzW(null, string2, bundle, false, true, null);
    }

    public final void zzh(String string2, String string3, Bundle bundle) {
        this.zzW(string2, string3, bundle, true, true, null);
    }

    public final void zzi(String string2, String string3, Bundle bundle, long l10) {
        Long l11 = l10;
        this.zzW(string2, string3, bundle, true, false, l11);
    }

    public final void zzj(String string2, String string3, Object object, boolean bl2) {
        zzbf zzbf2 = new zzbf(this, string2, string3, object, bl2);
        this.zzU(zzbf2);
    }

    public final void zzk(Bundle bundle) {
        zzaa zzaa2 = new zzaa(this, bundle);
        this.zzU(zzaa2);
    }

    public final void zzl(String string2, String string3, Bundle bundle) {
        zzab zzab2 = new zzab(this, string2, string3, bundle);
        this.zzU(zzab2);
    }

    public final List zzm(String list, String object) {
        zzm zzm2 = new zzm();
        zzac zzac2 = new zzac(this, (String)((Object)list), (String)object, zzm2);
        this.zzU(zzac2);
        long l10 = 5000L;
        list = zzm2.zzd(l10);
        object = List.class;
        list = (List)zzm.zze((Bundle)list, (Class)object);
        if (list == null) {
            list = Collections.emptyList();
        }
        return list;
    }

    public final void zzn(String string2) {
        zzad zzad2 = new zzad(this, string2);
        this.zzU(zzad2);
    }

    public final void zzo(Activity activity, String string2, String string3) {
        zzae zzae2 = new zzae(this, activity, string2, string3);
        this.zzU(zzae2);
    }

    public final void zzp(Boolean bl2) {
        zzaf zzaf2 = new zzaf(this, bl2);
        this.zzU(zzaf2);
    }

    public final void zzq(Bundle bundle) {
        zzag zzag2 = new zzag(this, bundle);
        this.zzU(zzag2);
    }

    public final void zzr(Bundle bundle) {
        zzah zzah2 = new zzah(this, bundle);
        this.zzU(zzah2);
    }

    public final void zzs() {
        zzai zzai2 = new zzai(this);
        this.zzU(zzai2);
    }

    public final void zzt(long l10) {
        zzaj zzaj2 = new zzaj(this, l10);
        this.zzU(zzaj2);
    }

    public final void zzu(String string2) {
        zzal zzal2 = new zzal(this, string2);
        this.zzU(zzal2);
    }

    public final void zzv(String string2) {
        zzam zzam2 = new zzam(this, string2);
        this.zzU(zzam2);
    }

    public final String zzw() {
        zzm zzm2 = new zzm();
        zzan zzan2 = new zzan(this, zzm2);
        this.zzU(zzan2);
        return zzm2.zzc(500L);
    }

    public final String zzx() {
        zzm zzm2 = new zzm();
        zzao zzao2 = new zzao(this, zzm2);
        this.zzU(zzao2);
        return zzm2.zzc(50);
    }

    public final long zzy() {
        long l10;
        Object object = new zzm();
        Object object2 = new zzap(this, (zzm)object);
        this.zzU((zzbg)object2);
        long l11 = 500L;
        object = ((zzm)object).zzd(l11);
        object2 = Long.class;
        object = (Long)zzm.zze((Bundle)object, (Class)object2);
        if (object == null) {
            int n10;
            l11 = System.nanoTime();
            Clock clock = this.zza;
            long l12 = clock.currentTimeMillis();
            object = new Random(l11 ^= l12);
            l10 = ((Random)object).nextLong();
            this.zzg = n10 = this.zzg + 1;
            long l13 = n10;
            l10 += l13;
        } else {
            l10 = (Long)object;
        }
        return l10;
    }

    public final String zzz() {
        zzm zzm2 = new zzm();
        zzaq zzaq2 = new zzaq(this, zzm2);
        this.zzU(zzaq2);
        return zzm2.zzc(500L);
    }
}

