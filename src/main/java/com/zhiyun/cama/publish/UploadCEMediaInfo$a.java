/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.zhiyun.cama.publish;

import android.os.Parcel;
import android.os.Parcelable;
import com.zhiyun.cama.publish.UploadCEMediaInfo;

public final class UploadCEMediaInfo$a
implements Parcelable.Creator {
    public UploadCEMediaInfo a(Parcel parcel) {
        UploadCEMediaInfo uploadCEMediaInfo = new UploadCEMediaInfo(parcel);
        return uploadCEMediaInfo;
    }

    public UploadCEMediaInfo[] b(int n10) {
        return new UploadCEMediaInfo[n10];
    }
}

