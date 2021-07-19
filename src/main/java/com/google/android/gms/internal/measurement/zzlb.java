/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.gms.internal.measurement;

import android.net.Uri;
import com.google.android.gms.internal.measurement.zzex;
import com.google.android.gms.internal.measurement.zzfe;
import com.google.android.gms.internal.measurement.zzfg;
import com.google.android.gms.internal.measurement.zzla;

public final class zzlb
implements zzla {
    public static final zzfg zzA;
    public static final zzfg zzB;
    public static final zzfg zzC;
    public static final zzfg zzD;
    public static final zzfg zzE;
    public static final zzfg zzF;
    public static final zzfg zzG;
    public static final zzfg zzH;
    public static final zzfg zzI;
    public static final zzfg zzJ;
    public static final zzfg zzK;
    public static final zzfg zzL;
    public static final zzfg zza;
    public static final zzfg zzb;
    public static final zzfg zzc;
    public static final zzfg zzd;
    public static final zzfg zze;
    public static final zzfg zzf;
    public static final zzfg zzg;
    public static final zzfg zzh;
    public static final zzfg zzi;
    public static final zzfg zzj;
    public static final zzfg zzk;
    public static final zzfg zzl;
    public static final zzfg zzm;
    public static final zzfg zzn;
    public static final zzfg zzo;
    public static final zzfg zzp;
    public static final zzfg zzq;
    public static final zzfg zzr;
    public static final zzfg zzs;
    public static final zzfg zzt;
    public static final zzfg zzu;
    public static final zzfg zzv;
    public static final zzfg zzw;
    public static final zzfg zzx;
    public static final zzfg zzy;
    public static final zzfg zzz;

    static {
        Uri uri = zzex.zza("com.google.android.gms.measurement");
        zzfe zzfe2 = new zzfe(uri);
        long l10 = 10000L;
        zza = zzfe2.zza("measurement.ad_id_cache_time", l10);
        long l11 = 100;
        zzb = zzfe2.zza("measurement.max_bundles_per_iteration", l11);
        long l12 = 86400000L;
        zzc = zzfe2.zza("measurement.config.cache_time", l12);
        zzd = zzfe2.zzd("measurement.log_tag", "FA");
        zze = zzfe2.zzd("measurement.config.url_authority", "app-measurement.com");
        zzf = zzfe2.zzd("measurement.config.url_scheme", "https");
        long l13 = 1000L;
        zzg = zzfe2.zza("measurement.upload.debug_upload_interval", l13);
        zzh = zzfe2.zza("measurement.lifetimevalue.max_currency_tracked", 4);
        zzi = zzfe2.zza("measurement.store.max_stored_events_per_app", 100000L);
        zzj = zzfe2.zza("measurement.experiment.max_ids", 50);
        zzk = zzfe2.zza("measurement.audience.filter_result_max_count", 200L);
        zzl = zzfe2.zza("measurement.alarm_manager.minimum_interval", 60000L);
        long l14 = 500L;
        zzm = zzfe2.zza("measurement.upload.minimum_delay", l14);
        zzn = zzfe2.zza("measurement.monitoring.sample_period_millis", l12);
        zzo = zzfe2.zza("measurement.upload.realtime_upload_interval", l10);
        l10 = 604800000L;
        zzp = zzfe2.zza("measurement.upload.refresh_blacklisted_config_interval", l10);
        long l15 = 3600000L;
        zzq = zzfe2.zza("measurement.config.cache_time.service", l15);
        zzr = zzfe2.zza("measurement.service_client.idle_disconnect_millis", 5000L);
        zzs = zzfe2.zzd("measurement.log_tag.service", "FA-SVC");
        zzt = zzfe2.zza("measurement.upload.stale_data_deletion_interval", l12);
        zzu = zzfe2.zza("measurement.sdk.attribution.cache.ttl", l10);
        zzv = zzfe2.zza("measurement.upload.backoff_period", 43200000L);
        zzw = zzfe2.zza("measurement.upload.initial_upload_delay_time", 15000L);
        zzx = zzfe2.zza("measurement.upload.interval", l15);
        l10 = 65536L;
        zzy = zzfe2.zza("measurement.upload.max_bundle_size", l10);
        zzz = zzfe2.zza("measurement.upload.max_bundles", l11);
        zzA = zzfe2.zza("measurement.upload.max_conversions_per_day", l14);
        zzB = zzfe2.zza("measurement.upload.max_error_events_per_day", l13);
        zzC = zzfe2.zza("measurement.upload.max_events_per_bundle", l13);
        zzD = zzfe2.zza("measurement.upload.max_events_per_day", 100000L);
        zzE = zzfe2.zza("measurement.upload.max_public_events_per_day", 50000L);
        zzF = zzfe2.zza("measurement.upload.max_queue_time", 2419200000L);
        zzG = zzfe2.zza("measurement.upload.max_realtime_events_per_day", 10);
        zzH = zzfe2.zza("measurement.upload.max_batch_size", l10);
        zzI = zzfe2.zza("measurement.upload.retry_count", 6);
        zzJ = zzfe2.zza("measurement.upload.retry_time", 1800000L);
        zzK = zzfe2.zzd("measurement.upload.url", "https://app-measurement.com/a");
        zzL = zzfe2.zza("measurement.upload.window_interval", l15);
    }

    public final long zzA() {
        return (Long)zzD.zze();
    }

    public final long zzB() {
        return (Long)zzE.zze();
    }

    public final long zzC() {
        return (Long)zzF.zze();
    }

    public final long zzD() {
        return (Long)zzG.zze();
    }

    public final long zzE() {
        return (Long)zzH.zze();
    }

    public final long zzF() {
        return (Long)zzI.zze();
    }

    public final long zzG() {
        return (Long)zzJ.zze();
    }

    public final String zzH() {
        return (String)zzK.zze();
    }

    public final long zzI() {
        return (Long)zzL.zze();
    }

    public final long zza() {
        return (Long)zza.zze();
    }

    public final long zzb() {
        return (Long)zzb.zze();
    }

    public final long zzc() {
        return (Long)zzc.zze();
    }

    public final String zzd() {
        return (String)zze.zze();
    }

    public final String zze() {
        return (String)zzf.zze();
    }

    public final long zzf() {
        return (Long)zzg.zze();
    }

    public final long zzg() {
        return (Long)zzh.zze();
    }

    public final long zzh() {
        return (Long)zzi.zze();
    }

    public final long zzi() {
        return (Long)zzj.zze();
    }

    public final long zzj() {
        return (Long)zzk.zze();
    }

    public final long zzk() {
        return (Long)zzl.zze();
    }

    public final long zzl() {
        return (Long)zzm.zze();
    }

    public final long zzm() {
        return (Long)zzn.zze();
    }

    public final long zzn() {
        return (Long)zzo.zze();
    }

    public final long zzo() {
        return (Long)zzp.zze();
    }

    public final long zzp() {
        return (Long)zzr.zze();
    }

    public final long zzq() {
        return (Long)zzt.zze();
    }

    public final long zzr() {
        return (Long)zzu.zze();
    }

    public final long zzs() {
        return (Long)zzv.zze();
    }

    public final long zzt() {
        return (Long)zzw.zze();
    }

    public final long zzu() {
        return (Long)zzx.zze();
    }

    public final long zzv() {
        return (Long)zzy.zze();
    }

    public final long zzw() {
        return (Long)zzz.zze();
    }

    public final long zzx() {
        return (Long)zzA.zze();
    }

    public final long zzy() {
        return (Long)zzB.zze();
    }

    public final long zzz() {
        return (Long)zzC.zze();
    }
}

