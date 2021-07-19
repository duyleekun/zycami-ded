/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.upstream.cache;

import android.net.Uri;

public interface ContentMetadata {
    public static final String KEY_CONTENT_LENGTH = "exo_len";
    public static final String KEY_CUSTOM_PREFIX = "custom_";
    public static final String KEY_REDIRECTED_URI = "exo_redir";

    public static long getContentLength(ContentMetadata contentMetadata) {
        return contentMetadata.get(KEY_CONTENT_LENGTH, -1);
    }

    public static Uri getRedirectedUri(ContentMetadata object) {
        String string2 = KEY_REDIRECTED_URI;
        Uri uri = null;
        if ((object = object.get(string2, (String)null)) != null) {
            uri = Uri.parse((String)object);
        }
        return uri;
    }

    public boolean contains(String var1);

    public long get(String var1, long var2);

    public String get(String var1, String var2);

    public byte[] get(String var1, byte[] var2);
}

