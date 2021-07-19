/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package androidx.core.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.widget.NestedScrollView$SavedState;

public class NestedScrollView$SavedState$1
implements Parcelable.Creator {
    public NestedScrollView$SavedState createFromParcel(Parcel parcel) {
        NestedScrollView$SavedState nestedScrollView$SavedState = new NestedScrollView$SavedState(parcel);
        return nestedScrollView$SavedState;
    }

    public NestedScrollView$SavedState[] newArray(int n10) {
        return new NestedScrollView$SavedState[n10];
    }
}

