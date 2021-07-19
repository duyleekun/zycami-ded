/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.RemoteException
 */
package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzs;
import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzei;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzge;
import com.google.android.gms.measurement.internal.zzjb;
import com.google.android.gms.measurement.internal.zzkg;
import com.google.android.gms.measurement.internal.zzkk;
import com.google.android.gms.measurement.internal.zzp;

public final class zzic
implements Runnable {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzp zzc;
    public final /* synthetic */ boolean zzd;
    public final /* synthetic */ zzs zze;
    public final /* synthetic */ zzjb zzf;

    public zzic(zzjb zzjb2, String string2, String string3, zzp zzp2, boolean bl2, zzs zzs2) {
        this.zzf = zzjb2;
        this.zza = string2;
        this.zzb = string3;
        this.zzc = zzp2;
        this.zzd = bl2;
        this.zze = zzs2;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void run() {
        void var2_7;
        Object object;
        Object object2;
        block14: {
            void var3_14;
            Object object3;
            Object object4;
            block13: {
                Bundle bundle;
                block12: {
                    boolean bl2;
                    object2 = new Bundle();
                    object4 = this.zzf;
                    object4 = zzjb.zzM((zzjb)object4);
                    if (object4 == null) {
                        object4 = this.zzf;
                        object4 = ((zzge)object4).zzx;
                        object4 = ((zzfl)object4).zzat();
                        object4 = ((zzei)object4).zzb();
                        String string2 = "Failed to get user properties; not connected to service";
                        String string3 = this.zza;
                        String string4 = this.zzb;
                        ((zzeg)object4).zzc(string2, string3, string4);
                        object4 = this.zzf.zzx.zzl();
                        zzs zzs2 = this.zze;
                        ((zzkk)object4).zzai(zzs2, (Bundle)object2);
                        return;
                    }
                    zzp zzp2 = this.zzc;
                    Preconditions.checkNotNull(zzp2);
                    String string5 = this.zza;
                    object = this.zzb;
                    boolean bl3 = this.zzd;
                    zzp zzp3 = this.zzc;
                    object4 = object4.zzo(string5, (String)object, bl3, zzp3);
                    bundle = new Bundle();
                    if (object4 == null) break block12;
                    object4 = object4.iterator();
                    while (bl2 = object4.hasNext()) {
                        object = object4.next();
                        object = (zzkg)object;
                        object3 = ((zzkg)object).zze;
                        if (object3 != null) {
                            object = ((zzkg)object).zzb;
                            bundle.putString((String)object, (String)object3);
                            continue;
                        }
                        object3 = ((zzkg)object).zzd;
                        if (object3 != null) {
                            object = ((zzkg)object).zzb;
                            long l10 = (Long)object3;
                            bundle.putLong((String)object, l10);
                            continue;
                        }
                        object3 = ((zzkg)object).zzg;
                        if (object3 == null) continue;
                        object = ((zzkg)object).zzb;
                        double d10 = (Double)object3;
                        bundle.putDouble((String)object, d10);
                    }
                }
                try {
                    object2 = this.zzf;
                    zzjb.zzN((zzjb)object2);
                    object2 = this.zzf.zzx.zzl();
                    object4 = this.zze;
                    ((zzkk)object2).zzai((zzs)object4, bundle);
                    return;
                }
                catch (RemoteException remoteException) {
                    break block13;
                }
                catch (Throwable throwable) {
                    break block14;
                }
                catch (RemoteException remoteException) {
                    Bundle bundle2 = object2;
                    object2 = remoteException;
                }
            }
            try {
                object4 = this.zzf;
                object4 = ((zzge)object4).zzx;
                object4 = ((zzfl)object4).zzat();
                object4 = ((zzei)object4).zzb();
                object = "Failed to get user properties; remote exception";
                object3 = this.zza;
                ((zzeg)object4).zzc((String)object, object3, object2);
                object2 = this.zzf.zzx.zzl();
                object4 = this.zze;
                ((zzkk)object2).zzai((zzs)object4, (Bundle)var3_14);
                return;
            }
            catch (Throwable throwable) {
                object2 = var3_14;
            }
        }
        zzkk zzkk2 = this.zzf.zzx.zzl();
        object = this.zze;
        zzkk2.zzai((zzs)object, (Bundle)object2);
        throw var2_7;
    }
}

