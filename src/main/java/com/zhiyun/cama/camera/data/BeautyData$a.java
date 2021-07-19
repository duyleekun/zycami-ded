/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.zhiyun.cama.camera.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.zhiyun.cama.camera.data.BeautyData;

public final class BeautyData$a
implements Parcelable.Creator {
    public BeautyData a(Parcel parcel) {
        BeautyData beautyData = new BeautyData(parcel);
        return beautyData;
    }

    public BeautyData[] b(int n10) {
        return new BeautyData[n10];
    }
}

