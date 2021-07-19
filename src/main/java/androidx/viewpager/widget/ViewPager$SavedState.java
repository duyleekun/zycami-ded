/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package androidx.viewpager.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;
import androidx.viewpager.widget.ViewPager$SavedState$1;

public class ViewPager$SavedState
extends AbsSavedState {
    public static final Parcelable.Creator CREATOR;
    public Parcelable adapterState;
    public ClassLoader loader;
    public int position;

    static {
        ViewPager$SavedState$1 viewPager$SavedState$1 = new ViewPager$SavedState$1();
        CREATOR = viewPager$SavedState$1;
    }

    public ViewPager$SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int n10;
        if (classLoader == null) {
            classLoader = this.getClass().getClassLoader();
        }
        this.position = n10 = parcel.readInt();
        parcel = parcel.readParcelable(classLoader);
        this.adapterState = parcel;
        this.loader = classLoader;
    }

    public ViewPager$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FragmentPager.SavedState{");
        String string2 = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append(string2);
        stringBuilder.append(" position=");
        int n10 = this.position;
        stringBuilder.append(n10);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        super.writeToParcel(parcel, n10);
        int n11 = this.position;
        parcel.writeInt(n11);
        Parcelable parcelable = this.adapterState;
        parcel.writeParcelable(parcelable, n10);
    }
}

