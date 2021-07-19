/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.view.View$BaseSavedState
 */
package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.fragment.app.FragmentTabHost$SavedState$1;

public class FragmentTabHost$SavedState
extends View.BaseSavedState {
    public static final Parcelable.Creator CREATOR;
    public String curTab;

    static {
        FragmentTabHost$SavedState$1 fragmentTabHost$SavedState$1 = new FragmentTabHost$SavedState$1();
        CREATOR = fragmentTabHost$SavedState$1;
    }

    public FragmentTabHost$SavedState(Parcel object) {
        super(object);
        object = object.readString();
        this.curTab = object;
    }

    public FragmentTabHost$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FragmentTabHost.SavedState{");
        String string2 = Integer.toHexString(System.identityHashCode((Object)this));
        stringBuilder.append(string2);
        stringBuilder.append(" curTab=");
        string2 = this.curTab;
        stringBuilder.append(string2);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        super.writeToParcel(parcel, n10);
        String string2 = this.curTab;
        parcel.writeString(string2);
    }
}

