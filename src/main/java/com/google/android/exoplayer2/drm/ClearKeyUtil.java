/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import org.json.JSONException;
import org.json.JSONObject;

public final class ClearKeyUtil {
    private static final String TAG = "ClearKeyUtil";

    private ClearKeyUtil() {
    }

    public static byte[] adjustRequestData(byte[] byArray) {
        int n10 = Util.SDK_INT;
        int n11 = 27;
        if (n10 >= n11) {
            return byArray;
        }
        return Util.getUtf8Bytes(ClearKeyUtil.base64ToBase64Url(Util.fromUtf8Bytes(byArray)));
    }

    public static byte[] adjustResponseData(byte[] byArray) {
        int n10;
        int n11 = Util.SDK_INT;
        int n12 = 27;
        if (n11 >= n12) {
            return byArray;
        }
        CharSequence charSequence = Util.fromUtf8Bytes(byArray);
        Object object = new JSONObject((String)charSequence);
        String string2 = "{\"keys\":[";
        charSequence = new StringBuilder(string2);
        string2 = "keys";
        object = object.getJSONArray(string2);
        int n13 = 0;
        string2 = null;
        while (true) {
            String string3;
            block27: {
                n10 = object.length();
                if (n13 >= n10) break;
                if (n13 == 0) break block27;
                string3 = ",";
                ((StringBuilder)charSequence).append(string3);
            }
            string3 = object.getJSONObject(n13);
            String string4 = "{\"k\":\"";
            ((StringBuilder)charSequence).append(string4);
            string4 = "k";
            string4 = string3.getString(string4);
            string4 = ClearKeyUtil.base64UrlToBase64(string4);
            ((StringBuilder)charSequence).append(string4);
            string4 = "\",\"kid\":\"";
            ((StringBuilder)charSequence).append(string4);
            string4 = "kid";
            string4 = string3.getString(string4);
            string4 = ClearKeyUtil.base64UrlToBase64(string4);
            ((StringBuilder)charSequence).append(string4);
            string4 = "\",\"kty\":\"";
            ((StringBuilder)charSequence).append(string4);
            string4 = "kty";
            string3 = string3.getString(string4);
            ((StringBuilder)charSequence).append(string3);
            string3 = "\"}";
            ((StringBuilder)charSequence).append(string3);
            ++n13;
            continue;
            break;
        }
        object = "]}";
        try {
            ((StringBuilder)charSequence).append((String)object);
            object = ((StringBuilder)charSequence).toString();
        }
        catch (JSONException jSONException) {
            charSequence = "Failed to adjust response data: ";
            string2 = String.valueOf(Util.fromUtf8Bytes(byArray));
            n10 = string2.length();
            if (n10 != 0) {
                charSequence = ((String)charSequence).concat(string2);
            } else {
                string2 = new String((String)charSequence);
                charSequence = string2;
            }
            Log.e(TAG, (String)charSequence, jSONException);
            return byArray;
        }
        return Util.getUtf8Bytes((String)object);
    }

    private static String base64ToBase64Url(String string2) {
        return string2.replace('+', '-').replace('/', '_');
    }

    private static String base64UrlToBase64(String string2) {
        return string2.replace('-', '+').replace('_', '/');
    }
}

