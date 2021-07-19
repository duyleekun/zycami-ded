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
import androidx.recyclerview.widget.LinearLayoutManager$SavedState$1;

public class LinearLayoutManager$SavedState
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public boolean mAnchorLayoutFromEnd;
    public int mAnchorOffset;
    public int mAnchorPosition;

    static {
        LinearLayoutManager$SavedState$1 linearLayoutManager$SavedState$1 = new LinearLayoutManager$SavedState$1();
        CREATOR = linearLayoutManager$SavedState$1;
    }

    public LinearLayoutManager$SavedState() {
    }

    public LinearLayoutManager$SavedState(Parcel parcel) {
        int n10;
        this.mAnchorPosition = n10 = parcel.readInt();
        this.mAnchorOffset = n10 = parcel.readInt();
        int n11 = parcel.readInt();
        n10 = 1;
        if (n11 != n10) {
            n10 = 0;
        }
        this.mAnchorLayoutFromEnd = n10;
    }

    public LinearLayoutManager$SavedState(LinearLayoutManager$SavedState linearLayoutManager$SavedState) {
        boolean bl2;
        int n10;
        this.mAnchorPosition = n10 = linearLayoutManager$SavedState.mAnchorPosition;
        this.mAnchorOffset = n10 = linearLayoutManager$SavedState.mAnchorOffset;
        this.mAnchorLayoutFromEnd = bl2 = linearLayoutManager$SavedState.mAnchorLayoutFromEnd;
    }

    public int describeContents() {
        return 0;
    }

    public boolean hasValidAnchor() {
        int n10 = this.mAnchorPosition;
        n10 = n10 >= 0 ? 1 : 0;
        return n10 != 0;
    }

    public void invalidateAnchor() {
        this.mAnchorPosition = -1;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        n10 = this.mAnchorPosition;
        parcel.writeInt(n10);
        n10 = this.mAnchorOffset;
        parcel.writeInt(n10);
        n10 = (int)(this.mAnchorLayoutFromEnd ? 1 : 0);
        parcel.writeInt(n10);
    }
}

