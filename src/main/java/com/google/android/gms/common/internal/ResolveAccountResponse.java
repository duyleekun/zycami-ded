/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.IAccountAccessor$Stub;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.zan;

public class ResolveAccountResponse
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private ConnectionResult zadi;
    private boolean zagg;
    private final int zalf;
    private IBinder zanx;
    private boolean zapc;

    static {
        zan zan2 = new zan();
        CREATOR = zan2;
    }

    public ResolveAccountResponse(int n10) {
        ConnectionResult connectionResult = new ConnectionResult(n10, null);
        this(connectionResult);
    }

    public ResolveAccountResponse(int n10, IBinder iBinder, ConnectionResult connectionResult, boolean bl2, boolean bl3) {
        this.zalf = n10;
        this.zanx = iBinder;
        this.zadi = connectionResult;
        this.zagg = bl2;
        this.zapc = bl3;
    }

    public ResolveAccountResponse(ConnectionResult connectionResult) {
        this(1, null, connectionResult, false, false);
    }

    public boolean equals(Object object) {
        boolean bl2;
        boolean bl3 = true;
        if (this == object) {
            return bl3;
        }
        boolean bl4 = object instanceof ResolveAccountResponse;
        if (!bl4) {
            return false;
        }
        object = (ResolveAccountResponse)object;
        Object object2 = this.zadi;
        ConnectionResult connectionResult = ((ResolveAccountResponse)object).zadi;
        bl4 = ((ConnectionResult)object2).equals(connectionResult);
        if (bl4 && (bl2 = (object2 = this.getAccountAccessor()).equals(object = ((ResolveAccountResponse)object).getAccountAccessor()))) {
            return bl3;
        }
        return false;
    }

    public IAccountAccessor getAccountAccessor() {
        return IAccountAccessor$Stub.asInterface(this.zanx);
    }

    public ConnectionResult getConnectionResult() {
        return this.zadi;
    }

    public boolean getSaveDefaultAccount() {
        return this.zagg;
    }

    public boolean isFromCrossClientAuth() {
        return this.zapc;
    }

    public ResolveAccountResponse setAccountAccessor(IAccountAccessor iAccountAccessor) {
        iAccountAccessor = iAccountAccessor == null ? null : iAccountAccessor.asBinder();
        this.zanx = iAccountAccessor;
        return this;
    }

    public ResolveAccountResponse setIsFromCrossClientAuth(boolean bl2) {
        this.zapc = bl2;
        return this;
    }

    public ResolveAccountResponse setSaveDefaultAccount(boolean bl2) {
        this.zagg = bl2;
        return this;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        int n11 = SafeParcelWriter.beginObjectHeader(parcel);
        int n12 = this.zalf;
        SafeParcelWriter.writeInt(parcel, 1, n12);
        Object object = this.zanx;
        SafeParcelWriter.writeIBinder(parcel, 2, object, false);
        object = this.getConnectionResult();
        SafeParcelWriter.writeParcelable(parcel, 3, (Parcelable)object, n10, false);
        n10 = (int)(this.getSaveDefaultAccount() ? 1 : 0);
        SafeParcelWriter.writeBoolean(parcel, 4, n10 != 0);
        n10 = (int)(this.isFromCrossClientAuth() ? 1 : 0);
        SafeParcelWriter.writeBoolean(parcel, 5, n10 != 0);
        SafeParcelWriter.finishObjectHeader(parcel, n11);
    }
}

