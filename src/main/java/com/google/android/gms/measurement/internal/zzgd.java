/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.content.Context
 *  android.database.sqlite.SQLiteException
 *  android.os.Binder
 *  android.os.Bundle
 *  android.text.TextUtils
 */
package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.internal.measurement.zzlc;
import com.google.android.gms.measurement.internal.zzaa;
import com.google.android.gms.measurement.internal.zzae;
import com.google.android.gms.measurement.internal.zzai;
import com.google.android.gms.measurement.internal.zzan;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzas;
import com.google.android.gms.measurement.internal.zzdv;
import com.google.android.gms.measurement.internal.zzdw;
import com.google.android.gms.measurement.internal.zzdy;
import com.google.android.gms.measurement.internal.zzed;
import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzei;
import com.google.android.gms.measurement.internal.zzfi;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzfm;
import com.google.android.gms.measurement.internal.zzfn;
import com.google.android.gms.measurement.internal.zzfo;
import com.google.android.gms.measurement.internal.zzfp;
import com.google.android.gms.measurement.internal.zzfq;
import com.google.android.gms.measurement.internal.zzfr;
import com.google.android.gms.measurement.internal.zzfs;
import com.google.android.gms.measurement.internal.zzft;
import com.google.android.gms.measurement.internal.zzfu;
import com.google.android.gms.measurement.internal.zzfv;
import com.google.android.gms.measurement.internal.zzfw;
import com.google.android.gms.measurement.internal.zzfx;
import com.google.android.gms.measurement.internal.zzfy;
import com.google.android.gms.measurement.internal.zzfz;
import com.google.android.gms.measurement.internal.zzga;
import com.google.android.gms.measurement.internal.zzgb;
import com.google.android.gms.measurement.internal.zzgc;
import com.google.android.gms.measurement.internal.zzge;
import com.google.android.gms.measurement.internal.zzju;
import com.google.android.gms.measurement.internal.zzjv;
import com.google.android.gms.measurement.internal.zzkd;
import com.google.android.gms.measurement.internal.zzkg;
import com.google.android.gms.measurement.internal.zzki;
import com.google.android.gms.measurement.internal.zzkk;
import com.google.android.gms.measurement.internal.zzp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public final class zzgd
extends zzdy {
    private final zzkd zza;
    private Boolean zzb;
    private String zzc;

    public zzgd(zzkd zzkd2, String string2) {
        Preconditions.checkNotNull(zzkd2);
        this.zza = zzkd2;
        this.zzc = null;
    }

    public static /* synthetic */ zzkd zzw(zzgd zzgd2) {
        return zzgd2.zza;
    }

    private final void zzx(zzp object, boolean bl2) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotEmpty(((zzp)object).zza);
        Object object2 = ((zzp)object).zza;
        this.zzy((String)object2, false);
        object2 = this.zza.zzr();
        String string2 = ((zzp)object).zzb;
        String string3 = ((zzp)object).zzq;
        object = ((zzp)object).zzu;
        ((zzkk)object2).zzA(string2, string3, (String)object);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private final void zzy(String var1_1, boolean var2_2) {
        block31: {
            block30: {
                block29: {
                    block32: {
                        block28: {
                            var3_3 = TextUtils.isEmpty((CharSequence)var1_1);
                            if (var3_3) break block31;
                            var3_3 = false;
                            var4_4 = null;
                            var5_5 = 1;
                            if (!var2_2) break block32;
                            try {
                                var6_6 = this.zzb;
                                if (var6_6 != null) ** GOTO lbl50
                                var6_6 = "com.google.android.gms";
                            }
                            catch (SecurityException var6_7) {
                                var4_4 = this.zza.zzat().zzb();
                                var1_1 = zzei.zzl((String)var1_1);
                                var4_4.zzb("Measurement Service called with invalid calling package. appId", var1_1);
                                throw var6_7;
                            }
                            var7_9 = this.zzc;
                            var2_2 = var6_6.equals(var7_9);
                            if (var2_2) break block28;
                            var6_6 = this.zza;
                            var6_6 = var6_6.zzaw();
                            var8_10 = Binder.getCallingUid();
                            var2_2 = UidVerifier.isGooglePlayServicesUid((Context)var6_6, var8_10);
                            if (var2_2) break block28;
                            var6_6 = this.zza;
                            var6_6 = var6_6.zzaw();
                            var6_6 = GoogleSignatureVerifier.getInstance((Context)var6_6);
                            var8_10 = Binder.getCallingUid();
                            var2_2 = var6_6.isUidGoogleSigned(var8_10);
                            if (var2_2) break block28;
                            var2_2 = false;
                            var6_6 = null;
                        }
                        var2_2 = var5_5;
                        var6_6 = var2_2;
                        this.zzb = var6_6;
lbl50:
                        // 2 sources

                        var6_6 = this.zzb;
                        var2_2 = var6_6.booleanValue();
                        if (var2_2) break block29;
                    }
                    var6_6 = this.zzc;
                    if (var6_6 != null) ** GOTO lbl69
                    var6_6 = this.zza;
                    var6_6 = var6_6.zzaw();
                    var8_10 = Binder.getCallingUid();
                    var2_2 = GooglePlayServicesUtilLight.uidHasPackageName((Context)var6_6, var8_10, (String)var1_1);
                    if (!var2_2) ** GOTO lbl69
                    this.zzc = var1_1;
lbl69:
                    // 3 sources

                    var6_6 = this.zzc;
                    var2_2 = var1_1.equals(var6_6);
                    if (!var2_2) break block30;
                }
                return;
            }
            var9_11 = new Object[var5_5];
            var9_11[0] = var1_1;
            var4_4 = "Unknown calling package name '%s'.";
            var4_4 = String.format((String)var4_4, var9_11);
            var6_6 = new SecurityException((String)var4_4);
            throw var6_6;
        }
        var1_1 = this.zza.zzat().zzb();
        var6_8 = "Measurement Service called without app package";
        var1_1.zza(var6_8);
        var1_1 = new SecurityException(var6_8);
        throw var1_1;
    }

    public final zzas zzb(zzas zzas2, zzp object) {
        boolean bl2;
        String string2 = "_cmp";
        object = zzas2.zza;
        int n10 = string2.equals(object);
        if (n10 != 0 && (object = zzas2.zzb) != null && (n10 = ((zzaq)object).zze()) != 0 && ((bl2 = (string2 = "referrer broadcast").equals(object = zzas2.zzb.zzd("_cis"))) || (n10 = (int)((string2 = "referrer API").equals(object) ? 1 : 0)) != 0)) {
            object = this.zza.zzat().zzi();
            string2 = zzas2.toString();
            ((zzeg)object).zzb("Event has been filtered ", string2);
            zzaq zzaq2 = zzas2.zzb;
            String string3 = zzas2.zzc;
            long l10 = zzas2.zzd;
            object = new zzas("_cmpx", zzaq2, string3, l10);
            return object;
        }
        return zzas2;
    }

    public final void zzc(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        zzfi zzfi2 = this.zza.zzau();
        boolean bl2 = zzfi2.zzd();
        if (bl2) {
            runnable.run();
            return;
        }
        this.zza.zzau().zzh(runnable);
    }

    public final void zzd(zzas zzas2, zzp zzp2) {
        Preconditions.checkNotNull(zzas2);
        this.zzx(zzp2, false);
        zzfw zzfw2 = new zzfw(this, zzas2, zzp2);
        this.zzc(zzfw2);
    }

    public final void zze(zzkg zzkg2, zzp zzp2) {
        Preconditions.checkNotNull(zzkg2);
        this.zzx(zzp2, false);
        zzfz zzfz2 = new zzfz(this, zzkg2, zzp2);
        this.zzc(zzfz2);
    }

    public final void zzf(zzp zzp2) {
        this.zzx(zzp2, false);
        zzgb zzgb2 = new zzgb(this, zzp2);
        this.zzc(zzgb2);
    }

    public final void zzg(zzas zzas2, String string2, String object) {
        Preconditions.checkNotNull(zzas2);
        Preconditions.checkNotEmpty(string2);
        this.zzy(string2, true);
        object = new zzfx(this, zzas2, string2);
        this.zzc((Runnable)object);
    }

    public final void zzh(zzp zzp2) {
        this.zzx(zzp2, false);
        zzfu zzfu2 = new zzfu(this, zzp2);
        this.zzc(zzfu2);
    }

    /*
     * WARNING - void declaration
     */
    public final List zzi(zzp object, boolean bl2) {
        void var9_11;
        Iterator iterator2;
        block17: {
            this.zzx((zzp)object, false);
            iterator2 = ((zzp)object).zza;
            Preconditions.checkNotNull(iterator2);
            ArrayList<Object> arrayList = this.zza.zzau();
            Object object2 = new zzga(this, (String)((Object)iterator2));
            iterator2 = ((zzfi)((Object)arrayList)).zze((Callable)object2);
            iterator2 = iterator2.get();
            iterator2 = (List)((Object)iterator2);
            int n10 = iterator2.size();
            try {
                arrayList = new ArrayList<Object>(n10);
                iterator2 = iterator2.iterator();
            }
            catch (ExecutionException executionException) {
                break block17;
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
            while (true) {
                Object object3;
                block16: {
                    n10 = (int)(iterator2.hasNext() ? 1 : 0);
                    if (n10 == 0) break;
                    object2 = iterator2.next();
                    object2 = (zzki)object2;
                    if (bl2) break block16;
                    object3 = ((zzki)object2).zzc;
                    boolean bl3 = zzkk.zzR((String)object3);
                    if (bl3) continue;
                }
                object3 = new zzkg((zzki)object2);
                arrayList.add(object3);
                continue;
                break;
            }
            return arrayList;
        }
        iterator2 = this.zza.zzat().zzb();
        object = zzei.zzl(((zzp)object).zza);
        ((zzeg)((Object)iterator2)).zzc("Failed to get user properties. appId", object, var9_11);
        return null;
    }

    /*
     * WARNING - void declaration
     */
    public final byte[] zzj(zzas object, String object2) {
        void var4_7;
        Object object3;
        Object object4;
        long l10;
        long l11;
        Object object5;
        Object object6;
        Object object7;
        block25: {
            Preconditions.checkNotEmpty((String)object2);
            Preconditions.checkNotNull(object);
            boolean bl2 = true;
            this.zzy((String)object2, bl2);
            object7 = this.zza.zzat().zzj();
            object6 = this.zza.zzq();
            object5 = ((zzas)object).zza;
            object6 = ((zzed)object6).zzc((String)object5);
            object5 = "Log and bundle. event";
            ((zzeg)object7).zzb((String)object5, object6);
            object7 = this.zza.zzax();
            l11 = object7.nanoTime();
            l10 = 1000000L;
            l11 /= l10;
            object4 = this.zza.zzau();
            object3 = new zzfy(this, (zzas)object, (String)object2);
            object4 = ((zzfi)object4).zzf((Callable)object3);
            object4 = object4.get();
            object4 = (byte[])object4;
            if (object4 != null) break block25;
            object4 = this.zza;
            object4 = ((zzkd)object4).zzat();
            object4 = ((zzei)object4).zzb();
            object3 = "Log and bundle returned null. appId";
            Object object8 = zzei.zzl((String)object2);
            ((zzeg)object4).zzb((String)object3, object8);
            object4 = null;
            object4 = new byte[0];
        }
        object3 = this.zza;
        object3 = ((zzkd)object3).zzax();
        long l12 = object3.nanoTime();
        Object object9 = this.zza;
        object9 = ((zzkd)object9).zzat();
        object9 = ((zzei)object9).zzj();
        String string2 = "Log and bundle processed. event, size, time_ms";
        Object object10 = this.zza;
        object10 = ((zzkd)object10).zzq();
        Object object11 = ((zzas)object).zza;
        object10 = ((zzed)object10).zzc((String)object11);
        int n10 = ((Object)object4).length;
        object11 = n10;
        l12 = l12 / l10 - l11;
        object7 = l12;
        try {
            ((zzeg)object9).zzd(string2, object10, object11, object7);
            return object4;
        }
        catch (ExecutionException executionException) {
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        object6 = this.zza.zzat().zzb();
        object2 = zzei.zzl((String)object2);
        object5 = this.zza.zzq();
        object = ((zzas)object).zza;
        object = ((zzed)object5).zzc((String)object);
        ((zzeg)object6).zzd("Failed to log and bundle. appId, event, error", object2, object, var4_7);
        return null;
    }

    public final void zzk(long l10, String string2, String string3, String string4) {
        zzgc zzgc2 = new zzgc(this, string3, string4, string2, l10);
        this.zzc(zzgc2);
    }

    public final String zzl(zzp zzp2) {
        this.zzx(zzp2, false);
        return this.zza.zzY(zzp2);
    }

    public final void zzm(zzaa object, zzp zzp2) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(((zzaa)object).zzc);
        this.zzx(zzp2, false);
        zzaa zzaa2 = new zzaa((zzaa)object);
        zzaa2.zza = object = zzp2.zza;
        object = new zzfn(this, zzaa2, zzp2);
        this.zzc((Runnable)object);
    }

    public final void zzn(zzaa object) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(((zzaa)object).zzc);
        Preconditions.checkNotEmpty(((zzaa)object).zza);
        Object object2 = ((zzaa)object).zza;
        this.zzy((String)object2, true);
        object2 = new zzaa((zzaa)object);
        object = new zzfo(this, (zzaa)object2);
        this.zzc((Runnable)object);
    }

    /*
     * WARNING - void declaration
     */
    public final List zzo(String iterator2, String arrayList, boolean bl2, zzp zzp2) {
        void var1_4;
        block17: {
            int n10 = 0;
            this.zzx(zzp2, false);
            Object object = zzp2.zza;
            Preconditions.checkNotNull(object);
            Object object2 = this.zza.zzau();
            zzfp zzfp2 = new zzfp(this, (String)object, (String)((Object)iterator2), (String)((Object)arrayList));
            iterator2 = ((zzfi)object2).zze(zzfp2);
            iterator2 = iterator2.get();
            iterator2 = (List)((Object)iterator2);
            n10 = iterator2.size();
            try {
                arrayList = new ArrayList<Object>(n10);
                iterator2 = iterator2.iterator();
            }
            catch (ExecutionException executionException) {
                break block17;
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
            while (true) {
                block16: {
                    n10 = (int)(iterator2.hasNext() ? 1 : 0);
                    if (n10 == 0) break;
                    object = iterator2.next();
                    object = (zzki)object;
                    if (bl2) break block16;
                    object2 = ((zzki)object).zzc;
                    boolean bl3 = zzkk.zzR((String)object2);
                    if (bl3) continue;
                }
                object2 = new zzkg((zzki)object);
                arrayList.add(object2);
                continue;
                break;
            }
            return arrayList;
        }
        arrayList = this.zza.zzat().zzb();
        Object object = zzei.zzl(zzp2.zza);
        ((zzeg)((Object)arrayList)).zzc("Failed to query user properties. appId", object, var1_4);
        return Collections.emptyList();
    }

    /*
     * WARNING - void declaration
     */
    public final List zzp(String object, String iterator2, String arrayList, boolean bl2) {
        void var2_5;
        block17: {
            int n10 = 1;
            this.zzy((String)object, n10 != 0);
            Object object2 = this.zza.zzau();
            Object object3 = new zzfq(this, (String)object, (String)((Object)iterator2), (String)((Object)arrayList));
            iterator2 = ((zzfi)object2).zze((Callable)object3);
            iterator2 = iterator2.get();
            iterator2 = (List)((Object)iterator2);
            n10 = iterator2.size();
            try {
                arrayList = new ArrayList<Object>(n10);
                iterator2 = iterator2.iterator();
            }
            catch (ExecutionException executionException) {
                break block17;
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
            while (true) {
                block16: {
                    n10 = (int)(iterator2.hasNext() ? 1 : 0);
                    if (n10 == 0) break;
                    object2 = iterator2.next();
                    object2 = (zzki)object2;
                    if (bl2) break block16;
                    object3 = ((zzki)object2).zzc;
                    boolean bl3 = zzkk.zzR((String)object3);
                    if (bl3) continue;
                }
                object3 = new zzkg((zzki)object2);
                arrayList.add(object3);
                continue;
                break;
            }
            return arrayList;
        }
        arrayList = this.zza.zzat().zzb();
        object = zzei.zzl((String)object);
        ((zzeg)((Object)arrayList)).zzc("Failed to get user properties as. appId", object, var2_5);
        return Collections.emptyList();
    }

    /*
     * WARNING - void declaration
     */
    public final List zzq(String object, String string2, zzp object2) {
        void var1_4;
        this.zzx((zzp)object2, false);
        object2 = ((zzp)object2).zza;
        Preconditions.checkNotNull(object2);
        zzfi zzfi2 = this.zza.zzau();
        zzfr zzfr2 = new zzfr(this, (String)object2, (String)object, string2);
        object = zzfi2.zze(zzfr2);
        object = object.get();
        try {
            return (List)object;
        }
        catch (ExecutionException executionException) {
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        this.zza.zzat().zzb().zzb("Failed to get conditional user properties", var1_4);
        return Collections.emptyList();
    }

    /*
     * WARNING - void declaration
     */
    public final List zzr(String object, String string2, String string3) {
        void var1_4;
        boolean bl2 = true;
        this.zzy((String)object, bl2);
        zzfi zzfi2 = this.zza.zzau();
        zzfs zzfs2 = new zzfs(this, (String)object, string2, string3);
        object = zzfi2.zze(zzfs2);
        object = object.get();
        try {
            return (List)object;
        }
        catch (ExecutionException executionException) {
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        this.zza.zzat().zzb().zzb("Failed to get conditional user properties as", var1_4);
        return Collections.emptyList();
    }

    public final void zzs(zzp zzp2) {
        Preconditions.checkNotEmpty(zzp2.zza);
        Object object = zzp2.zza;
        this.zzy((String)object, false);
        object = new zzft(this, zzp2);
        this.zzc((Runnable)object);
    }

    public final void zzt(Bundle bundle, zzp object) {
        this.zzx((zzp)object, false);
        object = ((zzp)object).zza;
        Preconditions.checkNotNull(object);
        zzfm zzfm2 = new zzfm(this, (String)object, bundle);
        this.zzc(zzfm2);
    }

    public final void zzu(zzp object) {
        zzlc.zzb();
        Object object2 = this.zza.zzd();
        zzdv zzdv2 = zzdw.zzay;
        boolean bl2 = ((zzae)object2).zzn(null, zzdv2);
        if (bl2) {
            Preconditions.checkNotEmpty(((zzp)object).zza);
            Preconditions.checkNotNull(((zzp)object).zzv);
            object2 = new zzfv(this, (zzp)object);
            Preconditions.checkNotNull(object2);
            object = this.zza.zzau();
            boolean bl3 = ((zzfi)object).zzd();
            if (bl3) {
                object2.run();
                return;
            }
            object = this.zza.zzau();
            ((zzfi)object).zzj((Runnable)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final /* synthetic */ void zzv(String object, Bundle object2) {
        int n10;
        zzan zzan2;
        Object object3 = this.zza.zzi();
        ((zzge)object3).zzg();
        ((zzjv)object3).zzX();
        Object object4 = ((zzge)object3).zzx;
        String string2 = "dep";
        long l10 = 0L;
        long l11 = 0L;
        Object object5 = zzan2;
        Object object6 = object;
        zzan2 = new zzan((zzfl)object4, "", (String)object, string2, l10, l11, (Bundle)object2);
        object2 = ((zzju)object3).zza.zzn().zzf(zzan2).zzbp();
        object5 = ((zzge)object3).zzx.zzat().zzk();
        object4 = ((zzge)object3).zzx.zzm().zzc((String)object);
        int n11 = ((Bundle)object2).length;
        Integer n12 = n11;
        object6 = "Saving default event parameters, appId, data size";
        ((zzeg)object5).zzc((String)object6, object4, n12);
        object5 = new ContentValues();
        object5.put("app_id", (String)object);
        object4 = "parameters";
        object5.put((String)object4, (byte[])object2);
        try {
            object2 = ((zzai)object3).zze();
            object4 = "default_event_params";
            n11 = 0;
            n12 = null;
            n10 = 5;
        }
        catch (SQLiteException sQLiteException) {
            object3 = ((zzge)object3).zzx.zzat().zzb();
            object = zzei.zzl((String)object);
            ((zzeg)object3).zzc("Error storing default event parameters. appId", object, (Object)sQLiteException);
            return;
        }
        long l12 = object2.insertWithOnConflict((String)object4, null, (ContentValues)object5, n10);
        long l13 = -1;
        long l14 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
        if (l14 != false) return;
        object2 = ((zzge)object3).zzx;
        object2 = ((zzfl)object2).zzat();
        object2 = ((zzei)object2).zzb();
        object5 = "Failed to insert default event parameters (got -1). appId";
        object4 = zzei.zzl((String)object);
        ((zzeg)object2).zzb((String)object5, object4);
    }
}

