/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.os.Bundle
 */
package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzfi;
import com.google.android.gms.measurement.internal.zzgz;
import com.google.android.gms.measurement.internal.zzhl;
import com.google.android.gms.measurement.internal.zzhn;
import com.google.android.gms.measurement.internal.zzji;
import com.google.android.gms.measurement.internal.zzjj;
import com.google.android.gms.measurement.internal.zzjq;

public final class zzhm
implements Application.ActivityLifecycleCallbacks {
    public final /* synthetic */ zzhn zza;

    public /* synthetic */ zzhm(zzhn zzhn2, zzgz zzgz2) {
        this.zza = zzhn2;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void onActivityCreated(Activity var1_1, Bundle var2_2) {
        block10: {
            var3_3 = this.zza;
            var3_3 = var3_3.zzx;
            var3_3 = var3_3.zzat();
            var3_3 = var3_3.zzk();
            var4_6 = "onActivityCreated";
            var3_3.zza((String)var4_6);
            var3_3 = var1_1.getIntent();
            if (var3_3 == null) {
                var3_3 = this.zza.zzx;
            }
            ** GOTO lbl-1000
            {
                catch (Throwable var3_4) {
                    break block10;
                }
                catch (Exception var3_5) {}
                {
                    var4_6 = this.zza;
                    var4_6 = var4_6.zzx;
                    var4_6 = var4_6.zzat();
                    var4_6 = var4_6.zzb();
                    var7_10 = "Throwable caught in onActivityCreated";
                    var4_6.zzb(var7_10, var3_5);
                    var3_3 = this.zza.zzx;
                }
            }
lbl23:
            // 4 sources

            while (true) {
                var3_3.zzx().zzo(var1_1, var2_2);
                return;
            }
lbl-1000:
            // 1 sources

            {
                block11: {
                    var5_7 = var3_3.getData();
                    if (var5_7 == null || !(var6_8 = var5_7.isHierarchical())) break block11;
                    var4_6 = this.zza;
                    var4_6 = var4_6.zzx;
                    var4_6.zzl();
                    var4_6 = "android.intent.extra.REFERRER_NAME";
                    var3_3 = var3_3.getStringExtra((String)var4_6);
                    var4_6 = "android-app://com.google.android.googlequicksearchbox/https/www.google.com";
                    var6_8 = var4_6.equals(var3_3);
                    var7_9 = null;
                    var8_11 = true;
                    if (!(var6_8 || (var6_8 = (var4_6 = "https://www.google.com").equals(var3_3)) || (var9_12 = (var4_6 = "android-app://com.google.appcrawler").equals(var3_3)))) {
                        var9_12 = false;
                        var3_3 = null;
                    } else {
                        var9_12 = var8_11;
                    }
                    var3_3 = var8_11 != var9_12 ? "auto" : "gs";
                    var10_13 = var3_3;
                    var3_3 = "referrer";
                    var11_14 = var5_7.getQueryParameter((String)var3_3);
                    if (var2_2 != null) {
                        var8_11 = false;
                    }
                    var3_3 = this.zza;
                    var3_3 = var3_3.zzx;
                    var3_3 = var3_3.zzau();
                    var4_6 = var12_15;
                    var7_9 = this;
                    var12_15 = new zzhl(this, var8_11, var5_7, (String)var10_13, var11_14);
                    var3_3.zzh(var12_15);
                    var3_3 = this.zza.zzx;
                    ** GOTO lbl23
                }
                var3_3 = this.zza.zzx;
                ** continue;
            }
        }
        this.zza.zzx.zzx().zzo(var1_1, var2_2);
        throw var3_4;
    }

    public final void onActivityDestroyed(Activity activity) {
        this.zza.zzx.zzx().zzt(activity);
    }

    public final void onActivityPaused(Activity object) {
        this.zza.zzx.zzx().zzr((Activity)object);
        object = this.zza.zzx.zzh();
        long l10 = object.zzx.zzax().elapsedRealtime();
        zzfi zzfi2 = object.zzx.zzau();
        zzjj zzjj2 = new zzjj((zzjq)object, l10);
        zzfi2.zzh(zzjj2);
    }

    public final void onActivityResumed(Activity activity) {
        zzjq zzjq2 = this.zza.zzx.zzh();
        long l10 = zzjq2.zzx.zzax().elapsedRealtime();
        zzfi zzfi2 = zzjq2.zzx.zzau();
        zzji zzji2 = new zzji(zzjq2, l10);
        zzfi2.zzh(zzji2);
        this.zza.zzx.zzx().zzq(activity);
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.zza.zzx.zzx().zzs(activity, bundle);
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }
}

