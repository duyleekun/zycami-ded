/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$ClassLoaderCreator
 */
package com.google.android.material.textfield;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.textfield.TextInputLayout$SavedState;

public final class TextInputLayout$SavedState$1
implements Parcelable.ClassLoaderCreator {
    public TextInputLayout$SavedState createFromParcel(Parcel parcel) {
        TextInputLayout$SavedState textInputLayout$SavedState = new TextInputLayout$SavedState(parcel, null);
        return textInputLayout$SavedState;
    }

    public TextInputLayout$SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        TextInputLayout$SavedState textInputLayout$SavedState = new TextInputLayout$SavedState(parcel, classLoader);
        return textInputLayout$SavedState;
    }

    public TextInputLayout$SavedState[] newArray(int n10) {
        return new TextInputLayout$SavedState[n10];
    }
}

