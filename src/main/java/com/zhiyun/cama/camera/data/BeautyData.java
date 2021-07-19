/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.zhiyun.cama.camera.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.zhiyun.cama.camera.data.BeautyData$a;
import com.zhiyun.cama.camera.data.CameraSet$Beauty;

public class BeautyData
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    private CameraSet$Beauty mBeauty;
    private int mProgress;

    static {
        BeautyData$a beautyData$a = new BeautyData$a();
        CREATOR = beautyData$a;
    }

    public BeautyData(Parcel parcel) {
        int n10;
        CameraSet$Beauty cameraSet$Beauty;
        int n11 = parcel.readInt();
        int n12 = -1;
        if (n11 == n12) {
            n11 = 0;
            cameraSet$Beauty = null;
        } else {
            CameraSet$Beauty[] cameraSet$BeautyArray = CameraSet$Beauty.values();
            cameraSet$Beauty = cameraSet$BeautyArray[n11];
        }
        this.mBeauty = cameraSet$Beauty;
        this.mProgress = n10 = parcel.readInt();
    }

    public BeautyData(CameraSet$Beauty cameraSet$Beauty, int n10) {
        this.mBeauty = cameraSet$Beauty;
        this.mProgress = n10;
    }

    public int describeContents() {
        return 0;
    }

    public CameraSet$Beauty getBeauty() {
        return this.mBeauty;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void setBeauty(CameraSet$Beauty cameraSet$Beauty) {
        this.mBeauty = cameraSet$Beauty;
    }

    public void setProgress(int n10) {
        this.mProgress = n10;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        CameraSet$Beauty cameraSet$Beauty = this.mBeauty;
        n10 = cameraSet$Beauty == null ? -1 : cameraSet$Beauty.ordinal();
        parcel.writeInt(n10);
        n10 = this.mProgress;
        parcel.writeInt(n10);
    }
}

