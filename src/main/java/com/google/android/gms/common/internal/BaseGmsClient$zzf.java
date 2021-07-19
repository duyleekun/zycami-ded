/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.RemoteException
 *  android.util.Log
 */
package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.BaseGmsClient$BaseConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient$BaseOnConnectionFailedListener;
import com.google.android.gms.common.internal.BaseGmsClient$zza;

public final class BaseGmsClient$zzf
extends BaseGmsClient$zza {
    private final IBinder zza;
    private final /* synthetic */ BaseGmsClient zzb;

    public BaseGmsClient$zzf(BaseGmsClient baseGmsClient, int n10, IBinder iBinder, Bundle bundle) {
        this.zzb = baseGmsClient;
        super(baseGmsClient, n10, bundle);
        this.zza = iBinder;
    }

    public final void zza(ConnectionResult connectionResult) {
        BaseGmsClient$BaseOnConnectionFailedListener baseGmsClient$BaseOnConnectionFailedListener = BaseGmsClient.zzg(this.zzb);
        if (baseGmsClient$BaseOnConnectionFailedListener != null) {
            baseGmsClient$BaseOnConnectionFailedListener = BaseGmsClient.zzg(this.zzb);
            baseGmsClient$BaseOnConnectionFailedListener.onConnectionFailed(connectionResult);
        }
        this.zzb.onConnectionFailed(connectionResult);
    }

    public final boolean zza() {
        boolean bl2;
        int n10;
        boolean bl3;
        int n11;
        Object object;
        BaseGmsClient$BaseConnectionCallbacks baseGmsClient$BaseConnectionCallbacks;
        Object object2;
        block5: {
            object2 = "GmsClient";
            baseGmsClient$BaseConnectionCallbacks = null;
            try {
                object = this.zza;
            }
            catch (RemoteException remoteException) {
                Log.w((String)object2, (String)"service probably died");
                return false;
            }
            object = object.getInterfaceDescriptor();
            String string2 = this.zzb.getServiceDescriptor();
            n11 = string2.equals(object);
            if (n11 != 0) break block5;
            string2 = this.zzb.getServiceDescriptor();
            int n12 = String.valueOf(string2).length() + 34;
            int n13 = String.valueOf(object).length();
            StringBuilder stringBuilder = new StringBuilder(n12 += n13);
            stringBuilder.append("service descriptor mismatch: ");
            stringBuilder.append(string2);
            stringBuilder.append(" vs. ");
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            Log.e((String)object2, (String)object);
            return false;
        }
        object2 = this.zzb;
        object = this.zza;
        if ((object2 = ((BaseGmsClient)object2).createServiceInterface((IBinder)object)) != null && ((bl3 = BaseGmsClient.zza((BaseGmsClient)(object = this.zzb), n11 = 2, n10 = 4, (IInterface)object2)) || (bl2 = BaseGmsClient.zza((BaseGmsClient)(object = this.zzb), n11 = 3, n10, (IInterface)object2)))) {
            BaseGmsClient.zza(this.zzb, null);
            object2 = this.zzb.getConnectionHint();
            baseGmsClient$BaseConnectionCallbacks = BaseGmsClient.zze(this.zzb);
            if (baseGmsClient$BaseConnectionCallbacks != null) {
                baseGmsClient$BaseConnectionCallbacks = BaseGmsClient.zze(this.zzb);
                baseGmsClient$BaseConnectionCallbacks.onConnected((Bundle)object2);
            }
            return true;
        }
        return false;
    }
}

