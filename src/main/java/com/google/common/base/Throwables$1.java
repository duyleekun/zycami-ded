/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Throwables;
import java.lang.reflect.Method;
import java.util.AbstractList;

public final class Throwables$1
extends AbstractList {
    public final /* synthetic */ Throwable val$t;

    public Throwables$1(Throwable throwable) {
        this.val$t = throwable;
    }

    public StackTraceElement get(int n10) {
        Method method = Throwables.access$000();
        Object object = Throwables.access$100();
        Object[] objectArray = new Object[2];
        Throwable throwable = this.val$t;
        objectArray[0] = throwable;
        Integer n11 = n10;
        objectArray[1] = n11;
        return (StackTraceElement)Throwables.access$200(method, object, objectArray);
    }

    public int size() {
        Method method = Throwables.access$300();
        Object object = Throwables.access$100();
        Object[] objectArray = new Object[1];
        Throwable throwable = this.val$t;
        objectArray[0] = throwable;
        return (Integer)Throwables.access$200(method, object, objectArray);
    }
}

