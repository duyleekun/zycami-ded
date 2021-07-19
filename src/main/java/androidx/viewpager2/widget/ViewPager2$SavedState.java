/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.view.View$BaseSavedState
 */
package androidx.viewpager2.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.viewpager2.widget.ViewPager2$SavedState$1;

public class ViewPager2$SavedState
extends View.BaseSavedState {
    public static final Parcelable.Creator CREATOR;
    public Parcelable mAdapterState;
    public int mCurrentItem;
    public int mRecyclerViewId;

    static {
        ViewPager2$SavedState$1 viewPager2$SavedState$1 = new ViewPager2$SavedState$1();
        CREATOR = viewPager2$SavedState$1;
    }

    public ViewPager2$SavedState(Parcel parcel) {
        super(parcel);
        this.readValues(parcel, null);
    }

    public ViewPager2$SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.readValues(parcel, classLoader);
    }

    public ViewPager2$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    private void readValues(Parcel parcel, ClassLoader classLoader) {
        int n10;
        this.mRecyclerViewId = n10 = parcel.readInt();
        this.mCurrentItem = n10 = parcel.readInt();
        parcel = parcel.readParcelable(classLoader);
        this.mAdapterState = parcel;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        super.writeToParcel(parcel, n10);
        int n11 = this.mRecyclerViewId;
        parcel.writeInt(n11);
        n11 = this.mCurrentItem;
        parcel.writeInt(n11);
        Parcelable parcelable = this.mAdapterState;
        parcel.writeParcelable(parcelable, n10);
    }
}

