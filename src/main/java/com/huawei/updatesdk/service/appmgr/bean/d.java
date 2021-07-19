/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageInfo
 */
package com.huawei.updatesdk.service.appmgr.bean;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.huawei.updatesdk.a.a.d.h.b$b;
import com.huawei.updatesdk.b.b.a;
import com.huawei.updatesdk.b.b.c;
import com.huawei.updatesdk.b.c.b;
import com.huawei.updatesdk.service.appmgr.bean.Param;
import com.huawei.updatesdk.service.appmgr.bean.d$a;
import java.util.ArrayList;
import java.util.List;

public class d
extends c {
    public static final String APIMETHOD = "client.updateCheck";
    public static final int DEFAULT_UPGRADE_RESULT = 0;
    public static final int FULL_UPGRADE_RESULT = 1;
    public static final int INSTALL_CHECK_DEFAULT;
    private String agVersion_;
    private com.huawei.updatesdk.a.a.d.h.b deviceSpecParams_;
    private int getSafeGame_;
    private int gmsSupport_;
    private int hardwareType;
    private int installCheck_;
    private int isFullUpgrade_;
    private int isUpdateSdk;
    private String locale;
    private int mapleVer_;
    private String packageName_;
    private d$a pkgInfo_;
    private String serviceCountry_;
    private int serviceType = 0;
    private int supportMaple_;
    private int versionCode_;
    private String version_;

    public d() {
        int n10;
        boolean bl2 = true;
        this.isUpdateSdk = bl2;
        this.installCheck_ = 0;
        this.isFullUpgrade_ = 0;
        this.getSafeGame_ = bl2;
        this.supportMaple_ = 0;
        this.locale = null;
        Object object = com.huawei.updatesdk.a.b.a.a.c().a();
        this.a(APIMETHOD);
        this.b("1.2");
        Object object2 = com.huawei.updatesdk.a.a.d.h.c.h();
        this.locale = object2;
        object2 = com.huawei.updatesdk.a.a.d.h.c.h(object);
        this.g((String)object2);
        int n11 = com.huawei.updatesdk.a.a.d.h.c.g(object);
        this.f(n11);
        n11 = (int)(com.huawei.updatesdk.a.a.d.h.c.i(object) ? 1 : 0);
        this.a(n11);
        object2 = com.huawei.updatesdk.a.b.a.a.c().a().getPackageName();
        this.e((String)object2);
        object2 = a.d().a();
        this.f((String)object2);
        n11 = com.huawei.updatesdk.a.a.d.h.c.d().a();
        this.e(n11);
        n11 = com.huawei.updatesdk.a.a.d.h.c.d().b();
        this.c(n11);
        object2 = new b$b((Context)object);
        object = ((b$b)object2).a(bl2).a();
        this.deviceSpecParams_ = object;
        this.hardwareType = n10 = b.a().b();
    }

    public d(List list) {
        this();
        d$a d$a = new d$a();
        d$a.a(list);
        this.a(d$a);
    }

    public static d a(List object) {
        boolean bl2;
        d d10 = new d();
        d$a d$a = new d$a();
        d10.a(d$a);
        ArrayList<Param> arrayList = new ArrayList<Param>();
        d$a.a(arrayList);
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            d$a = (PackageInfo)object.next();
            Param param = new Param((PackageInfo)d$a);
            arrayList.add(param);
        }
        return d10;
    }

    public void a(int n10) {
        this.gmsSupport_ = n10;
    }

    public void a(d$a d$a) {
        this.pkgInfo_ = d$a;
    }

    public void b(int n10) {
        this.installCheck_ = n10;
    }

    public void c(int n10) {
        this.mapleVer_ = n10;
    }

    public void d(int n10) {
        this.serviceType = n10;
    }

    public void d(String string2) {
        this.agVersion_ = string2;
    }

    public void e(int n10) {
        this.supportMaple_ = n10;
    }

    public void e(String string2) {
        this.packageName_ = string2;
    }

    public void f(int n10) {
        this.versionCode_ = n10;
    }

    public void f(String string2) {
        this.serviceCountry_ = string2;
    }

    public void g(String string2) {
        this.version_ = string2;
    }
}

