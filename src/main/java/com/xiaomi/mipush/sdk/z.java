/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.xiaomi.mipush.sdk;

import android.text.TextUtils;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class z {
    public int a;
    public String a = "";

    public boolean equals(Object object) {
        boolean bl2;
        if (object != null && (bl2 = object instanceof z)) {
            boolean bl3;
            object = (z)object;
            String string2 = ((z)object).a;
            bl2 = TextUtils.isEmpty((CharSequence)string2);
            if (!bl2 && (bl3 = ((String)(object = ((z)object).a)).equals(string2 = this.a))) {
                return true;
            }
        }
        return false;
    }
}

