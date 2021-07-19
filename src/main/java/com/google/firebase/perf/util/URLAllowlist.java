/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 */
package com.google.firebase.perf.util;

import android.content.Context;
import android.content.res.Resources;
import com.google.firebase.perf.logging.AndroidLogger;
import java.net.URI;

public class URLAllowlist {
    private static String[] allowlistedDomains;

    public static boolean isURLAllowlisted(URI object, Context stringArray) {
        Resources resources = stringArray.getResources();
        stringArray = stringArray.getPackageName();
        String string2 = "firebase_performance_whitelisted_domains";
        String[] stringArray2 = "array";
        int n10 = resources.getIdentifier(string2, (String)stringArray2, (String)stringArray);
        boolean bl2 = true;
        if (n10 == 0) {
            return bl2;
        }
        stringArray2 = AndroidLogger.getInstance();
        String string3 = "Detected domain allowlist, only allowlisted domains will be measured.";
        stringArray2.info(string3);
        stringArray2 = allowlistedDomains;
        if (stringArray2 == null) {
            stringArray = resources.getStringArray(n10);
            allowlistedDomains = stringArray;
        }
        if ((object = ((URI)object).getHost()) == null) {
            return bl2;
        }
        stringArray = allowlistedDomains;
        int n11 = stringArray.length;
        stringArray2 = null;
        string3 = null;
        for (int i10 = 0; i10 < n11; ++i10) {
            String string4 = stringArray[i10];
            boolean bl3 = ((String)object).contains(string4);
            if (!bl3) continue;
            return bl2;
        }
        return false;
    }
}

