/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 */
package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.common.internal.zzm;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzd;

public abstract class zzn
extends zza
implements zzl {
    public zzn() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    public static zzl zza(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
        boolean bl2 = iInterface instanceof zzl;
        if (bl2) {
            return (zzl)iInterface;
        }
        iInterface = new zzm(iBinder);
        return iInterface;
    }

    public final boolean zza(int n10, Parcel parcel, Parcel parcel2, int n11) {
        int n12 = 1;
        if (n10 != n12) {
            n11 = 2;
            if (n10 != n11) {
                return false;
            }
            n10 = this.zzc();
            parcel2.writeNoException();
            parcel2.writeInt(n10);
        } else {
            IObjectWrapper iObjectWrapper = this.zzb();
            parcel2.writeNoException();
            zzd.zza(parcel2, iObjectWrapper);
        }
        return n12;
    }
}

