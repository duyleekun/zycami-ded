/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.os.Handler$Callback
 *  android.os.Message
 *  android.util.Log
 */
package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.internal.GmsClientSupervisor$zza;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzh;
import java.util.HashMap;

public final class zzg
implements Handler.Callback {
    private final /* synthetic */ zzf zza;

    private zzg(zzf zzf2) {
        this.zza = zzf2;
    }

    public /* synthetic */ zzg(zzf zzf2, zze zze2) {
        this(zzf2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean handleMessage(Message object) {
        boolean bl2 = ((Message)object).what;
        boolean bl3 = true;
        if (bl2) {
            if (bl2 != bl3) {
                return false;
            }
            HashMap hashMap = zzf.zza(this.zza);
            synchronized (hashMap) {
                int n10;
                int n11;
                object = ((Message)object).obj;
                object = (GmsClientSupervisor$zza)object;
                Object object2 = this.zza;
                object2 = zzf.zza((zzf)object2);
                object2 = ((HashMap)object2).get(object);
                object2 = (zzh)object2;
                if (object2 != null && (n11 = ((zzh)object2).zzb()) == (n10 = 3)) {
                    String string2 = "GmsClientSupervisor";
                    String string3 = String.valueOf(object);
                    Object object3 = String.valueOf(string3);
                    int n12 = ((String)object3).length() + 47;
                    StringBuilder stringBuilder = new StringBuilder(n12);
                    object3 = "Timeout waiting for ServiceConnection callback ";
                    stringBuilder.append((String)object3);
                    stringBuilder.append(string3);
                    string3 = stringBuilder.toString();
                    object3 = new Exception();
                    Log.e((String)string2, (String)string3, (Throwable)object3);
                    string2 = ((zzh)object2).zze();
                    if (string2 == null) {
                        string2 = ((GmsClientSupervisor$zza)object).zzb();
                    }
                    if (string2 == null) {
                        object = ((GmsClientSupervisor$zza)object).zza();
                        object = Preconditions.checkNotNull(object);
                        object = (String)object;
                        string3 = "unknown";
                        string2 = new ComponentName((String)object, string3);
                    }
                    ((zzh)object2).onServiceDisconnected((ComponentName)string2);
                }
                return bl3;
            }
        }
        HashMap hashMap = zzf.zza(this.zza);
        synchronized (hashMap) {
            boolean bl4;
            object = ((Message)object).obj;
            object = (GmsClientSupervisor$zza)object;
            Object object4 = this.zza;
            object4 = zzf.zza((zzf)object4);
            object4 = ((HashMap)object4).get(object);
            object4 = (zzh)object4;
            if (object4 != null && (bl4 = ((zzh)object4).zzc())) {
                bl4 = ((zzh)object4).zza();
                if (bl4) {
                    String string4 = "GmsClientSupervisor";
                    ((zzh)object4).zzb(string4);
                }
                object4 = this.zza;
                object4 = zzf.zza((zzf)object4);
                ((HashMap)object4).remove(object);
            }
            return bl3;
        }
    }
}

