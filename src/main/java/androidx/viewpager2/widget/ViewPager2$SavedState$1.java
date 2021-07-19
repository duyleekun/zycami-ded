/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Parcel
 *  android.os.Parcelable$ClassLoaderCreator
 */
package androidx.viewpager2.widget;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.viewpager2.widget.ViewPager2$SavedState;

public final class ViewPager2$SavedState$1
implements Parcelable.ClassLoaderCreator {
    public ViewPager2$SavedState createFromParcel(Parcel parcel) {
        return this.createFromParcel(parcel, null);
    }

    public ViewPager2$SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        ViewPager2$SavedState viewPager2$SavedState = n10 >= n11 ? new ViewPager2$SavedState(parcel, classLoader) : new ViewPager2$SavedState(parcel);
        return viewPager2$SavedState;
    }

    public ViewPager2$SavedState[] newArray(int n10) {
        return new ViewPager2$SavedState[n10];
    }
}

