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
import com.google.android.gms.common.internal.IResolveAccountCallbacks;
import com.google.android.gms.common.internal.IResolveAccountCallbacks$Stub$Proxy;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.internal.base.zab;
import com.google.android.gms.internal.base.zac;

public abstract class IResolveAccountCallbacks$Stub
extends zab
implements IResolveAccountCallbacks {
    public IResolveAccountCallbacks$Stub() {
        super("com.google.android.gms.common.internal.IResolveAccountCallbacks");
    }

    public static IResolveAccountCallbacks asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IResolveAccountCallbacks");
        boolean bl2 = iInterface instanceof IResolveAccountCallbacks;
        if (bl2) {
            return (IResolveAccountCallbacks)iInterface;
        }
        iInterface = new IResolveAccountCallbacks$Stub$Proxy(iBinder);
        return iInterface;
    }

    public boolean dispatchTransaction(int n10, Parcel parcel, Parcel parcel2, int n11) {
        n11 = 2;
        if (n10 == n11) {
            Object object = ResolveAccountResponse.CREATOR;
            object = (ResolveAccountResponse)zac.zaa(parcel, object);
            this.onAccountResolutionComplete((ResolveAccountResponse)object);
            parcel2.writeNoException();
            return true;
        }
        return false;
    }
}

