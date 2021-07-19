/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.updatesdk.b.h;

import com.huawei.updatesdk.a.a.c.a.a.a;

public final class b$a
implements Thread.UncaughtExceptionHandler {
    public void uncaughtException(Thread object, Throwable throwable) {
        StringBuilder stringBuilder = new StringBuilder();
        object = ((Thread)object).getName();
        stringBuilder.append((String)object);
        stringBuilder.append(" : ");
        object = throwable.getMessage();
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        a.a("PackageUtils", (String)object);
    }
}

