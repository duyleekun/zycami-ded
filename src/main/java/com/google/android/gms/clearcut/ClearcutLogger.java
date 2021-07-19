/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.util.Log
 */
package com.google.android.gms.clearcut;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.clearcut.ClearcutLogger$LogEventBuilder;
import com.google.android.gms.clearcut.ClearcutLogger$zza;
import com.google.android.gms.clearcut.ClearcutLogger$zzc;
import com.google.android.gms.clearcut.zza;
import com.google.android.gms.clearcut.zzb;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api$AbstractClientBuilder;
import com.google.android.gms.common.api.Api$ClientKey;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.clearcut.zze;
import com.google.android.gms.internal.clearcut.zzge$zzv$zzb;
import com.google.android.gms.internal.clearcut.zzp;
import com.google.android.gms.phenotype.ExperimentTokens;
import java.util.ArrayList;

public final class ClearcutLogger {
    public static final Api API;
    private static final Api$AbstractClientBuilder CLIENT_BUILDER;
    private static final Api$ClientKey CLIENT_KEY;
    private static final ExperimentTokens[] zze;
    private static final String[] zzf;
    private static final byte[][] zzg;
    private final String packageName;
    private final Context zzh;
    private final int zzi;
    private String zzj;
    private int zzk;
    private String zzl;
    private String zzm;
    private final boolean zzn;
    private zzge$zzv$zzb zzo;
    private final zzb zzp;
    private final Clock zzq;
    private ClearcutLogger$zzc zzr;
    private final ClearcutLogger$zza zzs;

    static {
        Api api;
        Api$ClientKey api$ClientKey;
        CLIENT_KEY = api$ClientKey = new Api$ClientKey();
        zza zza2 = new zza();
        CLIENT_BUILDER = zza2;
        API = api = new Api("ClearcutLogger.API", zza2, api$ClientKey);
        zze = new ExperimentTokens[0];
        zzf = new String[0];
        zzg = new byte[0][];
    }

    /*
     * WARNING - void declaration
     */
    private ClearcutLogger(Context object, int n10, String string2, String string3, String object2, boolean bl2, zzb zzb2, Clock clock, ClearcutLogger$zzc object3, ClearcutLogger$zza clearcutLogger$zza) {
        int bl3;
        this.zzk = n10 = -1;
        this.zzo = object2 = zzge$zzv$zzb.zzbhk;
        this.zzh = object;
        this.packageName = object3 = object.getPackageName();
        this.zzi = bl3 = ClearcutLogger.zza((Context)object);
        this.zzk = n10;
        this.zzj = string2;
        this.zzl = string3;
        boolean bl4 = false;
        this.zzm = null;
        this.zzn = bl2;
        this.zzp = zzb2;
        this.zzq = clock;
        this.zzr = object = new ClearcutLogger$zzc();
        this.zzo = object2;
        this.zzs = clearcutLogger$zza;
        if (bl2) {
            void var11_15;
            if (string3 == null) {
                boolean bl5 = true;
            } else {
                boolean bl6 = false;
                object = null;
            }
            String string4 = "can't be anonymous with an upload account";
            Preconditions.checkArgument((boolean)var11_15, string4);
        }
    }

    public ClearcutLogger(Context context, String string2, String string3) {
        zzb zzb2 = com.google.android.gms.internal.clearcut.zze.zzb(context);
        Clock clock = DefaultClock.getInstance();
        zzp zzp2 = new zzp(context);
        this(context, -1, string2, string3, null, false, zzb2, clock, null, zzp2);
    }

    public static ClearcutLogger anonymousLogger(Context context, String string2) {
        zzb zzb2 = com.google.android.gms.internal.clearcut.zze.zzb(context);
        Clock clock = DefaultClock.getInstance();
        zzp zzp2 = new zzp(context);
        ClearcutLogger clearcutLogger = new ClearcutLogger(context, -1, string2, null, null, true, zzb2, clock, null, zzp2);
        return clearcutLogger;
    }

    private static int zza(Context object) {
        int n10 = 0;
        Object object2 = object.getPackageManager();
        object = object.getPackageName();
        object = object2.getPackageInfo((String)object, 0);
        try {
            n10 = object.versionCode;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            object2 = "ClearcutLogger";
            String string2 = "This can't happen.";
            Log.wtf((String)object2, (String)string2, (Throwable)nameNotFoundException);
        }
        return n10;
    }

    public static /* synthetic */ int zza(ClearcutLogger clearcutLogger) {
        return clearcutLogger.zzk;
    }

    private static int[] zza(ArrayList arrayList) {
        if (arrayList == null) {
            return null;
        }
        int n10 = arrayList.size();
        int[] nArray = new int[n10];
        int n11 = arrayList.size();
        int n12 = 0;
        for (int i10 = 0; i10 < n11; ++i10) {
            Object object = arrayList.get(i10);
            object = (Integer)object;
            int n13 = (Integer)object;
            int n14 = n12 + 1;
            nArray[n12] = n13;
            n12 = n14;
        }
        return nArray;
    }

    public static /* synthetic */ String zzb(ClearcutLogger clearcutLogger) {
        return clearcutLogger.zzj;
    }

    public static /* synthetic */ int[] zzb(ArrayList arrayList) {
        return ClearcutLogger.zza(null);
    }

    public static /* synthetic */ String zzc(ClearcutLogger clearcutLogger) {
        return clearcutLogger.zzl;
    }

    public static /* synthetic */ zzge$zzv$zzb zzd(ClearcutLogger clearcutLogger) {
        return clearcutLogger.zzo;
    }

    public static /* synthetic */ Context zze(ClearcutLogger clearcutLogger) {
        return clearcutLogger.zzh;
    }

    public static /* synthetic */ Clock zzf(ClearcutLogger clearcutLogger) {
        return clearcutLogger.zzq;
    }

    public static /* synthetic */ ClearcutLogger$zzc zzg(ClearcutLogger clearcutLogger) {
        return clearcutLogger.zzr;
    }

    public static /* synthetic */ boolean zzh(ClearcutLogger clearcutLogger) {
        return clearcutLogger.zzn;
    }

    public static /* synthetic */ String zzi(ClearcutLogger clearcutLogger) {
        return clearcutLogger.packageName;
    }

    public static /* synthetic */ int zzj(ClearcutLogger clearcutLogger) {
        return clearcutLogger.zzi;
    }

    public static /* synthetic */ ClearcutLogger$zza zzk(ClearcutLogger clearcutLogger) {
        return clearcutLogger.zzs;
    }

    public static /* synthetic */ zzb zzl(ClearcutLogger clearcutLogger) {
        return clearcutLogger.zzp;
    }

    public final ClearcutLogger$LogEventBuilder newEvent(byte[] byArray) {
        ClearcutLogger$LogEventBuilder clearcutLogger$LogEventBuilder = new ClearcutLogger$LogEventBuilder(this, byArray, null);
        return clearcutLogger$LogEventBuilder;
    }
}

