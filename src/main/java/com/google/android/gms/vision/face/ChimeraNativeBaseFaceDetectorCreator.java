/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.RemoteException
 *  android.os.SystemClock
 */
package com.google.android.gms.vision.face;

import android.content.Context;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.vision.zzbi;
import com.google.android.gms.internal.vision.zzfl$zza;
import com.google.android.gms.internal.vision.zzfl$zzg;
import com.google.android.gms.internal.vision.zzfl$zzg$zza;
import com.google.android.gms.internal.vision.zzfl$zzg$zzb;
import com.google.android.gms.internal.vision.zzfl$zzg$zzc;
import com.google.android.gms.internal.vision.zzfl$zzg$zzd;
import com.google.android.gms.internal.vision.zzfl$zzk;
import com.google.android.gms.internal.vision.zzfl$zzk$zza;
import com.google.android.gms.internal.vision.zzfl$zzo;
import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.vision.clearcut.DynamiteClearcutLogger;
import com.google.android.gms.vision.clearcut.LogUtils;
import com.google.android.gms.vision.face.internal.client.zzf;
import com.google.android.gms.vision.face.internal.client.zzh;
import com.google.android.gms.vision.face.internal.client.zzl;

public abstract class ChimeraNativeBaseFaceDetectorCreator
extends zzl {
    private static void zza(DynamiteClearcutLogger dynamiteClearcutLogger, Context object, zzf object2, String string2, long l10) {
        Object object3;
        zzfl$zzg$zzb zzfl$zzg$zzb = zzfl$zzg.zzdm();
        int n10 = ((zzf)object2).mode;
        int n11 = 2;
        int n12 = 1;
        if (n10 == n12) {
            object3 = zzfl$zzg$zzd.zzqg;
            zzfl$zzg$zzb.zzb((zzfl$zzg$zzd)object3);
        } else if (n10 == 0) {
            object3 = zzfl$zzg$zzd.zzqh;
            zzfl$zzg$zzb.zzb((zzfl$zzg$zzd)object3);
        } else if (n10 == n11) {
            object3 = zzfl$zzg$zzd.zzqi;
            zzfl$zzg$zzb.zzb((zzfl$zzg$zzd)object3);
        }
        n10 = ((zzf)object2).landmarkType;
        if (n10 == n12) {
            object3 = zzfl$zzg$zzc.zzqc;
            zzfl$zzg$zzb.zzb((zzfl$zzg$zzc)object3);
        } else if (n10 == 0) {
            object3 = zzfl$zzg$zzc.zzqb;
            zzfl$zzg$zzb.zzb((zzfl$zzg$zzc)object3);
        } else if (n10 == n11) {
            object3 = zzfl$zzg$zzc.zzqd;
            zzfl$zzg$zzb.zzb((zzfl$zzg$zzc)object3);
        }
        n10 = ((zzf)object2).zzcw;
        if (n10 == n12) {
            object3 = zzfl$zzg$zza.zzpy;
            zzfl$zzg$zzb.zzb((zzfl$zzg$zza)object3);
        } else if (n10 == 0) {
            object3 = zzfl$zzg$zza.zzpx;
            zzfl$zzg$zzb.zzb((zzfl$zzg$zza)object3);
        }
        n10 = (int)(((zzf)object2).zzcv ? 1 : 0);
        object3 = zzfl$zzg$zzb.zzh(n10 != 0);
        n12 = ((zzf)object2).trackingEnabled;
        object3 = ((zzfl$zzg$zzb)object3).zzi(n12 != 0);
        float f10 = ((zzf)object2).proportionalMinFaceSize;
        ((zzfl$zzg$zzb)object3).zzf(f10);
        object2 = zzfl$zzk.zzdv();
        object3 = "face";
        object2 = ((zzfl$zzk$zza)object2).zzs((String)object3).zzq(l10).zza(zzfl$zzg$zzb);
        if (string2 != null) {
            ((zzfl$zzk$zza)object2).zzt(string2);
        }
        object = LogUtils.zza(object);
        ((zzfl$zzk$zza)object2).zzb((zzfl$zza)object);
        object = (zzfl$zzo)((zzid)zzfl$zzo.zzec().zza((zzfl$zzk$zza)object2).zzgw());
        dynamiteClearcutLogger.zza(n11, (zzfl$zzo)object);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public zzh newFaceDetector(IObjectWrapper object, zzf zzf2) {
        Object object2;
        DynamiteClearcutLogger dynamiteClearcutLogger;
        Object object3;
        long l10;
        block5: {
            l10 = SystemClock.elapsedRealtime();
            object3 = object = ObjectWrapper.unwrap((IObjectWrapper)object);
            object3 = (Context)object;
            zzbi.zzj((Context)object3);
            dynamiteClearcutLogger = new DynamiteClearcutLogger((Context)object3);
            object = null;
            object = this.zza((Context)object3, (Context)object3, dynamiteClearcutLogger, zzf2);
            if (object == null) {
                return object;
            }
            Object var7_6 = null;
            {
                catch (Throwable throwable) {
                    object2 = object;
                    object = throwable;
                    break block5;
                }
                catch (RemoteException remoteException) {}
                {
                    object = remoteException.getMessage();
                    throw remoteException;
                }
            }
            long l11 = SystemClock.elapsedRealtime() - l10;
            zzf zzf3 = zzf2;
            ChimeraNativeBaseFaceDetectorCreator.zza(dynamiteClearcutLogger, (Context)object3, zzf2, null, l11);
            return object;
        }
        if (object2 == null) throw object;
        long l12 = SystemClock.elapsedRealtime() - l10;
        zzf zzf4 = zzf2;
        ChimeraNativeBaseFaceDetectorCreator.zza(dynamiteClearcutLogger, (Context)object3, zzf2, (String)object2, l12);
        throw object;
    }

    public abstract zzh zza(Context var1, Context var2, DynamiteClearcutLogger var3, zzf var4);
}

