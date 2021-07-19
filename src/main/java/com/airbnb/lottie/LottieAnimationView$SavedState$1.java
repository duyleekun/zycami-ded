/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.airbnb.lottie;

import android.os.Parcel;
import android.os.Parcelable;
import com.airbnb.lottie.LottieAnimationView$SavedState;

public class LottieAnimationView$SavedState$1
implements Parcelable.Creator {
    public LottieAnimationView$SavedState createFromParcel(Parcel parcel) {
        LottieAnimationView$SavedState lottieAnimationView$SavedState = new LottieAnimationView$SavedState(parcel, null);
        return lottieAnimationView$SavedState;
    }

    public LottieAnimationView$SavedState[] newArray(int n10) {
        return new LottieAnimationView$SavedState[n10];
    }
}

