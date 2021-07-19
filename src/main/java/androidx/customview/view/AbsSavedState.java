/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package androidx.customview.view;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState$1;
import androidx.customview.view.AbsSavedState$2;

public abstract class AbsSavedState
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public static final AbsSavedState EMPTY_STATE;
    private final Parcelable mSuperState;

    static {
        Object object = new AbsSavedState$1();
        EMPTY_STATE = object;
        object = new AbsSavedState$2();
        CREATOR = object;
    }

    private AbsSavedState() {
        this.mSuperState = null;
    }

    public AbsSavedState(Parcel parcel) {
        this(parcel, null);
    }

    public AbsSavedState(Parcel object, ClassLoader classLoader) {
        object = object.readParcelable(classLoader);
        if (object == null) {
            object = EMPTY_STATE;
        }
        this.mSuperState = object;
    }

    public AbsSavedState(Parcelable object) {
        if (object != null) {
            AbsSavedState absSavedState = EMPTY_STATE;
            if (object == absSavedState) {
                object = null;
            }
            this.mSuperState = object;
            return;
        }
        super("superState must not be null");
        throw object;
    }

    public /* synthetic */ AbsSavedState(AbsSavedState$1 var1_1) {
        this();
    }

    public int describeContents() {
        return 0;
    }

    public final Parcelable getSuperState() {
        return this.mSuperState;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        Parcelable parcelable = this.mSuperState;
        parcel.writeParcelable(parcelable, n10);
    }
}

