/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$ClassLoaderCreator
 */
package com.google.android.material.navigation;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.navigation.NavigationView$SavedState;

public final class NavigationView$SavedState$1
implements Parcelable.ClassLoaderCreator {
    public NavigationView$SavedState createFromParcel(Parcel parcel) {
        NavigationView$SavedState navigationView$SavedState = new NavigationView$SavedState(parcel, null);
        return navigationView$SavedState;
    }

    public NavigationView$SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        NavigationView$SavedState navigationView$SavedState = new NavigationView$SavedState(parcel, classLoader);
        return navigationView$SavedState;
    }

    public NavigationView$SavedState[] newArray(int n10) {
        return new NavigationView$SavedState[n10];
    }
}

