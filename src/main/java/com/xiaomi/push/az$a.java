/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import java.io.FilterInputStream;
import java.io.InputStream;

public final class az$a
extends FilterInputStream {
    private boolean a;

    public az$a(InputStream inputStream) {
        super(inputStream);
    }

    public int read(byte[] byArray, int n10, int n11) {
        int n12;
        boolean bl2 = this.a;
        int n13 = -1;
        if (!bl2 && (n12 = super.read(byArray, n10, n11)) != n13) {
            return n12;
        }
        this.a = true;
        return n13;
    }
}

