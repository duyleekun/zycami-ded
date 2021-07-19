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

public class Flag$IntegerFlag
extends Flag {
    public Flag$IntegerFlag(int n10, String string2, Integer n11) {
        super(n10, string2, n11, null);
    }

    private final Integer zzc(zzc zzc2) {
        String string2;
        try {
            string2 = this.getKey();
        }
        catch (RemoteException remoteException) {
            return (Integer)this.zzb();
        }
        Object object = this.zzb();
        object = (Integer)object;
        int n10 = (Integer)object;
        int n11 = this.getSource();
        int n12 = zzc2.getIntFlagValue(string2, n10, n11);
        return n12;
    }

    public final /* synthetic */ Object zza(zzc zzc2) {
        return this.zzc(zzc2);
    }
}

