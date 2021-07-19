/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$ClassLoaderCreator
 */
package androidx.viewpager.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.viewpager.widget.ViewPager$SavedState;

public final class ViewPager$SavedState$1
implements Parcelable.ClassLoaderCreator {
    public ViewPager$SavedState createFromParcel(Parcel parcel) {
        ViewPager$SavedState viewPager$SavedState = new ViewPager$SavedState(parcel, null);
        return viewPager$SavedState;
    }

    public ViewPager$SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        ViewPager$SavedState viewPager$SavedState = new ViewPager$SavedState(parcel, classLoader);
        return viewPager$SavedState;
    }

    public ViewPager$SavedState[] newArray(int n10) {
        return new ViewPager$SavedState[n10];
    }
}

