/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 */
package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.internal.common.zza;

public abstract class zzp
extends zza
implements zzq {
    public static zzq zza(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
        boolean bl2 = iInterface instanceof zzq;
        if (bl2) {
            return (zzq)iInterface;
        }
        iInterface = new zzr(iBinder);
        return iInterface;
    }
}

