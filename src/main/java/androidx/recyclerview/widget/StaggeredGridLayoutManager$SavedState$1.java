/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState;

public class StaggeredGridLayoutManager$SavedState$1
implements Parcelable.Creator {
    public StaggeredGridLayoutManager$SavedState createFromParcel(Parcel parcel) {
        StaggeredGridLayoutManager$SavedState staggeredGridLayoutManager$SavedState = new StaggeredGridLayoutManager$SavedState(parcel);
        return staggeredGridLayoutManager$SavedState;
    }

    public StaggeredGridLayoutManager$SavedState[] newArray(int n10) {
        return new StaggeredGridLayoutManager$SavedState[n10];
    }
}

