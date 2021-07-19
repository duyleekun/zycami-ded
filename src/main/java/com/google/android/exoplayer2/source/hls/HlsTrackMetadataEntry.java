/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 */
package com.google.android.exoplayer2.source.hls;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.exoplayer2.metadata.Metadata$Entry;
import com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry$1;
import com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry$VariantInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class HlsTrackMetadataEntry
implements Metadata$Entry {
    public static final Parcelable.Creator CREATOR;
    public final String groupId;
    public final String name;
    public final List variantInfos;

    static {
        HlsTrackMetadataEntry$1 hlsTrackMetadataEntry$1 = new HlsTrackMetadataEntry$1();
        CREATOR = hlsTrackMetadataEntry$1;
    }

    public HlsTrackMetadataEntry(Parcel object) {
        String string2;
        this.groupId = string2 = object.readString();
        this.name = string2 = object.readString();
        int n10 = object.readInt();
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object2 = HlsTrackMetadataEntry$VariantInfo.class.getClassLoader();
            object2 = (HlsTrackMetadataEntry$VariantInfo)object.readParcelable((ClassLoader)object2);
            arrayList.add(object2);
        }
        object = Collections.unmodifiableList(arrayList);
        this.variantInfos = object;
    }

    public HlsTrackMetadataEntry(String list, String string2, List list2) {
        this.groupId = list;
        this.name = string2;
        list = new List(list2);
        this.variantInfos = list = Collections.unmodifiableList(list);
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
        if (object != null && (object3 = HlsTrackMetadataEntry.class) == (object2 = object.getClass())) {
            boolean bl3;
            object = (HlsTrackMetadataEntry)object;
            object3 = this.groupId;
            object2 = ((HlsTrackMetadataEntry)object).groupId;
            boolean bl4 = TextUtils.equals((CharSequence)object3, (CharSequence)object2);
            if (!(bl4 && (bl4 = TextUtils.equals((CharSequence)(object3 = this.name), (CharSequence)(object2 = ((HlsTrackMetadataEntry)object).name))) && (bl3 = (object3 = this.variantInfos).equals(object = ((HlsTrackMetadataEntry)object).variantInfos)))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10;
        String string2 = this.groupId;
        int n11 = 0;
        if (string2 != null) {
            n10 = string2.hashCode();
        } else {
            n10 = 0;
            string2 = null;
        }
        n10 *= 31;
        String string3 = this.name;
        if (string3 != null) {
            n11 = string3.hashCode();
        }
        n10 = (n10 + n11) * 31;
        n11 = this.variantInfos.hashCode();
        return n10 + n11;
    }

    public String toString() {
        String string2;
        String string3 = this.groupId;
        if (string3 != null) {
            String string4 = this.name;
            int n10 = String.valueOf(string3).length() + 5;
            int n11 = String.valueOf(string4).length();
            StringBuilder stringBuilder = new StringBuilder(n10 += n11);
            string2 = " [";
            stringBuilder.append(string2);
            stringBuilder.append(string3);
            stringBuilder.append(", ");
            stringBuilder.append(string4);
            stringBuilder.append("]");
            string3 = stringBuilder.toString();
        } else {
            string3 = "";
        }
        string3 = String.valueOf(string3);
        int n12 = string3.length();
        string2 = "HlsTrackMetadataEntry";
        string3 = n12 != 0 ? string2.concat(string3) : new String(string2);
        return string3;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        Object object = this.groupId;
        parcel.writeString((String)object);
        object = this.name;
        parcel.writeString((String)object);
        object = this.variantInfos;
        n10 = object.size();
        parcel.writeInt(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            Parcelable parcelable = (Parcelable)this.variantInfos.get(i10);
            parcel.writeParcelable(parcelable, 0);
        }
    }
}

