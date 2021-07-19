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
import androidx.appcompat.widget.ActionMenuPresenter$SavedState$1;

public class ActionMenuPresenter$SavedState
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public int openSubMenuId;

    static {
        ActionMenuPresenter$SavedState$1 actionMenuPresenter$SavedState$1 = new ActionMenuPresenter$SavedState$1();
        CREATOR = actionMenuPresenter$SavedState$1;
    }

    public ActionMenuPresenter$SavedState() {
    }

    public ActionMenuPresenter$SavedState(Parcel parcel) {
        int n10;
        this.openSubMenuId = n10 = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        n10 = this.openSubMenuId;
        parcel.writeInt(n10);
    }
}

