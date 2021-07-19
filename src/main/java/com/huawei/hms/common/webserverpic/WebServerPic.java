/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.huawei.hms.common.webserverpic;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.common.internal.safeparcel.SafeParcelWriter;
import com.huawei.hms.common.webserverpic.WebServerPicCreator;
import java.util.Locale;

public class WebServerPic {
    public static final Parcelable.Creator CREATOR;
    private final int height;
    private final Uri url;
    private final int width;

    static {
        WebServerPicCreator webServerPicCreator = new WebServerPicCreator();
        CREATOR = webServerPicCreator;
    }

    public WebServerPic(Uri uri) {
        this(uri, 0, 0);
    }

    public WebServerPic(Uri object, int n10, int n11) {
        this.url = object;
        this.width = n10;
        this.height = n11;
        if (object != null) {
            if (n10 >= 0 && n11 >= 0) {
                return;
            }
            super("width and height should be positive or 0");
            throw object;
        }
        super("url is not able to be null");
        throw object;
    }

    public final int getHeight() {
        return this.height;
    }

    public final Uri getUrl() {
        return this.url;
    }

    public final int getWidth() {
        return this.width;
    }

    public final String toString() {
        Locale locale = Locale.ENGLISH;
        Object object = this.width;
        Object[] objectArray = new Object[]{object, object = Integer.valueOf(this.height), object = this.url.toString()};
        return String.format(locale, "Image %dx%d %s", objectArray);
    }

    public final void writeToParcel(Parcel parcel, int n10) {
        Preconditions.checkNotNull(parcel);
        int n11 = SafeParcelWriter.beginObjectHeader(parcel);
        Uri uri = this.getUrl();
        SafeParcelWriter.writeParcelable(parcel, 1, (Parcelable)uri, n10, false);
        n10 = this.getWidth();
        SafeParcelWriter.writeInt(parcel, 2, n10);
        n10 = this.getHeight();
        SafeParcelWriter.writeInt(parcel, 3, n10);
        SafeParcelWriter.finishObjectHeader(parcel, n11);
    }
}

