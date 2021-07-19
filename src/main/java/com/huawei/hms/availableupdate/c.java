/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.availableupdate;

import com.huawei.hms.availableupdate.c$a;
import com.huawei.hms.availableupdate.c$b;
import com.huawei.hms.availableupdate.e;
import com.huawei.hms.availableupdate.f;
import com.huawei.hms.availableupdate.g;
import com.huawei.hms.utils.Checker;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class c
implements e {
    public static final Executor b = Executors.newSingleThreadExecutor();
    public final e a;

    public c(e e10) {
        Checker.checkNonNull(e10, "update must not be null.");
        this.a = e10;
    }

    public static /* synthetic */ e a(c c10) {
        return c10.a;
    }

    public static /* synthetic */ f a(f f10) {
        return c.b(f10);
    }

    public static f b(f f10) {
        c$a c$a = new c$a(f10);
        return c$a;
    }

    public void a() {
        this.a.a();
    }

    public void a(f f10, g g10) {
        Executor executor = b;
        c$b c$b = new c$b(this, f10, g10);
        executor.execute(c$b);
    }
}

