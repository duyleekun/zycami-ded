/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.text.TextUtils
 */
package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.measurement.zzlc;
import com.google.android.gms.internal.measurement.zzll;
import com.google.android.gms.internal.measurement.zzlr;
import com.google.android.gms.internal.measurement.zzlx;
import com.google.android.gms.internal.measurement.zznb;
import com.google.android.gms.measurement.internal.zzae;
import com.google.android.gms.measurement.internal.zzaf;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzas;
import com.google.android.gms.measurement.internal.zzdv;
import com.google.android.gms.measurement.internal.zzdw;
import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzet;
import com.google.android.gms.measurement.internal.zzeu;
import com.google.android.gms.measurement.internal.zzew;
import com.google.android.gms.measurement.internal.zzex;
import com.google.android.gms.measurement.internal.zzf;
import com.google.android.gms.measurement.internal.zzfa;
import com.google.android.gms.measurement.internal.zzfi;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzge;
import com.google.android.gms.measurement.internal.zzgf;
import com.google.android.gms.measurement.internal.zzgg;
import com.google.android.gms.measurement.internal.zzgh;
import com.google.android.gms.measurement.internal.zzgi;
import com.google.android.gms.measurement.internal.zzgk;
import com.google.android.gms.measurement.internal.zzgl;
import com.google.android.gms.measurement.internal.zzgm;
import com.google.android.gms.measurement.internal.zzgp;
import com.google.android.gms.measurement.internal.zzgr;
import com.google.android.gms.measurement.internal.zzgt;
import com.google.android.gms.measurement.internal.zzgu;
import com.google.android.gms.measurement.internal.zzgv;
import com.google.android.gms.measurement.internal.zzgw;
import com.google.android.gms.measurement.internal.zzgx;
import com.google.android.gms.measurement.internal.zzgy;
import com.google.android.gms.measurement.internal.zzgz;
import com.google.android.gms.measurement.internal.zzha;
import com.google.android.gms.measurement.internal.zzhb;
import com.google.android.gms.measurement.internal.zzhc;
import com.google.android.gms.measurement.internal.zzhd;
import com.google.android.gms.measurement.internal.zzhe;
import com.google.android.gms.measurement.internal.zzhf;
import com.google.android.gms.measurement.internal.zzhg;
import com.google.android.gms.measurement.internal.zzhh;
import com.google.android.gms.measurement.internal.zzhi;
import com.google.android.gms.measurement.internal.zzhj;
import com.google.android.gms.measurement.internal.zzhk;
import com.google.android.gms.measurement.internal.zzhm;
import com.google.android.gms.measurement.internal.zzht;
import com.google.android.gms.measurement.internal.zzhu;
import com.google.android.gms.measurement.internal.zzib;
import com.google.android.gms.measurement.internal.zzjb;
import com.google.android.gms.measurement.internal.zzjp;
import com.google.android.gms.measurement.internal.zzjq;
import com.google.android.gms.measurement.internal.zzkg;
import com.google.android.gms.measurement.internal.zzkj;
import com.google.android.gms.measurement.internal.zzkk;
import com.google.android.gms.measurement.internal.zzr;
import com.google.android.gms.measurement.internal.zzz;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class zzhn
extends zzf {
    public zzhm zza;
    public final zzr zzb;
    public boolean zzc;
    private zzgl zzd;
    private final Set zze;
    private boolean zzf;
    private final AtomicReference zzg;
    private final Object zzh;
    private zzaf zzi;
    private int zzj;
    private final AtomicLong zzk;
    private long zzl;
    private int zzm;
    private final zzkj zzn;

    public zzhn(zzfl zzfl2) {
        super(zzfl2);
        int n10;
        Object object = new CopyOnWriteArraySet();
        this.zze = object;
        this.zzh = object = new Object();
        this.zzc = true;
        this.zzn = object = new zzhc(this);
        object = new AtomicReference();
        this.zzg = object;
        this.zzi = object = new zzaf(null, null);
        this.zzj = n10 = 100;
        this.zzl = -1;
        this.zzm = n10;
        this.zzk = object = new AtomicLong(0L);
        this.zzb = object = new zzr(zzfl2);
    }

    public static /* synthetic */ void zzV(zzhn zzhn2, Boolean bl2, boolean bl3) {
        zzhn2.zzY(bl2, true);
    }

    public static /* synthetic */ void zzW(zzhn object, zzaf atomicReference, int n10, long l10, boolean bl2, boolean bl3) {
        ((zzge)object).zzg();
        ((zzf)object).zzb();
        long l11 = ((zzhn)object).zzl;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 <= 0 && (l12 = (long)zzaf.zzm(((zzhn)object).zzm, n10)) != false) {
            ((zzge)object).zzx.zzat().zzi().zzb("Dropped out-of-date consent setting, proposed settings", atomicReference);
            return;
        }
        zzex zzex2 = ((zzge)object).zzx.zzd();
        zzlc.zzb();
        Object object2 = zzex2.zzx.zzc();
        zzdv zzdv2 = zzdw.zzaw;
        boolean bl4 = ((zzae)object2).zzn(null, zzdv2);
        if (bl4) {
            object2 = zzex2.zzx;
            zzex2.zzg();
            bl4 = zzex2.zzh(n10);
            if (bl4) {
                zzex2 = zzex2.zzd().edit();
                atomicReference = ((zzaf)((Object)atomicReference)).zzd();
                object2 = "consent_settings";
                zzex2.putString((String)object2, (String)((Object)atomicReference));
                zzex2.putInt("consent_source", n10);
                zzex2.apply();
                ((zzhn)object).zzl = l10;
                ((zzhn)object).zzm = n10;
                atomicReference = ((zzge)object).zzx.zzy();
                ((zzjb)((Object)atomicReference)).zzj(bl2);
                if (bl3) {
                    object = ((zzge)object).zzx.zzy();
                    atomicReference = new AtomicReference();
                    ((zzjb)object).zzv(atomicReference);
                }
                return;
            }
        }
        object = ((zzge)object).zzx.zzat().zzi();
        atomicReference = n10;
        ((zzeg)object).zzb("Lower precedence consent source ignored, proposed source", atomicReference);
    }

    public static /* synthetic */ void zzX(zzhn zzhn2) {
        zzhn2.zzZ();
    }

    private final void zzY(Boolean bl2, boolean bl3) {
        boolean bl4;
        zzgg zzgg2;
        ((zzge)this).zzg();
        this.zzb();
        this.zzx.zzat().zzj().zzb("Setting app measurement enabled (FE)", bl2);
        this.zzx.zzd().zze(bl2);
        zzlc.zzb();
        Object object = this.zzx.zzc();
        zzdv zzdv2 = zzdw.zzaw;
        boolean bl5 = ((zzae)object).zzn(null, zzdv2);
        if (bl5 && bl3) {
            zzgg2 = this.zzx.zzd();
            zzlc.zzb();
            object = ((zzge)zzgg2).zzx.zzc();
            bl5 = ((zzae)object).zzn(null, zzdv2);
            if (bl5) {
                object = ((zzge)zzgg2).zzx;
                ((zzge)zzgg2).zzg();
                zzgg2 = ((zzex)zzgg2).zzd().edit();
                object = "measurement_enabled_from_api";
                if (bl2 != null) {
                    boolean bl6 = bl2;
                    zzgg2.putBoolean((String)object, bl6);
                } else {
                    zzgg2.remove((String)object);
                }
                zzgg2.apply();
            }
        }
        zzlc.zzb();
        zzgg2 = this.zzx.zzc();
        bl3 = ((zzae)zzgg2).zzn(null, zzdv2);
        if (bl3 && !(bl3 = ((zzfl)(zzgg2 = this.zzx)).zzI()) && (bl2 == null || (bl4 = bl2.booleanValue()))) {
            return;
        }
        this.zzZ();
    }

    private final void zzZ() {
        long l10;
        boolean bl2;
        Object object;
        Object object2;
        ((zzge)this).zzg();
        Object object3 = this.zzx.zzd().zzm.zza();
        long l11 = 0L;
        if (object3 != null) {
            object2 = "unset";
            boolean bl3 = ((String)object2).equals(object3);
            if (bl3) {
                Object var6_5 = null;
                object3 = this.zzx.zzax();
                long l12 = object3.currentTimeMillis();
                String string2 = "app";
                String string3 = "_npa";
                object = this;
                this.zzB(string2, string3, null, l12);
            } else {
                bl3 = true;
                object = "true";
                bl2 = ((String)object).equals(object3);
                l10 = bl3 != bl2 ? l11 : 1L;
                Long l13 = l10;
                object3 = this.zzx.zzax();
                long l14 = object3.currentTimeMillis();
                String string4 = "app";
                String string5 = "_npa";
                zzhn zzhn2 = this;
                this.zzB(string4, string5, l13, l14);
            }
        }
        if ((bl2 = ((zzfl)(object3 = this.zzx)).zzF()) && (bl2 = this.zzc)) {
            Object object4;
            this.zzx.zzat().zzj().zza("Recording app launch after enabling measurement for the first time (FE)");
            this.zzH();
            zzlx.zzb();
            object3 = this.zzx.zzc();
            object2 = zzdw.zzao;
            object = null;
            bl2 = ((zzae)object3).zzn(null, (zzdv)object2);
            if (bl2) {
                object3 = this.zzx.zzh().zza;
                ((zzjp)object3).zza();
            }
            zzlr.zzb();
            object3 = this.zzx.zzc();
            object2 = zzdw.zzar;
            bl2 = ((zzae)object3).zzn(null, (zzdv)object2);
            if (bl2) {
                object3 = this.zzx.zzi();
                Preconditions.checkNotNull(object3);
                object2 = object3.zza.zzd().zzi;
                l10 = ((zzeu)object2).zza();
                long l15 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                if (l15 <= 0) {
                    object4 = ((zzfa)object3).zza.zzaw().getPackageName();
                    ((zzfa)object3).zza((String)object4);
                }
            }
            object3 = this.zzx.zzau();
            object4 = new zzgr(this);
            ((zzfi)object3).zzh((Runnable)object4);
            return;
        }
        this.zzx.zzat().zzj().zza("Updating Scion state (FE)");
        this.zzx.zzy().zzi();
    }

    public final void zzA(String string2, String string3, long l10, Object object) {
        zzfi zzfi2 = this.zzx.zzau();
        zzgu zzgu2 = new zzgu(this, string2, string3, object, l10);
        zzfi2.zzh(zzgu2);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final void zzB(String var1_1, String var2_2, Object var3_3, long var4_4) {
        block5: {
            Preconditions.checkNotEmpty(var1_1);
            Preconditions.checkNotEmpty((String)var2_2);
            this.zzg();
            this.zzb();
            var6_5 = "allow_personalized_ads";
            var7_6 = var6_5.equals(var2_2);
            var8_7 = "_npa";
            if (!var7_6) ** GOTO lbl-1000
            var7_6 = var3_3 instanceof String;
            if (!var7_6) break block5;
            var6_5 = var3_3;
            var6_5 = (String)var3_3;
            var9_8 /* !! */  = TextUtils.isEmpty((CharSequence)var6_5);
            if (var9_8 /* !! */ ) break block5;
            var10_9 = true;
            var3_3 = Locale.ENGLISH;
            var3_3 = var6_5.toLowerCase((Locale)var3_3);
            var6_5 = "false";
            var11_10 = var6_5.equals(var3_3);
            var12_11 = 1L;
            var14_12 = var10_9 != var11_10 ? 0L : var12_11;
            var3_3 = var14_12;
            var2_2 = this.zzx.zzd().zzm;
            var16_13 = var3_3.longValue();
            cfr_temp_0 = var16_13 - var12_11;
            var9_8 /* !! */  = cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1);
            if (!var9_8 /* !! */ ) {
                var6_5 = "true";
            }
            var2_2.zzb((String)var6_5);
            ** GOTO lbl38
        }
        if (var3_3 == null) {
            var2_2 = this.zzx.zzd().zzm;
            var6_5 = "unset";
            var2_2.zzb((String)var6_5);
lbl38:
            // 2 sources

            var18_14 = var3_3;
            var19_15 = var8_7;
        } else lbl-1000:
        // 2 sources

        {
            var19_15 = var2_2;
            var18_14 = var3_3;
        }
        var2_2 = this.zzx;
        var10_9 = var2_2.zzF();
        if (!var10_9) {
            this.zzx.zzat().zzk().zza("User property not set since app measurement is disabled");
            return;
        }
        var2_2 = this.zzx;
        var10_9 = var2_2.zzL();
        if (!var10_9) {
            return;
        }
        var16_13 = var4_4;
        var2_2 = new zzkg(var19_15, var4_4, var18_14, var1_1);
        this.zzx.zzy().zzs((zzkg)var2_2);
    }

    public final List zzC(boolean bl2) {
        this.zzb();
        Object object = this.zzx.zzat().zzk();
        Object object2 = "Getting user properties (FE)";
        ((zzeg)object).zza((String)object2);
        object = this.zzx.zzau();
        boolean bl3 = ((zzfi)object).zzd();
        if (!bl3) {
            object = this.zzx;
            ((zzfl)object).zzas();
            bl3 = zzz.zza();
            if (bl3) {
                this.zzx.zzat().zzb().zza("Cannot get all user properties from main thread");
                return Collections.emptyList();
            }
            AtomicReference atomicReference = new AtomicReference();
            object = this.zzx.zzau();
            zzgv zzgv2 = new zzgv(this, atomicReference, bl2);
            long l10 = 5000L;
            String string2 = "get user properties";
            object2 = atomicReference;
            ((zzfi)object).zzi(atomicReference, l10, string2, zzgv2);
            object = (List)atomicReference.get();
            if (object == null) {
                object = this.zzx.zzat().zzb();
                Boolean bl4 = bl2;
                ((zzeg)object).zzb("Timed out waiting for get user properties, includeInternal", bl4);
                return Collections.emptyList();
            }
            return object;
        }
        this.zzx.zzat().zzb().zza("Cannot get all user properties from analytics worker thread");
        return Collections.emptyList();
    }

    public final String zzD() {
        return (String)this.zzg.get();
    }

    public final void zzE(String string2) {
        this.zzg.set(string2);
    }

    public final void zzF(long l10) {
        this.zzg.set(null);
        zzfi zzfi2 = this.zzx.zzau();
        zzgw zzgw2 = new zzgw(this, l10);
        zzfi2.zzh(zzgw2);
    }

    public final void zzG(long l10, boolean bl2) {
        ((zzge)this).zzg();
        this.zzb();
        this.zzx.zzat().zzj().zza("Resetting analytics data (FE)");
        zzgg zzgg2 = this.zzx.zzh();
        ((zzge)zzgg2).zzg();
        Object object = ((zzjq)zzgg2).zza;
        ((zzjq)zzgg2).zzb.zzc();
        zzgg2 = this.zzx;
        boolean bl3 = ((zzfl)zzgg2).zzF();
        object = this.zzx.zzd();
        Object object2 = ((zzex)object).zzh;
        ((zzeu)object2).zzb(l10);
        Object object3 = object.zzx.zzd().zzt.zza();
        boolean bl4 = TextUtils.isEmpty((CharSequence)object3);
        if (!bl4) {
            object3 = ((zzex)object).zzt;
            ((zzew)object3).zzb(null);
        }
        zzlx.zzb();
        object3 = ((zzge)object).zzx.zzc();
        object2 = zzdw.zzao;
        bl4 = ((zzae)object3).zzn(null, (zzdv)object2);
        long l11 = 0L;
        if (bl4) {
            object3 = ((zzex)object).zzo;
            ((zzeu)object3).zzb(l11);
        }
        if (!(bl4 = ((zzae)(object3 = ((zzge)object).zzx.zzc())).zzr())) {
            bl4 = bl3 ^ true;
            ((zzex)object).zzj(bl4);
        }
        ((zzex)object).zzu.zzb(null);
        ((zzex)object).zzv.zzb(l11);
        object3 = ((zzex)object).zzw;
        ((zzet)object3).zzb(null);
        if (bl2) {
            object3 = this.zzx.zzy();
            ((zzjb)object3).zzu();
        }
        zzlx.zzb();
        object3 = this.zzx.zzc();
        bl4 = ((zzae)object3).zzn(null, (zzdv)object2);
        if (bl4) {
            object3 = this.zzx.zzh().zza;
            ((zzjp)object3).zza();
        }
        this.zzc = bl4 = bl3 ^ true;
    }

    public final void zzH() {
        ((zzge)this).zzg();
        this.zzb();
        Object object = this.zzx;
        boolean bl2 = ((zzfl)object).zzL();
        if (bl2) {
            object = this.zzx.zzc();
            Object object2 = zzdw.zzab;
            String string2 = null;
            bl2 = ((zzae)object).zzn(null, (zzdv)object2);
            if (bl2) {
                object = this.zzx.zzc();
                ((zzge)object).zzx.zzas();
                object2 = "google_analytics_deferred_deep_link_enabled";
                object = ((zzae)object).zzp((String)object2);
                if (object != null && (bl2 = ((Boolean)object).booleanValue())) {
                    this.zzx.zzat().zzj().zza("Deferred Deep Link feature enabled.");
                    object = this.zzx.zzau();
                    object2 = new zzgp(this);
                    ((zzfi)object).zzh((Runnable)object2);
                }
            }
            this.zzx.zzy().zzy();
            bl2 = false;
            this.zzc = false;
            object = this.zzx.zzd();
            ((zzge)object).zzg();
            object2 = ((zzex)object).zzd();
            String string3 = "previous_os_version";
            object2 = object2.getString(string3, null);
            ((zzge)object).zzx.zzz().zzv();
            string2 = Build.VERSION.RELEASE;
            boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
            if (!bl3 && !(bl3 = string2.equals(object2))) {
                object = ((zzex)object).zzd().edit();
                object.putString(string3, string2);
                object.apply();
            }
            if (!(bl2 = TextUtils.isEmpty((CharSequence)object2))) {
                object = this.zzx.zzz();
                ((zzgf)object).zzv();
                bl2 = ((String)object2).equals(string2);
                if (!bl2) {
                    object = new Bundle();
                    object.putString("_po", (String)object2);
                    object2 = "auto";
                    string2 = "_ou";
                    this.zzs((String)object2, string2, (Bundle)object);
                }
            }
        }
    }

    public final void zzI(zzgl zzgl2) {
        zzgl zzgl3;
        ((zzge)this).zzg();
        this.zzb();
        if (zzgl2 != null && zzgl2 != (zzgl3 = this.zzd)) {
            boolean bl2;
            if (zzgl3 == null) {
                bl2 = true;
            } else {
                bl2 = false;
                zzgl3 = null;
            }
            String string2 = "EventInterceptor already set.";
            Preconditions.checkState(bl2, string2);
        }
        this.zzd = zzgl2;
    }

    public final void zzJ(zzgm object) {
        this.zzb();
        Preconditions.checkNotNull(object);
        Object object2 = this.zze;
        boolean bl2 = object2.add(object);
        if (!bl2) {
            object = this.zzx.zzat().zze();
            object2 = "OnEventListener already registered";
            ((zzeg)object).zza((String)object2);
        }
    }

    public final void zzK(zzgm object) {
        this.zzb();
        Preconditions.checkNotNull(object);
        Object object2 = this.zze;
        boolean bl2 = object2.remove(object);
        if (!bl2) {
            object = this.zzx.zzat().zze();
            object2 = "OnEventListener had not been registered";
            ((zzeg)object).zza((String)object2);
        }
    }

    public final int zzL(String string2) {
        Preconditions.checkNotEmpty(string2);
        this.zzx.zzc();
        return 25;
    }

    public final void zzM(Bundle bundle) {
        long l10 = this.zzx.zzax().currentTimeMillis();
        this.zzN(bundle, l10);
    }

    public final void zzN(Bundle object, long l10) {
        String string2;
        Object object2 = Long.class;
        Object object3 = String.class;
        Preconditions.checkNotNull(object);
        Bundle bundle = new Bundle((Bundle)object);
        object = "app_id";
        Object object4 = bundle.getString((String)object);
        boolean bl2 = TextUtils.isEmpty((CharSequence)object4);
        if (!bl2) {
            object4 = this.zzx.zzat().zze();
            string2 = "Package name should be null when calling setConditionalUserProperty";
            ((zzeg)object4).zza(string2);
        }
        bundle.remove((String)object);
        Preconditions.checkNotNull(bundle);
        bl2 = false;
        object4 = null;
        zzgh.zzb(bundle, (String)object, object3, null);
        object = "origin";
        zzgh.zzb(bundle, (String)object, object3, null);
        string2 = "name";
        zzgh.zzb(bundle, string2, object3, null);
        String string3 = "value";
        zzgh.zzb(bundle, string3, Object.class, null);
        String string4 = "trigger_event_name";
        zzgh.zzb(bundle, string4, object3, null);
        long l11 = 0L;
        Long l12 = l11;
        String string5 = "trigger_timeout";
        zzgh.zzb(bundle, string5, object2, l12);
        zzgh.zzb(bundle, "timed_out_event_name", object3, null);
        zzgh.zzb(bundle, "timed_out_event_params", Bundle.class, null);
        zzgh.zzb(bundle, "triggered_event_name", object3, null);
        String string6 = "triggered_event_params";
        zzgh.zzb(bundle, string6, Bundle.class, null);
        String string7 = "time_to_live";
        zzgh.zzb(bundle, string7, object2, l12);
        zzgh.zzb(bundle, "expired_event_name", object3, null);
        object3 = "expired_event_params";
        zzgh.zzb(bundle, (String)object3, Bundle.class, null);
        object2 = bundle.getString(string2);
        Preconditions.checkNotEmpty((String)object2);
        Preconditions.checkNotEmpty(bundle.getString((String)object));
        Preconditions.checkNotNull(bundle.get(string3));
        bundle.putLong("creation_timestamp", l10);
        object = bundle.getString(string2);
        Object object5 = bundle.get(string3);
        Object object6 = this.zzx.zzl();
        int n10 = ((zzkk)object6).zzo((String)object);
        if (n10 == 0) {
            object6 = this.zzx.zzl();
            n10 = ((zzkk)object6).zzJ((String)object, object5);
            if (n10 == 0) {
                object6 = this.zzx.zzl().zzK((String)object, object5);
                if (object6 == null) {
                    object6 = this.zzx.zzat().zzb();
                    object = this.zzx.zzm().zze((String)object);
                    ((zzeg)object6).zzc("Unable to normalize conditional user property value", object, object5);
                    return;
                }
                zzgh.zza(bundle, object6);
                l10 = bundle.getLong(string5);
                object2 = bundle.getString(string4);
                int n11 = TextUtils.isEmpty((CharSequence)object2);
                long l13 = 1L;
                long l14 = 15552000000L;
                if (n11 == 0) {
                    object2 = this.zzx;
                    ((zzfl)object2).zzc();
                    n11 = l10 == l14 ? 0 : (l10 < l14 ? -1 : 1);
                    if (n11 > 0 || (n11 = (int)(l10 == l13 ? 0 : (l10 < l13 ? -1 : 1))) < 0) {
                        object2 = this.zzx.zzat().zzb();
                        object = this.zzx.zzm().zze((String)object);
                        object5 = l10;
                        ((zzeg)object2).zzc("Invalid conditional user property timeout", object, object5);
                        return;
                    }
                }
                l10 = bundle.getLong(string7);
                object2 = this.zzx;
                ((zzfl)object2).zzc();
                n11 = (int)(l10 == l14 ? 0 : (l10 < l14 ? -1 : 1));
                if (n11 <= 0 && (n11 = (int)(l10 == l13 ? 0 : (l10 < l13 ? -1 : 1))) >= 0) {
                    object = this.zzx.zzau();
                    object5 = new zzgx(this, bundle);
                    ((zzfi)object).zzh((Runnable)object5);
                    return;
                }
                object2 = this.zzx.zzat().zzb();
                object = this.zzx.zzm().zze((String)object);
                object5 = l10;
                ((zzeg)object2).zzc("Invalid conditional user property time to live", object, object5);
                return;
            }
            object6 = this.zzx.zzat().zzb();
            object = this.zzx.zzm().zze((String)object);
            ((zzeg)object6).zzc("Invalid conditional user property value", object, object5);
            return;
        }
        object5 = this.zzx.zzat().zzb();
        object = this.zzx.zzm().zze((String)object);
        ((zzeg)object5).zzb("Invalid conditional user property name", object);
    }

    public final void zzO(String object, String object2, Bundle bundle) {
        Clock clock = this.zzx.zzax();
        long l10 = clock.currentTimeMillis();
        Preconditions.checkNotEmpty((String)object);
        Bundle bundle2 = new Bundle();
        String string2 = "name";
        bundle2.putString(string2, (String)object);
        object = "creation_timestamp";
        bundle2.putLong((String)object, l10);
        if (object2 != null) {
            bundle2.putString("expired_event_name", (String)object2);
            object = "expired_event_params";
            bundle2.putBundle((String)object, bundle);
        }
        object = this.zzx.zzau();
        object2 = new zzgy(this, bundle2);
        ((zzfi)object).zzh((Runnable)object2);
    }

    public final ArrayList zzP(String arrayList, String string2) {
        Object object = this.zzx.zzau();
        boolean bl2 = ((zzfi)object).zzd();
        zzfi zzfi2 = null;
        if (bl2) {
            arrayList = this.zzx.zzat().zzb();
            string2 = "Cannot get conditional user properties from analytics worker thread";
            ((zzeg)((Object)arrayList)).zza(string2);
            arrayList = new ArrayList(0);
        } else {
            object = this.zzx;
            ((zzfl)object).zzas();
            bl2 = zzz.zza();
            if (bl2) {
                arrayList = this.zzx.zzat().zzb();
                string2 = "Cannot get conditional user properties from main thread";
                ((zzeg)((Object)arrayList)).zza(string2);
                arrayList = new ArrayList(0);
            } else {
                object = new AtomicReference();
                zzfi2 = this.zzx.zzau();
                Object object2 = arrayList;
                zzha zzha2 = new zzha(this, (AtomicReference)object, null, (String)((Object)arrayList), string2);
                long l10 = 5000L;
                object2 = "get conditional user properties";
                zzfi2.zzi((AtomicReference)object, l10, (String)object2, zzha2);
                arrayList = (List)((AtomicReference)object).get();
                if (arrayList == null) {
                    arrayList = this.zzx.zzat().zzb();
                    string2 = null;
                    object = "Timed out waiting for get conditional user properties";
                    ((zzeg)((Object)arrayList)).zzb((String)object, null);
                    arrayList = new ArrayList();
                } else {
                    arrayList = zzkk.zzak(arrayList);
                }
            }
        }
        return arrayList;
    }

    public final Map zzQ(String object, String object2, boolean bl2) {
        Object object3 = this.zzx.zzau();
        boolean bl3 = ((zzfi)object3).zzd();
        if (bl3) {
            object = this.zzx.zzat().zzb();
            object2 = "Cannot get user properties from analytics worker thread";
            ((zzeg)object).zza((String)object2);
            object = Collections.emptyMap();
        } else {
            object3 = this.zzx;
            ((zzfl)object3).zzas();
            bl3 = zzz.zza();
            if (bl3) {
                object = this.zzx.zzat().zzb();
                object2 = "Cannot get user properties from main thread";
                ((zzeg)object).zza((String)object2);
                object = Collections.emptyMap();
            } else {
                zzhb zzhb2;
                AtomicReference atomicReference = new AtomicReference();
                zzfi zzfi2 = this.zzx.zzau();
                object3 = zzhb2;
                Object object4 = object;
                zzhb2 = new zzhb(this, atomicReference, null, (String)object, (String)object2, bl2);
                long l10 = 5000L;
                object4 = "get user properties";
                object3 = zzfi2;
                zzfi2.zzi(atomicReference, l10, (String)object4, zzhb2);
                object = (List)atomicReference.get();
                if (object == null) {
                    object = this.zzx.zzat().zzb();
                    object2 = bl2;
                    String string2 = "Timed out waiting for handle get user properties, includeInternal";
                    ((zzeg)object).zzb(string2, object2);
                    object = Collections.emptyMap();
                } else {
                    boolean bl4;
                    int n10 = object.size();
                    object2 = new ArrayMap(n10);
                    object = object.iterator();
                    while (bl4 = object.hasNext()) {
                        Object object5 = (zzkg)object.next();
                        object3 = ((zzkg)object5).zza();
                        if (object3 == null) continue;
                        object5 = ((zzkg)object5).zzb;
                        object2.put(object5, object3);
                    }
                    object = object2;
                }
            }
        }
        return object;
    }

    public final String zzR() {
        zzhu zzhu2 = this.zzx.zzx().zzl();
        if (zzhu2 != null) {
            return zzhu2.zza;
        }
        return null;
    }

    public final String zzS() {
        zzhu zzhu2 = this.zzx.zzx().zzl();
        if (zzhu2 != null) {
            return zzhu2.zzb;
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final String zzT() {
        String string2 = this.zzx.zzr();
        if (string2 != null) {
            return this.zzx.zzr();
        }
        string2 = null;
        try {
            zznb.zzb();
            zzgg zzgg2 = this.zzx;
            zzgg2 = ((zzfl)zzgg2).zzc();
            Object object = zzdw.zzaB;
            boolean bl2 = ((zzae)zzgg2).zzn(null, (zzdv)object);
            object = "google_app_id";
            if (bl2) {
                zzgg2 = this.zzx;
                zzgg2 = ((zzfl)zzgg2).zzaw();
                Object object2 = this.zzx;
                object2 = ((zzfl)object2).zzv();
                return zzht.zzb((Context)zzgg2, (String)object, (String)object2);
            }
            zzgg2 = this.zzx;
            zzgg2 = ((zzfl)zzgg2).zzaw();
            return zzht.zza((Context)zzgg2, (String)object);
        }
        catch (IllegalStateException illegalStateException) {
            this.zzx.zzat().zzb().zzb("getGoogleAppId failed with exception", illegalStateException);
            return null;
        }
    }

    public final /* synthetic */ void zzU(Bundle object) {
        int n10;
        Object object2;
        Object object3;
        Object object4;
        Object object5;
        int n12;
        if (object == null) {
            object = this.zzx.zzd().zzw;
            Bundle bundle = new Bundle();
            ((zzet)object).zzb(bundle);
            return;
        }
        Bundle bundle = this.zzx.zzd().zzw.zza();
        Object object6 = object.keySet().iterator();
        while ((n12 = object6.hasNext()) != 0) {
            Object object7;
            boolean n11;
            object5 = (String)object6.next();
            object4 = object.get((String)object5);
            if (!(object4 == null || (n11 = object4 instanceof String) || (n11 = object4 instanceof Long) || (n11 = object4 instanceof Double))) {
                object7 = this.zzx.zzl();
                n11 = ((zzkk)object7).zzs(object4);
                if (n11) {
                    object7 = this.zzx;
                    object3 = ((zzfl)object7).zzl();
                    object2 = this.zzn;
                    int n13 = 27;
                    ((zzkk)object3).zzM((zzkj)object2, null, n13, null, null, 0);
                }
                object7 = this.zzx.zzat().zzh();
                object3 = "Invalid default event parameter type. Name, value";
                ((zzeg)object7).zzc((String)object3, object5, object4);
                continue;
            }
            n11 = zzkk.zzR((String)object5);
            if (n11) {
                object4 = this.zzx.zzat().zzh();
                object7 = "Invalid default event parameter name. Name";
                ((zzeg)object4).zzb((String)object7, object5);
                continue;
            }
            if (object4 == null) {
                bundle.remove((String)object5);
                continue;
            }
            object7 = this.zzx.zzl();
            object3 = this.zzx;
            ((zzfl)object3).zzc();
            object2 = "param";
            n10 = 100;
            n11 = ((zzkk)object7).zzt((String)object2, (String)object5, n10, object4);
            if (!n11) continue;
            object7 = this.zzx.zzl();
            ((zzkk)object7).zzL(bundle, (String)object5, object4);
        }
        this.zzx.zzl();
        object = this.zzx.zzc();
        int n14 = ((zzae)object).zzc();
        int n15 = bundle.size();
        if (n15 > n14) {
            boolean bl2;
            object5 = bundle.keySet();
            object6 = new TreeSet(object5);
            object6 = object6.iterator();
            n12 = 0;
            object5 = null;
            while (bl2 = object6.hasNext()) {
                object4 = (String)object6.next();
                if (++n12 <= n14) continue;
                bundle.remove((String)object4);
            }
            object6 = this.zzx.zzl();
            object5 = this.zzn;
            bl2 = false;
            object4 = null;
            int n16 = 26;
            n10 = 0;
            object3 = null;
            object2 = null;
            ((zzkk)object6).zzM((zzkj)object5, null, n16, null, null, 0);
            object = this.zzx.zzat().zzh();
            object6 = "Too many default event parameters set. Discarding beyond event parameter limit";
            ((zzeg)object).zza((String)object6);
        }
        this.zzx.zzd().zzw.zzb(bundle);
        this.zzx.zzy().zzA(bundle);
    }

    public final boolean zze() {
        return false;
    }

    public final void zzh() {
        Object object = this.zzx.zzaw().getApplicationContext();
        boolean bl2 = object instanceof Application;
        if (bl2 && (object = this.zza) != null) {
            object = (Application)this.zzx.zzaw().getApplicationContext();
            zzhm zzhm2 = this.zza;
            object.unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)zzhm2);
        }
    }

    public final Boolean zzi() {
        AtomicReference atomicReference = new AtomicReference();
        zzfi zzfi2 = this.zzx.zzau();
        zzgz zzgz2 = new zzgz(this, atomicReference);
        return (Boolean)zzfi2.zzi(atomicReference, 15000L, "boolean test flag value", zzgz2);
    }

    public final String zzj() {
        AtomicReference atomicReference = new AtomicReference();
        zzfi zzfi2 = this.zzx.zzau();
        zzhd zzhd2 = new zzhd(this, atomicReference);
        return (String)zzfi2.zzi(atomicReference, 15000L, "String test flag value", zzhd2);
    }

    public final Long zzk() {
        AtomicReference atomicReference = new AtomicReference();
        zzfi zzfi2 = this.zzx.zzau();
        zzhe zzhe2 = new zzhe(this, atomicReference);
        return (Long)zzfi2.zzi(atomicReference, 15000L, "long test flag value", zzhe2);
    }

    public final Integer zzl() {
        AtomicReference atomicReference = new AtomicReference();
        zzfi zzfi2 = this.zzx.zzau();
        zzhf zzhf2 = new zzhf(this, atomicReference);
        return (Integer)zzfi2.zzi(atomicReference, 15000L, "int test flag value", zzhf2);
    }

    public final Double zzm() {
        AtomicReference atomicReference = new AtomicReference();
        zzfi zzfi2 = this.zzx.zzau();
        zzhg zzhg2 = new zzhg(this, atomicReference);
        return (Double)zzfi2.zzi(atomicReference, 15000L, "double test flag value", zzhg2);
    }

    public final void zzn(Boolean bl2) {
        this.zzb();
        zzfi zzfi2 = this.zzx.zzau();
        zzhh zzhh2 = new zzhh(this, bl2);
        zzfi2.zzh(zzhh2);
    }

    public final void zzo(Bundle object, int n10, long l10) {
        zzlc.zzb();
        Object object2 = this.zzx.zzc();
        Object object3 = zzdw.zzaw;
        String string2 = null;
        boolean bl2 = ((zzae)object2).zzn(null, (zzdv)object3);
        if (bl2) {
            this.zzb();
            object2 = zzaf.zza(object);
            if (object2 != null) {
                object3 = this.zzx.zzat().zzh();
                string2 = "Ignoring invalid consent setting";
                ((zzeg)object3).zzb(string2, object2);
                object2 = this.zzx.zzat().zzh();
                object3 = "Valid consent values are 'granted', 'denied'";
                ((zzeg)object2).zza((String)object3);
            }
            object = zzaf.zzb(object);
            this.zzq((zzaf)object, n10, l10);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final void zzq(zzaf zzaf2, int n10, long l10) {
        zzhk zzhk2;
        long l11;
        float f10;
        boolean bl2;
        zzfi zzfi2;
        float f11;
        boolean bl3;
        int n11;
        int n12;
        Object object;
        Object object2;
        zzaf zzaf3;
        zzhn zzhn2;
        block12: {
            zzhj zzhj2;
            block14: {
                block13: {
                    Object object3;
                    int n13;
                    block11: {
                        block10: {
                            block9: {
                                zzhn2 = this;
                                zzaf3 = zzaf2;
                                zzlc.zzb();
                                object2 = this.zzx.zzc();
                                object = zzdw.zzaw;
                                n13 = ((zzae)object2).zzn(null, (zzdv)object);
                                if (n13 == 0) return;
                                this.zzb();
                                object2 = this.zzx.zzc();
                                object = zzdw.zzax;
                                n13 = ((zzae)object2).zzn(null, (zzdv)object);
                                n12 = 20;
                                if (n13 == 0) break block9;
                                n13 = n10;
                                if (n10 != n12) break block10;
                                n11 = n12;
                                break block11;
                            }
                            n13 = n10;
                        }
                        object3 = zzaf2.zze();
                        if (object3 == null && (object3 = zzaf2.zzg()) == null) {
                            zzhn2.zzx.zzat().zzh().zza("Discarding empty consent settings");
                            return;
                        }
                        n11 = n13;
                    }
                    object2 = zzhn2.zzh;
                    // MONITORENTER : object2
                    boolean bl4 = zzhn2.zzj;
                    bl4 = zzaf.zzm(n11, (int)(bl4 ? 1 : 0));
                    bl3 = true;
                    f11 = Float.MIN_VALUE;
                    boolean bl5 = false;
                    float f12 = 0.0f;
                    zzfi2 = null;
                    if (bl4) {
                        zzaf zzaf4;
                        object3 = zzhn2.zzi;
                        bl4 = zzaf3.zzi((zzaf)object3);
                        bl2 = zzaf2.zzh();
                        if (bl2 && !(bl2 = (zzaf4 = zzhn2.zzi).zzh())) {
                            bl5 = bl3;
                            f12 = f11;
                        }
                        zzaf4 = zzhn2.zzi;
                        zzhn2.zzi = zzaf3 = zzaf3.zzl(zzaf4);
                        zzhn2.zzj = n11;
                        bl2 = bl5;
                        f10 = f12;
                        bl5 = bl4;
                    } else {
                        bl3 = false;
                        f11 = 0.0f;
                        bl2 = false;
                        Object var20_20 = null;
                        f10 = 0.0f;
                    }
                    // MONITOREXIT : object2
                    if (!bl3) {
                        zzhn2.zzx.zzat().zzi().zzb("Ignoring lower-priority consent settings, proposed settings", zzaf3);
                        return;
                    }
                    object2 = zzhn2.zzk;
                    l11 = ((AtomicLong)object2).getAndIncrement();
                    if (bl5) {
                        zzhi zzhi2;
                        zzhn2.zzg.set(null);
                        zzfi zzfi3 = zzhn2.zzx.zzau();
                        object2 = zzhi2;
                        object = this;
                        zzhi2 = new zzhi(this, zzaf3, l10, n11, l11, bl2);
                        zzfi3.zzj(zzhi2);
                        return;
                    }
                    object2 = zzhn2.zzx.zzc();
                    n13 = (int)(((zzae)object2).zzn(null, (zzdv)object) ? 1 : 0);
                    if (n13 == 0) break block12;
                    n13 = 40;
                    if (n11 == n13) break block13;
                    if (n11 != n12) break block12;
                    break block14;
                }
                n12 = n11;
            }
            zzfi2 = zzhn2.zzx.zzau();
            object2 = zzhj2;
            object = this;
            bl3 = bl2;
            f11 = f10;
            zzhj2 = new zzhj(this, zzaf3, n12, l11, bl2);
            zzfi2.zzj(zzhj2);
            return;
        }
        zzfi2 = zzhn2.zzx.zzau();
        object2 = zzhk2;
        object = this;
        n12 = n11;
        bl3 = bl2;
        f11 = f10;
        zzhk2 = new zzhk(this, zzaf3, n11, l11, bl2);
        zzfi2.zzh(zzhk2);
    }

    public final void zzr(zzaf object) {
        boolean bl2;
        ((zzge)this).zzg();
        boolean bl3 = ((zzaf)object).zzh();
        boolean bl4 = true;
        if (bl3 && (bl2 = ((zzaf)object).zzf()) || (bl2 = ((zzjb)(object = this.zzx.zzy())).zzH())) {
            bl2 = bl4;
        } else {
            bl2 = false;
            object = null;
        }
        zzgg zzgg2 = this.zzx;
        bl3 = ((zzfl)zzgg2).zzI();
        if (bl2 != bl3) {
            this.zzx.zzH(bl2);
            zzgg2 = this.zzx.zzd();
            zzlc.zzb();
            zzgg zzgg3 = ((zzge)zzgg2).zzx.zzc();
            Object object2 = zzdw.zzaw;
            Boolean bl5 = null;
            boolean bl6 = zzgg3.zzn(null, (zzdv)object2);
            if (bl6) {
                zzgg3 = ((zzge)zzgg2).zzx;
                ((zzge)zzgg2).zzg();
                zzgg3 = ((zzex)zzgg2).zzd();
                object2 = "measurement_enabled_from_api";
                bl6 = zzgg3.contains((String)object2);
                if (bl6) {
                    zzgg2 = ((zzex)zzgg2).zzd();
                    bl3 = zzgg2.getBoolean((String)object2, bl4);
                    bl5 = bl3;
                }
            }
            if (!bl2 || bl5 == null || (bl3 = bl5.booleanValue())) {
                object = bl2;
                this.zzY((Boolean)object, false);
            }
        }
    }

    public final void zzs(String string2, String string3, Bundle bundle) {
        long l10 = this.zzx.zzax().currentTimeMillis();
        this.zzv(string2, string3, bundle, true, true, l10);
    }

    public final void zzt(String string2, String string3, long l10, Bundle bundle) {
        boolean bl2;
        boolean bl3;
        ((zzge)this).zzg();
        Object object = this.zzd;
        boolean bl4 = true;
        if (object != null && !(bl3 = zzkk.zzR(string3))) {
            bl3 = false;
            object = null;
            bl2 = false;
        } else {
            bl2 = bl4;
        }
        object = this;
        this.zzu(string2, string3, l10, bundle, true, bl2, false, null);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final void zzu(String var1_1, String var2_2, long var3_3, Bundle var5_4, boolean var6_5, boolean var7_6, boolean var8_7, String var9_8) {
        block65: {
            block66: {
                block70: {
                    block67: {
                        block68: {
                            block69: {
                                var10_9 = this;
                                var11_10 = var1_1;
                                var12_11 = var2_2;
                                var13_12 = var3_3;
                                var15_13 /* !! */  = var5_4;
                                var16_14 = "com.google.android.gms.tagmanager.TagManagerService";
                                Preconditions.checkNotEmpty((String)var1_1);
                                Preconditions.checkNotNull(var5_4);
                                this.zzg();
                                this.zzb();
                                var17_16 = this.zzx;
                                var18_17 = var17_16.zzF();
                                if (var18_17 == 0) break block65;
                                var17_16 = this.zzx.zzA().zzo();
                                if (var17_16 != null && (var18_17 = var17_16.contains(var2_2)) == 0) {
                                    this.zzx.zzat().zzj().zzc("Dropping non-safelisted event. event name, origin", var2_2, var1_1);
                                    return;
                                }
                                var18_17 = var10_9.zzf;
                                var19_18 = null;
                                var20_19 = 0;
                                var21_20 /* !! */  = null;
                                var22_21 = 1;
                                if (var18_17 == 0) {
                                    block64: {
                                        block63: {
                                            var10_9.zzf = var22_21;
                                            var17_16 = var10_9.zzx;
                                            var18_17 = var17_16.zzu();
                                            if (var18_17 != 0) break block63;
                                            var17_16 = var10_9.zzx;
                                            var17_16 = var17_16.zzaw();
                                            var17_16 = var17_16.getClassLoader();
                                            var16_14 = Class.forName((String)var16_14, (boolean)var22_21, (ClassLoader)var17_16);
                                            break block64;
                                        }
                                        var16_14 = Class.forName((String)var16_14);
                                    }
                                    var17_16 = new Class[var22_21];
                                    var23_22 = Context.class;
                                    var17_16[0] = var23_22;
                                    var23_22 = "initialize";
                                    var16_14 = var16_14.getDeclaredMethod((String)var23_22, (Class<?>)var17_16);
                                    var17_16 = new Object[var22_21];
                                    var23_22 = var10_9.zzx;
                                    var23_22 = var23_22.zzaw();
                                    var17_16[0] = var23_22;
                                    try {
                                        var16_14.invoke(null, (Object[])var17_16);
                                    }
                                    catch (Exception var16_15) {
                                        var17_16 = var10_9.zzx;
                                        var17_16 = var17_16.zzat();
                                        var17_16 = var17_16.zze();
                                        var23_22 = "Failed to invoke Tag Manager's initialize() method";
                                        try {
                                            var17_16.zzb((String)var23_22, var16_15);
                                        }
                                        catch (ClassNotFoundException v0) {
                                            var16_14 = var10_9.zzx.zzat().zzi();
                                            var17_16 = "Tag Manager is not found and thus will not be used";
                                            var16_14.zza((String)var17_16);
                                        }
                                    }
                                }
                                if ((var24_23 = (var16_14 = var10_9.zzx.zzc()).zzn(null, (zzdv)(var17_16 = zzdw.zzac))) != 0 && (var24_23 = (var16_14 = "_cmp").equals(var12_11)) != 0 && (var18_17 = var15_13 /* !! */ .containsKey((String)(var16_14 = "gclid"))) != 0) {
                                    var10_9.zzx.zzas();
                                    var25_24 = var15_13 /* !! */ .getString(var16_14);
                                    var16_14 = var10_9.zzx.zzax();
                                    var26_25 = var16_14.currentTimeMillis();
                                    var23_22 = "auto";
                                    var28_26 = "_lgclid";
                                    var17_16 = this;
                                    this.zzB((String)var23_22, (String)var28_26, var25_24, var26_25);
                                }
                                var16_14 = var10_9.zzx;
                                var16_14.zzas();
                                if (var6_5 && (var24_23 = (int)zzkk.zzY((String)var2_2)) != 0) {
                                    var16_14 = var10_9.zzx.zzl();
                                    var17_16 = var10_9.zzx.zzd().zzw.zza();
                                    var16_14.zzH((Bundle)var15_13 /* !! */ , (Bundle)var17_16);
                                }
                                var24_23 = 40;
                                if (var8_7 != 0) {
                                    var10_9.zzx.zzas();
                                    var17_16 = "_iap";
                                    var18_17 = var17_16.equals(var12_11);
                                    if (var18_17 == 0) {
                                        var17_16 = var10_9.zzx.zzl();
                                        var23_22 = "event";
                                        var29_27 = var17_16.zzj((String)var23_22, var12_11);
                                        var30_28 = 2;
                                        if (var29_27) {
                                            var28_26 = zzgi.zza;
                                            var31_29 = zzgi.zzb;
                                            var29_27 = var17_16.zzl((String)var23_22, (String[])var28_26, (String[])var31_29, var12_11);
                                            if (!var29_27) {
                                                var30_28 = 13;
                                            } else {
                                                var28_26 = var17_16.zzx;
                                                var28_26.zzc();
                                                var18_17 = var17_16.zzm((String)var23_22, var24_23, var12_11);
                                                if (var18_17 != 0) {
                                                    var30_28 = 0;
                                                    var25_24 = null;
                                                }
                                            }
                                        }
                                        if (var30_28 != 0) {
                                            var17_16 = var10_9.zzx.zzat().zzd();
                                            var23_22 = var10_9.zzx.zzm().zzc(var12_11);
                                            var28_26 = "Invalid public event name. Event will not be logged (FE)";
                                            var17_16.zzb((String)var28_26, var23_22);
                                            var17_16 = var10_9.zzx.zzl();
                                            var23_22 = var10_9.zzx;
                                            var23_22.zzc();
                                            var16_14 = var17_16.zzC(var12_11, var24_23, (boolean)var22_21);
                                            if (var12_11 != null) {
                                                var20_19 = var2_2.length();
                                            }
                                            var17_16 = var10_9.zzx.zzl();
                                            var23_22 = var10_9.zzn;
                                            var1_1 = var17_16;
                                            var2_2 = var23_22;
                                            var5_4 = "_ev";
                                            var32_30 = var16_14;
                                            var7_6 = var20_19;
                                            var17_16.zzM((zzkj)var23_22, null, var30_28, (String)var5_4, (String)var16_14, var20_19);
                                            return;
                                        }
                                    }
                                }
                                var10_9.zzx.zzas();
                                var17_16 = var10_9.zzx.zzx().zzh(false);
                                var33_33 = "_sc";
                                if (var17_16 != null && (var34_34 = var15_13 /* !! */ .containsKey((String)var33_33)) == 0) {
                                    var17_16.zzd = var22_21;
                                }
                                if (var6_5 && var8_7 != 0) {
                                    var34_34 = var22_21;
                                } else {
                                    var34_34 = 0;
                                    var23_22 = null;
                                }
                                zzib.zzm((zzhu)var17_16, (Bundle)var15_13 /* !! */ , (boolean)var34_34);
                                var17_16 = "am";
                                var18_17 = var17_16.equals(var11_10);
                                var34_34 = zzkk.zzR((String)var2_2);
                                if (!var6_5 || (var28_26 = var10_9.zzd) == null || var34_34 != 0) ** GOTO lbl175
                                if (var18_17 != 0) {
                                    var35_35 = var22_21;
                                } else {
                                    var16_14 = var10_9.zzx.zzat().zzj();
                                    var17_16 = var10_9.zzx.zzm().zzc(var12_11);
                                    var23_22 = var10_9.zzx.zzm().zzf((Bundle)var15_13 /* !! */ );
                                    var16_14.zzc("Passing event to registered event handler (FE)", var17_16, var23_22);
                                    Preconditions.checkNotNull(var10_9.zzd);
                                    var17_16 = var10_9.zzd;
                                    var23_22 = var1_1;
                                    var28_26 = var2_2;
                                    var25_24 = var5_4;
                                    var26_25 = var3_3;
                                    var17_16.interceptEvent((String)var1_1, (String)var2_2, (Bundle)var5_4, var3_3);
                                    return;
lbl175:
                                    // 1 sources

                                    var35_35 = var18_17;
                                }
                                var17_16 = var10_9.zzx;
                                var18_17 = var17_16.zzL();
                                if (var18_17 == 0) break block66;
                                var17_16 = var10_9.zzx.zzl();
                                var18_17 = var17_16.zzn(var12_11);
                                if (var18_17 != 0) {
                                    var23_22 = var10_9.zzx.zzat().zzd();
                                    var28_26 = var10_9.zzx.zzm().zzc(var12_11);
                                    var25_24 = "Invalid event name. Event will not be logged (FE)";
                                    var23_22.zzb((String)var25_24, var28_26);
                                    var23_22 = var10_9.zzx.zzl();
                                    var28_26 = var10_9.zzx;
                                    var28_26.zzc();
                                    var16_14 = var23_22.zzC(var12_11, var24_23, (boolean)var22_21);
                                    if (var12_11 != null) {
                                        var20_19 = var2_2.length();
                                    }
                                    var23_22 = var10_9.zzx.zzl();
                                    var28_26 = var10_9.zzn;
                                    var1_1 = var23_22;
                                    var2_2 = var28_26;
                                    var5_4 = "_ev";
                                    var32_31 = var16_14;
                                    var7_6 = var20_19;
                                    var23_22.zzM((zzkj)var28_26, var9_8, var18_17, (String)var5_4, (String)var16_14, var20_19);
                                    return;
                                }
                                var16_14 = "_o";
                                var31_29 = "_sn";
                                var25_24 = "_si";
                                var36_36 = CollectionUtils.listOf(new String[]{var16_14, var31_29, var33_33, var25_24});
                                var17_16 = var10_9.zzx.zzl();
                                var23_22 = var9_8;
                                var28_26 = var2_2;
                                var37_37 = var25_24;
                                var25_24 = var5_4;
                                var15_13 /* !! */  = var31_29;
                                var31_29 = var36_36;
                                var19_18 = var33_33;
                                var38_38 = var8_7;
                                var31_29 = var17_16.zzF(var9_8, (String)var2_2, (Bundle)var5_4, var36_36, (boolean)var8_7);
                                Preconditions.checkNotNull(var31_29);
                                var18_17 = (int)var31_29.containsKey((String)var33_33);
                                if (var18_17 != 0 && (var18_17 = (int)var31_29.containsKey((String)var37_37)) != 0) {
                                    var17_16 = var31_29.getString((String)var15_13 /* !! */ );
                                    var23_22 = var31_29.getString((String)var33_33);
                                    var39_39 = var31_29.getLong((String)var37_37);
                                    var28_26 = var39_39;
                                    var41_40 = var28_26.longValue();
                                    var25_24 = new zzhu((String)var17_16, (String)var23_22, var41_40);
                                }
                                var10_9.zzx.zzas();
                                var17_16 = var10_9.zzx.zzx().zzh(false);
                                var41_40 = 0L;
                                var37_37 = "_ae";
                                if (var17_16 != null && (var18_17 = (int)var37_37.equals(var12_11)) != 0) {
                                    var17_16 = var10_9.zzx.zzh().zzb;
                                    var23_22 = var17_16.zzc.zzx.zzax();
                                    var43_41 = var23_22.elapsedRealtime();
                                    var5_4 = var37_37;
                                    var45_42 = var17_16.zzb;
                                    var45_42 = var43_41 - var45_42;
                                    var17_16.zzb = var43_41;
                                    var18_17 = (int)(var45_42 == var41_40 ? 0 : (var45_42 < var41_40 ? -1 : 1));
                                    if (var18_17 > 0) {
                                        var17_16 = var10_9.zzx.zzl();
                                        var17_16.zzac((Bundle)var31_29, var45_42);
                                    }
                                } else {
                                    var5_4 = var37_37;
                                }
                                zzll.zzb();
                                var17_16 = var10_9.zzx.zzc();
                                var23_22 = zzdw.zzan;
                                var20_19 = 0;
                                var21_20 /* !! */  = null;
                                var18_17 = (int)var17_16.zzn(null, (zzdv)var23_22);
                                if (var18_17 == 0) break block67;
                                var17_16 = "auto";
                                var18_17 = (int)var17_16.equals(var11_10);
                                var23_22 = "_ffr";
                                if (var18_17 != 0 || (var18_17 = (int)(var17_16 = "_ssr").equals(var12_11)) == 0) break block68;
                                var17_16 = var10_9.zzx.zzl();
                                var29_27 = Strings.isEmptyOrWhitespace((String)(var23_22 = var31_29.getString((String)var23_22)));
                                if (var29_27) {
                                    var34_34 = 0;
                                    var23_22 = null;
                                } else if (var23_22 != null) {
                                    var23_22 = var23_22.trim();
                                }
                                var28_26 = var17_16.zzx.zzd().zzt.zza();
                                var29_27 = zzkk.zzS((String)var23_22, (String)var28_26);
                                if (var29_27) break block69;
                                var17_16 = var17_16.zzx.zzd().zzt;
                                var17_16.zzb((String)var23_22);
                                break block67;
                            }
                            var17_16.zzx.zzat().zzj().zza("Not logging duplicate session_start_with_rollout event");
                            return;
                        }
                        var37_37 = var5_4;
                        var18_17 = (int)var5_4.equals(var12_11);
                        if (var18_17 != 0 && !(var29_27 = TextUtils.isEmpty((CharSequence)(var17_16 = var10_9.zzx.zzl().zzx.zzd().zzt.zza())))) {
                            var31_29.putString((String)var23_22, (String)var17_16);
                        }
                        break block70;
                    }
                    var37_37 = var5_4;
                }
                var33_33 = new ArrayList();
                var33_33.add(var31_29);
                var10_9.zzx.zzl().zzf().nextLong();
                var17_16 = var10_9.zzx.zzd().zzo;
                var47_43 = var17_16.zza();
                var18_17 = (int)(var47_43 == var41_40 ? 0 : (var47_43 < var41_40 ? -1 : 1));
                if (var18_17 > 0 && (var18_17 = (int)(var17_16 = var10_9.zzx.zzd()).zzl(var13_12)) != 0 && (var18_17 = (int)(var17_16 = var10_9.zzx.zzd().zzq).zza()) != 0) {
                    var10_9.zzx.zzat().zzk().zza("Current session is expired, remove the session number, ID, and engagement time");
                    var30_28 = 0;
                    var25_24 = null;
                    var49_44 = var10_9.zzx.zzax().currentTimeMillis();
                    var17_16 = this;
                    var21_20 /* !! */  = var31_29;
                    var5_4 = var33_33;
                    var26_25 = var49_44;
                    this.zzB("auto", "_sid", null, var49_44);
                    var26_25 = var10_9.zzx.zzax().currentTimeMillis();
                    var17_16 = this;
                    this.zzB("auto", "_sno", null, var26_25);
                    var26_25 = var10_9.zzx.zzax().currentTimeMillis();
                    var23_22 = "auto";
                    var28_26 = "_se";
                    var17_16 = this;
                    this.zzB((String)var23_22, (String)var28_26, null, var26_25);
                } else {
                    var21_20 /* !! */  = var31_29;
                    var5_4 = var33_33;
                }
                var17_16 = "extend_session";
                var47_43 = var21_20 /* !! */ .getLong((String)var17_16, var41_40);
                var39_39 = 1L;
                var18_17 = (int)(var47_43 == var39_39 ? 0 : (var47_43 < var39_39 ? -1 : 1));
                if (var18_17 == 0) {
                    var17_16 = var10_9.zzx.zzat().zzk();
                    var23_22 = "EXTEND_SESSION param attached: initiate a new session or extend the current active session";
                    var17_16.zza((String)var23_22);
                    var17_16 = var10_9.zzx.zzh().zza;
                    var34_34 = 1;
                    var17_16.zzb(var13_12, (boolean)var34_34);
                }
                var23_22 = var21_20 /* !! */ .keySet();
                var17_16 = new ArrayList(var23_22);
                Collections.sort(var17_16);
                var34_34 = var17_16.size();
                var28_26 = null;
                for (var29_27 = 0; var29_27 < var34_34; var29_27 += 1) {
                    var25_24 = (String)var17_16.get(var29_27);
                    if (var25_24 == null) continue;
                    var10_9.zzx.zzl();
                    var31_29 = var21_20 /* !! */ .get((String)var25_24);
                    var38_38 = var31_29 instanceof Bundle;
                    if (var38_38 != 0) {
                        var15_13 /* !! */  = new Bundle[1];
                        var38_38 = 0;
                        var33_33 = null;
                        var15_13 /* !! */ [0] = var31_29;
                    } else {
                        var38_38 = var31_29 instanceof Parcelable[];
                        if (var38_38 != 0) {
                            var31_29 = (Parcelable[])var31_29;
                            var38_38 = ((Parcelable[])var31_29).length;
                            var31_29 = Arrays.copyOf(var31_29, var38_38, Bundle[].class);
                            var15_13 /* !! */  = var31_29;
                            var15_13 /* !! */  = (Bundle[])var31_29;
                        } else {
                            var38_38 = var31_29 instanceof ArrayList;
                            if (var38_38 != 0) {
                                var31_29 = (ArrayList)var31_29;
                                var38_38 = var31_29.size();
                                var33_33 = new Bundle[var38_38];
                                var31_29 = var31_29.toArray(var33_33);
                                var15_13 /* !! */  = var31_29;
                                var15_13 /* !! */  = (Bundle[])var31_29;
                            } else {
                                var51_45 = 0;
                                var15_13 /* !! */  = null;
                            }
                        }
                    }
                    if (var15_13 /* !! */  == null) continue;
                    var21_20 /* !! */ .putParcelableArray((String)var25_24, (Parcelable[])var15_13 /* !! */ );
                }
                var15_13 /* !! */  = null;
                for (var51_45 = 0; var51_45 < (var18_17 = var5_4.size()); ++var51_45) {
                    var19_18 = var5_4;
                    var17_16 = (Bundle)var5_4.get(var51_45);
                    var23_22 = var51_45 != 0 ? "_ep" : var12_11;
                    var17_16.putString((String)var16_14, var11_10);
                    if (var7_6) {
                        var28_26 = var10_9.zzx.zzl();
                        var17_16 = var28_26.zzU((Bundle)var17_16);
                    }
                    var21_20 /* !! */  = var17_16;
                    var28_26 = new zzaq((Bundle)var17_16);
                    var17_16 = var31_29;
                    var25_24 = var1_1;
                    var32_32 = var16_14;
                    var16_14 = var31_29;
                    var26_25 = var3_3;
                    var31_29 = new zzas((String)var23_22, (zzaq)var28_26, (String)var1_1, var3_3);
                    var17_16 = var10_9.zzx.zzy();
                    var31_29 = var9_8;
                    var17_16.zzl((zzas)var16_14, var9_8);
                    if (var35_35 == 0) {
                        var16_14 = var10_9.zze.iterator();
                        while ((var18_17 = (int)var16_14.hasNext()) != 0) {
                            var17_16 = (zzgm)var16_14.next();
                            var25_24 = new Bundle(var21_20 /* !! */ );
                            var23_22 = var1_1;
                            var28_26 = var2_2;
                            var26_25 = var3_3;
                            var17_16.onEvent((String)var1_1, (String)var2_2, (Bundle)var25_24, var3_3);
                            var31_29 = var9_8;
                        }
                    }
                    var16_14 = var32_32;
                    var5_4 = var19_18;
                }
                var10_9.zzx.zzas();
                var16_14 = var10_9.zzx.zzx();
                var18_17 = 0;
                var17_16 = null;
                var16_14 = var16_14.zzh(false);
                if (var16_14 != null && (var24_23 = (int)var37_37.equals(var12_11)) != 0) {
                    var16_14 = var10_9.zzx.zzh();
                    var17_16 = var10_9.zzx.zzax();
                    var47_43 = var17_16.elapsedRealtime();
                    var16_14 = var16_14.zzb;
                    var29_27 = 1;
                    var16_14.zzd((boolean)var29_27, (boolean)var29_27, var47_43);
                }
            }
            return;
        }
        this.zzx.zzat().zzj().zza("Event not sent since app measurement is disabled");
    }

    public final void zzv(String string2, String string3, Bundle bundle, boolean bl2, boolean bl3, long l10) {
        boolean bl4;
        boolean bl5;
        zzgl zzgl2;
        Object object;
        String string4;
        Object object2;
        zzhn zzhn2 = this;
        if (string2 == null) {
            object2 = "app";
            string4 = object2;
        } else {
            string4 = string2;
        }
        if (bundle == null) {
            object2 = new Bundle();
            object = object2;
        } else {
            object = bundle;
        }
        object2 = zzhn2.zzx.zzc();
        zzdv zzdv2 = zzdw.zzat;
        boolean bl6 = ((zzae)object2).zzn(null, zzdv2);
        if (bl6 && (bl6 = zzkk.zzS(string3, (String)(object2 = "screen_view")))) {
            zzhn2.zzx.zzx().zzj((Bundle)object, l10);
            return;
        }
        bl6 = true;
        if (bl3 && (zzgl2 = zzhn2.zzd) != null && !(bl5 = zzkk.zzR(string3))) {
            bl5 = false;
            zzgl2 = null;
            bl4 = false;
        } else {
            bl4 = bl6;
        }
        boolean bl7 = bl2 ^ true;
        object2 = this;
        bl5 = bl3;
        this.zzx(string4, string3, l10, (Bundle)object, bl3, bl4, bl7, null);
    }

    public final void zzx(String string2, String string3, long l10, Bundle bundle, boolean bl2, boolean bl3, boolean bl4, String string4) {
        zzgt zzgt2;
        String string5;
        Object object;
        Object object2;
        int n10;
        Object object3 = bundle;
        Bundle bundle2 = new Bundle(bundle);
        object3 = bundle2.keySet().iterator();
        while ((n10 = object3.hasNext()) != 0) {
            Bundle bundle3;
            boolean bl5;
            object2 = (String)object3.next();
            object = bundle2.get((String)object2);
            int n11 = object instanceof Bundle;
            if (n11 != 0) {
                object = (Bundle)object;
                string5 = new Bundle((Bundle)object);
                bundle2.putBundle((String)object2, (Bundle)string5);
                continue;
            }
            n10 = object instanceof Parcelable[];
            string5 = null;
            if (n10 != 0) {
                object = (Parcelable[])object;
                for (n11 = 0; n11 < (n10 = ((Parcelable[])object).length); ++n11) {
                    object2 = object[n11];
                    bl5 = object2 instanceof Bundle;
                    if (!bl5) continue;
                    object2 = (Bundle)object2;
                    bundle3 = new Bundle((Bundle)object2);
                    object[n11] = bundle3;
                }
                continue;
            }
            n10 = object instanceof List;
            if (n10 == 0) continue;
            object = (List)object;
            while (n11 < (n10 = object.size())) {
                object2 = object.get(n11);
                bl5 = object2 instanceof Bundle;
                if (bl5) {
                    object2 = (Bundle)object2;
                    bundle3 = new Bundle((Bundle)object2);
                    object.set(n11, bundle3);
                }
                ++n11;
            }
        }
        zzfi zzfi2 = this.zzx.zzau();
        object3 = zzgt2;
        object2 = this;
        object = string2;
        string5 = string3;
        zzgt2 = new zzgt(this, string2, string3, l10, bundle2, bl2, bl3, bl4, string4);
        zzfi2.zzh(zzgt2);
    }

    public final void zzy(String string2, String string3, Object object, boolean bl2) {
        long l10 = this.zzx.zzax().currentTimeMillis();
        this.zzz("auto", string3, object, true, l10);
    }

    /*
     * Unable to fully structure code
     */
    public final void zzz(String var1_1, String var2_2, Object var3_3, boolean var4_4, long var5_5) {
        block8: {
            block9: {
                var7_6 = this;
                var8_7 = var2_2;
                var9_8 = var3_3;
                var10_9 = var1_1 == null ? "app" : var1_1;
                var11_10 = 6;
                var12_11 = 0;
                var13_12 = 24;
                if (var4_4) {
                    var14_13 = var7_6.zzx.zzl();
                    var11_10 = var14_13.zzo(var8_7);
lbl11:
                    // 4 sources

                    while (true) {
                        var15_17 = var11_10;
                        break block8;
                        break;
                    }
                }
                var16_14 = var7_6.zzx.zzl();
                var18_18 = var16_14.zzj((String)(var17_15 = "user property"), var8_7);
                if (!var18_18) ** GOTO lbl11
                var19_16 = zzgk.zza;
                var18_18 = var16_14.zzl((String)var17_15, (String[])var19_16, null, var8_7);
                if (var18_18) break block9;
                var11_10 = 15;
                ** GOTO lbl11
            }
            var19_16 = var16_14.zzx;
            var19_16.zzc();
            var20_19 = var16_14.zzm((String)var17_15, var13_12, var8_7);
            if (var20_19) ** break;
            ** while (true)
            var15_17 = 0;
        }
        var11_10 = 1;
        if (var15_17 != 0) {
            var9_8 = var7_6.zzx.zzl();
            var10_9 = var7_6.zzx;
            var10_9.zzc();
            var21_20 = var9_8.zzC(var8_7, var13_12, (boolean)var11_10);
            if (var8_7 != null) {
                var12_11 = var2_2.length();
            }
            var17_15 = var7_6.zzx.zzl();
            var19_16 = var7_6.zzn;
            var17_15.zzM((zzkj)var19_16, null, var15_17, "_ev", var21_20, var12_11);
            return;
        }
        if (var9_8 != null) {
            var16_14 = var7_6.zzx.zzl();
            var15_17 = var16_14.zzJ(var8_7, var9_8);
            if (var15_17 != 0) {
                var10_9 = var7_6.zzx.zzl();
                var16_14 = var7_6.zzx;
                var16_14.zzc();
                var21_21 = var10_9.zzC(var8_7, var13_12, (boolean)var11_10);
                var22_22 = var9_8 instanceof String;
                if (var22_22 || (var22_22 = var9_8 instanceof CharSequence)) {
                    var9_8 = String.valueOf(var3_3);
                    var12_11 = var9_8.length();
                }
                var17_15 = var7_6.zzx.zzl();
                var19_16 = var7_6.zzn;
                var17_15.zzM((zzkj)var19_16, null, var15_17, "_ev", var21_21, var12_11);
                return;
            }
            var14_13 = var7_6.zzx.zzl();
            var23_23 = var14_13.zzK(var8_7, var9_8);
            if (var23_23 != null) {
                var9_8 = this;
                var8_7 = var2_2;
                this.zzA((String)var10_9, var2_2, var5_5, var23_23);
            }
            return;
        }
        var9_8 = this;
        var8_7 = var2_2;
        this.zzA((String)var10_9, var2_2, var5_5, null);
    }
}

