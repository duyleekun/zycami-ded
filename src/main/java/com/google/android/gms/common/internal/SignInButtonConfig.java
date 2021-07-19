/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.zao;

public class SignInButtonConfig
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final int zalf;
    private final Scope[] zany;
    private final int zapd;
    private final int zape;

    static {
        zao zao2 = new zao();
        CREATOR = zao2;
    }

    public SignInButtonConfig(int n10, int n11, int n12, Scope[] scopeArray) {
        this.zalf = n10;
        this.zapd = n11;
        this.zape = n12;
        this.zany = scopeArray;
    }

    public SignInButtonConfig(int n10, int n11, Scope[] scopeArray) {
        this(1, n10, n11, null);
    }

    public int getButtonSize() {
        return this.zapd;
    }

    public int getColorScheme() {
        return this.zape;
    }

    public Scope[] getScopes() {
        return this.zany;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        int n11 = SafeParcelWriter.beginObjectHeader(parcel);
        int n12 = this.zalf;
        SafeParcelWriter.writeInt(parcel, 1, n12);
        n12 = this.getButtonSize();
        SafeParcelWriter.writeInt(parcel, 2, n12);
        n12 = this.getColorScheme();
        SafeParcelWriter.writeInt(parcel, 3, n12);
        Parcelable[] parcelableArray = this.getScopes();
        SafeParcelWriter.writeTypedArray(parcel, 4, parcelableArray, n10, false);
        SafeParcelWriter.finishObjectHeader(parcel, n11);
    }
}

