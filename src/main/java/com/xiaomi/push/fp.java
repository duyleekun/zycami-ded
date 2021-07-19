/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.fl;
import java.nio.ByteBuffer;

public final class fp
extends fl {
    public fp() {
        this.a("PING", null);
        this.a("0");
        this.a(0);
    }

    public ByteBuffer a(ByteBuffer byteBuffer) {
        byte[] byArray = this.a();
        int n10 = byArray.length;
        if (n10 == 0) {
            return byteBuffer;
        }
        return super.a(byteBuffer);
    }

    public int c() {
        byte[] byArray = this.a();
        int n10 = byArray.length;
        if (n10 == 0) {
            return 0;
        }
        return super.c();
    }
}

