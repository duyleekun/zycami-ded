/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSpec$1;
import com.google.android.exoplayer2.upstream.DataSpec$Builder;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class DataSpec {
    public static final int FLAG_ALLOW_CACHE_FRAGMENTATION = 4;
    public static final int FLAG_ALLOW_GZIP = 1;
    public static final int FLAG_DONT_CACHE_IF_LENGTH_UNKNOWN = 2;
    public static final int FLAG_MIGHT_NOT_USE_FULL_NETWORK_SPEED = 8;
    public static final int HTTP_METHOD_GET = 1;
    public static final int HTTP_METHOD_HEAD = 3;
    public static final int HTTP_METHOD_POST = 2;
    public final long absoluteStreamPosition;
    public final Object customData;
    public final int flags;
    public final byte[] httpBody;
    public final int httpMethod;
    public final Map httpRequestHeaders;
    public final String key;
    public final long length;
    public final long position;
    public final Uri uri;
    public final long uriPositionOffset;

    public DataSpec(Uri uri) {
        this(uri, 0L, -1);
    }

    public DataSpec(Uri uri, int n10) {
        this(uri, 0L, -1, null, n10);
    }

    public DataSpec(Uri uri, int n10, byte[] byArray, long l10, long l11, long l12, String string2, int n11) {
        Map map = Collections.emptyMap();
        this(uri, n10, byArray, l10, l11, l12, string2, n11, map);
    }

    public DataSpec(Uri uri, int n10, byte[] byArray, long l10, long l11, long l12, String string2, int n11, Map map) {
        long l13 = l10 - l11;
        this(uri, l13, n10, byArray, map, l11, l12, string2, n11, null);
    }

    private DataSpec(Uri uri, long l10, int n10, byte[] byArray, Map map, long l11, long l12, String string2, int n11, Object object) {
        Object object2;
        long l13;
        DataSpec dataSpec = this;
        long l14 = l10;
        byte[] byArray2 = byArray;
        long l15 = l11;
        long l16 = l12;
        long l17 = l10 + l11;
        long l18 = 0L;
        long l19 = l17 == l18 ? 0 : (l17 < l18 ? -1 : 1);
        boolean bl2 = true;
        l19 = l19 >= 0 ? (long)bl2 : (long)0;
        Assertions.checkArgument((boolean)l19);
        l19 = l15 == l18 ? 0 : (l15 < l18 ? -1 : 1);
        l19 = l19 >= 0 ? (long)bl2 : (long)0;
        Assertions.checkArgument((boolean)l19);
        long l20 = l16 == l18 ? 0 : (l16 < l18 ? -1 : 1);
        if (l20 <= 0 && (l20 = (l13 = l16 - (l18 = (long)-1)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != false) {
            bl2 = false;
        }
        Assertions.checkArgument(bl2);
        dataSpec.uri = uri;
        dataSpec.uriPositionOffset = l14;
        int n12 = n10;
        dataSpec.httpMethod = n10;
        if (byArray2 == null || (n12 = byArray2.length) == 0) {
            n12 = 0;
            object2 = null;
            byArray2 = null;
        }
        dataSpec.httpBody = byArray2;
        object2 = new HashMap(map);
        object2 = Collections.unmodifiableMap(object2);
        dataSpec.httpRequestHeaders = object2;
        dataSpec.position = l15;
        dataSpec.absoluteStreamPosition = l17;
        dataSpec.length = l16;
        object2 = string2;
        dataSpec.key = string2;
        n12 = n11;
        dataSpec.flags = n11;
        object2 = object;
        dataSpec.customData = object;
    }

    public /* synthetic */ DataSpec(Uri uri, long l10, int n10, byte[] byArray, Map map, long l11, long l12, String string2, int n11, Object object, DataSpec$1 dataSpec$1) {
        this(uri, l10, n10, byArray, map, l11, l12, string2, n11, object);
    }

    public DataSpec(Uri uri, long l10, long l11) {
        Map map = Collections.emptyMap();
        this(uri, 0L, 1, null, map, l10, l11, null, 0, null);
    }

    public DataSpec(Uri uri, long l10, long l11, long l12, String string2, int n10) {
        this(uri, null, l10, l11, l12, string2, n10);
    }

    public DataSpec(Uri uri, long l10, long l11, String string2) {
        this(uri, l10, l10, l11, string2, 0);
    }

    public DataSpec(Uri uri, long l10, long l11, String string2, int n10) {
        this(uri, l10, l10, l11, string2, n10);
    }

    public DataSpec(Uri uri, long l10, long l11, String string2, int n10, Map map) {
        this(uri, 1, null, l10, l10, l11, string2, n10, map);
    }

    public DataSpec(Uri uri, byte[] byArray, long l10, long l11, long l12, String string2, int n10) {
        int n11 = byArray != null ? 2 : 1;
        this(uri, n11, byArray, l10, l11, l12, string2, n10);
    }

    public static String getStringForHttpMethod(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 == n11) {
                    return "HEAD";
                }
                IllegalStateException illegalStateException = new IllegalStateException();
                throw illegalStateException;
            }
            return "POST";
        }
        return "GET";
    }

    public DataSpec$Builder buildUpon() {
        DataSpec$Builder dataSpec$Builder = new DataSpec$Builder(this, null);
        return dataSpec$Builder;
    }

    public final String getHttpMethodString() {
        return DataSpec.getStringForHttpMethod(this.httpMethod);
    }

    public boolean isFlagSet(int n10) {
        int n11 = this.flags & n10;
        n10 = n11 == n10 ? 1 : 0;
        return n10 != 0;
    }

    public DataSpec subrange(long l10) {
        long l11 = this.length;
        long l12 = -1;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object != false) {
            l12 = l11 - l10;
        }
        return this.subrange(l10, l12);
    }

    public DataSpec subrange(long l10, long l11) {
        long l12;
        DataSpec dataSpec = this;
        long l13 = 0L;
        long l14 = l10 - l13;
        Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object == false && (object = (l12 = (l13 = this.length) - l11) == 0L ? 0 : (l12 < 0L ? -1 : 1)) == false) {
            return this;
        }
        Uri uri = dataSpec.uri;
        long l15 = dataSpec.uriPositionOffset;
        int n10 = dataSpec.httpMethod;
        byte[] byArray = dataSpec.httpBody;
        Map map = dataSpec.httpRequestHeaders;
        long l16 = dataSpec.position + l10;
        String string2 = dataSpec.key;
        int n11 = dataSpec.flags;
        Object object2 = dataSpec.customData;
        DataSpec dataSpec2 = new DataSpec(uri, l15, n10, byArray, map, l16, l11, string2, n11, object2);
        return dataSpec2;
    }

    public String toString() {
        String string2 = this.getHttpMethodString();
        String string3 = String.valueOf(this.uri);
        long l10 = this.position;
        long l11 = this.length;
        String string4 = this.key;
        int n10 = this.flags;
        int n11 = String.valueOf(string2).length() + 70;
        int n12 = String.valueOf(string3).length();
        n11 += n12;
        n12 = String.valueOf(string4).length();
        StringBuilder stringBuilder = new StringBuilder(n11 += n12);
        stringBuilder.append("DataSpec[");
        stringBuilder.append(string2);
        stringBuilder.append(" ");
        stringBuilder.append(string3);
        string2 = ", ";
        stringBuilder.append(string2);
        stringBuilder.append(l10);
        stringBuilder.append(string2);
        stringBuilder.append(l11);
        stringBuilder.append(string2);
        stringBuilder.append(string4);
        stringBuilder.append(string2);
        stringBuilder.append(n10);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public DataSpec withAdditionalHeaders(Map object) {
        Object object2 = this.httpRequestHeaders;
        HashMap hashMap = new HashMap(object2);
        hashMap.putAll(object);
        Uri uri = this.uri;
        long l10 = this.uriPositionOffset;
        int n10 = this.httpMethod;
        byte[] byArray = this.httpBody;
        long l11 = this.position;
        long l12 = this.length;
        String string2 = this.key;
        int n11 = this.flags;
        Object object3 = this.customData;
        object2 = object;
        object = new DataSpec(uri, l10, n10, byArray, hashMap, l11, l12, string2, n11, object3);
        return object;
    }

    public DataSpec withRequestHeaders(Map map) {
        Uri uri = this.uri;
        long l10 = this.uriPositionOffset;
        int n10 = this.httpMethod;
        byte[] byArray = this.httpBody;
        long l11 = this.position;
        long l12 = this.length;
        String string2 = this.key;
        int n11 = this.flags;
        Object object = this.customData;
        DataSpec dataSpec = new DataSpec(uri, l10, n10, byArray, map, l11, l12, string2, n11, object);
        return dataSpec;
    }

    public DataSpec withUri(Uri uri) {
        long l10 = this.uriPositionOffset;
        int n10 = this.httpMethod;
        byte[] byArray = this.httpBody;
        Map map = this.httpRequestHeaders;
        long l11 = this.position;
        long l12 = this.length;
        String string2 = this.key;
        int n11 = this.flags;
        Object object = this.customData;
        DataSpec dataSpec = new DataSpec(uri, l10, n10, byArray, map, l11, l12, string2, n11, object);
        return dataSpec;
    }
}

