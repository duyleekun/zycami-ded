/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 */
package com.google.android.gms.flags;

import android.os.RemoteException;
import com.google.android.gms.flags.Flag;
import com.google.android.gms.flags.zzc;

public class Flag$StringFlag
extends Flag {
    public Flag$StringFlag(int n10, String string2, String string3) {
        super(n10, string2, string3, null);
    }

    private final String zze(zzc zzc2) {
        String string2;
        try {
            string2 = this.getKey();
        }
        catch (RemoteException remoteException) {
            return (String)this.zzb();
        }
        Object object = this.zzb();
        object = (String)object;
        int n10 = this.getSource();
        return zzc2.getStringFlagValue(string2, (String)object, n10);
    }

    public final /* synthetic */ Object zza(zzc zzc2) {
        return this.zze(zzc2);
    }
}

