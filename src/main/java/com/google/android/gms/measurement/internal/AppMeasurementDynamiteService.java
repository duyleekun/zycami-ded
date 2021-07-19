/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.RemoteException
 */
package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzlc;
import com.google.android.gms.internal.measurement.zzs;
import com.google.android.gms.internal.measurement.zzv;
import com.google.android.gms.internal.measurement.zzx;
import com.google.android.gms.internal.measurement.zzy;
import com.google.android.gms.measurement.internal.zzae;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzas;
import com.google.android.gms.measurement.internal.zzdv;
import com.google.android.gms.measurement.internal.zzdw;
import com.google.android.gms.measurement.internal.zzfi;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzgm;
import com.google.android.gms.measurement.internal.zzgo;
import com.google.android.gms.measurement.internal.zzgq;
import com.google.android.gms.measurement.internal.zzgs;
import com.google.android.gms.measurement.internal.zzh;
import com.google.android.gms.measurement.internal.zzhm;
import com.google.android.gms.measurement.internal.zzhn;
import com.google.android.gms.measurement.internal.zzi;
import com.google.android.gms.measurement.internal.zzib;
import com.google.android.gms.measurement.internal.zzj;
import com.google.android.gms.measurement.internal.zzk;
import com.google.android.gms.measurement.internal.zzkk;
import com.google.android.gms.measurement.internal.zzl;
import com.google.android.gms.measurement.internal.zzm;
import com.google.android.gms.measurement.internal.zzn;
import com.google.android.gms.measurement.internal.zzo;
import java.util.Map;

public class AppMeasurementDynamiteService
extends com.google.android.gms.internal.measurement.zzo {
    public zzfl zza = null;
    private final Map zzb;

    public AppMeasurementDynamiteService() {
        ArrayMap arrayMap = new ArrayMap();
        this.zzb = arrayMap;
    }

    private final void zzb() {
        Object object = this.zza;
        if (object != null) {
            return;
        }
        object = new IllegalStateException("Attempting to perform action before initialize.");
        throw object;
    }

    private final void zzc(zzs zzs2, String string2) {
        this.zzb();
        this.zza.zzl().zzad(zzs2, string2);
    }

    public void beginAdUnitExposure(String string2, long l10) {
        this.zzb();
        this.zza.zzB().zza(string2, l10);
    }

    public void clearConditionalUserProperty(String string2, String string3, Bundle bundle) {
        this.zzb();
        this.zza.zzk().zzO(string2, string3, bundle);
    }

    public void clearMeasurementEnabled(long l10) {
        this.zzb();
        this.zza.zzk().zzn(null);
    }

    public void endAdUnitExposure(String string2, long l10) {
        this.zzb();
        this.zza.zzB().zzb(string2, l10);
    }

    public void generateEventId(zzs zzs2) {
        this.zzb();
        long l10 = this.zza.zzl().zzd();
        this.zzb();
        this.zza.zzl().zzae(zzs2, l10);
    }

    public void getAppInstanceId(zzs zzs2) {
        this.zzb();
        zzfi zzfi2 = this.zza.zzau();
        zzh zzh2 = new zzh(this, zzs2);
        zzfi2.zzh(zzh2);
    }

    public void getCachedAppInstanceId(zzs zzs2) {
        this.zzb();
        String string2 = this.zza.zzk().zzD();
        this.zzc(zzs2, string2);
    }

    public void getConditionalUserProperties(String string2, String string3, zzs zzs2) {
        this.zzb();
        zzfi zzfi2 = this.zza.zzau();
        zzl zzl2 = new zzl(this, zzs2, string2, string3);
        zzfi2.zzh(zzl2);
    }

    public void getCurrentScreenClass(zzs zzs2) {
        this.zzb();
        String string2 = this.zza.zzk().zzS();
        this.zzc(zzs2, string2);
    }

    public void getCurrentScreenName(zzs zzs2) {
        this.zzb();
        String string2 = this.zza.zzk().zzR();
        this.zzc(zzs2, string2);
    }

    public void getGmpAppId(zzs zzs2) {
        this.zzb();
        String string2 = this.zza.zzk().zzT();
        this.zzc(zzs2, string2);
    }

    public void getMaxUserProperties(String string2, zzs zzs2) {
        this.zzb();
        this.zza.zzk().zzL(string2);
        this.zzb();
        this.zza.zzl().zzaf(zzs2, 25);
    }

    public void getTestFlag(zzs zzs2, int n10) {
        this.zzb();
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 3;
                    if (n10 != n11) {
                        n11 = 4;
                        if (n10 != n11) {
                            return;
                        }
                        zzkk zzkk2 = this.zza.zzl();
                        n11 = (int)(this.zza.zzk().zzi().booleanValue() ? 1 : 0);
                        zzkk2.zzah(zzs2, n11 != 0);
                        return;
                    }
                    zzkk zzkk3 = this.zza.zzl();
                    n11 = this.zza.zzk().zzl();
                    zzkk3.zzaf(zzs2, n11);
                    return;
                }
                zzkk zzkk4 = this.zza.zzl();
                Double d10 = this.zza.zzk().zzm();
                double d11 = d10;
                Bundle bundle = new Bundle();
                String string2 = "r";
                bundle.putDouble(string2, d11);
                try {
                    zzs2.zzb(bundle);
                    return;
                }
                catch (RemoteException remoteException) {
                    zzkk4.zzx.zzat().zze().zzb("Error returning double value to wrapper", (Object)remoteException);
                    return;
                }
            }
            zzkk zzkk5 = this.zza.zzl();
            long l10 = this.zza.zzk().zzk();
            zzkk5.zzae(zzs2, l10);
            return;
        }
        zzkk zzkk6 = this.zza.zzl();
        String string3 = this.zza.zzk().zzj();
        zzkk6.zzad(zzs2, string3);
    }

    public void getUserProperties(String string2, String string3, boolean bl2, zzs zzs2) {
        this.zzb();
        zzfi zzfi2 = this.zza.zzau();
        zzj zzj2 = new zzj(this, zzs2, string2, string3, bl2);
        zzfi2.zzh(zzj2);
    }

    public void initForTests(Map map) {
        this.zzb();
    }

    public void initialize(IObjectWrapper object, zzy zzy2, long l10) {
        zzfl zzfl2 = this.zza;
        if (zzfl2 == null) {
            object = (Context)Preconditions.checkNotNull((Context)ObjectWrapper.unwrap((IObjectWrapper)object));
            Long l11 = l10;
            this.zza = object = zzfl.zzC((Context)object, zzy2, l11);
            return;
        }
        zzfl2.zzat().zze().zza("Attempting to initialize multiple times");
    }

    public void isDataCollectionEnabled(zzs zzs2) {
        this.zzb();
        zzfi zzfi2 = this.zza.zzau();
        zzm zzm2 = new zzm(this, zzs2);
        zzfi2.zzh(zzm2);
    }

    public void logEvent(String string2, String string3, Bundle bundle, boolean bl2, boolean bl3, long l10) {
        this.zzb();
        this.zza.zzk().zzv(string2, string3, bundle, bl2, bl3, l10);
    }

    public void logEventAndBundle(String string2, String object, Bundle object2, zzs zzs2, long l10) {
        this.zzb();
        Preconditions.checkNotEmpty((String)object);
        Object object3 = object2 != null ? new Bundle(object2) : new Bundle();
        String string3 = "app";
        object3.putString("_o", string3);
        zzaq zzaq2 = new zzaq((Bundle)object2);
        object3 = new zzas((String)object, zzaq2, string3, l10);
        object = this.zza.zzau();
        object2 = new zzi(this, zzs2, (zzas)object3, string2);
        ((zzfi)object).zzh((Runnable)object2);
    }

    public void logHealthData(int n10, String string2, IObjectWrapper object, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        this.zzb();
        Object object2 = null;
        Object object3 = object == null ? null : (object = ObjectWrapper.unwrap((IObjectWrapper)object));
        Object object4 = iObjectWrapper == null ? null : (object = ObjectWrapper.unwrap(iObjectWrapper));
        if (iObjectWrapper2 != null) {
            object2 = ObjectWrapper.unwrap(iObjectWrapper2);
        }
        this.zza.zzat().zzm(n10, true, false, string2, object3, object4, object2);
    }

    public void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long l10) {
        this.zzb();
        zzhm zzhm2 = this.zza.zzk().zza;
        if (zzhm2 != null) {
            zzhn zzhn2 = this.zza.zzk();
            zzhn2.zzh();
            iObjectWrapper = (Activity)ObjectWrapper.unwrap(iObjectWrapper);
            zzhm2.onActivityCreated((Activity)iObjectWrapper, bundle);
        }
    }

    public void onActivityDestroyed(IObjectWrapper iObjectWrapper, long l10) {
        this.zzb();
        zzhm zzhm2 = this.zza.zzk().zza;
        if (zzhm2 != null) {
            zzhn zzhn2 = this.zza.zzk();
            zzhn2.zzh();
            iObjectWrapper = (Activity)ObjectWrapper.unwrap(iObjectWrapper);
            zzhm2.onActivityDestroyed((Activity)iObjectWrapper);
        }
    }

    public void onActivityPaused(IObjectWrapper iObjectWrapper, long l10) {
        this.zzb();
        zzhm zzhm2 = this.zza.zzk().zza;
        if (zzhm2 != null) {
            zzhn zzhn2 = this.zza.zzk();
            zzhn2.zzh();
            iObjectWrapper = (Activity)ObjectWrapper.unwrap(iObjectWrapper);
            zzhm2.onActivityPaused((Activity)iObjectWrapper);
        }
    }

    public void onActivityResumed(IObjectWrapper iObjectWrapper, long l10) {
        this.zzb();
        zzhm zzhm2 = this.zza.zzk().zza;
        if (zzhm2 != null) {
            zzhn zzhn2 = this.zza.zzk();
            zzhn2.zzh();
            iObjectWrapper = (Activity)ObjectWrapper.unwrap(iObjectWrapper);
            zzhm2.onActivityResumed((Activity)iObjectWrapper);
        }
    }

    public void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzs zzs2, long l10) {
        this.zzb();
        zzhm zzhm2 = this.zza.zzk().zza;
        Bundle bundle = new Bundle();
        if (zzhm2 != null) {
            zzhn zzhn2 = this.zza.zzk();
            zzhn2.zzh();
            iObjectWrapper = (Activity)ObjectWrapper.unwrap(iObjectWrapper);
            zzhm2.onActivitySaveInstanceState((Activity)iObjectWrapper, bundle);
        }
        try {
            zzs2.zzb(bundle);
            return;
        }
        catch (RemoteException remoteException) {
            this.zza.zzat().zze().zzb("Error returning bundle value to wrapper", (Object)remoteException);
            return;
        }
    }

    public void onActivityStarted(IObjectWrapper iObjectWrapper, long l10) {
        this.zzb();
        Object object = this.zza.zzk().zza;
        if (object != null) {
            object = this.zza.zzk();
            ((zzhn)object).zzh();
            iObjectWrapper = (Activity)ObjectWrapper.unwrap(iObjectWrapper);
        }
    }

    public void onActivityStopped(IObjectWrapper iObjectWrapper, long l10) {
        this.zzb();
        Object object = this.zza.zzk().zza;
        if (object != null) {
            object = this.zza.zzk();
            ((zzhn)object).zzh();
            iObjectWrapper = (Activity)ObjectWrapper.unwrap(iObjectWrapper);
        }
    }

    public void performAction(Bundle bundle, zzs zzs2, long l10) {
        this.zzb();
        zzs2.zzb(null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void registerOnMeasurementEventListener(zzv object) {
        Object object2;
        this.zzb();
        Map map = this.zzb;
        synchronized (map) {
            object2 = this.zzb;
            int n10 = object.zze();
            Object object3 = n10;
            object2 = object2.get(object3);
            object2 = (zzgm)object2;
            if (object2 == null) {
                object2 = new zzo(this, (zzv)object);
                object3 = this.zzb;
                int n11 = object.zze();
                object = n11;
                object3.put(object, object2);
            }
        }
        this.zza.zzk().zzJ((zzgm)object2);
    }

    public void resetAnalyticsData(long l10) {
        this.zzb();
        this.zza.zzk().zzF(l10);
    }

    public void setConditionalUserProperty(Bundle bundle, long l10) {
        this.zzb();
        if (bundle == null) {
            this.zza.zzat().zzb().zza("Conditional user property must not be null");
            return;
        }
        this.zza.zzk().zzN(bundle, l10);
    }

    public void setConsent(Bundle bundle, long l10) {
        this.zzb();
        zzhn zzhn2 = this.zza.zzk();
        zzlc.zzb();
        zzae zzae2 = zzhn2.zzx.zzc();
        zzdv zzdv2 = zzdw.zzaw;
        int n10 = zzae2.zzn(null, zzdv2);
        if (n10 != 0) {
            n10 = 30;
            zzhn2.zzo(bundle, n10, l10);
        }
    }

    public void setConsentThirdParty(Bundle bundle, long l10) {
        this.zzb();
        zzhn zzhn2 = this.zza.zzk();
        zzlc.zzb();
        zzae zzae2 = zzhn2.zzx.zzc();
        zzdv zzdv2 = zzdw.zzax;
        int n10 = zzae2.zzn(null, zzdv2);
        if (n10 != 0) {
            n10 = 10;
            zzhn2.zzo(bundle, n10, l10);
        }
    }

    public void setCurrentScreen(IObjectWrapper iObjectWrapper, String string2, String string3, long l10) {
        this.zzb();
        zzib zzib2 = this.zza.zzx();
        iObjectWrapper = (Activity)ObjectWrapper.unwrap(iObjectWrapper);
        zzib2.zzk((Activity)iObjectWrapper, string2, string3);
    }

    public void setDataCollectionEnabled(boolean bl2) {
        this.zzb();
        zzhn zzhn2 = this.zza.zzk();
        zzhn2.zzb();
        zzfi zzfi2 = zzhn2.zzx.zzau();
        zzgq zzgq2 = new zzgq(zzhn2, bl2);
        zzfi2.zzh(zzgq2);
    }

    public void setDefaultEventParameters(Bundle bundle) {
        Object object;
        this.zzb();
        zzhn zzhn2 = this.zza.zzk();
        if (bundle == null) {
            bundle = null;
        } else {
            object = new Bundle(bundle);
            bundle = object;
        }
        object = zzhn2.zzx.zzau();
        zzgo zzgo2 = new zzgo(zzhn2, bundle);
        ((zzfi)object).zzh(zzgo2);
    }

    public void setEventInterceptor(zzv object) {
        this.zzb();
        zzn zzn2 = new zzn(this, (zzv)object);
        object = this.zza.zzau();
        boolean bl2 = ((zzfi)object).zzd();
        if (bl2) {
            this.zza.zzk().zzI(zzn2);
            return;
        }
        object = this.zza.zzau();
        zzk zzk2 = new zzk(this, zzn2);
        ((zzfi)object).zzh(zzk2);
    }

    public void setInstanceIdProvider(zzx zzx2) {
        this.zzb();
    }

    public void setMeasurementEnabled(boolean bl2, long l10) {
        this.zzb();
        zzhn zzhn2 = this.zza.zzk();
        Boolean bl3 = bl2;
        zzhn2.zzn(bl3);
    }

    public void setMinimumSessionDuration(long l10) {
        this.zzb();
    }

    public void setSessionTimeoutDuration(long l10) {
        this.zzb();
        zzhn zzhn2 = this.zza.zzk();
        zzfi zzfi2 = zzhn2.zzx.zzau();
        zzgs zzgs2 = new zzgs(zzhn2, l10);
        zzfi2.zzh(zzgs2);
    }

    public void setUserId(String string2, long l10) {
        this.zzb();
        this.zza.zzk().zzz(null, "_id", string2, true, l10);
    }

    public void setUserProperty(String string2, String string3, IObjectWrapper iObjectWrapper, boolean bl2, long l10) {
        this.zzb();
        Object object = ObjectWrapper.unwrap(iObjectWrapper);
        this.zza.zzk().zzz(string2, string3, object, bl2, l10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void unregisterOnMeasurementEventListener(zzv zzv2) {
        this.zzb();
        Map map = this.zzb;
        // MONITORENTER : map
        Object object = this.zzb;
        int n10 = zzv2.zze();
        Integer n11 = n10;
        object = object.remove(n11);
        object = (zzgm)object;
        // MONITOREXIT : map
        if (object == null) {
            object = new zzo(this, zzv2);
        }
        this.zza.zzk().zzK((zzgm)object);
    }
}

