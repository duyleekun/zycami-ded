/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$ClassLoaderCreator
 */
package com.google.android.material.appbar;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.appbar.AppBarLayout$BaseBehavior$SavedState;

public final class AppBarLayout$BaseBehavior$SavedState$1
implements Parcelable.ClassLoaderCreator {
    public AppBarLayout$BaseBehavior$SavedState createFromParcel(Parcel parcel) {
        AppBarLayout$BaseBehavior$SavedState appBarLayout$BaseBehavior$SavedState = new AppBarLayout$BaseBehavior$SavedState(parcel, null);
        return appBarLayout$BaseBehavior$SavedState;
    }

    public AppBarLayout$BaseBehavior$SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        AppBarLayout$BaseBehavior$SavedState appBarLayout$BaseBehavior$SavedState = new AppBarLayout$BaseBehavior$SavedState(parcel, classLoader);
        return appBarLayout$BaseBehavior$SavedState;
    }

    public AppBarLayout$BaseBehavior$SavedState[] newArray(int n10) {
        return new AppBarLayout$BaseBehavior$SavedState[n10];
    }
}

