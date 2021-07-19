/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.net.Uri
 *  android.util.Log
 */
package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.google.android.gms.internal.measurement.zzei;
import com.google.android.gms.internal.measurement.zzek;
import com.google.android.gms.internal.measurement.zzen;
import com.google.android.gms.internal.measurement.zzeu;
import com.google.android.gms.internal.measurement.zzev;
import com.google.android.gms.internal.measurement.zzew;
import com.google.android.gms.internal.measurement.zzey;
import com.google.android.gms.internal.measurement.zzez;
import com.google.android.gms.internal.measurement.zzfa;
import com.google.android.gms.internal.measurement.zzfe;
import com.google.android.gms.internal.measurement.zzff;
import com.google.android.gms.internal.measurement.zzfh;
import com.google.android.gms.internal.measurement.zzfi;
import com.google.android.gms.internal.measurement.zzfj;
import com.google.android.gms.internal.measurement.zzfm;
import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfs;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public abstract class zzfg {
    public static final /* synthetic */ int zzc = 0;
    private static final Object zzd;
    private static volatile zzff zze;
    private static volatile boolean zzf = false;
    private static final AtomicReference zzg;
    private static final zzfi zzh;
    private static final AtomicInteger zzj;
    public final zzfe zza;
    public final String zzb;
    private final Object zzi;
    private volatile int zzk;
    private volatile Object zzl;
    private final boolean zzm;

    static {
        Object object;
        zzd = object = new Object();
        object = new AtomicReference();
        zzg = object;
        zzfj zzfj2 = zzez.zza;
        zzh = object = new zzfi(zzfj2);
        zzj = object = new AtomicInteger();
    }

    public /* synthetic */ zzfg(zzfe object, String string2, Object object2, boolean bl2, zzfa zzfa2) {
        int n10;
        this.zzk = n10 = -1;
        Uri uri = ((zzfe)object).zzb;
        if (uri != null) {
            this.zza = object;
            this.zzb = string2;
            this.zzi = object2;
            this.zzm = true;
            return;
        }
        object = new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        throw object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void zzb(Context object) {
        Object object2 = zzd;
        synchronized (object2) {
            Object object3 = zze;
            Object object4 = object.getApplicationContext();
            if (object4 != null) {
                object = object4;
            }
            if (object3 == null || (object3 = ((zzff)object3).zza()) != object) {
                zzen.zzd();
                zzfh.zzb();
                zzeu.zzc();
                object3 = new zzey((Context)object);
                object3 = zzfs.zza((zzfo)object3);
                object4 = new zzek((Context)object, (zzfo)object3);
                zze = object4;
                object = zzj;
                ((AtomicInteger)object).incrementAndGet();
            }
            return;
        }
    }

    public static void zzc() {
        zzj.incrementAndGet();
    }

    public abstract Object zza(Object var1);

    public final String zzd() {
        return this.zzb;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zze() {
        var1_1 = this.zzm;
        if (var1_1 == 0) {
            var2_2 = this.zzb;
            var3_3 = "flagName must not be null";
            Objects.requireNonNull(var2_2, (String)var3_3);
        }
        if ((var4_4 = this.zzk) >= (var1_1 = (var2_2 = zzfg.zzj).get())) return this.zzl;
        synchronized (this) {
            block21: {
                var4_4 = this.zzk;
                if (var4_4 >= var1_1) return this.zzl;
                var3_3 = zzfg.zze;
                var5_5 = "Must call PhenotypeFlag.init() first";
                if (var3_3 == null) {
                    var2_2 = new IllegalStateException((String)var5_5);
                    throw var2_2;
                }
                var5_5 = this.zza;
                var6_6 = var5_5.zzg;
                var5_5 = var3_3.zza();
                var5_5 = zzeu.zza((Context)var5_5);
                var7_7 = "gms:phenotype:phenotype_flag:debug_bypass_phenotype";
                var5_5 = var5_5.zzb(var7_7);
                var7_7 = null;
                if (var5_5 == null || !(var6_6 = (var5_5 = (var8_8 = zzei.zzc).matcher((CharSequence)var5_5)).matches())) break block21;
                var5_5 = "PhenotypeFlag";
                var9_9 = 3;
                var6_6 = Log.isLoggable((String)var5_5, (int)var9_9);
                if (var6_6) {
                    var5_5 = "PhenotypeFlag";
                    var8_8 = "Bypass reading Phenotype values for flag: ";
                    var10_10 = this.zzd();
                    var11_11 = (var10_10 = String.valueOf(var10_10)).length();
                    if (var11_11 != 0) {
                        var8_8 = var8_8.concat(var10_10);
                    } else {
                        var10_10 = new String((String)var8_8);
                        var8_8 = var10_10;
                    }
                    Log.d((String)var5_5, (String)var8_8);
                }
                ** GOTO lbl-1000
            }
            var5_5 = this.zza;
            var5_5 = var5_5.zzb;
            if (var5_5 != null) {
                var5_5 = var3_3.zza();
                var8_8 = this.zza;
                var8_8 = var8_8.zzb;
                var6_6 = zzew.zza((Context)var5_5, (Uri)var8_8);
                if (var6_6) {
                    var5_5 = this.zza;
                    var6_6 = var5_5.zzh;
                    var5_5 = var3_3.zza();
                    var5_5 = var5_5.getContentResolver();
                    var8_8 = this.zza;
                    var8_8 = var8_8.zzb;
                    var5_5 = zzen.zza((ContentResolver)var5_5, (Uri)var8_8);
                } else {
                    var6_6 = false;
                    var5_5 = null;
                }
            } else {
                var5_5 = var3_3.zza();
                var8_8 = this.zza;
                var8_8 = var8_8.zza;
                var5_5 = zzfh.zza((Context)var5_5, null);
            }
            if (var5_5 != null && (var5_5 = var5_5.zze((String)(var8_8 = this.zzd()))) != null) {
                var5_5 = this.zza(var5_5);
            } else lbl-1000:
            // 2 sources

            {
                var6_6 = false;
                var5_5 = null;
            }
            if (var5_5 == null) {
                var5_5 = this.zza;
                var9_9 = (int)var5_5.zze;
                var5_5 = var5_5.zzi;
                var5_5 = var3_3.zza();
                var5_5 = zzeu.zza((Context)var5_5);
                var8_8 = this.zza;
                var8_8 = var8_8.zzc;
                var8_8 = this.zzb;
                if ((var5_5 = var5_5.zzb((String)var8_8)) != null) {
                    var5_5 = this.zza(var5_5);
                } else {
                    var6_6 = false;
                    var5_5 = null;
                }
                if (var5_5 == null) {
                    var5_5 = this.zzi;
                }
            }
            var3_3 = var3_3.zzb();
            var3_3 = var3_3.zza();
            var3_3 = (zzfm)var3_3;
            var9_9 = (int)var3_3.zza();
            if (var9_9 != 0) {
                var3_3 = var3_3.zzb();
                var3_3 = (zzev)var3_3;
                var5_5 = this.zza;
                var8_8 = var5_5.zzb;
                var10_10 = var5_5.zza;
                var5_5 = var5_5.zzd;
                var10_10 = this.zzb;
                var5_5 = (var3_3 = var3_3.zza((Uri)var8_8, null, (String)var5_5, var10_10)) == null ? this.zzi : this.zza(var3_3);
            }
            this.zzl = var5_5;
            this.zzk = var1_1;
            return this.zzl;
        }
    }
}

