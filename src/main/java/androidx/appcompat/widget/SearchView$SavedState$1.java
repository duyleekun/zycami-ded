/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$ClassLoaderCreator
 */
package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.SearchView$SavedState;

public class SearchView$SavedState$1
implements Parcelable.ClassLoaderCreator {
    public SearchView$SavedState createFromParcel(Parcel parcel) {
        SearchView$SavedState searchView$SavedState = new SearchView$SavedState(parcel, null);
        return searchView$SavedState;
    }

    public SearchView$SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        SearchView$SavedState searchView$SavedState = new SearchView$SavedState(parcel, classLoader);
        return searchView$SavedState;
    }

    public SearchView$SavedState[] newArray(int n10) {
        return new SearchView$SavedState[n10];
    }
}

