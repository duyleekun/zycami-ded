/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.view.View$BaseSavedState
 */
package com.airbnb.lottie;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.airbnb.lottie.LottieAnimationView$1;
import com.airbnb.lottie.LottieAnimationView$SavedState$1;

public class LottieAnimationView$SavedState
extends View.BaseSavedState {
    public static final Parcelable.Creator CREATOR;
    public String animationName;
    public int animationResId;
    public String imageAssetsFolder;
    public boolean isAnimating;
    public float progress;
    public int repeatCount;
    public int repeatMode;

    static {
        LottieAnimationView$SavedState$1 lottieAnimationView$SavedState$1 = new LottieAnimationView$SavedState$1();
        CREATOR = lottieAnimationView$SavedState$1;
    }

    private LottieAnimationView$SavedState(Parcel parcel) {
        super(parcel);
        int n10;
        float f10;
        String string2;
        this.animationName = string2 = parcel.readString();
        this.progress = f10 = parcel.readFloat();
        int n11 = parcel.readInt();
        int n12 = 1;
        if (n11 != n12) {
            n12 = 0;
        }
        this.isAnimating = n12;
        this.imageAssetsFolder = string2 = parcel.readString();
        this.repeatMode = n11 = parcel.readInt();
        this.repeatCount = n10 = parcel.readInt();
    }

    public /* synthetic */ LottieAnimationView$SavedState(Parcel parcel, LottieAnimationView.1 var2_2) {
        this(parcel);
    }

    public LottieAnimationView$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public void writeToParcel(Parcel parcel, int n10) {
        super.writeToParcel(parcel, n10);
        String string2 = this.animationName;
        parcel.writeString(string2);
        float f10 = this.progress;
        parcel.writeFloat(f10);
        n10 = (int)(this.isAnimating ? 1 : 0);
        parcel.writeInt(n10);
        string2 = this.imageAssetsFolder;
        parcel.writeString(string2);
        n10 = this.repeatMode;
        parcel.writeInt(n10);
        n10 = this.repeatCount;
        parcel.writeInt(n10);
    }
}

