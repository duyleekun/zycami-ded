/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.network.a.a;

import com.tencent.liteav.network.a.a.a;
import com.tencent.liteav.network.a.a.c;
import com.tencent.liteav.network.a.b;
import com.tencent.liteav.network.a.d;
import com.tencent.liteav.network.a.e;
import java.io.IOException;
import java.net.InetAddress;

public final class a$1
implements com.tencent.liteav.network.a.c {
    public e[] a(b object, d d10) {
        Object object2 = a.b();
        if (object2 == null) {
            object2 = a.a();
        }
        if (object2 != null) {
            object2 = object2[0];
            c c10 = new c((InetAddress)object2);
            return c10.a((b)object, d10);
        }
        object = new IOException("cant get local dns server");
        throw object;
    }
}

