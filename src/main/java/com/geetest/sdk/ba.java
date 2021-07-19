/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ba {
    public static String a(long l10) {
        Cloneable cloneable = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", (Locale)cloneable);
        cloneable = new Date(l10);
        return simpleDateFormat.format((Date)cloneable);
    }
}

