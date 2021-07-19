/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$ClassLoaderCreator
 */
package androidx.slidingpanelayout.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.slidingpanelayout.widget.SlidingPaneLayout$SavedState;

public final class SlidingPaneLayout$SavedState$1
implements Parcelable.ClassLoaderCreator {
    public SlidingPaneLayout$SavedState createFromParcel(Parcel parcel) {
        SlidingPaneLayout$SavedState slidingPaneLayout$SavedState = new SlidingPaneLayout$SavedState(parcel, null);
        return slidingPaneLayout$SavedState;
    }

    public SlidingPaneLayout$SavedState createFromParcel(Parcel parcel, ClassLoader object) {
        object = new SlidingPaneLayout$SavedState(parcel, null);
        return object;
    }

    public SlidingPaneLayout$SavedState[] newArray(int n10) {
        return new SlidingPaneLayout$SavedState[n10];
    }
}

