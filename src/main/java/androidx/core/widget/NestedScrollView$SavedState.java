/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.view.View$BaseSavedState
 */
package androidx.core.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.core.widget.NestedScrollView$SavedState$1;

public class NestedScrollView$SavedState
extends View.BaseSavedState {
    public static final Parcelable.Creator CREATOR;
    public int scrollPosition;

    static {
        NestedScrollView$SavedState$1 nestedScrollView$SavedState$1 = new NestedScrollView$SavedState$1();
        CREATOR = nestedScrollView$SavedState$1;
    }

    public NestedScrollView$SavedState(Parcel parcel) {
        super(parcel);
        int n10;
        this.scrollPosition = n10 = parcel.readInt();
    }

    public NestedScrollView$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HorizontalScrollView.SavedState{");
        String string2 = Integer.toHexString(System.identityHashCode((Object)this));
        stringBuilder.append(string2);
        stringBuilder.append(" scrollPosition=");
        int n10 = this.scrollPosition;
        stringBuilder.append(n10);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        super.writeToParcel(parcel, n10);
        n10 = this.scrollPosition;
        parcel.writeInt(n10);
    }
}

