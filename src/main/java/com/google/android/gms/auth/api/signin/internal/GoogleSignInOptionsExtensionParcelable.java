/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension;
import com.google.android.gms.auth.api.signin.internal.zaa;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public class GoogleSignInOptionsExtensionParcelable
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private Bundle mBundle;
    private int mType;
    private final int versionCode;

    static {
        zaa zaa2 = new zaa();
        CREATOR = zaa2;
    }

    public GoogleSignInOptionsExtensionParcelable(int n10, int n11, Bundle bundle) {
        this.versionCode = n10;
        this.mType = n11;
        this.mBundle = bundle;
    }

    public GoogleSignInOptionsExtensionParcelable(GoogleSignInOptionsExtension googleSignInOptionsExtension) {
        int n10 = googleSignInOptionsExtension.getExtensionType();
        googleSignInOptionsExtension = googleSignInOptionsExtension.toBundle();
        this(1, n10, (Bundle)googleSignInOptionsExtension);
    }

    public int getType() {
        return this.mType;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        n10 = SafeParcelWriter.beginObjectHeader(parcel);
        int n11 = this.versionCode;
        SafeParcelWriter.writeInt(parcel, 1, n11);
        n11 = this.getType();
        SafeParcelWriter.writeInt(parcel, 2, n11);
        Bundle bundle = this.mBundle;
        SafeParcelWriter.writeBundle(parcel, 3, bundle, false);
        SafeParcelWriter.finishObjectHeader(parcel, n10);
    }
}

