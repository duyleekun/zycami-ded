/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.text.TextUtils;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class gx$a {
    public int a;
    public long a;
    public String a;
    public int b;
    public long b;
    public String b;

    public gx$a(String string2, long l10, int n10, int n11, String string3, long l11) {
        int n12;
        long l12;
        String string4;
        this.a = string4 = "";
        this.a = l12 = 0L;
        this.a = n12 = -1;
        this.b = n12;
        this.b = string4;
        this.b = l12;
        this.a = string2;
        this.a = l10;
        this.a = n10;
        this.b = n11;
        this.b = string3;
        this.b = l11;
    }

    public boolean a(gx$a gx$a) {
        int n10;
        String string2 = gx$a.a;
        String string3 = this.a;
        int n11 = TextUtils.equals((CharSequence)string2, (CharSequence)string3);
        if (n11 != 0 && (n11 = TextUtils.equals((CharSequence)(string2 = gx$a.b), (CharSequence)(string3 = this.b))) != 0 && (n11 = gx$a.a) == (n10 = this.a) && (n11 = gx$a.b) == (n10 = this.b)) {
            long l10 = gx$a.a;
            long l11 = this.a;
            long l12 = (l10 = Math.abs(l10 - l11)) - (l11 = 5000L);
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object <= 0) {
                return true;
            }
        }
        return false;
    }
}

