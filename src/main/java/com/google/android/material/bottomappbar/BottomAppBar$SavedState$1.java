/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$ClassLoaderCreator
 */
package com.google.android.material.bottomappbar;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.bottomappbar.BottomAppBar$SavedState;

public final class BottomAppBar$SavedState$1
implements Parcelable.ClassLoaderCreator {
    public BottomAppBar$SavedState createFromParcel(Parcel parcel) {
        BottomAppBar$SavedState bottomAppBar$SavedState = new BottomAppBar$SavedState(parcel, null);
        return bottomAppBar$SavedState;
    }

    public BottomAppBar$SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        BottomAppBar$SavedState bottomAppBar$SavedState = new BottomAppBar$SavedState(parcel, classLoader);
        return bottomAppBar$SavedState;
    }

    public BottomAppBar$SavedState[] newArray(int n10) {
        return new BottomAppBar$SavedState[n10];
    }
}

