/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 */
package com.huawei.updatesdk.b.b;

import android.os.Build;
import com.huawei.updatesdk.a.b.a.a;
import com.huawei.updatesdk.b.c.b;

public class c
extends com.huawei.updatesdk.a.b.c.c.c {
    private String buildNumber;
    private String density;
    private int emuiApiLevel = 0;
    private String firmwareVersion;
    private String manufacturer;
    private String phoneType;
    private String resolution;
    private long ts;

    public c() {
        int n10;
        String string2;
        long l10;
        Object object = a.c().a();
        this.ts = l10 = System.currentTimeMillis();
        Object object2 = Build.VERSION.RELEASE.trim();
        this.firmwareVersion = object2;
        object2 = com.huawei.updatesdk.a.a.d.h.c.c();
        this.buildNumber = object2;
        object2 = b.a();
        this.phoneType = string2 = ((com.huawei.updatesdk.b.c.c)object2).f();
        this.density = string2 = com.huawei.updatesdk.a.a.d.h.c.f(object);
        object = com.huawei.updatesdk.a.a.d.h.c.e(object);
        this.resolution = object;
        this.emuiApiLevel = n10 = com.huawei.updatesdk.b.h.a.d().a();
        object = ((com.huawei.updatesdk.b.c.c)object2).e();
        this.manufacturer = object;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.getClass().getName();
        stringBuilder.append(string2);
        stringBuilder.append(" {\n\tmethod_: ");
        string2 = this.b();
        stringBuilder.append(string2);
        stringBuilder.append("\n}");
        return stringBuilder.toString();
    }
}

