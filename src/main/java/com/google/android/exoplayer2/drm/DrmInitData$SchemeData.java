/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.drm.DrmInitData$SchemeData$1;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.UUID;

public final class DrmInitData$SchemeData
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public final byte[] data;
    private int hashCode;
    public final String licenseServerUrl;
    public final String mimeType;
    public final UUID uuid;

    static {
        DrmInitData$SchemeData$1 drmInitData$SchemeData$1 = new DrmInitData$SchemeData$1();
        CREATOR = drmInitData$SchemeData$1;
    }

    public DrmInitData$SchemeData(Parcel object) {
        long l10 = object.readLong();
        long l11 = object.readLong();
        Object object2 = new UUID(l10, l11);
        this.uuid = object2;
        this.licenseServerUrl = object2 = object.readString();
        this.mimeType = object2 = (String)Util.castNonNull(object.readString());
        object = object.createByteArray();
        this.data = (byte[])object;
    }

    public DrmInitData$SchemeData(UUID object, String string2, String string3, byte[] byArray) {
        object = (UUID)Assertions.checkNotNull(object);
        this.uuid = object;
        this.licenseServerUrl = string2;
        this.mimeType = object = (String)Assertions.checkNotNull(string3);
        this.data = byArray;
    }

    public DrmInitData$SchemeData(UUID uUID, String string2, byte[] byArray) {
        this(uUID, null, string2, byArray);
    }

    public boolean canReplace(DrmInitData$SchemeData object) {
        boolean bl2;
        boolean bl3 = this.hasData();
        if (bl3 && !(bl3 = ((DrmInitData$SchemeData)object).hasData()) && (bl2 = this.matches((UUID)(object = ((DrmInitData$SchemeData)object).uuid)))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public DrmInitData$SchemeData copyWithData(byte[] byArray) {
        UUID uUID = this.uuid;
        String string2 = this.licenseServerUrl;
        String string3 = this.mimeType;
        DrmInitData$SchemeData drmInitData$SchemeData = new DrmInitData$SchemeData(uUID, string2, string3, byArray);
        return drmInitData$SchemeData;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        boolean bl2;
        boolean bl3 = object instanceof DrmInitData$SchemeData;
        boolean bl4 = false;
        if (!bl3) {
            return false;
        }
        bl3 = true;
        if (object == this) {
            return bl3;
        }
        object = (DrmInitData$SchemeData)object;
        Object object2 = this.licenseServerUrl;
        Object object3 = ((DrmInitData$SchemeData)object).licenseServerUrl;
        boolean bl5 = Util.areEqual(object2, object3);
        if (bl5 && (bl5 = Util.areEqual(object2 = this.mimeType, object3 = ((DrmInitData$SchemeData)object).mimeType)) && (bl5 = Util.areEqual(object2 = this.uuid, object3 = ((DrmInitData$SchemeData)object).uuid)) && (bl2 = Arrays.equals((byte[])(object2 = (Object)this.data), (byte[])(object = (Object)((DrmInitData$SchemeData)object).data)))) {
            bl4 = bl3;
        }
        return bl4;
    }

    public boolean hasData() {
        boolean bl2;
        byte[] byArray = this.data;
        if (byArray != null) {
            bl2 = true;
        } else {
            bl2 = false;
            byArray = null;
        }
        return bl2;
    }

    public int hashCode() {
        int n10 = this.hashCode;
        if (n10 == 0) {
            int n11;
            UUID uUID = this.uuid;
            n10 = uUID.hashCode() * 31;
            Object object = this.licenseServerUrl;
            if (object == null) {
                n11 = 0;
                object = null;
            } else {
                n11 = ((String)object).hashCode();
            }
            n10 = (n10 + n11) * 31;
            n11 = this.mimeType.hashCode();
            n10 = (n10 + n11) * 31;
            object = this.data;
            n11 = Arrays.hashCode((byte[])object);
            this.hashCode = n10 += n11;
        }
        return this.hashCode;
    }

    public boolean matches(UUID uUID) {
        boolean bl2;
        UUID uUID2 = C.UUID_NIL;
        UUID uUID3 = this.uuid;
        boolean bl3 = uUID2.equals(uUID3);
        if (!bl3 && !(bl2 = uUID.equals(uUID2 = this.uuid))) {
            bl2 = false;
            uUID = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        long l10 = this.uuid.getMostSignificantBits();
        parcel.writeLong(l10);
        l10 = this.uuid.getLeastSignificantBits();
        parcel.writeLong(l10);
        Object object = this.licenseServerUrl;
        parcel.writeString((String)object);
        object = this.mimeType;
        parcel.writeString((String)object);
        object = this.data;
        parcel.writeByteArray((byte[])object);
    }
}

