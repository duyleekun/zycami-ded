/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$ClassLoaderCreator
 */
package androidx.coordinatorlayout.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.coordinatorlayout.widget.CoordinatorLayout$SavedState;

public final class CoordinatorLayout$SavedState$1
implements Parcelable.ClassLoaderCreator {
    public CoordinatorLayout$SavedState createFromParcel(Parcel parcel) {
        CoordinatorLayout$SavedState coordinatorLayout$SavedState = new CoordinatorLayout$SavedState(parcel, null);
        return coordinatorLayout$SavedState;
    }

    public CoordinatorLayout$SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        CoordinatorLayout$SavedState coordinatorLayout$SavedState = new CoordinatorLayout$SavedState(parcel, classLoader);
        return coordinatorLayout$SavedState;
    }

    public CoordinatorLayout$SavedState[] newArray(int n10) {
        return new CoordinatorLayout$SavedState[n10];
    }
}

