/*
 * Decompiled with CFR 0.151.
 */
package com.mob.commons.b;

import com.mob.tools.MobLog;

public class c {
    private static final c a;

    static {
        c c10;
        a = c10 = new c();
    }

    private c() {
    }

    public static c a() {
        return a;
    }

    /*
     * Unable to fully structure code
     */
    private void b(Object var1_1) {
        var2_2 = var1_1 instanceof Throwable;
        if (!var2_2) ** GOTO lbl13
        try {
            var3_3 = MobLog.getInstance();
        }
        catch (Throwable v0) {
            ** continue;
        }
        var1_1 = (Throwable)var1_1;
        var3_3.d((Throwable)var1_1);
        ** GOTO lbl20
lbl13:
        // 1 sources

        var3_4 = MobLog.getInstance();
        var4_5 = null;
        var4_5 = new Object[]{};
        var3_4.d(var1_1, var4_5);
lbl20:
        // 3 sources

    }

    public void a(Object object) {
        this.b(object);
    }
}

