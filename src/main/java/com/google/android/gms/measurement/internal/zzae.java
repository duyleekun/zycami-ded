/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.res.Resources$NotFoundException
 *  android.os.Bundle
 *  android.text.TextUtils
 */
package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzmp;
import com.google.android.gms.measurement.internal.zzac;
import com.google.android.gms.measurement.internal.zzad;
import com.google.android.gms.measurement.internal.zzdv;
import com.google.android.gms.measurement.internal.zzdw;
import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzei;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzge;
import com.google.android.gms.measurement.internal.zzkk;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public final class zzae
extends zzge {
    private Boolean zza;
    private zzad zzb;
    private Boolean zzc;

    public zzae(zzfl object) {
        super((zzfl)object);
        this.zzb = object = zzac.zza;
    }

    public static final long zzA() {
        return (Long)zzdw.zzC.zzb(null);
    }

    private final String zzB(String object, String object2) {
        object2 = String.class;
        String string2 = "";
        Object[] objectArray = "android.os.SystemProperties";
        objectArray = Class.forName((String)objectArray);
        int n10 = 2;
        Class[] classArray = new Class[n10];
        classArray[0] = object2;
        int n11 = 1;
        classArray[n11] = object2;
        object2 = "get";
        object2 = objectArray.getMethod((String)object2, classArray);
        objectArray = new Object[n10];
        objectArray[0] = object;
        objectArray[n11] = string2;
        object = null;
        object = ((Method)object2).invoke(null, objectArray);
        object = (String)object;
        try {
            Preconditions.checkNotNull(object);
            return object;
        }
        catch (InvocationTargetException invocationTargetException) {
            object2 = this.zzx.zzat().zzb();
            objectArray = "SystemProperties.get() threw an exception";
            ((zzeg)object2).zzb((String)objectArray, invocationTargetException);
        }
        catch (IllegalAccessException illegalAccessException) {
            object2 = this.zzx.zzat().zzb();
            objectArray = "Could not access SystemProperties.get()";
            ((zzeg)object2).zzb((String)objectArray, illegalAccessException);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            object2 = this.zzx.zzat().zzb();
            objectArray = "Could not find SystemProperties.get() method";
            ((zzeg)object2).zzb((String)objectArray, noSuchMethodException);
        }
        catch (ClassNotFoundException classNotFoundException) {
            object2 = this.zzx.zzat().zzb();
            objectArray = "Could not find SystemProperties class";
            ((zzeg)object2).zzb((String)objectArray, classNotFoundException);
        }
        return string2;
    }

    public static final long zzz() {
        return (Long)zzdw.zzc.zzb(null);
    }

    public final void zza(zzad zzad2) {
        this.zzb = zzad2;
    }

    public final String zzb() {
        this.zzx.zzas();
        return "FA";
    }

    public final int zzc() {
        int n10;
        zzkk zzkk2 = this.zzx.zzl();
        Boolean bl2 = zzkk2.zzx.zzy().zzC();
        int n11 = zzkk2.zzZ();
        if (n11 < (n10 = 201500) && (bl2 == null || (n11 = (int)(bl2.booleanValue() ? 1 : 0)) != 0)) {
            return 25;
        }
        return 100;
    }

    public final int zzd(String string2) {
        zzdv zzdv2 = zzdw.zzH;
        return this.zzl(string2, zzdv2, 25, 100);
    }

    public final int zze(String string2) {
        zzdv zzdv2 = zzdw.zzG;
        return this.zzl(string2, zzdv2, 500, 2000);
    }

    public final long zzf() {
        this.zzx.zzas();
        return 39000L;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean zzh() {
        Object object = this.zzc;
        if (object != null) return this.zzc;
        synchronized (this) {
            object = this.zzc;
            if (object != null) return this.zzc;
            object = this.zzx;
            object = ((zzfl)object).zzaw();
            object = object.getApplicationInfo();
            String string2 = ProcessUtils.getMyProcessName();
            if (object != null) {
                boolean bl2;
                object = ((ApplicationInfo)object).processName;
                boolean bl3 = false;
                if (object != null && (bl2 = ((String)object).equals(string2))) {
                    bl3 = true;
                }
                this.zzc = object = Boolean.valueOf(bl3);
            }
            if ((object = this.zzc) != null) return this.zzc;
            this.zzc = object = Boolean.TRUE;
            object = this.zzx;
            object = ((zzfl)object).zzat();
            object = ((zzei)object).zzb();
            string2 = "My process not in the list of running processes";
            ((zzeg)object).zza(string2);
            return this.zzc;
        }
    }

    public final String zzi(String string2, zzdv zzdv2) {
        if (string2 == null) {
            return (String)zzdv2.zzb(null);
        }
        zzad zzad2 = this.zzb;
        String string3 = zzdv2.zza();
        string2 = zzad2.zza(string2, string3);
        return (String)zzdv2.zzb(string2);
    }

    public final long zzj(String object, zzdv zzdv2) {
        long l10;
        if (object == null) {
            return (Long)zzdv2.zzb(null);
        }
        zzad zzad2 = this.zzb;
        String string2 = zzdv2.zza();
        boolean bl2 = TextUtils.isEmpty((CharSequence)(object = zzad2.zza((String)object, string2)));
        if (bl2) {
            return (Long)zzdv2.zzb(null);
        }
        try {
            l10 = Long.parseLong((String)object);
        }
        catch (NumberFormatException numberFormatException) {
            return (Long)zzdv2.zzb(null);
        }
        object = l10;
        object = zzdv2.zzb(object);
        object = (Long)object;
        return (Long)object;
    }

    public final int zzk(String object, zzdv zzdv2) {
        int n10;
        if (object == null) {
            return (Integer)zzdv2.zzb(null);
        }
        zzad zzad2 = this.zzb;
        String string2 = zzdv2.zza();
        boolean bl2 = TextUtils.isEmpty((CharSequence)(object = zzad2.zza((String)object, string2)));
        if (bl2) {
            return (Integer)zzdv2.zzb(null);
        }
        try {
            n10 = Integer.parseInt((String)object);
        }
        catch (NumberFormatException numberFormatException) {
            return (Integer)zzdv2.zzb(null);
        }
        object = n10;
        object = zzdv2.zzb(object);
        object = (Integer)object;
        return (Integer)object;
    }

    public final int zzl(String string2, zzdv zzdv2, int n10, int n11) {
        return Math.max(Math.min(this.zzk(string2, zzdv2), n11), n10);
    }

    public final double zzm(String object, zzdv zzdv2) {
        double d10;
        if (object == null) {
            return (Double)zzdv2.zzb(null);
        }
        zzad zzad2 = this.zzb;
        String string2 = zzdv2.zza();
        boolean bl2 = TextUtils.isEmpty((CharSequence)(object = zzad2.zza((String)object, string2)));
        if (bl2) {
            return (Double)zzdv2.zzb(null);
        }
        try {
            d10 = Double.parseDouble((String)object);
        }
        catch (NumberFormatException numberFormatException) {
            return (Double)zzdv2.zzb(null);
        }
        object = d10;
        object = zzdv2.zzb(object);
        object = (Double)object;
        return (Double)object;
    }

    public final boolean zzn(String object, zzdv zzdv2) {
        if (object == null) {
            return (Boolean)zzdv2.zzb(null);
        }
        zzad zzad2 = this.zzb;
        String string2 = zzdv2.zza();
        boolean bl2 = TextUtils.isEmpty((CharSequence)(object = zzad2.zza((String)object, string2)));
        if (bl2) {
            return (Boolean)zzdv2.zzb(null);
        }
        object = Boolean.parseBoolean((String)object);
        return (Boolean)zzdv2.zzb(object);
    }

    public final Bundle zzo() {
        Object object;
        block21: {
            block20: {
                try {
                    object = this.zzx;
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {
                    this.zzx.zzat().zzb().zzb("Failed to load metadata: Package name not found", (Object)nameNotFoundException);
                    return null;
                }
                object = ((zzfl)object).zzaw();
                object = object.getPackageManager();
                if (object != null) break block20;
                object = this.zzx;
                object = ((zzfl)object).zzat();
                object = ((zzei)object).zzb();
                String string2 = "Failed to load metadata: PackageManager is null";
                ((zzeg)object).zza(string2);
                return null;
            }
            object = this.zzx;
            object = ((zzfl)object).zzaw();
            object = Wrappers.packageManager((Context)object);
            Object object2 = this.zzx;
            object2 = ((zzfl)object2).zzaw();
            object2 = object2.getPackageName();
            int n10 = 128;
            object = ((PackageManagerWrapper)object).getApplicationInfo((String)object2, n10);
            if (object != null) break block21;
            object = this.zzx;
            object = ((zzfl)object).zzat();
            object = ((zzei)object).zzb();
            object2 = "Failed to load metadata: ApplicationInfo is null";
            ((zzeg)object).zza((String)object2);
            return null;
        }
        return ((ApplicationInfo)object).metaData;
    }

    public final Boolean zzp(String string2) {
        Preconditions.checkNotEmpty(string2);
        Bundle bundle = this.zzo();
        if (bundle == null) {
            this.zzx.zzat().zzb().zza("Failed to load metadata: Metadata bundle is null");
            return null;
        }
        boolean bl2 = bundle.containsKey(string2);
        if (!bl2) {
            return null;
        }
        return bundle.getBoolean(string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final List zzq(String object) {
        object = "analytics.safelisted_events";
        Preconditions.checkNotEmpty((String)object);
        Object object2 = this.zzo();
        if (object2 == null) {
            object = this.zzx.zzat().zzb();
            object2 = "Failed to load metadata: Metadata bundle is null";
            ((zzeg)object).zza((String)object2);
            return null;
        }
        boolean bl2 = object2.containsKey((String)object);
        if (!bl2) {
            return null;
        }
        int n10 = object2.getInt((String)object);
        object = n10;
        if (object == null) return null;
        try {
            object2 = this.zzx;
            object2 = ((zzfl)object2).zzaw();
            object2 = object2.getResources();
            n10 = (Integer)object;
            object = object2.getStringArray(n10);
            if (object != null) return Arrays.asList(object);
            return null;
        }
        catch (Resources.NotFoundException notFoundException) {
            object2 = this.zzx.zzat().zzb();
            String string2 = "Failed to load string array from metadata: resource not found";
            ((zzeg)object2).zzb(string2, (Object)notFoundException);
        }
        return null;
    }

    public final boolean zzr() {
        boolean bl2;
        this.zzx.zzas();
        Boolean bl3 = this.zzp("firebase_analytics_collection_deactivated");
        return bl3 != null && (bl2 = bl3.booleanValue());
    }

    public final boolean zzs() {
        boolean bl2;
        Boolean bl3 = this.zzp("google_analytics_adid_collection_enabled");
        return bl3 == null || (bl2 = bl3.booleanValue());
        {
        }
    }

    public final boolean zzt() {
        zzmp.zzb();
        Object object = zzdw.zzas;
        boolean bl2 = this.zzn(null, (zzdv)object);
        boolean bl3 = true;
        if (!bl2) {
            return bl3;
        }
        object = this.zzp("google_analytics_automatic_screen_reporting_enabled");
        if (object != null && !(bl2 = ((Boolean)object).booleanValue())) {
            return false;
        }
        return bl3;
    }

    public final String zzu() {
        return this.zzB("debug.firebase.analytics.app", "");
    }

    public final String zzv() {
        return this.zzB("debug.deferred.deeplink", "");
    }

    public final boolean zzw(String string2) {
        string2 = this.zzb.zza(string2, "gaia_collection_enabled");
        return "1".equals(string2);
    }

    public final boolean zzx(String string2) {
        string2 = this.zzb.zza(string2, "measurement.event_sampling_enabled");
        return "1".equals(string2);
    }

    public final boolean zzy() {
        boolean bl2;
        Object object = this.zza;
        if (object == null) {
            object = this.zzp("app_measurement_lite");
            this.zza = object;
            if (object == null) {
                this.zza = object = Boolean.FALSE;
            }
        }
        return (bl2 = ((Boolean)(object = this.zza)).booleanValue()) || !(bl2 = ((zzfl)(object = this.zzx)).zzu());
        {
        }
    }
}

