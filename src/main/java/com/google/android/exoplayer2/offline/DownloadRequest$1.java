/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.exoplayer2.offline;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.offline.DownloadRequest;

public class DownloadRequest$1
implements Parcelable.Creator {
    public DownloadRequest createFromParcel(Parcel parcel) {
        DownloadRequest downloadRequest = new DownloadRequest(parcel);
        return downloadRequest;
    }

    public DownloadRequest[] newArray(int n10) {
        return new DownloadRequest[n10];
    }
}

