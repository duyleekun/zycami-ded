/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.material.appbar;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.appbar.AppBarLayout$BaseBehavior$SavedState$1;

public class AppBarLayout$BaseBehavior$SavedState
extends AbsSavedState {
    public static final Parcelable.Creator CREATOR;
    public boolean firstVisibleChildAtMinimumHeight;
    public int firstVisibleChildIndex;
    public float firstVisibleChildPercentageShown;

    static {
        AppBarLayout$BaseBehavior$SavedState$1 appBarLayout$BaseBehavior$SavedState$1 = new AppBarLayout$BaseBehavior$SavedState$1();
        CREATOR = appBarLayout$BaseBehavior$SavedState$1;
    }

    public AppBarLayout$BaseBehavior$SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        float f10;
        int n10;
        this.firstVisibleChildIndex = n10 = parcel.readInt();
        this.firstVisibleChildPercentageShown = f10 = parcel.readFloat();
        byte by2 = parcel.readByte();
        if (by2 != 0) {
            by2 = 1;
        } else {
            by2 = 0;
            parcel = null;
        }
        this.firstVisibleChildAtMinimumHeight = by2;
    }

    public AppBarLayout$BaseBehavior$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public void writeToParcel(Parcel parcel, int n10) {
        super.writeToParcel(parcel, n10);
        n10 = this.firstVisibleChildIndex;
        parcel.writeInt(n10);
        float f10 = this.firstVisibleChildPercentageShown;
        parcel.writeFloat(f10);
        n10 = (byte)(this.firstVisibleChildAtMinimumHeight ? 1 : 0);
        parcel.writeByte((byte)n10);
    }
}

