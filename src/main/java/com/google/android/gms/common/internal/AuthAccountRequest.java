/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.AccountAccessor;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.IAccountAccessor$Stub;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.zaa;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AuthAccountRequest
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final int zalf;
    private final IBinder zanx;
    private final Scope[] zany;
    private Integer zanz;
    private Integer zaoa;
    private Account zax;

    static {
        zaa zaa2 = new zaa();
        CREATOR = zaa2;
    }

    public AuthAccountRequest(int n10, IBinder iBinder, Scope[] scopeArray, Integer n11, Integer n12, Account account) {
        this.zalf = n10;
        this.zanx = iBinder;
        this.zany = scopeArray;
        this.zanz = n11;
        this.zaoa = n12;
        this.zax = account;
    }

    public AuthAccountRequest(Account object, Set scopeArray) {
        Object object2 = new Scope[scopeArray.size()];
        Scope[] scopeArray2 = scopeArray = scopeArray.toArray((T[])object2);
        scopeArray2 = scopeArray;
        Object object3 = object = Preconditions.checkNotNull(object);
        object3 = object;
        object2 = this;
        this(3, null, scopeArray2, null, null, (Account)object3);
    }

    public AuthAccountRequest(IAccountAccessor scopeArray, Set set) {
        IBinder iBinder = scopeArray.asBinder();
        scopeArray = new Scope[set.size()];
        Scope[] scopeArray2 = scopeArray = set.toArray(scopeArray);
        scopeArray2 = scopeArray;
        this(3, iBinder, scopeArray2, null, null, null);
    }

    public Account getAccount() {
        Object object = this.zax;
        if (object == null) {
            object = this.zanx;
            object = object != null ? AccountAccessor.getAccountBinderSafe(IAccountAccessor$Stub.asInterface((IBinder)object)) : null;
        }
        return object;
    }

    public Integer getOauthPolicy() {
        return this.zanz;
    }

    public Integer getPolicyAction() {
        return this.zaoa;
    }

    public Set getScopes() {
        List<Scope> list = Arrays.asList(this.zany);
        HashSet<Scope> hashSet = new HashSet<Scope>(list);
        return hashSet;
    }

    public AuthAccountRequest setOauthPolicy(Integer n10) {
        this.zanz = n10;
        return this;
    }

    public AuthAccountRequest setPolicyAction(Integer n10) {
        this.zaoa = n10;
        return this;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        int n11 = SafeParcelWriter.beginObjectHeader(parcel);
        int n12 = this.zalf;
        SafeParcelWriter.writeInt(parcel, 1, n12);
        Account account = this.zanx;
        SafeParcelWriter.writeIBinder(parcel, 2, (IBinder)account, false);
        account = this.zany;
        SafeParcelWriter.writeTypedArray(parcel, 3, (Parcelable[])account, n10, false);
        account = this.zanz;
        SafeParcelWriter.writeIntegerObject(parcel, 4, (Integer)account, false);
        account = this.zaoa;
        SafeParcelWriter.writeIntegerObject(parcel, 5, (Integer)account, false);
        account = this.zax;
        SafeParcelWriter.writeParcelable(parcel, 6, (Parcelable)account, n10, false);
        SafeParcelWriter.finishObjectHeader(parcel, n11);
    }
}

