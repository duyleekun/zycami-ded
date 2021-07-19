/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.util;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class HttpUtils {
    private static final Pattern zza = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
    private static final Pattern zzb = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
    private static final Pattern zzc = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");

    private HttpUtils() {
    }

    public static Map parse(URI object, String string2) {
        int n10;
        HashMap<String, String> hashMap = Collections.emptyMap();
        if ((object = object.getRawQuery()) != null && (n10 = object.length()) > 0) {
            boolean bl2;
            hashMap = new HashMap<String, String>();
            Scanner scanner = new Scanner((String)object);
            object = "&";
            scanner.useDelimiter((String)object);
            while (bl2 = scanner.hasNext()) {
                int n11;
                object = scanner.next();
                String string3 = "=";
                int n12 = ((String[])(object = object.split(string3))).length;
                if (n12 != 0 && (n12 = ((String[])object).length) <= (n11 = 2)) {
                    n12 = 0;
                    string3 = HttpUtils.zza(object[0], string2);
                    String string4 = null;
                    int n13 = ((String[])object).length;
                    if (n13 == n11) {
                        n11 = 1;
                        object = object[n11];
                        string4 = HttpUtils.zza((String)object, string2);
                    }
                    hashMap.put(string3, string4);
                    continue;
                }
                object = new IllegalArgumentException("bad parameter");
                throw object;
            }
        }
        return hashMap;
    }

    private static String zza(String string2, String object) {
        if (object == null) {
            object = "ISO-8859-1";
        }
        try {
            return URLDecoder.decode(string2, (String)object);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            object = new IllegalArgumentException(unsupportedEncodingException);
            throw object;
        }
    }
}

