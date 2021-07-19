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
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.internal.ICancelToken$Stub$zza;
import com.google.android.gms.internal.common.zza;

public abstract class ICancelToken$Stub
extends zza
implements ICancelToken {
    public ICancelToken$Stub() {
        super("com.google.android.gms.common.internal.ICancelToken");
    }

    public static ICancelToken asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICancelToken");
        boolean bl2 = iInterface instanceof ICancelToken;
        if (bl2) {
            return (ICancelToken)iInterface;
        }
        iInterface = new ICancelToken$Stub$zza(iBinder);
        return iInterface;
    }
}

