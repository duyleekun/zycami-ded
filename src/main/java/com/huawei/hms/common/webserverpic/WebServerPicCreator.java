/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.huawei.hms.common.webserverpic;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.webserverpic.WebServerPic;

public final class WebServerPicCreator
implements Parcelable.Creator {
    public WebServerPic createFromParcel(Parcel parcel) {
        ClassLoader classLoader = Uri.class.getClassLoader();
        classLoader = (Uri)parcel.readParcelable(classLoader);
        int n10 = parcel.readInt();
        int n11 = parcel.readInt();
        WebServerPic webServerPic = new WebServerPic((Uri)classLoader, n10, n11);
        return webServerPic;
    }

    public WebServerPic[] newArray(int n10) {
        return new WebServerPic[n10];
    }
}

