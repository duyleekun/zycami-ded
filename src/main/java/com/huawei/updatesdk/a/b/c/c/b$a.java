/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.updatesdk.a.b.c.c;

import java.lang.reflect.Field;
import java.security.PrivilegedAction;

public class b$a
implements PrivilegedAction {
    private Field a;

    public b$a(Field field) {
        this.a = field;
    }

    public Object run() {
        this.a.setAccessible(true);
        return null;
    }
}

