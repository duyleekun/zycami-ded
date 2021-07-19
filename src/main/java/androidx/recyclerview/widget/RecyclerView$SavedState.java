/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView$SavedState$1;

public class RecyclerView$SavedState
extends AbsSavedState {
    public static final Parcelable.Creator CREATOR;
    public Parcelable mLayoutState;

    static {
        RecyclerView$SavedState$1 recyclerView$SavedState$1 = new RecyclerView$SavedState$1();
        CREATOR = recyclerView$SavedState$1;
    }

    public RecyclerView$SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        if (classLoader == null) {
            classLoader = RecyclerView$LayoutManager.class.getClassLoader();
        }
        parcel = parcel.readParcelable(classLoader);
        this.mLayoutState = parcel;
    }

    public RecyclerView$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public void copyFrom(RecyclerView$SavedState recyclerView$SavedState) {
        recyclerView$SavedState = recyclerView$SavedState.mLayoutState;
        this.mLayoutState = recyclerView$SavedState;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        super.writeToParcel(parcel, n10);
        Parcelable parcelable = this.mLayoutState;
        parcel.writeParcelable(parcelable, 0);
    }
}

