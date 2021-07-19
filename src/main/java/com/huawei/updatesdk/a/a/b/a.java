/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.updatesdk.a.a.b;

import java.util.ArrayDeque;
import java.util.Queue;

public final class a {
    private static final a b;
    private final Queue a;

    static {
        a a10;
        b = a10 = new a();
    }

    private a() {
        ArrayDeque arrayDeque;
        this.a = arrayDeque = new ArrayDeque(0);
    }

    public static a b() {
        return b;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(byte[] object) {
        int n10 = ((byte[])object).length;
        int n11 = 65536;
        if (n10 != n11) return;
        Queue queue = this.a;
        synchronized (queue) {
            Object object2 = this.a;
            n11 = object2.size();
            int n12 = 32;
            if (n11 >= n12) return;
            object2 = this.a;
            boolean bl2 = object2.offer(object);
            if (bl2) return;
            object = "ByteArrayPool";
            object2 = "releaseBytes false";
            com.huawei.updatesdk.a.a.c.a.a.a.a((String)object, (String)object2);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public byte[] a() {
        Object object;
        Queue queue = this.a;
        synchronized (queue) {
            object = this.a;
            object = object.poll();
            object = (byte[])object;
        }
        if (object != null) return object;
        int n10 = 65536;
        return new byte[n10];
    }
}

