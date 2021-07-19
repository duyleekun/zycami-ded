/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.util.SparseArray
 */
package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.material.internal.ParcelableSparseArray$1;

public class ParcelableSparseArray
extends SparseArray
implements Parcelable {
    public static final Parcelable.Creator CREATOR;

    static {
        ParcelableSparseArray$1 parcelableSparseArray$1 = new ParcelableSparseArray$1();
        CREATOR = parcelableSparseArray$1;
    }

    public ParcelableSparseArray() {
    }

    public ParcelableSparseArray(Parcel parcelableArray, ClassLoader classLoader) {
        int n10 = parcelableArray.readInt();
        int[] nArray = new int[n10];
        parcelableArray.readIntArray(nArray);
        parcelableArray = parcelableArray.readParcelableArray(classLoader);
        classLoader = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11 = nArray[i10];
            Parcelable parcelable = parcelableArray[i10];
            this.put(n11, parcelable);
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        int n11 = this.size();
        int[] nArray = new int[n11];
        Parcelable[] parcelableArray = new Parcelable[n11];
        for (int i10 = 0; i10 < n11; ++i10) {
            Parcelable parcelable;
            int n12;
            nArray[i10] = n12 = this.keyAt(i10);
            parcelableArray[i10] = parcelable = (Parcelable)this.valueAt(i10);
        }
        parcel.writeInt(n11);
        parcel.writeIntArray(nArray);
        parcel.writeParcelableArray(parcelableArray, n10);
    }
}

