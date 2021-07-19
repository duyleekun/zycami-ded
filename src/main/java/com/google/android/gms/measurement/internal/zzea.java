/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.Signature
 *  android.content.res.Resources
 *  android.text.TextUtils
 */
package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.wrappers.InstantApps;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzlc;
import com.google.android.gms.internal.measurement.zzmg;
import com.google.android.gms.internal.measurement.zznb;
import com.google.android.gms.internal.measurement.zznk;
import com.google.android.gms.measurement.internal.zzae;
import com.google.android.gms.measurement.internal.zzdv;
import com.google.android.gms.measurement.internal.zzdw;
import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzei;
import com.google.android.gms.measurement.internal.zzex;
import com.google.android.gms.measurement.internal.zzf;
import com.google.android.gms.measurement.internal.zzfd;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzge;
import com.google.android.gms.measurement.internal.zzht;
import com.google.android.gms.measurement.internal.zzkk;
import com.google.android.gms.measurement.internal.zzp;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.List;

public final class zzea
extends zzf {
    private String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private String zze;
    private long zzf;
    private final long zzg;
    private List zzh;
    private int zzi;
    private String zzj;
    private String zzk;
    private String zzl;

    public zzea(zzfl zzfl2, long l10) {
        super(zzfl2);
        this.zzg = l10;
    }

    public final boolean zze() {
        return true;
    }

    /*
     * Unable to fully structure code
     */
    public final void zzf() {
        block122: {
            block123: {
                block121: {
                    block120: {
                        block115: {
                            block118: {
                                block119: {
                                    block117: {
                                        block116: {
                                            block111: {
                                                block114: {
                                                    block113: {
                                                        block112: {
                                                            block110: {
                                                                block109: {
                                                                    block105: {
                                                                        block108: {
                                                                            block107: {
                                                                                block106: {
                                                                                    var1_1 = this.zzx.zzaw().getPackageName();
                                                                                    var2_2 = this.zzx.zzaw().getPackageManager();
                                                                                    var3_3 = "Unknown";
                                                                                    var4_4 = -1 << -1;
                                                                                    var5_5 = "";
                                                                                    var6_6 = "unknown";
                                                                                    if (var2_2 == null) {
                                                                                        var7_7 = this.zzx.zzat().zzb();
                                                                                        var8_8 = zzei.zzl((String)var1_1);
                                                                                        var9_9 = "PackageManager is null, app identity information might be inaccurate. appId";
                                                                                        var7_7.zzb((String)var9_9, var8_8);
                                                                                        while (true) {
                                                                                            var8_8 = var3_3;
                                                                                            break block105;
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    try {
                                                                                        var6_6 = var2_2.getInstallerPackageName((String)var1_1);
                                                                                    }
                                                                                    catch (IllegalArgumentException v0) {
                                                                                        var7_7 = this.zzx.zzat().zzb();
                                                                                        var8_8 = zzei.zzl((String)var1_1);
                                                                                        var9_9 = "Error retrieving app installer package name. appId";
                                                                                        var7_7.zzb((String)var9_9, var8_8);
                                                                                    }
                                                                                    if (var6_6 == null) {
                                                                                        var6_6 = "manual_install";
                                                                                    } else {
                                                                                        var7_7 = "com.android.vending";
                                                                                        var10_10 = var7_7.equals(var6_6);
                                                                                        if (var10_10) {
                                                                                            var6_6 = var5_5;
                                                                                        }
                                                                                    }
                                                                                    var7_7 = this.zzx;
                                                                                    var7_7 = var7_7.zzaw();
                                                                                    var7_7 = var7_7.getPackageName();
                                                                                    if ((var7_7 = var2_2.getPackageInfo((String)var7_7, 0)) == null) ** continue;
                                                                                    var8_8 = var7_7.applicationInfo;
                                                                                    var8_8 = var2_2.getApplicationLabel((ApplicationInfo)var8_8);
                                                                                    var11_11 = TextUtils.isEmpty((CharSequence)var8_8);
                                                                                    if (var11_11 != 0) break block106;
                                                                                    var8_8 = var8_8.toString();
                                                                                    break block107;
                                                                                }
                                                                                var8_8 = var3_3;
                                                                            }
                                                                            try {
                                                                                var3_3 = var7_7.versionName;
                                                                            }
                                                                            catch (PackageManager.NameNotFoundException v1) {
                                                                                var7_7 = var3_3;
                                                                                var3_3 = var8_8;
                                                                                break block108;
                                                                            }
                                                                            var4_4 = var7_7.versionCode;
                                                                            break block105;
                                                                            catch (PackageManager.NameNotFoundException v2) {
                                                                                var7_7 = var3_3;
                                                                            }
                                                                        }
                                                                        var8_8 = this.zzx.zzat().zzb();
                                                                        var9_9 = zzei.zzl((String)var1_1);
                                                                        var12_12 = "Error retrieving package info. appId, appName";
                                                                        var8_8.zzc((String)var12_12, var9_9, var3_3);
                                                                        var8_8 = var3_3;
                                                                        var3_3 = var7_7;
                                                                    }
                                                                    this.zza = var1_1;
                                                                    this.zzd = var6_6;
                                                                    this.zzb = var3_3;
                                                                    this.zzc = var4_4;
                                                                    this.zze = var8_8;
                                                                    this.zzf = var13_13 = 0L;
                                                                    var3_3 = this.zzx.zzr();
                                                                    var15_14 = TextUtils.isEmpty((CharSequence)var3_3);
                                                                    var4_4 = 1;
                                                                    if (var15_14 == 0 && (var15_14 = (var6_6 = "am").equals(var3_3 = this.zzx.zzs())) != 0) {
                                                                        var15_14 = var4_4;
                                                                    } else {
                                                                        var15_14 = 0;
                                                                        var3_3 = null;
                                                                    }
                                                                    var6_6 = this.zzx;
                                                                    var16_15 = var6_6.zzG();
                                                                    switch (var16_15) {
                                                                        default: {
                                                                            var7_7 = this.zzx.zzat().zzi();
                                                                            var8_8 = "App measurement disabled due to denied storage consent";
                                                                            var7_7.zza((String)var8_8);
                                                                            break;
                                                                        }
                                                                        case 7: {
                                                                            var7_7 = this.zzx.zzat().zzi();
                                                                            var8_8 = "App measurement disabled via the global data collection setting";
                                                                            var7_7.zza((String)var8_8);
                                                                            break;
                                                                        }
                                                                        case 6: {
                                                                            var7_7 = this.zzx.zzat().zzh();
                                                                            var8_8 = "App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics";
                                                                            var7_7.zza((String)var8_8);
                                                                            break;
                                                                        }
                                                                        case 5: {
                                                                            var7_7 = this.zzx.zzat().zzk();
                                                                            var8_8 = "App measurement disabled via the init parameters";
                                                                            var7_7.zza((String)var8_8);
                                                                            break;
                                                                        }
                                                                        case 4: {
                                                                            var7_7 = this.zzx.zzat().zzi();
                                                                            var8_8 = "App measurement disabled via the manifest";
                                                                            var7_7.zza((String)var8_8);
                                                                            break;
                                                                        }
                                                                        case 3: {
                                                                            var7_7 = this.zzx.zzat().zzi();
                                                                            var8_8 = "App measurement disabled by setAnalyticsCollectionEnabled(false)";
                                                                            var7_7.zza((String)var8_8);
                                                                            break;
                                                                        }
                                                                        case 2: {
                                                                            var7_7 = this.zzx.zzat().zzk();
                                                                            var8_8 = "App measurement deactivated via the init parameters";
                                                                            var7_7.zza((String)var8_8);
                                                                            break;
                                                                        }
                                                                        case 1: {
                                                                            var7_7 = this.zzx.zzat().zzi();
                                                                            var8_8 = "App measurement deactivated via the manifest";
                                                                            var7_7.zza((String)var8_8);
                                                                            break;
                                                                        }
                                                                        case 0: {
                                                                            var7_7 = this.zzx.zzat().zzk();
                                                                            var8_8 = "App measurement collection enabled";
                                                                            var7_7.zza((String)var8_8);
                                                                        }
                                                                    }
                                                                    this.zzj = var5_5;
                                                                    this.zzk = var5_5;
                                                                    this.zzl = var5_5;
                                                                    var7_7 = this.zzx;
                                                                    var7_7.zzas();
                                                                    if (var15_14 != 0) {
                                                                        this.zzk = var3_3 = this.zzx.zzr();
                                                                    }
                                                                    var15_14 = 0;
                                                                    var3_3 = null;
                                                                    zznb.zzb();
                                                                    var7_7 = this.zzx;
                                                                    var7_7 = var7_7.zzc();
                                                                    var8_8 = zzdw.zzaB;
                                                                    var10_10 = var7_7.zzn(null, (zzdv)var8_8);
                                                                    var9_9 = "google_app_id";
                                                                    if (!var10_10) break block109;
                                                                    var7_7 = this.zzx;
                                                                    var7_7 = var7_7.zzaw();
                                                                    var12_12 = this.zzx;
                                                                    var12_12 = var12_12.zzv();
                                                                    var7_7 = zzht.zzb((Context)var7_7, (String)var9_9, (String)var12_12);
                                                                    break block110;
                                                                }
                                                                var7_7 = this.zzx;
                                                                var7_7 = var7_7.zzaw();
                                                                var7_7 = zzht.zza((Context)var7_7, (String)var9_9);
                                                            }
                                                            var11_11 = TextUtils.isEmpty((CharSequence)var7_7);
                                                            var9_9 = var4_4 != var11_11 ? var7_7 : var5_5;
                                                            this.zzj = var9_9;
                                                            zzmg.zzb();
                                                            var9_9 = this.zzx;
                                                            var9_9 = var9_9.zzc();
                                                            var12_12 = zzdw.zzah;
                                                            var11_11 = (int)var9_9.zzn(null, (zzdv)var12_12);
                                                            var12_12 = "admob_app_id";
                                                            if (var11_11 == 0) ** GOTO lbl263
                                                            zznb.zzb();
                                                            var9_9 = this.zzx;
                                                            var9_9 = var9_9.zzc();
                                                            var17_16 = var9_9.zzn(null, (zzdv)var8_8);
                                                            var9_9 = "ga_app_id";
                                                            if (!var17_16) break block111;
                                                            var8_8 = this.zzx;
                                                            var8_8 = var8_8.zzaw();
                                                            var18_17 = this.zzx;
                                                            var18_17 = var18_17.zzv();
                                                            Preconditions.checkNotNull(var8_8);
                                                            var19_18 = var8_8.getResources();
                                                            var20_19 = TextUtils.isEmpty((CharSequence)var18_17);
                                                            if (!var20_19) break block112;
                                                            var18_17 = zzfd.zza((Context)var8_8);
                                                        }
                                                        var8_8 = zzfd.zzb((String)var9_9, var19_18, (String)var18_17);
                                                        var11_11 = (int)TextUtils.isEmpty((CharSequence)var8_8);
                                                        if (var4_4 == var11_11) break block113;
                                                        var5_5 = var8_8;
                                                    }
                                                    this.zzl = var5_5;
                                                    var4_4 = (int)TextUtils.isEmpty((CharSequence)var7_7);
                                                    if (var4_4 == 0) break block114;
                                                    var4_4 = (int)TextUtils.isEmpty((CharSequence)var8_8);
                                                    if (var4_4 != 0) break block115;
                                                }
                                                var21_20 = zzfd.zzb((String)var12_12, var19_18, (String)var18_17);
                                                this.zzk = var21_20;
                                                break block115;
                                            }
                                            var18_17 = this.zzx;
                                            var18_17 = var18_17.zzaw();
                                            var8_8 = new StringResourceValueReader((Context)var18_17);
                                            var9_9 = var8_8.getString((String)var9_9);
                                            var22_22 = TextUtils.isEmpty((CharSequence)var9_9);
                                            if (var4_4 == var22_22) break block116;
                                            var5_5 = var9_9;
                                        }
                                        this.zzl = var5_5;
                                        var4_4 = (int)TextUtils.isEmpty((CharSequence)var7_7);
                                        if (var4_4 == 0) break block117;
                                        var4_4 = (int)TextUtils.isEmpty((CharSequence)var9_9);
                                        if (var4_4 != 0) break block115;
                                    }
                                    var21_20 = var8_8.getString((String)var12_12);
                                    this.zzk = var21_20;
                                    break block115;
lbl263:
                                    // 1 sources

                                    var4_4 = (int)TextUtils.isEmpty((CharSequence)var7_7);
                                    if (var4_4 != 0) break block115;
                                    zznb.zzb();
                                    var21_20 = this.zzx;
                                    var21_20 = var21_20.zzc();
                                    var4_4 = (int)var21_20.zzn(null, (zzdv)var8_8);
                                    if (var4_4 == 0) break block118;
                                    var21_20 = this.zzx;
                                    var21_20 = var21_20.zzaw();
                                    var5_5 = this.zzx;
                                    var5_5 = var5_5.zzv();
                                    Preconditions.checkNotNull(var21_20);
                                    var7_7 = var21_20.getResources();
                                    var17_16 = TextUtils.isEmpty((CharSequence)var5_5);
                                    if (!var17_16) break block119;
                                    var5_5 = zzfd.zza((Context)var21_20);
                                }
                                var21_20 = zzfd.zzb((String)var12_12, (Resources)var7_7, (String)var5_5);
                                this.zzk = var21_20;
                                break block115;
                            }
                            var5_5 = this.zzx;
                            var5_5 = var5_5.zzaw();
                            var21_20 = new StringResourceValueReader((Context)var5_5);
                            var21_20 = var21_20.getString((String)var12_12);
                            this.zzk = var21_20;
                        }
                        if (var16_15 != 0) break block123;
                        var21_20 = this.zzx;
                        var21_20 = var21_20.zzat();
                        var21_20 = var21_20.zzk();
                        var5_5 = "App measurement enabled for app package, google app id";
                        var6_6 = this.zza;
                        var7_7 = this.zzj;
                        var10_10 = TextUtils.isEmpty((CharSequence)var7_7);
                        if (!var10_10) break block120;
                        var7_7 = this.zzk;
                        break block121;
                    }
                    var7_7 = this.zzj;
                }
                try {
                    var21_20.zzc((String)var5_5, var6_6, var7_7);
                }
                catch (IllegalStateException var21_21) {
                    var5_5 = this.zzx.zzat().zzb();
                    var1_1 = zzei.zzl((String)var1_1);
                    var6_6 = "Fetching Google App Id failed with exception. appId";
                    var5_5.zzc((String)var6_6, var1_1, var21_21);
                }
            }
            this.zzh = null;
            this.zzx.zzas();
            var1_1 = this.zzx.zzc();
            var3_3 = "analytics.safelisted_events";
            var1_1 = var1_1.zzq((String)var3_3);
            if (var1_1 == null) ** GOTO lbl360
            var15_14 = var1_1.size();
            if (var15_14 == 0) {
                var1_1 = this.zzx.zzat().zzh();
                var3_3 = "Safelisted event list is empty. Ignoring";
                var1_1.zza((String)var3_3);
            } else {
                var3_3 = var1_1.iterator();
                while ((var4_4 = (int)var3_3.hasNext()) != 0) {
                    var21_20 = (String)var3_3.next();
                    var5_5 = this.zzx.zzl();
                    var4_4 = (int)var5_5.zzk((String)(var6_6 = "safelisted event"), (String)var21_20);
                    if (var4_4 != 0) continue;
                    break block122;
                }
lbl360:
                // 2 sources

                this.zzh = var1_1;
            }
        }
        if (var2_2 != null) {
            var23_23 = InstantApps.isInstantApp(this.zzx.zzaw());
            this.zzi = (int)var23_23;
            return;
        }
        this.zzi = 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final zzp zzh(String string2) {
        zzp zzp2;
        Object object;
        Object object2;
        Object[] objectArray;
        int n10;
        boolean bl2;
        boolean bl3;
        long l10;
        int n11;
        Object[] objectArray2;
        Object object3;
        Object object4;
        boolean bl4;
        long l11;
        long l12;
        long l13;
        String string3;
        long l14;
        String string4;
        String string5;
        String string6;
        zzea zzea2;
        block23: {
            block22: {
                Object object5;
                block21: {
                    block24: {
                        block26: {
                            block20: {
                                long l15;
                                block19: {
                                    MessageDigest messageDigest;
                                    PackageManager packageManager;
                                    Context context;
                                    block25: {
                                        zzea2 = this;
                                        ((zzge)this).zzg();
                                        string6 = this.zzi();
                                        string5 = this.zzj();
                                        this.zzb();
                                        string4 = this.zzb;
                                        this.zzb();
                                        l14 = this.zzc;
                                        this.zzb();
                                        Preconditions.checkNotNull(this.zzd);
                                        string3 = this.zzd;
                                        zzae zzae2 = this.zzx.zzc();
                                        zzae2.zzf();
                                        this.zzb();
                                        ((zzge)this).zzg();
                                        l13 = this.zzf;
                                        l12 = 0L;
                                        l11 = l13 == l12 ? 0 : (l13 < l12 ? -1 : 1);
                                        bl4 = false;
                                        object4 = null;
                                        if (l11 != false) break block24;
                                        object3 = this.zzx.zzl();
                                        context = this.zzx.zzaw();
                                        objectArray2 = this.zzx.zzaw().getPackageName();
                                        ((zzge)object3).zzg();
                                        Preconditions.checkNotNull(context);
                                        Preconditions.checkNotEmpty((String)objectArray2);
                                        packageManager = context.getPackageManager();
                                        messageDigest = zzkk.zzN();
                                        l15 = -1;
                                        if (messageDigest != null) break block25;
                                        zzeg zzeg2 = ((zzge)object3).zzx.zzat().zzb();
                                        object3 = "Could not get MD5 instance";
                                        zzeg2.zza((String)object3);
                                        break block19;
                                    }
                                    if (packageManager != null) {
                                        try {
                                            n11 = ((zzkk)object3).zzW(context, (String)objectArray2);
                                            if (n11 == 0) {
                                                PackageManagerWrapper packageManagerWrapper = Wrappers.packageManager(context);
                                                objectArray2 = ((zzge)object3).zzx;
                                                objectArray2 = objectArray2.zzaw();
                                                objectArray2 = objectArray2.getPackageName();
                                                int n12 = 64;
                                                PackageInfo packageInfo = packageManagerWrapper.getPackageInfo((String)objectArray2, n12);
                                                Signature[] signatureArray = packageInfo.signatures;
                                                if (signatureArray != null && (n11 = signatureArray.length) > 0) {
                                                    Signature signature = signatureArray[0];
                                                    byte[] byArray2 = signature.toByteArray();
                                                    byArray2 = messageDigest.digest(byArray2);
                                                    l15 = l13 = zzkk.zzO(byArray2);
                                                    break block19;
                                                } else {
                                                    zzfl zzfl2 = ((zzge)object3).zzx;
                                                    zzei zzei2 = zzfl2.zzat();
                                                    zzeg zzeg3 = zzei2.zze();
                                                    objectArray2 = "Could not get signatures";
                                                    zzeg3.zza((String)objectArray2);
                                                }
                                                break block19;
                                            }
                                            l15 = l12;
                                        }
                                        catch (PackageManager.NameNotFoundException nameNotFoundException) {
                                            object3 = ((zzge)object3).zzx.zzat().zzb();
                                            objectArray2 = "Package name not found";
                                            ((zzeg)object3).zzb((String)objectArray2, (Object)nameNotFoundException);
                                            break block20;
                                        }
                                    }
                                    break block20;
                                }
                                l13 = l15;
                                break block26;
                            }
                            l13 = l12;
                        }
                        zzea2.zzf = l13;
                    }
                    l10 = l13;
                    zzfl zzfl3 = zzea2.zzx;
                    l11 = (long)zzfl3.zzF();
                    bl3 = zzea2.zzx.zzd().zzp;
                    n11 = 1;
                    bl2 = bl3 ^ true;
                    ((zzge)this).zzg();
                    object3 = zzea2.zzx;
                    bl3 = ((zzfl)object3).zzF();
                    n10 = 0;
                    object5 = null;
                    if (bl3) {
                        zznk.zzb();
                        object3 = zzea2.zzx.zzc();
                        objectArray = zzdw.zzaj;
                        bl3 = ((zzae)object3).zzn(null, (zzdv)objectArray);
                        if (bl3) {
                            object3 = zzea2.zzx.zzat().zzk();
                            objectArray = "Disabled IID for tests.";
                            ((zzeg)object3).zza((String)objectArray);
                        } else {
                            try {
                                object3 = zzea2.zzx;
                                object3 = ((zzfl)object3).zzaw();
                                object3 = object3.getClassLoader();
                                objectArray = "com.google.firebase.analytics.FirebaseAnalytics";
                                object3 = ((ClassLoader)object3).loadClass((String)objectArray);
                                if (object3 != null) break block21;
                            }
                            catch (ClassNotFoundException classNotFoundException) {
                                break block22;
                            }
                        }
                    }
                    object2 = null;
                    break block23;
                }
                try {
                    Class<Context> clazz;
                    objectArray = new Class[n11];
                    objectArray[0] = clazz = Context.class;
                    object5 = "getInstance";
                    object5 = ((Class)object3).getDeclaredMethod((String)object5, (Class<?>[])objectArray);
                    objectArray = new Object[n11];
                    objectArray2 = zzea2.zzx;
                    objectArray2 = objectArray2.zzaw();
                    objectArray[0] = objectArray2;
                    n11 = 0;
                    objectArray2 = null;
                    object5 = ((Method)object5).invoke(null, objectArray);
                    if (object5 == null) break block22;
                    objectArray2 = "getFirebaseInstanceId";
                }
                catch (Exception exception) {
                    object3 = zzea2.zzx.zzat().zzf();
                    objectArray2 = "Failed to obtain Firebase Analytics instance";
                    ((zzeg)object3).zza((String)objectArray2);
                    break block22;
                }
                try {
                    objectArray = new Class[]{};
                    object3 = ((Class)object3).getDeclaredMethod((String)objectArray2, (Class<?>[])objectArray);
                    objectArray2 = new Object[]{};
                    object3 = ((Method)object3).invoke(object5, objectArray2);
                    object2 = object3 = (String)object3;
                    break block23;
                }
                catch (Exception exception) {
                    object3 = zzea2.zzx.zzat().zzh();
                    objectArray2 = "Failed to retrieve Firebase Instance Id";
                    ((zzeg)object3).zza((String)objectArray2);
                }
            }
            object2 = null;
        }
        object3 = zzea2.zzx;
        long l16 = object3.zzd().zzh.zza();
        objectArray2 = l16;
        l12 = objectArray2.longValue();
        long l17 = 0L;
        n10 = l12 == l17 ? 0 : (l12 < l17 ? -1 : 1);
        if (n10 == 0) {
            l13 = ((zzfl)object3).zzc;
        } else {
            l12 = ((zzfl)object3).zzc;
            l13 = objectArray2.longValue();
            l13 = Math.min(l12, l13);
        }
        long l18 = l13;
        this.zzb();
        n10 = zzea2.zzi;
        boolean bl5 = zzea2.zzx.zzc().zzs();
        object3 = zzea2.zzx.zzd();
        ((zzge)object3).zzg();
        object3 = ((zzex)object3).zzd();
        objectArray2 = "deferred_analytics_collection";
        boolean bl6 = object3.getBoolean((String)objectArray2, false);
        this.zzb();
        objectArray = zzea2.zzk;
        object4 = zzea2.zzx.zzc();
        object3 = "google_analytics_default_allow_ad_personalization_signals";
        object4 = ((zzae)object4).zzp((String)object3);
        if (object4 == null) {
            object = null;
        } else {
            bl4 = (Boolean)object4;
            bl3 = true;
            object = object4 = Boolean.valueOf(bl4 ^= bl3);
        }
        l13 = zzea2.zzg;
        object4 = zzea2.zzh;
        zzmg.zzb();
        Object object6 = object4;
        object4 = zzea2.zzx.zzc();
        long l19 = l13;
        object3 = zzdw.zzah;
        n11 = 0;
        objectArray2 = null;
        bl4 = ((zzae)object4).zzn(null, (zzdv)object3);
        Object object7 = bl4 ? (object4 = this.zzl()) : null;
        zzlc.zzb();
        object4 = zzea2.zzx.zzc();
        object3 = zzdw.zzaw;
        bl4 = ((zzae)object4).zzn(null, (zzdv)object3);
        object4 = bl4 ? zzea2.zzx.zzd().zzi().zzd() : "";
        Object object8 = object4;
        Object object9 = object6;
        object4 = zzp2;
        l12 = l10;
        String string7 = string2;
        object6 = object2;
        boolean bl7 = bl5;
        bl5 = bl6;
        return new zzp(string6, string5, string4, l14, string3, 39000L, l10, string2, (boolean)l11, bl2, (String)object2, 0L, l18, n10, bl7, bl6, (String)objectArray, (Boolean)object, l19, (List)object9, (String)object7, (String)object8);
    }

    public final String zzi() {
        this.zzb();
        Preconditions.checkNotNull(this.zza);
        return this.zza;
    }

    public final String zzj() {
        this.zzb();
        Preconditions.checkNotNull(this.zzj);
        return this.zzj;
    }

    public final String zzk() {
        this.zzb();
        return this.zzk;
    }

    public final String zzl() {
        this.zzb();
        Preconditions.checkNotNull(this.zzl);
        return this.zzl;
    }

    public final int zzm() {
        this.zzb();
        return this.zzc;
    }

    public final int zzn() {
        this.zzb();
        return this.zzi;
    }

    public final List zzo() {
        return this.zzh;
    }
}

