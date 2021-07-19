/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.ServiceConnection
 *  android.os.IBinder
 *  android.os.Message
 */
package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.IGmsServiceBroker;
import com.google.android.gms.common.internal.IGmsServiceBroker$Stub$zza;

public final class BaseGmsClient$zzd
implements ServiceConnection {
    private final int zza;
    private final /* synthetic */ BaseGmsClient zzb;

    public BaseGmsClient$zzd(BaseGmsClient baseGmsClient, int n10) {
        this.zzb = baseGmsClient;
        this.zza = n10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void onServiceConnected(ComponentName object, IBinder iBinder) {
        if (iBinder == null) {
            BaseGmsClient.zza(this.zzb, 16);
            return;
        }
        object = BaseGmsClient.zza(this.zzb);
        synchronized (object) {
            Object object2;
            BaseGmsClient baseGmsClient = this.zzb;
            if (iBinder == null) {
                object2 = null;
            } else {
                boolean bl2;
                object2 = "com.google.android.gms.common.internal.IGmsServiceBroker";
                object2 = (object2 = iBinder.queryLocalInterface((String)object2)) != null && (bl2 = object2 instanceof IGmsServiceBroker) ? (IGmsServiceBroker)object2 : new IGmsServiceBroker$Stub$zza(iBinder);
            }
            BaseGmsClient.zza(baseGmsClient, (IGmsServiceBroker)object2);
        }
        object = this.zzb;
        int n10 = this.zza;
        ((BaseGmsClient)object).zza(0, null, n10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void onServiceDisconnected(ComponentName object) {
        int n10;
        BaseGmsClient baseGmsClient;
        object = BaseGmsClient.zza(this.zzb);
        synchronized (object) {
            baseGmsClient = this.zzb;
            n10 = 0;
            BaseGmsClient.zza(baseGmsClient, null);
        }
        object = this.zzb.zza;
        n10 = this.zza;
        baseGmsClient = object.obtainMessage(6, n10, 1);
        object.sendMessage((Message)baseGmsClient);
    }
}

