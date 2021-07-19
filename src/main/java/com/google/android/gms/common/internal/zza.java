/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.BinderWrapper;

public final class zza
implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        BinderWrapper binderWrapper = new BinderWrapper(parcel, null);
        return binderWrapper;
    }

    public final /* synthetic */ Object[] newArray(int n10) {
        return new BinderWrapper[n10];
    }
}

