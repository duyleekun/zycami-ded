/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 */
package com.google.android.gms.dynamic;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper$Stub$zza;
import com.google.android.gms.internal.common.zza;

public class IObjectWrapper$Stub
extends zza
implements IObjectWrapper {
    public IObjectWrapper$Stub() {
        super("com.google.android.gms.dynamic.IObjectWrapper");
    }

    public static IObjectWrapper asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
        boolean bl2 = iInterface instanceof IObjectWrapper;
        if (bl2) {
            return (IObjectWrapper)iInterface;
        }
        iInterface = new IObjectWrapper$Stub$zza(iBinder);
        return iInterface;
    }
}

