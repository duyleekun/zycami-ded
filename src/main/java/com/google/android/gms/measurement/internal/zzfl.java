/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.Context
 *  android.content.Intent
 *  android.net.ConnectivityManager
 *  android.net.Uri
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.util.Pair
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzfg;
import com.google.android.gms.internal.measurement.zzlc;
import com.google.android.gms.internal.measurement.zzll;
import com.google.android.gms.internal.measurement.zzy;
import com.google.android.gms.measurement.internal.zzae;
import com.google.android.gms.measurement.internal.zzaf;
import com.google.android.gms.measurement.internal.zzam;
import com.google.android.gms.measurement.internal.zzd;
import com.google.android.gms.measurement.internal.zzdu;
import com.google.android.gms.measurement.internal.zzdv;
import com.google.android.gms.measurement.internal.zzdw;
import com.google.android.gms.measurement.internal.zzea;
import com.google.android.gms.measurement.internal.zzec;
import com.google.android.gms.measurement.internal.zzed;
import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzei;
import com.google.android.gms.measurement.internal.zzex;
import com.google.android.gms.measurement.internal.zzf;
import com.google.android.gms.measurement.internal.zzfa;
import com.google.android.gms.measurement.internal.zzfb;
import com.google.android.gms.measurement.internal.zzfi;
import com.google.android.gms.measurement.internal.zzfj;
import com.google.android.gms.measurement.internal.zzfk;
import com.google.android.gms.measurement.internal.zzge;
import com.google.android.gms.measurement.internal.zzgf;
import com.google.android.gms.measurement.internal.zzgg;
import com.google.android.gms.measurement.internal.zzgn;
import com.google.android.gms.measurement.internal.zzhm;
import com.google.android.gms.measurement.internal.zzhn;
import com.google.android.gms.measurement.internal.zzhq;
import com.google.android.gms.measurement.internal.zzhr;
import com.google.android.gms.measurement.internal.zzib;
import com.google.android.gms.measurement.internal.zzjb;
import com.google.android.gms.measurement.internal.zzjq;
import com.google.android.gms.measurement.internal.zzkk;
import com.google.android.gms.measurement.internal.zzz;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzfl
implements zzgg {
    private static volatile zzfl zzd;
    private zzea zzA;
    private zzfa zzB;
    private boolean zzC;
    private Boolean zzD;
    private long zzE;
    private volatile Boolean zzF;
    private volatile boolean zzG;
    private int zzH;
    private final AtomicInteger zzI;
    public Boolean zza;
    public Boolean zzb;
    public final long zzc;
    private final Context zze;
    private final String zzf;
    private final String zzg;
    private final String zzh;
    private final boolean zzi;
    private final zzz zzj;
    private final zzae zzk;
    private final zzex zzl;
    private final zzei zzm;
    private final zzfi zzn;
    private final zzjq zzo;
    private final zzkk zzp;
    private final zzed zzq;
    private final Clock zzr;
    private final zzib zzs;
    private final zzhn zzt;
    private final zzd zzu;
    private final zzhr zzv;
    private final String zzw;
    private zzec zzx;
    private zzjb zzy;
    private zzam zzz;

    public zzfl(zzgn zzgn2) {
        long l10;
        long l11;
        long l12;
        boolean bl2;
        boolean bl3;
        String string2;
        Object object;
        boolean bl4;
        boolean bl5 = false;
        Object object2 = null;
        this.zzC = false;
        Object object3 = new AtomicInteger(0);
        this.zzI = object3;
        Preconditions.checkNotNull(zzgn2);
        object3 = zzgn2.zza;
        Object object4 = new zzz((Context)object3);
        this.zzj = object4;
        zzdu.zza = object4;
        object3 = zzgn2.zza;
        this.zze = object3;
        this.zzf = object4 = zzgn2.zzb;
        this.zzg = object4 = zzgn2.zzc;
        this.zzh = object4 = zzgn2.zzd;
        this.zzi = bl4 = zzgn2.zzh;
        this.zzF = object4 = zzgn2.zze;
        this.zzw = object4 = zzgn2.zzj;
        this.zzG = bl4 = true;
        Object object5 = zzgn2.zzg;
        if (object5 != null && (object = ((zzy)object5).zzg) != null) {
            string2 = "measurementEnabled";
            bl3 = (object = object.get(string2)) instanceof Boolean;
            if (bl3) {
                this.zza = object = (Boolean)object;
            }
            object5 = ((zzy)object5).zzg;
            object = "measurementDeactivated";
            bl2 = (object5 = object5.get((String)object)) instanceof Boolean;
            if (bl2) {
                this.zzb = object5 = (Boolean)object5;
            }
        }
        zzfg.zzb((Context)object3);
        this.zzr = object5 = DefaultClock.getInstance();
        object = zzgn2.zzi;
        long l13 = object != null ? ((Long)object).longValue() : object5.currentTimeMillis();
        this.zzc = l13;
        this.zzk = object5 = new zzae(this);
        object5 = new zzex(this);
        ((zzgf)object5).zzx();
        this.zzl = object5;
        object5 = new zzei(this);
        ((zzgf)object5).zzx();
        this.zzm = object5;
        object5 = new zzkk(this);
        ((zzgf)object5).zzx();
        this.zzp = object5;
        object5 = new zzed(this);
        ((zzgf)object5).zzx();
        this.zzq = object5;
        this.zzu = object5 = new zzd(this);
        object5 = new zzib(this);
        ((zzf)object5).zzc();
        this.zzs = object5;
        object5 = new zzhn(this);
        ((zzf)object5).zzc();
        this.zzt = object5;
        object5 = new zzjq(this);
        ((zzf)object5).zzc();
        this.zzo = object5;
        object5 = new zzhr(this);
        ((zzgf)object5).zzx();
        this.zzv = object5;
        object5 = new zzfi(this);
        ((zzgf)object5).zzx();
        this.zzn = object5;
        object = zzgn2.zzg;
        if (object == null || !(bl2 = (l12 = (l11 = ((zzy)object).zzb) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) {
            bl5 = bl4;
        }
        object3 = object3.getApplicationContext();
        boolean bl6 = object3 instanceof Application;
        if (bl6) {
            object3 = this.zzk();
            object4 = object3.zzx.zze.getApplicationContext();
            bl4 = object4 instanceof Application;
            if (bl4) {
                object4 = (Application)object3.zzx.zze.getApplicationContext();
                object = ((zzhn)object3).zza;
                if (object == null) {
                    bl3 = false;
                    string2 = null;
                    ((zzhn)object3).zza = object = new zzhm((zzhn)object3, null);
                }
                if (bl5) {
                    object2 = ((zzhn)object3).zza;
                    object4.unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)object2);
                    object2 = ((zzhn)object3).zza;
                    object4.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)object2);
                    object2 = ((zzge)object3).zzx.zzat().zzk();
                    object3 = "Registered activity lifecycle callback";
                    ((zzeg)object2).zza((String)object3);
                }
            }
        } else {
            object2 = this.zzat().zze();
            object3 = "Application context is not an Application";
            ((zzeg)object2).zza((String)object3);
        }
        object2 = new zzfk(this, zzgn2);
        ((zzfi)object5).zzh((Runnable)object2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static zzfl zzC(Context object, zzy object2, Long object3) {
        boolean bl2;
        Class<zzfl> clazz;
        Class<zzfl> clazz2;
        if (object2 != null && ((clazz2 = ((zzy)object2).zze) == null || (clazz2 = ((zzy)object2).zzf) == null)) {
            long l10 = ((zzy)object2).zza;
            long l11 = ((zzy)object2).zzb;
            boolean bl3 = ((zzy)object2).zzc;
            String string2 = ((zzy)object2).zzd;
            Bundle bundle = ((zzy)object2).zzg;
            clazz = clazz2;
            clazz2 = new Class<zzfl>(l10, l11, bl3, string2, null, null, bundle, null);
            object2 = clazz2;
        }
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(object.getApplicationContext());
        clazz2 = zzd;
        if (clazz2 == null) {
            clazz2 = zzfl.class;
            synchronized (clazz2) {
                clazz = zzd;
                if (clazz == null) {
                    clazz = new Class<zzfl>(object, (zzy)object2, (Long)object3);
                    object = new zzfl((zzgn)((Object)clazz));
                    zzd = object;
                }
            }
        } else if (object2 != null && (object = ((zzy)object2).zzg) != null && (bl2 = object.containsKey((String)(object3 = "dataCollectionDefaultEnabled")))) {
            Preconditions.checkNotNull(zzd);
            object = zzd;
            object2 = ((zzy)object2).zzg;
            object3 = "dataCollectionDefaultEnabled";
            boolean bl4 = object2.getBoolean((String)object3);
            object.zzF = object2 = Boolean.valueOf(bl4);
        }
        Preconditions.checkNotNull(zzd);
        return zzd;
    }

    public static /* synthetic */ void zzO(zzfl zzfl2, zzgn object) {
        ((zzge)zzfl2.zzau()).zzg();
        zzfl2.zzk.zzb();
        Object object2 = new zzam(zzfl2);
        ((zzgf)object2).zzx();
        zzfl2.zzz = object2;
        long l10 = ((zzgn)object).zzf;
        object2 = new zzea(zzfl2, l10);
        ((zzf)object2).zzc();
        zzfl2.zzA = object2;
        object = new zzec(zzfl2);
        ((zzf)object).zzc();
        zzfl2.zzx = object;
        object = new zzjb(zzfl2);
        ((zzf)object).zzc();
        zzfl2.zzy = object;
        zzfl2.zzp.zzy();
        zzfl2.zzl.zzy();
        zzfl2.zzB = object = new zzfa(zzfl2);
        zzfl2.zzA.zzd();
        object = zzfl2.zzat().zzi();
        zzfl2.zzk.zzf();
        l10 = 39000L;
        Object object3 = l10;
        String string2 = "App measurement initialized, version";
        ((zzeg)object).zzb(string2, object3);
        object = zzfl2.zzat().zzi();
        object3 = "To enable debug logging run: adb shell setprop log.tag.FA VERBOSE";
        ((zzeg)object).zza((String)object3);
        object = ((zzea)object2).zzi();
        object2 = zzfl2.zzf;
        boolean n10 = TextUtils.isEmpty((CharSequence)object2);
        if (n10) {
            object2 = zzfl2.zzl();
            boolean bl2 = ((zzkk)object2).zzT((String)object);
            if (bl2) {
                object = zzfl2.zzat().zzi();
                object2 = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.";
                ((zzeg)object).zza((String)object2);
            } else {
                object2 = zzfl2.zzat().zzi();
                object = String.valueOf(object);
                object3 = "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ";
                int n11 = ((String)object).length();
                object = n11 != 0 ? ((String)object3).concat((String)object) : new String((String)object3);
                ((zzeg)object2).zza((String)object);
            }
        }
        object = zzfl2.zzat().zzj();
        ((zzeg)object).zza("Debug-level message logging enabled");
        int n12 = zzfl2.zzH;
        object2 = zzfl2.zzI;
        int n13 = ((AtomicInteger)object2).get();
        if (n12 != n13) {
            object = zzfl2.zzat().zzb();
            int n14 = zzfl2.zzH;
            object2 = n14;
            int n15 = zzfl2.zzI.get();
            object3 = n15;
            string2 = "Not all components initialized";
            ((zzeg)object).zzc(string2, object2, object3);
        }
        zzfl2.zzC = true;
    }

    public static final void zzP() {
        IllegalStateException illegalStateException = new IllegalStateException("Unexpected call on client side");
        throw illegalStateException;
    }

    private static final void zzQ(zzge object) {
        if (object != null) {
            return;
        }
        object = new IllegalStateException("Component not created");
        throw object;
    }

    private static final void zzR(zzf object) {
        if (object != null) {
            boolean bl2 = ((zzf)object).zza();
            if (bl2) {
                return;
            }
            object = String.valueOf(object.getClass());
            int n10 = String.valueOf(object).length();
            StringBuilder stringBuilder = new StringBuilder(n10 += 27);
            stringBuilder.append("Component not initialized: ");
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            IllegalStateException illegalStateException = new IllegalStateException((String)object);
            throw illegalStateException;
        }
        object = new IllegalStateException("Component not created");
        throw object;
    }

    private static final void zzS(zzgf object) {
        if (object != null) {
            boolean bl2 = ((zzgf)object).zzu();
            if (bl2) {
                return;
            }
            object = String.valueOf(object.getClass());
            int n10 = String.valueOf(object).length();
            StringBuilder stringBuilder = new StringBuilder(n10 += 27);
            stringBuilder.append("Component not initialized: ");
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            IllegalStateException illegalStateException = new IllegalStateException((String)object);
            throw illegalStateException;
        }
        object = new IllegalStateException("Component not created");
        throw object;
    }

    public final zzea zzA() {
        zzfl.zzR(this.zzA);
        return this.zzA;
    }

    public final zzd zzB() {
        Object object = this.zzu;
        if (object != null) {
            return object;
        }
        object = new IllegalStateException("Component not created");
        throw object;
    }

    public final void zzD(boolean bl2) {
        Boolean bl3;
        this.zzF = bl3 = Boolean.valueOf(bl2);
    }

    public final boolean zzE() {
        boolean bl2;
        Boolean bl3 = this.zzF;
        return bl3 != null && (bl2 = (bl3 = this.zzF).booleanValue());
    }

    public final boolean zzF() {
        int n10 = this.zzG();
        return n10 == 0;
    }

    public final int zzG() {
        ((zzge)this.zzau()).zzg();
        Object object = this.zzk;
        boolean bl2 = ((zzae)object).zzr();
        if (bl2) {
            return 1;
        }
        object = this.zzb;
        if (object != null && (bl2 = ((Boolean)object).booleanValue())) {
            return 2;
        }
        zzlc.zzb();
        object = this.zzk;
        zzdv zzdv2 = zzdw.zzaw;
        bl2 = ((zzae)object).zzn(null, zzdv2);
        if (bl2) {
            object = this.zzau();
            ((zzge)object).zzg();
            bl2 = this.zzG;
            if (!bl2) {
                return 8;
            }
        }
        object = this.zzd().zzf();
        zzdv2 = null;
        if (object != null) {
            bl2 = (Boolean)object;
            if (bl2) {
                return 0;
            }
            return 3;
        }
        object = this.zzk;
        Object object2 = object.zzx.zzj;
        object2 = "firebase_analytics_collection_enabled";
        if ((object = ((zzae)object).zzp((String)object2)) != null) {
            bl2 = (Boolean)object;
            if (bl2) {
                return 0;
            }
            return 4;
        }
        object = this.zza;
        if (object != null) {
            bl2 = (Boolean)object;
            if (bl2) {
                return 0;
            }
            return 5;
        }
        object = this.zzk;
        object2 = zzdw.zzS;
        bl2 = ((zzae)object).zzn(null, (zzdv)object2);
        if (bl2 && (object = this.zzF) != null) {
            object = this.zzF;
            bl2 = (Boolean)object;
            if (bl2) {
                return 0;
            }
            return 7;
        }
        return 0;
    }

    public final void zzH(boolean bl2) {
        ((zzge)this.zzau()).zzg();
        this.zzG = bl2;
    }

    public final boolean zzI() {
        ((zzge)this.zzau()).zzg();
        return this.zzG;
    }

    public final void zzJ() {
        int n10;
        this.zzH = n10 = this.zzH + 1;
    }

    public final void zzK() {
        this.zzI.incrementAndGet();
    }

    public final boolean zzL() {
        block7: {
            block9: {
                String string2;
                long l10;
                long l11;
                Object object;
                Object object2;
                block8: {
                    long l12;
                    long l13;
                    long l14;
                    object2 = this.zzC;
                    if (object2 == 0) break block7;
                    ((zzge)this.zzau()).zzg();
                    object = this.zzD;
                    if (object == null || (l11 = (l14 = (l13 = this.zzE) - (l12 = 0L)) == 0L ? 0 : (l14 < 0L ? -1 : 1)) == false) break block8;
                    object2 = (Boolean)object;
                    if (object2 != 0) break block9;
                    object = this.zzr;
                    l10 = object.elapsedRealtime();
                    long l15 = this.zzE;
                    long l16 = (l10 = Math.abs(l10 - l15)) - (l15 = 1000L);
                    object2 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                    if (object2 <= 0) break block9;
                }
                this.zzE = l10 = this.zzr.elapsedRealtime();
                object = this.zzl();
                String string3 = "android.permission.INTERNET";
                object2 = ((zzkk)object).zzQ(string3);
                l11 = 1;
                if (object2 != 0 && (object2 = ((zzkk)(object = this.zzl())).zzQ(string2 = "android.permission.ACCESS_NETWORK_STATE")) != 0 && ((object2 = (Object)((PackageManagerWrapper)(object = Wrappers.packageManager(this.zze))).isCallerInstantApp()) != 0 || (object2 = (Object)((zzae)(object = this.zzk)).zzy()) != 0 || (object2 = (Object)zzfb.zza((Context)(object = this.zze))) != 0 && (object2 = (Object)zzkk.zzP((Context)(object = this.zze), false)) != 0)) {
                    object2 = l11;
                } else {
                    object2 = 0;
                    object = null;
                }
                this.zzD = object = Boolean.valueOf((boolean)object2);
                object2 = (Boolean)object;
                if (object2 != 0) {
                    String string4;
                    String string5;
                    object = this.zzl();
                    object2 = ((zzkk)object).zzA(string2 = this.zzA().zzj(), string5 = this.zzA().zzk(), string4 = this.zzA().zzl());
                    if (object2 == 0 && (object2 = (Object)TextUtils.isEmpty((CharSequence)(object = this.zzA().zzk()))) != 0) {
                        l11 = 0;
                        string3 = null;
                    }
                    this.zzD = object = Boolean.valueOf((boolean)l11);
                }
            }
            return this.zzD;
        }
        IllegalStateException illegalStateException = new IllegalStateException("AppMeasurement is not initialized");
        throw illegalStateException;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zzM() {
        Object object;
        boolean bl2;
        Object object2;
        Pair pair;
        String string2;
        block4: {
            block5: {
                ((zzge)this.zzau()).zzg();
                zzfl.zzS(this.zzo());
                string2 = this.zzA().zzi();
                pair = this.zzd().zzb(string2);
                object2 = this.zzk;
                bl2 = ((zzae)object2).zzs();
                if (!bl2 || (bl2 = ((Boolean)(object2 = (Boolean)pair.second)).booleanValue()) || (bl2 = TextUtils.isEmpty((CharSequence)(object2 = (CharSequence)pair.first)))) break block5;
                object2 = this.zzo();
                ((zzgf)object2).zzv();
                object2 = (ConnectivityManager)object2.zzx.zze.getSystemService("connectivity");
                object = null;
                if (object2 == null) break block4;
                try {
                    object = object2.getActiveNetworkInfo();
                    break block4;
                }
                catch (SecurityException securityException) {}
            }
            this.zzat().zzj().zza("ADID unavailable to retrieve Deferred Deep Link. Skipping");
            return;
        }
        if (object != null && (bl2 = object.isConnected())) {
            Object object3;
            object2 = this.zzl();
            object = this.zzA().zzx.zzk;
            ((zzae)object).zzf();
            long l10 = 39000L;
            Object object4 = object3 = pair.first;
            String string3 = (String)object3;
            long l11 = this.zzd().zzs.zza();
            long l12 = -1;
            Object object5 = object2;
            Object object6 = string2;
            object6 = ((zzkk)object2).zzal(l10, string2, string3, l11 += l12);
            if (object6 != null) {
                zzhq zzhq2;
                object2 = this.zzo();
                zzfj zzfj2 = new zzfj(this);
                ((zzge)object2).zzg();
                ((zzgf)object2).zzv();
                Preconditions.checkNotNull(object6);
                Preconditions.checkNotNull(zzfj2);
                zzfi zzfi2 = ((zzge)object2).zzx.zzau();
                Object var8_12 = null;
                zzhq zzhq3 = zzhq2;
                object = string2;
                zzhq2 = new zzhq((zzhr)object2, string2, (URL)object6, null, null, zzfj2, null);
                zzfi2.zzk(zzhq2);
            }
            return;
        }
        this.zzat().zze().zza("Network is not available for Deferred Deep Link request. Skipping");
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final /* synthetic */ void zzN(String var1_1, int var2_4, Throwable var3_5, byte[] var4_6, Map var5_7) {
        block10: {
            block11: {
                block9: {
                    var1_1 = "timestamp";
                    var5_7 = "gclid";
                    var6_8 = "";
                    var7_9 = "deeplink";
                    var8_10 = 304;
                    var9_11 = 200;
                    if (var2_4 == var9_11 || var2_4 == (var9_11 = 204)) break block9;
                    if (var2_4 != var8_10) break block10;
                    var2_4 = var8_10;
                }
                if (var3_5 != null) break block10;
                var10_12 = this.zzd().zzr;
                var11_14 = true;
                var10_12.zzb(var11_14);
                if (var4_6 == null || (var2_4 = ((Object)var4_6).length) == 0) break block11;
                var10_12 = new String((byte[])var4_6);
                try {
                    var3_5 = new JSONObject((String)var10_12);
                    var10_12 = var3_5.optString(var7_9, (String)var6_8);
                    var4_6 = var3_5.optString((String)var5_7, (String)var6_8);
                    var12_15 = 0.0;
                    var12_15 = var3_5.optDouble((String)var1_1, var12_15);
                    var11_14 = TextUtils.isEmpty((CharSequence)var10_12);
                    if (var11_14) {
                        var1_1 = this.zzat();
                        var1_1 = var1_1.zzj();
                        var10_12 = "Deferred Deep Link is empty.";
                        var1_1.zza((String)var10_12);
                        return;
                    }
                    var3_5 = this.zzl();
                    var6_8 = var3_5.zzx;
                    var14_16 = TextUtils.isEmpty((CharSequence)var10_12);
                    if (!var14_16) {
                        var3_5 = var3_5.zzx;
                        var3_5 = var3_5.zze;
                        var3_5 = var3_5.getPackageManager();
                        var15_17 = "android.intent.action.VIEW";
                        var16_18 = Uri.parse((String)var10_12);
                        var6_8 = new Intent(var15_17, var16_18);
                        var15_17 = null;
                        if ((var3_5 = var3_5.queryIntentActivities((Intent)var6_8, 0)) != null && !(var11_14 = var3_5.isEmpty())) {
                            var3_5 = new Bundle();
                            var3_5.putString((String)var5_7, (String)var4_6);
                            var4_6 = "_cis";
                            var5_7 = "ddp";
                            var3_5.putString((String)var4_6, (String)var5_7);
                            var4_6 = this.zzt;
                            var5_7 = "auto";
                            var6_8 = "_cmp";
                            var4_6.zzs((String)var5_7, (String)var6_8, (Bundle)var3_5);
                            var3_5 = this.zzl();
                            var17_19 = TextUtils.isEmpty((CharSequence)var10_12);
                            if (var17_19) {
                                return;
                            }
                        }
                    }
                    ** GOTO lbl88
                }
                catch (JSONException var1_3) {
                    this.zzat().zzb().zzb("Failed to parse the Deferred Deep Link response. exception", (Object)var1_3);
                    return;
                }
                var4_6 = var3_5.zzx;
                var4_6 = var4_6.zze;
                var5_7 = "google.analytics.deferred.deeplink.prefs";
                var4_6 = var4_6.getSharedPreferences((String)var5_7, 0);
                var4_6 = var4_6.edit();
                var4_6.putString(var7_9, (String)var10_12);
                var18_20 = Double.doubleToRawLongBits(var12_15);
                var4_6.putLong((String)var1_1, var18_20);
                var20_21 = var4_6.commit();
                if (var20_21 == false) return;
                {
                    catch (Exception var1_2) {
                        var10_12 = var3_5.zzx;
                        var10_12 = var10_12.zzat();
                        var10_12 = var10_12.zzb();
                        var3_5 = "Failed to persist Deferred Deep Link. exception";
                        var10_12.zzb((String)var3_5, var1_2);
                        return;
                    }
                    var10_12 = "android.google.analytics.action.DEEPLINK_ACTION";
                    var1_1 = new Intent((String)var10_12);
                    var10_12 = var3_5.zzx;
                    var10_12 = var10_12.zze;
                    var10_12.sendBroadcast((Intent)var1_1);
                    return;
lbl88:
                    // 1 sources

                    var1_1 = this.zzat();
                    var1_1 = var1_1.zze();
                    var3_5 = "Deferred Deep Link validation failed. gclid, deep link";
                    var1_1.zzc((String)var3_5, var4_6, var10_12);
                    return;
                }
            }
            this.zzat().zzj().zza("Deferred Deep Link response empty.");
            return;
        }
        var1_1 = this.zzat().zze();
        var10_13 = var2_4;
        var1_1.zzc("Network Request for Deferred Deep Link failed. response, exception", var10_13, var3_5);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final void zza(zzy var1_1) {
        block35: {
            block40: {
                block41: {
                    block36: {
                        block38: {
                            block39: {
                                block37: {
                                    this.zzau().zzg();
                                    zzlc.zzb();
                                    var2_2 /* !! */  = this.zzk;
                                    var3_3 = zzdw.zzaw;
                                    var4_4 = var2_2 /* !! */ .zzn(null, var3_3);
                                    if (!var4_4) break block35;
                                    var2_2 /* !! */  = this.zzd().zzi();
                                    var5_5 = this.zzd();
                                    var6_6 = var5_5.zzx;
                                    var5_5.zzg();
                                    var5_5 = var5_5.zzd();
                                    var7_7 = 100;
                                    var8_8 = var5_5.getInt("consent_source", var7_7);
                                    var6_6 = this.zzk;
                                    var9_9 = zzdw.zzax;
                                    var10_10 = var6_6.zzn(null, (zzdv)var9_9);
                                    var11_11 = 40;
                                    if (var10_10 == 0) break block36;
                                    var6_6 = this.zzk;
                                    var12_12 = var6_6.zzx;
                                    zzlc.zzb();
                                    var13_13 = var6_6.zzn(null, (zzdv)var9_9);
                                    if (var13_13 == 0) {
                                        var10_10 = 0;
                                        var6_6 = null;
                                    } else {
                                        var12_12 = "google_analytics_default_allow_ad_storage";
                                        var6_6 = var6_6.zzp((String)var12_12);
                                    }
                                    var12_12 = this.zzk;
                                    var14_14 = var12_12.zzx;
                                    zzlc.zzb();
                                    var15_15 = var12_12.zzn(null, (zzdv)var9_9);
                                    if (!var15_15) {
                                        var15_15 = false;
                                        var9_9 = null;
                                    } else {
                                        var9_9 = var12_12.zzp("google_analytics_default_allow_analytics_storage");
                                    }
                                    var13_13 = 20;
                                    if (var6_6 == null && var9_9 == null || !(var16_16 = (var14_14 = this.zzd()).zzh(var13_13))) break block37;
                                    var1_1 = new zzaf((Boolean)var6_6, (Boolean)var9_9);
                                    var7_7 = var13_13;
                                    break block38;
                                }
                                var6_6 = this.zzA().zzj();
                                var10_10 = TextUtils.isEmpty((CharSequence)var6_6);
                                if (var10_10 != 0 || var8_8 != (var10_10 = 30) && var8_8 != var11_11) break block39;
                                var1_1 = this.zzk();
                                var5_5 = zzaf.zza;
                                var17_17 = this.zzc;
                                var1_1.zzq((zzaf)var5_5, var13_13, var17_17);
                                ** GOTO lbl-1000
                            }
                            if (var1_1 != null && (var5_5 = var1_1.zzg) != null && (var8_8 = (int)(var5_5 = this.zzd()).zzh(var11_11)) != 0 && (var8_8 = (int)(var1_1 = zzaf.zzb(var1_1.zzg)).equals(var5_5 = zzaf.zza)) == 0) {
                                var7_7 = var11_11;
                            } else lbl-1000:
                            // 2 sources

                            {
                                var19_18 = 0;
                                var1_1 = null;
                            }
                        }
                        if (var1_1 == null) break block40;
                        var2_2 /* !! */  = this.zzk();
                        var20_19 = this.zzc;
                        var2_2 /* !! */ .zzq((zzaf)var1_1, var7_7, var20_19);
                        break block41;
                    }
                    if (var1_1 == null || (var5_5 = var1_1.zzg) == null || (var8_8 = (int)(var5_5 = this.zzd()).zzh(var11_11)) == 0 || (var8_8 = (int)(var1_1 = zzaf.zzb(var1_1.zzg)).equals(var5_5 = zzaf.zza)) != 0) break block40;
                    var2_2 /* !! */  = this.zzk();
                    var20_19 = this.zzc;
                    var2_2 /* !! */ .zzq((zzaf)var1_1, var11_11, var20_19);
                }
                var2_2 /* !! */  = var1_1;
            }
            var1_1 = this.zzk();
            var1_1.zzr((zzaf)var2_2 /* !! */ );
        }
        if ((var19_18 = (cfr_temp_0 = (var20_19 = (var1_1 = this.zzd().zzc).zza()) - (var22_20 = 0L)) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1)) == false) {
            var1_1 = this.zzd().zzc;
            var2_2 /* !! */  = this.zzr;
            var20_19 = var2_2 /* !! */ .currentTimeMillis();
            var1_1.zzb(var20_19);
        }
        if ((var19_18 = (cfr_temp_1 = (var20_19 = (var1_1 = Long.valueOf(this.zzd().zzh.zza())).longValue()) - var22_20) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) == false) {
            var1_1 = this.zzat().zzk();
            var2_2 /* !! */  = Long.valueOf(this.zzc);
            var5_5 = "Persisting first open";
            var1_1.zzb((String)var5_5, var2_2 /* !! */ );
            var1_1 = this.zzd().zzh;
            var20_19 = this.zzc;
            var1_1.zzb(var20_19);
        }
        var1_1 = this.zzk().zzb;
        var1_1.zzc();
        var19_18 = (long)this.zzL();
        if (var19_18 == false) {
            var19_18 = (long)this.zzF();
            if (var19_18 != false) {
                var1_1 = this.zzl();
                var19_18 = (long)var1_1.zzQ((String)(var2_2 /* !! */  = "android.permission.INTERNET"));
                if (var19_18 == false) {
                    var1_1 = this.zzat().zzb();
                    var2_2 /* !! */  = "App is missing INTERNET permission";
                    var1_1.zza((String)var2_2 /* !! */ );
                }
                if ((var19_18 = (long)(var1_1 = this.zzl()).zzQ((String)(var2_2 /* !! */  = "android.permission.ACCESS_NETWORK_STATE"))) == false) {
                    var1_1 = this.zzat().zzb();
                    var2_2 /* !! */  = "App is missing ACCESS_NETWORK_STATE permission";
                    var1_1.zza((String)var2_2 /* !! */ );
                }
                if ((var19_18 = (long)(var1_1 = Wrappers.packageManager(this.zze)).isCallerInstantApp()) == false && (var19_18 = (long)(var1_1 = this.zzk).zzy()) == false) {
                    var1_1 = this.zze;
                    var19_18 = (long)zzfb.zza((Context)var1_1);
                    if (var19_18 == false) {
                        var1_1 = this.zzat().zzb();
                        var2_2 /* !! */  = "AppMeasurementReceiver not registered/enabled";
                        var1_1.zza((String)var2_2 /* !! */ );
                    }
                    var1_1 = this.zze;
                    var4_4 = false;
                    var2_2 /* !! */  = null;
                    var19_18 = (long)zzkk.zzP((Context)var1_1, false);
                    if (var19_18 == false) {
                        var1_1 = this.zzat().zzb();
                        var2_2 /* !! */  = "AppMeasurementService not registered/enabled";
                        var1_1.zza((String)var2_2 /* !! */ );
                    }
                }
                var1_1 = this.zzat().zzb();
                var2_2 /* !! */  = "Uploading is not possible. App measurement disabled";
                var1_1.zza((String)var2_2 /* !! */ );
            }
        } else {
            block34: {
                var1_1 = this.zzA().zzj();
                var19_18 = (long)TextUtils.isEmpty((CharSequence)var1_1);
                if (var19_18 == false || (var19_18 = (long)TextUtils.isEmpty((CharSequence)(var1_1 = this.zzA().zzk()))) == false) {
                    var1_1 = this.zzl();
                    var2_2 /* !! */  = this.zzA().zzj();
                    var5_5 = this.zzd();
                    var5_5.zzg();
                    var5_5 = var5_5.zzd();
                    var6_6 = "gmp_app_id";
                    var5_5 = var5_5.getString((String)var6_6, null);
                    var24_21 = this.zzA().zzk();
                    var9_9 = this.zzd();
                    var9_9.zzg();
                    var9_9 = var9_9.zzd();
                    var25_22 = "admob_app_id";
                    var9_9 = var9_9.getString(var25_22, null);
                    var19_18 = (long)var1_1.zzB((String)var2_2 /* !! */ , (String)var5_5, var24_21, (String)var9_9);
                    if (var19_18 != false) {
                        this.zzat().zzi().zza("Rechecking which service to use due to a GMP App Id change");
                        var1_1 = this.zzd();
                        var1_1.zzg();
                        var2_2 /* !! */  = var1_1.zzf();
                        var5_5 = var1_1.zzd().edit();
                        var5_5.clear();
                        var5_5.apply();
                        if (var2_2 /* !! */  != null) {
                            var1_1.zze((Boolean)var2_2 /* !! */ );
                        }
                        this.zzn().zzh();
                        this.zzy.zzF();
                        this.zzy.zzB();
                        var1_1 = this.zzd().zzh;
                        var22_20 = this.zzc;
                        var1_1.zzb(var22_20);
                        var1_1 = this.zzd().zzj;
                        var1_1.zzb(null);
                    }
                    var1_1 = this.zzd();
                    var2_2 /* !! */  = this.zzA().zzj();
                    var1_1.zzg();
                    var1_1 = var1_1.zzd().edit();
                    var1_1.putString((String)var6_6, (String)var2_2 /* !! */ );
                    var1_1.apply();
                    var1_1 = this.zzd();
                    var2_2 /* !! */  = this.zzA().zzk();
                    var1_1.zzg();
                    var1_1 = var1_1.zzd().edit();
                    var1_1.putString(var25_22, var2_2 /* !! */ );
                    var1_1.apply();
                }
                zzlc.zzb();
                var1_1 = this.zzk;
                var19_18 = (long)var1_1.zzn(null, var3_3);
                if (var19_18 != false && (var19_18 = (long)(var1_1 = this.zzd().zzi()).zzh()) == false) {
                    var1_1 = this.zzd().zzj;
                    var1_1.zzb(null);
                }
                var1_1 = this.zzk();
                var2_2 /* !! */  = this.zzd().zzj.zza();
                var1_1.zzE((String)var2_2 /* !! */ );
                zzll.zzb();
                var1_1 = this.zzk;
                var2_2 /* !! */  = zzdw.zzan;
                var19_18 = (long)var1_1.zzn(null, (zzdv)var2_2 /* !! */ );
                if (var19_18 != false) {
                    var1_1 = this.zzl();
                    var1_1 = var1_1.zzx;
                    var1_1 = var1_1.zze;
                    var1_1 = var1_1.getClassLoader();
                    var2_2 /* !! */  = "com.google.firebase.remoteconfig.FirebaseRemoteConfig";
                    try {
                        var1_1.loadClass((String)var2_2 /* !! */ );
                    }
                    catch (ClassNotFoundException v0) {
                        var1_1 = this.zzd().zzt.zza();
                        var19_18 = (long)TextUtils.isEmpty((CharSequence)var1_1);
                        if (var19_18 != false) break block34;
                        var1_1 = this.zzat().zze();
                        var2_2 /* !! */  = "Remote config removed with active feature rollouts";
                        var1_1.zza((String)var2_2 /* !! */ );
                        var1_1 = this.zzd().zzt;
                        var1_1.zzb(null);
                    }
                }
            }
            if ((var19_18 = (long)TextUtils.isEmpty((CharSequence)(var1_1 = this.zzA().zzj()))) == false || (var19_18 = (long)TextUtils.isEmpty((CharSequence)(var1_1 = this.zzA().zzk()))) == false) {
                var19_18 = (long)this.zzF();
                var2_2 /* !! */  = this.zzd();
                var4_4 = var2_2 /* !! */ .zzk();
                if (!var4_4 && !(var4_4 = (var2_2 /* !! */  = this.zzk).zzr())) {
                    var2_2 /* !! */  = this.zzd();
                    var26_23 = var19_18 ^ 1;
                    var2_2 /* !! */ .zzj(var26_23);
                }
                if (var19_18 != false) {
                    var1_1 = this.zzk();
                    var1_1.zzH();
                }
                this.zzh().zza.zza();
                var1_1 = this.zzy();
                var2_2 /* !! */  = new AtomicReference();
                var1_1.zzv((AtomicReference)var2_2 /* !! */ );
                var1_1 = this.zzy();
                var2_2 /* !! */  = this.zzd().zzw.zza();
                var1_1.zzA(var2_2 /* !! */ );
            }
        }
        var1_1 = this.zzd().zzn;
        var2_2 /* !! */  = this.zzk;
        var3_3 = zzdw.zzW;
        var4_4 = var2_2 /* !! */ .zzn(null, var3_3);
        var1_1.zzb(var4_4);
    }

    public final zzz zzas() {
        return this.zzj;
    }

    public final zzei zzat() {
        zzfl.zzS(this.zzm);
        return this.zzm;
    }

    public final zzfi zzau() {
        zzfl.zzS(this.zzn);
        return this.zzn;
    }

    public final Context zzaw() {
        return this.zze;
    }

    public final Clock zzax() {
        return this.zzr;
    }

    public final zzae zzc() {
        return this.zzk;
    }

    public final zzex zzd() {
        zzfl.zzQ(this.zzl);
        return this.zzl;
    }

    public final zzei zzf() {
        boolean bl2;
        zzei zzei2 = this.zzm;
        if (zzei2 != null && (bl2 = zzei2.zzu())) {
            return this.zzm;
        }
        return null;
    }

    public final zzjq zzh() {
        zzfl.zzR(this.zzo);
        return this.zzo;
    }

    public final zzfa zzi() {
        return this.zzB;
    }

    public final zzfi zzj() {
        return this.zzn;
    }

    public final zzhn zzk() {
        zzfl.zzR(this.zzt);
        return this.zzt;
    }

    public final zzkk zzl() {
        zzfl.zzQ(this.zzp);
        return this.zzp;
    }

    public final zzed zzm() {
        zzfl.zzQ(this.zzq);
        return this.zzq;
    }

    public final zzec zzn() {
        zzfl.zzR(this.zzx);
        return this.zzx;
    }

    public final zzhr zzo() {
        zzfl.zzS(this.zzv);
        return this.zzv;
    }

    public final boolean zzq() {
        return TextUtils.isEmpty((CharSequence)this.zzf);
    }

    public final String zzr() {
        return this.zzf;
    }

    public final String zzs() {
        return this.zzg;
    }

    public final String zzt() {
        return this.zzh;
    }

    public final boolean zzu() {
        return this.zzi;
    }

    public final String zzv() {
        return this.zzw;
    }

    public final zzib zzx() {
        zzfl.zzR(this.zzs);
        return this.zzs;
    }

    public final zzjb zzy() {
        zzfl.zzR(this.zzy);
        return this.zzy;
    }

    public final zzam zzz() {
        zzfl.zzS(this.zzz);
        return this.zzz;
    }
}

