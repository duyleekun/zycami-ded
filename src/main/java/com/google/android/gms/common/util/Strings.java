/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.google.android.gms.common.util;

import android.text.TextUtils;
import java.util.regex.Pattern;

public class Strings {
    private static final Pattern zza = Pattern.compile("\\$\\{(.*?)\\}");

    private Strings() {
    }

    public static String emptyToNull(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            string2 = null;
        }
        return string2;
    }

    public static boolean isEmptyOrWhitespace(String string2) {
        boolean bl2;
        return string2 == null || (bl2 = (string2 = string2.trim()).isEmpty());
        {
        }
    }
}

