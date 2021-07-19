/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.h;

import com.baidu.location.h.a;
import com.baidu.location.h.g;
import com.baidu.location.h.h;
import com.baidu.location.h.i;
import com.baidu.location.h.j;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public abstract class f {
    private static String a = "10.0.0.172";
    private static int b = 80;
    public static int g = com.baidu.location.h.a.g;
    public static int p;
    public String h = null;
    public int i = 1;
    public String j = null;
    public Map k = null;
    public String l = null;
    public byte[] m = null;
    public byte[] n = null;
    public String o = null;

    public void a(ExecutorService executorService) {
        g g10 = new g(this);
        try {
            executorService.execute(g10);
        }
        catch (Throwable throwable) {
            executorService = null;
            this.a(false);
        }
    }

    public void a(ExecutorService executorService, String string2) {
        j j10 = new j(this, string2);
        try {
            executorService.execute(j10);
        }
        catch (Throwable throwable) {
            executorService = null;
            this.a(false);
        }
    }

    public void a(ExecutorService executorService, boolean bl2, String string2) {
        h h10 = new h(this, string2, bl2);
        try {
            executorService.execute(h10);
        }
        catch (Throwable throwable) {
            executorService = null;
            this.a(false);
        }
    }

    public abstract void a(boolean var1);

    public abstract void b();

    public void e(String string2) {
        try {
            i i10 = new i(this, string2);
            i10.start();
        }
        catch (Throwable throwable) {
            string2 = null;
            this.a(false);
        }
    }
}

