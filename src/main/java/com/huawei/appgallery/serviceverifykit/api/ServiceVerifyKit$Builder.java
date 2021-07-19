/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.text.TextUtils
 */
package com.huawei.appgallery.serviceverifykit.api;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.appgallery.serviceverifykit.api.ServiceVerifyKit;
import com.huawei.appgallery.serviceverifykit.api.ServiceVerifyKit$Builder$ComponentType;
import d.j.b.a.b.d.b;
import java.util.HashMap;
import java.util.Map;

public class ServiceVerifyKit$Builder {
    private String a;
    private String b = "AppGallery Verification";
    private String c = "Huawei CBG Cloud Security Signer";
    private String d = "com.huawei.appgallery.fingerprint_signature";
    private String e = "com.huawei.appgallery.sign_certchain";
    private Map f;
    private Map g;
    private Context h;
    private int i;
    private int j;
    private Intent k;
    private ServiceVerifyKit$Builder$ComponentType l;
    private String m;
    private String n;

    public ServiceVerifyKit$Builder() {
        HashMap hashMap;
        this.f = hashMap = new HashMap();
        this.g = hashMap = new HashMap();
        this.j = 0;
        this.m = "verify_match_property";
    }

    public ServiceVerifyKit$Builder a(String string2, String object) {
        object = ServiceVerifyKit.q((String[])this.f.get(string2), (String)object);
        this.f.put(string2, object);
        object = this.g;
        Integer n10 = this.j;
        object.put(string2, n10);
        return this;
    }

    public ServiceVerifyKit$Builder b(String string2, String object, int n10) {
        object = ServiceVerifyKit.q((String[])this.f.get(string2), (String)object);
        this.f.put(string2, object);
        object = this.g;
        Integer n11 = n10;
        object.put(string2, n11);
        return this;
    }

    public ServiceVerifyKit$Builder c(String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            object = d.j.b.a.b.d.b.b;
            String string2 = "ServiceVerifyKit";
            String string3 = "error input propertyName";
            ((b)object).a(string2, string3);
        } else {
            this.n = object;
        }
        return this;
    }

    public String d() {
        ServiceVerifyKit serviceVerifyKit = new ServiceVerifyKit(null);
        Object object = this.h;
        ServiceVerifyKit.c(serviceVerifyKit, object);
        object = this.b;
        ServiceVerifyKit.y(serviceVerifyKit, (String)object);
        object = this.c;
        ServiceVerifyKit.z(serviceVerifyKit, (String)object);
        object = this.a;
        ServiceVerifyKit.A(serviceVerifyKit, (String)object);
        object = ServiceVerifyKit.t(serviceVerifyKit);
        Map map = this.f;
        object.putAll(map);
        object = ServiceVerifyKit.x(serviceVerifyKit);
        map = this.g;
        object.putAll(map);
        int n10 = this.i;
        ServiceVerifyKit.b(serviceVerifyKit, n10);
        object = this.m;
        ServiceVerifyKit.B(serviceVerifyKit, (String)object);
        object = this.n;
        ServiceVerifyKit.j(serviceVerifyKit, (String)object);
        object = this.k;
        ServiceVerifyKit.d(serviceVerifyKit, (Intent)object);
        object = this.l;
        ServiceVerifyKit.f(serviceVerifyKit, (ServiceVerifyKit$Builder$ComponentType)((Object)object));
        object = this.e;
        ServiceVerifyKit.r(serviceVerifyKit, (String)object);
        object = this.d;
        ServiceVerifyKit.v(serviceVerifyKit, (String)object);
        return ServiceVerifyKit.i(serviceVerifyKit);
    }

    public ServiceVerifyKit$Builder e(String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            object = d.j.b.a.b.d.b.b;
            String string2 = "ServiceVerifyKit";
            String string3 = "error input CN";
            ((b)object).a(string2, string3);
        } else {
            this.b = object;
        }
        return this;
    }

    public ServiceVerifyKit$Builder f(String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            object = d.j.b.a.b.d.b.b;
            String string2 = "ServiceVerifyKit";
            String string3 = "error input chain key";
            ((b)object).a(string2, string3);
        } else {
            this.e = object;
        }
        return this;
    }

    public ServiceVerifyKit$Builder g(String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            object = d.j.b.a.b.d.b.b;
            String string2 = "ServiceVerifyKit";
            String string3 = "error input signer key";
            ((b)object).a(string2, string3);
        } else {
            this.d = object;
        }
        return this;
    }

    public ServiceVerifyKit$Builder h(Context context) {
        this.h = context = context.getApplicationContext();
        return this;
    }

    public ServiceVerifyKit$Builder i(int n10) {
        this.i = n10;
        return this;
    }

    public ServiceVerifyKit$Builder j(String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            object = d.j.b.a.b.d.b.b;
            String string2 = "ServiceVerifyKit";
            String string3 = "error input propertyKey";
            ((b)object).a(string2, string3);
        } else {
            this.m = object;
        }
        return this;
    }

    public ServiceVerifyKit$Builder k(String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            object = d.j.b.a.b.d.b.b;
            String string2 = "ServiceVerifyKit";
            String string3 = "error input OU";
            ((b)object).a(string2, string3);
        } else {
            this.c = object;
        }
        return this;
    }

    public ServiceVerifyKit$Builder l(String string2) {
        this.a = string2;
        return this;
    }

    public ServiceVerifyKit$Builder m(Intent object, ServiceVerifyKit$Builder$ComponentType object2) {
        String string2 = "ServiceVerifyKit";
        if (object == null) {
            object = d.j.b.a.b.d.b.b;
            String string3 = "error input intent";
            ((b)object).a(string2, string3);
        } else {
            this.k = object;
        }
        if (object2 == null) {
            object = d.j.b.a.b.d.b.b;
            object2 = "error input type";
            ((b)object).a(string2, (String)object2);
        } else {
            this.l = object2;
        }
        return this;
    }
}

