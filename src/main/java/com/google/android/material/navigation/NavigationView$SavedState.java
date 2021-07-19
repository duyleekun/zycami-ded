/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.material.navigation;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.navigation.NavigationView$SavedState$1;

public class NavigationView$SavedState
extends AbsSavedState {
    public static final Parcelable.Creator CREATOR;
    public Bundle menuState;

    static {
        NavigationView$SavedState$1 navigationView$SavedState$1 = new NavigationView$SavedState$1();
        CREATOR = navigationView$SavedState$1;
    }

    public NavigationView$SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        parcel = parcel.readBundle(classLoader);
        this.menuState = parcel;
    }

    public NavigationView$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public void writeToParcel(Parcel parcel, int n10) {
        super.writeToParcel(parcel, n10);
        Bundle bundle = this.menuState;
        parcel.writeBundle(bundle);
    }
}

