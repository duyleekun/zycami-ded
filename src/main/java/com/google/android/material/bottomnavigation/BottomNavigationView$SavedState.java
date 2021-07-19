/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.material.bottomnavigation;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.bottomnavigation.BottomNavigationView$SavedState$1;

public class BottomNavigationView$SavedState
extends AbsSavedState {
    public static final Parcelable.Creator CREATOR;
    public Bundle menuPresenterState;

    static {
        BottomNavigationView$SavedState$1 bottomNavigationView$SavedState$1 = new BottomNavigationView$SavedState$1();
        CREATOR = bottomNavigationView$SavedState$1;
    }

    public BottomNavigationView$SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.readFromParcel(parcel, classLoader);
    }

    public BottomNavigationView$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    private void readFromParcel(Parcel parcel, ClassLoader classLoader) {
        parcel = parcel.readBundle(classLoader);
        this.menuPresenterState = parcel;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        super.writeToParcel(parcel, n10);
        Bundle bundle = this.menuPresenterState;
        parcel.writeBundle(bundle);
    }
}

