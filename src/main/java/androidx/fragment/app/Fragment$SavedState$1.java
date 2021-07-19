/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$ClassLoaderCreator
 */
package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment$SavedState;

public class Fragment$SavedState$1
implements Parcelable.ClassLoaderCreator {
    public Fragment$SavedState createFromParcel(Parcel parcel) {
        Fragment$SavedState fragment$SavedState = new Fragment$SavedState(parcel, null);
        return fragment$SavedState;
    }

    public Fragment$SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        Fragment$SavedState fragment$SavedState = new Fragment$SavedState(parcel, classLoader);
        return fragment$SavedState;
    }

    public Fragment$SavedState[] newArray(int n10) {
        return new Fragment$SavedState[n10];
    }
}

