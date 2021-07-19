/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 */
package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ISignInButtonCreator;
import com.google.android.gms.common.internal.SignInButtonConfig;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper$Stub;
import com.google.android.gms.internal.base.zaa;
import com.google.android.gms.internal.base.zac;

public final class zah
extends zaa
implements ISignInButtonCreator {
    public zah(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ISignInButtonCreator");
    }

    public final IObjectWrapper newSignInButton(IObjectWrapper iObjectWrapper, int n10, int n11) {
        Parcel parcel = this.zaa();
        zac.zaa(parcel, iObjectWrapper);
        parcel.writeInt(n10);
        parcel.writeInt(n11);
        iObjectWrapper = this.zaa(1, parcel);
        IObjectWrapper iObjectWrapper2 = IObjectWrapper$Stub.asInterface(iObjectWrapper.readStrongBinder());
        iObjectWrapper.recycle();
        return iObjectWrapper2;
    }

    public final IObjectWrapper newSignInButtonFromConfig(IObjectWrapper iObjectWrapper, SignInButtonConfig object) {
        Parcel parcel = this.zaa();
        zac.zaa(parcel, iObjectWrapper);
        zac.zaa(parcel, (Parcelable)object);
        iObjectWrapper = this.zaa(2, parcel);
        object = IObjectWrapper$Stub.asInterface(iObjectWrapper.readStrongBinder());
        iObjectWrapper.recycle();
        return object;
    }
}

