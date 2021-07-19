/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.zam;

public class ResolveAccountRequest
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final int zalf;
    private final int zapa;
    private final GoogleSignInAccount zapb;
    private final Account zax;

    static {
        zam zam2 = new zam();
        CREATOR = zam2;
    }

    public ResolveAccountRequest(int n10, Account account, int n11, GoogleSignInAccount googleSignInAccount) {
        this.zalf = n10;
        this.zax = account;
        this.zapa = n11;
        this.zapb = googleSignInAccount;
    }

    public ResolveAccountRequest(Account account, int n10, GoogleSignInAccount googleSignInAccount) {
        this(2, account, n10, googleSignInAccount);
    }

    public Account getAccount() {
        return this.zax;
    }

    public int getSessionId() {
        return this.zapa;
    }

    public GoogleSignInAccount getSignInAccountHint() {
        return this.zapb;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        int n11 = SafeParcelWriter.beginObjectHeader(parcel);
        int n12 = this.zalf;
        SafeParcelWriter.writeInt(parcel, 1, n12);
        Object object = this.getAccount();
        SafeParcelWriter.writeParcelable(parcel, 2, (Parcelable)object, n10, false);
        n12 = this.getSessionId();
        SafeParcelWriter.writeInt(parcel, 3, n12);
        object = this.getSignInAccountHint();
        SafeParcelWriter.writeParcelable(parcel, 4, (Parcelable)object, n10, false);
        SafeParcelWriter.finishObjectHeader(parcel, n11);
    }
}

