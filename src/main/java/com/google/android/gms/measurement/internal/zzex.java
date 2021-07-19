/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.util.Pair
 */
package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient$Info;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzae;
import com.google.android.gms.measurement.internal.zzaf;
import com.google.android.gms.measurement.internal.zzdv;
import com.google.android.gms.measurement.internal.zzdw;
import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzes;
import com.google.android.gms.measurement.internal.zzet;
import com.google.android.gms.measurement.internal.zzeu;
import com.google.android.gms.measurement.internal.zzev;
import com.google.android.gms.measurement.internal.zzew;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzgf;

public final class zzex
extends zzgf {
    public static final Pair zza;
    private boolean zzA;
    private long zzB;
    public zzev zzb;
    public final zzeu zzc;
    public final zzeu zzd;
    public final zzeu zze;
    public final zzeu zzf;
    public final zzeu zzg;
    public final zzeu zzh;
    public final zzeu zzi;
    public final zzew zzj;
    public final zzeu zzk;
    public final zzes zzl;
    public final zzew zzm;
    public final zzes zzn;
    public final zzeu zzo;
    public boolean zzp;
    public final zzes zzq;
    public final zzes zzr;
    public final zzeu zzs;
    public final zzew zzt;
    public final zzew zzu;
    public final zzeu zzv;
    public final zzet zzw;
    private SharedPreferences zzy;
    private String zzz;

    static {
        Pair pair;
        Long l10 = 0L;
        zza = pair = new Pair((Object)"", (Object)l10);
    }

    public zzex(zzfl object) {
        super((zzfl)object);
        long l10 = 0L;
        this.zzc = object = new zzeu(this, "last_upload", l10);
        this.zzd = object = new zzeu(this, "last_upload_attempt", l10);
        this.zze = object = new zzeu(this, "backoff", l10);
        this.zzf = object = new zzeu(this, "last_delete_stale", l10);
        this.zzk = object = new zzeu(this, "session_timeout", 1800000L);
        this.zzl = object = new zzes(this, "start_new_session", true);
        this.zzo = object = new zzeu(this, "last_pause_time", l10);
        this.zzm = object = new zzew(this, "non_personalized_ads", null);
        this.zzn = object = new zzes(this, "allow_remote_dynamite", false);
        this.zzg = object = new zzeu(this, "midnight_offset", l10);
        this.zzh = object = new zzeu(this, "first_open_time", l10);
        this.zzi = object = new zzeu(this, "app_install_time", l10);
        this.zzj = object = new zzew(this, "app_instance_id", null);
        this.zzq = object = new zzes(this, "app_backgrounded", false);
        this.zzr = object = new zzes(this, "deep_link_retrieval_complete", false);
        this.zzs = object = new zzeu(this, "deep_link_retrieval_attempts", l10);
        this.zzt = object = new zzew(this, "firebase_feature_rollouts", null);
        this.zzu = object = new zzew(this, "deferred_attribution_cache", null);
        this.zzv = object = new zzeu(this, "deferred_attribution_cache_timestamp", l10);
        this.zzw = object = new zzet(this, "default_event_parameters", null);
    }

    public final boolean zza() {
        return true;
    }

    public final void zzay() {
        boolean bl2;
        Object object = this.zzx.zzaw();
        boolean bl3 = false;
        object = object.getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.zzy = object;
        String string2 = "has_been_opened";
        this.zzp = bl2 = object.getBoolean(string2, false);
        if (!bl2) {
            object = this.zzy.edit();
            bl3 = true;
            object.putBoolean(string2, bl3);
            object.apply();
        }
        this.zzx.zzc();
        long l10 = (Long)zzdw.zzb.zzb(null);
        long l11 = Math.max(0L, l10);
        object = new zzev(this, "health_monitor", l11, null);
        this.zzb = object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Pair zzb(String object) {
        long l10;
        long l11;
        long l12;
        Object object2 = "";
        this.zzg();
        Object object3 = this.zzx.zzax();
        long l13 = object3.elapsedRealtime();
        Object object4 = this.zzz;
        if (object4 != null && (l12 = (l11 = l13 - (l10 = this.zzB)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) < 0) {
            object2 = this.zzA;
            return new Pair(object4, object2);
        }
        object4 = this.zzx.zzc();
        zzdv zzdv2 = zzdw.zza;
        long l14 = ((zzae)object4).zzj((String)object, zzdv2);
        this.zzB = l13 += l14;
        boolean bl2 = true;
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(bl2);
        try {
            object = this.zzx;
            object = ((zzfl)object).zzaw();
            object = AdvertisingIdClient.getAdvertisingIdInfo((Context)object);
            if (object != null) {
                this.zzz = object3 = ((AdvertisingIdClient$Info)object).getId();
                this.zzA = bl2 = ((AdvertisingIdClient$Info)object).isLimitAdTrackingEnabled();
            }
            if ((object = this.zzz) == null) {
                this.zzz = object2;
            }
        }
        catch (Exception exception) {
            object3 = this.zzx.zzat().zzj();
            String string2 = "Unable to get advertising id";
            ((zzeg)object3).zzb(string2, exception);
            this.zzz = object2;
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        object2 = this.zzz;
        object3 = this.zzA;
        return new Pair(object2, object3);
    }

    public final SharedPreferences zzd() {
        this.zzg();
        this.zzv();
        Preconditions.checkNotNull(this.zzy);
        return this.zzy;
    }

    public final void zze(Boolean bl2) {
        this.zzg();
        SharedPreferences.Editor editor = this.zzd().edit();
        String string2 = "measurement_enabled";
        if (bl2 != null) {
            boolean bl3 = bl2;
            editor.putBoolean(string2, bl3);
        } else {
            editor.remove(string2);
        }
        editor.apply();
    }

    public final Boolean zzf() {
        this.zzg();
        SharedPreferences sharedPreferences = this.zzd();
        String string2 = "measurement_enabled";
        boolean bl2 = sharedPreferences.contains(string2);
        if (bl2) {
            return this.zzd().getBoolean(string2, true);
        }
        return null;
    }

    public final boolean zzh(int n10) {
        int n11 = this.zzd().getInt("consent_source", 100);
        return zzaf.zzm(n10, n11);
    }

    public final zzaf zzi() {
        this.zzg();
        return zzaf.zzc(this.zzd().getString("consent_settings", "G1"));
    }

    public final void zzj(boolean bl2) {
        this.zzg();
        zzeg zzeg2 = this.zzx.zzat().zzk();
        Boolean bl3 = bl2;
        zzeg2.zzb("App measurement setting deferred collection", bl3);
        zzeg2 = this.zzd().edit();
        zzeg2.putBoolean("deferred_analytics_collection", bl2);
        zzeg2.apply();
    }

    public final boolean zzk() {
        SharedPreferences sharedPreferences = this.zzy;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.contains("deferred_analytics_collection");
    }

    public final boolean zzl(long l10) {
        long l11 = this.zzk.zza();
        zzeu zzeu2 = this.zzo;
        long l12 = (l10 -= l11) - (l11 = zzeu2.zza());
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        return object > 0;
    }
}

