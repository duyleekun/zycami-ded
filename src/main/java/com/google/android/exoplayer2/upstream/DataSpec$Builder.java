/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DataSpec$1;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Collections;
import java.util.Map;

public final class DataSpec$Builder {
    private Object customData;
    private int flags;
    private byte[] httpBody;
    private int httpMethod;
    private Map httpRequestHeaders;
    private String key;
    private long length;
    private long position;
    private Uri uri;
    private long uriPositionOffset;

    public DataSpec$Builder() {
        Map map;
        this.httpMethod = 1;
        this.httpRequestHeaders = map = Collections.emptyMap();
        this.length = -1;
    }

    private DataSpec$Builder(DataSpec object) {
        int n10;
        long l10;
        Object object2;
        this.uri = object2 = ((DataSpec)object).uri;
        this.uriPositionOffset = l10 = ((DataSpec)object).uriPositionOffset;
        this.httpMethod = n10 = ((DataSpec)object).httpMethod;
        object2 = ((DataSpec)object).httpBody;
        this.httpBody = (byte[])object2;
        object2 = ((DataSpec)object).httpRequestHeaders;
        this.httpRequestHeaders = object2;
        this.position = l10 = ((DataSpec)object).position;
        this.length = l10 = ((DataSpec)object).length;
        object2 = ((DataSpec)object).key;
        this.key = object2;
        this.flags = n10 = ((DataSpec)object).flags;
        this.customData = object = ((DataSpec)object).customData;
    }

    public /* synthetic */ DataSpec$Builder(DataSpec dataSpec, DataSpec$1 dataSpec$1) {
        this(dataSpec);
    }

    public DataSpec build() {
        Assertions.checkStateNotNull(this.uri, "The uri must be set.");
        Uri uri = this.uri;
        long l10 = this.uriPositionOffset;
        int n10 = this.httpMethod;
        byte[] byArray = this.httpBody;
        Map map = this.httpRequestHeaders;
        long l11 = this.position;
        long l12 = this.length;
        String string2 = this.key;
        int n11 = this.flags;
        Object object = this.customData;
        DataSpec dataSpec = new DataSpec(uri, l10, n10, byArray, map, l11, l12, string2, n11, object, null);
        return dataSpec;
    }

    public DataSpec$Builder setCustomData(Object object) {
        this.customData = object;
        return this;
    }

    public DataSpec$Builder setFlags(int n10) {
        this.flags = n10;
        return this;
    }

    public DataSpec$Builder setHttpBody(byte[] byArray) {
        this.httpBody = byArray;
        return this;
    }

    public DataSpec$Builder setHttpMethod(int n10) {
        this.httpMethod = n10;
        return this;
    }

    public DataSpec$Builder setHttpRequestHeaders(Map map) {
        this.httpRequestHeaders = map;
        return this;
    }

    public DataSpec$Builder setKey(String string2) {
        this.key = string2;
        return this;
    }

    public DataSpec$Builder setLength(long l10) {
        this.length = l10;
        return this;
    }

    public DataSpec$Builder setPosition(long l10) {
        this.position = l10;
        return this;
    }

    public DataSpec$Builder setUri(Uri uri) {
        this.uri = uri;
        return this;
    }

    public DataSpec$Builder setUri(String string2) {
        string2 = Uri.parse((String)string2);
        this.uri = string2;
        return this;
    }

    public DataSpec$Builder setUriPositionOffset(long l10) {
        this.uriPositionOffset = l10;
        return this;
    }
}

