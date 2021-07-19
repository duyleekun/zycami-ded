/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.huawei.updatesdk.service.appmgr.bean;

import android.text.TextUtils;
import com.huawei.updatesdk.a.b.c.c.b;

public class c
extends b {
    private String appName;
    private String downUrl;
    private long fileSize;
    private String pkgName;
    private String sha256;
    private long versionCode;
    private String versionName;

    public String a() {
        return this.appName;
    }

    public String b() {
        return this.downUrl;
    }

    public long c() {
        return this.fileSize;
    }

    public String d() {
        return this.pkgName;
    }

    public String e() {
        return this.sha256;
    }

    public boolean f() {
        long l10;
        long l11;
        long l12;
        String string2 = this.sha256;
        int n10 = TextUtils.isEmpty((CharSequence)string2);
        if (n10 == 0 && (n10 = TextUtils.isEmpty((CharSequence)(string2 = this.downUrl))) == 0 && (n10 = (l12 = (l11 = this.fileSize) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        return n10 != 0;
    }
}

