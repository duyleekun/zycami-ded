/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.basic.util;

import com.tencent.liteav.basic.util.a$a;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public class a {
    private final ThreadLocal a;
    private final a$a b;
    private WeakReference c;

    public a(a$a a$a) {
        WeakReference<Object> weakReference = new WeakReference<Object>();
        this.a = weakReference;
        this.c = weakReference = new WeakReference<Object>(null);
        this.b = a$a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Object b() {
        Object object = this.c.get();
        if (object != null) return object;
        synchronized (this) {
            WeakReference<Object> weakReference;
            object = this.c;
            object = ((Reference)object).get();
            if (object != null) return object;
            object = this.b;
            object = object.a();
            this.c = weakReference = new WeakReference<Object>(object);
            return object;
        }
    }

    public Object a() {
        Object object = this.a.get();
        if (object == null) {
            object = this.b();
            ThreadLocal threadLocal = this.a;
            threadLocal.set(object);
        }
        return object;
    }
}

