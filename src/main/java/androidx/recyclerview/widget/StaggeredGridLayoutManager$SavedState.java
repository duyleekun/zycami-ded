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
import androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem;
import androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState$1;
import java.util.List;

public class StaggeredGridLayoutManager$SavedState
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public boolean mAnchorLayoutFromEnd;
    public int mAnchorPosition;
    public List mFullSpanItems;
    public boolean mLastLayoutRTL;
    public boolean mReverseLayout;
    public int[] mSpanLookup;
    public int mSpanLookupSize;
    public int[] mSpanOffsets;
    public int mSpanOffsetsSize;
    public int mVisibleAnchorPosition;

    static {
        StaggeredGridLayoutManager$SavedState$1 staggeredGridLayoutManager$SavedState$1 = new StaggeredGridLayoutManager$SavedState$1();
        CREATOR = staggeredGridLayoutManager$SavedState$1;
    }

    public StaggeredGridLayoutManager$SavedState() {
    }

    public StaggeredGridLayoutManager$SavedState(Parcel object) {
        Object object2;
        int n10;
        this.mAnchorPosition = n10 = object.readInt();
        this.mVisibleAnchorPosition = n10 = object.readInt();
        this.mSpanOffsetsSize = n10 = object.readInt();
        if (n10 > 0) {
            object2 = new int[n10];
            this.mSpanOffsets = object2;
            object.readIntArray(object2);
        }
        this.mSpanLookupSize = n10 = object.readInt();
        if (n10 > 0) {
            object2 = new int[n10];
            this.mSpanLookup = object2;
            object.readIntArray(object2);
        }
        n10 = object.readInt();
        int n11 = 0;
        int n12 = 1;
        if (n10 == n12) {
            n10 = n12;
        } else {
            n10 = 0;
            object2 = null;
        }
        this.mReverseLayout = n10;
        n10 = object.readInt();
        if (n10 == n12) {
            n10 = n12;
        } else {
            n10 = 0;
            object2 = null;
        }
        this.mAnchorLayoutFromEnd = n10;
        n10 = object.readInt();
        if (n10 == n12) {
            n11 = n12;
        }
        this.mLastLayoutRTL = n11;
        object2 = StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem.class.getClassLoader();
        object = object.readArrayList((ClassLoader)object2);
        this.mFullSpanItems = object;
    }

    public StaggeredGridLayoutManager$SavedState(StaggeredGridLayoutManager$SavedState object) {
        int[] nArray;
        int n10;
        this.mSpanOffsetsSize = n10 = ((StaggeredGridLayoutManager$SavedState)object).mSpanOffsetsSize;
        this.mAnchorPosition = n10 = ((StaggeredGridLayoutManager$SavedState)object).mAnchorPosition;
        this.mVisibleAnchorPosition = n10 = ((StaggeredGridLayoutManager$SavedState)object).mVisibleAnchorPosition;
        this.mSpanOffsets = nArray = ((StaggeredGridLayoutManager$SavedState)object).mSpanOffsets;
        this.mSpanLookupSize = n10 = ((StaggeredGridLayoutManager$SavedState)object).mSpanLookupSize;
        nArray = ((StaggeredGridLayoutManager$SavedState)object).mSpanLookup;
        this.mSpanLookup = nArray;
        n10 = (int)(((StaggeredGridLayoutManager$SavedState)object).mReverseLayout ? 1 : 0);
        this.mReverseLayout = n10;
        n10 = (int)(((StaggeredGridLayoutManager$SavedState)object).mAnchorLayoutFromEnd ? 1 : 0);
        this.mAnchorLayoutFromEnd = n10;
        n10 = (int)(((StaggeredGridLayoutManager$SavedState)object).mLastLayoutRTL ? 1 : 0);
        this.mLastLayoutRTL = n10;
        this.mFullSpanItems = object = ((StaggeredGridLayoutManager$SavedState)object).mFullSpanItems;
    }

    public int describeContents() {
        return 0;
    }

    public void invalidateAnchorPositionInfo() {
        int n10;
        this.mSpanOffsets = null;
        this.mSpanOffsetsSize = 0;
        this.mAnchorPosition = n10 = -1;
        this.mVisibleAnchorPosition = n10;
    }

    public void invalidateSpanInfo() {
        this.mSpanOffsets = null;
        this.mSpanOffsetsSize = 0;
        this.mSpanLookupSize = 0;
        this.mSpanLookup = null;
        this.mFullSpanItems = null;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        Object object;
        n10 = this.mAnchorPosition;
        parcel.writeInt(n10);
        n10 = this.mVisibleAnchorPosition;
        parcel.writeInt(n10);
        n10 = this.mSpanOffsetsSize;
        parcel.writeInt(n10);
        n10 = this.mSpanOffsetsSize;
        if (n10 > 0) {
            object = this.mSpanOffsets;
            parcel.writeIntArray(object);
        }
        n10 = this.mSpanLookupSize;
        parcel.writeInt(n10);
        n10 = this.mSpanLookupSize;
        if (n10 > 0) {
            object = this.mSpanLookup;
            parcel.writeIntArray(object);
        }
        n10 = (int)(this.mReverseLayout ? 1 : 0);
        parcel.writeInt(n10);
        n10 = (int)(this.mAnchorLayoutFromEnd ? 1 : 0);
        parcel.writeInt(n10);
        n10 = (int)(this.mLastLayoutRTL ? 1 : 0);
        parcel.writeInt(n10);
        object = this.mFullSpanItems;
        parcel.writeList((List)object);
    }
}

