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
import androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem$1;
import java.util.Arrays;

public class StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public int mGapDir;
    public int[] mGapPerSpan;
    public boolean mHasUnwantedGapAfter;
    public int mPosition;

    static {
        StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem$1 staggeredGridLayoutManager$LazySpanLookup$FullSpanItem$1 = new StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem$1();
        CREATOR = staggeredGridLayoutManager$LazySpanLookup$FullSpanItem$1;
    }

    public StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem() {
    }

    public StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem(Parcel parcel) {
        int n10;
        this.mPosition = n10 = parcel.readInt();
        this.mGapDir = n10 = parcel.readInt();
        n10 = parcel.readInt();
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        this.mHasUnwantedGapAfter = n11;
        n10 = parcel.readInt();
        if (n10 > 0) {
            int[] nArray = new int[n10];
            this.mGapPerSpan = nArray;
            parcel.readIntArray(nArray);
        }
    }

    public int describeContents() {
        return 0;
    }

    public int getGapForSpan(int n10) {
        int[] nArray = this.mGapPerSpan;
        n10 = nArray == null ? 0 : nArray[n10];
        return n10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FullSpanItem{mPosition=");
        int bl2 = this.mPosition;
        stringBuilder.append(bl2);
        stringBuilder.append(", mGapDir=");
        int n10 = this.mGapDir;
        stringBuilder.append(n10);
        stringBuilder.append(", mHasUnwantedGapAfter=");
        boolean bl3 = this.mHasUnwantedGapAfter;
        stringBuilder.append(bl3);
        stringBuilder.append(", mGapPerSpan=");
        String string2 = Arrays.toString(this.mGapPerSpan);
        stringBuilder.append(string2);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        int n11;
        n10 = this.mPosition;
        parcel.writeInt(n10);
        n10 = this.mGapDir;
        parcel.writeInt(n10);
        n10 = (int)(this.mHasUnwantedGapAfter ? 1 : 0);
        parcel.writeInt(n10);
        int[] nArray = this.mGapPerSpan;
        if (nArray != null && (n11 = nArray.length) > 0) {
            n10 = nArray.length;
            parcel.writeInt(n10);
            nArray = this.mGapPerSpan;
            parcel.writeIntArray(nArray);
        } else {
            n10 = 0;
            nArray = null;
            parcel.writeInt(0);
        }
    }
}

