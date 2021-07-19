/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk.utils;

import com.geetest.sdk.utils.n;
import g.b0;
import g.v;
import java.io.OutputStream;

public final class n$a
extends b0 {
    public final /* synthetic */ byte[] a;

    public n$a(byte[] byArray) {
        this.a = byArray;
    }

    public v contentType() {
        return n.g;
    }

    public void writeTo(h.n closeable) {
        closeable = closeable.j0();
        byte[] byArray = this.a;
        ((OutputStream)closeable).write(byArray);
    }
}

