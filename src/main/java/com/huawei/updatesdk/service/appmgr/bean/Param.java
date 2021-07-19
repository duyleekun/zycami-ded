/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.pm.PackageInfo
 *  android.content.pm.Signature
 *  android.text.TextUtils
 */
package com.huawei.updatesdk.service.appmgr.bean;

import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.huawei.updatesdk.a.a.d.a;
import com.huawei.updatesdk.a.a.d.g;
import com.huawei.updatesdk.b.h.b;
import java.util.List;
import java.util.Locale;

public class Param
extends com.huawei.updatesdk.a.b.c.c.b {
    private String fSha2_;
    private int isPre_;
    private List keySets_;
    private int maple_;
    private String oldVersion_;
    private String package_;
    private String sSha2_;
    private int targetSdkVersion_;
    private int versionCode_;

    public Param() {
    }

    public Param(PackageInfo object) {
        int n10;
        int n11;
        Object object2 = object.packageName;
        this.package_ = object2;
        this.versionCode_ = n11 = object.versionCode;
        object2 = object.versionName;
        if (object2 == null) {
            object2 = "null";
        }
        this.oldVersion_ = object2;
        this.targetSdkVersion_ = n11 = object.applicationInfo.targetSdkVersion;
        this.isPre_ = n11 = b.a(object);
        this.maple_ = n11 = b.a(this.package_);
        object2 = com.huawei.updatesdk.b.a.b.b.a().a((PackageInfo)object);
        this.keySets_ = object2;
        object2 = object.signatures;
        if (object2 != null && (n10 = ((Signature[])object2).length) > 0) {
            n10 = 0;
            object2 = object2[0].toCharsString();
            this.setApkSignature((String)object2);
        }
        object = com.huawei.updatesdk.b.a.a.b.a().a((PackageInfo)object);
        this.fSha2_ = object;
    }

    public void setApkFileSha256(String string2) {
        this.fSha2_ = string2;
    }

    public void setApkSignature(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)(string2 = g.b(a.a(g.c(string2)))));
        if (!bl2) {
            Locale locale = Locale.getDefault();
            this.sSha2_ = string2 = string2.toLowerCase(locale);
        }
    }

    public void setMapleState(int n10) {
        this.maple_ = n10;
    }

    public void setPackageName(String string2) {
        this.package_ = string2;
    }

    public void setTargetSdkVersion(int n10) {
        this.targetSdkVersion_ = n10;
    }

    public void setVersionCode(int n10) {
        this.versionCode_ = n10;
    }

    public void setVersionName(String string2) {
        this.oldVersion_ = string2;
    }
}

