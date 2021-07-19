/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.material.stateful;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.SimpleArrayMap;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.stateful.ExtendableSavedState$1;

public class ExtendableSavedState
extends AbsSavedState {
    public static final Parcelable.Creator CREATOR;
    public final SimpleArrayMap extendableStates;

    static {
        ExtendableSavedState$1 extendableSavedState$1 = new ExtendableSavedState$1();
        CREATOR = extendableSavedState$1;
    }

    private ExtendableSavedState(Parcel object, ClassLoader classLoader) {
        super((Parcel)object, classLoader);
        int n10 = object.readInt();
        String[] stringArray = new String[n10];
        object.readStringArray(stringArray);
        Object[] objectArray = new Bundle[n10];
        Object object2 = Bundle.CREATOR;
        object.readTypedArray(objectArray, (Parcelable.Creator)object2);
        super(n10);
        this.extendableStates = object;
        object = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            object2 = this.extendableStates;
            String string2 = stringArray[i10];
            Object object3 = objectArray[i10];
            ((SimpleArrayMap)object2).put(string2, object3);
        }
    }

    public /* synthetic */ ExtendableSavedState(Parcel parcel, ClassLoader classLoader, ExtendableSavedState$1 extendableSavedState$1) {
        this(parcel, classLoader);
    }

    public ExtendableSavedState(Parcelable object) {
        super((Parcelable)object);
        super();
        this.extendableStates = object;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ExtendableSavedState{");
        Object object = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append((String)object);
        stringBuilder.append(" states=");
        object = this.extendableStates;
        stringBuilder.append(object);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        super.writeToParcel(parcel, n10);
        SimpleArrayMap simpleArrayMap = this.extendableStates;
        n10 = simpleArrayMap.size();
        parcel.writeInt(n10);
        String[] stringArray = new String[n10];
        Bundle[] bundleArray = new Bundle[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            String string2;
            stringArray[i10] = string2 = (String)this.extendableStates.keyAt(i10);
            string2 = (Bundle)this.extendableStates.valueAt(i10);
            bundleArray[i10] = string2;
        }
        parcel.writeStringArray(stringArray);
        parcel.writeTypedArray((Parcelable[])bundleArray, 0);
    }
}

