/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 */
package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.IResolveAccountCallbacks;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.internal.base.zaa;
import com.google.android.gms.internal.base.zac;

public class IResolveAccountCallbacks$Stub$Proxy
extends zaa
implements IResolveAccountCallbacks {
    public IResolveAccountCallbacks$Stub$Proxy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IResolveAccountCallbacks");
    }

    public void onAccountResolutionComplete(ResolveAccountResponse resolveAccountResponse) {
        Parcel parcel = this.zaa();
        zac.zaa(parcel, resolveAccountResponse);
        this.zab(2, parcel);
    }
}

