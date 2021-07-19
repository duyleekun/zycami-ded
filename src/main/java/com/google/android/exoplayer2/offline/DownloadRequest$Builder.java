/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.offline;

import android.net.Uri;
import com.google.android.exoplayer2.offline.DownloadRequest;
import com.google.common.collect.ImmutableList;
import java.util.List;

public class DownloadRequest$Builder {
    private String customCacheKey;
    private byte[] data;
    private final String id;
    private byte[] keySetId;
    private String mimeType;
    private List streamKeys;
    private final Uri uri;

    public DownloadRequest$Builder(String string2, Uri uri) {
        this.id = string2;
        this.uri = uri;
    }

    public DownloadRequest build() {
        DownloadRequest downloadRequest;
        String string2 = this.id;
        Uri uri = this.uri;
        String string3 = this.mimeType;
        Object object = this.streamKeys;
        if (object == null) {
            object = ImmutableList.of();
        }
        List list = object;
        byte[] byArray = this.keySetId;
        String string4 = this.customCacheKey;
        byte[] byArray2 = this.data;
        object = downloadRequest;
        downloadRequest = new DownloadRequest(string2, uri, string3, list, byArray, string4, byArray2, null);
        return downloadRequest;
    }

    public DownloadRequest$Builder setCustomCacheKey(String string2) {
        this.customCacheKey = string2;
        return this;
    }

    public DownloadRequest$Builder setData(byte[] byArray) {
        this.data = byArray;
        return this;
    }

    public DownloadRequest$Builder setKeySetId(byte[] byArray) {
        this.keySetId = byArray;
        return this;
    }

    public DownloadRequest$Builder setMimeType(String string2) {
        this.mimeType = string2;
        return this;
    }

    public DownloadRequest$Builder setStreamKeys(List list) {
        this.streamKeys = list;
        return this;
    }
}

