/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.SearchView$SavedState$1;
import androidx.customview.view.AbsSavedState;

public class SearchView$SavedState
extends AbsSavedState {
    public static final Parcelable.Creator CREATOR;
    public boolean isIconified;

    static {
        SearchView$SavedState$1 searchView$SavedState$1 = new SearchView$SavedState$1();
        CREATOR = searchView$SavedState$1;
    }

    public SearchView$SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        boolean bl2;
        this.isIconified = bl2 = ((Boolean)parcel.readValue(null)).booleanValue();
    }

    public SearchView$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SearchView.SavedState{");
        String string2 = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append(string2);
        stringBuilder.append(" isIconified=");
        boolean bl2 = this.isIconified;
        stringBuilder.append(bl2);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        super.writeToParcel(parcel, n10);
        Boolean bl2 = this.isIconified;
        parcel.writeValue((Object)bl2);
    }
}

