/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.framework.common;

import java.lang.reflect.Field;
import java.security.PrivilegedAction;

public final class ReflectionUtils$1
implements PrivilegedAction {
    public final /* synthetic */ Field val$field;

    public ReflectionUtils$1(Field field) {
        this.val$field = field;
    }

    public Object run() {
        this.val$field.setAccessible(true);
        return null;
    }
}

