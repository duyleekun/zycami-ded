/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package androidx.slidingpanelayout.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;
import androidx.slidingpanelayout.widget.SlidingPaneLayout$SavedState$1;

public class SlidingPaneLayout$SavedState
extends AbsSavedState {
    public static final Parcelable.Creator CREATOR;
    public boolean isOpen;

    static {
        SlidingPaneLayout$SavedState$1 slidingPaneLayout$SavedState$1 = new SlidingPaneLayout$SavedState$1();
        CREATOR = slidingPaneLayout$SavedState$1;
    }

    public SlidingPaneLayout$SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int n10 = parcel.readInt();
        if (n10 != 0) {
            n10 = 1;
        } else {
            n10 = 0;
            parcel = null;
        }
        this.isOpen = n10;
    }

    public SlidingPaneLayout$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public void writeToParcel(Parcel parcel, int n10) {
        super.writeToParcel(parcel, n10);
        n10 = (int)(this.isOpen ? 1 : 0);
        parcel.writeInt(n10);
    }
}

