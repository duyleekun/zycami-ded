/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.ServiceConnection
 *  android.net.Uri
 *  android.os.Bundle
 */
package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.measurement.zzf;
import com.google.android.gms.internal.measurement.zzlr;
import com.google.android.gms.measurement.internal.zzae;
import com.google.android.gms.measurement.internal.zzdv;
import com.google.android.gms.measurement.internal.zzdw;
import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzei;
import com.google.android.gms.measurement.internal.zzeu;
import com.google.android.gms.measurement.internal.zzez;
import com.google.android.gms.measurement.internal.zzfa;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzge;
import com.google.android.gms.measurement.internal.zzhn;
import com.google.android.gms.measurement.internal.zzkk;

public final class zzey
implements Runnable {
    public final /* synthetic */ zzf zza;
    public final /* synthetic */ ServiceConnection zzb;
    public final /* synthetic */ zzez zzc;

    public zzey(zzez zzez2, zzf zzf2, ServiceConnection serviceConnection) {
        this.zzc = zzez2;
        this.zza = zzf2;
        this.zzb = serviceConnection;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void run() {
        ServiceConnection serviceConnection;
        zzfa zzfa2;
        Object object;
        block6: {
            Object object2;
            block8: {
                long l10;
                long l11;
                long l12;
                long l13;
                boolean bl2;
                Object object3;
                Object object4;
                block10: {
                    long l14;
                    block11: {
                        boolean bl3;
                        String string2;
                        Object object5;
                        boolean bl4;
                        long l15;
                        block9: {
                            block7: {
                                block5: {
                                    object = this.zzc;
                                    zzfa2 = ((zzez)object).zza;
                                    object = zzez.zza((zzez)object);
                                    object2 = this.zza;
                                    serviceConnection = this.zzb;
                                    ((zzge)zzfa2.zza.zzau()).zzg();
                                    object4 = new Bundle();
                                    object3 = "package_name";
                                    object4.putString((String)object3, (String)object);
                                    bl2 = false;
                                    object = null;
                                    try {
                                        object2 = object2.zzd((Bundle)object4);
                                        if (object2 != null) break block5;
                                        object2 = zzfa2.zza;
                                        object2 = ((zzfl)object2).zzat();
                                        object2 = ((zzei)object2).zzb();
                                        object4 = "Install Referrer Service returned a null response";
                                        ((zzeg)object2).zza((String)object4);
                                    }
                                    catch (Exception exception) {
                                        object4 = zzfa2.zza.zzat().zzb();
                                        object2 = exception.getMessage();
                                        object3 = "Exception occurred while retrieving the Install Referrer";
                                        ((zzeg)object4).zzb((String)object3, object2);
                                    }
                                    boolean bl5 = false;
                                    object2 = null;
                                }
                                object4 = zzfa2.zza.zzau();
                                ((zzge)object4).zzg();
                                if (object2 == null) break block6;
                                object4 = "install_begin_timestamp_seconds";
                                l13 = 0L;
                                l12 = object2.getLong((String)object4, l13);
                                l15 = 1000L;
                                long l16 = (l12 *= l15) - l13;
                                Object object6 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                                if (object6 != false) break block7;
                                object = zzfa2.zza.zzat().zze();
                                object2 = "Service response is missing Install Referrer install timestamp";
                                ((zzeg)object).zza((String)object2);
                                break block6;
                            }
                            object4 = object2.getString("install_referrer");
                            if (object4 == null || (bl4 = ((String)object4).isEmpty())) break block8;
                            zzfa2.zza.zzat().zzk().zzb("InstallReferrer API result", object4);
                            object5 = zzfa2.zza.zzl();
                            string2 = "?";
                            int n10 = ((String)object4).length();
                            object4 = n10 != 0 ? string2.concat((String)object4) : new String(string2);
                            object4 = Uri.parse((String)object4);
                            object4 = ((zzkk)object5).zzi((Uri)object4);
                            if (object4 != null) break block9;
                            object = zzfa2.zza.zzat().zzb();
                            object2 = "No campaign params defined in Install Referrer result";
                            ((zzeg)object).zza((String)object2);
                            break block6;
                        }
                        object5 = object4.getString("medium");
                        if (object5 == null || (bl3 = (string2 = "(not set)").equalsIgnoreCase((String)object5)) || (bl4 = (string2 = "organic").equalsIgnoreCase((String)object5))) break block10;
                        object5 = "referrer_click_timestamp_seconds";
                        l14 = object2.getLong((String)object5, l13) * l15;
                        long l17 = l14 - l13;
                        Object object7 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
                        if (object7 != false) break block11;
                        object = zzfa2.zza.zzat().zzb();
                        object2 = "Install Referrer is missing click timestamp for ad campaign";
                        ((zzeg)object).zza((String)object2);
                        break block6;
                    }
                    object2 = "click_timestamp";
                    object4.putLong((String)object2, l14);
                }
                if ((l11 = (l10 = l12 - (l13 = ((zzeu)(object2 = zzfa2.zza.zzd().zzi)).zza())) == 0L ? 0 : (l10 < 0L ? -1 : 1)) == false) {
                    object = zzfa2.zza.zzat().zzk();
                    object2 = "Install Referrer campaign has already been logged";
                    ((zzeg)object).zza((String)object2);
                    break block6;
                } else {
                    zzlr.zzb();
                    object2 = zzfa2.zza.zzc();
                    object3 = zzdw.zzar;
                    bl2 = ((zzae)object2).zzn(null, (zzdv)object3);
                    if (!bl2 || (bl2 = ((zzfl)(object = zzfa2.zza)).zzF())) {
                        zzfa2.zza.zzd().zzi.zzb(l12);
                        object = zzfa2.zza.zzat().zzk();
                        object3 = "referrer API";
                        ((zzeg)object).zzb("Logging Install Referrer campaign from sdk with ", object3);
                        object4.putString("_cis", (String)object3);
                        object = zzfa2.zza.zzk();
                        object2 = "auto";
                        object3 = "_cmp";
                        ((zzhn)object).zzs((String)object2, (String)object3, (Bundle)object4);
                    }
                }
                break block6;
            }
            object = zzfa2.zza.zzat().zzb();
            object2 = "No referrer defined in Install Referrer response";
            ((zzeg)object).zza((String)object2);
        }
        object = ConnectionTracker.getInstance();
        zzfa2 = zzfa2.zza.zzaw();
        ((ConnectionTracker)object).unbindService((Context)zzfa2, serviceConnection);
    }
}

