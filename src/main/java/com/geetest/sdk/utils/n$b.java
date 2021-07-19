/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk.utils;

import com.geetest.sdk.utils.n;
import com.geetest.sdk.utils.n$b$a;
import g.c;
import g.m;
import g.z;
import g.z$a;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class n$b {
    private static z a;

    static {
        Object object = new z();
        object = ((z)object).c0();
        Object object2 = TimeUnit.SECONDS;
        object = ((z$a)object).k(10, (TimeUnit)((Object)object2));
        long l10 = 5;
        object = ((z$a)object).j0(l10, (TimeUnit)((Object)object2)).R0(l10, (TimeUnit)((Object)object2));
        object2 = n$b.b();
        object = ((z$a)object).g((c)object2);
        object2 = new n$b$a();
        a = ((z$a)object).o((m)object2).f();
    }

    public static /* synthetic */ z a() {
        return a;
    }

    private static c b() {
        Object object = n.f;
        String string2 = "netCache";
        File file = new File((String)object, string2);
        boolean bl2 = file.exists();
        if (!bl2) {
            file.mkdir();
        }
        long l10 = 0xA00000;
        object = new c(file, l10);
        return object;
    }
}

