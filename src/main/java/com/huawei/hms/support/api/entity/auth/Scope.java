/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.huawei.hms.support.api.entity.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.entity.auth.Scope$a;

public class Scope
implements IMessageEntity,
Parcelable {
    public static final Parcelable.Creator CREATOR;
    private String mScopeUri;

    static {
        Scope$a scope$a = new Scope$a();
        CREATOR = scope$a;
    }

    public Scope() {
        this.mScopeUri = null;
    }

    public Scope(Parcel object) {
        object = object.readString();
        this.mScopeUri = object;
    }

    public Scope(String string2) {
        this.mScopeUri = string2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        boolean bl2 = object instanceof Scope;
        if (!bl2) {
            return false;
        }
        object = (Scope)object;
        String string2 = this.mScopeUri;
        object = ((Scope)object).mScopeUri;
        return Objects.equal(string2, object);
    }

    public boolean equeals(Object object) {
        return this.equals(object);
    }

    public String getScopeUri() {
        return this.mScopeUri;
    }

    public final int hashCode() {
        String string2 = this.mScopeUri;
        int n10 = string2 == null ? super.hashCode() : string2.hashCode();
        return n10;
    }

    public final String toString() {
        return this.mScopeUri;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        String string2 = this.mScopeUri;
        parcel.writeString(string2);
    }
}

