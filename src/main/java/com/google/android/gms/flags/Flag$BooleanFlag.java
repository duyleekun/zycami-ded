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

public class Flag$BooleanFlag
extends Flag {
    public Flag$BooleanFlag(int n10, String string2, Boolean bl2) {
        super(n10, string2, bl2, null);
    }

    private final Boolean zzb(zzc zzc2) {
        String string2;
        try {
            string2 = this.getKey();
        }
        catch (RemoteException remoteException) {
            return (Boolean)this.zzb();
        }
        Object object = this.zzb();
        object = (Boolean)object;
        boolean bl2 = (Boolean)object;
        int n10 = this.getSource();
        boolean bl3 = zzc2.getBooleanFlagValue(string2, bl2, n10);
        return bl3;
    }

    public final /* synthetic */ Object zza(zzc zzc2) {
        return this.zzb(zzc2);
    }
}

