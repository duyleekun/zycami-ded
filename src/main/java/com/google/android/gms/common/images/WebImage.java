/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.images.zae;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class WebImage
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final int zalf;
    private final int zane;
    private final int zanf;
    private final Uri zang;

    static {
        zae zae2 = new zae();
        CREATOR = zae2;
    }

    public WebImage(int n10, Uri uri, int n11, int n12) {
        this.zalf = n10;
        this.zang = uri;
        this.zane = n11;
        this.zanf = n12;
    }

    public WebImage(Uri uri) {
        this(uri, 0, 0);
    }

    public WebImage(Uri object, int n10, int n11) {
        int n12 = 1;
        this(n12, (Uri)object, n10, n11);
        if (object != null) {
            if (n10 >= 0 && n11 >= 0) {
                return;
            }
            super("width and height must not be negative");
            throw object;
        }
        super("url cannot be null");
        throw object;
    }

    public WebImage(JSONObject jSONObject) {
        Uri uri = WebImage.zaa(jSONObject);
        int n10 = jSONObject.optInt("width", 0);
        int n11 = jSONObject.optInt("height", 0);
        this(uri, n10, n11);
    }

    private static Uri zaa(JSONObject object) {
        block4: {
            String string2 = "url";
            boolean bl2 = object.has(string2);
            if (bl2) {
                try {
                    object = object.getString(string2);
                }
                catch (JSONException jSONException) {}
                object = Uri.parse((String)object);
                break block4;
            }
            object = null;
        }
        return object;
    }

    public final boolean equals(Object object) {
        int n10;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (n10 = object instanceof WebImage) != 0) {
            int n11;
            int n12;
            object = (WebImage)object;
            Uri uri = this.zang;
            Uri uri2 = ((WebImage)object).zang;
            n10 = Objects.equal(uri, uri2);
            if (n10 != 0 && (n10 = this.zane) == (n12 = ((WebImage)object).zane) && (n10 = this.zanf) == (n11 = ((WebImage)object).zanf)) {
                return bl2;
            }
        }
        return false;
    }

    public final int getHeight() {
        return this.zanf;
    }

    public final Uri getUrl() {
        return this.zang;
    }

    public final int getWidth() {
        return this.zane;
    }

    public final int hashCode() {
        Object[] objectArray = new Object[3];
        Object object = this.zang;
        objectArray[0] = object;
        object = this.zane;
        objectArray[1] = object;
        object = this.zanf;
        objectArray[2] = object;
        return Objects.hashCode(objectArray);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final JSONObject toJson() {
        Uri uri;
        JSONObject jSONObject = new JSONObject();
        String string2 = "url";
        try {
            uri = this.zang;
        }
        catch (JSONException jSONException) {
            return jSONObject;
        }
        String string3 = uri.toString();
        jSONObject.put(string2, (Object)string3);
        string2 = "width";
        int n10 = this.zane;
        jSONObject.put(string2, n10);
        string2 = "height";
        n10 = this.zanf;
        jSONObject.put(string2, n10);
        return jSONObject;
    }

    public final String toString() {
        Locale locale = Locale.US;
        Object object = this.zane;
        Object[] objectArray = new Object[]{object, object = Integer.valueOf(this.zanf), object = this.zang.toString()};
        return String.format(locale, "Image %dx%d %s", objectArray);
    }

    public final void writeToParcel(Parcel parcel, int n10) {
        int n11 = SafeParcelWriter.beginObjectHeader(parcel);
        int n12 = this.zalf;
        SafeParcelWriter.writeInt(parcel, 1, n12);
        Uri uri = this.getUrl();
        SafeParcelWriter.writeParcelable(parcel, 2, (Parcelable)uri, n10, false);
        n10 = this.getWidth();
        SafeParcelWriter.writeInt(parcel, 3, n10);
        n10 = this.getHeight();
        SafeParcelWriter.writeInt(parcel, 4, n10);
        SafeParcelWriter.finishObjectHeader(parcel, n11);
    }
}

