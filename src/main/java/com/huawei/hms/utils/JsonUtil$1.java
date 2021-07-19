/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.utils;

import java.lang.reflect.Field;
import java.security.PrivilegedAction;

public final class JsonUtil$1
implements PrivilegedAction {
    public final /* synthetic */ Field val$field;
    public final /* synthetic */ boolean val$flag;

    public JsonUtil$1(Field field, boolean bl2) {
        this.val$field = field;
        this.val$flag = bl2;
    }

    public Object run() {
        Field field = this.val$field;
        boolean bl2 = this.val$flag;
        field.setAccessible(bl2);
        return null;
    }
}

