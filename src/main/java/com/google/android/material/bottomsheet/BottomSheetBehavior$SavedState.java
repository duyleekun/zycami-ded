/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.material.bottomsheet;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.bottomsheet.BottomSheetBehavior$SavedState$1;

public class BottomSheetBehavior$SavedState
extends AbsSavedState {
    public static final Parcelable.Creator CREATOR;
    public final int state;

    static {
        BottomSheetBehavior$SavedState$1 bottomSheetBehavior$SavedState$1 = new BottomSheetBehavior$SavedState$1();
        CREATOR = bottomSheetBehavior$SavedState$1;
    }

    public BottomSheetBehavior$SavedState(Parcel parcel) {
        this(parcel, null);
    }

    public BottomSheetBehavior$SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int n10;
        this.state = n10 = parcel.readInt();
    }

    public BottomSheetBehavior$SavedState(Parcelable parcelable, int n10) {
        super(parcelable);
        this.state = n10;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        super.writeToParcel(parcel, n10);
        n10 = this.state;
        parcel.writeInt(n10);
    }
}

