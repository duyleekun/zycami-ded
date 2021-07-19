/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.material.bottomappbar;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.bottomappbar.BottomAppBar$SavedState$1;

public class BottomAppBar$SavedState
extends AbsSavedState {
    public static final Parcelable.Creator CREATOR;
    public int fabAlignmentMode;
    public boolean fabAttached;

    static {
        BottomAppBar$SavedState$1 bottomAppBar$SavedState$1 = new BottomAppBar$SavedState$1();
        CREATOR = bottomAppBar$SavedState$1;
    }

    public BottomAppBar$SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int n10;
        this.fabAlignmentMode = n10 = parcel.readInt();
        int n11 = parcel.readInt();
        if (n11 != 0) {
            n11 = 1;
        } else {
            n11 = 0;
            parcel = null;
        }
        this.fabAttached = n11;
    }

    public BottomAppBar$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public void writeToParcel(Parcel parcel, int n10) {
        super.writeToParcel(parcel, n10);
        n10 = this.fabAlignmentMode;
        parcel.writeInt(n10);
        n10 = (int)(this.fabAttached ? 1 : 0);
        parcel.writeInt(n10);
    }
}

