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
import androidx.recyclerview.widget.LinearLayoutManager$SavedState;

public class LinearLayoutManager$SavedState$1
implements Parcelable.Creator {
    public LinearLayoutManager$SavedState createFromParcel(Parcel parcel) {
        LinearLayoutManager$SavedState linearLayoutManager$SavedState = new LinearLayoutManager$SavedState(parcel);
        return linearLayoutManager$SavedState;
    }

    public LinearLayoutManager$SavedState[] newArray(int n10) {
        return new LinearLayoutManager$SavedState[n10];
    }
}

