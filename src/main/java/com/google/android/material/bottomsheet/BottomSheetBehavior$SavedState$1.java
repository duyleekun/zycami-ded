/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$ClassLoaderCreator
 */
package com.google.android.material.bottomsheet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.bottomsheet.BottomSheetBehavior$SavedState;

public final class BottomSheetBehavior$SavedState$1
implements Parcelable.ClassLoaderCreator {
    public BottomSheetBehavior$SavedState createFromParcel(Parcel parcel) {
        BottomSheetBehavior$SavedState bottomSheetBehavior$SavedState = new BottomSheetBehavior$SavedState(parcel, null);
        return bottomSheetBehavior$SavedState;
    }

    public BottomSheetBehavior$SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        BottomSheetBehavior$SavedState bottomSheetBehavior$SavedState = new BottomSheetBehavior$SavedState(parcel, classLoader);
        return bottomSheetBehavior$SavedState;
    }

    public BottomSheetBehavior$SavedState[] newArray(int n10) {
        return new BottomSheetBehavior$SavedState[n10];
    }
}

