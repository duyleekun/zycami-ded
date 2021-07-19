/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.google.android.gms.common.util;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class zzd {
    private static final Pattern zza = Pattern.compile("\\\\u[0-9a-fA-F]{4}");

    public static String zza(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            int n10;
            Matcher matcher = zza.matcher(string2);
            StringBuffer stringBuffer = null;
            while ((n10 = matcher.find()) != 0) {
                if (stringBuffer == null) {
                    stringBuffer = new StringBuffer();
                }
                Object object = matcher.group().substring(2);
                int n11 = 16;
                n10 = Integer.parseInt((String)object, n11);
                object = Character.toChars(n10);
                String string3 = new String((char[])object);
                matcher.appendReplacement(stringBuffer, string3);
            }
            if (stringBuffer == null) {
                return string2;
            }
            matcher.appendTail(stringBuffer);
            string2 = stringBuffer.toString();
        }
        return string2;
    }
}

