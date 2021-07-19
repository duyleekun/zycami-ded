/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 */
package com.google.android.material.textfield;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.textfield.TextInputLayout$SavedState$1;

public class TextInputLayout$SavedState
extends AbsSavedState {
    public static final Parcelable.Creator CREATOR;
    public CharSequence error;
    public boolean isPasswordToggledVisible;

    static {
        TextInputLayout$SavedState$1 textInputLayout$SavedState$1 = new TextInputLayout$SavedState$1();
        CREATOR = textInputLayout$SavedState$1;
    }

    public TextInputLayout$SavedState(Parcel parcel, ClassLoader object) {
        super(parcel, (ClassLoader)object);
        this.error = object = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        int n10 = parcel.readInt();
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
            object = null;
        }
        this.isPasswordToggledVisible = n11;
    }

    public TextInputLayout$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TextInputLayout.SavedState{");
        CharSequence charSequence = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append((String)charSequence);
        stringBuilder.append(" error=");
        charSequence = this.error;
        stringBuilder.append((Object)charSequence);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        super.writeToParcel(parcel, n10);
        TextUtils.writeToParcel((CharSequence)this.error, (Parcel)parcel, (int)n10);
        n10 = (int)(this.isPasswordToggledVisible ? 1 : 0);
        parcel.writeInt(n10);
    }
}

