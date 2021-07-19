/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework.utils;

import cn.sharesdk.framework.utils.h$1;

public final class h$a
extends ThreadLocal {
    private h$a() {
    }

    public /* synthetic */ h$a(h$1 h$1) {
        this();
    }

    public char[] a() {
        return new char[1024];
    }

    public /* synthetic */ Object initialValue() {
        return this.a();
    }
}

