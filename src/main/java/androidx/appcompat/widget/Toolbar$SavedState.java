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
import androidx.appcompat.widget.Toolbar$SavedState$1;
import androidx.customview.view.AbsSavedState;

public class Toolbar$SavedState
extends AbsSavedState {
    public static final Parcelable.Creator CREATOR;
    public int expandedMenuItemId;
    public boolean isOverflowOpen;

    static {
        Toolbar$SavedState$1 toolbar$SavedState$1 = new Toolbar$SavedState$1();
        CREATOR = toolbar$SavedState$1;
    }

    public Toolbar$SavedState(Parcel parcel) {
        this(parcel, null);
    }

    public Toolbar$SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int n10;
        this.expandedMenuItemId = n10 = parcel.readInt();
        int n11 = parcel.readInt();
        if (n11 != 0) {
            n11 = 1;
        } else {
            n11 = 0;
            parcel = null;
        }
        this.isOverflowOpen = n11;
    }

    public Toolbar$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public void writeToParcel(Parcel parcel, int n10) {
        super.writeToParcel(parcel, n10);
        n10 = this.expandedMenuItemId;
        parcel.writeInt(n10);
        n10 = (int)(this.isOverflowOpen ? 1 : 0);
        parcel.writeInt(n10);
    }
}

