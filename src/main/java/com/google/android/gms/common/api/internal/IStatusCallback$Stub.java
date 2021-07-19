/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 */
package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.api.internal.IStatusCallback$Stub$zaa;
import com.google.android.gms.internal.base.zab;
import com.google.android.gms.internal.base.zac;

public abstract class IStatusCallback$Stub
extends zab
implements IStatusCallback {
    public IStatusCallback$Stub() {
        super("com.google.android.gms.common.api.internal.IStatusCallback");
    }

    public static IStatusCallback asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.common.api.internal.IStatusCallback");
        boolean bl2 = iInterface instanceof IStatusCallback;
        if (bl2) {
            return (IStatusCallback)iInterface;
        }
        iInterface = new IStatusCallback$Stub$zaa(iBinder);
        return iInterface;
    }

    public boolean dispatchTransaction(int n10, Parcel parcel, Parcel parcel2, int n11) {
        int n12 = 1;
        if (n10 == n12) {
            Object object = Status.CREATOR;
            object = (Status)zac.zaa(parcel, object);
            this.onResult((Status)object);
            return n12;
        }
        return false;
    }
}

