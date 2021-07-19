/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.exoplayer2.metadata.emsg;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.metadata.Metadata$Entry;
import com.google.android.exoplayer2.metadata.emsg.EventMessage$1;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class EventMessage
implements Metadata$Entry {
    public static final Parcelable.Creator CREATOR;
    private static final Format ID3_FORMAT;
    public static final String ID3_SCHEME_ID_AOM = "https://aomedia.org/emsg/ID3";
    private static final String ID3_SCHEME_ID_APPLE = "https://developer.apple.com/streaming/emsg-id3";
    private static final Format SCTE35_FORMAT;
    public static final String SCTE35_SCHEME_ID = "urn:scte:scte35:2014:bin";
    public final long durationMs;
    private int hashCode;
    public final long id;
    public final byte[] messageData;
    public final String schemeIdUri;
    public final String value;

    static {
        Object object = new Format$Builder();
        ID3_FORMAT = ((Format$Builder)object).setSampleMimeType("application/id3").build();
        object = new Format$Builder();
        SCTE35_FORMAT = ((Format$Builder)object).setSampleMimeType("application/x-scte35").build();
        object = new EventMessage$1();
        CREATOR = object;
    }

    public EventMessage(Parcel object) {
        long l10;
        String string2;
        this.schemeIdUri = string2 = (String)Util.castNonNull(object.readString());
        this.value = string2 = (String)Util.castNonNull(object.readString());
        this.durationMs = l10 = object.readLong();
        this.id = l10 = object.readLong();
        object = (byte[])Util.castNonNull(object.createByteArray());
        this.messageData = (byte[])object;
    }

    public EventMessage(String string2, String string3, long l10, long l11, byte[] byArray) {
        this.schemeIdUri = string2;
        this.value = string3;
        this.durationMs = l10;
        this.id = l11;
        this.messageData = byArray;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = EventMessage.class) == (object2 = object.getClass())) {
            boolean bl3;
            long l10;
            object = (EventMessage)object;
            long l11 = this.durationMs;
            long l12 = ((EventMessage)object).durationMs;
            long l13 = l11 - l12;
            Object object4 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object4 != false || (object4 = (l10 = (l11 = this.id) - (l12 = ((EventMessage)object).id)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false || (object4 = (Object)Util.areEqual(object3 = this.schemeIdUri, object2 = ((EventMessage)object).schemeIdUri)) == false || (object4 = (Object)Util.areEqual(object3 = this.value, object2 = ((EventMessage)object).value)) == false || !(bl3 = Arrays.equals((byte[])(object3 = (Object)this.messageData), (byte[])(object = (Object)((EventMessage)object).messageData)))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public byte[] getWrappedMetadataBytes() {
        Object object = this.getWrappedMetadataFormat();
        object = object != null ? (Object)this.messageData : null;
        return object;
    }

    public Format getWrappedMetadataFormat() {
        String string2 = this.schemeIdUri;
        string2.hashCode();
        int n10 = string2.hashCode();
        int n11 = -1;
        switch (n10) {
            default: {
                break;
            }
            case 1303648457: {
                String string3 = ID3_SCHEME_ID_APPLE;
                boolean bl2 = string2.equals(string3);
                if (!bl2) break;
                n11 = 2;
                break;
            }
            case -795945609: {
                String string4 = ID3_SCHEME_ID_AOM;
                boolean bl3 = string2.equals(string4);
                if (!bl3) break;
                n11 = 1;
                break;
            }
            case -1468477611: {
                String string5 = SCTE35_SCHEME_ID;
                boolean bl4 = string2.equals(string5);
                if (!bl4) break;
                n11 = 0;
            }
        }
        switch (n11) {
            default: {
                return null;
            }
            case 1: 
            case 2: {
                return ID3_FORMAT;
            }
            case 0: 
        }
        return SCTE35_FORMAT;
    }

    public int hashCode() {
        int n10 = this.hashCode;
        if (n10 == 0) {
            int n11;
            n10 = 527;
            Object object = this.schemeIdUri;
            int n12 = 0;
            if (object != null) {
                n11 = ((String)object).hashCode();
            } else {
                n11 = 0;
                object = null;
            }
            n10 = (n10 + n11) * 31;
            object = this.value;
            if (object != null) {
                n12 = ((String)object).hashCode();
            }
            n10 = (n10 + n12) * 31;
            long l10 = this.durationMs;
            int n13 = 32;
            long l11 = l10 >>> n13;
            n11 = (int)(l10 ^ l11);
            n10 = (n10 + n11) * 31;
            l10 = this.id;
            long l12 = l10 >>> n13;
            n11 = (int)(l10 ^= l12);
            n10 = (n10 + n11) * 31;
            object = this.messageData;
            n11 = Arrays.hashCode((byte[])object);
            this.hashCode = n10 += n11;
        }
        return this.hashCode;
    }

    public String toString() {
        String string2 = this.schemeIdUri;
        long l10 = this.id;
        long l11 = this.durationMs;
        String string3 = this.value;
        int n10 = String.valueOf(string2).length() + 79;
        int n11 = String.valueOf(string3).length();
        StringBuilder stringBuilder = new StringBuilder(n10 += n11);
        stringBuilder.append("EMSG: scheme=");
        stringBuilder.append(string2);
        stringBuilder.append(", id=");
        stringBuilder.append(l10);
        stringBuilder.append(", durationMs=");
        stringBuilder.append(l11);
        stringBuilder.append(", value=");
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        Object object = this.schemeIdUri;
        parcel.writeString((String)object);
        object = this.value;
        parcel.writeString((String)object);
        long l10 = this.durationMs;
        parcel.writeLong(l10);
        l10 = this.id;
        parcel.writeLong(l10);
        object = this.messageData;
        parcel.writeByteArray((byte[])object);
    }
}

