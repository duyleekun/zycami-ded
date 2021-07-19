/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.sina.weibo.sdk.api;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.sina.weibo.sdk.api.ImageObject$1;
import com.sina.weibo.sdk.api.MediaObject;
import com.sina.weibo.sdk.c.c;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;

public class ImageObject
extends MediaObject {
    private static final int CONTENT_LENGTH_LIMIT = 0x100000;
    public static final Parcelable.Creator CREATOR;
    private static final int PATH_LENGTH_LIMIT = 512;
    private static final String TAG = "ImageObject";
    private static final long serialVersionUID = 8760548583231081050L;
    public byte[] imageData;
    public String imagePath;

    static {
        ImageObject$1 imageObject$1 = new ImageObject$1();
        CREATOR = imageObject$1;
    }

    public ImageObject() {
    }

    public ImageObject(Parcel object) {
        byte[] byArray = object.createByteArray();
        this.imageData = byArray;
        object = object.readString();
        this.imagePath = object;
    }

    private int getFileSize(String string2) {
        int n10;
        if (string2 != null && (n10 = string2.length()) != 0) {
            File file = new File(string2);
            boolean bl2 = file.exists();
            if (!bl2) {
                return 0;
            }
            return (int)file.length();
        }
        return 0;
    }

    public boolean checkArgs() {
        int n10;
        Object object = this.imageData;
        String string2 = TAG;
        if (object != null && (n10 = ((byte[])object).length) != 0 || (object = (Object)this.imagePath) != null && (n10 = ((String)object).length()) != 0) {
            int n11;
            object = this.imageData;
            int n12 = 0x100000;
            if (object != null && (n10 = ((byte[])object).length) > n12) {
                c.b(string2, "checkArgs fail, content is too large");
                return false;
            }
            object = this.imagePath;
            if (object != null && (n10 = ((String)object).length()) > (n11 = 512)) {
                c.b(string2, "checkArgs fail, path is invalid");
                return false;
            }
            object = this.imagePath;
            if (object != null && (n10 = this.getFileSize((String)object)) > n12) {
                c.b(string2, "checkArgs fail, image content is too large");
                return false;
            }
            return true;
        }
        c.b(string2, "checkArgs fail, all arguments are null");
        return false;
    }

    public int describeContents() {
        return 0;
    }

    public void setImageData(Bitmap object) {
        int n10;
        Bitmap.CompressFormat compressFormat;
        Object object2;
        try {
            object2 = new ByteArrayOutputStream();
            compressFormat = Bitmap.CompressFormat.JPEG;
            n10 = 85;
        }
        catch (Exception exception) {
            object2 = new StringBuilder("ImageObject :");
            String string2 = exception.getMessage();
            ((StringBuilder)object2).append(string2);
            string2 = ((StringBuilder)object2).toString();
            c.b(TAG, string2);
            return;
        }
        object.compress(compressFormat, n10, (OutputStream)object2);
        object = ((ByteArrayOutputStream)object2).toByteArray();
        this.imageData = (byte[])object;
        ((ByteArrayOutputStream)object2).close();
    }

    public void setImagePath(String string2) {
        this.imagePath = string2;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        Object object = this.imageData;
        parcel.writeByteArray(object);
        object = this.imagePath;
        parcel.writeString((String)object);
    }
}

