/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.ActionMenuPresenter$SavedState;

public class ActionMenuPresenter$SavedState$1
implements Parcelable.Creator {
    public ActionMenuPresenter$SavedState createFromParcel(Parcel parcel) {
        ActionMenuPresenter$SavedState actionMenuPresenter$SavedState = new ActionMenuPresenter$SavedState(parcel);
        return actionMenuPresenter$SavedState;
    }

    public ActionMenuPresenter$SavedState[] newArray(int n10) {
        return new ActionMenuPresenter$SavedState[n10];
    }
}

