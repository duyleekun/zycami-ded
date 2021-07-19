/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework;

import cn.sharesdk.framework.c$1;

public class c {
    private static volatile c b;
    private boolean a = false;

    private c() {
        c$1 c$1 = new c$1(this);
        c$1.start();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static c a() {
        Class<c> clazz = c.class;
        // MONITORENTER : clazz
        c c10 = b;
        if (c10 == null) {
            // MONITORENTER : clazz
            c10 = b;
            if (c10 == null) {
                b = c10 = new c();
            }
            // MONITOREXIT : clazz
        }
        // MONITOREXIT : clazz
        return b;
    }

    public static /* synthetic */ boolean a(c c10, boolean bl2) {
        c10.a = bl2;
        return bl2;
    }
}

