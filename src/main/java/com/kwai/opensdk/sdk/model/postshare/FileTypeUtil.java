/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.kwai.opensdk.sdk.model.postshare;

import android.text.TextUtils;
import java.net.URLConnection;

public class FileTypeUtil {
    private static String getMimeType(String string2) {
        return URLConnection.getFileNameMap().getContentTypeFor(string2);
    }

    public static boolean isImageFile(String string2) {
        String string3;
        boolean bl2;
        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
        return !bl3 && !(bl3 = TextUtils.isEmpty((CharSequence)(string2 = FileTypeUtil.getMimeType(string2)))) && (bl2 = string2.contains(string3 = "image/"));
    }

    public static boolean isVideoFile(String string2) {
        String string3;
        boolean bl2;
        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
        return !bl3 && !(bl3 = TextUtils.isEmpty((CharSequence)(string2 = FileTypeUtil.getMimeType(string2)))) && (bl2 = string2.contains(string3 = "video/"));
    }
}

