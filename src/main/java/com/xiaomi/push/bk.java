/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.text.TextUtils;
import java.io.File;
import java.io.FilenameFilter;

public final class bk
implements FilenameFilter {
    public boolean accept(File object, String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        return !bl2 && !(bl2 = ((String)(object = string2.toLowerCase())).endsWith(string2 = ".lock"));
    }
}

