/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.sina.weibo.sdk.api;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.sina.weibo.sdk.api.MediaObject;
import com.sina.weibo.sdk.api.MultiImageObject$1;
import java.util.ArrayList;
import java.util.List;

public class MultiImageObject
extends MediaObject {
    public static final Parcelable.Creator CREATOR;
    private static final long serialVersionUID = 4858450022450986236L;
    public ArrayList imageList;

    static {
        MultiImageObject$1 multiImageObject$1 = new MultiImageObject$1();
        CREATOR = multiImageObject$1;
    }

    public MultiImageObject() {
    }

    public MultiImageObject(Parcel object) {
        super((Parcel)object);
        Parcelable.Creator creator = Uri.CREATOR;
        object = object.createTypedArrayList(creator);
        this.imageList = object;
    }

    public int describeContents() {
        return 0;
    }

    public ArrayList getImageList() {
        return this.imageList;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        super.writeToParcel(parcel, n10);
        ArrayList arrayList = this.imageList;
        parcel.writeTypedList((List)arrayList);
    }
}

