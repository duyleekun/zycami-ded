/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.kwai.opensdk.sdk.utils;

import android.net.Uri;

public class UriUtil {
    private static String getSchemeOrNull(Uri object) {
        object = object == null ? null : object.getScheme();
        return object;
    }

    public static boolean isUriString(Uri object) {
        boolean bl2;
        String string2 = "content";
        boolean bl3 = string2.equals(object = UriUtil.getSchemeOrNull(object));
        if (!bl3 && !(bl2 = (string2 = "file").equals(object))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }
}

