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

public class Flag$LongFlag
extends Flag {
    public Flag$LongFlag(int n10, String string2, Long l10) {
        super(n10, string2, l10, null);
    }

    private final Long zzd(zzc zzc2) {
        String string2;
        try {
            string2 = this.getKey();
        }
        catch (RemoteException remoteException) {
            return (Long)this.zzb();
        }
        Object object = this.zzb();
        object = (Long)object;
        long l10 = (Long)object;
        int n10 = this.getSource();
        long l11 = zzc2.getLongFlagValue(string2, l10, n10);
        return l11;
    }

    public final /* synthetic */ Object zza(zzc zzc2) {
        return this.zzd(zzc2);
    }
}

