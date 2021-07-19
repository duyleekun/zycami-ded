/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.os.Looper
 *  android.os.Message
 *  android.util.Log
 */
package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.BaseGmsClient$zzc;
import com.google.android.gms.internal.common.zzi;
import java.util.concurrent.atomic.AtomicInteger;

public final class BaseGmsClient$zzb
extends zzi {
    private final /* synthetic */ BaseGmsClient zza;

    public BaseGmsClient$zzb(BaseGmsClient baseGmsClient, Looper looper) {
        this.zza = baseGmsClient;
        super(looper);
    }

    private static void zza(Message object) {
        object = (BaseGmsClient$zzc)((Message)object).obj;
        ((BaseGmsClient$zzc)object).zzb();
        ((BaseGmsClient$zzc)object).zzd();
    }

    private static boolean zzb(Message message) {
        int n10 = message.what;
        int n11 = 1;
        int n12 = 2;
        if (n10 != n12 && n10 != n11 && n10 != (n12 = 7)) {
            return false;
        }
        return n11 != 0;
    }

    public final void handleMessage(Message object) {
        int n10;
        int n11;
        Object object2 = this.zza.zzc;
        int n12 = ((AtomicInteger)object2).get();
        if (n12 != (n11 = object.arg1)) {
            n12 = (int)(BaseGmsClient$zzb.zzb(object) ? 1 : 0);
            if (n12 != 0) {
                BaseGmsClient$zzb.zza(object);
            }
            return;
        }
        n12 = object.what;
        n11 = 4;
        int n13 = 1;
        int n14 = 5;
        if ((n12 == n13 || n12 == (n10 = 7) || n12 == n11 && (n12 = (int)(((BaseGmsClient)(object2 = this.zza)).enableLocalFallback() ? 1 : 0)) == 0 || (n12 = object.what) == n14) && (n12 = (int)(((BaseGmsClient)(object2 = this.zza)).isConnecting() ? 1 : 0)) == 0) {
            BaseGmsClient$zzb.zza(object);
            return;
        }
        n12 = object.what;
        n10 = 8;
        int n15 = 3;
        Object object3 = null;
        if (n12 == n11) {
            object2 = this.zza;
            int n16 = object.arg2;
            ConnectionResult connectionResult = new ConnectionResult(n16);
            BaseGmsClient.zza((BaseGmsClient)object2, connectionResult);
            object = this.zza;
            n16 = (int)(BaseGmsClient.zzb((BaseGmsClient)object) ? 1 : 0);
            if (n16 != 0 && (n16 = (int)(BaseGmsClient.zzc((BaseGmsClient)(object = this.zza)) ? 1 : 0)) == 0) {
                BaseGmsClient.zza(this.zza, n15, null);
                return;
            }
            object = BaseGmsClient.zzd(this.zza);
            object = object != null ? BaseGmsClient.zzd(this.zza) : new ConnectionResult(n10);
            this.zza.zzb.onReportServiceBinding((ConnectionResult)object);
            this.zza.onConnectionFailed((ConnectionResult)object);
            return;
        }
        if (n12 == n14) {
            object = BaseGmsClient.zzd(this.zza);
            object = object != null ? BaseGmsClient.zzd(this.zza) : new ConnectionResult(n10);
            this.zza.zzb.onReportServiceBinding((ConnectionResult)object);
            this.zza.onConnectionFailed((ConnectionResult)object);
            return;
        }
        if (n12 == n15) {
            object2 = object.obj;
            n11 = object2 instanceof PendingIntent;
            if (n11 != 0) {
                object3 = object2;
                object3 = (PendingIntent)object2;
            }
            int n17 = object.arg2;
            object2 = new ConnectionResult(n17, (PendingIntent)object3);
            this.zza.zzb.onReportServiceBinding((ConnectionResult)object2);
            this.zza.onConnectionFailed((ConnectionResult)object2);
            return;
        }
        n11 = 6;
        if (n12 == n11) {
            BaseGmsClient.zza(this.zza, n14, null);
            object2 = BaseGmsClient.zze(this.zza);
            if (object2 != null) {
                object2 = BaseGmsClient.zze(this.zza);
                n11 = object.arg2;
                object2.onConnectionSuspended(n11);
            }
            object2 = this.zza;
            int n18 = object.arg2;
            ((BaseGmsClient)object2).onConnectionSuspended(n18);
            BaseGmsClient.zza(this.zza, n14, n13, null);
            return;
        }
        n11 = 2;
        if (n12 == n11 && (n12 = (int)(((BaseGmsClient)(object2 = this.zza)).isConnected() ? 1 : 0)) == 0) {
            BaseGmsClient$zzb.zza(object);
            return;
        }
        n12 = (int)(BaseGmsClient$zzb.zzb(object) ? 1 : 0);
        if (n12 != 0) {
            ((BaseGmsClient$zzc)object.obj).zzc();
            return;
        }
        int n19 = object.what;
        StringBuilder stringBuilder = new StringBuilder(45);
        stringBuilder.append("Don't know how to handle message: ");
        stringBuilder.append(n19);
        object = stringBuilder.toString();
        object2 = new Exception();
        Log.wtf((String)"GmsClient", (String)object, (Throwable)object2);
    }
}

