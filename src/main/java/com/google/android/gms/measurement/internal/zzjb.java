/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.SharedPreferences
 *  android.os.Bundle
 *  android.os.RemoteException
 *  android.util.Pair
 */
package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzlc;
import com.google.android.gms.internal.measurement.zzs;
import com.google.android.gms.measurement.internal.zzaa;
import com.google.android.gms.measurement.internal.zzae;
import com.google.android.gms.measurement.internal.zzal;
import com.google.android.gms.measurement.internal.zzas;
import com.google.android.gms.measurement.internal.zzdv;
import com.google.android.gms.measurement.internal.zzdw;
import com.google.android.gms.measurement.internal.zzdz;
import com.google.android.gms.measurement.internal.zzea;
import com.google.android.gms.measurement.internal.zzec;
import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzex;
import com.google.android.gms.measurement.internal.zzf;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzge;
import com.google.android.gms.measurement.internal.zzhu;
import com.google.android.gms.measurement.internal.zzic;
import com.google.android.gms.measurement.internal.zzid;
import com.google.android.gms.measurement.internal.zzie;
import com.google.android.gms.measurement.internal.zzif;
import com.google.android.gms.measurement.internal.zzig;
import com.google.android.gms.measurement.internal.zzih;
import com.google.android.gms.measurement.internal.zzii;
import com.google.android.gms.measurement.internal.zzij;
import com.google.android.gms.measurement.internal.zzik;
import com.google.android.gms.measurement.internal.zzil;
import com.google.android.gms.measurement.internal.zzim;
import com.google.android.gms.measurement.internal.zzin;
import com.google.android.gms.measurement.internal.zzio;
import com.google.android.gms.measurement.internal.zzip;
import com.google.android.gms.measurement.internal.zziq;
import com.google.android.gms.measurement.internal.zzir;
import com.google.android.gms.measurement.internal.zzis;
import com.google.android.gms.measurement.internal.zzit;
import com.google.android.gms.measurement.internal.zziu;
import com.google.android.gms.measurement.internal.zzja;
import com.google.android.gms.measurement.internal.zzjr;
import com.google.android.gms.measurement.internal.zzkg;
import com.google.android.gms.measurement.internal.zzkk;
import com.google.android.gms.measurement.internal.zzp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class zzjb
extends zzf {
    private final zzja zza;
    private zzdz zzb;
    private volatile Boolean zzc;
    private final zzal zzd;
    private final zzjr zze;
    private final List zzf;
    private final zzal zzg;

    public zzjb(zzfl zzfl2) {
        super(zzfl2);
        Object object = new ArrayList();
        this.zzf = object;
        Clock clock = zzfl2.zzax();
        this.zze = object = new zzjr(clock);
        this.zza = object = new zzja(this);
        this.zzd = object = new zzil(this, zzfl2);
        this.zzg = object = new zzin(this, zzfl2);
    }

    public static /* synthetic */ zzja zzI(zzjb zzjb2) {
        return zzjb2.zza;
    }

    public static /* synthetic */ void zzJ(zzjb zzjb2, ComponentName componentName) {
        ((zzge)zzjb2).zzg();
        Object object = zzjb2.zzb;
        if (object != null) {
            zzjb2.zzb = null;
            object = zzjb2.zzx.zzat().zzk();
            String string2 = "Disconnected from device MeasurementService";
            ((zzeg)object).zzb(string2, componentName);
            ((zzge)zzjb2).zzg();
            zzjb2.zzB();
        }
    }

    public static /* synthetic */ zzdz zzK(zzjb zzjb2, zzdz zzdz2) {
        zzjb2.zzb = null;
        return null;
    }

    public static /* synthetic */ void zzL(zzjb zzjb2) {
        zzjb2.zzR();
    }

    public static /* synthetic */ zzdz zzM(zzjb zzjb2) {
        return zzjb2.zzb;
    }

    public static /* synthetic */ void zzN(zzjb zzjb2) {
        zzjb2.zzP();
    }

    private final boolean zzO() {
        this.zzx.zzas();
        return true;
    }

    private final void zzP() {
        ((zzge)this).zzg();
        this.zze.zza();
        zzal zzal2 = this.zzd;
        this.zzx.zzc();
        long l10 = (Long)zzdw.zzI.zzb(null);
        zzal2.zzb(l10);
    }

    private final void zzQ(Runnable runnable) {
        ((zzge)this).zzg();
        int n10 = this.zzh();
        if (n10 != 0) {
            runnable.run();
            return;
        }
        List list = this.zzf;
        n10 = list.size();
        zzfl zzfl2 = this.zzx;
        zzfl2.zzc();
        long l10 = n10;
        long l11 = 1000L;
        n10 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
        if (n10 >= 0) {
            this.zzx.zzat().zzb().zza("Discarding data. Max runnable queue size reached");
            return;
        }
        this.zzf.add(runnable);
        this.zzg.zzb(60000L);
        this.zzB();
    }

    private final void zzR() {
        ((zzge)this).zzg();
        Object object = this.zzx.zzat().zzk();
        int n10 = this.zzf.size();
        Object object2 = n10;
        Object object3 = "Processing queued up service tasks";
        ((zzeg)object).zzb((String)object3, object2);
        object = this.zzf.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            object2 = (Runnable)object.next();
            try {
                object2.run();
            }
            catch (Exception exception) {
                object3 = this.zzx.zzat().zzb();
                String string2 = "Task exception while flushing queue";
                ((zzeg)object3).zzb(string2, exception);
            }
        }
        this.zzf.clear();
        this.zzg.zzd();
    }

    private final zzp zzS(boolean bl2) {
        this.zzx.zzas();
        zzea zzea2 = this.zzx.zzA();
        String string2 = null;
        if (bl2) {
            Object object = this.zzx.zzat();
            Object object2 = object.zzx.zzd().zzb;
            if (object2 != null && (object = object.zzx.zzd().zzb.zzb()) != null && object != (object2 = zzex.zza)) {
                string2 = String.valueOf(((Pair)object).second);
                object = (String)((Pair)object).first;
                object2 = String.valueOf(string2);
                int n10 = ((String)object2).length();
                String string3 = String.valueOf(object);
                int n11 = string3.length();
                n10 = n10 + 1 + n11;
                StringBuilder stringBuilder = new StringBuilder(n10);
                stringBuilder.append(string2);
                stringBuilder.append(":");
                stringBuilder.append((String)object);
                string2 = stringBuilder.toString();
            }
        }
        return zzea2.zzh(string2);
    }

    public final void zzA(Bundle bundle) {
        ((zzge)this).zzg();
        this.zzb();
        zzp zzp2 = this.zzS(false);
        zzik zzik2 = new zzik(this, zzp2, bundle);
        this.zzQ(zzik2);
    }

    public final void zzB() {
        ((zzge)this).zzg();
        this.zzb();
        boolean n10 = this.zzh();
        if (n10) {
            return;
        }
        boolean bl2 = this.zzD();
        if (!bl2) {
            Object object = this.zzx.zzc();
            boolean bl3 = ((zzae)object).zzy();
            if (!bl3) {
                int n11;
                this.zzx.zzas();
                object = this.zzx.zzaw().getPackageManager();
                Object object2 = new Intent();
                Context context = this.zzx.zzaw();
                String string2 = "com.google.android.gms.measurement.AppMeasurementService";
                object2 = object2.setClassName(context, string2);
                int n12 = 65536;
                object = object.queryIntentServices(object2, n12);
                if (object != null && (n11 = object.size()) > 0) {
                    object = new Intent("com.google.android.gms.measurement.START");
                    context = this.zzx.zzaw();
                    this.zzx.zzas();
                    object2 = new ComponentName(context, string2);
                    object.setComponent((ComponentName)object2);
                    this.zza.zza((Intent)object);
                    return;
                }
                object = this.zzx.zzat().zzb();
                object2 = "Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest";
                ((zzeg)object).zza((String)object2);
            }
            return;
        }
        this.zza.zzc();
    }

    public final Boolean zzC() {
        return this.zzc;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final boolean zzD() {
        block7: {
            int n10;
            Object object;
            block8: {
                float f10;
                int n11;
                float f11;
                int n12;
                String string2;
                block17: {
                    block9: {
                        String string3;
                        block10: {
                            Object object2;
                            block11: {
                                int n13;
                                String string4;
                                int n14;
                                block12: {
                                    block16: {
                                        block13: {
                                            block14: {
                                                block15: {
                                                    ((zzge)this).zzg();
                                                    this.zzb();
                                                    object = this.zzc;
                                                    if (object != null) break block7;
                                                    ((zzge)this).zzg();
                                                    this.zzb();
                                                    object = this.zzx.zzd();
                                                    ((zzge)object).zzg();
                                                    SharedPreferences sharedPreferences = ((zzex)object).zzd();
                                                    string2 = "use_service";
                                                    n10 = sharedPreferences.contains(string2);
                                                    n12 = 0;
                                                    f11 = 0.0f;
                                                    string3 = null;
                                                    if (n10 == 0) {
                                                        n11 = 0;
                                                        object = null;
                                                    } else {
                                                        n11 = ((zzex)object).zzd().getBoolean(string2, false);
                                                        object = n11 != 0;
                                                    }
                                                    n10 = 1;
                                                    f10 = Float.MIN_VALUE;
                                                    if (object != null && (n14 = ((Boolean)object).booleanValue()) != 0) break block8;
                                                    this.zzx.zzas();
                                                    object2 = this.zzx.zzA();
                                                    n14 = ((zzea)object2).zzn();
                                                    if (n14 == n10) break block9;
                                                    object2 = this.zzx.zzat().zzk();
                                                    string4 = "Checking service availability";
                                                    ((zzeg)object2).zza(string4);
                                                    object2 = this.zzx.zzl();
                                                    n13 = 12451000;
                                                    n14 = ((zzkk)object2).zzaa(n13);
                                                    if (n14 == 0) break block10;
                                                    if (n14 == n10) break block11;
                                                    n13 = 2;
                                                    if (n14 == n13) break block12;
                                                    n11 = 3;
                                                    if (n14 == n11) break block13;
                                                    n11 = 9;
                                                    if (n14 == n11) break block14;
                                                    n11 = 18;
                                                    if (n14 == n11) break block15;
                                                    object = this.zzx.zzat().zze();
                                                    Integer n15 = n14;
                                                    object2 = "Unexpected service status";
                                                    ((zzeg)object).zzb((String)object2, n15);
                                                    break block16;
                                                }
                                                object = this.zzx.zzat().zze();
                                                string3 = "Service updating";
                                                ((zzeg)object).zza(string3);
                                                break block9;
                                            }
                                            object = this.zzx.zzat().zze();
                                            String string5 = "Service invalid";
                                            ((zzeg)object).zza(string5);
                                            break block16;
                                        }
                                        object = this.zzx.zzat().zze();
                                        String string6 = "Service disabled";
                                        ((zzeg)object).zza(string6);
                                    }
                                    n10 = 0;
                                    Object var2_7 = null;
                                    f10 = 0.0f;
                                    break block17;
                                }
                                object2 = this.zzx.zzat().zzj();
                                string4 = "Service container out of date";
                                ((zzeg)object2).zza(string4);
                                object2 = this.zzx.zzl();
                                n14 = ((zzkk)object2).zzZ();
                                n13 = 17443;
                                if (n14 >= n13) {
                                    if (object != null) {
                                        n10 = 0;
                                        Object var2_8 = null;
                                        f10 = 0.0f;
                                    }
                                    n12 = n10;
                                    f11 = f10;
                                    n10 = 0;
                                    Object var2_10 = null;
                                    f10 = 0.0f;
                                }
                                break block17;
                            }
                            object = this.zzx.zzat().zzk();
                            object2 = "Service missing";
                            ((zzeg)object).zza((String)object2);
                            break block17;
                        }
                        object = this.zzx.zzat().zzk();
                        string3 = "Service available";
                        ((zzeg)object).zza(string3);
                    }
                    n12 = n10;
                    f11 = f10;
                }
                if (n12 == 0 && (n11 = ((zzae)(object = this.zzx.zzc())).zzy()) != 0) {
                    object = this.zzx.zzat().zzb();
                    String string7 = "No way to upload. Consider using the full version of Analytics";
                    ((zzeg)object).zza(string7);
                } else if (n10 != 0) {
                    object = this.zzx.zzd();
                    ((zzge)object).zzg();
                    object = ((zzex)object).zzd().edit();
                    object.putBoolean(string2, n12 != 0);
                    object.apply();
                }
                n10 = n12;
                f10 = f11;
            }
            this.zzc = object = Boolean.valueOf(n10 != 0);
        }
        return this.zzc;
    }

    public final void zzE(zzdz zzdz2) {
        ((zzge)this).zzg();
        Preconditions.checkNotNull(zzdz2);
        this.zzb = zzdz2;
        this.zzP();
        this.zzR();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zzF() {
        ((zzge)this).zzg();
        this.zzb();
        Object object = this.zza;
        ((zzja)object).zzb();
        try {
            object = ConnectionTracker.getInstance();
            zzfl zzfl2 = this.zzx;
            zzfl2 = zzfl2.zzaw();
            zzja zzja2 = this.zza;
            ((ConnectionTracker)object).unbindService((Context)zzfl2, zzja2);
        }
        catch (IllegalArgumentException | IllegalStateException runtimeException) {}
        this.zzb = null;
    }

    public final void zzG(zzs zzs2, zzas object, String object2) {
        ((zzge)this).zzg();
        this.zzb();
        Object object3 = this.zzx.zzl();
        int n10 = 12451000;
        int n11 = ((zzkk)object3).zzaa(n10);
        if (n11 != 0) {
            this.zzx.zzat().zze().zza("Not bundling data. Service unavailable or out of date");
            object = this.zzx.zzl();
            object2 = new byte[0];
            ((zzkk)object).zzag(zzs2, (byte[])object2);
            return;
        }
        object3 = new zzim(this, (zzas)object, (String)object2, zzs2);
        this.zzQ((Runnable)object3);
    }

    public final boolean zzH() {
        ((zzge)this).zzg();
        this.zzb();
        zzge zzge2 = this.zzx.zzc();
        zzdv zzdv2 = zzdw.zzay;
        int n10 = 0;
        Integer n11 = null;
        boolean n12 = ((zzae)zzge2).zzn(null, zzdv2);
        zzdv2 = null;
        if (!n12) {
            return false;
        }
        boolean bl2 = this.zzD();
        boolean bl3 = true;
        if (bl2) {
            zzdv zzdv3;
            zzge2 = this.zzx.zzl();
            int n13 = ((zzkk)zzge2).zzZ();
            if (n13 >= (n10 = (n11 = (Integer)(zzdv3 = zzdw.zzaz).zzb(null)).intValue())) {
                return bl3;
            }
            return false;
        }
        return bl3;
    }

    public final boolean zze() {
        return false;
    }

    public final boolean zzh() {
        ((zzge)this).zzg();
        this.zzb();
        zzdz zzdz2 = this.zzb;
        return zzdz2 != null;
    }

    public final void zzi() {
        ((zzge)this).zzg();
        this.zzb();
        zzp zzp2 = this.zzS(true);
        zzio zzio2 = new zzio(this, zzp2);
        this.zzQ(zzio2);
    }

    public final void zzj(boolean bl2) {
        zzlc.zzb();
        Object object = this.zzx.zzc();
        zzdv zzdv2 = zzdw.zzaw;
        boolean bl3 = ((zzae)object).zzn(null, zzdv2);
        if (bl3) {
            Object object2;
            ((zzge)this).zzg();
            this.zzb();
            if (bl2) {
                this.zzO();
                object2 = this.zzx.zzn();
                ((zzec)object2).zzh();
            }
            if (bl2 = this.zzH()) {
                bl2 = false;
                object2 = this.zzS(false);
                object = new zzip(this, (zzp)object2);
                this.zzQ((Runnable)object);
            }
        }
    }

    public final void zzk(zzdz zzdz2, AbstractSafeParcelable abstractSafeParcelable, zzp zzp2) {
        int n10;
        ((zzge)this).zzg();
        this.zzb();
        this.zzO();
        this.zzx.zzc();
        int n11 = 100;
        int n12 = n11;
        for (int i10 = 0; i10 < (n10 = 1001) && n12 == n11; ++i10) {
            ArrayList<AbstractSafeParcelable> arrayList = new ArrayList<AbstractSafeParcelable>();
            List list = this.zzx.zzn().zzl(n11);
            if (list != null) {
                arrayList.addAll(list);
                n10 = list.size();
            } else {
                n10 = 0;
                list = null;
            }
            if (abstractSafeParcelable != null && n10 < n11) {
                arrayList.add(abstractSafeParcelable);
            }
            int n13 = arrayList.size();
            for (int i11 = 0; i11 < n13; ++i11) {
                String string2;
                Object object;
                Object object2 = (AbstractSafeParcelable)arrayList.get(i11);
                boolean bl2 = object2 instanceof zzas;
                if (bl2) {
                    object2 = (zzas)object2;
                    try {
                        zzdz2.zzd((zzas)object2, zzp2);
                    }
                    catch (RemoteException remoteException) {
                        object = this.zzx.zzat().zzb();
                        string2 = "Failed to send event to the service";
                        ((zzeg)object).zzb(string2, (Object)remoteException);
                    }
                    continue;
                }
                bl2 = object2 instanceof zzkg;
                if (bl2) {
                    object2 = (zzkg)object2;
                    try {
                        zzdz2.zze((zzkg)object2, zzp2);
                    }
                    catch (RemoteException remoteException) {
                        object = this.zzx.zzat().zzb();
                        string2 = "Failed to send user property to the service";
                        ((zzeg)object).zzb(string2, (Object)remoteException);
                    }
                    continue;
                }
                bl2 = object2 instanceof zzaa;
                if (bl2) {
                    object2 = (zzaa)object2;
                    try {
                        zzdz2.zzm((zzaa)object2, zzp2);
                    }
                    catch (RemoteException remoteException) {
                        object = this.zzx.zzat().zzb();
                        string2 = "Failed to send conditional user property to the service";
                        ((zzeg)object).zzb(string2, (Object)remoteException);
                    }
                    continue;
                }
                object2 = this.zzx.zzat().zzb();
                object = "Discarding data. Unrecognized parcel type.";
                ((zzeg)object2).zza((String)object);
            }
            n12 = n10;
        }
    }

    public final void zzl(zzas zzas2, String string2) {
        Preconditions.checkNotNull(zzas2);
        ((zzge)this).zzg();
        this.zzb();
        this.zzO();
        boolean bl2 = this.zzx.zzn().zzi(zzas2);
        zzp zzp2 = this.zzS(true);
        zziq zziq2 = new zziq(this, true, zzp2, bl2, zzas2, string2);
        this.zzQ(zziq2);
    }

    public final void zzm(zzaa zzaa2) {
        Preconditions.checkNotNull(zzaa2);
        ((zzge)this).zzg();
        this.zzb();
        this.zzx.zzas();
        boolean bl2 = this.zzx.zzn().zzk(zzaa2);
        zzaa zzaa3 = new zzaa(zzaa2);
        zzp zzp2 = this.zzS(true);
        zzir zzir2 = new zzir(this, true, zzp2, bl2, zzaa3, zzaa2);
        this.zzQ(zzir2);
    }

    public final void zzn(AtomicReference atomicReference, String object, String string2, String string3) {
        ((zzge)this).zzg();
        this.zzb();
        zzp zzp2 = this.zzS(false);
        object = new zzis(this, atomicReference, null, string2, string3, zzp2);
        this.zzQ((Runnable)object);
    }

    public final void zzo(zzs zzs2, String string2, String string3) {
        ((zzge)this).zzg();
        this.zzb();
        zzp zzp2 = this.zzS(false);
        zzit zzit2 = new zzit(this, string2, string3, zzp2, zzs2);
        this.zzQ(zzit2);
    }

    public final void zzq(AtomicReference atomicReference, String object, String string2, String string3, boolean bl2) {
        ((zzge)this).zzg();
        this.zzb();
        zzp zzp2 = this.zzS(false);
        object = new zziu(this, atomicReference, null, string2, string3, zzp2, bl2);
        this.zzQ((Runnable)object);
    }

    public final void zzr(zzs zzs2, String string2, String string3, boolean bl2) {
        ((zzge)this).zzg();
        this.zzb();
        zzp zzp2 = this.zzS(false);
        zzic zzic2 = new zzic(this, string2, string3, zzp2, bl2, zzs2);
        this.zzQ(zzic2);
    }

    public final void zzs(zzkg zzkg2) {
        ((zzge)this).zzg();
        this.zzb();
        this.zzO();
        boolean bl2 = this.zzx.zzn().zzj(zzkg2);
        zzp zzp2 = this.zzS(true);
        zzid zzid2 = new zzid(this, zzp2, bl2, zzkg2);
        this.zzQ(zzid2);
    }

    public final void zzt(AtomicReference atomicReference, boolean bl2) {
        ((zzge)this).zzg();
        this.zzb();
        zzp zzp2 = this.zzS(false);
        zzie zzie2 = new zzie(this, atomicReference, zzp2, bl2);
        this.zzQ(zzie2);
    }

    public final void zzu() {
        ((zzge)this).zzg();
        this.zzb();
        zzp zzp2 = this.zzS(false);
        this.zzO();
        this.zzx.zzn().zzh();
        zzif zzif2 = new zzif(this, zzp2);
        this.zzQ(zzif2);
    }

    public final void zzv(AtomicReference atomicReference) {
        ((zzge)this).zzg();
        this.zzb();
        zzp zzp2 = this.zzS(false);
        zzig zzig2 = new zzig(this, atomicReference, zzp2);
        this.zzQ(zzig2);
    }

    public final void zzx(zzs zzs2) {
        ((zzge)this).zzg();
        this.zzb();
        zzp zzp2 = this.zzS(false);
        zzih zzih2 = new zzih(this, zzp2, zzs2);
        this.zzQ(zzih2);
    }

    public final void zzy() {
        ((zzge)this).zzg();
        this.zzb();
        zzp zzp2 = this.zzS(true);
        this.zzx.zzn().zzm();
        zzii zzii2 = new zzii(this, zzp2);
        this.zzQ(zzii2);
    }

    public final void zzz(zzhu zzhu2) {
        ((zzge)this).zzg();
        this.zzb();
        zzij zzij2 = new zzij(this, zzhu2);
        this.zzQ(zzij2);
    }
}

