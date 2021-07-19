/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.exoplayer2.offline;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaItem$Builder;
import com.google.android.exoplayer2.offline.DownloadRequest$1;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class DownloadRequest
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public final String customCacheKey;
    public final byte[] data;
    public final String id;
    public final byte[] keySetId;
    public final String mimeType;
    public final List streamKeys;
    public final Uri uri;

    static {
        DownloadRequest$1 downloadRequest$1 = new DownloadRequest$1();
        CREATOR = downloadRequest$1;
    }

    public DownloadRequest(Parcel object) {
        Object object2 = (String)Util.castNonNull(object.readString());
        this.id = object2;
        object2 = Uri.parse((String)((String)Util.castNonNull(object.readString())));
        this.uri = object2;
        object2 = object.readString();
        this.mimeType = object2;
        int n10 = object.readInt();
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object3 = StreamKey.class.getClassLoader();
            object3 = (StreamKey)object.readParcelable((ClassLoader)object3);
            arrayList.add(object3);
        }
        this.streamKeys = object2 = Collections.unmodifiableList(arrayList);
        object2 = object.createByteArray();
        this.keySetId = (byte[])object2;
        this.customCacheKey = object2 = object.readString();
        object = (byte[])Util.castNonNull(object.createByteArray());
        this.data = (byte[])object;
    }

    private DownloadRequest(String object, Uri uri, String string2, List list, byte[] byArray, String string3, byte[] byArray2) {
        int n10;
        boolean bl2;
        boolean bl3 = Util.inferContentTypeForUriAndMimeType(uri, string2);
        boolean bl4 = true;
        if (!bl3 || bl3 == (bl2 = 2 != 0) || bl3 == bl4) {
            if (string3 != null) {
                bl4 = false;
            }
            int n11 = 49;
            StringBuilder stringBuilder = new StringBuilder(n11);
            String string4 = "customCacheKey must be null for type: ";
            stringBuilder.append(string4);
            stringBuilder.append((int)(bl3 ? 1 : 0));
            String string5 = stringBuilder.toString();
            Assertions.checkArgument(bl4, string5);
        }
        this.id = object;
        this.uri = uri;
        this.mimeType = string2;
        object = new ArrayList(list);
        Collections.sort(object);
        object = Collections.unmodifiableList(object);
        this.streamKeys = object;
        if (byArray != null) {
            n10 = byArray.length;
            object = Arrays.copyOf(byArray, n10);
        } else {
            n10 = 0;
            object = null;
        }
        this.keySetId = (byte[])object;
        this.customCacheKey = string3;
        if (byArray2 != null) {
            n10 = byArray2.length;
            object = Arrays.copyOf(byArray2, n10);
        } else {
            object = Util.EMPTY_BYTE_ARRAY;
        }
        this.data = (byte[])object;
    }

    public /* synthetic */ DownloadRequest(String string2, Uri uri, String string3, List list, byte[] byArray, String string4, byte[] byArray2, DownloadRequest$1 downloadRequest$1) {
        this(string2, uri, string3, list, byArray, string4, byArray2);
    }

    public DownloadRequest copyWithId(String string2) {
        Uri uri = this.uri;
        String string3 = this.mimeType;
        List list = this.streamKeys;
        byte[] byArray = this.keySetId;
        String string4 = this.customCacheKey;
        byte[] byArray2 = this.data;
        DownloadRequest downloadRequest = new DownloadRequest(string2, uri, string3, list, byArray, string4, byArray2);
        return downloadRequest;
    }

    public DownloadRequest copyWithKeySetId(byte[] byArray) {
        String string2 = this.id;
        Uri uri = this.uri;
        String string3 = this.mimeType;
        List list = this.streamKeys;
        String string4 = this.customCacheKey;
        byte[] byArray2 = this.data;
        DownloadRequest downloadRequest = new DownloadRequest(string2, uri, string3, list, byArray, string4, byArray2);
        return downloadRequest;
    }

    public DownloadRequest copyWithMergedRequest(DownloadRequest downloadRequest) {
        Object object;
        ArrayList<Object> arrayList = this.id;
        ArrayList<Object> arrayList2 = downloadRequest.id;
        Assertions.checkArgument(((String)((Object)arrayList)).equals(arrayList2));
        arrayList = this.streamKeys;
        boolean bl2 = arrayList.isEmpty();
        if (!bl2 && !(bl2 = (arrayList = downloadRequest.streamKeys).isEmpty())) {
            int n10;
            arrayList2 = this.streamKeys;
            arrayList = new ArrayList<Object>(arrayList2);
            arrayList2 = null;
            for (int i10 = 0; i10 < (n10 = (object = downloadRequest.streamKeys).size()); ++i10) {
                object = (StreamKey)downloadRequest.streamKeys.get(i10);
                boolean bl3 = arrayList.contains(object);
                if (bl3) continue;
                arrayList.add(object);
            }
        } else {
            arrayList = Collections.emptyList();
        }
        List list = arrayList;
        object = this.id;
        Uri uri = downloadRequest.uri;
        String string2 = downloadRequest.mimeType;
        byte[] byArray = downloadRequest.keySetId;
        String string3 = downloadRequest.customCacheKey;
        byte[] byArray2 = downloadRequest.data;
        arrayList2 = arrayList;
        arrayList = new ArrayList<Object>((String)object, uri, string2, list, byArray, string3, byArray2);
        return arrayList;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        boolean bl2;
        boolean bl3 = object instanceof DownloadRequest;
        boolean bl4 = false;
        if (!bl3) {
            return false;
        }
        object = (DownloadRequest)object;
        Object object2 = this.id;
        Object object3 = ((DownloadRequest)object).id;
        bl3 = ((String)object2).equals(object3);
        if (bl3 && (bl3 = (object2 = this.uri).equals(object3 = ((DownloadRequest)object).uri)) && (bl3 = Util.areEqual(object2 = this.mimeType, object3 = ((DownloadRequest)object).mimeType)) && (bl3 = (object2 = this.streamKeys).equals(object3 = ((DownloadRequest)object).streamKeys)) && (bl3 = Arrays.equals((byte[])(object2 = (Object)this.keySetId), (byte[])(object3 = (Object)((DownloadRequest)object).keySetId))) && (bl3 = Util.areEqual(object2 = this.customCacheKey, object3 = ((DownloadRequest)object).customCacheKey)) && (bl2 = Arrays.equals((byte[])(object2 = (Object)this.data), (byte[])(object = (Object)((DownloadRequest)object).data)))) {
            bl4 = true;
        }
        return bl4;
    }

    public final int hashCode() {
        String string2 = this.id;
        int n10 = string2.hashCode() * 31 * 31;
        int n11 = this.uri.hashCode();
        n10 = (n10 + n11) * 31;
        String string3 = this.mimeType;
        int n12 = 0;
        if (string3 != null) {
            n11 = string3.hashCode();
        } else {
            n11 = 0;
            string3 = null;
        }
        n10 = (n10 + n11) * 31;
        n11 = this.streamKeys.hashCode();
        n10 = (n10 + n11) * 31;
        n11 = Arrays.hashCode(this.keySetId);
        n10 = (n10 + n11) * 31;
        string3 = this.customCacheKey;
        if (string3 != null) {
            n12 = string3.hashCode();
        }
        n10 = (n10 + n12) * 31;
        n11 = Arrays.hashCode(this.data);
        return n10 + n11;
    }

    public MediaItem toMediaItem() {
        MediaItem$Builder mediaItem$Builder = new MediaItem$Builder();
        Object object = this.id;
        mediaItem$Builder = mediaItem$Builder.setMediaId((String)object);
        object = this.uri;
        mediaItem$Builder = mediaItem$Builder.setUri((Uri)object);
        object = this.customCacheKey;
        mediaItem$Builder = mediaItem$Builder.setCustomCacheKey((String)object);
        object = this.mimeType;
        mediaItem$Builder = mediaItem$Builder.setMimeType((String)object);
        object = this.streamKeys;
        mediaItem$Builder = mediaItem$Builder.setStreamKeys((List)object);
        object = this.keySetId;
        return mediaItem$Builder.setDrmKeySetId((byte[])object).build();
    }

    public String toString() {
        String string2 = this.mimeType;
        String string3 = this.id;
        int n10 = String.valueOf(string2).length() + 1;
        int n11 = String.valueOf(string3).length();
        StringBuilder stringBuilder = new StringBuilder(n10 += n11);
        stringBuilder.append(string2);
        stringBuilder.append(":");
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        List list;
        int n11;
        Object object = this.id;
        parcel.writeString((String)object);
        object = this.uri.toString();
        parcel.writeString((String)object);
        object = this.mimeType;
        parcel.writeString((String)object);
        n10 = this.streamKeys.size();
        parcel.writeInt(n10);
        n10 = 0;
        object = null;
        for (int i10 = 0; i10 < (n11 = (list = this.streamKeys).size()); ++i10) {
            list = (Parcelable)this.streamKeys.get(i10);
            parcel.writeParcelable((Parcelable)list, 0);
        }
        object = this.keySetId;
        parcel.writeByteArray((byte[])object);
        object = this.customCacheKey;
        parcel.writeString((String)object);
        object = this.data;
        parcel.writeByteArray((byte[])object);
    }
}

